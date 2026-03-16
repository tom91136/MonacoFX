package net.kurobako.monacofx.js;

public interface JsCallback {
	JsCallback wrap();

	@FunctionalInterface interface JsCallback0 extends JsCallback {
		void accept();
		@Override default JsCallback wrap() { return new JsCallback0.Delegate(this); }
		class Delegate implements JsCallback0 {
			private final JsCallback0 x;
			public Delegate(JsCallback0 x) {this.x = x;}
			@Override public void accept() { x.accept(); }
		}
	}

	@FunctionalInterface interface JsCallback1<T0> extends JsCallback {
		void accept(T0 t0);
		@Override default JsCallback wrap() { return new JsCallback1.Delegate<>(this); }
		class Delegate<T0> implements JsCallback1<T0> {
			private final JsCallback1<T0> x;
			public Delegate(JsCallback1<T0> x) {this.x = x;}
			@Override public void accept(T0 t0) { x.accept(t0); }
		}
	}

	@FunctionalInterface interface JsCallback2<T0, T1> extends JsCallback {
		void accept(T0 t0, T1 t1);
		@Override default JsCallback wrap() { return new JsCallback2.Delegate<>(this); }
		class Delegate<T0, T1> implements JsCallback2<T0, T1> {
			private final JsCallback2<T0, T1> x;
			public Delegate(JsCallback2<T0, T1> x) {this.x = x;}
			@Override public void accept(T0 t0, T1 t1) { x.accept(t0, t1); }
		}
	}

}
