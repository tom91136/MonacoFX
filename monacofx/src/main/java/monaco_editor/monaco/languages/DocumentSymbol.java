
package monaco_editor.monaco.languages;
import java.util.List;
import javax.annotation.Nonnull;
import monaco_editor.monaco.IRange;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:5676:35}<br>
 * Original signature:<br>
 * {@code export interface DocumentSymbol  }<br>
 */
@SuppressWarnings("unused")
public class DocumentSymbol extends JsProxy {

	public DocumentSymbol(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public DocumentSymbol(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5684:16}<br>
	 * Original signature:<br>
	 * {@code children?: DocumentSymbol[]; }<br>
	 */
	public List<DocumentSymbol> children() { return get("children", ofArray(DocumentSymbol::new)); }

 	/**
	 * See {@code monaco.d.ts:5684:16}<br>
	 * Original signature:<br>
	 * {@code children?: DocumentSymbol[]; }<br>
	 */
	public DocumentSymbol children(@Nonnull List<DocumentSymbol> value) {
		
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5681:21}<br>
	 * Original signature:<br>
	 * {@code containerName?: string; }<br>
	 */
	public String containerName() { return get("containerName", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:5681:21}<br>
	 * Original signature:<br>
	 * {@code containerName?: string; }<br>
	 */
	public DocumentSymbol containerName(@Nonnull String value) {
		set("containerName", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5678:14}<br>
	 * Original signature:<br>
	 * {@code detail: string; }<br>
	 */
	public String detail() { return get("detail", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:5678:14}<br>
	 * Original signature:<br>
	 * {@code detail: string; }<br>
	 */
	public DocumentSymbol detail(@Nonnull String value) {
		set("detail", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5679:12}<br>
	 * Original signature:<br>
	 * {@code kind: SymbolKind; }<br>
	 */
	public SymbolKind kind() { return get("kind", ofJsEnum(SymbolKind.class)); }

 	/**
	 * See {@code monaco.d.ts:5679:12}<br>
	 * Original signature:<br>
	 * {@code kind: SymbolKind; }<br>
	 */
	public DocumentSymbol kind(@Nonnull SymbolKind value) {
		set("kind", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5677:12}<br>
	 * Original signature:<br>
	 * {@code name: string; }<br>
	 */
	public String name() { return get("name", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:5677:12}<br>
	 * Original signature:<br>
	 * {@code name: string; }<br>
	 */
	public DocumentSymbol name(@Nonnull String value) {
		set("name", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5682:13}<br>
	 * Original signature:<br>
	 * {@code range: IRange; }<br>
	 */
	public IRange range() { return get("range", IRange::new); }

 	/**
	 * See {@code monaco.d.ts:5682:13}<br>
	 * Original signature:<br>
	 * {@code range: IRange; }<br>
	 */
	public DocumentSymbol range(@Nonnull IRange value) {
		set("range", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5683:22}<br>
	 * Original signature:<br>
	 * {@code selectionRange: IRange; }<br>
	 */
	public IRange selectionRange() { return get("selectionRange", IRange::new); }

 	/**
	 * See {@code monaco.d.ts:5683:22}<br>
	 * Original signature:<br>
	 * {@code selectionRange: IRange; }<br>
	 */
	public DocumentSymbol selectionRange(@Nonnull IRange value) {
		set("selectionRange", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5680:12}<br>
	 * Original signature:<br>
	 * {@code tags: ReadonlyArray<SymbolTag>; }<br>
	 */
	public List<SymbolTag> tags() { return get("tags", ofArray(ofJsEnum(SymbolTag.class))); }

 	/**
	 * See {@code monaco.d.ts:5680:12}<br>
	 * Original signature:<br>
	 * {@code tags: ReadonlyArray<SymbolTag>; }<br>
	 */
	public DocumentSymbol tags(@Nonnull List<SymbolTag> value) {
		
		return this;
	}

 
}
