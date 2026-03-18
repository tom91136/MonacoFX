package net.kurobako.monacofx;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import monaco_editor.monaco.editor.ICodeEditor;
import net.kurobako.monacofx.MonacoPane.MonacoContext;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

/**
 * Shared setup/teardown for all MonacoPane integration tests.
 *
 * <p>Boots the JavaFX platform, creates a {@link MonacoPane} in a {@link Stage}, waits for Monaco to load, and exposes
 * the context, pane, stage, and editor to subclasses.
 *
 * <p>Requires a display (real or virtual). Use {@code xvfb-run} or manual {@code Xvfb} in CI.
 */
abstract class MonacoPaneTestBase {

    protected static MonacoContext ctx;
    protected static Stage stage;
    protected static MonacoPane pane;
    protected static ICodeEditor editor;

    @BeforeAll
    static void startMonaco() throws Exception {
        assumeTrue(hasDisplay(), "Skipping: no DISPLAY set (use xvfb-run in CI)");

        ensureFxRunning();

        CountDownLatch monacoLoaded = new CountDownLatch(1);
        AtomicReference<MonacoContext> ref = new AtomicReference<>();
        AtomicReference<Throwable> error = new AtomicReference<>();

        Platform.runLater(() -> {
            try {
                pane = new MonacoPane();
                pane.editorProperty().addListener((obs, old, val) -> {
                    if (val != null) {
                        ref.set(val);
                        monacoLoaded.countDown();
                    }
                });
                if (pane.getEditor() != null) {
                    ref.set(pane.getEditor());
                    monacoLoaded.countDown();
                }
                stage = new Stage();
                stage.setScene(new Scene(new StackPane(pane), 800, 600));
                stage.show();
            } catch (Throwable t) {
                error.set(t);
                monacoLoaded.countDown();
            }
        });

        if (!monacoLoaded.await(60, TimeUnit.SECONDS)) throw new AssertionError("Monaco did not load within 60 s");
        if (error.get() != null) throw new RuntimeException("Setup failed", error.get());

        ctx = ref.get();
        assertThat(ctx).isNotNull();
        editor = runOnFx(() -> ctx.monaco().editor().getEditors().get(0));
        Thread.sleep(500);
    }

    @AfterAll
    static void tearDown() {
        Thread t = new Thread(Platform::exit);
        t.setDaemon(true);
        t.start();
    }

    @FunctionalInterface
    protected interface FxCallable<T> {
        T call() throws Exception;
    }

    protected static <T> T runOnFx(FxCallable<T> task) throws Exception {
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

    protected static void runOnFxVoid(Runnable task) throws Exception {
        runOnFx(() -> {
            task.run();
            return null;
        });
    }

    private static boolean hasDisplay() {
        String d = System.getenv("DISPLAY");
        return d != null && !d.isBlank();
    }

    private static void ensureFxRunning() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        try {
            Platform.startup(latch::countDown);
        } catch (IllegalStateException alreadyRunning) {
            latch.countDown();
        }
        if (!latch.await(15, TimeUnit.SECONDS)) throw new AssertionError("JavaFX platform did not start");
    }
}
