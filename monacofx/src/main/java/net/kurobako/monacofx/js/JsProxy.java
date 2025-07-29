package net.kurobako.monacofx.js;

import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.Nullable;

import netscape.javascript.JSException;
import netscape.javascript.JSObject;

public class JsProxy {

    public final JsContext ctx;
    public final Object receiver;

    public JsProxy(JsContext ctx, Object receiver) {
        this.ctx = Objects.requireNonNull(ctx);
        this.receiver = receiver;
    }

    public JsProxy(JsContext ctx) {
        this.ctx = Objects.requireNonNull(ctx);
        this.receiver = ctx.newObject();
    }

    public JSObject asJsObject() {
        return (JSObject) receiver;
    }


    protected <T> void setUnsafe(String key, T t) {
        asJsObject().setMember(key, t);
    }

    @SuppressWarnings("unchecked")
    protected <T> T getUnsafe(String key) {
        return receiver == null ? null : (T) asJsObject().getMember(key);
    }


    @SuppressWarnings("unchecked")
    public static <T, E extends Enum<E> & JsEnum<T>> BiFunction<JsContext, Object, E> ofJsEnum(Class<E> cls) {
        return (ctx, t) -> JsEnum.from(cls, (T) t).orElseThrow(() -> new RuntimeException("Unexpected enum value " + t + " for " + cls));
    }

    public static <T> BiFunction<JsContext, Object, T> ofVoid() {
        return (ctx, t) -> null;
    }

    public static <T> BiFunction<JsContext, Object, T> ofMapped(Class<T> cls) {
        return (ctx, t) -> {
            try {
                return cls.cast(t);
            } catch (ClassCastException e) {
                throw new RuntimeException(String.format("Unexpected conversion: need %s but got %s(`%s`)",
                        cls, t == null ? null : t.getClass(), t), e);
            }
        };
    }

    public static <T> BiFunction<JsContext, Object, List<T>> ofArray(BiFunction<JsContext, Object, T> f) {
        return (ctx, t) -> {
            JSObject array = (JSObject) t;
            return IntStream.range(0, (int) array.getMember("length"))
                    .mapToObj(array::getSlot)
                    .map(x -> f.apply(ctx, x))
                    .collect(Collectors.toList());
        };
    }


    public <T> void set(String key, @Nullable JsEnum<T> value) {
        setUnsafe(key, value == null ? null : value.value());
    }

    public void set(String key, @Nullable JsProxy proxy) {
        setUnsafe(key, proxy == null ? null : proxy.receiver);
    }

    public void set(String key, @Nullable JsUnion value) {
        setUnsafe(key, value == null ? null : value.unite());
    }

    public void set(String key, @Nullable JsTuple value) {
        setUnsafe(key, value == null ? null : value.elements());
    }

    public void set(String key, @Nullable Object value) {
        setUnsafe(key, value);
    }


    public <T> T get(String key, BiFunction<JsContext, Object, T> f) {
        Object v = getUnsafe(key);
        if (v == null) return null;
        return f.apply(ctx, v);
    }


    protected <T> List<T> getArray(JSObject array, BiFunction<JsContext, Object, T> f) {
        return IntStream.range(0, (int) array.getMember("length"))
                .mapToObj(array::getSlot)
                .map(x -> f.apply(ctx, x))
                .collect(Collectors.toList());
    }


    protected <T> List<T> getArray1D(String key, BiFunction<JsContext, Object, T> f) {
        JSObject array = getUnsafe(key);
        if (array == null) return null;
        return ofArray(f).apply(ctx, array);
    }

    protected <T> List<List<T>> getArray2D(String key, BiFunction<JsContext, Object, T> f) {
        JSObject array = getUnsafe(key);
        if (array == null) return null;
        return ofArray(ofArray(f)).apply(ctx, array);
    }


    private JSObject toJsArray(List<?> xs, UnaryOperator<Object> f) {
        JSObject array = (JSObject) ctx.engine.executeScript("[]");
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


    protected <T> T call(String methodName, BiFunction<JsContext, Object, T> out, Object... args) {
        Object[] unboxed = new Object[args.length];
        for (int i = 0; i < args.length; i++) unboxed[i] = unboxAll(args[i]);
        return out.apply(ctx, asJsObject().call(methodName, unboxed));
    }


    @Override
    public String toString() {
      try {
        if (receiver instanceof JSObject) {
          return "(" + getClass().getName() + ")" + ((JSObject) receiver).call("toString")
                  .toString();
        } else return receiver.toString();
      } catch (JSException e) {
        return e.toString();
      }
    }

}
