
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>Configuration options for editor scrollbars</p>
 * See {@code monaco.d.ts:3416:44}<br>
 * Original signature:<br>
 * {@code export interface IEditorScrollbarOptions  }<br>
 */
@SuppressWarnings("unused")
public class IEditorScrollbarOptions extends JsProxy {

	public IEditorScrollbarOptions(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IEditorScrollbarOptions(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Always consume mouse wheel events (always call preventDefault() and stopPropagation() on the browser events).
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:3456:31}<br>
	 * Original signature:<br>
	 * {@code alwaysConsumeMouseWheel?: boolean; }<br>
	 */
	public boolean alwaysConsumeMouseWheel() { return get("alwaysConsumeMouseWheel", ofMapped(boolean.class)); }

 	/**
	 * <p>Always consume mouse wheel events (always call preventDefault() and stopPropagation() on the browser events).
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:3456:31}<br>
	 * Original signature:<br>
	 * {@code alwaysConsumeMouseWheel?: boolean; }<br>
	 */
	public IEditorScrollbarOptions alwaysConsumeMouseWheel(@Nonnull Boolean value) {
		set("alwaysConsumeMouseWheel", value);
		return this;
	}

 	/**
	 * <p>The size of arrows (if displayed).
	 * Defaults to 11.</p>
	 * See {@code monaco.d.ts:3421:17}<br>
	 * Original signature:<br>
	 * {@code arrowSize?: number; }<br>
	 */
	public double arrowSize() { return get("arrowSize", ofMapped(double.class)); }

 	/**
	 * <p>The size of arrows (if displayed).
	 * Defaults to 11.</p>
	 * See {@code monaco.d.ts:3421:17}<br>
	 * Original signature:<br>
	 * {@code arrowSize?: number; }<br>
	 */
	public IEditorScrollbarOptions arrowSize(@Nonnull Double value) {
		set("arrowSize", value);
		return this;
	}

 	/**
	 * <p>Listen to mouse wheel events and react to them by scrolling.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:3451:24}<br>
	 * Original signature:<br>
	 * {@code handleMouseWheel?: boolean; }<br>
	 */
	public boolean handleMouseWheel() { return get("handleMouseWheel", ofMapped(boolean.class)); }

 	/**
	 * <p>Listen to mouse wheel events and react to them by scrolling.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:3451:24}<br>
	 * Original signature:<br>
	 * {@code handleMouseWheel?: boolean; }<br>
	 */
	public IEditorScrollbarOptions handleMouseWheel(@Nonnull Boolean value) {
		set("handleMouseWheel", value);
		return this;
	}

 	/**
	 * <p>Render arrows at the left and right of the horizontal scrollbar.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:3446:27}<br>
	 * Original signature:<br>
	 * {@code horizontalHasArrows?: boolean; }<br>
	 */
	public boolean horizontalHasArrows() { return get("horizontalHasArrows", ofMapped(boolean.class)); }

 	/**
	 * <p>Render arrows at the left and right of the horizontal scrollbar.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:3446:27}<br>
	 * Original signature:<br>
	 * {@code horizontalHasArrows?: boolean; }<br>
	 */
	public IEditorScrollbarOptions horizontalHasArrows(@Nonnull Boolean value) {
		set("horizontalHasArrows", value);
		return this;
	}

 	/**
	 * <p>Height in pixels for the horizontal scrollbar.
	 * Defaults to 10 (px).</p>
	 * See {@code monaco.d.ts:3461:31}<br>
	 * Original signature:<br>
	 * {@code horizontalScrollbarSize?: number; }<br>
	 */
	public double horizontalScrollbarSize() { return get("horizontalScrollbarSize", ofMapped(double.class)); }

 	/**
	 * <p>Height in pixels for the horizontal scrollbar.
	 * Defaults to 10 (px).</p>
	 * See {@code monaco.d.ts:3461:31}<br>
	 * Original signature:<br>
	 * {@code horizontalScrollbarSize?: number; }<br>
	 */
	public IEditorScrollbarOptions horizontalScrollbarSize(@Nonnull Double value) {
		set("horizontalScrollbarSize", value);
		return this;
	}

 	/**
	 * <p>Height in pixels for the horizontal slider.
	 * Defaults to <code>horizontalScrollbarSize</code>.</p>
	 * See {@code monaco.d.ts:3476:28}<br>
	 * Original signature:<br>
	 * {@code horizontalSliderSize?: number; }<br>
	 */
	public double horizontalSliderSize() { return get("horizontalSliderSize", ofMapped(double.class)); }

 	/**
	 * <p>Height in pixels for the horizontal slider.
	 * Defaults to <code>horizontalScrollbarSize</code>.</p>
	 * See {@code monaco.d.ts:3476:28}<br>
	 * Original signature:<br>
	 * {@code horizontalSliderSize?: number; }<br>
	 */
	public IEditorScrollbarOptions horizontalSliderSize(@Nonnull Double value) {
		set("horizontalSliderSize", value);
		return this;
	}

 	/**
	 * <p>Cast horizontal and vertical shadows when the content is scrolled.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:3436:18}<br>
	 * Original signature:<br>
	 * {@code useShadows?: boolean; }<br>
	 */
	public boolean useShadows() { return get("useShadows", ofMapped(boolean.class)); }

 	/**
	 * <p>Cast horizontal and vertical shadows when the content is scrolled.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:3436:18}<br>
	 * Original signature:<br>
	 * {@code useShadows?: boolean; }<br>
	 */
	public IEditorScrollbarOptions useShadows(@Nonnull Boolean value) {
		set("useShadows", value);
		return this;
	}

 	/**
	 * <p>Render arrows at the top and bottom of the vertical scrollbar.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:3441:25}<br>
	 * Original signature:<br>
	 * {@code verticalHasArrows?: boolean; }<br>
	 */
	public boolean verticalHasArrows() { return get("verticalHasArrows", ofMapped(boolean.class)); }

 	/**
	 * <p>Render arrows at the top and bottom of the vertical scrollbar.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:3441:25}<br>
	 * Original signature:<br>
	 * {@code verticalHasArrows?: boolean; }<br>
	 */
	public IEditorScrollbarOptions verticalHasArrows(@Nonnull Boolean value) {
		set("verticalHasArrows", value);
		return this;
	}

 	/**
	 * <p>Width in pixels for the vertical scrollbar.
	 * Defaults to 10 (px).</p>
	 * See {@code monaco.d.ts:3466:29}<br>
	 * Original signature:<br>
	 * {@code verticalScrollbarSize?: number; }<br>
	 */
	public double verticalScrollbarSize() { return get("verticalScrollbarSize", ofMapped(double.class)); }

 	/**
	 * <p>Width in pixels for the vertical scrollbar.
	 * Defaults to 10 (px).</p>
	 * See {@code monaco.d.ts:3466:29}<br>
	 * Original signature:<br>
	 * {@code verticalScrollbarSize?: number; }<br>
	 */
	public IEditorScrollbarOptions verticalScrollbarSize(@Nonnull Double value) {
		set("verticalScrollbarSize", value);
		return this;
	}

 	/**
	 * <p>Width in pixels for the vertical slider.
	 * Defaults to <code>verticalScrollbarSize</code>.</p>
	 * See {@code monaco.d.ts:3471:26}<br>
	 * Original signature:<br>
	 * {@code verticalSliderSize?: number; }<br>
	 */
	public double verticalSliderSize() { return get("verticalSliderSize", ofMapped(double.class)); }

 	/**
	 * <p>Width in pixels for the vertical slider.
	 * Defaults to <code>verticalScrollbarSize</code>.</p>
	 * See {@code monaco.d.ts:3471:26}<br>
	 * Original signature:<br>
	 * {@code verticalSliderSize?: number; }<br>
	 */
	public IEditorScrollbarOptions verticalSliderSize(@Nonnull Double value) {
		set("verticalSliderSize", value);
		return this;
	}

 
}
