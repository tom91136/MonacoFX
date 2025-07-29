
package monaco_editor.monaco.languages;
import java.util.List;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>The result of a line tokenization.</p>
 * See {@code monaco.d.ts:4690:32}<br>
 * Original signature:<br>
 * {@code export interface ILineTokens  }<br>
 */
@SuppressWarnings("unused")
public class ILineTokens extends JsProxy {

	public ILineTokens(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public ILineTokens(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>The tokenization end state.
	 * A pointer will be held to this and the object should not be modified by the tokenizer after the pointer is returned.</p>
	 * See {@code monaco.d.ts:4699:16}<br>
	 * Original signature:<br>
	 * {@code endState: IState; }<br>
	 */
	public IState endState() { return get("endState", IState::new); }

 	/**
	 * <p>The tokenization end state.
	 * A pointer will be held to this and the object should not be modified by the tokenizer after the pointer is returned.</p>
	 * See {@code monaco.d.ts:4699:16}<br>
	 * Original signature:<br>
	 * {@code endState: IState; }<br>
	 */
	public ILineTokens endState(@Nonnull IState value) {
		set("endState", value);
		return this;
	}

 	/**
	 * <p>The list of tokens on the line.</p>
	 * See {@code monaco.d.ts:4694:14}<br>
	 * Original signature:<br>
	 * {@code tokens: IToken[]; }<br>
	 */
	public List<IToken> tokens() { return get("tokens", ofArray(IToken::new)); }

 	/**
	 * <p>The list of tokens on the line.</p>
	 * See {@code monaco.d.ts:4694:14}<br>
	 * Original signature:<br>
	 * {@code tokens: IToken[]; }<br>
	 */
	public ILineTokens tokens(@Nonnull List<IToken> value) {
		
		return this;
	}

 
}
