
package monaco_editor.monaco;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>A range in the editor. This interface is suitable for serialization.</p>
 * See {@code monaco.d.ts:537:27}<br>
 * Original signature:<br>
 * {@code export interface IRange  }<br>
 */
@SuppressWarnings("unused")
public class IRange extends JsProxy {

	public IRange(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IRange(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Column on which the range ends in line <code>endLineNumber</code>.</p>
	 * See {@code monaco.d.ts:553:26}<br>
	 * Original signature:<br>
	 * {@code readonly endColumn: number; }<br>
	 */
	public double endColumn() { return get("endColumn", ofMapped(double.class)); }

 	/**
	 * <p>Line number on which the range ends.</p>
	 * See {@code monaco.d.ts:549:30}<br>
	 * Original signature:<br>
	 * {@code readonly endLineNumber: number; }<br>
	 */
	public double endLineNumber() { return get("endLineNumber", ofMapped(double.class)); }

 	/**
	 * <p>Column on which the range starts in line <code>startLineNumber</code> (starts at 1).</p>
	 * See {@code monaco.d.ts:545:28}<br>
	 * Original signature:<br>
	 * {@code readonly startColumn: number; }<br>
	 */
	public double startColumn() { return get("startColumn", ofMapped(double.class)); }

 	/**
	 * <p>Line number on which the range starts (starts at 1).</p>
	 * See {@code monaco.d.ts:541:32}<br>
	 * Original signature:<br>
	 * {@code readonly startLineNumber: number; }<br>
	 */
	public double startLineNumber() { return get("startLineNumber", ofMapped(double.class)); }

 
}
