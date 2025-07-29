
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:2035:39}<br>
 * Original signature:<br>
 * {@code export interface INewScrollPosition  }<br>
 */
@SuppressWarnings("unused")
public class INewScrollPosition extends JsProxy {

	public INewScrollPosition(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public INewScrollPosition(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:2036:18}<br>
	 * Original signature:<br>
	 * {@code scrollLeft?: number; }<br>
	 */
	public double scrollLeft() { return get("scrollLeft", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:2036:18}<br>
	 * Original signature:<br>
	 * {@code scrollLeft?: number; }<br>
	 */
	public INewScrollPosition scrollLeft(@Nonnull Double value) {
		set("scrollLeft", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:2037:17}<br>
	 * Original signature:<br>
	 * {@code scrollTop?: number; }<br>
	 */
	public double scrollTop() { return get("scrollTop", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:2037:17}<br>
	 * Original signature:<br>
	 * {@code scrollTop?: number; }<br>
	 */
	public INewScrollPosition scrollTop(@Nonnull Double value) {
		set("scrollTop", value);
		return this;
	}

 
}
