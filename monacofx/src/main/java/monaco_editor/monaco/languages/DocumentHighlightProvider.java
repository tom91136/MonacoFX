
package monaco_editor.monaco.languages;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import monaco_editor.monaco.CancellationToken;
import monaco_editor.monaco.Position;
import monaco_editor.monaco.editor.ITextModel;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsPromise;
import net.kurobako.monacofx.js.JsProxy;
import net.kurobako.monacofx.js.JsUnion2;

/**
 * <p>The document highlight provider interface defines the contract between extensions and
 * the word-highlight-feature.</p>
 * See {@code monaco.d.ts:5527:46}<br>
 * Original signature:<br>
 * {@code export interface DocumentHighlightProvider  }<br>
 */
@SuppressWarnings("unused")
public class DocumentHighlightProvider extends JsProxy {

	public DocumentHighlightProvider(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public DocumentHighlightProvider(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Provide a set of document highlights, like all occurrences of a variable or
	 * all exit-points of a function.</p>
	 * See {@code monaco.d.ts:5532:33}<br>
	 * Original signature:<br>
	 * {@code provideDocumentHighlights(model: editor.ITextModel, position: Position, token: CancellationToken): ProviderResult<DocumentHighlight[]>; }<br>
	 */
	public Optional<JsUnion2<List<DocumentHighlight>, JsPromise<List<DocumentHighlight>>>> provideDocumentHighlights(@Nonnull ITextModel model, @Nonnull Position position, @Nonnull CancellationToken token) { return Optional.ofNullable(call("provideDocumentHighlights", null /*union*/, model, position, token)); }

 
}
