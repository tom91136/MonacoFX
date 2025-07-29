
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:5075:37}<br>
 * Original signature:<br>
 * {@code export interface IAutoClosingPair  }<br>
 */
@SuppressWarnings("unused")
public class IAutoClosingPair extends JsProxy {

	public IAutoClosingPair(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IAutoClosingPair(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5077:13}<br>
	 * Original signature:<br>
	 * {@code close: string; }<br>
	 */
	public String close() { return get("close", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:5077:13}<br>
	 * Original signature:<br>
	 * {@code close: string; }<br>
	 */
	public IAutoClosingPair close(@Nonnull String value) {
		set("close", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5076:12}<br>
	 * Original signature:<br>
	 * {@code open: string; }<br>
	 */
	public String open() { return get("open", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:5076:12}<br>
	 * Original signature:<br>
	 * {@code open: string; }<br>
	 */
	public IAutoClosingPair open(@Nonnull String value) {
		set("open", value);
		return this;
	}

 
}
