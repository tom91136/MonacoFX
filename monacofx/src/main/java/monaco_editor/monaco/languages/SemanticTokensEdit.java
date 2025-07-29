
package monaco_editor.monaco.languages;
import java.util.List;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:6007:39}<br>
 * Original signature:<br>
 * {@code export interface SemanticTokensEdit  }<br>
 */
@SuppressWarnings("unused")
public class SemanticTokensEdit extends JsProxy {

	public SemanticTokensEdit(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public SemanticTokensEdit(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:6010:21}<br>
	 * Original signature:<br>
	 * {@code readonly data?: Uint32Array; }<br>
	 */
	public List<Integer> data() { return get("data", ofArray(ofMapped(int.class))); }

 	/**
	 * See {@code monaco.d.ts:6009:28}<br>
	 * Original signature:<br>
	 * {@code readonly deleteCount: number; }<br>
	 */
	public double deleteCount() { return get("deleteCount", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:6008:22}<br>
	 * Original signature:<br>
	 * {@code readonly start: number; }<br>
	 */
	public double start() { return get("start", ofMapped(double.class)); }

 
}
