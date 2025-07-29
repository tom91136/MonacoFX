
package monaco_editor.monaco.languages;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import monaco_editor.monaco.CancellationToken;
import monaco_editor.monaco.Range;
import monaco_editor.monaco.editor.ITextModel;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsPromise;
import net.kurobako.monacofx.js.JsProxy;
import net.kurobako.monacofx.js.JsUnion2;
import netscape.javascript.JSObject;

/**
 * <p>The document formatting provider interface defines the contract between extensions and
 * the formatting-feature.</p>
 * See {@code monaco.d.ts:5735:56}<br>
 * Original signature:<br>
 * {@code export interface DocumentRangeFormattingEditProvider  }<br>
 */
@SuppressWarnings("unused")
public class DocumentRangeFormattingEditProvider extends JsProxy {

	public DocumentRangeFormattingEditProvider(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public DocumentRangeFormattingEditProvider(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5736:28}<br>
	 * Original signature:<br>
	 * {@code readonly displayName?: string; }<br>
	 */
	public String displayName() { return get("displayName", ofMapped(String.class)); }

 	/**
	 * <p>Provide formatting edits for a range in a document.
	 * The given range is a hint and providers can decide to format a smaller
	 * or larger range. Often this is done by adjusting the start and end
	 * of the range to full syntax nodes.</p>
	 * See {@code monaco.d.ts:5744:43}<br>
	 * Original signature:<br>
	 * {@code provideDocumentRangeFormattingEdits(model: editor.ITextModel, range: Range, options: FormattingOptions, token: CancellationToken): ProviderResult<TextEdit[]>; }<br>
	 */
	public Optional<JsUnion2<List<JSObject>, JsPromise<List<JSObject>>>> provideDocumentRangeFormattingEdits(@Nonnull ITextModel model, @Nonnull Range range, @Nonnull FormattingOptions options, @Nonnull CancellationToken token) { return Optional.ofNullable(call("provideDocumentRangeFormattingEdits", null /*union*/, model, range, options, token)); }

 
}
