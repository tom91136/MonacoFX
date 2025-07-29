
package monaco_editor.monaco.languages.css;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import netscape.javascript.JSObject;

/**
 * See {@code monaco.d.ts:6582:39}<br>
 * Original signature:<br>
 * {@code export interface DiagnosticsOptions  }<br>
 */
@SuppressWarnings("unused")
public class DiagnosticsOptions extends JsProxy {

	public DiagnosticsOptions(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public DiagnosticsOptions(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:6584:21}<br>
	 * Original signature:<br>
	 * {@code readonly lint?:  }<br>
	 */
	public JSObject lint() { return get("lint", ofMapped(JSObject.class)); }

 	/**
	 * See {@code monaco.d.ts:6583:25}<br>
	 * Original signature:<br>
	 * {@code readonly validate?: boolean; }<br>
	 */
	public boolean validate() { return get("validate", ofMapped(boolean.class)); }

 
}
