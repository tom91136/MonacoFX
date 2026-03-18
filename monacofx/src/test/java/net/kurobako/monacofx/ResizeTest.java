package net.kurobako.monacofx;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Offset.offset;

import monaco_editor.monaco.editor.EditorLayoutInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Tests that the Monaco editor correctly fills its container after resize. */
class ResizeTest extends MonacoPaneTestBase {

    private static final double W = 800, H = 600;

    @BeforeEach
    void resetSize() throws Exception {
        resizeStage(W, H);
        Thread.sleep(500);
    }

    @Test
    void editorFillsViewAtInitialSize() throws Exception {
        assertEditorFillsContainer();
    }

    @Test
    void editorFillsViewAfterEnlarge() throws Exception {
        resizeStage(1200, 900);
        assertEditorFillsContainer();
    }

    @Test
    void editorFillsViewAfterShrink() throws Exception {
        resizeStage(400, 300);
        assertEditorFillsContainer();
    }

    @Test
    void editorFillsViewAfterEnlargeThenShrink() throws Exception {
        resizeStage(1100, 800);
        assertEditorFillsContainer();
        resizeStage(500, 350);
        assertEditorFillsContainer();
    }

    @Test
    void editorFillsViewAfterShrinkThenEnlarge() throws Exception {
        resizeStage(300, 200);
        assertEditorFillsContainer();
        resizeStage(900, 700);
        assertEditorFillsContainer();
    }

    private void resizeStage(double w, double h) throws Exception {
        runOnFx(() -> {
            stage.setWidth(w);
            stage.setHeight(h);
            stage.getScene().getRoot().applyCss();
            stage.getScene().getRoot().layout();
            return null;
        });
        Thread.sleep(200);
        runOnFx(() -> {
            ctx.engine.executeScript("(function(){" + "  var eds=monaco.editor.getEditors();"
                    + "  for(var i=0;i<eds.length;i++)eds[i].layout();"
                    + "})()");
            return null;
        });
    }

    private void assertEditorFillsContainer() throws Exception {
        double tolerance = 5.0;
        double[] sizes = null;
        for (int i = 0; i < 20; i++) {
            sizes = runOnFx(() -> {
                EditorLayoutInfo layout = editor.getLayoutInfo();
                return new double[] {pane.getWidth(), pane.getHeight(), layout.width(), layout.height()};
            });
            if (Math.abs(sizes[2] - sizes[0]) <= tolerance && Math.abs(sizes[3] - sizes[1]) <= tolerance) return;
            Thread.sleep(250);
        }
        assertThat(sizes[2]).as("editor width").isCloseTo(sizes[0], offset(tolerance));
        assertThat(sizes[3]).as("editor height").isCloseTo(sizes[1], offset(tolerance));
    }
}
