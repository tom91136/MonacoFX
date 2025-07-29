
package monaco_editor.monaco.languages;
import java.util.List;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:6013:40}<br>
 * Original signature:<br>
 * {@code export interface SemanticTokensEdits  }<br>
 */
@SuppressWarnings("unused")
public class SemanticTokensEdits extends JsProxy {

	public SemanticTokensEdits(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public SemanticTokensEdits(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:6015:22}<br>
	 * Original signature:<br>
	 * {@code readonly edits: SemanticTokensEdit[]; }<br>
	 */
	public List<SemanticTokensEdit> edits() { return get("edits", ofArray(SemanticTokensEdit::new)); }

 	/**
	 * See {@code monaco.d.ts:6014:25}<br>
	 * Original signature:<br>
	 * {@code readonly resultId?: string; }<br>
	 */
	public String resultId() { return get("resultId", ofMapped(String.class)); }

 
}
