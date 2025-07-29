
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>Describes what to do when pressing Enter.</p>
 * See {@code monaco.d.ts:5111:32}<br>
 * Original signature:<br>
 * {@code export interface EnterAction  }<br>
 */
@SuppressWarnings("unused")
public class EnterAction extends JsProxy {

	public EnterAction(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public EnterAction(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Describes text to be appended after the new line and after the indentation.</p>
	 * See {@code monaco.d.ts:5119:18}<br>
	 * Original signature:<br>
	 * {@code appendText?: string; }<br>
	 */
	public String appendText() { return get("appendText", ofMapped(String.class)); }

 	/**
	 * <p>Describes text to be appended after the new line and after the indentation.</p>
	 * See {@code monaco.d.ts:5119:18}<br>
	 * Original signature:<br>
	 * {@code appendText?: string; }<br>
	 */
	public EnterAction appendText(@Nonnull String value) {
		set("appendText", value);
		return this;
	}

 	/**
	 * <p>Describe what to do with the indentation.</p>
	 * See {@code monaco.d.ts:5115:20}<br>
	 * Original signature:<br>
	 * {@code indentAction: IndentAction; }<br>
	 */
	public IndentAction indentAction() { return get("indentAction", ofJsEnum(IndentAction.class)); }

 	/**
	 * <p>Describe what to do with the indentation.</p>
	 * See {@code monaco.d.ts:5115:20}<br>
	 * Original signature:<br>
	 * {@code indentAction: IndentAction; }<br>
	 */
	public EnterAction indentAction(@Nonnull IndentAction value) {
		set("indentAction", value);
		return this;
	}

 	/**
	 * <p>Describes the number of characters to remove from the new line's indentation.</p>
	 * See {@code monaco.d.ts:5123:18}<br>
	 * Original signature:<br>
	 * {@code removeText?: number; }<br>
	 */
	public double removeText() { return get("removeText", ofMapped(double.class)); }

 	/**
	 * <p>Describes the number of characters to remove from the new line's indentation.</p>
	 * See {@code monaco.d.ts:5123:18}<br>
	 * Original signature:<br>
	 * {@code removeText?: number; }<br>
	 */
	public EnterAction removeText(@Nonnull Double value) {
		set("removeText", value);
		return this;
	}

 
}
