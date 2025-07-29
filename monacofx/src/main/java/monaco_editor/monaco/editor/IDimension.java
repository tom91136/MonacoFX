
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:1996:31}<br>
 * Original signature:<br>
 * {@code export interface IDimension  }<br>
 */
@SuppressWarnings("unused")
public class IDimension extends JsProxy {

	public IDimension(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IDimension(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:1998:14}<br>
	 * Original signature:<br>
	 * {@code height: number; }<br>
	 */
	public double height() { return get("height", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:1998:14}<br>
	 * Original signature:<br>
	 * {@code height: number; }<br>
	 */
	public IDimension height(@Nonnull Double value) {
		set("height", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1997:13}<br>
	 * Original signature:<br>
	 * {@code width: number; }<br>
	 */
	public double width() { return get("width", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:1997:13}<br>
	 * Original signature:<br>
	 * {@code width: number; }<br>
	 */
	public IDimension width(@Nonnull Double value) {
		set("width", value);
		return this;
	}

 
}
