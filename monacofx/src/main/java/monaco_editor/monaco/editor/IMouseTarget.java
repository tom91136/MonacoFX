
package monaco_editor.monaco.editor;
import java.util.Optional;
import javax.annotation.Nonnull;
import monaco_editor.monaco.Position;
import monaco_editor.monaco.Range;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import netscape.javascript.JSObject;

/**
 * <p>Target hit with the mouse in the editor.</p>
 * See {@code monaco.d.ts:4152:33}<br>
 * Original signature:<br>
 * {@code export interface IMouseTarget  }<br>
 */
@SuppressWarnings("unused")
public class IMouseTarget extends JsProxy {

	public IMouseTarget(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IMouseTarget(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Some extra detail.</p>
	 * See {@code monaco.d.ts:4176:23}<br>
	 * Original signature:<br>
	 * {@code readonly detail: any; }<br>
	 */
	public JSObject detail() { return get("detail", ofMapped(JSObject.class)); }

 	/**
	 * <p>The target element</p>
	 * See {@code monaco.d.ts:4156:24}<br>
	 * Original signature:<br>
	 * {@code readonly element: Element | null; }<br>
	 */
	public Optional<JSObject> element() { return Optional.ofNullable(get("element", ofMapped(JSObject.class))); }

 	/**
	 * <p>Desired mouse column (e.g. when position.column gets clamped to text length -- clicking after text on a line).</p>
	 * See {@code monaco.d.ts:4168:28}<br>
	 * Original signature:<br>
	 * {@code readonly mouseColumn: number; }<br>
	 */
	public double mouseColumn() { return get("mouseColumn", ofMapped(double.class)); }

 	/**
	 * <p>The 'approximate' editor position</p>
	 * See {@code monaco.d.ts:4164:25}<br>
	 * Original signature:<br>
	 * {@code readonly position: Position | null; }<br>
	 */
	public Optional<Position> position() { return Optional.ofNullable(get("position", Position::new)); }

 	/**
	 * <p>The 'approximate' editor range</p>
	 * See {@code monaco.d.ts:4172:22}<br>
	 * Original signature:<br>
	 * {@code readonly range: Range | null; }<br>
	 */
	public Optional<Range> range() { return Optional.ofNullable(get("range", Range::new)); }

 	/**
	 * <p>The target type</p>
	 * See {@code monaco.d.ts:4160:21}<br>
	 * Original signature:<br>
	 * {@code readonly type: MouseTargetType; }<br>
	 */
	public MouseTargetType type() { return get("type", ofJsEnum(MouseTargetType.class)); }

 
}
