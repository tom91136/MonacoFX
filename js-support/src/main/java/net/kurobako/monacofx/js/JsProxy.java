package net.kurobako.monacofx.js;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import netscape.javascript.JSException;
import netscape.javascript.JSObject;

/**
 * A typed Java wrapper around a JavaScript object accessed through {@link JsContext}.
 *
 * <p>Generated Java classes (derived from TypeScript {@code interface} and {@code class} definitions) extend this to
 * provide type-safe getters, setters, and method calls that are delegated to the underlying {@link JSObject} via
 * Liveconnect.
 *
 * <p>Values are converted between Java and JS using <em>lift functions</em> ({@code BiFunction<JsContext, Object, T>}).
 * Common lifts are available as static helpers:
 *
 * <ul>
 *   <li>{@link #ofMapped(Class)} &mdash; identity cast with Number-to-Double coercion
 *   <li>{@link #ofJsEnum(Class)} &mdash; reverse-lookup for {@link JsEnum} constants
 *   <li>{@link #ofArray(BiFunction)} &mdash; JS array ({@code T[]}) to {@link java.util.List}
 *   <li>{@link #ofVoid()} &mdash; always returns {@code null}
 * </ul>
 */
public class JsProxy {

    private static final String JS_UNDEFINED = "undefined";

    /** The {@link JsContext} this proxy belongs to. */
    public final JsContext ctx;

    /** The raw JS-side value (usually a {@link JSObject}, but may be {@code null}). */
    @Nullable
    public final Object receiver;

    /** Wraps an existing JS value. */
    public JsProxy(@Nonnull JsContext ctx, @Nullable Object receiver) {
        this.ctx = Objects.requireNonNull(ctx, "JsContext must not be null");
        this.receiver = receiver;
    }

    /** Creates a new empty JS object ({@code {}}) and wraps it. */
    public JsProxy(JsContext ctx) {
        this.ctx = Objects.requireNonNull(ctx, "JsContext must not be null");
        this.receiver = ctx.newObject();
    }

    /** Casts the receiver to {@link JSObject}, throwing if it is null or not a JSObject. */
    @Nonnull
    public JSObject asJsObject() {
        if (receiver == null)
            throw new IllegalStateException("receiver is null on " + getClass().getName());
        if (!(receiver instanceof JSObject))
            throw new IllegalStateException("receiver is " + receiver.getClass().getName() + ", not JSObject, on "
                    + getClass().getName());
        return (JSObject) receiver;
    }

    protected <T> void setUnsafe(String key, T t) {
        asJsObject().setMember(key, t);
    }

    @Nullable
    @SuppressWarnings("unchecked")
    protected <T> T getUnsafe(String key) {
        if (receiver == null) return null;
        Object v = asJsObject().getMember(key);
        if (JS_UNDEFINED.equals(v)) return null;
        return (T) v;
    }

    /**
     * Returns a lift function that reverse-maps a JS constant to the corresponding {@link JsEnum} member.
     *
     * @throws RuntimeException if no enum constant matches the JS value
     */
    @SuppressWarnings("unchecked")
    public static <T, E extends Enum<E> & JsEnum<T>> BiFunction<JsContext, Object, E> ofJsEnum(Class<E> cls) {
        return (ctx, t) -> JsEnum.from(cls, (T) t)
                .orElseThrow(() -> new RuntimeException("Unexpected enum value " + t + " for " + cls));
    }

    /** Returns a lift function that always returns {@code null} (for void JS methods). */
    public static <T> BiFunction<JsContext, Object, T> ofVoid() {
        return (ctx, t) -> null;
    }

    /**
     * Returns a lift function that casts the raw JS value to the given class.
     *
     * <p>Handles Liveconnect's Number quirk: JS numbers may arrive as {@link Integer} even when {@link Double} is
     * expected, so numeric values are coerced via {@link Number#doubleValue()}.
     *
     * @throws RuntimeException if the value is not {@code null} and cannot be cast
     */
    @SuppressWarnings("unchecked")
    public static <T> BiFunction<JsContext, Object, T> ofMapped(Class<T> cls) {
        return (ctx, t) -> {
            if (t == null) return null;
            // XXX Liveconnect returns Integer/Long for JS numbers even when Double is expected
            if (t instanceof Number && (cls == double.class || cls == Double.class))
                return (T) Double.valueOf(((Number) t).doubleValue());
            if (cls.isInstance(t)) return cls.cast(t);
            throw new RuntimeException(
                    String.format("Unexpected conversion: need %s but got %s(`%s`)", cls, t.getClass(), t));
        };
    }

    /**
     * Returns a lift function that converts a JS array into a Java {@link List}.
     *
     * @param f lift function applied to each element
     */
    public static <T> BiFunction<JsContext, Object, List<T>> ofArray(BiFunction<JsContext, Object, T> f) {
        return (ctx, t) -> {
            if (t == null) return null;
            if (!(t instanceof JSObject))
                throw new RuntimeException(
                        "Expected JS array but got " + t.getClass().getName() + ": " + t);
            JSObject array = (JSObject) t;
            Object len = array.getMember("length");
            if (len == null || JS_UNDEFINED.equals(len))
                throw new RuntimeException("JS object has no 'length' property -- not an array: " + t);
            return IntStream.range(0, ((Number) len).intValue())
                    .mapToObj(array::getSlot)
                    .map(x -> f.apply(ctx, x))
                    .collect(Collectors.toList());
        };
    }

    /** Sets a JS property to the enum's underlying value. */
    public <T> void set(String key, @Nullable JsEnum<T> value) {
        setUnsafe(key, value == null ? null : value.value());
    }

    /** Sets a JS property to the proxy's underlying receiver. */
    public void set(String key, @Nullable JsProxy proxy) {
        setUnsafe(key, proxy == null ? null : proxy.receiver);
    }

    /** Sets a JS property to the union's underlying value. */
    public void set(String key, @Nullable JsUnion value) {
        setUnsafe(key, value == null ? null : value.unite());
    }

    /** Sets a JS property to the tuple's elements as an array. */
    public void set(String key, @Nullable JsTuple value) {
        setUnsafe(key, value == null ? null : value.elements());
    }

    /** Sets a JS property to a JS array converted from the given list. */
    public void set(String key, @Nullable List<?> value) {
        setUnsafe(key, value == null ? null : toJsArray(value, this::unboxAll));
    }

    /** Sets a JS property to the given raw value. */
    public void set(String key, @Nullable Object value) {
        setUnsafe(key, value);
    }

    /**
     * Gets a JS property and converts it using the given lift function.
     *
     * @param f lift function; if {@code null}, the raw value is returned
     * @return the lifted value, or {@code null} if the property is absent or {@code undefined}
     */
    @Nullable
    @SuppressWarnings("unchecked")
    public <T> T get(String key, @Nullable BiFunction<JsContext, Object, T> f) {
        Object v = getUnsafe(key);
        if (v == null) return null;
        // XXX null lift = union type with no available converter; return raw
        if (f == null) return (T) v;
        try {
            return f.apply(ctx, v);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to lift property '" + key + "' on " + getClass().getName() + " (value=" + v + ", type="
                            + v.getClass().getName() + ")",
                    e);
        }
    }

    @Nullable
    protected <T> List<T> getArray1D(String key, BiFunction<JsContext, Object, T> f) {
        JSObject array = getUnsafe(key);
        return array == null ? null : ofArray(f).apply(ctx, array);
    }

    @Nullable
    protected <T> List<List<T>> getArray2D(String key, BiFunction<JsContext, Object, T> f) {
        JSObject array = getUnsafe(key);
        return array == null ? null : ofArray(ofArray(f)).apply(ctx, array);
    }

    private JSObject toJsArray(List<?> xs, UnaryOperator<Object> f) {
        JSObject array = ctx.newArray();
        for (int i = 0; i < xs.size(); i++) array.setSlot(i, f.apply(xs.get(i)));
        return array;
    }

    private Object unboxAll(Object arg) {
        if (arg instanceof JsEnum<?>) {
            return ((JsEnum<?>) arg).value();
        } else if (arg instanceof JsProxy) {
            return ((JsProxy) arg).receiver;
        } else if (arg instanceof JsUnion) {
            return ((JsUnion) arg).unite();
        } else if (arg instanceof JsTuple) {
            return ((JsTuple) arg).elements();
        } else if (arg instanceof List<?>) {
            return toJsArray((List<?>) arg, this::unboxAll);
        } else return arg;
    }

    private static final AtomicLong CB_COUNTER = new AtomicLong();

    @SuppressWarnings("unchecked")
    protected <T extends JsProxy> T bindCallback(String jsName, int arity, Object cb) {
        if (cb instanceof JsFn) cb = ((JsFn) cb).wrap();
        ctx.retainCallback(cb);
        String key = "__cb_" + CB_COUNTER.getAndIncrement() + "_" + jsName;
        ((JSObject) ctx.engine.executeScript("window")).setMember(key, cb);
        String args = IntStream.range(0, arity).mapToObj(i -> "a" + i).collect(Collectors.joining(","));
        ((JSObject) ctx.engine.executeScript(
                        "(function(r,k){r['" + jsName + "']=function(" + args + "){" + "try{return window[k].apply_("
                                + args + ");}" + "catch(e){console.error('[bindCallback] "
                                + jsName + ": '+e);throw e;}" + "};})"))
                .call("call", null, receiver, key);
        return (T) this;
    }

    @Nullable
    private <T> T liftResult(@Nullable BiFunction<JsContext, Object, T> out, Object result, String debugLabel) {
        if (JS_UNDEFINED.equals(result)) result = null;
        if (result == null || out == null) return null;
        try {
            return out.apply(ctx, result);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to lift result of " + debugLabel + " (value=" + result + ", type="
                            + result.getClass().getName() + ")",
                    e);
        }
    }

    @Nullable
    protected <T> T call(String methodName, @Nullable BiFunction<JsContext, Object, T> out, Object... args) {
        Object[] unboxed = new Object[args.length];
        for (int i = 0; i < args.length; i++) unboxed[i] = unboxAll(args[i]);
        return liftResult(
                out, asJsObject().call(methodName, unboxed), getClass().getName() + "." + methodName + "()");
    }

    // XXX invokes receiver as a JS function via Function.prototype.call(null, ...args)
    @Nullable
    protected <T> T invokeThis(@Nullable BiFunction<JsContext, Object, T> out, Object... args) {
        Object[] callArgs = new Object[args.length + 1];
        callArgs[0] = null;
        for (int i = 0; i < args.length; i++) callArgs[i + 1] = unboxAll(args[i]);
        return liftResult(
                out,
                asJsObject().call("call", callArgs),
                "invokeThis on " + getClass().getName());
    }

    @Override
    public String toString() {
        if (receiver == null) return "(" + getClass().getName() + ")null";
        try {
            if (receiver instanceof JSObject) {
                return "(" + getClass().getName() + ")" + ((JSObject) receiver).call("toString");
            } else return "(" + getClass().getName() + ")" + receiver;
        } catch (JSException e) {
            return "(" + getClass().getName() + ")error:" + e.getMessage();
        }
    }
}
