
package monaco_editor.monaco;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:433:33}<br>
 * Original signature:<br>
 * {@code export interface IScrollEvent  }<br>
 */
@SuppressWarnings("unused")
public class IScrollEvent extends JsProxy {

	public IScrollEvent(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IScrollEvent(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:437:29}<br>
	 * Original signature:<br>
	 * {@code readonly scrollHeight: number; }<br>
	 */
	public double scrollHeight() { return get("scrollHeight", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:441:36}<br>
	 * Original signature:<br>
	 * {@code readonly scrollHeightChanged: boolean; }<br>
	 */
	public boolean scrollHeightChanged() { return get("scrollHeightChanged", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:435:27}<br>
	 * Original signature:<br>
	 * {@code readonly scrollLeft: number; }<br>
	 */
	public double scrollLeft() { return get("scrollLeft", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:439:34}<br>
	 * Original signature:<br>
	 * {@code readonly scrollLeftChanged: boolean; }<br>
	 */
	public boolean scrollLeftChanged() { return get("scrollLeftChanged", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:434:26}<br>
	 * Original signature:<br>
	 * {@code readonly scrollTop: number; }<br>
	 */
	public double scrollTop() { return get("scrollTop", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:438:33}<br>
	 * Original signature:<br>
	 * {@code readonly scrollTopChanged: boolean; }<br>
	 */
	public boolean scrollTopChanged() { return get("scrollTopChanged", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:436:28}<br>
	 * Original signature:<br>
	 * {@code readonly scrollWidth: number; }<br>
	 */
	public double scrollWidth() { return get("scrollWidth", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:440:35}<br>
	 * Original signature:<br>
	 * {@code readonly scrollWidthChanged: boolean; }<br>
	 */
	public boolean scrollWidthChanged() { return get("scrollWidthChanged", ofMapped(boolean.class)); }

 
}
