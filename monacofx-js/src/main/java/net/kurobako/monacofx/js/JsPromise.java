package net.kurobako.monacofx.js;

import net.kurobako.monacofx.js.JsCallback.JsCallback1;

import java.util.function.BiFunction;

public class JsPromise<T> extends JsProxy {

    private final BiFunction<JsContext, Object, T> lift;

    public JsPromise(JsContext context, Object receiver ) {
        super(context, receiver);
        this.lift = null;
    }

    public JsPromise(JsContext context, Object receiver, BiFunction<JsContext, Object, T> lift) {
        super(context, receiver);
        this.lift = lift;
    }

    public JsPromise(JsContext context, BiFunction<JsContext, Object, T> lift) {
        super(context);
        this.lift = lift;
    }

    public JsPromise<T> then(JsCallback1<T> fulfilled) {
        return call("then", (ctx, o) -> new JsPromise<>(ctx, o, lift), ctx.callback1(lift, fulfilled));
    }

    public JsPromise<T> then(JsCallback1<T> fulfilled, JsCallback1<Exception> rejected) {
        return call("then", (ctx, o) -> new JsPromise<>(ctx, o, lift),
                ctx.callback1(lift, fulfilled),
                ctx.callback1((ignored, jsObject) -> new Exception(), rejected));
    }

}
