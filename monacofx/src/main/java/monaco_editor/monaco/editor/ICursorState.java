
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import monaco_editor.monaco.IPosition;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>A (serializable) state of the cursors.</p>
 * See {@code monaco.d.ts:2053:33}<br>
 * Original signature:<br>
 * {@code export interface ICursorState  }<br>
 */
@SuppressWarnings("unused")
public class ICursorState extends JsProxy {

	public ICursorState(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public ICursorState(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:2054:23}<br>
	 * Original signature:<br>
	 * {@code inSelectionMode: boolean; }<br>
	 */
	public boolean inSelectionMode() { return get("inSelectionMode", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:2054:23}<br>
	 * Original signature:<br>
	 * {@code inSelectionMode: boolean; }<br>
	 */
	public ICursorState inSelectionMode(@Nonnull Boolean value) {
		set("inSelectionMode", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:2056:16}<br>
	 * Original signature:<br>
	 * {@code position: IPosition; }<br>
	 */
	public IPosition position() { return get("position", IPosition::new); }

 	/**
	 * See {@code monaco.d.ts:2056:16}<br>
	 * Original signature:<br>
	 * {@code position: IPosition; }<br>
	 */
	public ICursorState position(@Nonnull IPosition value) {
		set("position", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:2055:22}<br>
	 * Original signature:<br>
	 * {@code selectionStart: IPosition; }<br>
	 */
	public IPosition selectionStart() { return get("selectionStart", IPosition::new); }

 	/**
	 * See {@code monaco.d.ts:2055:22}<br>
	 * Original signature:<br>
	 * {@code selectionStart: IPosition; }<br>
	 */
	public ICursorState selectionStart(@Nonnull IPosition value) {
		set("selectionStart", value);
		return this;
	}

 
}
