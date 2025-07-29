package net.kurobako.monaco

import cats.kernel.Order
import cats.syntax.all._
import cats.{Apply, Show, Traverse}
import net.kurobako.monaco.Ast.{Name, Sym}
import net.kurobako.monaco.JavaAst.DelegationBody.{Call, GetMember, Raw, SetMember}
import net.kurobako.monaco.JavaAst.JEnum.JEnumEntry
import net.kurobako.monaco.JavaAst.JType.{JPrimitive, JavaGeneric, JavaInt, JavaList, JavaLiteral, JavaObject, JavaRef, JavaString, JavaTypeVar, JavaUnion, JavaVoid}
import net.kurobako.monaco.TsToJavaAst.{JNonnull, JNullable, JOptional, JsEnum, JsUnion}
import netscape.javascript.JSObject

object JavaAst {


	sealed trait JType[+A]
	object JType {
		implicit val traverse: Traverse[JType] = cats.derived.semi.traverse

		sealed abstract class JPrimitive(val unboxed: Sym, val boxed: Sym) extends JType[Nothing] {
			def format(boxed: Boolean): Sym = if (boxed) this.boxed else this.unboxed
		}
		case object JavaInt extends JPrimitive(Sym.unsafe("int"), Sym.unsafe("Integer"))
		case object JavaLong extends JPrimitive(Sym.unsafe("int"), Sym.unsafe("Integer"))
		case object JavaFloat extends JPrimitive(Sym.unsafe("int"), Sym.unsafe("Integer"))
		case object JavaDouble extends JPrimitive(Sym.unsafe("double"), Sym.unsafe("Double"))
		case object JavaBoolean extends JPrimitive(Sym.unsafe("boolean"), Sym.unsafe("Boolean"))
		case object JavaVoid extends JPrimitive(Sym.unsafe("void"), Sym.unsafe("Void"))
		case object JavaString extends JType[Nothing] // String is not a ref because JSObject auto converts it to the correct Java type
		case object JavaObject extends JType[Nothing] // JSObject is the base type if conversion fails
		case class JavaLiteral(name: String) extends JType[Nothing]

		case class JavaTypeVar[+A](name: Sym) extends JType[A]
		case class JavaList[+A](name: JType[A], dim: Int) extends JType[A]
		case class JavaUnion[+A](actual: Nel[JType[A]]) extends JType[A]
		case class JavaIntersection[+A](actual: Nel[JType[A]]) extends JType[A]
		case class JavaGeneric[+A](name: JType[A], parameters: Nel[JType[A]]) extends JType[A]
		case class JavaRef[+A](name: A) extends JType[A]
	}


	case class JTypeContext[+A](value: JType[A], nullable: Boolean = false) {
		def optional(optional: Boolean): JTypeContext[A] = copy(nullable = this.nullable || optional)
		override def toString: String = s"$value${if (nullable) "?" else ""}"
	}

	type DocLns = List[String]


	sealed trait DelegationBody[+A]
	object DelegationBody {
		//		case class ConcreteType[A](that : JType[A], nullable : Boolean  )
		case class GetMember[+A](name: Sym, tpe: JTypeContext[A]) extends DelegationBody[A]
		case class SetMember[+A](name: Sym, param: Sym, tpe: JTypeContext[A]) extends DelegationBody[A]
		case class Call[+A](name: Sym, params: List[(Sym, JTypeContext[A])], tpe: JTypeContext[A]) extends DelegationBody[A]
		case class Raw(lines: List[String]) extends DelegationBody[Nothing]
	}

	sealed trait JTopLevel[+A] {
		def name: Name
		def doc: List[String]
	}
	object JTopLevel {
		implicit val traverse: Traverse[JTopLevel] = cats.derived.semi.traverse
	}

	case class JMethod[+A](name: Sym,
						   tpeParams: List[(Sym, Option[JTypeContext[A]])],
						   params: List[(Sym, JTypeContext[A])], rtn: JTypeContext[A],
						   code: DelegationBody[A], doc: DocLns = Nil, static: Boolean = false)
	case class JCtor[+A](params: List[(Sym, JTypeContext[A])], code: DelegationBody[A], doc: DocLns = Nil)

	case class JClass[+A](name: Name, tpeParams: List[(Sym, Option[JTypeContext[A]])], parents: List[A],
						  ctors: List[JCtor[A]],
						  methods: List[JMethod[A]],
						  doc: DocLns = Nil) extends JTopLevel[A]
	object JClass {
		implicit val traverse: Traverse[JClass] = cats.derived.semi.traverse
	}

	sealed trait JEnum[A, B] extends JTopLevel[A] {
		def name: Name
		def doc: DocLns
		def entries: List[JEnumEntry[B]]
	}
	object JEnum {
		case class JEnumEntry[+A](name: Sym, value: A, doc: DocLns)
		case class JIntEnum[A](name: Name, entries: List[JEnumEntry[Int]], doc: DocLns) extends JEnum[A, Int]
		case class JStrEnum[A](name: Name, entries: List[JEnumEntry[String]], doc: DocLns) extends JEnum[A, String]
	}


	// not actually a tree, but close
	sealed trait JTypeTree[+A]
	object JTypeTree {


		case object Remove extends JTypeTree[Nothing]
		case class IntEnum(xs: Nel[Int], nullable: Boolean) extends JTypeTree[Nothing]
		case class StrEnum(xs: Nel[String], nullable: Boolean) extends JTypeTree[Nothing]
		case class NoRep(name: Foreign) extends JTypeTree[Nothing]
		sealed trait Foreign
		object Foreign {
			case object Null extends Foreign
			case object Undefined extends Foreign
			sealed trait Lit[A] extends Foreign {def value: A}
			object Lit {
				case class StrLit(value: String) extends Lit[String]
				case class IntLit(value: Int) extends Lit[Int]
			}
		}
		case class Alt[A](xs: Nel[JTypeContext[A]]) extends JTypeTree[A] {
			def modify(f: JTypeContext[A] => JTypeContext[A]): Alt[A] = Alt(xs.map(f))

			override def toString: String = xs.map(_.toString).mkString_("[", "|", "]")
		}
		object Alt {
			def apply[A](x: JType[A]): Alt[A] = new Alt(Nel.one(JTypeContext(x)))
			def apply[A](x: JTypeContext[A]): Alt[A] = new Alt(Nel.one(x))
		}
	}

	val ImplicitImportPkg = Vector("java", "lang")

	def fmtTopLevelSource(tl: JTopLevel[Name], enums: Set[String]): (String, String) = {


		def fmtDoc(lines: List[String], indent: Int = 0): String = {
			val prefix = "\t" * indent
			lines.map(prefix + _).mkString("\n")
		}

		def fmtImports(xs: List[Name]) = xs.distinct
			.filterNot(_.path == ImplicitImportPkg) // no java implicit imports
			.filterNot(_.path == tl.name.path) // no imports of classes from the same package
			.sorted(Order[Name].toOrdering)
			.map(name => s"import ${name.normalise};").mkString("\n")


		def fmtInTpe(t: JTypeContext[String], boxed: Boolean): (List[Name], String) = {
			val annotation = if (t.nullable) JNullable else JNonnull
			fmtTpe(t.value).bimap(annotation :: _, x => s"@${annotation.self} $x")
		}

		def fmtOutTpe(t: JTypeContext[String], boxed: Boolean): (List[Name], String) = {
			if (t.nullable) fmtTpe(t.value).bimap(JOptional :: _, x => s"Optional<$x>")
			else fmtTpe(t.value, boxed)
		}

		def fmtTpe(t: JType[String], boxed: Boolean = true): (List[Name], String) = {


			t match {
				case p: JPrimitive       => Nil -> p.format(boxed).value
				case JavaString          => Nil -> "String"
				case JavaObject          => (Name.cls[JSObject] :: Nil) -> Name.cls[JSObject].self
				case JavaLiteral(name)   => Nil -> name
				case JavaTypeVar(name)   => Nil -> name.value
				case JavaUnion(actual)   =>
					val union = JsUnion(actual.size)
					actual.foldMap(fmtTpe(_).map(_ :: Nil)).bimap(union :: _, tpes => s"${union.self}<${tpes.mkString(", ")}>")
				case JavaList(name, dim) =>

					val list = Name.cls[java.util.List[_]]
					fmtTpe(name, boxed = true).bimap(list :: _, s => s"${list.self}<" * dim + s + ">" * dim)

				case JavaGeneric(name, parameters) =>
					val (rootNames, rootTpe) = fmtTpe(name)
					parameters.foldMap(fmtTpe(_).map(_ :: Nil)).bimap(rootNames ::: _, tpes => s"${rootTpe.self}<${tpes.mkString(", ")}>")
				case JavaRef(name)                 => Nil -> name
			}
		}


		def fmtParamList(xs: List[(Sym, JTypeContext[String])]): (List[Name], String) = xs.foldMap { case (sym, tpe) =>
			fmtInTpe(tpe, boxed = false).map(x => s"$x ${sym.value}" :: Nil)
		}.map(_.mkString(", "))


		def fmtTpeParamList(tpeParams: List[(Sym, Option[JTypeContext[String]])]): (List[Name], String) = tpeParams.foldMap {
			case (sym, None)    => (Nil, sym.value :: Nil)
			case (sym, Some(x)) => fmtTpe(x.value).map(x => s"${sym.value} extends $x" :: Nil)
		}.map {
			case Nil => ""
			case xs  => xs.mkString(" <", ", ", ">")
		}

		val file = tl.name.fragments.mkString_("", "/", ".java")


		def fmtEnum[A: Show](e: JEnum[String, A], valueTpeName: JType[String]) = {
			val (varTpeNames, varTpe)         = fmtTpe(valueTpeName, boxed = false)
			val (rtnTpeNames, rtnTpe)         = fmtTpe(valueTpeName, boxed = true)
			val (enumMarkerNames, enumMarker) = fmtTpe(JavaGeneric(JavaRef(JsEnum.self), Nel.one(valueTpeName))).leftMap(JsEnum :: _)
			s"""
			   |package ${e.name.normalisedPath};
			   |
			   |${fmtImports(varTpeNames ::: rtnTpeNames ::: enumMarkerNames)}
			   |
			   |${fmtDoc(e.doc)}
			   |@SuppressWarnings("unused")
			   |public enum ${e.name.self} implements $enumMarker {
			   |${e.entries.map(m => s"${fmtDoc(m.doc, indent = 1)}\n\t${m.name.value}(${m.value.show})").mkString(",\n")};
			   |	private final $varTpe value;
			   |	${e.name.self}($varTpe value) { this.value = value; }
			   |	public $rtnTpe value() { return value; }
			   |}
			   |""".stripMargin
		}

		def fmtCode(x: DelegationBody[String]) = {

			def fmtOutWrapper(t: JType[String]): String = {
				t match {
					case JavaVoid                           => s"ofVoid()"
					case p: JPrimitive                      => s"ofMapped(${p.format(false).value}.class)"
					case JType.JavaString                   => s"ofMapped(${Name.cls[String].self}.class)"
					case JType.JavaObject                   => s"ofMapped(${Name.cls[JSObject].self}.class)"
					case JavaLiteral(name)                  => name
					case JavaTypeVar(name)                  => "null " //  s"ofMapped(${Name.cls[JSObject].self}.class)" //  name.value
					case JavaList(name, dim)                =>   s"${"ofArray(" * dim}${fmtOutWrapper(name)}${")" * dim}"
					case JavaUnion(actual)                  => "null /*union*/"
					case JType.JavaIntersection(actual)     => "null /*intersection*/"
					case JavaGeneric(JavaRef(cls), _)       => s"$cls ::new" // java infers the rest
					case JavaRef(cls) if enums contains cls => s"ofJsEnum($cls.class)"
					case JavaRef(cls)                       => s"$cls::new"
				}
			}
			def fmtOutTpe(nullable: Boolean, expr: String) = {
				if (nullable) s"return Optional.ofNullable($expr);" else s"return $expr;"
			}


			def getter(prop: String, t: JTypeContext[String]) = {
				fmtOutTpe(t.nullable, s"""get("$prop", ${fmtOutWrapper(t.value)})""") :: Nil
			}

			def setter(prop: String, param: String, t: JTypeContext[String]) = {
				(t.value match {
					case JavaString | JavaObject | _: JPrimitive => s"""set("$prop", $param);"""
					case JavaLiteral(name)                       => ""
					case JavaTypeVar(name)                       => ""
					case JavaList(name, dim)                     => ""
					case JavaGeneric(name, parameters)           => ""
					case JavaUnion(actual)                       => s"""set("$prop", $param);"""
					case JavaRef(name) if enums contains name    => s"""set("$prop", $param);"""
					case JavaRef(_)                              => s"""set("$prop", $param);"""
				}) :: "return this;" :: Nil
			}


			(x match {
				case GetMember(name, tpe)        => getter(name.value, tpe)
				case SetMember(name, param, tpe) => setter(name.value, param.value, tpe)
				case Call(name, params, tpe)     =>
					val ps   = params.map(_._1.value) match {
						case Nil => ""
						case xs  => xs.mkString(", ", ", ", "")
					}
					val expr = s"""call("${name.value}", ${fmtOutWrapper(tpe.value)}$ps)"""
					(tpe.value match {
						case JavaVoid => s"$expr;"
						case _        => fmtOutTpe(tpe.nullable, expr)
					}) :: Nil
				case Raw(lines)                  => lines
			}) match {
				case Nil         => "{}"
				case line :: Nil => s"""{ $line }
									   |""".stripMargin
				case xs          => s"""{
									   |${xs.map("\t\t" + _).mkString("\n")}
									   |	}
									   |""".stripMargin
			}
		}

		file -> (tl.map(_.self) match {
			case JClass(name, tpeParams, parents, ctors, methods, doc) =>
				Apply[(List[Name], *)].map3(
					fmtTpeParamList(tpeParams),
					ctors.foldMap { case JCtor(params, code, doc) =>
						fmtParamList(params).map { ps =>
							s"""${fmtDoc(doc, indent = 1)}
							   |	public ${name.self}($ps) ${fmtCode(code)}
							   | """.stripMargin
						}
					},
					methods.foldMap { case JMethod(  Sym(name),  tpeParams, params, rtn, code, doc, _) =>
						Apply[(List[Name], *)].map3(
							fmtTpeParamList(tpeParams),
							fmtOutTpe(rtn, boxed = false),
							fmtParamList(params)) { (tps, r, ps) =>
							s"""${fmtDoc(doc, indent = 1)}
							   |	public$tps $r $name($ps) ${fmtCode(code)}
							   | """.stripMargin
						}
					}
				) { (tps, ctors, methods) =>
					val parent = parents.lastOption.foldMap("extends " + _)
					s"""
					   |${fmtDoc(doc)}
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
			case e@JEnum.JIntEnum(_, _, _)                             => fmtEnum(e, JavaInt)
			case e@JEnum.JStrEnum(_, _, _)                             => fmtEnum(e, JavaRef("String"))
		})
	}


}
