
package monaco_editor.monaco.languages;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import monaco_editor.monaco.CancellationToken;
import monaco_editor.monaco.editor.ITextModel;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsPromise;
import net.kurobako.monacofx.js.JsProxy;
import net.kurobako.monacofx.js.JsUnion2;
import net.kurobako.monacofx.js.JsUnion3;

/**
 * See {@code monaco.d.ts:6018:51}<br>
 * Original signature:<br>
 * {@code export interface DocumentSemanticTokensProvider  }<br>
 */
@SuppressWarnings("unused")
public class DocumentSemanticTokensProvider extends JsProxy {

	public DocumentSemanticTokensProvider(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public DocumentSemanticTokensProvider(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:6019:17}<br>
	 * Original signature:<br>
	 * {@code getLegend(): SemanticTokensLegend; }<br>
	 */
	public SemanticTokensLegend getLegend() { return call("getLegend", SemanticTokensLegend::new); }

 	/**
	 * See {@code monaco.d.ts:6020:37}<br>
	 * Original signature:<br>
	 * {@code provideDocumentSemanticTokens(model: editor.ITextModel, lastResultId: string | null, token: CancellationToken): ProviderResult<SemanticTokens | SemanticTokensEdits>; }<br>
	 */
	public Optional<JsUnion3<SemanticTokens, SemanticTokensEdits, JsPromise<JsUnion2<SemanticTokens, SemanticTokensEdits>>>> provideDocumentSemanticTokens(@Nonnull ITextModel model, @Nullable String lastResultId, @Nonnull CancellationToken token) { return Optional.ofNullable(call("provideDocumentSemanticTokens", null /*union*/, model, lastResultId, token)); }

 	/**
	 * See {@code monaco.d.ts:6021:37}<br>
	 * Original signature:<br>
	 * {@code releaseDocumentSemanticTokens(resultId: string | undefined): void; }<br>
	 */
	public void releaseDocumentSemanticTokens(@Nullable String resultId) { call("releaseDocumentSemanticTokens", ofVoid(), resultId); }

 
}
