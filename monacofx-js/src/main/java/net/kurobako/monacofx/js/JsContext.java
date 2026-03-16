package net.kurobako.monacofx.js;

import net.kurobako.monacofx.js.JsCallback.JsCallback0;
import net.kurobako.monacofx.js.JsCallback.JsCallback1;
import net.kurobako.monacofx.js.JsCallback.JsCallback2;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiFunction;

import javafx.scene.web.WebEngine;
import netscape.javascript.JSObject;

public class JsContext {

    public static BiFunction<JsContext, Object, JSObject> LIFT_JSOBJECT = (ignored, obj) -> (JSObject) obj;

    private static final String MK_CALLBACK_FN_NAME = "__mkJavaCallback_";
    public final WebEngine engine;
    public final JsProxy window;

    public JsContext(WebEngine engine) {
        this.engine = engine;
        this.window = new JsProxy(this, engine.executeScript("window"));
        this.window.asJsObject().eval(String.format("this.%s = (f) => {  return function() { %s %s }  };",
                MK_CALLBACK_FN_NAME,
                "let args = arguments.length === f.accept.length ? arguments : Array.from(arguments).slice(0, f.accept.length);",
                "f.accept(...args);"
        ));

    }

    private final Set<JsCallback> callbackMap = new HashSet<>();


    private JSObject callback(JsCallback cb) {
        var delegated = cb.wrap();
        callbackMap.add(delegated);
        return window.call(MK_CALLBACK_FN_NAME, JsProxy.ofMapped(JSObject.class), delegated);
    }

    public JSObject callback0(JsCallback0 cb) {
        return callback(cb);
    }

    public <T0> JSObject callback1(BiFunction<JsContext, Object, T0> lift0, JsCallback1<T0> cb) {
        return callback((JsCallback1<Object>) t0 -> cb.accept(lift0.apply(this, t0)));
    }

    public <T0, T1> JSObject callback2(BiFunction<JsContext, Object, T0> lift0,
                                       BiFunction<JsContext, Object, T1> lift1,
                                       JsCallback2<T0, T1> cb) {
        return callback((JsCallback2<Object, Object>) (t0, t1) -> cb.accept(
                lift0.apply(this, t0),
                lift1.apply(this, t1)));
    }

    public JSObject newObject() {
        return (JSObject) engine.executeScript("new Object();");
    }
}
