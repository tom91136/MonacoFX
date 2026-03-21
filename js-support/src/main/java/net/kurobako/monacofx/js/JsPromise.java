package net.kurobako.monacofx.js;

import java.util.function.BiFunction;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.kurobako.monacofx.js.JsCallback.JsCallback1;
import netscape.javascript.JSObject;

/**
 * A typed wrapper around a JavaScript {@code Promise} object.
 *
 * <p>Resolved values are converted to {@code T} via the provided lift function. Rejections are converted to
 * {@link Exception} with the JS error message and stack trace.
 *
 * <pre>{@code
 * new JsPromise<>(ctx, jsPromiseObject, JsProxy.ofMapped(String.class))
 *     .then(value -> System.out.println("resolved: " + value),
 *           error -> System.err.println("rejected: " + error.getMessage()));
 * }</pre>
 *
 * @param <T> the Java type of the resolved value
 */
public class JsPromise<T> extends JsProxy {

    private final BiFunction<JsContext, Object, T> lift;

    @SuppressWarnings("unchecked")
    private static <T> BiFunction<JsContext, Object, T> rawLift() {
        return (ctx, o) -> (T) o;
    }

    /** Wraps a JS Promise with raw (unlifted) resolution values. */
    public JsPromise(JsContext context, Object receiver) {
        super(context, receiver);
        this.lift = rawLift();
    }

    /** Wraps a JS Promise with a custom lift function for resolved values. */
    public JsPromise(
            @Nonnull JsContext context, @Nullable Object receiver, @Nullable BiFunction<JsContext, Object, T> lift) {
        super(context, receiver);
        this.lift = lift != null ? lift : rawLift();
    }

    /** Creates a new empty JS object and wraps it as a Promise with the given lift. */
    public JsPromise(@Nonnull JsContext context, @Nullable BiFunction<JsContext, Object, T> lift) {
        super(context);
        this.lift = lift != null ? lift : rawLift();
    }

    /** Registers a fulfilment handler, equivalent to JS {@code promise.then(onFulfilled)}. */
    @Nonnull
    public JsPromise<T> then(@Nonnull JsCallback1<T> fulfilled) {
        return invoke("then", (ctx, o) -> new JsPromise<>(ctx, o, lift), ctx.callback1(lift, fulfilled));
    }

    /**
     * Registers fulfilment and rejection handlers, equivalent to JS {@code promise.then(onFulfilled, onRejected)}.
     *
     * <p>The rejection handler receives an {@link Exception} with the JS error's message and stack.
     */
    @Nonnull
    public JsPromise<T> then(@Nonnull JsCallback1<T> fulfilled, @Nonnull JsCallback1<Exception> rejected) {
        return invoke(
                "then",
                (ctx, o) -> new JsPromise<>(ctx, o, lift),
                ctx.callback1(lift, fulfilled),
                ctx.callback1(
                        (ignored, jsErr) -> {
                            if (!(jsErr instanceof JSObject)) return new Exception("JS error: " + jsErr);
                            JSObject jsObj = (JSObject) jsErr;
                            try {
                                Object msg = jsObj.getMember("message");
                                Object stack = jsObj.getMember("stack");
                                String detail = msg != null && !"undefined".equals(msg)
                                        ? String.valueOf(msg)
                                        : String.valueOf(jsErr);
                                if (stack != null && !"undefined".equals(stack)) detail += "\n" + stack;
                                return new Exception(detail);
                            } catch (Exception e) {
                                return new Exception("JS error: " + jsErr, e);
                            }
                        },
                        rejected));
    }
}
