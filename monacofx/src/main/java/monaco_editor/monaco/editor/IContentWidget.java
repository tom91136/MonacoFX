
package monaco_editor.monaco.editor;
import java.util.Optional;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import netscape.javascript.JSObject;

/**
 * <p>A content widget renders inline with the text and can be easily placed 'near' an editor position.</p>
 * See {@code monaco.d.ts:4019:35}<br>
 * Original signature:<br>
 * {@code export interface IContentWidget  }<br>
 */
@SuppressWarnings("unused")
public class IContentWidget extends JsProxy {

	public IContentWidget(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IContentWidget(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Render this content widget in a location where it could overflow the editor's view dom node.</p>
	 * See {@code monaco.d.ts:4023:27}<br>
	 * Original signature:<br>
	 * {@code allowEditorOverflow?: boolean; }<br>
	 */
	public boolean allowEditorOverflow() { return get("allowEditorOverflow", ofMapped(boolean.class)); }

 	/**
	 * <p>Render this content widget in a location where it could overflow the editor's view dom node.</p>
	 * See {@code monaco.d.ts:4023:27}<br>
	 * Original signature:<br>
	 * {@code allowEditorOverflow?: boolean; }<br>
	 */
	public IContentWidget allowEditorOverflow(@Nonnull Boolean value) {
		set("allowEditorOverflow", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:4024:25}<br>
	 * Original signature:<br>
	 * {@code suppressMouseDown?: boolean; }<br>
	 */
	public boolean suppressMouseDown() { return get("suppressMouseDown", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:4024:25}<br>
	 * Original signature:<br>
	 * {@code suppressMouseDown?: boolean; }<br>
	 */
	public IContentWidget suppressMouseDown(@Nonnull Boolean value) {
		set("suppressMouseDown", value);
		return this;
	}

 	/**
	 * <p>Get the dom node of the content widget.</p>
	 * See {@code monaco.d.ts:4032:18}<br>
	 * Original signature:<br>
	 * {@code getDomNode(): HTMLElement; }<br>
	 */
	public JSObject getDomNode() { return call("getDomNode", ofMapped(JSObject.class)); }

 	/**
	 * <p>Get a unique identifier of the content widget.</p>
	 * See {@code monaco.d.ts:4028:13}<br>
	 * Original signature:<br>
	 * {@code getId(): string; }<br>
	 */
	public String getId() { return call("getId", ofMapped(String.class)); }

 	/**
	 * <p>Get the placement of the content widget.
	 * If null is returned, the content widget will be placed off screen.</p>
	 * See {@code monaco.d.ts:4037:19}<br>
	 * Original signature:<br>
	 * {@code getPosition(): IContentWidgetPosition | null; }<br>
	 */
	public Optional<IContentWidgetPosition> getPosition() { return Optional.ofNullable(call("getPosition", IContentWidgetPosition::new)); }

 
}
