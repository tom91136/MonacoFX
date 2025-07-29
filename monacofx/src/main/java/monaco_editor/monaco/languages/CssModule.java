
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import monaco_editor.monaco.languages.css.LanguageServiceDefaults;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:6581:38}<br>
 * Original signature:<br>
 * {@code declare namespace monaco.languages.css  }<br>
 */
@SuppressWarnings("unused")
public class CssModule extends JsProxy {

	public CssModule(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public CssModule(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:6672:26}<br>
	 * Original signature:<br>
	 * {@code export var cssDefaults: LanguageServiceDefaults; }<br>
	 */
	public LanguageServiceDefaults cssDefaults() { return get("cssDefaults", LanguageServiceDefaults::new); }

 	/**
	 * See {@code monaco.d.ts:6672:26}<br>
	 * Original signature:<br>
	 * {@code export var cssDefaults: LanguageServiceDefaults; }<br>
	 */
	public CssModule cssDefaults(@Nonnull LanguageServiceDefaults value) {
		set("cssDefaults", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6673:27}<br>
	 * Original signature:<br>
	 * {@code export var lessDefaults: LanguageServiceDefaults; }<br>
	 */
	public LanguageServiceDefaults lessDefaults() { return get("lessDefaults", LanguageServiceDefaults::new); }

 	/**
	 * See {@code monaco.d.ts:6673:27}<br>
	 * Original signature:<br>
	 * {@code export var lessDefaults: LanguageServiceDefaults; }<br>
	 */
	public CssModule lessDefaults(@Nonnull LanguageServiceDefaults value) {
		set("lessDefaults", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6674:27}<br>
	 * Original signature:<br>
	 * {@code export var scssDefaults: LanguageServiceDefaults; }<br>
	 */
	public LanguageServiceDefaults scssDefaults() { return get("scssDefaults", LanguageServiceDefaults::new); }

 	/**
	 * See {@code monaco.d.ts:6674:27}<br>
	 * Original signature:<br>
	 * {@code export var scssDefaults: LanguageServiceDefaults; }<br>
	 */
	public CssModule scssDefaults(@Nonnull LanguageServiceDefaults value) {
		set("scssDefaults", value);
		return this;
	}

 
}
