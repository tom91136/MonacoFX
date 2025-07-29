
package net.kurobako.monacofx.js;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
public final class JsTuple4<T0, T1, T2, T3> implements JsTuple{

	public final T0 t0;
	public final T1 t1;
	public final T2 t2;
	public final T3 t3;

	public JsTuple4(T0 t0, T1 t1, T2 t2, T3 t3) { this.t0 = t0; this.t1 = t1; this.t2 = t2; this.t3 = t3; }
	public T0 t0() { return t0; }
	public T1 t1() { return t1; }
	public T2 t2() { return t2; }
	public T3 t3() { return t3; }

	@Override public List<Object> elements() { return Arrays.asList(t0, t1, t2, t3); }

	@Override public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		JsTuple4<?, ?, ?, ?> that = (JsTuple4<?, ?, ?, ?>) o;
		return Objects.equals(t0, that.t0)&&Objects.equals(t1, that.t1)&&Objects.equals(t2, that.t2)&&Objects.equals(t3, that.t3);
	}
	@Override public int hashCode() { return Objects.hash(t0, t1, t2, t3); }
	@Override public String toString() { return "JsTuple4(" + t0+ ", " +t1+ ", " +t2+ ", " +t3 + ')'; }
}

