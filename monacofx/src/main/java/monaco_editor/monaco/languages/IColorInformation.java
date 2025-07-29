
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import monaco_editor.monaco.IRange;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>A color range is a range in a text model which represents a color.</p>
 * See {@code monaco.d.ts:5832:38}<br>
 * Original signature:<br>
 * {@code export interface IColorInformation  }<br>
 */
@SuppressWarnings("unused")
public class IColorInformation extends JsProxy {

	public IColorInformation(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IColorInformation(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>The color represented in this range.</p>
	 * See {@code monaco.d.ts:5840:13}<br>
	 * Original signature:<br>
	 * {@code color: IColor; }<br>
	 */
	public IColor color() { return get("color", IColor::new); }

 	/**
	 * <p>The color represented in this range.</p>
	 * See {@code monaco.d.ts:5840:13}<br>
	 * Original signature:<br>
	 * {@code color: IColor; }<br>
	 */
	public IColorInformation color(@Nonnull IColor value) {
		set("color", value);
		return this;
	}

 	/**
	 * <p>The range within the model.</p>
	 * See {@code monaco.d.ts:5836:13}<br>
	 * Original signature:<br>
	 * {@code range: IRange; }<br>
	 */
	public IRange range() { return get("range", IRange::new); }

 	/**
	 * <p>The range within the model.</p>
	 * See {@code monaco.d.ts:5836:13}<br>
	 * Original signature:<br>
	 * {@code range: IRange; }<br>
	 */
	public IColorInformation range(@Nonnull IRange value) {
		set("range", value);
		return this;
	}

 
}
