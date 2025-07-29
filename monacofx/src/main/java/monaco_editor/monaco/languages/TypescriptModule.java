
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import monaco_editor.monaco.languages.typescript.LanguageServiceDefaults;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import netscape.javascript.JSObject;

/**
 * See {@code monaco.d.ts:6190:45}<br>
 * Original signature:<br>
 * {@code declare namespace monaco.languages.typescript  }<br>
 */
@SuppressWarnings("unused")
public class TypescriptModule extends JsProxy {

	public TypescriptModule(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public TypescriptModule(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:6574:36}<br>
	 * Original signature:<br>
	 * {@code export const getJavaScriptWorker: () => Promise<(...uris: Uri[]) => Promise<TypeScriptWorker>>; }<br>
	 */
	public JSObject getJavaScriptWorker() { return get("getJavaScriptWorker", ofMapped(JSObject.class)); }

 	/**
	 * See {@code monaco.d.ts:6573:36}<br>
	 * Original signature:<br>
	 * {@code export const getTypeScriptWorker: () => Promise<(...uris: Uri[]) => Promise<TypeScriptWorker>>; }<br>
	 */
	public JSObject getTypeScriptWorker() { return get("getTypeScriptWorker", ofMapped(JSObject.class)); }

 	/**
	 * See {@code monaco.d.ts:6571:35}<br>
	 * Original signature:<br>
	 * {@code export const javascriptDefaults: LanguageServiceDefaults; }<br>
	 */
	public LanguageServiceDefaults javascriptDefaults() { return get("javascriptDefaults", LanguageServiceDefaults::new); }

 	/**
	 * See {@code monaco.d.ts:6570:35}<br>
	 * Original signature:<br>
	 * {@code export const typescriptDefaults: LanguageServiceDefaults; }<br>
	 */
	public LanguageServiceDefaults typescriptDefaults() { return get("typescriptDefaults", LanguageServiceDefaults::new); }

 	/**
	 * See {@code monaco.d.ts:6568:34}<br>
	 * Original signature:<br>
	 * {@code export const typescriptVersion: string; }<br>
	 */
	public String typescriptVersion() { return get("typescriptVersion", ofMapped(String.class)); }

 
}
