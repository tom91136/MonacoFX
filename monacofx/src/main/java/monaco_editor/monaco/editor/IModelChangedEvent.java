
package monaco_editor.monaco.editor;
import java.util.Optional;
import javax.annotation.Nonnull;
import monaco_editor.monaco.Uri;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>An event describing that an editor has had its model reset (i.e. <code>editor.setModel()</code>).</p>
 * See {@code monaco.d.ts:1985:39}<br>
 * Original signature:<br>
 * {@code export interface IModelChangedEvent  }<br>
 */
@SuppressWarnings("unused")
public class IModelChangedEvent extends JsProxy {

	public IModelChangedEvent(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IModelChangedEvent(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>The <code>uri</code> of the new model or null.</p>
	 * See {@code monaco.d.ts:1993:28}<br>
	 * Original signature:<br>
	 * {@code readonly newModelUrl: Uri | null; }<br>
	 */
	public Optional<Uri> newModelUrl() { return Optional.ofNullable(get("newModelUrl", Uri::new)); }

 	/**
	 * <p>The <code>uri</code> of the previous model or null.</p>
	 * See {@code monaco.d.ts:1989:28}<br>
	 * Original signature:<br>
	 * {@code readonly oldModelUrl: Uri | null; }<br>
	 */
	public Optional<Uri> oldModelUrl() { return Optional.ofNullable(get("oldModelUrl", Uri::new)); }

 
}
