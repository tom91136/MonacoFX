package net.kurobako.monaco

import cats.{Monad, Monoid, Traverse}
import cats.derived.*
import cats.syntax.all.*
import mouse.all.*
import net.kurobako.monaco.Ast.{Name, Sym}
import net.kurobako.monaco.TypeDoc.ReflectionFlag

import scala.collection.immutable.ArraySeq

object TsAst {

  enum TsName {
    case TsString, TsObject, TsBool, TsNum, TsNull, TsVoid, TsUndef, TsTrue, TsFalse, TsAny
    case TsTypeVar(name: Sym)
    case TsRef(name: Sym, id: Option[Int])
    case TsStringLiteral(value: String)
    case TsIntLiteral(value: Int)
  }

  enum TsType[+A] derives Traverse {
    case TsTerminal(tpe: A)
    case TsArray(repr: TsType[A])
    case TsTuple(components: List[TsType[A]])
    case TsTypeOf(eqiv: TsType[A])
    case TsGuard(isA: TsType[A])
    case TsStructural(fields: List[(String, TsType[A])])
    case TsIntersection(tpes: List[TsType[A]])
    case TsUnion(tpes: List[TsType[A]])
    case TsGeneric(tpe: TsType[A], bounds: List[TsType[A]])
  }
  object TsType {

    given Monad[TsType] = new Monad[TsType] {
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
      override def tailRecM[A, B](a: A)(f: A => TsType[Either[A, B]]): TsType[B] =
        // XXX FIXME not stack-safe
        flatMap(f(a)) {
          case Right(b) => pure(b)
          case Left(a)  => tailRecM(a)(f)
        }
      override def pure[A](x: A): TsTerminal[A] = TsTerminal(x)

    }

  }

  case class Source(fileName: String, line: Int, character: Int)
  case class Comment(shortText: Option[String], text: Option[String])
  case class Doc(
      lines: List[String],
      srcPosition: List[Source] = Nil,
      srcLine: List[String] = Nil
  ) derives Monoid

  case class Meta(
      id: Int,
      name: Sym,
      flags: Set[ReflectionFlag],
      sources: List[Source],
      comment: Option[Comment]
  ) {
    def enabled(flag: ReflectionFlag): Boolean = flags.contains(flag)
    def docLns(srcLns: ArraySeq[String]): Doc  = Doc(
      lines = comment.toList.flatMap { case Comment(shortText, text) =>
        (if (shortText == text) text else shortText ++ text).iterator.to(List)
      },
      srcPosition = sources,
      srcLine = sources.flatMap { case Source(_, line, _) => srcLns.lift(line - 1) }
    )

  }

  case class TsParameter[+A](
      name: Sym,
      tpe: A,
      vararg: Boolean,
      optional: Boolean,
      comment: Option[Comment]
  ) derives Traverse {
    override def toString: String = s"$name : $tpe${if (optional) "?" else ""}${if (vararg) "..." else ""}"
  }

  case class TsSignature[+A](
      tpeParams: List[(Sym, Option[A])],
      params: List[TsParameter[A]],
      returnTpe: A,
      doc: Doc
  ) derives Traverse {
    override def toString: String = s"(${params.mkString(",")}) : $returnTpe"
  }

  case class TsProperty[+A](name: Sym, tpe: A, readonly: Boolean, optional: Boolean, doc: Doc) {
    override def toString: String = s"(property) ${readonly ?? "readonly"} $name :${optional ?? "?"} $tpe "
  }

  case class TsAccessor[+A](name: Sym, tpe: A, kind: TsAccessorKind, doc: Doc)
  enum TsAccessorKind {
    case TsGetter, TsSetter, TsGetterAndSetter
  }
  case class TsCtor[+A](signatures: List[TsSignature[A]], inherited: Boolean) {
    override def toString: String = signatures.map("(ctor)" + _).mkString("\n")
  }
  case class TsMethod[+A](name: Sym, signatures: List[TsSignature[A]], static: Boolean, doc: Doc, inherited: Boolean)

  case class TsEnumEntry(symbol: Sym, ordinal: Int, doc: Doc)

  sealed trait TopLevelElem {
    def name: Name
    def id: Int
    def doc: Doc
  }

  sealed trait ClassLike[+A] extends TopLevelElem {
    def parents: List[Int]
    def typeParams: List[(Sym, Option[A])]
    def methods: List[TsMethod[A]]
    def properties: List[TsProperty[A]]
  }

  case class TsGlobal[+A](
      name: Name,
      id: Int,
      modules: List[TsModule[A]],
      variables: List[TsVariable[A]],
      doc: Doc
  ) extends TopLevelElem derives Traverse

  case class TsModule[+A](
      name: Name,
      id: Int,
      functions: List[TsFunction[A]],
      variables: List[TsVariable[A]],
      aliases: List[TsTypeAlias[A]],
      // XXX TODO events are functions
      enums: List[TsEnum[A]],
      classes: List[TsClass[A]],
      interfaces: List[TsInterface[A]],
      modules: List[TsModule[A]],
      doc: Doc
  ) extends TopLevelElem derives Traverse

  case class TsVariable[+A](
      name: Name,
      id: Int,
      tpe: A,
      const: Boolean,
      doc: Doc
  ) extends TopLevelElem derives Traverse {
    override def toString: String = s"(var) ${const ?? "const"} $name : $tpe"
  }
  case class TsFunction[+A](
      name: Name,
      id: Int,
      signatures: List[TsSignature[A]],
      doc: Doc
  ) extends TopLevelElem derives Traverse {
    override def toString: String = signatures.map(s => s"(func)$name$s").mkString("\n")
  }
  case class TsTypeAlias[+A](
      name: Name,
      id: Int,
      tpe: A,
      doc: Doc
  ) extends TopLevelElem derives Traverse
  case class TsEnum[+A](name: Name, id: Int, members: List[TsEnumEntry], doc: Doc) extends TopLevelElem derives Traverse

  case class TsClass[+A](
      name: Name,
      id: Int,
      parents: List[Int],
      typeParams: List[(Sym, Option[A])],
      constructors: List[TsCtor[A]],
      methods: List[TsMethod[A]],
      properties: List[TsProperty[A]],
      accessors: List[TsAccessor[A]],
      doc: Doc
  ) extends TopLevelElem with ClassLike[A] derives Traverse
  case class TsInterface[+A](
      name: Name,
      id: Int,
      parents: List[Int],
      typeParams: List[(Sym, Option[A])],
      methods: List[TsMethod[A]],
      properties: List[TsProperty[A]],
      doc: Doc,
      callSignatures: List[TsSignature[A]] = Nil
  ) extends TopLevelElem with ClassLike[A] derives Traverse

}
