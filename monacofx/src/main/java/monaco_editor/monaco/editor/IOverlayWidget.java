
package monaco_editor.monaco.editor;
import java.util.Optional;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import netscape.javascript.JSObject;

/**
 * <p>An overlay widgets renders on top of the text.</p>
 * See {@code monaco.d.ts:4071:35}<br>
 * Original signature:<br>
 * {@code export interface IOverlayWidget  }<br>
 */
@SuppressWarnings("unused")
public class IOverlayWidget extends JsProxy {

	public IOverlayWidget(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IOverlayWidget(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Get the dom node of the overlay widget.</p>
	 * See {@code monaco.d.ts:4079:18}<br>
	 * Original signature:<br>
	 * {@code getDomNode(): HTMLElement; }<br>
	 */
	public JSObject getDomNode() { return call("getDomNode", ofMapped(JSObject.class)); }

 	/**
	 * <p>Get a unique identifier of the overlay widget.</p>
	 * See {@code monaco.d.ts:4075:13}<br>
	 * Original signature:<br>
	 * {@code getId(): string; }<br>
	 */
	public String getId() { return call("getId", ofMapped(String.class)); }

 	/**
	 * <p>Get the placement of the overlay widget.
	 * If null is returned, the overlay widget is responsible to place itself.</p>
	 * See {@code monaco.d.ts:4084:19}<br>
	 * Original signature:<br>
	 * {@code getPosition(): IOverlayWidgetPosition | null; }<br>
	 */
	public Optional<IOverlayWidgetPosition> getPosition() { return Optional.ofNullable(call("getPosition", IOverlayWidgetPosition::new)); }

 
}
