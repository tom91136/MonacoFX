
package net.kurobako.monacofx.js;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

@SuppressWarnings("OptionalGetWithoutIsPresent")
public interface JsUnion2<T0, T1> extends JsUnion{

	static <T0, T1> JsUnion2<T0, T1> t0(T0 t0) { return new T0Projection<>(t0); }
	static <T0, T1> JsUnion2<T0, T1> t1(T1 t1) { return new T1Projection<>(t1); }

	Optional<T0> maybeT0();
	default T0 getT0() { return maybeT0().get(); }
	default boolean isT0() { return maybeT0().isPresent(); }


	Optional<T1> maybeT1();
	default T1 getT1() { return maybeT1().get(); }
	default boolean isT1() { return maybeT1().isPresent(); }

	default <T> T fold(Function<? super T0, T> ifT0, Function<? super T1, T> ifT1) {
 		return maybeT0().map(ifT0)
				.or(() -> maybeT1().map(ifT1))
    			.orElseThrow(AssertionError::new);
	}

	@Override default Object unite() { return fold(Function.identity(), Function.identity()); }

	class T0Projection<T0, T1> implements JsUnion2<T0, T1>{
		private final T0 value;
		private T0Projection(T0 value) {this.value = value;}
		@Override public Optional<T0> maybeT0() { return Optional.of(value); }
		@Override public Optional<T1> maybeT1() { return Optional.empty(); }
		@Override public String toString() { return "JsUnion2T0Projection(" + value + ')'; }
		@Override public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			T0Projection<?, ?> that = (T0Projection<?, ?>) o;
			return Objects.equals(value, that.value);
		}
		@Override public int hashCode() { return Objects.hash(value); }
	}

	class T1Projection<T0, T1> implements JsUnion2<T0, T1>{
		private final T1 value;
		private T1Projection(T1 value) {this.value = value;}
		@Override public Optional<T0> maybeT0() { return Optional.empty(); }
		@Override public Optional<T1> maybeT1() { return Optional.of(value); }
		@Override public String toString() { return "JsUnion2T1Projection(" + value + ')'; }
		@Override public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			T1Projection<?, ?> that = (T1Projection<?, ?>) o;
			return Objects.equals(value, that.value);
		}
		@Override public int hashCode() { return Objects.hash(value); }
	}

}
