
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:1250:31}<br>
 * Original signature:<br>
 * {@code export interface ThemeColor  }<br>
 */
@SuppressWarnings("unused")
public class ThemeColor extends JsProxy {

	public ThemeColor(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public ThemeColor(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:1251:10}<br>
	 * Original signature:<br>
	 * {@code id: string; }<br>
	 */
	public String id() { return get("id", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:1251:10}<br>
	 * Original signature:<br>
	 * {@code id: string; }<br>
	 */
	public ThemeColor id(@Nonnull String value) {
		set("id", value);
		return this;
	}

 
}
