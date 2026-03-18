package net.kurobako.monacofx.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import monaco_editor.monaco.editor.IDiffEditorModel;
import monaco_editor.monaco.editor.IStandaloneCodeEditor;
import monaco_editor.monaco.editor.IStandaloneDiffEditorConstructionOptions;
import monaco_editor.monaco.editor.IStandaloneEditorConstructionOptions;
import net.kurobako.monacofx.MonacoPane;
import net.kurobako.monacofx.MonacoPane.MonacoContext;
import net.kurobako.monacofx.sample.SamplerController.Sample;

public class FXMLSample implements Sample {

    private final List<AtomicReference<MonacoContext>> allContexts = new ArrayList<>();
    private final List<MonacoPane> allPanes = new ArrayList<>();

    @Override
    public void setTheme(String theme) {
        allContexts.forEach(ref -> {
            MonacoContext ctx = ref.get();
            if (ctx != null) ctx.monaco().editor().setTheme(theme);
        });
    }

    @Override
    public void setScrollDeltaLines(int lines) {
        allPanes.forEach(p -> p.setScrollDeltaLines(lines));
    }

    private static final class LangSample {
        final String label, language, resourcePath;

        LangSample(String label, String language, String resourcePath) {
            this.label = label;
            this.language = language;
            this.resourcePath = resourcePath;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private static final List<LangSample> HOME_LANGS = List.of(
            new LangSample("TypeScript", "typescript", "/sample-typescript.txt"),
            new LangSample("JavaScript", "javascript", "/sample-javascript.txt"),
            new LangSample("Python", "python", "/sample-python.txt"));

    private static String readResource(String path) {
        try (var s = FXMLSample.class.getResourceAsStream(path);
                var r = new BufferedReader(new InputStreamReader(s))) {
            return r.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException("Could not read resource: " + path, e);
        }
    }

    private static HBox toolbar(Node... nodes) {
        var box = new HBox(8, nodes);
        box.setAlignment(Pos.CENTER_LEFT);
        box.setPadding(new Insets(6, 8, 6, 8));
        box.setStyle("-fx-background-color: -color-bg-subtle;");
        return box;
    }

    private static Label label(String text) {
        return new Label(text);
    }

    private Node makeHomeTab() {
        var langBox = new ComboBox<LangSample>();
        langBox.getItems().addAll(HOME_LANGS);

        AtomicReference<MonacoContext> ctxRef = new AtomicReference<>();
        AtomicReference<IStandaloneCodeEditor> editorRef = new AtomicReference<>();
        allContexts.add(ctxRef);

        var pane = new MonacoPane(
                ctx -> {
                    ctxRef.set(ctx);
                    var first = HOME_LANGS.get(0);
                    var ops = new IStandaloneEditorConstructionOptions(ctx)
                            .value(readResource(first.resourcePath))
                            .language(first.language)
                            .theme("vs-dark")
                            .fixedOverflowWidgets(true);
                    var e = ctx.monaco().editor().create(ctx.editorElement(), ops);
                    editorRef.set(e);
                    javafx.application.Platform.runLater(
                            () -> langBox.getSelectionModel().selectFirst());
                },
                System.err);
        allPanes.add(pane);

        langBox.setOnAction(ev -> {
            var sel = langBox.getValue();
            if (sel == null) return;
            var ctx = ctxRef.get();
            var e = editorRef.get();
            if (ctx == null || e == null) return;
            var model = ctx.monaco().editor().createModel(readResource(sel.resourcePath), sel.language);
            e.setModel(model);
        });

        var root = new BorderPane(pane);
        root.setTop(toolbar(label("Language:"), langBox));
        return root;
    }

    private Node makeDiffTab() {
        var original = readResource("/sample-javascript.txt");
        // slightly modified version: rename undefinedVariable -> definedVariable
        var modified = original.replace("undefinedVariable = {};", "var definedVariable = {};")
                .replace("undefinedVariable.prop", "definedVariable.prop")
                // insert a comment block near the top
                .replace(
                        "(function (global, undefined) {",
                        "// Here are some inserted lines\n// with some extra comments\n\n(function (global, undefined) {");

        AtomicReference<MonacoContext> ctxRef = new AtomicReference<>();
        allContexts.add(ctxRef);

        var pane = new MonacoPane(
                ctx -> {
                    ctxRef.set(ctx);
                    var opts = new IStandaloneDiffEditorConstructionOptions(ctx)
                            .theme("vs-dark")
                            .readOnly(true)
                            .enableSplitViewResizing(true);
                    var diff = ctx.monaco().editor().createDiffEditor(ctx.editorElement(), opts);
                    var orig = ctx.monaco().editor().createModel(original, "javascript");
                    var mod = ctx.monaco().editor().createModel(modified, "javascript");
                    diff.setModel(new IDiffEditorModel(ctx).original(orig).modified(mod));
                },
                System.err);
        allPanes.add(pane);

        var root = new BorderPane(pane);
        root.setTop(toolbar(label("WinJS library --original <-> modified")));
        return root;
    }

    @Override
    public List<Tab> mkTabs() {
        return List.of(new Tab("Editor", makeHomeTab()), new Tab("Diff Editor", makeDiffTab()));
    }
}
