package net.kurobako.monaco

import cats.*
import cats.syntax.all.*
import net.kurobako.monaco.Ast.Name
import net.kurobako.monaco.Ast.Sym
import net.kurobako.monaco.JavaAst.DelegationBody.*
import net.kurobako.monaco.JavaAst.JEnum.JEnumEntry
import net.kurobako.monaco.JavaAst.JType.JPrimitive
import net.kurobako.monaco.JavaAst.JType.JavaGeneric
import net.kurobako.monaco.JavaAst.JType.JavaInt
import net.kurobako.monaco.JavaAst.JType.JavaList
import net.kurobako.monaco.JavaAst.JType.JavaLiteral
import net.kurobako.monaco.JavaAst.JType.JavaObject
import net.kurobako.monaco.JavaAst.JType.JavaRef
import net.kurobako.monaco.JavaAst.JType.JavaString
import net.kurobako.monaco.JavaAst.JType.JavaTypeVar
import net.kurobako.monaco.JavaAst.JType.JavaUnion
import net.kurobako.monaco.JavaAst.JType.JavaVoid
import net.kurobako.monaco.TsToJavaAst.*
import netscape.javascript.JSObject

object JavaAst {

  sealed trait JType[+A]
  object JType {
    implicit val traverse: Traverse[JType] = cats.derived.semiauto.traverse

    sealed abstract class JPrimitive(val unboxed: Sym, val boxed: Sym) extends JType[Nothing] {
      def format(boxed: Boolean): Sym = if (boxed) this.boxed else this.unboxed
    }
    case object JavaInt     extends JPrimitive(Sym.unsafe("int"), Sym.unsafe("Integer"))
    case object JavaLong    extends JPrimitive(Sym.unsafe("int"), Sym.unsafe("Integer"))
    case object JavaFloat   extends JPrimitive(Sym.unsafe("int"), Sym.unsafe("Integer"))
    case object JavaDouble  extends JPrimitive(Sym.unsafe("double"), Sym.unsafe("Double"))
    case object JavaBoolean extends JPrimitive(Sym.unsafe("boolean"), Sym.unsafe("Boolean"))
    case object JavaVoid    extends JPrimitive(Sym.unsafe("void"), Sym.unsafe("Void"))
    // XXX String is not a ref --JSObject auto-converts it to the correct Java type
    case object JavaString extends JType[Nothing]
    // XXX JSObject is the base/fallback type when conversion fails
    case object JavaObject               extends JType[Nothing]
    case class JavaLiteral(name: String) extends JType[Nothing]

    case class JavaTypeVar[+A](name: Sym)                                 extends JType[A]
    case class JavaList[+A](name: JType[A], dim: Int)                     extends JType[A]
    case class JavaUnion[+A](actual: Nel[JType[A]])                       extends JType[A]
    case class JavaIntersection[+A](actual: Nel[JType[A]])                extends JType[A]
    case class JavaGeneric[+A](name: JType[A], parameters: Nel[JType[A]]) extends JType[A]
    case class JavaRef[+A](name: A)                                       extends JType[A]
  }

  case class JTypeContext[+A](value: JType[A], nullable: Boolean = false) {
    def optional(optional: Boolean): JTypeContext[A] = copy(nullable = this.nullable || optional)
    override def toString: String                    = s"$value${if (nullable) "?" else ""}"
  }

  type DocLns = List[String]

  sealed trait DelegationBody[+A]
  object DelegationBody {
    case class GetMember[+A](name: Sym, tpe: JTypeContext[A])                                  extends DelegationBody[A]
    case class SetMember[+A](name: Sym, param: Sym, tpe: JTypeContext[A])                      extends DelegationBody[A]
    case class Call[+A](name: Sym, params: List[(Sym, JTypeContext[A])], tpe: JTypeContext[A]) extends DelegationBody[A]
    case class Raw(lines: List[String])                                              extends DelegationBody[Nothing]
    case class Override[+A](methodName: Sym, arity: Int, paramTypes: List[JType[A]]) extends DelegationBody[A]
    case class InvokeReceiver[+A](params: List[(Sym, JTypeContext[A])], tpe: JTypeContext[A]) extends DelegationBody[A]
  }

  sealed trait JTopLevel[+A] {
    def name: Name
    def doc: List[String]
  }
  object JTopLevel {
    implicit val traverse: Traverse[JTopLevel] = cats.derived.semiauto.traverse
  }

  case class JMethod[+A](
      name: Sym,
      tpeParams: List[(Sym, Option[JTypeContext[A]])],
      params: List[(Sym, JTypeContext[A])],
      rtn: JTypeContext[A],
      code: DelegationBody[A],
      doc: DocLns = Nil,
      static: Boolean = false
  )
  case class JCtor[+A](params: List[(Sym, JTypeContext[A])], code: DelegationBody[A], doc: DocLns = Nil)

  case class JClass[+A](
      name: Name,
      tpeParams: List[(Sym, Option[JTypeContext[A]])],
      parents: List[A],
      ctors: List[JCtor[A]],
      methods: List[JMethod[A]],
      doc: DocLns = Nil
  ) extends JTopLevel[A]
  object JClass {
    implicit val traverse: Traverse[JClass] = cats.derived.semiauto.traverse
  }

  sealed trait JEnum[A, B] extends JTopLevel[A] {
    def name: Name
    def doc: DocLns
    def entries: List[JEnumEntry[B]]
  }
  object JEnum {
    case class JEnumEntry[+A](name: Sym, value: A, doc: DocLns)
    case class JIntEnum[A](name: Name, entries: List[JEnumEntry[Int]], doc: DocLns)    extends JEnum[A, Int]
    case class JStrEnum[A](name: Name, entries: List[JEnumEntry[String]], doc: DocLns) extends JEnum[A, String]
  }

  sealed trait JTypeTree[+A]
  object JTypeTree {

    case object Remove                                     extends JTypeTree[Nothing]
    case class IntEnum(xs: Nel[Int], nullable: Boolean)    extends JTypeTree[Nothing]
    case class StrEnum(xs: Nel[String], nullable: Boolean) extends JTypeTree[Nothing]
    case class NoRep(name: Foreign)                        extends JTypeTree[Nothing]
    sealed trait Foreign
    object Foreign {
      case object Null      extends Foreign
      case object Undefined extends Foreign
      sealed trait Lit[A]   extends Foreign { def value: A }
      object Lit {
        case class StrLit(value: String) extends Lit[String]
        case class IntLit(value: Int)    extends Lit[Int]
      }
    }
    case class Alt[A](xs: Nel[JTypeContext[A]]) extends JTypeTree[A] {
      def modify(f: JTypeContext[A] => JTypeContext[A]): Alt[A] = Alt(xs.map(f))

      override def toString: String = xs.map(_.toString).mkString_("[", "|", "]")
    }
    object Alt {
      def apply[A](x: JType[A]): Alt[A]        = new Alt(Nel.one(JTypeContext(x)))
      def apply[A](x: JTypeContext[A]): Alt[A] = new Alt(Nel.one(x))
    }
  }

  val ImplicitImportPkg = Vector("java", "lang")

  private val JavaKeywords: Set[String] = Set(
    "abstract",
    "assert",
    "boolean",
    "break",
    "byte",
    "case",
    "catch",
    "char",
    "class",
    "const",
    "continue",
    "default",
    "do",
    "double",
    "else",
    "enum",
    "extends",
    "final",
    "finally",
    "float",
    "for",
    "goto",
    "if",
    "implements",
    "import",
    "instanceof",
    "int",
    "interface",
    "long",
    "native",
    "new",
    "package",
    "private",
    "protected",
    "public",
    "return",
    "short",
    "static",
    "strictfp",
    "super",
    "switch",
    "synchronized",
    "this",
    "throw",
    "throws",
    "transient",
    "try",
    "void",
    "volatile",
    "while",
    "var",
    "yield"
  )
  private def javaId(s: String): String = if (JavaKeywords.contains(s)) s"${s}_" else s

  def fmtTopLevelSource(
      tl: JTopLevel[Name],
      enums: Set[String],
      generatedDate: String = java.time.Instant.now().toString
  ): (String, String) = {

    val generatedAnnotation =
      s"""@javax.annotation.processing.Generated(value = "ambient2java", date = "$generatedDate")"""

    def fmtDoc(lines: List[String], indent: Int = 0): String = {
      val prefix = "\t" * indent
      // XXX escape backslashes so \uXXXX in comments don't trigger Java's unicode escape processing
      lines.map(l => prefix + l.replace("\\", "&#92;")).mkString("\n")
    }

    def fmtImports(xs: List[Name]) = xs.distinct
      .filterNot(_.path == ImplicitImportPkg) // no java implicit imports
      .filterNot(_.path == tl.name.path)      // no imports of classes from the same package
      .sorted(using Order[Name].toOrdering)
      .map(name => s"import ${name.normalise};").mkString("\n")

    def fmtInTpe(t: JTypeContext[String], boxed: Boolean): (List[Name], String) = {
      val annotation = if (t.nullable) JNullable else JNonnull
      fmtTpe(t.value).bimap(annotation :: _, x => s"@${annotation.self} $x")
    }

    def fmtOutTpe(t: JTypeContext[String], boxed: Boolean): (List[Name], String) =
      if (t.nullable) fmtTpe(t.value).bimap(JOptional :: _, x => s"Optional<$x>")
      else fmtTpe(t.value, boxed)

    def fmtTpe(t: JType[String], boxed: Boolean = true): (List[Name], String) =

      t match {
        case p: JPrimitive     => Nil                         -> p.format(boxed).value
        case JavaString        => Nil                         -> "String"
        case JavaObject        => (Name.cls[JSObject] :: Nil) -> Name.cls[JSObject].self
        case JavaLiteral(name) => Nil                         -> name
        case JavaTypeVar(name) => Nil                         -> name.value
        case JavaUnion(actual) =>
          // XXX only JsUnion2..4 shims exist; degrade larger unions to JSObject
          if (actual.size > 4)
            (Name.cls[JSObject] :: Nil) -> Name.cls[JSObject].self
          else {
            val union = JsUnion(actual.size)
            actual.foldMap(fmtTpe(_).map(_ :: Nil)).bimap(union :: _, tpes => s"${union.self}<${tpes.mkString(", ")}>")
          }
        case JavaList(name, dim) =>

          val list = Name.cls[java.util.List[?]]
          fmtTpe(name, boxed = true).bimap(list :: _, s => s"${list.self}<" * dim + s + ">" * dim)

        // XXX JSObject is not generic in Java --degrade to raw JSObject
        case JavaGeneric(JavaObject, _) =>
          (Name.cls[JSObject] :: Nil) -> Name.cls[JSObject].self
        case JavaGeneric(name, parameters) =>
          val (rootNames, rootTpe) = fmtTpe(name)
          // XXX only shim classes are truly generic in Java; Monaco-generated classes are not parameterized
          val isShimGeneric = rootTpe.startsWith("JsUnion") || rootTpe.startsWith("JsTuple") ||
            rootTpe.startsWith("JsFunction") || rootTpe == "JsEnum" || rootTpe == "JsPromise" ||
            rootTpe == "Optional"
          if (isShimGeneric)
            parameters.foldMap(fmtTpe(_).map(_ :: Nil)).bimap(
              rootNames ::: _,
              tpes => s"$rootTpe<${tpes.mkString(", ")}>"
            )
          else
            (rootNames, rootTpe)
        case JavaRef(name)             => Nil -> name
        case JType.JavaIntersection(_) =>
          (Name.cls[JSObject] :: Nil) -> Name.cls[JSObject].self
      }

    def fmtParamList(xs: List[(Sym, JTypeContext[String])]): (List[Name], String) = xs.foldMap { case (sym, tpe) =>
      fmtInTpe(tpe, boxed = false).map(x => s"$x ${javaId(sym.value)}" :: Nil)
    }.map(_.mkString(", "))

    def fmtTpeParamList(tpeParams: List[(Sym, Option[JTypeContext[String]])]): (List[Name], String) =
      tpeParams.foldMap {
        case (sym, None)    => (Nil, sym.value :: Nil)
        case (sym, Some(x)) => fmtTpe(x.value).map(x => s"${sym.value} extends $x" :: Nil)
      } match {
        case (l, Nil) => (l, "")
        case (l, xs)  => (l, xs.mkString(" <", ", ", ">"))
      }

    val file = tl.name.fragments.mkString_("", "/", ".java")

    def fmtEnum[A: Show](e: JEnum[String, A], valueTpeName: JType[String]) = {
      val (varTpeNames, varTpe)         = fmtTpe(valueTpeName, boxed = false)
      val (rtnTpeNames, rtnTpe)         = fmtTpe(valueTpeName, boxed = true)
      val (enumMarkerNames, enumMarker) =
        fmtTpe(JavaGeneric(JavaRef(JsEnum.self), Nel.one(valueTpeName))).leftMap(JsEnum :: _)
      s"""
			   |package ${e.name.normalisedPath};
			   |
			   |${fmtImports(varTpeNames ::: rtnTpeNames ::: enumMarkerNames)}
			   |
			   |${fmtDoc(e.doc)}
			   |$generatedAnnotation
			   |@SuppressWarnings("unused")
			   |public enum ${e.name.self} implements $enumMarker {
			   |${e.entries.map(m => s"${fmtDoc(m.doc, indent = 1)}\n\t${m.name.value}(${m.value.show})").mkString(",\n")};
			   |	private final $varTpe value;
			   |	${e.name.self}($varTpe value) { this.value = value; }
			   |	public $rtnTpe value() { return value; }
			   |}
			   |""".stripMargin
    }

    def fmtCode(
        x: DelegationBody[String],
        isStatic: Boolean = false,
        jsClassPath: String = ""
    ): (List[Name], String) = {

      def fmtOutWrapper(t: JType[String]): String =
        t match {
          case JavaVoid                       => s"ofVoid()"
          case p: JPrimitive                  => s"ofMapped(${p.format(false).value}.class)"
          case JType.JavaString               => s"ofMapped(${Name.cls[String].self}.class)"
          case JType.JavaObject               => s"ofMapped(${Name.cls[JSObject].self}.class)"
          case JavaLiteral(name)              => name
          case JavaTypeVar(name)              => "null " //  s"ofMapped(${Name.cls[JSObject].self}.class)" //  name.value
          case JavaList(name, dim)            => s"${"ofArray(" * dim}${fmtOutWrapper(name)}${")" * dim}"
          case JavaUnion(actual)              => "null /*union*/"
          case JType.JavaIntersection(actual) => "null /*intersection*/"
          case JavaGeneric(JavaRef(cls), _)       => s"$cls ::new" // java infers the rest
          case JavaGeneric(_, _)                  => s"null /*unsupported generic*/"
          case JavaRef(cls) if enums contains cls => s"ofJsEnum($cls.class)"
          case JavaRef(cls)                       => s"$cls::new"

        }
      def fmtOutTpe(nullable: Boolean, expr: String) =
        if (nullable) s"return Optional.ofNullable($expr);" else s"return $expr;"

      def getter(prop: String, t: JTypeContext[String]) =
        fmtOutTpe(t.nullable, s"""get("$prop", ${fmtOutWrapper(t.value)})""") :: Nil

      def setter(prop: String, param: String, t: JTypeContext[String]) =
        (t.value match {
          case JavaString | JavaObject | _: JPrimitive => s"""set("$prop", $param);"""
          case JavaLiteral(name)                       => ""
          case JavaTypeVar(name)                       => ""
          case JavaList(_, _)                          => s"""set("$prop", $param);"""
          case JavaGeneric(_, _)                       => s"""set("$prop", $param);"""
          case JavaUnion(actual)                       => s"""set("$prop", $param);"""
          case JavaRef(name) if enums contains name    => s"""set("$prop", $param);"""
          case JavaRef(_)                              => s"""set("$prop", $param);"""
          case JType.JavaIntersection(_)               => s"""set("$prop", $param);"""
        }) :: "return this;" :: Nil

      val lines: List[String] = x match {
        case GetMember(name, tpe)        => getter(name.value, tpe)
        case SetMember(name, param, tpe) => setter(name.value, param.value, tpe)
        case Call(name, params, tpe)     =>
          val ps = params.map(_._1.value) match {
            case Nil => ""
            case xs  => xs.mkString(", ", ", ", "")
          }
          val expr = if (isStatic)
            s"""invokeStatic(new JsProxy(ctx, ctx.engine.executeScript("$jsClassPath")), "${name.value}", ${fmtOutWrapper(
                tpe.value
              )}$ps)"""
          else s"""invoke("${name.value}", ${fmtOutWrapper(tpe.value)}$ps)"""
          (tpe.value match {
            case JavaVoid => s"$expr;"
            case _        => fmtOutTpe(tpe.nullable, expr)
          }) :: Nil
        case Raw(lines)                              => lines
        case Override(methodName, arity, paramTypes) =>
          if (paramTypes.isEmpty)
            List(s"""return bindCallback("${methodName.value}", $arity, value);""")
          else {
            val args   = (0 until arity).map(i => s"a$i").mkString(",")
            val lifted = paramTypes.zipWithIndex.map { case (tpe, i) =>
              val a = s"a$i"
              tpe match {
                case JavaRef(cls) if enums contains cls => s"ofJsEnum($cls.class).apply(ctx, $a)"
                case JavaRef(cls)                       => s"new $cls(ctx, $a)"
                case JavaGeneric(JavaRef(cls), _)       => s"new $cls(ctx, $a)"
                case JavaObject                         => s"(JSObject) $a"
                case JavaString                         => s"(String) $a"
                case p: JPrimitive                      => p.unboxed.value match {
                    case "void"    => s"$a"
                    case "boolean" => s"(Boolean) $a"
                    case "int"     => s"((Number) $a).intValue()"
                    case "double"  => s"((Number) $a).doubleValue()"
                    case _         => s"$a"
                  }
                case l: JavaList[?] => s"${fmtOutWrapper(tpe)}.apply(ctx, $a)"
                case _              => s"(JSObject) $a"
              }
            }.mkString(", ")
            List(
              s"""return bindCallback("${methodName.value}", $arity, (JsFunction$arity)($args) -> ((JsFunction$arity)value).invoke($lifted));"""
            )
          }
        case DelegationBody.InvokeReceiver(params, tpe) =>
          val ps = params.map(_._1.value) match {
            case Nil => ""
            case xs  => xs.mkString(", ", ", ", "")
          }
          val expr = s"""invokeThis(${fmtOutWrapper(tpe.value)}$ps)"""
          (tpe.value match {
            case JavaVoid => s"$expr;"
            case _        => fmtOutTpe(tpe.nullable, expr)
          }) :: Nil
      }

      val extraImports: List[Name] = x match {
        case Override(_, arity, pts) if pts.nonEmpty =>
          TsToJavaAst.JsFunction(arity) :: (pts.collect {
            case JavaObject => Name.cls[JSObject]
          })
        case _ => Nil
      }

      extraImports -> (lines match {
        case Nil         => "{}"
        case line :: Nil => s"""{ $line }
									   |""".stripMargin
        case xs => s"""{
									   |${xs.map("\t\t" + _).mkString("\n")}
									   |	}
									   |""".stripMargin
      })
    }

    file -> (tl.map(_.self) match {
      case JClass(name, tpeParams, parents, ctors, methods, doc) =>
        Apply[(List[Name], *)].map3(
          fmtTpeParamList(tpeParams),
          ctors.foldMap { case JCtor(params, code, doc) =>
            val (codeNames, codeStr) = fmtCode(code)
            fmtParamList(params).map { ps =>
              s"""${fmtDoc(doc, indent = 1)}
							   |	public ${name.self}($ps) $codeStr
							   | """.stripMargin
            }.bimap(codeNames ::: _, identity)
          },
          methods.foldMap { case JMethod(Sym(rawName), tpeParams, params, rtn, code, doc, isStatic) =>
            val name                 = javaId(rawName)
            val jsClassPath          = tl.name.fragments.toVector.drop(1).map(_.value).mkString(".")
            val (codeNames, codeStr) = fmtCode(code, isStatic, jsClassPath)
            val staticMod            = if (isStatic) " static" else ""
            val unchecked            = code match {
              case Override(_, _, pts) if pts.nonEmpty => "\n\t@SuppressWarnings(\"unchecked\")"
              case _                                   => ""
            }
            val needsCtx                          = isStatic && code.isInstanceOf[Call[?]]
            val paramResult: (List[Name], String) = {
              val (names, str) = fmtParamList(params)
              if (needsCtx) {
                val prefix = s"@${JNonnull.self} ${JsContext.self} ctx"
                (JNonnull :: JsContext :: names, if (str.isEmpty) prefix else s"$prefix, $str")
              } else (names, str)
            }
            Apply[(List[Name], *)].map3(
              fmtTpeParamList(tpeParams),
              fmtOutTpe(rtn, boxed = false),
              paramResult
            ) { (tps, r, ps) =>
              s"""${fmtDoc(doc, indent = 1)}$unchecked
							   |	public$staticMod$tps $r $name($ps) $codeStr
							   | """.stripMargin
            }.bimap(codeNames ::: _, identity)
          }
        ) { (tps, ctors, methods) =>
          val parent = parents.lastOption.foldMap("extends " + _)
          s"""
					   |${fmtDoc(doc)}
					   |$generatedAnnotation
					   |@SuppressWarnings("unused")
					   |public class ${name.self}$tps $parent {
					   |$ctors
					   |$methods
					   |}
					   |""".stripMargin
        }.leftMap { names =>
          s"""
					   |package ${name.normalisedPath};
					   |${fmtImports(names ::: tl.toList)}
					   |""".stripMargin
        }.productIterator.mkString
      case e @ JEnum.JIntEnum(_, _, _) => fmtEnum(e, JavaInt)
      case e @ JEnum.JStrEnum(_, _, _) => fmtEnum(e, JavaRef("String"))
    })
  }

}
