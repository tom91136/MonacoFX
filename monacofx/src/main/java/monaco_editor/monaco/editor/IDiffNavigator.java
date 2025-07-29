
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:818:35}<br>
 * Original signature:<br>
 * {@code export interface IDiffNavigator  }<br>
 */
@SuppressWarnings("unused")
public class IDiffNavigator extends JsProxy {

	public IDiffNavigator(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IDiffNavigator(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:819:19}<br>
	 * Original signature:<br>
	 * {@code canNavigate(): boolean; }<br>
	 */
	public boolean canNavigate() { return call("canNavigate", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:822:15}<br>
	 * Original signature:<br>
	 * {@code dispose(): void; }<br>
	 */
	public void dispose() { call("dispose", ofVoid()); }

 	/**
	 * See {@code monaco.d.ts:820:12}<br>
	 * Original signature:<br>
	 * {@code next(): void; }<br>
	 */
	public void next() { call("next", ofVoid()); }

 	/**
	 * See {@code monaco.d.ts:821:16}<br>
	 * Original signature:<br>
	 * {@code previous(): void; }<br>
	 */
	public void previous() { call("previous", ofVoid()); }

 
}
