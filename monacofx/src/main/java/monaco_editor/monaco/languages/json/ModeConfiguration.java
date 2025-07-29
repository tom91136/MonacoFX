
package monaco_editor.monaco.languages.json;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:6714:38}<br>
 * Original signature:<br>
 * {@code export interface ModeConfiguration  }<br>
 */
@SuppressWarnings("unused")
public class ModeConfiguration extends JsProxy {

	public ModeConfiguration(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public ModeConfiguration(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Defines whether the built-in color provider is enabled.</p>
	 * See {@code monaco.d.ts:6748:23}<br>
	 * Original signature:<br>
	 * {@code readonly colors?: boolean; }<br>
	 */
	public boolean colors() { return get("colors", ofMapped(boolean.class)); }

 	/**
	 * <p>Defines whether the built-in completionItemProvider is enabled.</p>
	 * See {@code monaco.d.ts:6728:32}<br>
	 * Original signature:<br>
	 * {@code readonly completionItems?: boolean; }<br>
	 */
	public boolean completionItems() { return get("completionItems", ofMapped(boolean.class)); }

 	/**
	 * <p>Defines whether the built-in diagnostic provider is enabled.</p>
	 * See {@code monaco.d.ts:6758:28}<br>
	 * Original signature:<br>
	 * {@code readonly diagnostics?: boolean; }<br>
	 */
	public boolean diagnostics() { return get("diagnostics", ofMapped(boolean.class)); }

 	/**
	 * <p>Defines whether the built-in documentFormattingEdit provider is enabled.</p>
	 * See {@code monaco.d.ts:6718:40}<br>
	 * Original signature:<br>
	 * {@code readonly documentFormattingEdits?: boolean; }<br>
	 */
	public boolean documentFormattingEdits() { return get("documentFormattingEdits", ofMapped(boolean.class)); }

 	/**
	 * <p>Defines whether the built-in documentRangeFormattingEdit provider is enabled.</p>
	 * See {@code monaco.d.ts:6723:45}<br>
	 * Original signature:<br>
	 * {@code readonly documentRangeFormattingEdits?: boolean; }<br>
	 */
	public boolean documentRangeFormattingEdits() { return get("documentRangeFormattingEdits", ofMapped(boolean.class)); }

 	/**
	 * <p>Defines whether the built-in documentSymbolProvider is enabled.</p>
	 * See {@code monaco.d.ts:6738:32}<br>
	 * Original signature:<br>
	 * {@code readonly documentSymbols?: boolean; }<br>
	 */
	public boolean documentSymbols() { return get("documentSymbols", ofMapped(boolean.class)); }

 	/**
	 * <p>Defines whether the built-in foldingRange provider is enabled.</p>
	 * See {@code monaco.d.ts:6753:30}<br>
	 * Original signature:<br>
	 * {@code readonly foldingRanges?: boolean; }<br>
	 */
	public boolean foldingRanges() { return get("foldingRanges", ofMapped(boolean.class)); }

 	/**
	 * <p>Defines whether the built-in hoverProvider is enabled.</p>
	 * See {@code monaco.d.ts:6733:23}<br>
	 * Original signature:<br>
	 * {@code readonly hovers?: boolean; }<br>
	 */
	public boolean hovers() { return get("hovers", ofMapped(boolean.class)); }

 	/**
	 * <p>Defines whether the built-in selection range provider is enabled.</p>
	 * See {@code monaco.d.ts:6763:32}<br>
	 * Original signature:<br>
	 * {@code readonly selectionRanges?: boolean; }<br>
	 */
	public boolean selectionRanges() { return get("selectionRanges", ofMapped(boolean.class)); }

 	/**
	 * <p>Defines whether the built-in tokens provider is enabled.</p>
	 * See {@code monaco.d.ts:6743:23}<br>
	 * Original signature:<br>
	 * {@code readonly tokens?: boolean; }<br>
	 */
	public boolean tokens() { return get("tokens", ofMapped(boolean.class)); }

 
}
