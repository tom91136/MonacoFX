package net.kurobako.monaco

import cats.syntax.all._
import cats.{Applicative, Eval, Monad, Monoid, Show, Traverse}
import mouse.all._
import net.kurobako.monaco.Ast.{Name, Sym}
import net.kurobako.monaco.TsAst.ClassLike.{TsClass, TsInterface}
import net.kurobako.monaco.TsAst.TsAccessor.TsAccessorKind
import net.kurobako.monaco.TsAst.TsEnum.TsEnumEntry
import net.kurobako.monaco.TypeDoc.{ReflectionFlag, ReflectionKind}
import ujson.Value.Value

import scala.collection.immutable.ArraySeq

object TsAst {


	sealed trait TsName
	object TsName {
		case object TsString extends TsName
		case object TsObject extends TsName
		case object TsBool extends TsName
		case object TsNum extends TsName
		case object TsNull extends TsName
		case object TsVoid extends TsName
		case object TsUndef extends TsName
		case object TsTrue extends TsName
		case object TsFalse extends TsName
		case object TsAny extends TsName
		case class TsTypeVar(name: Sym) extends TsName
		case class TsRef(name: Sym, id: Option[Int]) extends TsName
		case class TsStringLiteral(value: String) extends TsName
		case class TsIntLiteral(value: Int) extends TsName
	}

	sealed trait TsType[+A]
	object TsType {
		case class TsTerminal[+A](tpe: A) extends TsType[A]
		case class TsArray[+A](repr: TsType[A]) extends TsType[A]
		case class TsTuple[+A](components: List[TsType[A]]) extends TsType[A]
		case class TsTypeOf[+A](eqiv: TsType[A]) extends TsType[A]
		case class TsGuard[+A](isA: TsType[A]) extends TsType[A]
		case class TsStructural[+A](fields: List[(String, TsType[A])]) extends TsType[A]
		case class TsIntersection[+A](tpes: List[TsType[A]]) extends TsType[A]
		case class TsUnion[+A](tpes: List[TsType[A]]) extends TsType[A]
		case class TsGeneric[+A](tpe: TsType[A], bounds: List[TsType[A]]) extends TsType[A]

		implicit val monad: Monad[TsType] with Traverse[TsType] = new Monad[TsType] with Traverse[TsType] {
			private val traverse: Traverse[TsType] = cats.derived.semi.traverse

			override def flatMap[A, B](fa: TsType[A])(f: A => TsType[B]): TsType[B] = fa match {
				case TsTerminal(tpe)        => f(tpe)
				case TsArray(repr)          => TsArray(flatMap(repr)(f))
				case TsTuple(components)    => TsTuple(components.map(flatMap(_)(f)))
				case TsTypeOf(eqiv)         => TsTypeOf(flatMap(eqiv)(f))
				case TsGuard(isA)           => TsGuard(flatMap(isA)(f))
				case TsStructural(fields)   => TsStructural(fields.map(_.map(flatMap(_)(f))))
				case TsIntersection(tpes)   => TsIntersection(tpes.map(flatMap(_)(f)))
				case TsUnion(tpes)          => TsUnion(tpes.map(flatMap(_)(f)))
				case TsGeneric(tpe, bounds) => TsGeneric(flatMap(tpe)(f), bounds.map(flatMap(_)(f)))
			}
			override def tailRecM[A, B](a: A)(f: A => TsType[Either[A, B]]): TsType[B] = {
				// FIXME provide a stack-safe imp.
				flatMap(f(a)) {
					case Right(b) => pure(b)
					case Left(a)  => tailRecM(a)(f)
				}
			}
			override def pure[A](x: A) = TsTerminal(x)
			override def traverse[G[_], A, B](fa: TsType[A])(f: A => G[B])(implicit evidence$1: Applicative[G]) = traverse.traverse(fa)(f)
			override def foldLeft[A, B](fa: TsType[A], b: B)(f: (B, A) => B) = traverse.foldLeft(fa, b)(f)
			override def foldRight[A, B](fa: TsType[A], lb: Eval[B])(f: (A, Eval[B]) => Eval[B]) = traverse.foldRight(fa, lb)(f)
		}


	}


	case class Source(fileName: String, line: Int, character: Int)
	case class Comment(shortText: Option[String], text: Option[String])
	case class Doc(lines: List[String], srcPosition: List[Source] = Nil, srcLine: List[String] = Nil)
	object Doc {
		implicit val monoid: Monoid[Doc] = /*_*/ cats.derived.semi.monoid /*_*/
	}
	case class Meta(id: Int, name: Sym,
					kind: ReflectionKind, flags: Map[ReflectionFlag, Boolean],
					sources: List[Source], comment: Option[Comment]) {
		def enabled(flag: ReflectionFlag): Boolean = flags.getOrElse(flag, false)
		def docLns(srcLns: ArraySeq[String]): Doc = Doc(
			lines = comment.toList.flatMap { case Comment(shortText, text) =>
				(if (shortText == text) text else shortText ++ text).iterator.to(List)
			},
			srcPosition = sources,
			srcLine = sources.flatMap { case Source(_, line, _) => srcLns.lift(line - 1) })

	}

	case class TopLevel(meta: Meta, value: Value)


	case class TsParameter[+A](name: Sym, tpe: A, vararg: Boolean, optional: Boolean, comment: Option[Comment]) {
		override def toString: String = s"$name : $tpe${if (optional) "?" else ""}${if (vararg) "..." else ""}"
	}
	object TsParameter {
		implicit val traverse: Traverse[TsParameter] = cats.derived.semi.traverse

	}
	case class TsSignature[+A](tpeParams: List[(Sym, Option[A])], params: List[TsParameter[A]], returnTpe: A, doc: Doc) {
		override def toString: String = s"(${params.mkString(",")}) : $returnTpe"
	}
	object TsSignature {
		implicit val traverse: Traverse[TsSignature] = cats.derived.semi.traverse
	}

	case class TsProperty[+A](name: Sym, tpe: A, readonly: Boolean, optional: Boolean, doc: Doc) {
		override def toString: String = s"(property) ${readonly ?? "readonly"} $name :${optional ?? "?"} $tpe "
	}

	case class TsAccessor[+A](name: Sym, tpe: A, kind: TsAccessorKind, doc: Doc)
	object TsAccessor {
		sealed trait TsAccessorKind
		case object TsGetter extends TsAccessorKind
		case object TsSetter extends TsAccessorKind
		case object TsGetterAndSetter extends TsAccessorKind

	}
	case class TsCtor[+A](signatures: List[TsSignature[A]], inherited: Boolean) {
		override def toString: String = signatures.map("(ctor)" + _).mkString("\n")
	}
	case class TsMethod[+A](name: Sym, signatures: List[TsSignature[A]], static: Boolean, doc: Doc, inherited: Boolean)


	sealed trait TopLevelElem[+A] {
		def name: Name
		def id: Int
		def doc: Doc
	}
	object TopLevelElem {
		implicit def show[A <: TopLevelElem[_]]: Show[A] = Show.fromToString
		//	implicit def ord[A]: Eq[TopLevel[A]] = Eq.fromUniversalEquals
		implicit val traverse: Traverse[TopLevelElem] = cats.derived.semi.traverse
	}

	case class TsGlobal[+A](name: Name, id: Int,
							modules: List[TsModule[A]],
							variables: List[TsVariable[A]],
							doc: Doc) extends TopLevelElem[A]
	object TsGlobal {
		implicit val traverse: Traverse[TsGlobal] = cats.derived.semi.traverse
	}

	case class TsModule[+A](name: Name, id: Int,
							functions: List[TsFunction[A]],
							variables: List[TsVariable[A]],
							aliases: List[TsTypeAlias[A]],
							// TODO events are functions
							enums: List[TsEnum[A]],
							classes: List[TsClass[A]],
							interfaces: List[TsInterface[A]],
							modules : List[TsModule[A]],
							doc: Doc) extends TopLevelElem[A]


	case class TsVariable[+A](name: Name, id: Int, tpe: A, const: Boolean, doc: Doc) extends TopLevelElem[A] {
		override def toString: String = s"(var) ${const ?? "const"} $name : $tpe"
	}
	case class TsFunction[+A](name: Name, id: Int, signatures: List[TsSignature[A]], doc: Doc) extends TopLevelElem[A] {
		override def toString: String = signatures.map(s => s"(func)$name$s").mkString("\n")
	}
	case class TsTypeAlias[+A](name: Name, id: Int, tpe: A, doc: Doc) extends TopLevelElem[A]
	case class TsEnum[+A](name: Name, id: Int, members: List[TsEnumEntry], doc: Doc) extends TopLevelElem[A]
	object TsEnum {
		case class TsEnumEntry(symbol: Sym, ordinal: Int, doc: Doc)
	}

	sealed trait ClassLike[+A] extends TopLevelElem[A] {
		def parents: List[Int]
		def typeParams: List[(Sym, Option[A])]
		def methods: List[TsMethod[A]]
		def properties: List[TsProperty[A]]
	}
	object ClassLike {
		implicit val traverse: Traverse[ClassLike] = cats.derived.semi.traverse

		case class TsClass[+A](name: Name, id: Int, parents: List[Int],
							   typeParams: List[(Sym, Option[A])],
							   constructors: List[TsCtor[A]],
							   methods: List[TsMethod[A]],
							   properties: List[TsProperty[A]],
							   accessors: List[TsAccessor[A]],
							   doc: Doc) extends ClassLike[A]
		case class TsInterface[+A](name: Name, id: Int, parents: List[Int],
								   typeParams: List[(Sym, Option[A])],
								   methods: List[TsMethod[A]],
								   properties: List[TsProperty[A]],
								   doc: Doc) extends ClassLike[A]
	}




}
