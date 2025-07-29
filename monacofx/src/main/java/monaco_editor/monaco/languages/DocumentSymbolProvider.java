
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

/**
 * <p>The document symbol provider interface defines the contract between extensions and
 * the <a href="https://code.visualstudio.com/docs/editor/editingevolved#_go-to-symbol">go to symbol</a>-feature.</p>
 * See {@code monaco.d.ts:5691:43}<br>
 * Original signature:<br>
 * {@code export interface DocumentSymbolProvider  }<br>
 */
@SuppressWarnings("unused")
public class DocumentSymbolProvider extends JsProxy {

	public DocumentSymbolProvider(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public DocumentSymbolProvider(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5692:19}<br>
	 * Original signature:<br>
	 * {@code displayName?: string; }<br>
	 */
	public String displayName() { return get("displayName", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:5692:19}<br>
	 * Original signature:<br>
	 * {@code displayName?: string; }<br>
	 */
	public DocumentSymbolProvider displayName(@Nonnull String value) {
		set("displayName", value);
		return this;
	}

 	/**
	 * <p>Provide symbol information for the given document.</p>
	 * See {@code monaco.d.ts:5696:30}<br>
	 * Original signature:<br>
	 * {@code provideDocumentSymbols(model: editor.ITextModel, token: CancellationToken): ProviderResult<DocumentSymbol[]>; }<br>
	 */
	public Optional<JsUnion2<List<DocumentSymbol>, JsPromise<List<DocumentSymbol>>>> provideDocumentSymbols(@Nonnull ITextModel model, @Nonnull CancellationToken token) { return Optional.ofNullable(call("provideDocumentSymbols", null /*union*/, model, token)); }

 
}
