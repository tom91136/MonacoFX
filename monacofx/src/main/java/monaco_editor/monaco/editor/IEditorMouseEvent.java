
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import monaco_editor.monaco.IMouseEvent;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>A mouse event originating from the editor.</p>
 * See {@code monaco.d.ts:4182:38}<br>
 * Original signature:<br>
 * {@code export interface IEditorMouseEvent  }<br>
 */
@SuppressWarnings("unused")
public class IEditorMouseEvent extends JsProxy {

	public IEditorMouseEvent(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IEditorMouseEvent(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:4183:22}<br>
	 * Original signature:<br>
	 * {@code readonly event: IMouseEvent; }<br>
	 */
	public IMouseEvent event() { return get("event", IMouseEvent::new); }

 	/**
	 * See {@code monaco.d.ts:4184:23}<br>
	 * Original signature:<br>
	 * {@code readonly target: IMouseTarget; }<br>
	 */
	public IMouseTarget target() { return get("target", IMouseTarget::new); }

 
}
