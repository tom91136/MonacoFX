
package monaco_editor.monaco.editor;
import java.util.List;
import javax.annotation.Nonnull;
import monaco_editor.monaco.Position;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>An event describing that the cursor position has changed.</p>
 * See {@code monaco.d.ts:2417:48}<br>
 * Original signature:<br>
 * {@code export interface ICursorPositionChangedEvent  }<br>
 */
@SuppressWarnings("unused")
public class ICursorPositionChangedEvent extends JsProxy {

	public ICursorPositionChangedEvent(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public ICursorPositionChangedEvent(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Primary cursor's position.</p>
	 * See {@code monaco.d.ts:2421:25}<br>
	 * Original signature:<br>
	 * {@code readonly position: Position; }<br>
	 */
	public Position position() { return get("position", Position::new); }

 	/**
	 * <p>Reason.</p>
	 * See {@code monaco.d.ts:2429:23}<br>
	 * Original signature:<br>
	 * {@code readonly reason: CursorChangeReason; }<br>
	 */
	public CursorChangeReason reason() { return get("reason", ofJsEnum(CursorChangeReason.class)); }

 	/**
	 * <p>Secondary cursors' position.</p>
	 * See {@code monaco.d.ts:2425:35}<br>
	 * Original signature:<br>
	 * {@code readonly secondaryPositions: Position[]; }<br>
	 */
	public List<Position> secondaryPositions() { return get("secondaryPositions", ofArray(Position::new)); }

 	/**
	 * <p>Source of the call that caused the event.</p>
	 * See {@code monaco.d.ts:2433:23}<br>
	 * Original signature:<br>
	 * {@code readonly source: string; }<br>
	 */
	public String source() { return get("source", ofMapped(String.class)); }

 
}
