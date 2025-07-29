
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsPromise;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:2040:34}<br>
 * Original signature:<br>
 * {@code export interface IEditorAction  }<br>
 */
@SuppressWarnings("unused")
public class IEditorAction extends JsProxy {

	public IEditorAction(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IEditorAction(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:2043:22}<br>
	 * Original signature:<br>
	 * {@code readonly alias: string; }<br>
	 */
	public String alias() { return get("alias", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:2041:19}<br>
	 * Original signature:<br>
	 * {@code readonly id: string; }<br>
	 */
	public String id() { return get("id", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:2042:22}<br>
	 * Original signature:<br>
	 * {@code readonly label: string; }<br>
	 */
	public String label() { return get("label", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:2044:19}<br>
	 * Original signature:<br>
	 * {@code isSupported(): boolean; }<br>
	 */
	public boolean isSupported() { return call("isSupported", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:2045:11}<br>
	 * Original signature:<br>
	 * {@code run(): Promise<void>; }<br>
	 */
	public JsPromise<Void> run() { return call("run", JsPromise ::new); }

 
}
