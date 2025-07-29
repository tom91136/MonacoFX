
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:967:36}<br>
 * Original signature:<br>
 * {@code export interface ITokenThemeRule  }<br>
 */
@SuppressWarnings("unused")
public class ITokenThemeRule extends JsProxy {

	public ITokenThemeRule(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public ITokenThemeRule(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:970:18}<br>
	 * Original signature:<br>
	 * {@code background?: string; }<br>
	 */
	public String background() { return get("background", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:970:18}<br>
	 * Original signature:<br>
	 * {@code background?: string; }<br>
	 */
	public ITokenThemeRule background(@Nonnull String value) {
		set("background", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:971:17}<br>
	 * Original signature:<br>
	 * {@code fontStyle?: string; }<br>
	 */
	public String fontStyle() { return get("fontStyle", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:971:17}<br>
	 * Original signature:<br>
	 * {@code fontStyle?: string; }<br>
	 */
	public ITokenThemeRule fontStyle(@Nonnull String value) {
		set("fontStyle", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:969:18}<br>
	 * Original signature:<br>
	 * {@code foreground?: string; }<br>
	 */
	public String foreground() { return get("foreground", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:969:18}<br>
	 * Original signature:<br>
	 * {@code foreground?: string; }<br>
	 */
	public ITokenThemeRule foreground(@Nonnull String value) {
		set("foreground", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:968:13}<br>
	 * Original signature:<br>
	 * {@code token: string; }<br>
	 */
	public String token() { return get("token", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:968:13}<br>
	 * Original signature:<br>
	 * {@code token: string; }<br>
	 */
	public ITokenThemeRule token(@Nonnull String value) {
		set("token", value);
		return this;
	}

 
}
