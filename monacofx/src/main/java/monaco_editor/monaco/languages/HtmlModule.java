
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import monaco_editor.monaco.languages.html.LanguageServiceDefaults;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:6783:39}<br>
 * Original signature:<br>
 * {@code declare namespace monaco.languages.html  }<br>
 */
@SuppressWarnings("unused")
public class HtmlModule extends JsProxy {

	public HtmlModule(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public HtmlModule(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:6884:32}<br>
	 * Original signature:<br>
	 * {@code export var handlebarDefaults: LanguageServiceDefaults; }<br>
	 */
	public LanguageServiceDefaults handlebarDefaults() { return get("handlebarDefaults", LanguageServiceDefaults::new); }

 	/**
	 * See {@code monaco.d.ts:6884:32}<br>
	 * Original signature:<br>
	 * {@code export var handlebarDefaults: LanguageServiceDefaults; }<br>
	 */
	public HtmlModule handlebarDefaults(@Nonnull LanguageServiceDefaults value) {
		set("handlebarDefaults", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6883:27}<br>
	 * Original signature:<br>
	 * {@code export var htmlDefaults: LanguageServiceDefaults; }<br>
	 */
	public LanguageServiceDefaults htmlDefaults() { return get("htmlDefaults", LanguageServiceDefaults::new); }

 	/**
	 * See {@code monaco.d.ts:6883:27}<br>
	 * Original signature:<br>
	 * {@code export var htmlDefaults: LanguageServiceDefaults; }<br>
	 */
	public HtmlModule htmlDefaults(@Nonnull LanguageServiceDefaults value) {
		set("htmlDefaults", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6885:28}<br>
	 * Original signature:<br>
	 * {@code export var razorDefaults: LanguageServiceDefaults; }<br>
	 */
	public LanguageServiceDefaults razorDefaults() { return get("razorDefaults", LanguageServiceDefaults::new); }

 	/**
	 * See {@code monaco.d.ts:6885:28}<br>
	 * Original signature:<br>
	 * {@code export var razorDefaults: LanguageServiceDefaults; }<br>
	 */
	public HtmlModule razorDefaults(@Nonnull LanguageServiceDefaults value) {
		set("razorDefaults", value);
		return this;
	}

 
}
