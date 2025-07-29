
package monaco_editor.monaco;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import netscape.javascript.JSObject;

/**
 * See {@code monaco.d.ts:391:36}<br>
 * Original signature:<br>
 * {@code export interface IMarkdownString  }<br>
 */
@SuppressWarnings("unused")
public class IMarkdownString extends JsProxy {

	public IMarkdownString(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IMarkdownString(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:393:26}<br>
	 * Original signature:<br>
	 * {@code readonly isTrusted?: boolean; }<br>
	 */
	public boolean isTrusted() { return get("isTrusted", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:394:34}<br>
	 * Original signature:<br>
	 * {@code readonly supportThemeIcons?: boolean; }<br>
	 */
	public boolean supportThemeIcons() { return get("supportThemeIcons", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:395:12}<br>
	 * Original signature:<br>
	 * {@code uris?:  }<br>
	 */
	public JSObject uris() { return get("uris", ofMapped(JSObject.class)); }

 	/**
	 * See {@code monaco.d.ts:395:12}<br>
	 * Original signature:<br>
	 * {@code uris?:  }<br>
	 */
	public IMarkdownString uris(@Nonnull JSObject value) {
		set("uris", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:392:22}<br>
	 * Original signature:<br>
	 * {@code readonly value: string; }<br>
	 */
	public String value() { return get("value", ofMapped(String.class)); }

 
}
