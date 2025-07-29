
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>An event describing that the configuration of the editor has changed.</p>
 * See {@code monaco.d.ts:3066:42}<br>
 * Original signature:<br>
 * {@code export class ConfigurationChangedEvent  }<br>
 */
@SuppressWarnings("unused")
public class ConfigurationChangedEvent extends JsProxy {

	public ConfigurationChangedEvent(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public ConfigurationChangedEvent(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:3067:18}<br>
	 * Original signature:<br>
	 * {@code hasChanged(id: EditorOption): boolean; }<br>
	 */
	public boolean hasChanged(@Nonnull EditorOption id) { return call("hasChanged", ofMapped(boolean.class), id); }

 
}
