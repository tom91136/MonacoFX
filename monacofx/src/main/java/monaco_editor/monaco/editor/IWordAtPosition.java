
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>Word inside a model.</p>
 * See {@code monaco.d.ts:1414:36}<br>
 * Original signature:<br>
 * {@code export interface IWordAtPosition  }<br>
 */
@SuppressWarnings("unused")
public class IWordAtPosition extends JsProxy {

	public IWordAtPosition(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IWordAtPosition(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>The column where the word ends.</p>
	 * See {@code monaco.d.ts:1426:26}<br>
	 * Original signature:<br>
	 * {@code readonly endColumn: number; }<br>
	 */
	public double endColumn() { return get("endColumn", ofMapped(double.class)); }

 	/**
	 * <p>The column where the word starts.</p>
	 * See {@code monaco.d.ts:1422:28}<br>
	 * Original signature:<br>
	 * {@code readonly startColumn: number; }<br>
	 */
	public double startColumn() { return get("startColumn", ofMapped(double.class)); }

 	/**
	 * <p>The word.</p>
	 * See {@code monaco.d.ts:1418:21}<br>
	 * Original signature:<br>
	 * {@code readonly word: string; }<br>
	 */
	public String word() { return get("word", ofMapped(String.class)); }

 
}
