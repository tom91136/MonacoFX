package net.kurobako.monacofx;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import monaco_editor.monaco.IPosition;
import monaco_editor.monaco.IRange;
import monaco_editor.monaco.editor.ITextModel;
import netscape.javascript.JSObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/** Parameterized clipboard integration tests. Tests copy, cut, and paste via keyboard and context menu paths. */
class ClipboardTest extends MonacoPaneTestBase {

    enum Method {
        KEYBOARD,
        CONTEXT_MENU
    }

    enum Op {
        COPY,
        CUT,
        PASTE
    }

    private static final String INITIAL = "alpha\nbravo\ncharlie\ndelta\n";
    private static final String PRE_CLIP = "pre-existing clipboard text";

    @BeforeEach
    void resetEditor() throws Exception {
        runOnFx(() -> {
            editor.getModel_().setValue(INITIAL);
            setClipboard("");
            return null;
        });
        waitMs(100);
    }

    static Stream<Arguments> clipboardTestCases() {
        List<Arguments> cases = new ArrayList<>();
        for (Method src : Method.values())
            for (Method dst : Method.values())
                for (Op op : Op.values())
                    for (boolean pre : new boolean[] {false, true}) cases.add(Arguments.of(src, dst, op, pre));
        return cases.stream();
    }

    @ParameterizedTest(name = "{2} src={0} dst={1} preClip={3}")
    @MethodSource("clipboardTestCases")
    void clipboardOperation(Method src, Method dst, Op op, boolean pre) throws Exception {
        if (pre) runOnFxVoid(() -> setClipboard(PRE_CLIP));
        switch (op) {
            case COPY -> testCopy(src, dst);
            case CUT -> testCut(src, dst);
            case PASTE -> testPaste(dst, pre);
        }
    }

    private void testCopy(Method copyMethod, Method pasteMethod) throws Exception {
        runOnFxVoid(() -> selectLine(2));
        waitMs(150);
        doAction(copyMethod, "copy");
        waitMs(200);

        assertThat(runOnFx(this::getClipboard)).contains("bravo");
        assertThat(runOnFx(() -> editor.getModel_().getValue())).isEqualTo(INITIAL);

        runOnFxVoid(this::moveCursorToEnd);
        waitMs(100);
        doAction(pasteMethod, "paste");
        waitMs(300);

        String after = runOnFx(() -> editor.getModel_().getValue());
        assertThat(after).contains("bravo");
        assertThat(after).startsWith(INITIAL.substring(0, INITIAL.indexOf("bravo") + 5));
    }

    private void testCut(Method cutMethod, Method pasteMethod) throws Exception {
        runOnFxVoid(() -> selectLine(2));
        waitMs(150);
        doAction(cutMethod, "cut");
        waitMs(200);

        assertThat(runOnFx(this::getClipboard)).contains("bravo");
        assertThat(runOnFx(() -> editor.getModel_().getValue())).doesNotContain("bravo");

        runOnFxVoid(this::moveCursorToEnd);
        waitMs(100);
        doAction(pasteMethod, "paste");
        waitMs(300);

        assertThat(runOnFx(() -> editor.getModel_().getValue())).contains("bravo");
    }

    private void testPaste(Method pasteMethod, boolean prePopulated) throws Exception {
        runOnFxVoid(this::moveCursorToEnd);
        waitMs(100);

        if (prePopulated) {
            doAction(pasteMethod, "paste");
            waitMs(300);
            assertThat(runOnFx(() -> editor.getModel_().getValue())).contains(PRE_CLIP);
        } else {
            String before = runOnFx(() -> editor.getModel_().getValue());
            doAction(pasteMethod, "paste");
            waitMs(300);
            assertThat(runOnFx(() -> editor.getModel_().getValue())).isEqualTo(before);
        }
    }

    private void doAction(Method method, String action) throws Exception {
        switch (method) {
            case KEYBOARD -> doKeyboard(action);
            case CONTEXT_MENU -> doContextMenu(action);
        }
    }

    private static final boolean IS_MAC =
            System.getProperty("os.name", "").toLowerCase().contains("mac");
    // XXX Robot doesn't really work on macOS it seems
    private void doKeyboard(String action) throws Exception {
        KeyCode key =
                switch (action) {
                    case "copy" -> KeyCode.C;
                    case "cut" -> KeyCode.X;
                    case "paste" -> KeyCode.V;
                    default -> throw new IllegalArgumentException(action);
                };
        runOnFx(() -> {
            editor.focus();
            pane.getWebView().fireEvent(new KeyEvent(KeyEvent.KEY_PRESSED, "", "", key, false, !IS_MAC, false, IS_MAC));
            return null;
        });
    }

    private void doContextMenu(String action) throws Exception {
        runOnFx(() -> {
            editor.focus();
            if ("paste".equals(action)) {
                String text = Clipboard.getSystemClipboard().getString();
                if (text != null && !text.isEmpty()) {
                    JSObject payload = ctx.newObject();
                    ((JSObject) payload).setMember("text", text);
                    editor.trigger("menu", "type", payload);
                }
            } else {
                ctx.engine.executeScript("document.execCommand('" + action + "')");
            }
            return null;
        });
    }

    private void selectLine(int line) {
        ITextModel model = editor.getModel_();
        String content = model.getLineContent((double) line);
        editor.setSelection(new IRange(ctx)
                .startLineNumber((double) line)
                .startColumn(1.0)
                .endLineNumber((double) line)
                .endColumn((double) (content.length() + 1)));
        editor.focus();
    }

    private void moveCursorToEnd() {
        ITextModel model = editor.getModel_();
        double last = model.getLineCount();
        String content = model.getLineContent(last);
        editor.setPosition(new IPosition(ctx).lineNumber(last).column((double) (content.length() + 1)));
        editor.focus();
    }

    private void setClipboard(String text) {
        var cc = new ClipboardContent();
        cc.putString(text);
        Clipboard.getSystemClipboard().setContent(cc);
    }

    private String getClipboard() {
        String s = Clipboard.getSystemClipboard().getString();
        return s != null ? s : "";
    }
}
