package net.kurobako.monacofx;


import com.sun.javafx.webkit.WebConsoleListener;
import com.sun.net.httpserver.HttpServer;

import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsPromise;
import net.kurobako.monacofx.js.JsProxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.util.Objects;
import java.util.stream.Collectors;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.concurrent.Worker.State;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import monaco_editor.MonacoModule;
import monaco_editor.monaco.EditorModule;
import monaco_editor.monaco.LanguagesModule;
import monaco_editor.monaco.WorkerModule;
import monaco_editor.monaco.editor.IStandaloneCodeEditor;
import monaco_editor.monaco.editor.IStandaloneEditorConstructionOptions;
import monaco_editor.monaco.languages.ILanguageExtensionPoint;
import netscape.javascript.JSObject;

import static java.nio.charset.StandardCharsets.UTF_8;

public class MonacoPane extends StackPane {

    private static final String VENDOR = "/vendor";

    private static String readAll(String path) throws IOException {
        try (var s = open(path);
             var reader = new BufferedReader(new InputStreamReader(s, UTF_8))
        ) {
            return reader.lines().collect(Collectors.joining("\n"));
        }
    }

    private static InputStream open(String path) throws IOException {
        return MonacoPane.class.getResource(path).openConnection().getInputStream();
    }

    private static String contentType(String uri) {
        if (uri.endsWith(".js")) return "text/javascript; charset=UTF-8";
        else if (uri.endsWith(".html")) return "text/html; charset=utf-8";
        else if (uri.endsWith(".css")) return "text/css; charset=UTF-8";
        else if (uri.endsWith(".ttf")) return "font/ttf";
        else return "text/plain; charset=UTF-8";
    }


    private final ObjectProperty<MonacoContext> editor = new SimpleObjectProperty<>(null);


    public MonacoContext getEditor() {
        return editor.get();
    }

    public ObjectProperty<MonacoContext> editorProperty() {
        return editor;
    }


    public static class ITextModel extends JsProxy {
        public ITextModel(JsContext context, Object receiver) {
            super(context, receiver);
        }

        public ITextModel(JsContext context) {
            super(context);
        }

        public String id() {
            return getUnsafe("id");
        }


    }


    public static class Editor extends JsProxy {
        public Editor(JsContext context, Object receiver) {
            super(context, receiver);
        }

        public Editor(JsContext context) {
            super(context);
        }

        public ITextModel getModel() {
            return call("getModel", ITextModel::new);
        }

    }


    public static class MonacoContext extends JsContext {
        private JSObject element;
        private MonacoModule monaco;

        MonacoContext(WebEngine engine) {
            super(engine);
        }

        private void initialise(JSObject element, MonacoModule monaco) {
            this.element = Objects.requireNonNull(element);
            this.monaco = Objects.requireNonNull(monaco);
        }

        public JSObject editorElement() {
            return element;
        }

        public MonacoModule monaco() {
            return monaco;
        }

    }


    public MonacoPane() throws IOException {
        var requireJs = readAll(VENDOR + "/require.js");

        var view = new WebView();
        getChildren().add(view);
        var engine = view.getEngine();
        editor.addListener((xx, p, ctx) -> {


            System.out.println("editor = " + ctx);
//
//
//            JSObject empty = (JSObject) engine.executeScript("new Object();");
//            empty.setMember("value", "a");
//
//
////
//
//
            System.out.println(ctx.monaco());

            System.out.println(ctx.monaco()
                    .languages()
                    .getLanguages().stream()
                    .map(ILanguageExtensionPoint::id)
                    .collect(Collectors.toList()));


            IStandaloneEditorConstructionOptions ops = new IStandaloneEditorConstructionOptions(ctx)
                    .value("// First line\nfunction hello() {\n\talert('Hello world!');\n}\n// Last line \n -> @ ")
                    .language("typescript")
                    .fontFamily("Fira Code")
                    .mouseWheelScrollSensitivity(0.05)
                    .roundedSelection(false)
                    .fixedOverflowWidgets(true)
                    .theme("vs-dark");

//
            IStandaloneCodeEditor e = ctx.monaco().editor().create(ctx.element, ops);

//            e.getContribution("editor.linkDetector")
//                    .get("openerService", JsPromise::new)
//                    .set("open", ctx.callback1(JsProxy.ofMapped(String.class),
//                            jsObject -> System.out.println("A=> " + jsObject.getClass())));

//
            ctx.window.set("onresize", ctx.callback0(e::layout));
//
//
////            layoutBoundsProperty().addListener(ignored -> e.layout());
//
//            System.out.println(e);
////

//            var o = editor.call("colorize", "foo", "javascript");
//            var a = new JsPromise<>(me.context, o, (ignored, x) -> (String) x);
//            System.out.println(a);

//            var b = a.then(x -> {
//                System.out.println("Out = " + x);
//            }, e -> {
//                System.out.println("Fail = " + e);
//            });
//
//            var yy = me.context.engine.executeScript("/ab+c/i");
//            System.out.println(yy.getClass());

        });


        WebConsoleListener.setDefaultListener((webView, message, lineNumber, sourceId) -> {
            System.out.println("\t" + webView + "@" + sourceId + ":" + lineNumber + " " + message);
        });

        engine.getLoadWorker().stateProperty().addListener((o, p, n) -> {

            System.out.println("Load worker state: " + n + " (" + p + " -> " + n + ")" );

            if (n != State.SUCCEEDED) return;


            var ctx = new MonacoContext(engine);

          ctx.window.set("bridge", ctx.callback1(JsProxy.ofMapped(JSObject.class),
                    element -> {
                        ctx.initialise(element, ctx.window.get("monaco", MonacoModule::new));
                        this.editor.set(ctx);
                    }
            ));
            engine.executeScript(requireJs);
            engine.executeScript("initialise();");
        });


        HttpServer server = HttpServer.create(new InetSocketAddress(0), 0);
        server.createContext("/", t -> {
            final String resourceUri;
            var uri = t.getRequestURI().toASCIIString().trim();
            if (uri.equals("/")) resourceUri = "/editor.html";
            else resourceUri = VENDOR + uri;
            var headers = t.getResponseHeaders();
            headers.add("Content-Type", contentType(resourceUri));
            t.sendResponseHeaders(200, 0);
            try (var source = open(resourceUri);
                 var response = t.getResponseBody()) {
                source.transferTo(response);
            }
        });
        server.setExecutor(null);
        server.start();

        String url = "http://localhost:" + server.getAddress().getPort();
        System.out.println(url);
        engine.load(url);
    }

}