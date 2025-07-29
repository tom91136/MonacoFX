
package monaco_editor.monaco.languages;
import java.util.Optional;
import javax.annotation.Nonnull;
import monaco_editor.monaco.CancellationToken;
import monaco_editor.monaco.Range;
import monaco_editor.monaco.editor.ITextModel;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsPromise;
import net.kurobako.monacofx.js.JsProxy;
import net.kurobako.monacofx.js.JsUnion2;

/**
 * See {@code monaco.d.ts:6024:56}<br>
 * Original signature:<br>
 * {@code export interface DocumentRangeSemanticTokensProvider  }<br>
 */
@SuppressWarnings("unused")
public class DocumentRangeSemanticTokensProvider extends JsProxy {

	public DocumentRangeSemanticTokensProvider(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public DocumentRangeSemanticTokensProvider(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:6025:17}<br>
	 * Original signature:<br>
	 * {@code getLegend(): SemanticTokensLegend; }<br>
	 */
	public SemanticTokensLegend getLegend() { return call("getLegend", SemanticTokensLegend::new); }

 	/**
	 * See {@code monaco.d.ts:6026:42}<br>
	 * Original signature:<br>
	 * {@code provideDocumentRangeSemanticTokens(model: editor.ITextModel, range: Range, token: CancellationToken): ProviderResult<SemanticTokens>; }<br>
	 */
	public Optional<JsUnion2<SemanticTokens, JsPromise<SemanticTokens>>> provideDocumentRangeSemanticTokens(@Nonnull ITextModel model, @Nonnull Range range, @Nonnull CancellationToken token) { return Optional.ofNullable(call("provideDocumentRangeSemanticTokens", null /*union*/, model, range, token)); }

 
}
