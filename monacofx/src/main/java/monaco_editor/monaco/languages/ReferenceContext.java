
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>Value-object that contains additional information when
 * requesting references.</p>
 * See {@code monaco.d.ts:5539:37}<br>
 * Original signature:<br>
 * {@code export interface ReferenceContext  }<br>
 */
@SuppressWarnings("unused")
public class ReferenceContext extends JsProxy {

	public ReferenceContext(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public ReferenceContext(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Include the declaration of the current symbol.</p>
	 * See {@code monaco.d.ts:5543:26}<br>
	 * Original signature:<br>
	 * {@code includeDeclaration: boolean; }<br>
	 */
	public boolean includeDeclaration() { return get("includeDeclaration", ofMapped(boolean.class)); }

 	/**
	 * <p>Include the declaration of the current symbol.</p>
	 * See {@code monaco.d.ts:5543:26}<br>
	 * Original signature:<br>
	 * {@code includeDeclaration: boolean; }<br>
	 */
	public ReferenceContext includeDeclaration(@Nonnull Boolean value) {
		set("includeDeclaration", value);
		return this;
	}

 
}
