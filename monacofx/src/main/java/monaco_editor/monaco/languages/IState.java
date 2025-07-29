
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>The state of the tokenizer between two lines.
 * It is useful to store flags such as in multiline comment, etc.
 * The model will clone the previous line's state and pass it in to tokenize the next line.</p>
 * See {@code monaco.d.ts:5131:27}<br>
 * Original signature:<br>
 * {@code export interface IState  }<br>
 */
@SuppressWarnings("unused")
public class IState extends JsProxy {

	public IState(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IState(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5132:13}<br>
	 * Original signature:<br>
	 * {@code clone(): IState; }<br>
	 */
	public IState clone() { return call("clone", IState::new); }

 	/**
	 * See {@code monaco.d.ts:5133:14}<br>
	 * Original signature:<br>
	 * {@code equals(other: IState): boolean; }<br>
	 */
	public boolean equals(@Nonnull IState other) { return call("equals", ofMapped(boolean.class), other); }

 
}
