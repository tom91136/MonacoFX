
package monaco_editor.monaco;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>A selection in the editor.
 * The selection is a range that has an orientation.</p>
 * See {@code monaco.d.ts:701:31}<br>
 * Original signature:<br>
 * {@code export interface ISelection  }<br>
 */
@SuppressWarnings("unused")
public class ISelection extends JsProxy {

	public ISelection(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public ISelection(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>The column on <code>positionLineNumber</code> where the selection has ended.</p>
	 * See {@code monaco.d.ts:717:31}<br>
	 * Original signature:<br>
	 * {@code readonly positionColumn: number; }<br>
	 */
	public double positionColumn() { return get("positionColumn", ofMapped(double.class)); }

 	/**
	 * <p>The line number on which the selection has ended.</p>
	 * See {@code monaco.d.ts:713:35}<br>
	 * Original signature:<br>
	 * {@code readonly positionLineNumber: number; }<br>
	 */
	public double positionLineNumber() { return get("positionLineNumber", ofMapped(double.class)); }

 	/**
	 * <p>The column on <code>selectionStartLineNumber</code> where the selection has started.</p>
	 * See {@code monaco.d.ts:709:37}<br>
	 * Original signature:<br>
	 * {@code readonly selectionStartColumn: number; }<br>
	 */
	public double selectionStartColumn() { return get("selectionStartColumn", ofMapped(double.class)); }

 	/**
	 * <p>The line number on which the selection has started.</p>
	 * See {@code monaco.d.ts:705:41}<br>
	 * Original signature:<br>
	 * {@code readonly selectionStartLineNumber: number; }<br>
	 */
	public double selectionStartLineNumber() { return get("selectionStartLineNumber", ofMapped(double.class)); }

 
}
