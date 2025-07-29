
package monaco_editor.monaco;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:61:38}<br>
 * Original signature:<br>
 * {@code export interface CancellationToken  }<br>
 */
@SuppressWarnings("unused")
public class CancellationToken extends JsProxy {

	public CancellationToken(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public CancellationToken(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:62:40}<br>
	 * Original signature:<br>
	 * {@code readonly isCancellationRequested: boolean; }<br>
	 */
	public boolean isCancellationRequested() { return get("isCancellationRequested", ofMapped(boolean.class)); }

 
}
