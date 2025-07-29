
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>Configuration options for editor lightbulb</p>
 * See {@code monaco.d.ts:3322:44}<br>
 * Original signature:<br>
 * {@code export interface IEditorLightbulbOptions  }<br>
 */
@SuppressWarnings("unused")
public class IEditorLightbulbOptions extends JsProxy {

	public IEditorLightbulbOptions(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IEditorLightbulbOptions(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Enable the lightbulb code action.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:3327:15}<br>
	 * Original signature:<br>
	 * {@code enabled?: boolean; }<br>
	 */
	public boolean enabled() { return get("enabled", ofMapped(boolean.class)); }

 	/**
	 * <p>Enable the lightbulb code action.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:3327:15}<br>
	 * Original signature:<br>
	 * {@code enabled?: boolean; }<br>
	 */
	public IEditorLightbulbOptions enabled(@Nonnull Boolean value) {
		set("enabled", value);
		return this;
	}

 
}
