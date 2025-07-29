
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:1524:41}<br>
 * Original signature:<br>
 * {@code export class TextModelResolvedOptions  }<br>
 */
@SuppressWarnings("unused")
public class TextModelResolvedOptions extends JsProxy {

	public TextModelResolvedOptions(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public TextModelResolvedOptions(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:1529:27}<br>
	 * Original signature:<br>
	 * {@code readonly defaultEOL: DefaultEndOfLine; }<br>
	 */
	public DefaultEndOfLine defaultEOL() { return get("defaultEOL", ofJsEnum(DefaultEndOfLine.class)); }

 	/**
	 * See {@code monaco.d.ts:1527:27}<br>
	 * Original signature:<br>
	 * {@code readonly indentSize: number; }<br>
	 */
	public double indentSize() { return get("indentSize", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:1528:29}<br>
	 * Original signature:<br>
	 * {@code readonly insertSpaces: boolean; }<br>
	 */
	public boolean insertSpaces() { return get("insertSpaces", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:1526:24}<br>
	 * Original signature:<br>
	 * {@code readonly tabSize: number; }<br>
	 */
	public double tabSize() { return get("tabSize", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:1530:35}<br>
	 * Original signature:<br>
	 * {@code readonly trimAutoWhitespace: boolean; }<br>
	 */
	public boolean trimAutoWhitespace() { return get("trimAutoWhitespace", ofMapped(boolean.class)); }

 
}
