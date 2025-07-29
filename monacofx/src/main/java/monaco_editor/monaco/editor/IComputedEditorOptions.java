
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>All computed editor options.</p>
 * See {@code monaco.d.ts:3073:43}<br>
 * Original signature:<br>
 * {@code export interface IComputedEditorOptions  }<br>
 */
@SuppressWarnings("unused")
public class IComputedEditorOptions extends JsProxy {

	public IComputedEditorOptions(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IComputedEditorOptions(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:3074:11}<br>
	 * Original signature:<br>
	 * {@code get<T extends EditorOption>(id: T): FindComputedEditorOptionValueById<T>; }<br>
	 */
	public <T extends EditorOption> T get(@Nonnull T id) { return call("get", null , id); }

 
}
