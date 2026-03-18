package net.kurobako.monaco

import better.files.File
import cats.Traverse
import cats.data.Validated
import cats.syntax.all.*
import com.vladsch.flexmark.html.HtmlRenderer
import com.vladsch.flexmark.parser.Parser
import mouse.all.*
import net.kurobako.monaco.Ast.{Name, Sym}
import net.kurobako.monaco.JavaAst.*
import net.kurobako.monaco.JavaAst.DelegationBody.{Call, GetMember, SetMember}
import net.kurobako.monaco.JavaAst.JEnum.{JEnumEntry, JIntEnum}
import net.kurobako.monaco.JavaAst.JType.*
import net.kurobako.monaco.JavaAst.JTypeTree.*
import net.kurobako.monaco.JavaAst.JTypeTree.Foreign.Lit
import net.kurobako.monaco.TsAst.*
import net.kurobako.monaco.TsAst.TsName.*
import net.kurobako.monaco.TsAst.TsType.*
import upickle.default as upickleDefault

import java.util.Optional
import javax.annotation.{Nonnull, Nullable}
import scala.annotation.tailrec

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

  val MaxOverrideArity         = 4
  def JsFunction(n: Int): Name = Name.cls(JsShimPkg, s"JsFunction$n")

  def emitOverrideMethods(
      methods: List[JMethod[Name]],
      enclosingTpe: JType[Name],
      inheritedNames: Set[(Sym, List[JType[Name]], JType[Name])] = Set.empty
  ): List[JMethod[Name]] = {
    // Predict which override* names the parent classes would generate, to avoid erasure clashes.
    val inheritedOverrideNames = inheritedNames
      .filter { case (_, params, _) => params.size <= MaxOverrideArity }
      .map { case (name, _, _) => "override" + name.value.capitalize }
    methods.collect {
      case JMethod(mname, _, params, rtn, DelegationBody.Call(jsName, _, _), _, false)
          if params.size <= MaxOverrideArity =>
        val arity  = params.size
        val jfName = JsFunction(arity)
        // XXX complex types (unions, generics, lists) fall back to Object --value goes straight to JS
        val rtnType: JType[Name] = rtn.value match {
          case _: JavaRef[?] => rtn.value
          case _: JPrimitive => rtn.value
          case JavaString    => rtn.value
          case _             => JavaObject
        }
        val typeArgs = Nel.fromListUnsafe(params.map(_._2.value) :+ rtnType)
        val jfType   = JavaGeneric(JavaRef(jfName), typeArgs)
        JMethod(
          name = Sym.unsafe("override" + mname.value.capitalize),
          tpeParams = Nil,
          params = List(Sym.unsafe("value") -> JTypeContext(jfType)),
          rtn = JTypeContext(enclosingTpe),
          code = DelegationBody.Override(jsName, arity, params.map(_._2.value)),
          doc = List("/**", s" * Overrides {@link #${mname.value}}.", " */"),
          static = false
        )
    }
      // XXX JsFunctionN<...> erases to JsFunctionN at runtime --deduplicate by (name, arity)
      .distinctBy(m => (m.name.value, m.code match { case DelegationBody.Override(_, a, _) => a; case _ => -1 }))
      .filterNot(m => inheritedOverrideNames.contains(m.name.value))
  }

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
  type NameLookup = Map[Name, Set[(Sym, List[JType[Name]], JType[Name])]]

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

    def matchLits[A](xs: List[Partial])(f: PartialFunction[Foreign, Lit[A]]): Option[Nel[A]] =
      xs.foldLeftM(Vector[A]()) {
        case (ys, NoRep(foreign)) => f.lift(foreign).map(ys :+ _.value)
        case (ys, Alt(x))
            // XXX FIXME single "any" type is actually a reflective function from LineNumbersType
            if x.size == 1 && x.head.value == JavaObject => ys.some
        case _ => none
      }.flatMap(Nel.fromFoldable(_))

    def liftInner(xs: List[TsType[TsName]], nullable: Boolean): ParseM[Partial] = for {
      xs <- xs.traverse(tsToJava(_, lut))
      potentialEnums = matchLits(xs) { case l @ Lit.StrLit(_) => l }.map(StrEnum(_, nullable)).orElse(
        matchLits(xs) { case l @ Lit.IntLit(_) => l }.map(IntEnum(_, nullable))
      )
      ys <- potentialEnums.cata(
        _.pureF, {
          val alts    = xs.collect { case a @ Alt(_) => a }
          val choices = if (alts.isEmpty) List(Alt(JavaObject)) else alts
          flattenChoices(choices).map(_.modify(_.copy(nullable = nullable))).elaborate(s"Union $tpes")
        }
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

  private def tsGenericToJava(tpe: TsType[TsName], bounds: List[TsType[TsName]], lut: TpeLookup): ParseM[Partial] =
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
    case TsTerminal(TsString)                  => Alt(JavaString).pureF
    case TsTerminal(TsObject | TsAny)          => Alt(JavaObject).pureF
    case TsTerminal(TsBool | TsTrue | TsFalse) => Alt(JavaBoolean).pureF
    case TsTerminal(TsNum)                     => Alt(JavaDouble).pureF
    case TsTerminal(TsVoid)                    => Alt(JavaVoid).pureF
    case TsGuard(_)                            => Alt(JavaBoolean).pureF

    case TsTerminal(TsNull)             => NoRep(Foreign.Null).pureF
    case TsTerminal(TsUndef)            => NoRep(Foreign.Undefined).pureF
    case TsTerminal(TsStringLiteral(x)) => NoRep(Lit.StrLit(x)).pureF
    case TsTerminal(TsIntLiteral(x))    => NoRep(Lit.IntLit(x)).pureF

    case TsTerminal(ref @ TsRef(name, id)) =>
      val fromLut: Option[ParseM[Partial]] = id.flatMap(lut.get).map {
        case Left(next)   => tsToJava(next, lut)
        case Right(jname) => Alt(JavaRef(jname)).asRight
      }
      fromLut.getOrElse {
        name match {
          case Sym("Object")                               => Alt(JavaObject).pureF
          case Sym("RegExp")                               => Alt(JavaString).pureF
          case Sym("Int32Array")                           => Alt(JavaList(JavaInt, 1)).pureF
          case Sym("Uint32Array")                          => Alt(JavaList(JavaLong, 1)).pureF
          case Sym("Float32Array")                         => Alt(JavaList(JavaFloat, 1)).pureF
          case Sym("Float64Array")                         => Alt(JavaList(JavaDouble, 1)).pureF
          case Sym("Promise" | "PromiseLike" | "Thenable") => Alt(JavaRef(JsPromise)).pureF

          case _ =>
            println(s"NOT FOUND: ${ref}")
            Alt(JavaObject).pureF
        }
      }

    case TsTerminal(TsTypeVar(_)) => Alt(JavaObject).pureF
    case TsArray(repr)            =>
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
      } yield Alt(JavaUnion(if (nullable) JavaVoid :: tpes else tpes))

    case TsTypeOf(eqiv)       => tsToJava(eqiv, lut)
    case TsIntersection(tpes) => tsUnionOrIntersectionToJava(tpes, lut)
    case TsUnion(tpes)        => tsUnionOrIntersectionToJava(tpes, lut)
    case TsGeneric(TsTerminal(TsRef(Sym("ReadonlyArray" | "Array"), None)), xs) =>
      (xs match {
        case x :: Nil => x.pureF
        case bad      => failF(s"More than one component for array ${bad}")
      }).flatMap(tsArrayToJava(_, lut))

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
          val text        = comment.text.map(emitMd(_)).getOrElse("").stripSuffix("\n").stripPrefix("\n")
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
      reservedNames: Set[(Sym, List[JType[Name]], JType[Name])]
  ): ParseM[List[JMethod[Name]]] =
    sigs.distinct.flatTraverse[ParseM, (List[JType[Name]], JMethod[Name])] {
      case TsSignature(_, ps, NoRep(Foreign.Null | Foreign.Undefined), _)
          if ps.forall(p => p.tpe == Remove || p.tpe == NoRep(Foreign.Null) || p.tpe == NoRep(Foreign.Undefined)) =>
        Nil.pureF
      case sig => for {
          noAlt <- sig.traverse {
            case Alt(xs)              => xs.pureF
            case StrEnum(_, nullable) => Nel.one(JTypeContext(JavaString, nullable)).pureF
            case IntEnum(_, nullable) => Nel.one(JTypeContext(JavaInt, nullable)).pureF
            case xs                   => failF(s"Cannot have $xs here($sig)")
          }
          tpeParams <- emitTpeBpunds(noAlt.tpeParams)

          paramDocs     = noAlt.params.flatMap(x => x.comment.map(x.name.value -> _))
          doc           = emitDoc(parentDoc |+| noAlt.doc, paramDocs)
          overloadedDoc = emitDoc(parentDoc |+| noAlt.doc |+|
            Doc(
              "\n<strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong>\n" :: Nil
            ))

          rtn = emitOutTpe(noAlt.returnTpe, nullable = false)

        } yield {

          def mkMethod(params: List[(TsParameter[Nel[JTypeContext[Name]]], JTypeContext[Name])], doc: DocLns) = {
            val ps           = params.map { case (param, tpe) => (param.name, JTypeContext(tpe.value, tpe.nullable)) }
            val myParamTypes = ps.map(_._2.value)
            val myReturnType = rtn.value
            // XXX only rename when parent has same (name, params) with DIFFERENT return type
            val conflictsWithParent = reservedNames.exists { case (rname, rparams, rrtn) =>
              rname == name && rparams == myParamTypes && rrtn != myReturnType
            }
            val newName = if (conflictsWithParent) name ++ "_" else name
            myParamTypes -> JMethod(newName, tpeParams, ps, rtn, Call(name, ps, rtn), doc, static)
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
      val deduped = methods.groupMap(_._1)(_._2).toList.flatMap { case (_, ms) =>
        val (optional, required) = ms.partitionMap(m =>
          m.rtn match {
            case JTypeContext(x, true)  => (m -> x).asLeft
            case JTypeContext(x, false) => (m -> x).asRight
          }
        )
        if (optional.map(_._2) == required.map(_._2)) optional.map(_._1)
        else ms
      }
      // XXX Java erasure: List<String> and List<LanguageFilter> have the same erasure
      def erase(t: JType[Name]): JType[Name] = t match {
        case JavaList(_, dim)     => JavaList(JavaObject, dim)
        case JavaGeneric(name, _) => erase(name)
        case other                => other
      }
      deduped
        .groupBy(m => (m.name, m.params.map(_._2.value).map(erase)))
        .values.toList.flatMap(_.headOption)
    }

  def emitFunction(fn: TsFunction[Partial]): CheckM[List[JMethod[Name]]] =
    emitCallable(fn.signatures, fn.name.sym, fn.doc, static = true, Set()).elaborate(emitError(
      "function",
      fn
    )).toValidatedNel

  def emitMethod(
      m: TsMethod[Partial],
      reservedNames: Set[(Sym, List[JType[Name]], JType[Name])]
  ): CheckM[List[JMethod[Name]]] =
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
    val jName = Sym.unsafe(name.value.replace('.', '_'))

    def mkGetter(tpe: JTypeContext[Name]) =
      JMethod(jName, Nil, Nil, tpe, GetMember(name, tpe), emitDoc(doc)) :: Nil

    def mkSetter(tpes: List[JTypeContext[Name]]) = tpes.map { tpe =>
      val param = Sym.unsafe("value")
      JMethod(jName, Nil, (param -> tpe) :: Nil, JTypeContext(enclosing), SetMember(name, param, tpe), emitDoc(doc))
    }

    tpe match {
      case Alt(Nel(JTypeContext(JavaVoid, _), Nil)) => Nil.pureF
      case Alt(xs)                                  =>
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
      case StrEnum(_, nullable) =>
        val tpe = JTypeContext(JavaString, nullable)
        ((get ?? mkGetter(tpe)) ++ (set ?? mkSetter(tpe :: Nil))).pureF
      case IntEnum(_, nullable) =>
        val tpe = JTypeContext(JavaInt, nullable)
        ((get ?? mkGetter(tpe)) ++ (set ?? mkSetter(tpe :: Nil))).pureF
      case NoRep(Foreign.Undefined | Foreign.Null) => Nil.pureF
      case NoRep(Foreign.Lit.StrLit(_))            =>
        val tpe = JTypeContext(JavaString, false)
        ((get ?? mkGetter(tpe)) ++ (set ?? mkSetter(tpe :: Nil))).pureF
      case NoRep(Foreign.Lit.IntLit(_)) =>
        val tpe = JTypeContext(JavaInt, false)
        ((get ?? mkGetter(tpe)) ++ (set ?? mkSetter(tpe :: Nil))).pureF
      case xs => failF(s"more than one type($xs) for $name")
    }
  }.elaborate(emitError("propertylike", s"$name : $tpe")).toValidatedNel

  def emitEnum(e: TsEnum[Partial]): JIntEnum[Name] =
    JIntEnum(e.name, e.members.map(m => JEnumEntry(m.symbol, m.ordinal, emitDoc(m.doc))), emitDoc(e.doc))

  def emitClassLike(cls: ClassLike[Partial], lut: TpeLookup, nameLut: NameLookup): CheckM[
    (JType[Name], Set[(Sym, List[JType[Name]], JType[Name])], (List[JCtor[Name]], List[JMethod[Name]]) => JClass[Name])
  ] = (for {
    parents <- cls.parents.flatTraverse { p =>
      lut.get(p) match {
        case Some(Right(name)) => List(name).pureF
        case Some(Left(e))     => failF(s"Unexpected type reference $e")
        case None              =>
          System.err.println(s"WARN: Skipping missing parent $p for ${cls.name}")
          List.empty[Name].pureF
      }
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

  def resolveInheritedConflicts(
      ms: List[JMethod[Name]],
      inheritedNames: Set[(Sym, List[JType[Name]], JType[Name])]
  ): List[JMethod[Name]] =
    ms.map { m =>
      val myParams  = m.params.map(_._2.value)
      val conflicts = inheritedNames.exists { case (rname, rparams, rrtn) =>
        rname == m.name && rparams == myParams && rrtn != m.rtn.value
      }
      if (conflicts) m.copy(name = m.name ++ "_") else m
    }

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
      (properties |+| accessors |+| methods).map { ms =>
        val resolved = resolveInheritedConflicts(ms, inheritedNames)
        mkCls(Nil, resolved ++ emitOverrideMethods(resolved, clsTpe, inheritedNames))
      }
    }.elaborate(emitError("class", cls.name))

  def emitInterfaceProperty(p: TsProperty[Partial], enclosing: JType[Name]): CheckM[List[JMethod[Name]]] =
    emitPropertyLike(p.name, p.tpe, p.optional, get = true, set = true, p.doc, enclosing)

  def emitCallSignatures(
      sigs: List[TsSignature[Partial]],
      reservedNames: Set[(Sym, List[JType[Name]], JType[Name])]
  ): CheckM[List[JMethod[Name]]] =
    if (sigs.isEmpty) Nil.validNel
    else emitCallable(sigs, Sym.unsafe("invoke"), Doc(Nil), static = false, reservedNames)
      .map(_.map(m => m.copy(code = DelegationBody.InvokeReceiver(m.params, m.rtn))))
      .toValidatedNel

  def emitInterface(iface: TsInterface[Partial], tpeLut: TpeLookup, nameLut: NameLookup): CheckM[JClass[Name]] =
    emitClassLike(iface, tpeLut, nameLut).andThen { case (clsTpe, inheritedNames, mkCls) =>
      val properties = iface.properties.flatTraverse(emitInterfaceProperty(_, clsTpe))
      val methods    = iface.methods.filterNot(_.inherited).flatTraverse(emitMethod(_, inheritedNames))
      val callSigs   = emitCallSignatures(iface.callSignatures, inheritedNames)
      (properties |+| methods |+| callSigs).map { ms =>
        val resolved = resolveInheritedConflicts(ms, inheritedNames)
        mkCls(Nil, resolved ++ emitOverrideMethods(resolved, clsTpe, inheritedNames))
      }
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
        // XXX TypeDoc 0.26 may emit overloads as separate Function nodes --group by name
        m.functions
          .groupBy(_.name)
          .values.toList
          .flatTraverse { fns =>
            val merged = fns.head.copy(signatures = fns.flatMap(_.signatures).distinct)
            emitFunction(merged)
          }
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
      // XXX TODO only handles single type variable propagation for Alias<Applied>
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
                case _ :: Nil => resolved.flatMap {
                    case TsTypeVar(_) => resolve(x)
                    case x            => TsTerminal(x)
                  }
                case _ => resolved
              }
            case _ => resolved
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

  def allModulesOf[A](ms: List[TsModule[A]]): List[TsModule[A]] =
    ms.flatMap(m => m :: allModulesOf(m.modules))

  def runConversion(
      jsonFile: File,
      dtsFile: File
  ): Either[Throwable, cats.data.ValidatedNel[Throwable, List[(String, String)]]] = {
    import scala.collection.parallel.CollectionConverters.*

    val a = for {
      tsDocAstStr <- time(s"Read: $jsonFile")(Either.catchNonFatal(jsonFile.contentAsString))
      tsSource  <- time(s"Read: $dtsFile")(Either.catchNonFatal(dtsFile.lines.to(scala.collection.immutable.ArraySeq)))
      tsDocRoot <- Either.catchNonFatal(upickleDefault.read[TypeDocParser2.TSReflection](tsDocAstStr))
      tsTypedGlobal <- time("Read TS AST")(TypeDocParser2.liftGlobal(tsDocRoot, tsSource))
      aliases = time("Isolate alias") {
        allModulesOf(tsTypedGlobal.modules).flatMap(_.aliases).map(a =>
          a.id -> (a.tpe match {
            case TsGeneric(tpe, _) => tpe // XXX TODO don't expand alias type parameters
            case x                 => x
          })
        ).toMap
      }
      _ = summon[Traverse[TsGlobal]]

      tsAliasResolvedGlobal = time("Resolve alias")(tsTypedGlobal.map(resolveAliasChain(_, aliases)))
      tpeLut <- time("Create Type LUT") {
        val modulePairs = allModulesOf(tsAliasResolvedGlobal.modules).flatMap { m =>
          m.variables.map(x => x.id -> x.tpe.asLeft) ++
            (m.classes ++
              m.aliases ++
              m.enums ++
              m.interfaces).map(x => x.id -> x.name.asRight)
        }
        // XXX supplementary: simple aliases pointing to root-level IDs not in the primary LUT
        val primaryIds    = modulePairs.collect { case (id, _) => id }.toSet
        val allAliases    = allModulesOf(tsAliasResolvedGlobal.modules).flatMap(_.aliases)
        val supplementary = allAliases.flatMap { a =>
          a.tpe match {
            case TsTerminal(TsRef(_, Some(targetId))) if !primaryIds.contains(targetId) =>
              Some(targetId -> a.name.asRight)
            case _ => None
          }
        }.distinctBy(_._1)
        safeGroup(modulePairs ++ supplementary)
      }

      global <- time("Transform Type")(tsAliasResolvedGlobal.traverse(tsToJava(_, tpeLut)))

      nameLut <- time("Create Name LUT") {
        def firstJType(t: Partial): JType[Name] = t match {
          case Alt(xs) => xs.toList match {
              case JTypeContext(single, _) :: Nil => single
              case alts                           => JavaUnion(Nel.fromListUnsafe(alts.map(_.value)))
            }
          case _ => JavaObject
        }
        def sigKeys(mname: Sym, sigs: List[TsSignature[Partial]]): List[(Sym, List[JType[Name]], JType[Name])] =
          sigs.map { sig =>
            val paramTypes = sig.params.map(p => firstJType(p.tpe))
            val returnType = firstJType(sig.returnTpe)
            (mname, paramTypes, returnType)
          }
        def propKeys(props: List[TsProperty[Partial]]): Set[(Sym, List[JType[Name]], JType[Name])] =
          props.map(p => (p.name, List.empty[JType[Name]], firstJType(p.tpe))).toSet
        safeGroup(allModulesOf(global.modules).flatMap { m =>
          m.classes.map(c =>
            c.name -> (c.methods.flatMap(meth => sigKeys(meth.name, meth.signatures)).toSet ++ propKeys(c.properties))
          ) ++
            m.interfaces.map(i =>
              i.name -> (i.methods.flatMap(meth => sigKeys(meth.name, meth.signatures)).toSet ++ propKeys(i.properties))
            )
        })
      }

      emittedNames = allModulesOf(global.modules).flatMap { m =>
        m.classes.map(_.name) ++ m.interfaces.map(_.name) ++ m.enums.map(_.name)
      }.toSet

      classResults = time("Transform AST") {
        allModulesOf(global.modules).flatMap { m =>
          (() => emitModule(m)) ::
            m.classes.map(c => () => emitClass(c, tpeLut, nameLut)) ++
            m.interfaces.map(i => () => emitInterface(i, tpeLut, nameLut)) ++
            m.enums.map(e => () => emitEnum(e).validNel) ++
            m.aliases.filterNot(a => emittedNames.contains(a.name)).map(a =>
              () =>
                JClass[Name](a.name, Nil, JsProxy :: Nil, JsContextCtors, Nil, emitDoc(a.doc)).validNel
            )
        }.par.map(_()).toList
      }
      (classErrors, classSuccesses) = classResults.partitionMap(_.toEither)
      _ = classErrors.flatMap(_.toList).foreach(e => System.err.println(s"Unable to emit: ${e.getMessage}"))

      enums = classSuccesses.collect {
        case JEnum.JIntEnum(name, _, _) => name
        case JEnum.JStrEnum(name, _, _) => name
      }.map(_.self).toSet

      classSources = time("Emit source")(classSuccesses.par.map(fmtTopLevelSource(_, enums)).toList)

    } yield classSources.validNel
    a
  }

  def main(args: Array[String]): Unit = {
    val (jsonFile, dtsFile, outputDir) = args.toList match {
      case json :: dts :: out :: Nil => (File(json), File(dts), File(out))
      case _                         =>
        System.err.println("Usage: TsToJavaAst <typedoc-json> <monaco-dts> <output-dir>")
        sys.exit(1)
    }

    runConversion(jsonFile, dtsFile).dump match {
      case Validated.Invalid(es) =>
        println(s"[INVALID] ${es.size} errors")
        es.toList.foreach(e => println(e.getMessage))

      case Validated.Valid(xs) =>
        val dupes = xs.groupBy(_._1).filter(_._2.size > 1)
        dupes.foreach { case (f, entries) =>
          System.err.println(s"WARN: Duplicate file path '$f' (${entries.size} entries, keeping last)")
        }
        val deduped = xs.reverse.distinctBy(_._1).reverse
        println(s"[VALID] ${deduped.size} files${
            if (dupes.nonEmpty) s" (${xs.size - deduped.size} duplicates removed)" else ""
          }")
        deduped.foreach { case (f, c) =>
          (outputDir / f).createFileIfNotExists(createParents = true).overwrite(c)
        }
    }
  }

}
