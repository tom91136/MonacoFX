
package monaco_editor.monaco;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>A position in the editor. This interface is suitable for serialization.</p>
 * See {@code monaco.d.ts:446:30}<br>
 * Original signature:<br>
 * {@code export interface IPosition  }<br>
 */
@SuppressWarnings("unused")
public class IPosition extends JsProxy {

	public IPosition(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IPosition(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>column (the first character in a line is between column 1 and column 2)</p>
	 * See {@code monaco.d.ts:454:23}<br>
	 * Original signature:<br>
	 * {@code readonly column: number; }<br>
	 */
	public double column() { return get("column", ofMapped(double.class)); }

 	/**
	 * <p>line number (starts at 1)</p>
	 * See {@code monaco.d.ts:450:27}<br>
	 * Original signature:<br>
	 * {@code readonly lineNumber: number; }<br>
	 */
	public double lineNumber() { return get("lineNumber", ofMapped(double.class)); }

 
}
