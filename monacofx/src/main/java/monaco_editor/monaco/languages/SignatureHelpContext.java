
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:5469:41}<br>
 * Original signature:<br>
 * {@code export interface SignatureHelpContext  }<br>
 */
@SuppressWarnings("unused")
public class SignatureHelpContext extends JsProxy {

	public SignatureHelpContext(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public SignatureHelpContext(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5473:36}<br>
	 * Original signature:<br>
	 * {@code readonly activeSignatureHelp?: SignatureHelp; }<br>
	 */
	public SignatureHelp activeSignatureHelp() { return get("activeSignatureHelp", SignatureHelp::new); }

 	/**
	 * See {@code monaco.d.ts:5472:28}<br>
	 * Original signature:<br>
	 * {@code readonly isRetrigger: boolean; }<br>
	 */
	public boolean isRetrigger() { return get("isRetrigger", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:5471:33}<br>
	 * Original signature:<br>
	 * {@code readonly triggerCharacter?: string; }<br>
	 */
	public String triggerCharacter() { return get("triggerCharacter", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:5470:28}<br>
	 * Original signature:<br>
	 * {@code readonly triggerKind: SignatureHelpTriggerKind; }<br>
	 */
	public SignatureHelpTriggerKind triggerKind() { return get("triggerKind", ofJsEnum(SignatureHelpTriggerKind.class)); }

 
}
