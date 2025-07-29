
package monaco_editor.monaco.languages;
import java.util.List;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:5986:33}<br>
 * Original signature:<br>
 * {@code export interface CodeLensList  }<br>
 */
@SuppressWarnings("unused")
public class CodeLensList extends JsProxy {

	public CodeLensList(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public CodeLensList(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5987:14}<br>
	 * Original signature:<br>
	 * {@code lenses: CodeLens[]; }<br>
	 */
	public List<CodeLens> lenses() { return get("lenses", ofArray(CodeLens::new)); }

 	/**
	 * See {@code monaco.d.ts:5987:14}<br>
	 * Original signature:<br>
	 * {@code lenses: CodeLens[]; }<br>
	 */
	public CodeLensList lenses(@Nonnull List<CodeLens> value) {
		
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5988:15}<br>
	 * Original signature:<br>
	 * {@code dispose(): void; }<br>
	 */
	public void dispose() { call("dispose", ofVoid()); }

 
}
