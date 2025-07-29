
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:846:42}<br>
 * Original signature:<br>
 * {@code export interface IDiffNavigatorOptions  }<br>
 */
@SuppressWarnings("unused")
public class IDiffNavigatorOptions extends JsProxy {

	public IDiffNavigatorOptions(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IDiffNavigatorOptions(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:849:34}<br>
	 * Original signature:<br>
	 * {@code readonly alwaysRevealFirst?: boolean; }<br>
	 */
	public boolean alwaysRevealFirst() { return get("alwaysRevealFirst", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:847:29}<br>
	 * Original signature:<br>
	 * {@code readonly followsCaret?: boolean; }<br>
	 */
	public boolean followsCaret() { return get("followsCaret", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:848:34}<br>
	 * Original signature:<br>
	 * {@code readonly ignoreCharChanges?: boolean; }<br>
	 */
	public boolean ignoreCharChanges() { return get("ignoreCharChanges", ofMapped(boolean.class)); }

 
}
