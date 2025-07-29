
package monaco_editor.monaco.languages;
import java.util.List;
import javax.annotation.Nonnull;
import monaco_editor.monaco.IDisposable;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:5396:35}<br>
 * Original signature:<br>
 * {@code export interface CodeActionList extends IDisposable  }<br>
 */
@SuppressWarnings("unused")
public class CodeActionList extends IDisposable {

	public CodeActionList(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public CodeActionList(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5397:24}<br>
	 * Original signature:<br>
	 * {@code readonly actions: ReadonlyArray<CodeAction>; }<br>
	 */
	public List<CodeAction> actions() { return get("actions", ofArray(CodeAction::new)); }

 
}
