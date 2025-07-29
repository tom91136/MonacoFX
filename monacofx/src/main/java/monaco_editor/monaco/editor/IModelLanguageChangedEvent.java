
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>An event describing that the current mode associated with a model has changed.</p>
 * See {@code monaco.d.ts:2303:47}<br>
 * Original signature:<br>
 * {@code export interface IModelLanguageChangedEvent  }<br>
 */
@SuppressWarnings("unused")
public class IModelLanguageChangedEvent extends JsProxy {

	public IModelLanguageChangedEvent(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IModelLanguageChangedEvent(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>New language</p>
	 * See {@code monaco.d.ts:2311:28}<br>
	 * Original signature:<br>
	 * {@code readonly newLanguage: string; }<br>
	 */
	public String newLanguage() { return get("newLanguage", ofMapped(String.class)); }

 	/**
	 * <p>Previous language</p>
	 * See {@code monaco.d.ts:2307:28}<br>
	 * Original signature:<br>
	 * {@code readonly oldLanguage: string; }<br>
	 */
	public String oldLanguage() { return get("oldLanguage", ofMapped(String.class)); }

 
}
