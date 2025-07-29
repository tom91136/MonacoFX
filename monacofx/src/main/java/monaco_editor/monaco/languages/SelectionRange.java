
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import monaco_editor.monaco.IRange;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:5857:35}<br>
 * Original signature:<br>
 * {@code export interface SelectionRange  }<br>
 */
@SuppressWarnings("unused")
public class SelectionRange extends JsProxy {

	public SelectionRange(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public SelectionRange(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5858:13}<br>
	 * Original signature:<br>
	 * {@code range: IRange; }<br>
	 */
	public IRange range() { return get("range", IRange::new); }

 	/**
	 * See {@code monaco.d.ts:5858:13}<br>
	 * Original signature:<br>
	 * {@code range: IRange; }<br>
	 */
	public SelectionRange range(@Nonnull IRange value) {
		set("range", value);
		return this;
	}

 
}
