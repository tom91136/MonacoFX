
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:5959:30}<br>
 * Original signature:<br>
 * {@code export interface Rejection  }<br>
 */
@SuppressWarnings("unused")
public class Rejection extends JsProxy {

	public Rejection(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public Rejection(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5960:20}<br>
	 * Original signature:<br>
	 * {@code rejectReason?: string; }<br>
	 */
	public String rejectReason() { return get("rejectReason", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:5960:20}<br>
	 * Original signature:<br>
	 * {@code rejectReason?: string; }<br>
	 */
	public Rejection rejectReason(@Nonnull String value) {
		set("rejectReason", value);
		return this;
	}

 
}
