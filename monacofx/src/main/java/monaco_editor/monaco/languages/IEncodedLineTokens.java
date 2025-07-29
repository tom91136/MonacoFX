
package monaco_editor.monaco.languages;
import java.util.List;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>The result of a line tokenization.</p>
 * See {@code monaco.d.ts:4705:39}<br>
 * Original signature:<br>
 * {@code export interface IEncodedLineTokens  }<br>
 */
@SuppressWarnings("unused")
public class IEncodedLineTokens extends JsProxy {

	public IEncodedLineTokens(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IEncodedLineTokens(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>The tokenization end state.
	 * A pointer will be held to this and the object should not be modified by the tokenizer after the pointer is returned.</p>
	 * See {@code monaco.d.ts:4731:16}<br>
	 * Original signature:<br>
	 * {@code endState: IState; }<br>
	 */
	public IState endState() { return get("endState", IState::new); }

 	/**
	 * <p>The tokenization end state.
	 * A pointer will be held to this and the object should not be modified by the tokenizer after the pointer is returned.</p>
	 * See {@code monaco.d.ts:4731:16}<br>
	 * Original signature:<br>
	 * {@code endState: IState; }<br>
	 */
	public IEncodedLineTokens endState(@Nonnull IState value) {
		set("endState", value);
		return this;
	}

 	/**
	 * <p>The tokens on the line in a binary, encoded format. Each token occupies two array indices. For token i:</p>
	 * <ul>
	 * <li>at offset 2*i =&gt; startIndex</li>
	 * <li>at offset 2*i + 1 =&gt; metadata
	 * Meta data is in binary format:</li>
	 * </ul>
	 * <hr />
	 * <pre><code>3322 2222 2222 1111 1111 1100 0000 0000
	 * 1098 7654 3210 9876 5432 1098 7654 3210
	 * </code></pre>
	 * <hr />
	 * <pre><code>bbbb bbbb bfff ffff ffFF FTTT LLLL LLLL
	 * </code></pre>
	 * <hr />
	 * <ul>
	 * <li>L = EncodedLanguageId (8 bits): Use <code>getEncodedLanguageId</code> to get the encoded ID of a language.</li>
	 * <li>T = StandardTokenType (3 bits): Other = 0, Comment = 1, String = 2, RegEx = 4.</li>
	 * <li>F = FontStyle (3 bits): None = 0, Italic = 1, Bold = 2, Underline = 4.</li>
	 * <li>f = foreground ColorId (9 bits)</li>
	 * <li>b = background ColorId (9 bits)</li>
	 * <li>The color value for each colorId is defined in IStandaloneThemeData.customTokenColors:
	 * e.g. colorId = 1 is stored in IStandaloneThemeData.customTokenColors[1]. Color id = 0 means no color,
	 * id = 1 is for the default foreground color, id = 2 for the default background.</li>
	 * </ul>
	 * See {@code monaco.d.ts:4726:14}<br>
	 * Original signature:<br>
	 * {@code tokens: Uint32Array; }<br>
	 */
	public List<Integer> tokens() { return get("tokens", ofArray(ofMapped(int.class))); }

 	/**
	 * <p>The tokens on the line in a binary, encoded format. Each token occupies two array indices. For token i:</p>
	 * <ul>
	 * <li>at offset 2*i =&gt; startIndex</li>
	 * <li>at offset 2*i + 1 =&gt; metadata
	 * Meta data is in binary format:</li>
	 * </ul>
	 * <hr />
	 * <pre><code>3322 2222 2222 1111 1111 1100 0000 0000
	 * 1098 7654 3210 9876 5432 1098 7654 3210
	 * </code></pre>
	 * <hr />
	 * <pre><code>bbbb bbbb bfff ffff ffFF FTTT LLLL LLLL
	 * </code></pre>
	 * <hr />
	 * <ul>
	 * <li>L = EncodedLanguageId (8 bits): Use <code>getEncodedLanguageId</code> to get the encoded ID of a language.</li>
	 * <li>T = StandardTokenType (3 bits): Other = 0, Comment = 1, String = 2, RegEx = 4.</li>
	 * <li>F = FontStyle (3 bits): None = 0, Italic = 1, Bold = 2, Underline = 4.</li>
	 * <li>f = foreground ColorId (9 bits)</li>
	 * <li>b = background ColorId (9 bits)</li>
	 * <li>The color value for each colorId is defined in IStandaloneThemeData.customTokenColors:
	 * e.g. colorId = 1 is stored in IStandaloneThemeData.customTokenColors[1]. Color id = 0 means no color,
	 * id = 1 is for the default foreground color, id = 2 for the default background.</li>
	 * </ul>
	 * See {@code monaco.d.ts:4726:14}<br>
	 * Original signature:<br>
	 * {@code tokens: Uint32Array; }<br>
	 */
	public IEncodedLineTokens tokens(@Nonnull List<Integer> value) {
		
		return this;
	}

 
}
