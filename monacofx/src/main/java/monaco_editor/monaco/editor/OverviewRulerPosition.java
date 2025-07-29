
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>A description for the overview ruler position.</p>
 * See {@code monaco.d.ts:3220:42}<br>
 * Original signature:<br>
 * {@code export interface OverviewRulerPosition  }<br>
 */
@SuppressWarnings("unused")
public class OverviewRulerPosition extends JsProxy {

	public OverviewRulerPosition(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public OverviewRulerPosition(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Height of the overview ruler</p>
	 * See {@code monaco.d.ts:3228:23}<br>
	 * Original signature:<br>
	 * {@code readonly height: number; }<br>
	 */
	public double height() { return get("height", ofMapped(double.class)); }

 	/**
	 * <p>Right position for the overview ruler</p>
	 * See {@code monaco.d.ts:3236:22}<br>
	 * Original signature:<br>
	 * {@code readonly right: number; }<br>
	 */
	public double right() { return get("right", ofMapped(double.class)); }

 	/**
	 * <p>Top position for the overview ruler</p>
	 * See {@code monaco.d.ts:3232:20}<br>
	 * Original signature:<br>
	 * {@code readonly top: number; }<br>
	 */
	public double top() { return get("top", ofMapped(double.class)); }

 	/**
	 * <p>Width of the overview ruler</p>
	 * See {@code monaco.d.ts:3224:22}<br>
	 * Original signature:<br>
	 * {@code readonly width: number; }<br>
	 */
	public double width() { return get("width", ofMapped(double.class)); }

 
}
