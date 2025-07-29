
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import monaco_editor.monaco.IDisposable;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:5459:40}<br>
 * Original signature:<br>
 * {@code export interface SignatureHelpResult extends IDisposable  }<br>
 */
@SuppressWarnings("unused")
public class SignatureHelpResult extends IDisposable {

	public SignatureHelpResult(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public SignatureHelpResult(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5460:13}<br>
	 * Original signature:<br>
	 * {@code value: SignatureHelp; }<br>
	 */
	public SignatureHelp value() { return get("value", SignatureHelp::new); }

 	/**
	 * See {@code monaco.d.ts:5460:13}<br>
	 * Original signature:<br>
	 * {@code value: SignatureHelp; }<br>
	 */
	public SignatureHelpResult value(@Nonnull SignatureHelp value) {
		set("value", value);
		return this;
	}

 
}
