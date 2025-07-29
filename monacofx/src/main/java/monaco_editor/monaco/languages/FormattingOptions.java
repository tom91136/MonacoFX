
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>Interface used to format a model</p>
 * See {@code monaco.d.ts:5708:38}<br>
 * Original signature:<br>
 * {@code export interface FormattingOptions  }<br>
 */
@SuppressWarnings("unused")
public class FormattingOptions extends JsProxy {

	public FormattingOptions(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public FormattingOptions(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Prefer spaces over tabs.</p>
	 * See {@code monaco.d.ts:5716:20}<br>
	 * Original signature:<br>
	 * {@code insertSpaces: boolean; }<br>
	 */
	public boolean insertSpaces() { return get("insertSpaces", ofMapped(boolean.class)); }

 	/**
	 * <p>Prefer spaces over tabs.</p>
	 * See {@code monaco.d.ts:5716:20}<br>
	 * Original signature:<br>
	 * {@code insertSpaces: boolean; }<br>
	 */
	public FormattingOptions insertSpaces(@Nonnull Boolean value) {
		set("insertSpaces", value);
		return this;
	}

 	/**
	 * <p>Size of a tab in spaces.</p>
	 * See {@code monaco.d.ts:5712:15}<br>
	 * Original signature:<br>
	 * {@code tabSize: number; }<br>
	 */
	public double tabSize() { return get("tabSize", ofMapped(double.class)); }

 	/**
	 * <p>Size of a tab in spaces.</p>
	 * See {@code monaco.d.ts:5712:15}<br>
	 * Original signature:<br>
	 * {@code tabSize: number; }<br>
	 */
	public FormattingOptions tabSize(@Nonnull Double value) {
		set("tabSize", value);
		return this;
	}

 
}
