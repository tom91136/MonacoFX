
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import monaco_editor.monaco.Selection;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>A command that modifies text / cursor state on a model.</p>
 * See {@code monaco.d.ts:1952:29}<br>
 * Original signature:<br>
 * {@code export interface ICommand  }<br>
 */
@SuppressWarnings("unused")
public class ICommand extends JsProxy {

	public ICommand(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public ICommand(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Compute the cursor state after the edit operations were applied.</p>
	 * See {@code monaco.d.ts:1965:26}<br>
	 * Original signature:<br>
	 * {@code computeCursorState(model: ITextModel, helper: ICursorStateComputerData): Selection; }<br>
	 * 
	 * @param model The model the command has executed on.
	 * @param helper A helper to get inverse edit operations and to get previously tracked selections.
	 */
	public Selection computeCursorState(@Nonnull ITextModel model, @Nonnull ICursorStateComputerData helper) { return call("computeCursorState", Selection::new, model, helper); }

 	/**
	 * <p>Get the edit operations needed to execute this command.</p>
	 * See {@code monaco.d.ts:1958:25}<br>
	 * Original signature:<br>
	 * {@code getEditOperations(model: ITextModel, builder: IEditOperationBuilder): void; }<br>
	 * 
	 * @param model The model the command will execute on.
	 * @param builder A helper to collect the needed edit operations and to track selections.
	 */
	public void getEditOperations(@Nonnull ITextModel model, @Nonnull IEditOperationBuilder builder) { call("getEditOperations", ofVoid(), model, builder); }

 
}
