
package monaco_editor.monaco.languages.html;
import javax.annotation.Nonnull;
import monaco_editor.monaco.IEvent;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:6877:44}<br>
 * Original signature:<br>
 * {@code export interface LanguageServiceDefaults  }<br>
 */
@SuppressWarnings("unused")
public class LanguageServiceDefaults extends JsProxy {

	public LanguageServiceDefaults(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public LanguageServiceDefaults(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:6878:28}<br>
	 * Original signature:<br>
	 * {@code readonly onDidChange: IEvent<LanguageServiceDefaults>; }<br>
	 */
	public IEvent<LanguageServiceDefaults> onDidChange() { return get("onDidChange", IEvent ::new); }

 	/**
	 * See {@code monaco.d.ts:6879:24}<br>
	 * Original signature:<br>
	 * {@code readonly options: Options; }<br>
	 */
	public Options options() { return get("options", Options::new); }

 	/**
	 * See {@code monaco.d.ts:6880:18}<br>
	 * Original signature:<br>
	 * {@code setOptions(options: Options): void; }<br>
	 */
	public void setOptions(@Nonnull Options options) { call("setOptions", ofVoid(), options); }

 
}
