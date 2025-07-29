
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>Describes language specific folding markers such as '#region' and '#endregion'.
 * The start and end regexes will be tested against the contents of all lines and must be designed efficiently:</p>
 * <ul>
 * <li>the regex should start with '^'</li>
 * <li>regexp flags (i, g) are ignored</li>
 * </ul>
 * See {@code monaco.d.ts:5011:35}<br>
 * Original signature:<br>
 * {@code export interface FoldingMarkers  }<br>
 */
@SuppressWarnings("unused")
public class FoldingMarkers extends JsProxy {

	public FoldingMarkers(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public FoldingMarkers(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5013:11}<br>
	 * Original signature:<br>
	 * {@code end: RegExp; }<br>
	 */
	public String end() { return get("end", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:5013:11}<br>
	 * Original signature:<br>
	 * {@code end: RegExp; }<br>
	 */
	public FoldingMarkers end(@Nonnull String value) {
		set("end", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5012:13}<br>
	 * Original signature:<br>
	 * {@code start: RegExp; }<br>
	 */
	public String start() { return get("start", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:5012:13}<br>
	 * Original signature:<br>
	 * {@code start: RegExp; }<br>
	 */
	public FoldingMarkers start(@Nonnull String value) {
		set("start", value);
		return this;
	}

 
}
