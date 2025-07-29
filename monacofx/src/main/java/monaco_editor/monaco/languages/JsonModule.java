
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import monaco_editor.monaco.languages.json.LanguageServiceDefaults;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:6681:39}<br>
 * Original signature:<br>
 * {@code declare namespace monaco.languages.json  }<br>
 */
@SuppressWarnings("unused")
public class JsonModule extends JsProxy {

	public JsonModule(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public JsonModule(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:6775:27}<br>
	 * Original signature:<br>
	 * {@code export var jsonDefaults: LanguageServiceDefaults; }<br>
	 */
	public LanguageServiceDefaults jsonDefaults() { return get("jsonDefaults", LanguageServiceDefaults::new); }

 	/**
	 * See {@code monaco.d.ts:6775:27}<br>
	 * Original signature:<br>
	 * {@code export var jsonDefaults: LanguageServiceDefaults; }<br>
	 */
	public JsonModule jsonDefaults(@Nonnull LanguageServiceDefaults value) {
		set("jsonDefaults", value);
		return this;
	}

 
}
