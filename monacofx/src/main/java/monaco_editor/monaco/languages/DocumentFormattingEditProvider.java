
package monaco_editor.monaco.languages;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import monaco_editor.monaco.CancellationToken;
import monaco_editor.monaco.editor.ITextModel;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsPromise;
import net.kurobako.monacofx.js.JsProxy;
import net.kurobako.monacofx.js.JsUnion2;
import netscape.javascript.JSObject;

/**
 * <p>The document formatting provider interface defines the contract between extensions and
 * the formatting-feature.</p>
 * See {@code monaco.d.ts:5723:51}<br>
 * Original signature:<br>
 * {@code export interface DocumentFormattingEditProvider  }<br>
 */
@SuppressWarnings("unused")
public class DocumentFormattingEditProvider extends JsProxy {

	public DocumentFormattingEditProvider(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public DocumentFormattingEditProvider(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5724:28}<br>
	 * Original signature:<br>
	 * {@code readonly displayName?: string; }<br>
	 */
	public String displayName() { return get("displayName", ofMapped(String.class)); }

 	/**
	 * <p>Provide formatting edits for a whole document.</p>
	 * See {@code monaco.d.ts:5728:38}<br>
	 * Original signature:<br>
	 * {@code provideDocumentFormattingEdits(model: editor.ITextModel, options: FormattingOptions, token: CancellationToken): ProviderResult<TextEdit[]>; }<br>
	 */
	public Optional<JsUnion2<List<JSObject>, JsPromise<List<JSObject>>>> provideDocumentFormattingEdits(@Nonnull ITextModel model, @Nonnull FormattingOptions options, @Nonnull CancellationToken token) { return Optional.ofNullable(call("provideDocumentFormattingEdits", null /*union*/, model, options, token)); }

 
}
