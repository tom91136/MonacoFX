package net.kurobako.monacofx.js;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class JsInteropIntegrationTest {

    private static JsContext ctx;

    @BeforeAll
    static void setup() throws Exception {
        boolean isLinux = System.getProperty("os.name", "").toLowerCase().contains("linux");
        if (isLinux) {
            String display = System.getenv("DISPLAY");
            assumeTrue(
                    display != null && !display.isBlank(),
                    "Skipping: no DISPLAY set (WebView requires a real or virtual display, use xvfb-run in CI)");
        }

        CountDownLatch latch = new CountDownLatch(1);
        try {
            Platform.startup(latch::countDown);
        } catch (IllegalStateException alreadyRunning) {
            latch.countDown();
        }
        if (!latch.await(15, TimeUnit.SECONDS)) throw new AssertionError("JavaFX platform startup timed out");

        CountDownLatch ready = new CountDownLatch(1);
        AtomicReference<JsContext> ref = new AtomicReference<>();
        AtomicReference<Stage> stage = new AtomicReference<>();
        AtomicReference<Throwable> error = new AtomicReference<>();

        Platform.runLater(() -> {
            try {
                WebView wv = new WebView();
                WebEngine eng = wv.getEngine();
                eng.loadContent("<html><body></body></html>");

                eng.getLoadWorker().stateProperty().addListener((obs, old, state) -> {
                    if (state == javafx.concurrent.Worker.State.SUCCEEDED) {
                        try {
                            ref.set(new JsContext(eng));
                        } catch (Throwable t) {
                            error.set(t);
                        }
                        ready.countDown();
                    }
                });

                stage.set(new Stage());
                stage.get().setScene(new Scene(new StackPane(wv), 200, 200));
            } catch (Throwable t) {
                error.set(t);
                ready.countDown();
            }
        });

        if (!ready.await(30, TimeUnit.SECONDS)) throw new AssertionError("WebEngine setup timed out");
        if (error.get() != null) throw new RuntimeException("Setup failed", error.get());

        ctx = ref.get();
        assertThat(ctx).isNotNull();
    }

    @AfterAll
    static void tearDown() {
        Thread t = new Thread(Platform::exit);
        t.setDaemon(true);
        t.start();
    }

    private static <T> T runOnFx(FxCallable<T> task) throws Exception {
        CompletableFuture<T> future = new CompletableFuture<>();
        Platform.runLater(() -> {
            try {
                future.complete(task.call());
            } catch (Throwable t) {
                future.completeExceptionally(t);
            }
        });
        return future.get(15, TimeUnit.SECONDS);
    }

    @FunctionalInterface
    private interface FxCallable<T> {
        T call() throws Exception;
    }

    @Test
    void newObjectCreatesEmptyJsObject() throws Exception {
        assertThat(runOnFx(() -> ctx.newObject())).isNotNull();
    }

    @Test
    void newArrayCreatesEmptyJsArray() throws Exception {
        assertThat(runOnFx(() -> ((Number) ctx.newArray().getMember("length")).intValue()))
                .isEqualTo(0);
    }

    @Test
    void setAndGetString() throws Exception {
        assertThat(runOnFx(() -> {
                    JsProxy p = new JsProxy(ctx);
                    p.set("foo", "hello");
                    return p.get("foo", JsProxy.ofMapped(String.class));
                }))
                .isEqualTo("hello");
    }

    @Test
    void setAndGetDouble() throws Exception {
        assertThat(runOnFx(() -> {
                    JsProxy p = new JsProxy(ctx);
                    p.set("num", 42.5);
                    return p.get("num", JsProxy.ofMapped(Double.class));
                }))
                .isEqualTo(42.5);
    }

    @Test
    void setAndGetInteger() throws Exception {
        assertThat(runOnFx(() -> {
                    JsProxy p = new JsProxy(ctx);
                    p.set("n", 7);
                    return p.get("n", JsProxy.ofMapped(Double.class));
                }))
                .isEqualTo(7.0);
    }

    @Test
    void setAndGetBoolean() throws Exception {
        assertThat((boolean) runOnFx(() -> {
                    JsProxy p = new JsProxy(ctx);
                    p.set("flag", true);
                    return p.get("flag", JsProxy.ofMapped(Boolean.class));
                }))
                .isTrue();
    }

    @Test
    void setNullReturnsNull() throws Exception {
        assertThat(runOnFx(() -> {
                    JsProxy p = new JsProxy(ctx);
                    p.set("x", (Object) null);
                    return p.get("x", JsProxy.ofMapped(String.class));
                }))
                .isNull();
    }

    @Test
    void getMissingPropertyReturnsNull() throws Exception {
        assertThat(runOnFx(() -> new JsProxy(ctx).get("nonexistent", JsProxy.ofMapped(String.class))))
                .isNull();
    }

    @Test
    void setAndGetNestedProxy() throws Exception {
        assertThat(runOnFx(() -> {
                    JsProxy inner = new JsProxy(ctx);
                    inner.set("val", "nested");
                    JsProxy outer = new JsProxy(ctx);
                    outer.set("child", inner);
                    return outer.get("child", JsProxy::new).get("val", JsProxy.ofMapped(String.class));
                }))
                .isEqualTo("nested");
    }

    @Test
    void setListCreatesJsArray() throws Exception {
        assertThat(runOnFx(() -> {
                    JsProxy p = new JsProxy(ctx);
                    p.set("items", List.of("a", "b", "c"));
                    return ((Number) ((JSObject) p.getUnsafe("items")).getMember("length")).intValue();
                }))
                .isEqualTo(3);
    }

    @Test
    void setListRoundTripsValues() throws Exception {
        assertThat(runOnFx(() -> {
                    JsProxy p = new JsProxy(ctx);
                    p.set("items", List.of("alpha", "beta", "gamma"));
                    return p.getArray1D("items", JsProxy.ofMapped(String.class));
                }))
                .containsExactly("alpha", "beta", "gamma");
    }

    @Test
    void setEmptyListCreatesEmptyArray() throws Exception {
        assertThat(runOnFx(() -> {
                    JsProxy p = new JsProxy(ctx);
                    p.set("empty", List.of());
                    return ((Number) ((JSObject) p.getUnsafe("empty")).getMember("length")).intValue();
                }))
                .isEqualTo(0);
    }

    @Test
    void setListOfProxiesRoundTrips() throws Exception {
        assertThat(runOnFx(() -> {
                    JsProxy a = new JsProxy(ctx);
                    a.set("name", "first");
                    JsProxy b = new JsProxy(ctx);
                    b.set("name", "second");
                    JsProxy outer = new JsProxy(ctx);
                    outer.set("arr", List.of(a, b));
                    return outer.getArray1D("arr", JsProxy::new).get(1).get("name", JsProxy.ofMapped(String.class));
                }))
                .isEqualTo("second");
    }

    @Test
    void setNullListSetsNull() throws Exception {
        Object result = runOnFx(() -> {
            JsProxy p = new JsProxy(ctx);
            p.set("items", (List<?>) null);
            return p.getUnsafe("items");
        });
        assertThat(result).isNull();
    }

    @Test
    void ofArrayWithNonArrayThrows() {
        // XXX getArray1D casts getUnsafe result to JSObject, so ClassCastException before ofArray validation
        assertThatThrownBy(() -> runOnFx(() -> {
                    JsProxy p = new JsProxy(ctx);
                    p.set("x", (Object) "not-an-array");
                    return p.getArray1D("x", JsProxy.ofMapped(String.class));
                }))
                .hasCauseInstanceOf(ClassCastException.class);
    }

    @Test
    void getArray2DRoundTrips() throws Exception {
        List<List<Double>> result = runOnFx(() -> {
            JsProxy p = new JsProxy(ctx);
            p.setUnsafe("matrix", ctx.engine.executeScript("[[1,2],[3,4,5]]"));
            return p.getArray2D("matrix", JsProxy.ofMapped(Double.class));
        });
        assertThat(result).hasSize(2);
        assertThat(result.get(0)).containsExactly(1.0, 2.0);
        assertThat(result.get(1)).containsExactly(3.0, 4.0, 5.0);
    }

    @Test
    void callJsMethod() throws Exception {
        assertThat(runOnFx(() -> new JsProxy(
                                ctx, ctx.engine.executeScript("({greet: function(name){ return 'hi ' + name; }})"))
                        .call("greet", JsProxy.ofMapped(String.class), "world")))
                .isEqualTo("hi world");
    }

    @Test
    void callReturningUndefinedGivesNull() throws Exception {
        assertThat(runOnFx(() -> new JsProxy(ctx, ctx.engine.executeScript("({noop: function(){}})"))
                        .call("noop", JsProxy.ofMapped(String.class))))
                .isNull();
    }

    @Test
    void invokeThisCallsReceiverAsFunction() throws Exception {
        assertThat(runOnFx(() -> new JsProxy(ctx, ctx.engine.executeScript("(function(a, b){ return a + b; })"))
                        .invokeThis(JsProxy.ofMapped(Double.class), 3, 4)))
                .isEqualTo(7.0);
    }

    @Test
    void invokeThisReturningUndefinedGivesNull() throws Exception {
        assertThat(runOnFx(() -> new JsProxy(ctx, ctx.engine.executeScript("(function(){})"))
                        .invokeThis(JsProxy.ofMapped(String.class))))
                .isNull();
    }

    @Test
    void callback0IsCalledFromJs() throws Exception {
        assertThat((boolean) runOnFx(() -> {
                    boolean[] flag = {false};
                    JSObject fn = ctx.callback0(() -> flag[0] = true);
                    ((JSObject) ctx.engine.executeScript("(function(f){ f(); })")).call("call", null, fn);
                    return flag[0];
                }))
                .isTrue();
    }

    @Test
    void callback1ReceivesLiftedValue() throws Exception {
        assertThat(runOnFx(() -> {
                    String[] captured = {null};
                    JSObject fn = ctx.callback1(JsProxy.ofMapped(String.class), v -> captured[0] = v);
                    ((JSObject) ctx.engine.executeScript("(function(f){ f('fromJS'); })")).call("call", null, fn);
                    return captured[0];
                }))
                .isEqualTo("fromJS");
    }

    @Test
    void callback2ReceivesBothArgs() throws Exception {
        assertThat(runOnFx(() -> {
                    String[] captured = {null};
                    JSObject fn = ctx.callback2(
                            JsProxy.ofMapped(String.class),
                            JsProxy.ofMapped(Double.class),
                            (a, b) -> captured[0] = a + ":" + b);
                    ((JSObject) ctx.engine.executeScript("(function(f){ f('x', 42); })")).call("call", null, fn);
                    return captured[0];
                }))
                .isEqualTo("x:42.0");
    }

    @Test
    void fn1ReturnsValueToJs() throws Exception {
        assertThat(runOnFx(() -> {
                    JSObject fn = ctx.fn1((JsFunction1<Object, Object>) arg -> "got:" + arg);
                    return (String) ((JSObject) ctx.engine.executeScript("(function(f){ return f('hello'); })"))
                            .call("call", null, fn);
                }))
                .isEqualTo("got:hello");
    }

    @Test
    void bindCallbackCreatesCallableJsMethod() throws Exception {
        assertThat(runOnFx(() -> {
                    String[] captured = {null};
                    JsProxy p = new JsProxy(ctx);
                    p.bindCallback("myMethod", 1, (JsFunction1<Object, Object>) arg -> {
                        captured[0] = "called:" + arg;
                        return null;
                    });
                    p.asJsObject().call("myMethod", "test");
                    return captured[0];
                }))
                .isEqualTo("called:test");
    }

    @Test
    void bindCallbackReturnsValueToJs() throws Exception {
        assertThat(((Number) runOnFx(() -> {
                            JsProxy p = new JsProxy(ctx);
                            p.bindCallback("add", 2, (JsFunction2<Object, Object, Object>)
                                    (a, b) -> ((Number) a).doubleValue() + ((Number) b).doubleValue());
                            return p.asJsObject().call("add", 10, 20);
                        }))
                        .doubleValue())
                .isEqualTo(30.0);
    }

    private enum TestDirection implements JsEnum<Integer> {
        LEFT(0),
        RIGHT(1);

        private final Integer v;

        TestDirection(Integer v) {
            this.v = v;
        }

        @Override
        public Integer value() {
            return v;
        }
    }

    @Test
    void setAndGetEnum() throws Exception {
        assertThat(runOnFx(() -> {
                    JsProxy p = new JsProxy(ctx);
                    p.set("dir", TestDirection.RIGHT);
                    return p.get("dir", JsProxy.ofJsEnum(TestDirection.class));
                }))
                .isEqualTo(TestDirection.RIGHT);
    }

    @Test
    void toStringOnJsObject() throws Exception {
        assertThat(runOnFx(() -> new JsProxy(ctx).toString()))
                .contains("JsProxy")
                .contains("object Object");
    }

    @Test
    void toStringWithNullReceiver() throws Exception {
        assertThat(runOnFx(() -> new JsProxy(ctx, (Object) null).toString())).contains("null");
    }

    @Test
    void asJsObjectOnNullReceiverThrows() {
        assertThatThrownBy(() -> runOnFx(() -> new JsProxy(ctx, (Object) null).asJsObject()))
                .hasCauseInstanceOf(IllegalStateException.class)
                .hasMessageContaining("receiver is null");
    }

    @Test
    void asJsObjectOnNonJSObjectThrows() {
        assertThatThrownBy(() -> runOnFx(() -> new JsProxy(ctx, "a plain string").asJsObject()))
                .hasCauseInstanceOf(IllegalStateException.class)
                .hasMessageContaining("not JSObject");
    }

    @Test
    void promiseThenReceivesResolvedValue() throws Exception {
        // XXX Promise microtasks run async in WebEngine; must set up on FX thread, wait off-FX
        String[] captured = {null};
        CountDownLatch done = new CountDownLatch(1);

        Platform.runLater(() -> {
            try {
                new JsPromise<>(
                                ctx,
                                ctx.engine.executeScript("Promise.resolve('resolved!')"),
                                JsProxy.ofMapped(String.class))
                        .then(v -> {
                            captured[0] = v;
                            done.countDown();
                        });
            } catch (Throwable t) {
                t.printStackTrace(System.err);
                done.countDown();
            }
        });

        assertThat(done.await(10, TimeUnit.SECONDS))
                .as("Promise.then callback should fire within 10 s")
                .isTrue();
        assertThat(captured[0]).isEqualTo("resolved!");
    }

    @Test
    void promiseThenRejectsCallsRejectedCallback() throws Exception {
        Exception[] captured = {null};
        CountDownLatch done = new CountDownLatch(1);

        Platform.runLater(() -> {
            try {
                new JsPromise<>(
                                ctx,
                                ctx.engine.executeScript("Promise.reject(new Error('boom'))"),
                                JsProxy.ofMapped(String.class))
                        .then(
                                v -> {
                                    // should not be called
                                    done.countDown();
                                },
                                err -> {
                                    captured[0] = err;
                                    done.countDown();
                                });
            } catch (Throwable t) {
                t.printStackTrace(System.err);
                done.countDown();
            }
        });

        assertThat(done.await(10, TimeUnit.SECONDS))
                .as("Promise rejection callback should fire within 10 s")
                .isTrue();
        assertThat(captured[0]).isNotNull();
        assertThat(captured[0].getMessage()).contains("boom");
    }

    @Test
    void ofMappedReturnsNullForNull() throws Exception {
        assertThat(runOnFx(() -> JsProxy.ofMapped(String.class).apply(ctx, null)))
                .isNull();
    }

    @Test
    void ofMappedConvertsIntegerToDouble() throws Exception {
        assertThat(runOnFx(() -> JsProxy.ofMapped(Double.class).apply(ctx, 42))).isEqualTo(42.0);
    }

    @Test
    void ofMappedThrowsOnTypeMismatch() {
        assertThatThrownBy(() -> runOnFx(() -> JsProxy.ofMapped(String.class).apply(ctx, 42)))
                .hasCauseInstanceOf(RuntimeException.class)
                .hasMessageContaining("Unexpected conversion");
    }

    // --- JsTuple tests ---

    @Test
    void tuple2FieldsAndAccessors() {
        var t = new JsTuple2<>("a", 1);
        assertThat(t.t0()).isEqualTo("a");
        assertThat(t.t1()).isEqualTo(1);
        assertThat(t.t0).isEqualTo("a");
        assertThat(t.t1).isEqualTo(1);
    }

    @Test
    void tuple2Elements() {
        assertThat(new JsTuple2<>("x", "y").elements()).containsExactly("x", "y");
    }

    @Test
    void tuple2EqualsSameValues() {
        assertThat(new JsTuple2<>(1, 2)).isEqualTo(new JsTuple2<>(1, 2));
    }

    @Test
    void tuple2NotEqualDifferentValues() {
        assertThat(new JsTuple2<>(1, 2)).isNotEqualTo(new JsTuple2<>(1, 3));
    }

    @Test
    void tuple2NotEqualNull() {
        assertThat(new JsTuple2<>(1, 2)).isNotEqualTo(null);
    }

    @Test
    void tuple2NotEqualDifferentType() {
        assertThat(new JsTuple2<>(1, 2)).isNotEqualTo("not a tuple");
    }

    @Test
    void tuple2HashCodeConsistent() {
        assertThat(new JsTuple2<>("a", "b").hashCode()).isEqualTo(new JsTuple2<>("a", "b").hashCode());
    }

    @Test
    void tuple2ToString() {
        assertThat(new JsTuple2<>("a", 1).toString()).isEqualTo("JsTuple2(a, 1)");
    }

    @Test
    void tuple3FieldsAndAccessors() {
        var t = new JsTuple3<>("a", 2, true);
        assertThat(t.t0()).isEqualTo("a");
        assertThat(t.t1()).isEqualTo(2);
        assertThat(t.t2()).isEqualTo(true);
    }

    @Test
    void tuple3Elements() {
        assertThat(new JsTuple3<>(1, 2, 3).elements()).containsExactly(1, 2, 3);
    }

    @Test
    void tuple3EqualsAndHashCode() {
        var a = new JsTuple3<>("x", "y", "z");
        var b = new JsTuple3<>("x", "y", "z");
        assertThat(a).isEqualTo(b);
        assertThat(a.hashCode()).isEqualTo(b.hashCode());
        assertThat(a).isNotEqualTo(new JsTuple3<>("x", "y", "w"));
        assertThat(a).isNotEqualTo(null);
    }

    @Test
    void tuple3ToString() {
        assertThat(new JsTuple3<>(1, 2, 3).toString()).isEqualTo("JsTuple3(1, 2, 3)");
    }

    @Test
    void tuple4FieldsAndAccessors() {
        var t = new JsTuple4<>("a", 2, true, 4.0);
        assertThat(t.t0()).isEqualTo("a");
        assertThat(t.t1()).isEqualTo(2);
        assertThat(t.t2()).isEqualTo(true);
        assertThat(t.t3()).isEqualTo(4.0);
    }

    @Test
    void tuple4Elements() {
        assertThat(new JsTuple4<>(1, 2, 3, 4).elements()).containsExactly(1, 2, 3, 4);
    }

    @Test
    void tuple4EqualsAndHashCode() {
        var a = new JsTuple4<>("a", "b", "c", "d");
        var b = new JsTuple4<>("a", "b", "c", "d");
        assertThat(a).isEqualTo(b);
        assertThat(a.hashCode()).isEqualTo(b.hashCode());
        assertThat(a).isNotEqualTo(new JsTuple4<>("a", "b", "c", "e"));
        assertThat(a).isNotEqualTo(null);
    }

    @Test
    void tuple4ToString() {
        assertThat(new JsTuple4<>(1, 2, 3, 4).toString()).isEqualTo("JsTuple4(1, 2, 3, 4)");
    }

    // --- JsUnion2 tests ---

    @Test
    void union2T0Projection() {
        JsUnion2<String, Integer> u = JsUnion2.t0("hello");
        assertThat(u.isT0()).isTrue();
        assertThat(u.isT1()).isFalse();
        assertThat(u.getT0()).isEqualTo("hello");
        assertThat(u.maybeT0()).contains("hello");
        assertThat(u.maybeT1()).isEmpty();
    }

    @Test
    void union2T1Projection() {
        JsUnion2<String, Integer> u = JsUnion2.t1(42);
        assertThat(u.isT0()).isFalse();
        assertThat(u.isT1()).isTrue();
        assertThat(u.getT1()).isEqualTo(42);
        assertThat(u.maybeT1()).contains(42);
        assertThat(u.maybeT0()).isEmpty();
    }

    @Test
    void union2Fold() {
        JsUnion2<String, Integer> u0 = JsUnion2.t0("x");
        JsUnion2<String, Integer> u1 = JsUnion2.t1(5);
        String r0 = u0.fold(s -> s + "!", i -> String.valueOf(i));
        String r1 = u1.fold(s -> s + "!", i -> String.valueOf(i));
        assertThat(r0).isEqualTo("x!");
        assertThat(r1).isEqualTo("5");
    }

    @Test
    void union2Unite() {
        Object v0 = JsUnion2.<String, Integer>t0("val").unite();
        Object v1 = JsUnion2.<String, Integer>t1(99).unite();
        assertThat(v0).isEqualTo("val");
        assertThat(v1).isEqualTo(99);
    }

    @Test
    void union2EqualsAndHashCode() {
        JsUnion2<String, Integer> a = JsUnion2.t0("x");
        JsUnion2<String, Integer> b = JsUnion2.t0("x");
        JsUnion2<String, Integer> c = JsUnion2.t0("y");
        assertThat(a).isEqualTo(b);
        assertThat(a.hashCode()).isEqualTo(b.hashCode());
        assertThat(a).isNotEqualTo(c);
        assertThat(a).isNotEqualTo(null);
        assertThat(a).isNotEqualTo(JsUnion2.t1("x"));
    }

    @Test
    void union2ToString() {
        assertThat(JsUnion2.t0("hi").toString()).isEqualTo("JsUnion2T0Projection(hi)");
        assertThat(JsUnion2.t1(42).toString()).isEqualTo("JsUnion2T1Projection(42)");
    }

    // --- JsUnion3 tests ---

    @Test
    void union3AllProjections() {
        JsUnion3<String, Integer, Boolean> u0 = JsUnion3.t0("a");
        JsUnion3<String, Integer, Boolean> u1 = JsUnion3.t1(1);
        JsUnion3<String, Integer, Boolean> u2 = JsUnion3.t2(true);

        assertThat(u0.isT0()).isTrue();
        assertThat(u0.isT1()).isFalse();
        assertThat(u0.isT2()).isFalse();
        assertThat(u0.getT0()).isEqualTo("a");

        assertThat(u1.isT1()).isTrue();
        assertThat(u1.getT1()).isEqualTo(1);
        assertThat(u1.maybeT0()).isEmpty();
        assertThat(u1.maybeT2()).isEmpty();

        assertThat(u2.isT2()).isTrue();
        assertThat(u2.getT2()).isEqualTo(true);
        assertThat(u2.maybeT0()).isEmpty();
        assertThat(u2.maybeT1()).isEmpty();
    }

    @Test
    void union3Fold() {
        JsUnion3<String, Integer, Boolean> u = JsUnion3.t2(true);
        String result = u.fold(s -> "str", i -> "int", b -> "bool:" + b);
        assertThat(result).isEqualTo("bool:true");
    }

    @Test
    void union3Unite() {
        Object v = JsUnion3.<String, Integer, Boolean>t1(7).unite();
        assertThat(v).isEqualTo(7);
    }

    @Test
    void union3EqualsAndToString() {
        JsUnion3<String, Integer, Boolean> a = JsUnion3.t1(5);
        JsUnion3<String, Integer, Boolean> b = JsUnion3.t1(5);
        assertThat(a).isEqualTo(b);
        assertThat(a.hashCode()).isEqualTo(b.hashCode());
        assertThat(a).isNotEqualTo(JsUnion3.t1(6));
        assertThat(a).isNotEqualTo(null);
        assertThat(JsUnion3.t0("v").toString()).isEqualTo("JsUnion3T0Projection(v)");
        assertThat(JsUnion3.t1(1).toString()).isEqualTo("JsUnion3T1Projection(1)");
        assertThat(JsUnion3.t2(true).toString()).isEqualTo("JsUnion3T2Projection(true)");
    }

    // --- JsUnion4 tests ---

    @Test
    void union4AllProjections() {
        JsUnion4<String, Integer, Boolean, Double> u0 = JsUnion4.t0("a");
        JsUnion4<String, Integer, Boolean, Double> u1 = JsUnion4.t1(1);
        JsUnion4<String, Integer, Boolean, Double> u2 = JsUnion4.t2(true);
        JsUnion4<String, Integer, Boolean, Double> u3 = JsUnion4.t3(3.14);

        assertThat(u0.isT0()).isTrue();
        assertThat(u0.isT1()).isFalse();
        assertThat(u0.isT2()).isFalse();
        assertThat(u0.isT3()).isFalse();
        assertThat(u0.getT0()).isEqualTo("a");

        assertThat(u1.isT1()).isTrue();
        assertThat(u1.getT1()).isEqualTo(1);

        assertThat(u2.isT2()).isTrue();
        assertThat(u2.getT2()).isEqualTo(true);

        assertThat(u3.isT3()).isTrue();
        assertThat(u3.getT3()).isEqualTo(3.14);
        assertThat(u3.maybeT0()).isEmpty();
        assertThat(u3.maybeT1()).isEmpty();
        assertThat(u3.maybeT2()).isEmpty();
    }

    @Test
    void union4Fold() {
        JsUnion4<String, Integer, Boolean, Double> u = JsUnion4.t3(2.5);
        String result = u.fold(s -> "str", i -> "int", b -> "bool", d -> "dbl:" + d);
        assertThat(result).isEqualTo("dbl:2.5");
    }

    @Test
    void union4Unite() {
        Object v = JsUnion4.<String, Integer, Boolean, Double>t2(false).unite();
        assertThat(v).isEqualTo(false);
    }

    @Test
    void union4EqualsAndToString() {
        JsUnion4<String, Integer, Boolean, Double> a = JsUnion4.t3(1.0);
        JsUnion4<String, Integer, Boolean, Double> b = JsUnion4.t3(1.0);
        assertThat(a).isEqualTo(b);
        assertThat(a.hashCode()).isEqualTo(b.hashCode());
        assertThat(a).isNotEqualTo(JsUnion4.t3(2.0));
        assertThat(a).isNotEqualTo(null);
        assertThat(JsUnion4.t0("v").toString()).isEqualTo("JsUnion4T0Projection(v)");
        assertThat(JsUnion4.t1(1).toString()).isEqualTo("JsUnion4T1Projection(1)");
        assertThat(JsUnion4.t2(true).toString()).isEqualTo("JsUnion4T2Projection(true)");
        assertThat(JsUnion4.t3(9.9).toString()).isEqualTo("JsUnion4T3Projection(9.9)");
    }
}
