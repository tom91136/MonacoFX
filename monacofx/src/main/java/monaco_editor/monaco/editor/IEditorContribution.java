
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import netscape.javascript.JSObject;

/**
 * <p>An editor contribution that gets created every time a new editor gets created and gets disposed when the editor gets disposed.</p>
 * See {@code monaco.d.ts:2277:40}<br>
 * Original signature:<br>
 * {@code export interface IEditorContribution  }<br>
 */
@SuppressWarnings("unused")
public class IEditorContribution extends JsProxy {

	public IEditorContribution(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IEditorContribution(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Dispose this contribution.</p>
	 * See {@code monaco.d.ts:2281:15}<br>
	 * Original signature:<br>
	 * {@code dispose(): void; }<br>
	 */
	public void dispose() { call("dispose", ofVoid()); }

 	/**
	 * <p>Restore view state.</p>
	 * See {@code monaco.d.ts:2289:24}<br>
	 * Original signature:<br>
	 * {@code restoreViewState?(state: any): void; }<br>
	 */
	public void restoreViewState(@Nonnull JSObject state) { call("restoreViewState", ofVoid(), state); }

 	/**
	 * <p>Store view state.</p>
	 * See {@code monaco.d.ts:2285:21}<br>
	 * Original signature:<br>
	 * {@code saveViewState?(): any; }<br>
	 */
	public JSObject saveViewState() { return call("saveViewState", ofMapped(JSObject.class)); }

 
}
