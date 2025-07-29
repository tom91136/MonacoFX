
package monaco_editor.monaco.languages.typescript;
import java.util.List;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>A linked list of formatted diagnostic messages to be used as part of a multiline message.
 * It is built from the bottom up, leaving the head to be the &quot;main&quot; diagnostic.</p>
 * See {@code monaco.d.ts:6341:36}<br>
 * Original signature:<br>
 * {@code interface DiagnosticMessageChain  }<br>
 */
@SuppressWarnings("unused")
public class DiagnosticMessageChain extends JsProxy {

	public DiagnosticMessageChain(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public DiagnosticMessageChain(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:6345:12}<br>
	 * Original signature:<br>
	 * {@code code: number; }<br>
	 */
	public double code() { return get("code", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:6345:12}<br>
	 * Original signature:<br>
	 * {@code code: number; }<br>
	 */
	public DiagnosticMessageChain code(@Nonnull Double value) {
		set("code", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6342:19}<br>
	 * Original signature:<br>
	 * {@code messageText: string; }<br>
	 */
	public String messageText() { return get("messageText", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:6342:19}<br>
	 * Original signature:<br>
	 * {@code messageText: string; }<br>
	 */
	public DiagnosticMessageChain messageText(@Nonnull String value) {
		set("messageText", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6346:12}<br>
	 * Original signature:<br>
	 * {@code next?: DiagnosticMessageChain[]; }<br>
	 */
	public List<DiagnosticMessageChain> next() { return get("next", ofArray(DiagnosticMessageChain::new)); }

 	/**
	 * See {@code monaco.d.ts:6346:12}<br>
	 * Original signature:<br>
	 * {@code next?: DiagnosticMessageChain[]; }<br>
	 */
	public DiagnosticMessageChain next(@Nonnull List<DiagnosticMessageChain> value) {
		
		return this;
	}

 
}
