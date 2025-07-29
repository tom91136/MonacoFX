
package monaco_editor.monaco;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:54:40}<br>
 * Original signature:<br>
 * {@code export class CancellationTokenSource  }<br>
 */
@SuppressWarnings("unused")
public class CancellationTokenSource extends JsProxy {

	public CancellationTokenSource(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public CancellationTokenSource(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:56:17}<br>
	 * Original signature:<br>
	 * {@code get token(): CancellationToken; }<br>
	 */
	public CancellationToken token() { return get("token", CancellationToken::new); }

 	/**
	 * See {@code monaco.d.ts:57:14}<br>
	 * Original signature:<br>
	 * {@code cancel(): void; }<br>
	 */
	public void cancel() { call("cancel", ofVoid()); }

 	/**
	 * See {@code monaco.d.ts:58:15}<br>
	 * Original signature:<br>
	 * {@code dispose(cancel?: boolean): void; }<br>
	 */
	public void dispose(@Nonnull Boolean cancel) { call("dispose", ofVoid(), cancel); }

 	/**
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:58:15}<br>
	 * Original signature:<br>
	 * {@code dispose(cancel?: boolean): void; }<br>
	 */
	public void dispose() { call("dispose", ofVoid()); }

 
}
