package net.kurobako.monacofx;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import monaco_editor.monaco.editor.ITextModel;
import monaco_editor.monaco.languages.ILanguageExtensionPoint;
import org.junit.jupiter.api.Test;

/** End-to-end tests exercising the generated Java API against a live Monaco instance. */
class JsBridgeTest extends MonacoPaneTestBase {

    @Test
    void monacoModuleIsAccessible() throws Exception {
        assertThat(runOnFx(() -> ctx.monaco())).isNotNull();
    }

    @Test
    void languagesContainsBuiltins() throws Exception {
        List<String> ids = runOnFx(() -> ctx.monaco().languages().getLanguages().stream()
                .map(ILanguageExtensionPoint::id)
                .collect(Collectors.toList()));
        assertThat(ids)
                .contains("javascript", "typescript", "css", "html", "json")
                .hasSizeGreaterThan(10);
    }

    @Test
    void createModelReturnsCorrectValue() throws Exception {
        String content = "const x = 42;";
        ITextModel model = runOnFx(() -> ctx.monaco().editor().createModel(content, "javascript"));
        String actual = runOnFx(model::getValue);
        assertThat(actual).isEqualTo(content);
    }

    @Test
    void createMultilineModelHasCorrectLineCount() throws Exception {
        ITextModel model = runOnFx(() -> ctx.monaco().editor().createModel("alpha\nbeta\ngamma", "plaintext"));
        assertThat(runOnFx(model::getLineCount)).isEqualTo(3.0);
    }

    @Test
    void createMultilineModelGetLineContent() throws Exception {
        ITextModel model = runOnFx(() -> ctx.monaco().editor().createModel("first\nsecond\nthird", "plaintext"));
        assertThat(runOnFx(() -> model.getLineContent(2.0))).isEqualTo("second");
    }

    @Test
    void getModelsIncludesCreatedModel() throws Exception {
        ITextModel model =
                runOnFx(() -> ctx.monaco().editor().createModel("// sentinel " + System.nanoTime(), "javascript"));
        String createdId = runOnFx(model::id);
        List<String> allIds = runOnFx(() ->
                ctx.monaco().editor().getModels().stream().map(ITextModel::id).collect(Collectors.toList()));
        assertThat(allIds).contains(createdId);
    }

    @Test
    void modelIdIsNonBlank() throws Exception {
        ITextModel model = runOnFx(() -> ctx.monaco().editor().createModel("// id test", "javascript"));
        String id = runOnFx(model::id);
        assertThat(id).isNotBlank();
    }

    /**
     * Verifies that Web Workers are functional under the classpath: protocol.
     *
     * <p>Calls {@code monaco.languages.typescript.getTypeScriptWorker()} which returns a Promise that only resolves if
     * the TS worker was successfully spawned and is responding.
     */
    @Test
    void typeScriptWorkerIsAlive() throws Exception {
        AtomicReference<String> result = new AtomicReference<>();

        runOnFxVoid(() -> {
            // Install a callback that the JS promise chain will invoke.
            ctx.engine.executeScript("(function(){"
                    + "  window.__workerTestResult = 'pending';"
                    + "  monaco.languages.typescript.getTypeScriptWorker()"
                    + "    .then(function(worker){ return worker(monaco.Uri.parse('inmemory://model/1')); })"
                    + "    .then(function(client){"
                    + "      window.__workerTestResult = client ? 'alive' : 'null-client';"
                    + "    })"
                    + "    .catch(function(e){ window.__workerTestResult = 'error:' + e; });"
                    + "})()");
        });

        // Poll for the async result (worker init can take a moment).
        for (int i = 0; i < 40; i++) {
            waitMs(250);
            String r = runOnFx(() -> {
                Object v = ctx.engine.executeScript("window.__workerTestResult");
                return v == null ? "null" : v.toString();
            });
            if (!"pending".equals(r)) {
                result.set(r);
                break;
            }
        }

        assertThat(result.get())
                .describedAs("TypeScript worker should be reachable via classpath: protocol")
                .isEqualTo("alive");
    }
}
