package net.kurobako.monacofx.js;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
public final class JsTuple2<T0, T1> implements JsTuple{

	public final T0 t0;
	public final T1 t1;

	public JsTuple2(T0 t0, T1 t1) { this.t0 = t0; this.t1 = t1; }
	public T0 t0() { return t0; }
	public T1 t1() { return t1; }

	@Override public List<Object> elements() { return Arrays.asList(t0, t1); }

	@Override public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		JsTuple2<?, ?> that = (JsTuple2<?, ?>) o;
		return Objects.equals(t0, that.t0)&&Objects.equals(t1, that.t1);
	}
	@Override public int hashCode() { return Objects.hash(t0, t1); }
	@Override public String toString() { return "JsTuple2(" + t0+ ", " +t1 + ')'; }
}

