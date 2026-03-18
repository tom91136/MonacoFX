package net.kurobako.monacofx.js;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiFunction;
import javafx.scene.web.WebEngine;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsCallback.JsCallback0;
import net.kurobako.monacofx.js.JsCallback.JsCallback1;
import net.kurobako.monacofx.js.JsCallback.JsCallback2;
import netscape.javascript.JSObject;

/**
 * Bridge between Java and a {@link WebEngine}'s JavaScript runtime.
 *
 * <p>A {@code JsContext} manages the lifecycle of Java objects exposed to JS. WebEngine holds only weak references to
 * Java callbacks, so this class retains strong references to prevent GC.
 *
 * <p>Typical usage:
 *
 * <pre>{@code
 * WebEngine engine = webView.getEngine();
 * JsContext ctx = new JsContext(engine);
 *
 * // call JS from Java
 * ctx.window.call("alert", JsProxy.ofVoid(), "Hello from Java!");
 *
 * // pass a Java callback to JS
 * JSObject listener = ctx.callback1(JsProxy.ofMapped(String.class), value -> {
 *     System.out.println("JS sent: " + value);
 * });
 * }</pre>
 */
public class JsContext {

    private static final String MK_FN_NAME = "__mkJavaFn_";

    /** The underlying {@link WebEngine} for this context. */
    public final WebEngine engine;

    /** A {@link JsProxy} wrapping the global {@code window} object. */
    public final JsProxy window;

    // XXX callbackMap prevents GC of Java objects exposed to JS (WebEngine only holds weak refs)
    private final Set<Object> callbackMap = new HashSet<>();

    /**
     * Creates a new context for the given engine.
     *
     * <p>Installs a helper function on {@code window} that converts Java {@link JsFn} delegates into callable JS
     * functions.
     *
     * @param engine a fully-loaded {@link WebEngine}
     */
    @SuppressWarnings("this-escape")
    public JsContext(WebEngine engine) {
        this.engine = engine;
        this.window = new JsProxy(this, engine.executeScript("window"));
        // XXX installs window.__mkJavaFn_: wraps apply_()-bearing Java objects into JS functions
        this.window
                .asJsObject()
                .eval(String.format("this.%s = (f) => function() { return f.apply_(...arguments); };", MK_FN_NAME));
    }

    /** Prevents {@code obj} from being garbage-collected while this context is alive. */
    public void retainCallback(Object obj) {
        callbackMap.add(obj);
    }

    /**
     * Wraps a {@link JsFn} into a callable JavaScript function object.
     *
     * <p>The returned {@link JSObject} can be passed as a callback argument to any JS API.
     */
    @Nonnull
    public JSObject wrapFn(@Nonnull JsFn fn) {
        var wrapped = fn.wrap();
        callbackMap.add(wrapped);
        return window.call(MK_FN_NAME, JsProxy.ofMapped(JSObject.class), wrapped);
    }

    /** Wraps a zero-argument Java callback into a JS function. */
    @Nonnull
    public JSObject callback0(@Nonnull JsCallback0 cb) {
        return wrapFn(cb);
    }

    /**
     * Wraps a single-argument Java callback into a JS function.
     *
     * @param lift0 converts the raw JS argument to {@code T0}
     * @param cb the callback to invoke
     */
    @Nonnull
    public <T0> JSObject callback1(@Nonnull BiFunction<JsContext, Object, T0> lift0, @Nonnull JsCallback1<T0> cb) {
        return wrapFn((JsFunction1<Object, Void>) t0 -> {
            try {
                cb.accept(lift0.apply(this, t0));
            } catch (Exception e) {
                System.err.println("[JsContext] callback1 error: " + e);
                e.printStackTrace(System.err);
                throw e;
            }
            return null;
        });
    }

    /**
     * Wraps a two-argument Java callback into a JS function.
     *
     * @param lift0 converts the first raw JS argument
     * @param lift1 converts the second raw JS argument
     * @param cb the callback to invoke
     */
    @Nonnull
    public <T0, T1> JSObject callback2(
            @Nonnull BiFunction<JsContext, Object, T0> lift0,
            @Nonnull BiFunction<JsContext, Object, T1> lift1,
            @Nonnull JsCallback2<T0, T1> cb) {
        return wrapFn((JsFunction2<Object, Object, Void>) (t0, t1) -> {
            try {
                cb.accept(lift0.apply(this, t0), lift1.apply(this, t1));
            } catch (Exception e) {
                System.err.println("[JsContext] callback2 error: " + e);
                e.printStackTrace(System.err);
                throw e;
            }
            return null;
        });
    }

    /** Creates a new empty JavaScript object ({@code {}}). */
    @Nonnull
    public JSObject newObject() {
        return (JSObject) engine.executeScript("new Object();");
    }

    /** Creates a new empty JavaScript array ({@code []}). */
    @Nonnull
    public JSObject newArray() {
        return (JSObject) engine.executeScript("[]");
    }

    /**
     * Wraps a single-argument Java function into a callable JS function that returns a value.
     *
     * <p>Unlike {@link #callback1}, this preserves the return value so JS can use it.
     *
     * <pre>{@code
     * JSObject doubler = ctx.fn1((JsFunction1<Object, Object>) x -> ((Number) x).intValue() * 2);
     * }</pre>
     */
    public <A, R> JSObject fn1(@Nonnull JsFunction1<A, R> fn) {
        return wrapFn(fn);
    }
}
