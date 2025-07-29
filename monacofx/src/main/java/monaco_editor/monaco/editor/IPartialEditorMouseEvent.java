
package monaco_editor.monaco.editor;
import java.util.Optional;
import javax.annotation.Nonnull;
import monaco_editor.monaco.IMouseEvent;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:4187:45}<br>
 * Original signature:<br>
 * {@code export interface IPartialEditorMouseEvent  }<br>
 */
@SuppressWarnings("unused")
public class IPartialEditorMouseEvent extends JsProxy {

	public IPartialEditorMouseEvent(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IPartialEditorMouseEvent(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:4188:22}<br>
	 * Original signature:<br>
	 * {@code readonly event: IMouseEvent; }<br>
	 */
	public IMouseEvent event() { return get("event", IMouseEvent::new); }

 	/**
	 * See {@code monaco.d.ts:4189:23}<br>
	 * Original signature:<br>
	 * {@code readonly target: IMouseTarget | null; }<br>
	 */
	public Optional<IMouseTarget> target() { return Optional.ofNullable(get("target", IMouseTarget::new)); }

 
}
