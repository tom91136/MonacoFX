
package monaco_editor.monaco.languages;
import java.util.List;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:5997:41}<br>
 * Original signature:<br>
 * {@code export interface SemanticTokensLegend  }<br>
 */
@SuppressWarnings("unused")
public class SemanticTokensLegend extends JsProxy {

	public SemanticTokensLegend(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public SemanticTokensLegend(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5999:31}<br>
	 * Original signature:<br>
	 * {@code readonly tokenModifiers: string[]; }<br>
	 */
	public List<String> tokenModifiers() { return get("tokenModifiers", ofArray(ofMapped(String.class))); }

 	/**
	 * See {@code monaco.d.ts:5998:27}<br>
	 * Original signature:<br>
	 * {@code readonly tokenTypes: string[]; }<br>
	 */
	public List<String> tokenTypes() { return get("tokenTypes", ofArray(ofMapped(String.class))); }

 
}
