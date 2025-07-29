package net.kurobako.monaco

import cats.data.NonEmptyVector
import cats.syntax.all._
import cats.{Order, Show}

import scala.reflect.ClassTag

object Ast {

	case class Sym(value: String) extends AnyVal {
		@inline def ++(that: String): Sym = new Sym(value ++ that)
		override def toString: String = s"'$value"
	}
	object Sym {
		implicit val show: Show[Sym] = (t: Sym) => t.value
		implicit val ord: Order[Sym] = Order.by(_.value)
		def unsafe(s: String): Sym = new Sym(s.replace("-", "_").ensuring(!_.isEmpty))
		def apply(s: String): ParseM[Sym] = {
			if (s.isEmpty) failF("Empty reference")
			else unsafe(s).pureF
		}
	}

	case class Name(fragments: Nev[Sym]) {
		def :+(that: Sym): Name = Name(fragments :+ that)
		def normalise: String = fragments.map(_.value).mkString_(".")
		def self: String = fragments.last.value
		def sym: Sym = fragments.last
		def path: Vector[String] = fragments.init.map(_.value)
		def normalisedPath:  String = fragments.init.map(_.value).mkString(".")
		def mapLast(f: Sym => Sym): Name = Name(fragments.init, f(fragments.last))
		override def toString: String = normalise
	}
	object Name {
		implicit val ord: Order[Name] = Order.by(_.fragments.toVector)
		def apply(xs: Vector[Sym], x: Sym): Name = new Name(NonEmptyVector.fromVectorUnsafe(xs :+ x))
		def apply(x: Sym, xs: Sym*): Name = new Name(NonEmptyVector(x, xs.toVector))
		def cls[A](implicit tag: ClassTag[A]): Name =
			new Name(NonEmptyVector.fromVectorUnsafe(tag.runtimeClass.getName.split('.').map(Sym.unsafe(_)).toVector))


		def cls(pkg  : String, cls : String): Name = {
			apply(pkg.split('.').map(Sym.unsafe(_)).toVector, Sym.unsafe(cls))
		}
	}

}
