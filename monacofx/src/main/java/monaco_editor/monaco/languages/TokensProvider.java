
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>A &quot;manual&quot; provider of tokens.</p>
 * See {@code monaco.d.ts:4737:35}<br>
 * Original signature:<br>
 * {@code export interface TokensProvider  }<br>
 */
@SuppressWarnings("unused")
public class TokensProvider extends JsProxy {

	public TokensProvider(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public TokensProvider(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>The initial state of a language. Will be the state passed in to tokenize the first line.</p>
	 * See {@code monaco.d.ts:4741:23}<br>
	 * Original signature:<br>
	 * {@code getInitialState(): IState; }<br>
	 */
	public IState getInitialState() { return call("getInitialState", IState::new); }

 	/**
	 * <p>Tokenize a line given the state at the beginning of the line.</p>
	 * See {@code monaco.d.ts:4745:16}<br>
	 * Original signature:<br>
	 * {@code tokenize(line: string, state: IState): ILineTokens; }<br>
	 */
	public ILineTokens tokenize(@Nonnull String line, @Nonnull IState state) { return call("tokenize", ILineTokens::new, line, state); }

 
}
