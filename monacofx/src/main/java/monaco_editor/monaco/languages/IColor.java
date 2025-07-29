
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>A color in RGBA format.</p>
 * See {@code monaco.d.ts:5788:27}<br>
 * Original signature:<br>
 * {@code export interface IColor  }<br>
 */
@SuppressWarnings("unused")
public class IColor extends JsProxy {

	public IColor(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IColor(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>The alpha component in the range [0-1].</p>
	 * See {@code monaco.d.ts:5804:22}<br>
	 * Original signature:<br>
	 * {@code readonly alpha: number; }<br>
	 */
	public double alpha() { return get("alpha", ofMapped(double.class)); }

 	/**
	 * <p>The blue component in the range [0-1].</p>
	 * See {@code monaco.d.ts:5800:21}<br>
	 * Original signature:<br>
	 * {@code readonly blue: number; }<br>
	 */
	public double blue() { return get("blue", ofMapped(double.class)); }

 	/**
	 * <p>The green component in the range [0-1].</p>
	 * See {@code monaco.d.ts:5796:22}<br>
	 * Original signature:<br>
	 * {@code readonly green: number; }<br>
	 */
	public double green() { return get("green", ofMapped(double.class)); }

 	/**
	 * <p>The red component in the range [0-1].</p>
	 * See {@code monaco.d.ts:5792:20}<br>
	 * Original signature:<br>
	 * {@code readonly red: number; }<br>
	 */
	public double red() { return get("red", ofMapped(double.class)); }

 
}
