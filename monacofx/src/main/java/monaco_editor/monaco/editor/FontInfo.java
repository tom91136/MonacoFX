
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:4625:25}<br>
 * Original signature:<br>
 * {@code export class FontInfo extends BareFontInfo  }<br>
 */
@SuppressWarnings("unused")
public class FontInfo extends BareFontInfo {

	public FontInfo(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public FontInfo(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:4631:47}<br>
	 * Original signature:<br>
	 * {@code readonly canUseHalfwidthRightwardsArrow: boolean; }<br>
	 */
	public boolean canUseHalfwidthRightwardsArrow() { return get("canUseHalfwidthRightwardsArrow", ofMapped(boolean.class)); }

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
	 * See {@code monaco.d.ts:4628:28}<br>
	 * Original signature:<br>
	 * {@code readonly isMonospace: boolean; }<br>
	 */
	public boolean isMonospace() { return get("isMonospace", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:4627:26}<br>
	 * Original signature:<br>
	 * {@code readonly isTrusted: boolean; }<br>
	 */
	public boolean isTrusted() { return get("isTrusted", ofMapped(boolean.class)); }

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
	 * See {@code monaco.d.ts:4634:30}<br>
	 * Original signature:<br>
	 * {@code readonly maxDigitWidth: number; }<br>
	 */
	public double maxDigitWidth() { return get("maxDigitWidth", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:4633:28}<br>
	 * Original signature:<br>
	 * {@code readonly middotWidth: number; }<br>
	 */
	public double middotWidth() { return get("middotWidth", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:4632:27}<br>
	 * Original signature:<br>
	 * {@code readonly spaceWidth: number; }<br>
	 */
	public double spaceWidth() { return get("spaceWidth", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:4630:47}<br>
	 * Original signature:<br>
	 * {@code readonly typicalFullwidthCharacterWidth: number; }<br>
	 */
	public double typicalFullwidthCharacterWidth() { return get("typicalFullwidthCharacterWidth", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:4629:47}<br>
	 * Original signature:<br>
	 * {@code readonly typicalHalfwidthCharacterWidth: number; }<br>
	 */
	public double typicalHalfwidthCharacterWidth() { return get("typicalHalfwidthCharacterWidth", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:4639:26}<br>
	 * Original signature:<br>
	 * {@code readonly zoomLevel: number; }<br>
	 */
	public double zoomLevel() { return get("zoomLevel", ofMapped(double.class)); }

 
}
