package net.kurobako.monacofx.sample;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import jdk.jshell.EvalException;
import jdk.jshell.ExpressionSnippet;
import jdk.jshell.JShell;
import jdk.jshell.JShellException;
import jdk.jshell.Snippet;
import jdk.jshell.SnippetEvent;
import jdk.jshell.UnresolvedReferenceException;
import jdk.jshell.VarSnippet;
import jdk.jshell.execution.LocalExecutionControlProvider;
import monaco_editor.monaco.IDisposable;
import monaco_editor.monaco.editor.IActionDescriptor;
import monaco_editor.monaco.editor.IModelContentChangedEvent;
import monaco_editor.monaco.editor.IStandaloneCodeEditor;
import monaco_editor.monaco.editor.IStandaloneEditorConstructionOptions;
import monaco_editor.monaco.languages.InlayHint;
import monaco_editor.monaco.languages.InlayHintKind;
import monaco_editor.monaco.languages.InlayHintList;
import monaco_editor.monaco.languages.InlayHintsProvider;
import net.kurobako.monacofx.MonacoPane;
import net.kurobako.monacofx.MonacoPane.MonacoContext;
import net.kurobako.monacofx.sample.SamplerController.Sample;

public class JShellSample implements Sample {

    private final AtomicReference<MonacoContext> ctxRef = new AtomicReference<>();
    private final AtomicReference<IStandaloneCodeEditor> editorRef = new AtomicReference<>();
    private final AtomicReference<JShell> jshellRef = new AtomicReference<>();
    private final RunBridge runBridge = new RunBridge();
    private final ExecutorService executor = Executors.newSingleThreadExecutor(r -> {
        var t = new Thread(r, "jshell-worker");
        t.setDaemon(true);
        return t;
    });

    // Registration handle for the current inlay hints provider; disposed before re-registering.
    private IDisposable currentProvider;
    // Evaluated results currently displayed as inlay hints.
    private final List<SnippetResult> currentResults = new ArrayList<>();
    // Debounce timer for auto-run; restarts on each keystroke, fires after 500ms idle.
    private final PauseTransition autoRunTimer = new PauseTransition(Duration.millis(500));
    private volatile boolean autoRun;

    private static final String DEFAULT_SOURCE = "int x = 5;\n" + "x * 2\n" + "System.out.println(\"hello\");\n";

    private static JShell buildJShell() {
        var js = JShell.builder()
                .executionEngine(new LocalExecutionControlProvider(), Map.of())
                .build();
        // LocalExecutionControlProvider skips the default imports that the
        // standard JShell REPL provides.  Replay them so java.util.*, etc. work.
        for (String src : new String[] {
            "import java.io.*;",
            "import java.math.*;",
            "import java.net.*;",
            "import java.nio.file.*;",
            "import java.util.*;",
            "import java.util.concurrent.*;",
            "import java.util.function.*;",
            "import java.util.prefs.*;",
            "import java.util.regex.*;",
            "import java.util.stream.*;"
        }) js.eval(src);
        return js;
    }

    private static List<SnippetResult> evaluateCapturing(JShell js, String source, ByteArrayOutputStream cap) {
        PrintStream origOut = System.out;
        PrintStream origErr = System.err;
        var tee = new OutputStream() {
            @Override
            public void write(int b) {
                cap.write(b);
                origErr.write(b);
            }

            @Override
            public void write(byte[] b, int off, int len) {
                cap.write(b, off, len);
                origErr.write(b, off, len);
            }

            @Override
            public void flush() throws IOException {
                origErr.flush();
            }
        };
        var ps = new PrintStream(tee, true, StandardCharsets.UTF_8);
        System.setOut(ps);
        System.setErr(ps);
        try {
            return evaluate(js, source);
        } finally {
            System.setOut(origOut);
            System.setErr(origErr);
        }
    }

    private record SnippetResult(int line, String label) {}

    private static int countNewlines(String s) {
        return (int) s.chars().filter(c -> c == '\n').count();
    }

    private static List<SnippetResult> evaluate(JShell js, String source) {
        var results = new ArrayList<SnippetResult>();
        var remaining = source;
        int line = 1; // 1-based line number at the start of `remaining`

        while (!remaining.isBlank()) {
            String stripped = remaining.stripLeading();
            line += countNewlines(remaining.substring(0, remaining.length() - stripped.length()));
            remaining = stripped;
            if (remaining.isBlank()) break;

            var ci = js.sourceCodeAnalysis().analyzeCompletion(remaining);
            var snippet = ci.source();
            if (snippet.isBlank()) break;

            int startLine = line;
            int endLine = line + countNewlines(snippet.stripTrailing());

            for (var ev : js.eval(snippet)) {
                if (ev.causeSnippet() == null) results.add(toResult(js, ev, startLine, endLine));
            }
            line += countNewlines(snippet);
            remaining = ci.remaining();
        }
        return results;
    }

    private static SnippetResult toResult(JShell js, SnippetEvent ev, int startLine, int endLine) {
        // Errors go on the start line (where the user wrote the bad code);
        // successful results go on the end line (after the last line of the statement).
        if (ev.status() == Snippet.Status.REJECTED) {
            String msg = js.diagnostics(ev.snippet())
                    .map(d -> d.getMessage(Locale.ENGLISH))
                    .findFirst()
                    .orElse("compile error");
            return new SnippetResult(startLine, "  // error: " + msg);
        }
        JShellException ex = ev.exception();
        if (ex instanceof EvalException ee) {
            String typeName = ee.getExceptionClassName();
            int dot = typeName.lastIndexOf('.');
            if (dot >= 0) typeName = typeName.substring(dot + 1);
            String msg = ee.getMessage() != null ? ": " + ee.getMessage() : "";
            return new SnippetResult(startLine, "  // throws " + typeName + msg);
        }
        if (ex instanceof UnresolvedReferenceException ure) {
            return new SnippetResult(
                    startLine,
                    "  // error: unresolved: " + ure.getSnippet().source().strip());
        }
        var snip = ev.snippet();
        if (snip instanceof VarSnippet vs) {
            String val = ev.value() != null ? ev.value() : "null";
            return new SnippetResult(endLine, "  // => " + vs.name() + ":" + vs.typeName() + " = " + val);
        }
        if (snip instanceof ExpressionSnippet) {
            String val = ev.value() != null ? ev.value() : "null";
            return new SnippetResult(endLine, "  // => " + val);
        }
        if (ev.value() != null && !ev.value().isEmpty() && !"null".equals(ev.value())) {
            return new SnippetResult(endLine, "  // => " + ev.value());
        }
        return new SnippetResult(endLine, "  // ok");
    }
    /** Rebuilds the inlay hints provider from {@link #currentResults}. */
    private void refreshInlayHints() {
        try {
            disposeCurrentProvider();
            var ctx = ctxRef.get();
            var editor = editorRef.get();
            if (ctx == null || editor == null || currentResults.isEmpty()) return;

            var model = editor.getModel_();
            int lineCount = model != null ? (int) model.getLineCount() : 0;

            var hints = new ArrayList<InlayHint>();
            for (var r : currentResults) {
                if (r.line() > lineCount) continue;
                double col = model != null ? model.getLineMaxColumn((double) r.line()) : 1.0;
                hints.add(new InlayHint(ctx)
                        .label(r.label())
                        .position(new monaco_editor.monaco.IPosition(ctx)
                                .lineNumber((double) r.line())
                                .column(col))
                        .kind(InlayHintKind.Type));
            }
            var hintList = new InlayHintList(ctx).hints(hints).overrideDispose(() -> null);

            currentProvider = ctx.monaco()
                    .languages()
                    .registerInlayHintsProvider(
                            "java",
                            new InlayHintsProvider(ctx).overrideProvideInlayHints((m, r, t) -> hintList.asJsObject()));
        } catch (Exception ex) {
            System.err.println("[JShell] refreshInlayHints error: " + ex);
            ex.printStackTrace(System.err);
        }
    }

    /** Discards results for lines &ge; {@code fromLine} and refreshes hints. */
    private void invalidateFrom(int fromLine) {
        if (currentResults.removeIf(r -> r.line() >= fromLine)) refreshInlayHints();
    }

    private void disposeCurrentProvider() {
        if (currentProvider != null) {
            currentProvider.dispose();
            currentProvider = null;
        }
    }

    public static final class RunBridge {
        private volatile Runnable action;

        public void setAction(Runnable r) {
            this.action = r;
        }

        public void run() {
            Runnable r = action;
            if (r != null) Platform.runLater(r);
        }
    }

    @Override
    public void setTheme(String theme) {
        MonacoContext ctx = ctxRef.get();
        if (ctx != null) ctx.monaco().editor().setTheme(theme);
    }

    private static HBox toolbar(Node... nodes) {
        var box = new HBox(8, nodes);
        box.setAlignment(Pos.CENTER_LEFT);
        box.setPadding(new Insets(6, 8, 6, 8));
        box.setStyle("-fx-background-color: -color-bg-subtle;");
        return box;
    }

    @Override
    public List<Tab> mkTabs() {
        var outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setWrapText(true);
        outputArea.setStyle("-fx-font-family: monospace;");

        var capOut = new ByteArrayOutputStream();

        MonacoPane pane;
        {
            pane = new MonacoPane(
                    ctx -> {
                        ctxRef.set(ctx);
                        var ops = new IStandaloneEditorConstructionOptions(ctx)
                                .value(DEFAULT_SOURCE)
                                .language("java")
                                .theme("vs-dark")
                                .fixedOverflowWidgets(true);
                        var editor = ctx.monaco().editor().create(ctx.editorElement(), ops);
                        editorRef.set(editor);
                        Platform.runLater(() -> {
                            try {
                                // Inject inlay-hint CSS via DOM API.
                                ctx.engine.executeScript("var s=document.createElement('style');"
                                        + "s.textContent='.monaco-inlay-hint{color:#6a9955!important;font-style:italic}';"
                                        + "document.head.appendChild(s)");

                                // Register Ctrl+Enter action via generated IActionDescriptor API.
                                int keybinding = (int) ctx.monaco().KeyMod().CtrlCmd()
                                        | ((Number) ctx.monaco().KeyCode().getMember("Enter")).intValue();
                                editor.addAction(new IActionDescriptor(ctx)
                                        .id("jshell-run")
                                        .label("Run JShell")
                                        .keybindings(List.of((double) keybinding))
                                        .overrideRun((ed, args) -> {
                                            runBridge.run();
                                            return null;
                                        }));

                                // On edit, invalidate results from the changed line onwards.
                                editor.onDidChangeModelContent()
                                        .invoke(ctx.callback1(IModelContentChangedEvent::new, ev -> {
                                            try {
                                                int minLine = Integer.MAX_VALUE;
                                                for (var change : ev.changes()) {
                                                    int sl =
                                                            (int) change.range().startLineNumber();
                                                    if (sl < minLine) minLine = sl;
                                                }
                                                invalidateFrom(minLine);
                                                if (autoRun) autoRunTimer.playFromStart();
                                            } catch (Exception ex) {
                                                System.err.println("[JShell] change listener error: " + ex);
                                                ex.printStackTrace(System.err);
                                                currentResults.clear();
                                                refreshInlayHints();
                                                if (autoRun) autoRunTimer.playFromStart();
                                            }
                                        }));
                            } catch (Exception ex) {
                                System.err.println("[JShell] editor setup error: " + ex);
                                ex.printStackTrace(System.err);
                            }
                        });
                    },
                    System.err);
        }

        jshellRef.set(buildJShell());

        var runBtn = new Button("▶ Run");
        var resetBtn = new Button("↺ Reset");
        var clearBtn = new Button("Clear output");
        var autoRunCb = new CheckBox("Auto-run");
        autoRunCb.selectedProperty().addListener((obs, o, n) -> {
            autoRun = n;
            if (!n) autoRunTimer.stop();
        });

        Runnable doRun = () -> {
            var ctx = ctxRef.get();
            var editor = editorRef.get();
            var js = jshellRef.get();
            if (ctx == null || editor == null || js == null) return;

            String source = editor.getValue();
            if (source == null || source.isBlank()) return;

            runBtn.setDisable(true);
            resetBtn.setDisable(true);
            capOut.reset();

            executor.submit(() -> {
                List<SnippetResult> results;
                try {
                    results = evaluateCapturing(js, source, capOut);
                } catch (Exception ex) {
                    System.err.println("[JShell] evaluate threw: " + ex);
                    ex.printStackTrace(System.err);
                    results = List.of();
                }
                final var finalResults = results;
                String captured = capOut.toString(StandardCharsets.UTF_8);

                Platform.runLater(() -> {
                    runBtn.setDisable(false);
                    resetBtn.setDisable(false);
                    if (!captured.isBlank()) {
                        outputArea.appendText(captured);
                        if (!captured.endsWith("\n")) outputArea.appendText("\n");
                    }
                    try {
                        currentResults.clear();
                        currentResults.addAll(finalResults);
                        refreshInlayHints();
                    } catch (Exception ex) {
                        System.err.println("[JShell] hint update failed: " + ex);
                        ex.printStackTrace(System.err);
                    }
                });
            });
        };

        runBridge.setAction(doRun);
        runBtn.setOnAction(e -> doRun.run());
        autoRunTimer.setOnFinished(e -> doRun.run());

        resetBtn.setOnAction(e -> {
            var old = jshellRef.get();
            if (old != null) old.close();
            capOut.reset();
            jshellRef.set(buildJShell());
            currentResults.clear();
            disposeCurrentProvider();
        });

        clearBtn.setOnAction(e -> outputArea.clear());

        var splitPane = new SplitPane(pane, outputArea);
        splitPane.setOrientation(Orientation.VERTICAL);
        splitPane.setDividerPositions(0.7);

        var root = new BorderPane(splitPane);
        root.setTop(toolbar(runBtn, resetBtn, clearBtn, autoRunCb));

        return List.of(new Tab("JShell", root));
    }
}
