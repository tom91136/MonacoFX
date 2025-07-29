
package monaco_editor.monaco;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>A helper that allows to emit and listen to typed events</p>
 * See {@code monaco.d.ts:34:24}<br>
 * Original signature:<br>
 * {@code export class Emitter<T>  }<br>
 */
@SuppressWarnings("unused")
public class Emitter <T> extends JsProxy {

	public Emitter(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public Emitter(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:36:22}<br>
	 * Original signature:<br>
	 * {@code readonly event: IEvent<T>; }<br>
	 */
	public IEvent<T> event() { return get("event", IEvent ::new); }

 	/**
	 * See {@code monaco.d.ts:38:15}<br>
	 * Original signature:<br>
	 * {@code dispose(): void; }<br>
	 */
	public void dispose() { call("dispose", ofVoid()); }

 	/**
	 * See {@code monaco.d.ts:37:12}<br>
	 * Original signature:<br>
	 * {@code fire(event: T): void; }<br>
	 */
	public void fire(@Nonnull T event) { call("fire", ofVoid(), event); }

 
}
