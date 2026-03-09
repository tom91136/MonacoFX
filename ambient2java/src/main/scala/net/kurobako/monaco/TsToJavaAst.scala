package net.kurobako.monaco

import java.util.Optional
import javax.annotation.Nonnull
import javax.annotation.Nullable
import scala.annotation.tailrec

import better.files.File
import cats.Traverse
import cats.data.Validated
import cats.syntax.all.*
import com.vladsch.flexmark.html.HtmlRenderer
import com.vladsch.flexmark.parser.Parser
import mouse.all.*
import net.kurobako.monaco.Ast.Name
import net.kurobako.monaco.Ast.Sym
import net.kurobako.monaco.JavaAst.*
import net.kurobako.monaco.JavaAst.DelegationBody
import net.kurobako.monaco.JavaAst.DelegationBody.Call
import net.kurobako.monaco.JavaAst.DelegationBody.GetMember
import net.kurobako.monaco.JavaAst.DelegationBody.SetMember
import net.kurobako.monaco.JavaAst.JEnum.JEnumEntry
import net.kurobako.monaco.JavaAst.JEnum.JIntEnum
import net.kurobako.monaco.JavaAst.JType.*
import net.kurobako.monaco.JavaAst.JTypeTree.*
import net.kurobako.monaco.JavaAst.JTypeTree.Foreign.Lit
import net.kurobako.monaco.TsAst.*
import net.kurobako.monaco.TsAst.*
import net.kurobako.monaco.TsAst.TsName.*
import net.kurobako.monaco.TsAst.TsType.*

object TsToJavaAst {

  val MdRenderer: HtmlRenderer = HtmlRenderer.builder().build
  val MdParser: Parser         = Parser.builder().build

  val JsShimPkg: String = "net.kurobako.monacofx.js"
  val JsContext: Name   = Name.cls(JsShimPkg, "JsContext")
  val JsUndef: Name     = Name.cls(JsShimPkg, "JsUndefined")
  val JsProxy: Name     = Name.cls(JsShimPkg, "JsProxy")
  val JsPromise: Name   = Name.cls(JsShimPkg, "JsPromise")
  val JsEnum: Name      = Name.cls(JsShimPkg, "JsEnum")

  val JOptional: Name = Name.cls[Optional[?]]
  val JNullable: Name = Name.cls[Nullable]
  val JNonnull: Name  = Name.cls[Nonnull]

  def JsTuple(n: Int): Name = Name.cls(JsShimPkg, s"JsTuple${n.ensuring(_ > 1)}")
  def JsUnion(n: Int): Name = Name.cls(JsShimPkg, s"JsUnion${n.ensuring(_ > 1)}")

  val JsContextCtors = List(
    JCtor(
      (Sym.unsafe("context")    -> JTypeContext(JavaRef(JsContext))) ::
        (Sym.unsafe("receiver") -> JTypeContext(JavaRef(Name.cls[Object]))) :: Nil,
      DelegationBody.Raw("super(context, receiver);" :: Nil)
    ),
    JCtor(
      (Sym.unsafe("context") -> JTypeContext(JavaRef(JsContext))) :: Nil,
      DelegationBody.Raw("super(context);" :: Nil)
    )
  )

  type TpeLookup  = Map[Int, Either[TsType[TsName], Name]]
  type NameLookup = Map[Name, Set[Sym]]

  def alternatives[A](xs: List[JTypeTree[A]]): ParseM[Nel[Nel[JTypeContext[A]]]] = for {
    tpes  <- xs.toNel.otherwise("No alternatives")
    names <- tpes.traverse {
      case Alt(xs) => xs.pureF
      case illegal => failF(s"$illegal should not appear at this level")
    }
  } yield names

  type Partial = JTypeTree[Name]

  def flattenChoices[A](xs: List[JTypeTree[A]]): ParseM[Alt[A]] =
    alternatives(xs).map(x => Alt(x.flatten.distinctUniversal))

  def tsUnionOrIntersectionToJava(tpes: List[TsType[TsName]], lut: TpeLookup): ParseM[Partial] = {
    // crush (null | undefined) here

    def matchLits[A](xs: List[Partial])(f: PartialFunction[Foreign, Lit[A]]): Option[Nel[A]] =
      xs.foldLeftM(Vector[A]()) {
        case (ys, NoRep(foreign)) => f.lift(foreign).map(ys :+ _.value)
        case (ys, Alt(x))
            // FIXME that single "any" type is actually a reflectivekind of function from LineNumbersType
            if x.size == 1 && x.head.value == JavaObject => ys.some
        case _ => none
      }.flatMap(Nel.fromFoldable(_))

    def liftInner(xs: List[TsType[TsName]], nullable: Boolean): ParseM[Partial] = for {
      xs <- xs.traverse(tsToJava(_, lut))
      potentialEnums = matchLits(xs) { case l @ Lit.StrLit(_) => l }.map(StrEnum(_, nullable)).orElse(
        matchLits(xs) { case l @ Lit.IntLit(_) => l }.map(IntEnum(_, nullable))
      )
      ys <- potentialEnums.cata(
        _.pureF,
        flattenChoices(xs).map(_.modify(_.copy(nullable = nullable))).elaborate(s"Union $tpes")
      )
    } yield ys

    tpes.partitionMap {
      case TsTerminal(x @ TsNull)  => x.asLeft
      case TsTerminal(x @ TsUndef) => x.asLeft
      case t                       => t.asRight
    } match {
      case (Nil, Nil) => failF("Empty union")
      case (Nil, xs)  => liftInner(xs, nullable = false)
      case (_, Nil)   => Remove.pureF
      case (_, xs)    => liftInner(xs, nullable = true)
    }
  }

  def tsGenericToJava(tpe: TsType[TsName], bounds: List[TsType[TsName]], lut: TpeLookup): ParseM[Partial] =

    // <A|B, C|D> = <A,C> | <A,D> | <B,C> | <B,D>
    // nullable types is not representable but preserved in type parameters

    tpe match {
      case TsTerminal(TsAny)                                                         => Alt(JavaObject).pureF
      case TsTerminal(TsRef(n @ Sym("Readonly" | "NonNullable" | "Required"), None)) =>
        bounds match {
          case x :: Nil => tsToJava(x, lut)
          case xs       => failF(s"BuiltIn type ${n.value} is unary, got $xs")
        }
      case _ =>

        tpe match {
          case TsUnion(tpes) => tsUnionOrIntersectionToJava(tpes, lut)
          case _             =>
            for {
              root  <- tsToJava(tpe, lut)
              root_ <- root match {
                case Alt(JTypeContext(name, nullable) Nel Nil) => name.pureF
                case bad => failF(s"Incompatible at type constructor: $bad for ${pprint.apply(tpe)}")
              }
              bound_ <- bounds.toNel.otherwise("Less than one bound")
              leaves <- bound_.traverse(tsToJava(_, lut)).flatMap(_.flatTraverse {
                case Alt(xs) => xs.map(_.value).pureF
                case x       => failF(s"No alt $x")
              })

              a = leaves match {
                case x Nel Nil => x
                case xs        => JavaGeneric(JavaRef(JsUnion(xs.size)), xs)
              }

            } yield Alt(JavaGeneric(root_, Nel.one(a)))

        }

    }

  @tailrec def tsArrayToJava(t: TsType[TsName], lut: TpeLookup, n: Int = 1): ParseM[Alt[Name]] = t match {
    case TsArray(repr) => tsArrayToJava(repr, lut, n + 1)
    case tpe           => tsToJava(tpe, lut) match {
        case Left(e)  => e.asLeft
        case Right(t) => flattenChoices(t :: Nil)
            .map(_.modify(i => i.copy(JavaList(i.value, n))))
            .elaborate(s"Flatten failed at array for $t")
      }
  }

  def tsToJava(tpe: TsType[TsName], lut: TpeLookup): ParseM[Partial] = tpe match {
    // representable classes
    case TsTerminal(TsString)                  => Alt(JavaString).pureF
    case TsTerminal(TsObject | TsAny)          => Alt(JavaObject).pureF
    case TsTerminal(TsBool | TsTrue | TsFalse) => Alt(JavaBoolean).pureF // XXX maybe introduce bool literals as enums?
    case TsTerminal(TsNum)                     => Alt(JavaDouble).pureF
    case TsTerminal(TsVoid)                    => Alt(JavaVoid).pureF
    case TsGuard(_)                            => Alt(JavaBoolean).pureF

    // types not representable in Java without extra classes
    case TsTerminal(TsNull)             => NoRep(Foreign.Null).pureF
    case TsTerminal(TsUndef)            => NoRep(Foreign.Undefined).pureF
    case TsTerminal(TsStringLiteral(x)) => NoRep(Lit.StrLit(x)).pureF
    case TsTerminal(TsIntLiteral(x))    => NoRep(Lit.IntLit(x)).pureF

    // references
    case TsTerminal(ref @ TsRef(name, id)) => id match {
        case Some(x) =>
          lut.get(x).otherwise(s"Need $x").flatMap {
            case Left(next)  => tsToJava(next, lut)
            case Right(name) => Alt(JavaRef(name)).asRight
          }
        case None =>
          name match {
            case Sym("Object")                  => Alt(JavaObject).pureF
            case Sym("RegExp")                  => Alt(JavaString).pureF
            case Sym("Int32Array")              => Alt(JavaList(JavaInt, 1)).pureF
            case Sym("Uint32Array")             => Alt(JavaList(JavaLong, 1)).pureF
            case Sym("Float32Array")            => Alt(JavaList(JavaFloat, 1)).pureF
            case Sym("Float64Array")            => Alt(JavaList(JavaDouble, 1)).pureF
            case Sym("Promise" | "PromiseLike") => Alt(JavaRef(JsPromise)).pureF

            case _ =>
              println(s"NOT FOUND: ${ref}")

              //						Alt(JavaRef(Name(name))).passF
              Alt(JavaObject).pureF

          }
      }

    case TsTerminal(TsTypeVar(name)) => Alt(JavaTypeVar(name)).pureF // FIXME should have a dedicated TypeVar things
    case TsArray(repr)               =>
      @tailrec def resolve(t: TsType[TsName], n: Int = 1): ParseM[Alt[Name]] = t match {
        case TsArray(repr) => resolve(repr, n + 1)
        case tpe           => tsToJava(tpe, lut) match {
            case Left(e)  => e.asLeft
            case Right(t) => flattenChoices(t :: Nil)
                .map(_.modify(i => i.copy(JavaList(i.value, n))))
                .elaborate(s"Flatten failed at array for $repr")
          }
      }
      resolve(repr)

    case TsTuple(components) =>
      for {
        tpes  <- components.traverse(tsToJava(_, lut))
        names <- tpes.traverse {
          case Alt(x Nel Nil)                => x.pureF
          case Alt(x Nel y :: z :: a :: Nil) => x.pureF // FIXME

          case xs => failF(s"No alternatives allowed in tuple component $xs")
        }
        xs <- Nel.fromList(names).otherwise("Less than one component for tuple")
        nullable = xs.exists(_.nullable)
        tpes     = xs.map(_.value)
      } yield Alt(
        JavaUnion(if (nullable) JavaVoid :: tpes else tpes)
        //				JavaGeneric(JavaRef(JsTuple(xs.length)), xs.map(c => emitOptional(c.name, optional = c.nullable)))
      )

    //			Alt("(tuple)").passF
    case TsTypeOf(eqiv)       => tsToJava(eqiv, lut)
    case TsIntersection(tpes) => tsUnionOrIntersectionToJava(tpes, lut)
    case TsUnion(tpes)        => tsUnionOrIntersectionToJava(tpes, lut)
    case TsGeneric(TsTerminal(TsRef(Sym("ReadonlyArray" | "Array"), None)), xs) =>
      (xs match {
        case x :: Nil => x.pureF
        case bad      => failF(s"More than one component for array ${bad}")
      }).flatMap(tsArrayToJava(_, lut))

    //		case TsGeneric(TsGeneric(x, xs), ys) =>
    //			def allTpeVars(xs: List[TsType[TsName]]) = xs.forall {
    //				case TsTerminal(TsTypeVar(_)) => true
    //				case _                        => false
    //			}
    //			(allTpeVars(xs), allTpeVars(ys)) match {
    //				case (false, true)  => tsGenericToJava(x, xs, lut)
    //				case (true, false)  => tsGenericToJava(x, ys, lut)
    //				case (false, false) => failF("No vars")
    //				case (true, true)   => failF("All Vars")
    //			}
    case TsGeneric(x, xs)     => tsGenericToJava(x, xs, lut)
    case TsStructural(fields) => Alt(JavaLiteral("???")).pureF
  }

  def emitPath(name: Name): String = name.fragments.mkString_("", "/", ".java")

  def emitError(n: String, e: Any) = s"Unable to emit $n: $e"

  def emitDoc(doc: Doc, paramDocs: List[(String, Comment)] = Nil): List[String] = {
    def emitMd(src: String): String = MdRenderer.render(MdParser.parse(src))
    val docs                        = emitMd(doc.lines.mkString("\n")).linesIterator.map(" * " + _).toList
    val params                      = paramDocs match {
      case Nil => Nil
      case xs  => " * " :: xs.map { case (name, comment) =>
          val text = comment.text.map(emitMd(_)).getOrElse("").stripSuffix("\n").stripPrefix("\n")
          // remove excessive <p></p> if they exist
          val reformatted =
            if (
              text.linesIterator.size == 1 &&
              text.startsWith("<p>") &&
              text.endsWith("</p>")
            ) text.stripPrefix("<p>").stripSuffix("</p>")
            else text
          s" * @param $name $reformatted"
        }
    }

    val srcPos    = doc.srcPosition.map(x => s" * " + s"See {@code ${x.fileName}:${x.line}:${x.character}}<br>")
    val originals = " * Original signature:<br>" ::
      doc.srcLine.map(ln =>
        s" * {@code ${
            ln.strip
              .replace("{", "").replace("}", "")
              .replace("```ts", "{ @code").replace("```", "}")
          } }<br>"
      )

    "/**" :: (docs ::: srcPos ::: originals ::: params) ::: " */" :: Nil
  }

  case class Callable(doc: Doc, rtnTpe: String, params: List[(Sym, String)])

  def emitOutTpe(xs: Nel[JTypeContext[Name]], nullable: Boolean): JTypeContext[Name] = {
    val anyNullable = nullable || xs.exists(_.nullable)
    xs match {
      case Nel(x, Nil) => x
      case xs          => JTypeContext(JavaUnion(xs.map(_.value)), anyNullable)
    }
  }

  def emitTpeBpunds(tpeParams: List[(Sym, Option[Nel[JTypeContext[Name]]])])
      : ParseM[List[(Sym, Option[JTypeContext[Name]])]] =
    tpeParams.traverse { case (s, b) =>
      b.traverse {
        case Nel(x, Nil) => x.pureF
        case xs          => failF(s"Bounds with alternatives: $xs")
      }.map(s -> _)
    }

  def emitCallable(
      sigs: List[TsSignature[Partial]],
      name: Sym,
      parentDoc: Doc,
      static: Boolean,
      reservedNames: Set[Sym]
  ): ParseM[List[JMethod[Name]]] =
    sigs.distinct.flatTraverse[ParseM, (List[JType[Name]], JMethod[Name])] {
      case TsSignature(_, ps, NoRep(Foreign.Null | Foreign.Undefined), _)
          if ps.forall(_.tpe == Remove) => Nil.pureF
      case sig => for {
          noAlt <- sig.traverse {
            case Alt(xs) => xs.pureF
            case xs      => failF(s"Cannot have $xs here($sig)")
          }
          tpeParams <- emitTpeBpunds(noAlt.tpeParams)

          paramDocs = noAlt.params.flatMap(x => x.comment.map(x.name.value -> _))
          doc       = emitDoc(parentDoc |+| noAlt.doc, paramDocs)

          // doc refer to the original non-overloaded
          overloadedDoc = emitDoc(parentDoc |+| noAlt.doc |+|
            Doc(
              "\n<strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong>\n" :: Nil
            ))

          rtn = emitOutTpe(noAlt.returnTpe, nullable = false)

        } yield {

          def mkMethod(params: List[(TsParameter[Nel[JTypeContext[Name]]], JTypeContext[Name])], doc: DocLns) = {
            val ps      = params.map { case (param, tpe) => (param.name, JTypeContext(tpe.value, tpe.nullable)) }
            val newName = if (reservedNames.contains(name)) name ++ "_" else name
            params.map(_._2).map(_.value) -> JMethod(newName, tpeParams, ps, rtn, Call(name, ps, rtn), doc, static)
          }

          (Nel.fromList(noAlt.params) match {
            case None     => mkMethod(Nil, doc) :: Nil
            case Some(ps) => crossJoin(ps.toList.map(param => param.tpe.toList.map(param -> _))).flatMap { permuted =>
                mkMethod(permuted, doc) ::         // base version
                  List.unfold(permuted.toVector) { // and then all overloads with each optional params not present
                    case ys :+ ((p, _)) if p.optional => (mkMethod(ys.toList, overloadedDoc), ys).some
                    case _                            => none
                  }
              }
          }).distinctBy(_._1) // eliminate all with the same parameter types
        }
    }.map { methods =>
      // find all methods that have the same overload signature and see if we can eliminate some with equivalent return type
      // this is safe in JS as overloads doesn't exist so all calls are actually to the same function
      methods.groupMap(_._1)(_._2).toList.flatMap { case (_, ms) =>
        val (optional, required) = ms.partitionMap(m =>
          m.rtn match {
            //					case JavaGeneric(JavaRef(OptionalName), x Nel Nil) => (m -> x).asLeft
            case JTypeContext(x, true)  => (m -> x).asLeft
            case JTypeContext(x, false) => (m -> x).asRight
          }
        )
        if (optional.map(_._2) == required.map(_._2)) optional.map(_._1)
        else ms
      }
    }

  def emitFunction(fn: TsFunction[Partial]): CheckM[List[JMethod[Name]]] =
    emitCallable(fn.signatures, fn.name.sym, fn.doc, static = true, Set()).elaborate(emitError(
      "function",
      fn
    )).toValidatedNel

  def emitMethod(m: TsMethod[Partial], reservedNames: Set[Sym]): CheckM[List[JMethod[Name]]] =
    emitCallable(m.signatures, m.name, m.doc, m.static, reservedNames).elaborate(emitError("method", m)).toValidatedNel

  def emitPropertyLike(
      name: Sym,
      tpe: Partial,
      optional: Boolean,
      get: Boolean,
      set: Boolean,
      doc: Doc,
      enclosing: JType[Name]
  ): CheckM[List[JMethod[Name]]] = {

    def mkGetter(tpe: JTypeContext[Name]) =
      JMethod(name, Nil, Nil, tpe, GetMember(name, tpe), emitDoc(doc)) :: Nil

    def mkSetter(tpes: List[JTypeContext[Name]]) = tpes.map { tpe =>
      val param = Sym.unsafe("value")
      JMethod(name, Nil, (param -> tpe) :: Nil, JTypeContext(enclosing), SetMember(name, param, tpe), emitDoc(doc))
    }

    tpe match {
      case Alt(Nel(JTypeContext(JavaVoid, _), Nil)) => Nil.pureF
      case Alt(xs)                                  =>

        // in-type as two options:
        //  * if more than 1 type is generic, use tuple thanks to erasure
        // *

        val genericCount = xs.map(_.value).count {
          case JavaTypeVar(_)
              | JavaList(_, _)
              | JavaUnion(_)
              | JavaIntersection(_)
              | JavaGeneric(_, _) => true
          case _ => false
        }

        val os = if (genericCount > 1) emitOutTpe(xs, optional) :: Nil else xs.toList

        ((get ?? mkGetter(emitOutTpe(xs, optional))) ++
          (set ?? mkSetter(os))).pureF
      case StrEnum(xs, nullable)    => Nil.pureF // FIXME
      case IntEnum(xs, nullable)    => Nil.pureF // FIXME
      case NoRep(Foreign.Undefined) => Nil.pureF // FIXME
      case xs                       => failF(s"more than one type($xs) for $name")
    }
  }.elaborate(emitError("propertylike", s"$name : $tpe")).toValidatedNel

  def emitEnum(e: TsEnum[Partial]): JIntEnum[Name] =
    JIntEnum(e.name, e.members.map(m => JEnumEntry(m.symbol, m.ordinal, emitDoc(m.doc))), emitDoc(e.doc))

  def emitClassLike(cls: ClassLike[Partial], lut: TpeLookup, nameLut: NameLookup): CheckM[
    (JType[Name], Set[Sym], (List[JCtor[Name]], List[JMethod[Name]]) => JClass[Name])
  ] = (for {
    // TODO get type bounds of parents to see if we pass current ones up
    parents <- cls.parents.traverse { p =>
      lut.get(p).otherwise(s"Missing parent $p")
        .flatMap(_.leftMap(e => fail(s"Unexpected type reference $e")))
    }

    inheritedNames <- parents.traverse(n => nameLut.get(n).otherwise(s"Missing name $n")).map(_.combineAll)

    clsTpe = cls.typeParams.toNel match {
      case None     => JavaRef(cls.name)
      case Some(xs) => JavaGeneric(JavaRef(cls.name), xs.map { case (x, _) => JavaTypeVar(x) })
    }

    noAlt <- cls.typeParams.traverse(_.traverse(_.traverse {
      case Alt(xs) => xs.pureF
      case xs      => failF(s"Cannot have $xs for tpe param(${cls.typeParams})")
    }))

    tpeParams <- emitTpeBpunds(noAlt)
  } yield (
    clsTpe,
    inheritedNames,
    (moreCtors: List[JCtor[Name]], moreMethods: List[JMethod[Name]]) =>
      JClass[Name](cls.name, tpeParams, JsProxy +: parents, JsContextCtors ++ moreCtors, moreMethods, emitDoc(cls.doc))
  )).toValidatedNel

  def emitProperty(p: TsProperty[Partial], enclosing: JType[Name]): CheckM[List[JMethod[Name]]] =
    emitPropertyLike(p.name, p.tpe, p.optional, get = true, set = !p.readonly, p.doc, enclosing)

  def emitClass(cls: TsClass[Partial], tpeLut: TpeLookup, nameLut: NameLookup): CheckM[JClass[Name]] =
    emitClassLike(cls, tpeLut, nameLut).andThen { case (clsTpe, inheritedNames, mkCls) =>
      val properties = cls.properties.flatTraverse(emitProperty(_, clsTpe))
      val accessors  = cls.accessors.flatTraverse { x =>
        val (get, set) = x.kind match {
          case TsAccessorKind.TsGetter          => (true, false)
          case TsAccessorKind.TsSetter          => (false, true)
          case TsAccessorKind.TsGetterAndSetter => (true, true)
        }
        emitPropertyLike(x.name, x.tpe, optional = false, get = get, set = set, x.doc, clsTpe)
      }
      val methods = cls.methods.filterNot(_.inherited).flatTraverse(emitMethod(_, inheritedNames))
      (properties |+| accessors |+| methods).map(mkCls(Nil, _))
    }.elaborate(emitError("class", cls.name))

  def emitInterface(iface: TsInterface[Partial], tpeLut: TpeLookup, nameLut: NameLookup): CheckM[JClass[Name]] =
    emitClassLike(iface, tpeLut, nameLut).andThen { case (clsTpe, inheritedNames, mkCls) =>
      val properties = iface.properties.flatTraverse(emitProperty(_, clsTpe))
      val methods    = iface.methods.filterNot(_.inherited).flatTraverse(emitMethod(_, inheritedNames))
      (properties |+| methods).map(mkCls(Nil, _))
    }.elaborate(emitError("interface", iface.name))

  def emitModule(m: TsModule[Partial]): CheckM[JClass[Name]] = {
    def moduleName(n: Name) = n.mapLast(x => Sym.unsafe(x.value.capitalize ++ "Module"))

    val name = moduleName(m.name)
    (
      m.modules.flatTraverse(m =>
        emitPropertyLike(
          m.name.sym,
          Alt(JavaRef(moduleName(m.name))),
          optional = false,
          get = true,
          set = false,
          doc = m.doc,
          JavaRef(name)
        )
      ) |+|
        m.variables.flatTraverse(v =>
          emitPropertyLike(v.name.sym, v.tpe, optional = false, get = true, set = !v.const, v.doc, JavaRef(name))
        ) |+|
        m.functions.flatTraverse(emitFunction(_))
    )
      .map(JClass(name, Nil, JsProxy :: Nil, JsContextCtors, _, emitDoc(m.doc)))
  }

  def resolveAliasChain(x: TsType[TsName], aliases: Map[Int, TsType[TsName]]): TsType[TsName] = {
    def resolve(tpe: TsType[TsName]) = tpe.flatMap {
      case ref @ TsRef(_, id) => id.flatMap(aliases.get(_)) match {
          case Some(next) => resolveAliasChain(next, aliases)
          case None       => TsTerminal(ref)
        }
      case y => TsTerminal(y)
    }
    x match {
      // special case where Alias<Applied> needs to propagate the first parameter to the rest
      // TODO this should be doable to arbitrary amounts of type variables, doing only one for now
      case gen @ TsGeneric(tpe, x :: Nil) =>
        val fullyAppliedTypeCtor = x match {
          case TsTerminal(TsTypeVar(_)) => false
          case _                        => true
        }
        val resolved = resolve(gen)
        if (fullyAppliedTypeCtor) {
          tpe match {
            case TsTerminal(TsRef(_, _)) => // type ctor root is an alias
              resolved.toList.collect { case TsTypeVar(name) => name }.distinct match {
                case _ :: Nil =>
                  resolved.flatMap {
                    case TsTypeVar(_) => resolve(x)
                    case x            => TsTerminal(x)
                  }
                case _ => resolved // more than one free type variable, can't handle, give up
              }
            case _ => resolved // not an alias, use as-is
          }
        } else resolved
      case x => resolve(x)
    }
  }

  def safeGroup[A, B](x: List[(A, B)]): ParseM[Map[A, B]] =
    x.groupMap(_._1)(_._2).collect {
      case (i, x :: Nil) => (i -> x).pureF
      case (i, xs)       => failF(s"$i has multiple references: $xs")
    }.toList.sequence.map(_.toMap)

  def main(args: Array[String]): Unit = {
    import scala.collection.parallel.CollectionConverters._

    val a = for {
      tsTypedGlobal <- time("Read TS AST")(TypeDocParser(File("a.json"), File("monaco.d.ts")))
      aliases = time("Isolate alias") {
        tsTypedGlobal.modules.flatMap(_.aliases).map(a =>
          a.id -> (a.tpe match {
            case TsGeneric(tpe, _) => tpe // TODO don't expand alias type parameters, probably wrong in cases
            case x                 => x
          })
        ).toMap
      }
      _ = summon[Traverse[TsGlobal]]

      tsAliasResolvedGlobal = time("Resolve alias")(tsTypedGlobal.map(resolveAliasChain(_, aliases)))
      tpeLut <- time("Create Type LUT") {
        safeGroup(tsAliasResolvedGlobal.modules.flatMap { m =>
          m.variables.map(x => x.id -> x.tpe.asLeft) ++
            (m.classes ++
              m.aliases ++
              m.enums ++
              m.interfaces).map(x => x.id -> x.name.asRight)
        })
      }

      nameLut <- time("Create Name LUT") {
        safeGroup(tsAliasResolvedGlobal.modules.flatMap { m =>
          m.classes.map(c =>
            c.name -> (c.methods.map(_.name) ++
              c.properties.map(_.name) ++
              c.accessors.map(_.name)).toSet
          ) ++
            m.interfaces.map(i =>
              i.name -> (i.methods.map(_.name) ++
                i.properties.map(_.name)).toSet
            )
        })
      }

      global <- time("Transform Type")(tsAliasResolvedGlobal.traverse(tsToJava(_, tpeLut)))
      classes = time("Transform AST") {
        global.modules.flatMap { m =>
          (() => emitModule(m)) ::
            m.classes.map(c => () => emitClass(c, tpeLut, nameLut)) ++
            m.interfaces.map(i => () => emitInterface(i, tpeLut, nameLut)) ++
            m.enums.map(e => () => emitEnum(e).validNel)
        }.par.map(_()).toList.sequence
      }

      tupleShims = (2 to 4).toList.traverse(JsTupleGen(JsShimPkg, "JsTuple", _)).toValidatedNel
      unionShims = (2 to 4).toList.traverse(JsUnionGen(JsShimPkg, "JsUnion", _)).toValidatedNel

      sources = classes.map { xs =>
        val enums = xs.collect {
          case JEnum.JIntEnum(name, _, _) => name
          case JEnum.JStrEnum(name, _, _) => name
        }.map(_.self).toSet
        time("Emit source")(xs.par.map(fmtTopLevelSource(_, enums)).toList)
      }

    } yield tupleShims |+| unionShims |+| sources
    a.dump match {
      case Validated.Invalid(es) =>

        es.toList.foreach(e => println(e.getMessage))

      case Validated.Valid(xs) =>

        val base = File("/home/tom/MonacoFX/monacofx/src/main/java/")

        xs.foreach { case (f, c) =>

          //					pprint.pprintln(tl)

          (base / f).createFileIfNotExists(createParents = true).overwrite(c)

        }

      //				println(xs)
    }

  }

}
