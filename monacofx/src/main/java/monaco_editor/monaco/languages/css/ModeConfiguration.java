
package monaco_editor.monaco.languages.css;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:6606:38}<br>
 * Original signature:<br>
 * {@code export interface ModeConfiguration  }<br>
 */
@SuppressWarnings("unused")
public class ModeConfiguration extends JsProxy {

	public ModeConfiguration(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public ModeConfiguration(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Defines whether the built-in color provider is enabled.</p>
	 * See {@code monaco.d.ts:6645:23}<br>
	 * Original signature:<br>
	 * {@code readonly colors?: boolean; }<br>
	 */
	public boolean colors() { return get("colors", ofMapped(boolean.class)); }

 	/**
	 * <p>Defines whether the built-in completionItemProvider is enabled.</p>
	 * See {@code monaco.d.ts:6610:32}<br>
	 * Original signature:<br>
	 * {@code readonly completionItems?: boolean; }<br>
	 */
	public boolean completionItems() { return get("completionItems", ofMapped(boolean.class)); }

 	/**
	 * <p>Defines whether the built-in definitions provider is enabled.</p>
	 * See {@code monaco.d.ts:6625:28}<br>
	 * Original signature:<br>
	 * {@code readonly definitions?: boolean; }<br>
	 */
	public boolean definitions() { return get("definitions", ofMapped(boolean.class)); }

 	/**
	 * <p>Defines whether the built-in diagnostic provider is enabled.</p>
	 * See {@code monaco.d.ts:6655:28}<br>
	 * Original signature:<br>
	 * {@code readonly diagnostics?: boolean; }<br>
	 */
	public boolean diagnostics() { return get("diagnostics", ofMapped(boolean.class)); }

 	/**
	 * <p>Defines whether the built-in references provider is enabled.</p>
	 * See {@code monaco.d.ts:6635:35}<br>
	 * Original signature:<br>
	 * {@code readonly documentHighlights?: boolean; }<br>
	 */
	public boolean documentHighlights() { return get("documentHighlights", ofMapped(boolean.class)); }

 	/**
	 * <p>Defines whether the built-in documentSymbolProvider is enabled.</p>
	 * See {@code monaco.d.ts:6620:32}<br>
	 * Original signature:<br>
	 * {@code readonly documentSymbols?: boolean; }<br>
	 */
	public boolean documentSymbols() { return get("documentSymbols", ofMapped(boolean.class)); }

 	/**
	 * <p>Defines whether the built-in foldingRange provider is enabled.</p>
	 * See {@code monaco.d.ts:6650:30}<br>
	 * Original signature:<br>
	 * {@code readonly foldingRanges?: boolean; }<br>
	 */
	public boolean foldingRanges() { return get("foldingRanges", ofMapped(boolean.class)); }

 	/**
	 * <p>Defines whether the built-in hoverProvider is enabled.</p>
	 * See {@code monaco.d.ts:6615:23}<br>
	 * Original signature:<br>
	 * {@code readonly hovers?: boolean; }<br>
	 */
	public boolean hovers() { return get("hovers", ofMapped(boolean.class)); }

 	/**
	 * <p>Defines whether the built-in references provider is enabled.</p>
	 * See {@code monaco.d.ts:6630:27}<br>
	 * Original signature:<br>
	 * {@code readonly references?: boolean; }<br>
	 */
	public boolean references() { return get("references", ofMapped(boolean.class)); }

 	/**
	 * <p>Defines whether the built-in rename provider is enabled.</p>
	 * See {@code monaco.d.ts:6640:23}<br>
	 * Original signature:<br>
	 * {@code readonly rename?: boolean; }<br>
	 */
	public boolean rename() { return get("rename", ofMapped(boolean.class)); }

 	/**
	 * <p>Defines whether the built-in selection range provider is enabled.</p>
	 * See {@code monaco.d.ts:6660:32}<br>
	 * Original signature:<br>
	 * {@code readonly selectionRanges?: boolean; }<br>
	 */
	public boolean selectionRanges() { return get("selectionRanges", ofMapped(boolean.class)); }

 
}
