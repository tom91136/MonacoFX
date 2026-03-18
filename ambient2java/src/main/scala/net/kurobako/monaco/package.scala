package net.kurobako

import cats.data.{NonEmptyList, NonEmptyVector, ValidatedNel}
import cats.syntax.all.*

package object monaco {

  type Nel[+A] = NonEmptyList[A]
  type Nev[+A] = NonEmptyVector[A]

  val Nel: NonEmptyList.type = NonEmptyList

  implicit class NonEmptyListOps[A](private val xs: NonEmptyList[A]) extends AnyVal {
    def distinctUniversal: NonEmptyList[A] = NonEmptyList.fromListUnsafe(xs.toList.distinct)
  }

  type ParseM[A] = Either[Throwable, A]
  type CheckM[A] = ValidatedNel[Throwable, A]

  def failF[A](reason: => String): ParseM[A] = new Exception(reason).asLeft[A]
  def fail[A](reason: => String)             = new Exception(reason)

  final implicit class ParseOps[A](private val obj: A) extends AnyVal {
    def pureF[B]: Either[B, A] = Right(obj)
  }

  final implicit class RichOption[A](private val maybe: Option[A]) extends AnyVal {
    def otherwise(reason: => String): ParseM[A] = maybe.toRight(new Exception(reason))
  }

  final implicit class RichParse[A](private val p: ParseM[A]) {
    def elaborate(s: => String): ParseM[A] = p.leftMap(e => new Exception(s, e))
    def dump: A                            =
      p match {
        case Left(e)  => throw new RuntimeException(e)
        case Right(x) => x
      }
  }

  final implicit class RichChecked[A](private val p: CheckM[A]) {
    def elaborate(s: => String): CheckM[A] = p.leftMap { e =>
      val ex = new Exception(s + "\n" + e.map(x =>
        x.getMessage + " -> " + Option(x.getCause).map(_.getMessage)
      ).mkString_("\t", "\n\t", ""))
      e.toList.foreach(ex.addSuppressed(_))
      NonEmptyList.one(ex)
    }
  }

  def crossJoin[A](list: List[List[A]]): List[List[A]] = list match {
    case Nil       => Nil
    case xs :: Nil => xs.map(List(_))
    case x :: xs   => for {
        i <- x
        j <- crossJoin(xs)
      } yield List(i) ++ j
  }

  def time[R](name: String)(block: => R): R = {
    val t0     = System.nanoTime()
    val result = block
    val t1     = System.nanoTime()
    println(s"$name : " + ((t1 - t0).toDouble / 1e6) + "ms")
    result
  }

}
