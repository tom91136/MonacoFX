
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>Configuration options for editor hover</p>
 * See {@code monaco.d.ts:3197:40}<br>
 * Original signature:<br>
 * {@code export interface IEditorHoverOptions  }<br>
 */
@SuppressWarnings("unused")
public class IEditorHoverOptions extends JsProxy {

	public IEditorHoverOptions(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IEditorHoverOptions(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Delay for showing the hover.
	 * Defaults to 300.</p>
	 * See {@code monaco.d.ts:3207:13}<br>
	 * Original signature:<br>
	 * {@code delay?: number; }<br>
	 */
	public double delay() { return get("delay", ofMapped(double.class)); }

 	/**
	 * <p>Delay for showing the hover.
	 * Defaults to 300.</p>
	 * See {@code monaco.d.ts:3207:13}<br>
	 * Original signature:<br>
	 * {@code delay?: number; }<br>
	 */
	public IEditorHoverOptions delay(@Nonnull Double value) {
		set("delay", value);
		return this;
	}

 	/**
	 * <p>Enable the hover.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:3202:15}<br>
	 * Original signature:<br>
	 * {@code enabled?: boolean; }<br>
	 */
	public boolean enabled() { return get("enabled", ofMapped(boolean.class)); }

 	/**
	 * <p>Enable the hover.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:3202:15}<br>
	 * Original signature:<br>
	 * {@code enabled?: boolean; }<br>
	 */
	public IEditorHoverOptions enabled(@Nonnull Boolean value) {
		set("enabled", value);
		return this;
	}

 	/**
	 * <p>Is the hover sticky such that it can be clicked and its contents selected?
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:3212:14}<br>
	 * Original signature:<br>
	 * {@code sticky?: boolean; }<br>
	 */
	public boolean sticky() { return get("sticky", ofMapped(boolean.class)); }

 	/**
	 * <p>Is the hover sticky such that it can be clicked and its contents selected?
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:3212:14}<br>
	 * Original signature:<br>
	 * {@code sticky?: boolean; }<br>
	 */
	public IEditorHoverOptions sticky(@Nonnull Boolean value) {
		set("sticky", value);
		return this;
	}

 
}
