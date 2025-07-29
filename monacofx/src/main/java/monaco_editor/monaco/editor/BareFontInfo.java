
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:4637:29}<br>
 * Original signature:<br>
 * {@code export class BareFontInfo  }<br>
 */
@SuppressWarnings("unused")
public class BareFontInfo extends JsProxy {

	public BareFontInfo(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public BareFontInfo(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:4640:27}<br>
	 * Original signature:<br>
	 * {@code readonly fontFamily: string; }<br>
	 */
	public String fontFamily() { return get("fontFamily", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:4643:36}<br>
	 * Original signature:<br>
	 * {@code readonly fontFeatureSettings: string; }<br>
	 */
	public String fontFeatureSettings() { return get("fontFeatureSettings", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:4642:25}<br>
	 * Original signature:<br>
	 * {@code readonly fontSize: number; }<br>
	 */
	public double fontSize() { return get("fontSize", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:4641:27}<br>
	 * Original signature:<br>
	 * {@code readonly fontWeight: string; }<br>
	 */
	public String fontWeight() { return get("fontWeight", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:4645:30}<br>
	 * Original signature:<br>
	 * {@code readonly letterSpacing: number; }<br>
	 */
	public double letterSpacing() { return get("letterSpacing", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:4644:27}<br>
	 * Original signature:<br>
	 * {@code readonly lineHeight: number; }<br>
	 */
	public double lineHeight() { return get("lineHeight", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:4639:26}<br>
	 * Original signature:<br>
	 * {@code readonly zoomLevel: number; }<br>
	 */
	public double zoomLevel() { return get("zoomLevel", ofMapped(double.class)); }

 
}
