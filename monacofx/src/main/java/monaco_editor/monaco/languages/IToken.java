
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>A token.</p>
 * See {@code monaco.d.ts:4682:27}<br>
 * Original signature:<br>
 * {@code export interface IToken  }<br>
 */
@SuppressWarnings("unused")
public class IToken extends JsProxy {

	public IToken(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IToken(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:4684:14}<br>
	 * Original signature:<br>
	 * {@code scopes: string; }<br>
	 */
	public String scopes() { return get("scopes", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:4684:14}<br>
	 * Original signature:<br>
	 * {@code scopes: string; }<br>
	 */
	public IToken scopes(@Nonnull String value) {
		set("scopes", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:4683:18}<br>
	 * Original signature:<br>
	 * {@code startIndex: number; }<br>
	 */
	public double startIndex() { return get("startIndex", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:4683:18}<br>
	 * Original signature:<br>
	 * {@code startIndex: number; }<br>
	 */
	public IToken startIndex(@Nonnull Double value) {
		set("startIndex", value);
		return this;
	}

 
}
