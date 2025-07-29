
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:3660:39}<br>
 * Original signature:<br>
 * {@code export interface EditorWrappingInfo  }<br>
 */
@SuppressWarnings("unused")
public class EditorWrappingInfo extends JsProxy {

	public EditorWrappingInfo(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public EditorWrappingInfo(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:3661:39}<br>
	 * Original signature:<br>
	 * {@code readonly isDominatedByLongLines: boolean; }<br>
	 */
	public boolean isDominatedByLongLines() { return get("isDominatedByLongLines", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:3663:35}<br>
	 * Original signature:<br>
	 * {@code readonly isViewportWrapping: boolean; }<br>
	 */
	public boolean isViewportWrapping() { return get("isViewportWrapping", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:3662:35}<br>
	 * Original signature:<br>
	 * {@code readonly isWordWrapMinified: boolean; }<br>
	 */
	public boolean isWordWrapMinified() { return get("isWordWrapMinified", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:3664:31}<br>
	 * Original signature:<br>
	 * {@code readonly wrappingColumn: number; }<br>
	 */
	public double wrappingColumn() { return get("wrappingColumn", ofMapped(double.class)); }

 
}
