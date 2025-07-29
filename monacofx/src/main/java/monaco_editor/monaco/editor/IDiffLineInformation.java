
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>Information about a line in the diff editor</p>
 * See {@code monaco.d.ts:4559:41}<br>
 * Original signature:<br>
 * {@code export interface IDiffLineInformation  }<br>
 */
@SuppressWarnings("unused")
public class IDiffLineInformation extends JsProxy {

	public IDiffLineInformation(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IDiffLineInformation(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:4560:37}<br>
	 * Original signature:<br>
	 * {@code readonly equivalentLineNumber: number; }<br>
	 */
	public double equivalentLineNumber() { return get("equivalentLineNumber", ofMapped(double.class)); }

 
}
