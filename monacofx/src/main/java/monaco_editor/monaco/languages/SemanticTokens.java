
package monaco_editor.monaco.languages;
import java.util.List;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:6002:35}<br>
 * Original signature:<br>
 * {@code export interface SemanticTokens  }<br>
 */
@SuppressWarnings("unused")
public class SemanticTokens extends JsProxy {

	public SemanticTokens(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public SemanticTokens(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:6004:21}<br>
	 * Original signature:<br>
	 * {@code readonly data: Uint32Array; }<br>
	 */
	public List<Integer> data() { return get("data", ofArray(ofMapped(int.class))); }

 	/**
	 * See {@code monaco.d.ts:6003:25}<br>
	 * Original signature:<br>
	 * {@code readonly resultId?: string; }<br>
	 */
	public String resultId() { return get("resultId", ofMapped(String.class)); }

 
}
