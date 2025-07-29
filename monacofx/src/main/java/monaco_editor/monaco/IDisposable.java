
package monaco_editor.monaco;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:23:32}<br>
 * Original signature:<br>
 * {@code export interface IDisposable  }<br>
 */
@SuppressWarnings("unused")
public class IDisposable extends JsProxy {

	public IDisposable(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IDisposable(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:24:15}<br>
	 * Original signature:<br>
	 * {@code dispose(): void; }<br>
	 */
	public void dispose() { call("dispose", ofVoid()); }

 
}
