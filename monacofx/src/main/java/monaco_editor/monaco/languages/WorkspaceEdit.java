
package monaco_editor.monaco.languages;
import java.util.List;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import net.kurobako.monacofx.js.JsUnion2;

/**
 * See {@code monaco.d.ts:5955:34}<br>
 * Original signature:<br>
 * {@code export interface WorkspaceEdit  }<br>
 */
@SuppressWarnings("unused")
public class WorkspaceEdit extends JsProxy {

	public WorkspaceEdit(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public WorkspaceEdit(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5956:13}<br>
	 * Original signature:<br>
	 * {@code edits: Array<WorkspaceTextEdit | WorkspaceFileEdit>; }<br>
	 */
	public JsUnion2<List<WorkspaceTextEdit>, List<WorkspaceFileEdit>> edits() { return get("edits", null /*union*/); }

 	/**
	 * See {@code monaco.d.ts:5956:13}<br>
	 * Original signature:<br>
	 * {@code edits: Array<WorkspaceTextEdit | WorkspaceFileEdit>; }<br>
	 */
	public WorkspaceEdit edits(@Nonnull JsUnion2<List<WorkspaceTextEdit>, List<WorkspaceFileEdit>> value) {
		set("edits", value);
		return this;
	}

 
}
