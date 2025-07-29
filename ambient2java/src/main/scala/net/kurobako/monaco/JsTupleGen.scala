package net.kurobako.monaco

object JsTupleGen {

	def apply(pkg: String, clsName: String, n: Int): Either[Throwable, (String, String)] = (0 until n).map("T" + _).toList match {
		case Nil         => failF("Empty")
		case ts@(_ :: _) =>

			val tpeParams = ts.mkString(", ")
			val wildcards = List.fill(n)("?").mkString(", ")

			val vars = ts.map(t => t -> t.toLowerCase)

			val fields = vars.map { case (t, n) => s"\tpublic final $t $n;" }.mkString("\n")
			val params = vars.map { case (t, n) => s"$t $n" }.mkString(", ")

			val getters = vars.map { case (t, n) => s"\tpublic $t $n() { return $n; }" }.mkString("\n")

			(s"${pkg.replace('.', '/')}/$clsName$n.java" ->
			 s"""
				|package $pkg;
				|import java.util.Arrays;
				|import java.util.List;
				|import java.util.Objects;
				|public final class $clsName$n<$tpeParams> implements $clsName{
				|
				|$fields
				|
				|	public $clsName$n($params) { ${vars.map { case (_, n) => s"this.$n = $n;" }.mkString(" ")} }
				|$getters
				|
				|	@Override public List<Object> elements() { return Arrays.asList(${vars.map { case (_, n) => n }.mkString(", ")}); }
				|
				|	@Override public boolean equals(Object o) {
				|		if (this == o) return true;
				|		if (o == null || getClass() != o.getClass()) return false;
				|		$clsName$n<$wildcards> that = ($clsName$n<$wildcards>) o;
				|		return ${vars.map(x => s"Objects.equals(${x._2}, that.${x._2})").mkString("&&")};
				|	}
				|	@Override public int hashCode() { return Objects.hash(${vars.map(_._2).mkString(", ")}); }
				|	@Override public String toString() { return "$clsName$n(" + ${vars.map(_._2).mkString("""+ ", " +""")} + ')'; }
				|}
				|
				|""".stripMargin).pureF
	}


}
