
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:1533:44}<br>
 * Original signature:<br>
 * {@code export interface ITextModelUpdateOptions  }<br>
 */
@SuppressWarnings("unused")
public class ITextModelUpdateOptions extends JsProxy {

	public ITextModelUpdateOptions(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public ITextModelUpdateOptions(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:1535:18}<br>
	 * Original signature:<br>
	 * {@code indentSize?: number; }<br>
	 */
	public double indentSize() { return get("indentSize", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:1535:18}<br>
	 * Original signature:<br>
	 * {@code indentSize?: number; }<br>
	 */
	public ITextModelUpdateOptions indentSize(@Nonnull Double value) {
		set("indentSize", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1536:20}<br>
	 * Original signature:<br>
	 * {@code insertSpaces?: boolean; }<br>
	 */
	public boolean insertSpaces() { return get("insertSpaces", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:1536:20}<br>
	 * Original signature:<br>
	 * {@code insertSpaces?: boolean; }<br>
	 */
	public ITextModelUpdateOptions insertSpaces(@Nonnull Boolean value) {
		set("insertSpaces", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1534:15}<br>
	 * Original signature:<br>
	 * {@code tabSize?: number; }<br>
	 */
	public double tabSize() { return get("tabSize", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:1534:15}<br>
	 * Original signature:<br>
	 * {@code tabSize?: number; }<br>
	 */
	public ITextModelUpdateOptions tabSize(@Nonnull Double value) {
		set("tabSize", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1537:26}<br>
	 * Original signature:<br>
	 * {@code trimAutoWhitespace?: boolean; }<br>
	 */
	public boolean trimAutoWhitespace() { return get("trimAutoWhitespace", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:1537:26}<br>
	 * Original signature:<br>
	 * {@code trimAutoWhitespace?: boolean; }<br>
	 */
	public ITextModelUpdateOptions trimAutoWhitespace(@Nonnull Boolean value) {
		set("trimAutoWhitespace", value);
		return this;
	}

 
}
