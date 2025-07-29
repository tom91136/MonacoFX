
package monaco_editor;
import javax.annotation.Nonnull;
import monaco_editor.monaco.EditorModule;
import monaco_editor.monaco.LanguagesModule;
import monaco_editor.monaco.WorkerModule;
import monaco_editor.monaco.languages.CssModule;
import monaco_editor.monaco.languages.HtmlModule;
import monaco_editor.monaco.languages.JsonModule;
import monaco_editor.monaco.languages.TypescriptModule;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:13:24}<br>
 * See {@code monaco.d.ts:816:24}<br>
 * See {@code monaco.d.ts:4653:24}<br>
 * See {@code monaco.d.ts:6165:24}<br>
 * See {@code monaco.d.ts:6190:24}<br>
 * See {@code monaco.d.ts:6581:24}<br>
 * See {@code monaco.d.ts:6681:24}<br>
 * See {@code monaco.d.ts:6783:24}<br>
 * Original signature:<br>
 * {@code declare namespace monaco  }<br>
 * {@code declare namespace monaco.editor  }<br>
 * {@code declare namespace monaco.languages  }<br>
 * {@code declare namespace monaco.worker  }<br>
 * {@code declare namespace monaco.languages.typescript  }<br>
 * {@code declare namespace monaco.languages.css  }<br>
 * {@code declare namespace monaco.languages.json  }<br>
 * {@code declare namespace monaco.languages.html  }<br>
 */
@SuppressWarnings("unused")
public class MonacoModule extends JsProxy {

	public MonacoModule(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public MonacoModule(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:816:31}<br>
	 * Original signature:<br>
	 * {@code declare namespace monaco.editor  }<br>
	 */
	public EditorModule editor() { return get("editor", EditorModule::new); }

 	/**
	 * See {@code monaco.d.ts:4653:34}<br>
	 * See {@code monaco.d.ts:6190:34}<br>
	 * See {@code monaco.d.ts:6581:34}<br>
	 * See {@code monaco.d.ts:6681:34}<br>
	 * See {@code monaco.d.ts:6783:34}<br>
	 * Original signature:<br>
	 * {@code declare namespace monaco.languages  }<br>
	 * {@code declare namespace monaco.languages.typescript  }<br>
	 * {@code declare namespace monaco.languages.css  }<br>
	 * {@code declare namespace monaco.languages.json  }<br>
	 * {@code declare namespace monaco.languages.html  }<br>
	 */
	public LanguagesModule languages() { return get("languages", LanguagesModule::new); }

 	/**
	 * See {@code monaco.d.ts:6581:38}<br>
	 * Original signature:<br>
	 * {@code declare namespace monaco.languages.css  }<br>
	 */
	public CssModule css() { return get("css", CssModule::new); }

 	/**
	 * See {@code monaco.d.ts:6783:39}<br>
	 * Original signature:<br>
	 * {@code declare namespace monaco.languages.html  }<br>
	 */
	public HtmlModule html() { return get("html", HtmlModule::new); }

 	/**
	 * See {@code monaco.d.ts:6681:39}<br>
	 * Original signature:<br>
	 * {@code declare namespace monaco.languages.json  }<br>
	 */
	public JsonModule json() { return get("json", JsonModule::new); }

 	/**
	 * See {@code monaco.d.ts:6190:45}<br>
	 * Original signature:<br>
	 * {@code declare namespace monaco.languages.typescript  }<br>
	 */
	public TypescriptModule typescript() { return get("typescript", TypescriptModule::new); }

 	/**
	 * See {@code monaco.d.ts:6165:31}<br>
	 * Original signature:<br>
	 * {@code declare namespace monaco.worker  }<br>
	 */
	public WorkerModule worker() { return get("worker", WorkerModule::new); }

 
}
