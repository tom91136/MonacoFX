
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>A &quot;manual&quot; provider of tokens, returning tokens in a binary form.</p>
 * See {@code monaco.d.ts:4751:42}<br>
 * Original signature:<br>
 * {@code export interface EncodedTokensProvider  }<br>
 */
@SuppressWarnings("unused")
public class EncodedTokensProvider extends JsProxy {

	public EncodedTokensProvider(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public EncodedTokensProvider(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>The initial state of a language. Will be the state passed in to tokenize the first line.</p>
	 * See {@code monaco.d.ts:4755:23}<br>
	 * Original signature:<br>
	 * {@code getInitialState(): IState; }<br>
	 */
	public IState getInitialState() { return call("getInitialState", IState::new); }

 	/**
	 * <p>Tokenize a line given the state at the beginning of the line.</p>
	 * See {@code monaco.d.ts:4759:23}<br>
	 * Original signature:<br>
	 * {@code tokenizeEncoded(line: string, state: IState): IEncodedLineTokens; }<br>
	 */
	public IEncodedLineTokens tokenizeEncoded(@Nonnull String line, @Nonnull IState state) { return call("tokenizeEncoded", IEncodedLineTokens::new, line, state); }

 
}
