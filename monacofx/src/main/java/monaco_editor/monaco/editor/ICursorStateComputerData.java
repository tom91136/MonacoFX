
package monaco_editor.monaco.editor;
import java.util.List;
import javax.annotation.Nonnull;
import monaco_editor.monaco.Selection;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>A helper for computing cursor state after a command.</p>
 * See {@code monaco.d.ts:1936:45}<br>
 * Original signature:<br>
 * {@code export interface ICursorStateComputerData  }<br>
 */
@SuppressWarnings("unused")
public class ICursorStateComputerData extends JsProxy {

	public ICursorStateComputerData(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public ICursorStateComputerData(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Get the inverse edit operations of the added edit operations.</p>
	 * See {@code monaco.d.ts:1940:32}<br>
	 * Original signature:<br>
	 * {@code getInverseEditOperations(): IIdentifiedSingleEditOperation[]; }<br>
	 */
	public List<IIdentifiedSingleEditOperation> getInverseEditOperations() { return call("getInverseEditOperations", ofArray(IIdentifiedSingleEditOperation::new)); }

 	/**
	 * <p>Get a previously tracked selection.</p>
	 * See {@code monaco.d.ts:1946:27}<br>
	 * Original signature:<br>
	 * {@code getTrackedSelection(id: string): Selection; }<br>
	 * 
	 * @param id The unique identifier returned by <code>trackSelection</code>.
	 */
	public Selection getTrackedSelection(@Nonnull String id) { return call("getTrackedSelection", Selection::new, id); }

 
}
