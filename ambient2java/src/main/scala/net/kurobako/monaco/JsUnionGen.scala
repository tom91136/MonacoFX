package net.kurobako.monaco

object JsUnionGen {

  def apply(pkg: String, clsName: String, n: Int): Either[Throwable, (String, String)] =
    (0 until n).map("T" + _).toList match {
      case ts @ (t0 :: tn) =>
        val tpeParams = ts.mkString(", ")

        val classes = ts.zipWithIndex.map { case (t, i) =>
          val methods = ts.zipWithIndex.map {
            case (t, j) if i == j => s"\t@Override public Optional<$t> maybe$t() { return Optional.of(value); }"
            case (t, _)           => s"\t@Override public Optional<$t> maybe$t() { return Optional.empty(); }"
          }.mkString("\n")

          val wildcards = List.fill(n)("?").mkString(", ")

          s"""class ${t}Projection<$tpeParams> implements $clsName$n<$tpeParams>{
				   |	private final $t value;
				   |	private ${t}Projection($t value) {this.value = value;}
				   |$methods
				   |	@Override public String toString() { return "$clsName$n${t}Projection(" + value + ')'; }
				   |	@Override public boolean equals(Object o) {
				   |		if (this == o) return true;
				   |		if (o == null || getClass() != o.getClass()) return false;
				   |		${t}Projection<$wildcards> that = (${t}Projection<$wildcards>) o;
				   |		return Objects.equals(value, that.value);
				   |	}
				   |	@Override public int hashCode() { return Objects.hash(value); }
				   |}
				   |""".stripMargin
        }.map(_.linesWithSeparators.map("\t" + _).mkString).mkString("\n")

        val staticFactories = ts.map { t =>
          val name = t.toLowerCase
          s"\tstatic <$tpeParams> $clsName$n<$tpeParams> $name($t $name) { return new ${t}Projection<>($name); }"
        }.mkString("\n")

        val methods = ts.map { t =>
          s"""
				   |	Optional<$t> maybe$t();
				   |	default $t get$t() { return maybe$t().get(); }
				   |	default boolean is$t() { return maybe$t().isPresent(); }
				   |""".stripMargin
        }.mkString("\n")

        def foldChain(t: String) = s"maybe$t().map(if$t)"

        (s"${pkg.replace('.', '/')}/$clsName$n.java" ->
          s"""
				|package $pkg;
				|
				|import java.util.Objects;
				|import java.util.Optional;
				|import java.util.function.Function;
				|
				|@SuppressWarnings("OptionalGetWithoutIsPresent")
				|public interface $clsName$n<$tpeParams> extends $clsName{
				|
				|$staticFactories
				|$methods
				|	default <T> T fold(${ts.map(n => s"Function<? super $n, T> if$n").mkString(", ")}) {
				| 		return ${foldChain(t0)}
				|${tn.map(t => s"\t\t\t\t.or(() -> ${foldChain(t)})").mkString("\n")}
				|    			.orElseThrow(AssertionError::new);
				|	}
				|
				|	@Override default Object unite() { return fold(${(0 until n).map(_ => "Function.identity()").mkString(", ")}); }
				|
				|$classes
				|}
				|""".stripMargin).pureF

      case Nil => failF("n < 2")
    }

}
