package net.kurobako.monacofx.js;

/**
 * Void-returning variants of {@link JsFn} for use as JavaScript callbacks.
 *
 * <p>Each callback extends the corresponding {@code JsFunctionN} with a convenience {@code accept(...)} method that
 * discards the return value.
 *
 * <pre>{@code
 * ctx.callback1(JsProxy.ofMapped(String.class), value -> System.out.println(value));
 * }</pre>
 */
public interface JsCallback {

    /** A zero-argument callback. */
    @FunctionalInterface
    interface JsCallback0 extends JsFunction0<Void> {
        void accept();

        @Override
        default Void invoke() {
            accept();
            return null;
        }
    }

    /** A single-argument callback. */
    @FunctionalInterface
    interface JsCallback1<T0> extends JsFunction1<T0, Void> {
        void accept(T0 t0);

        @Override
        default Void invoke(T0 t0) {
            accept(t0);
            return null;
        }
    }

    /** A two-argument callback. */
    @FunctionalInterface
    interface JsCallback2<T0, T1> extends JsFunction2<T0, T1, Void> {
        void accept(T0 t0, T1 t1);

        @Override
        default Void invoke(T0 t0, T1 t1) {
            accept(t0, t1);
            return null;
        }
    }
}
