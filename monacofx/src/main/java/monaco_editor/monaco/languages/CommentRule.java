
package monaco_editor.monaco.languages;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import net.kurobako.monacofx.js.JsUnion2;

/**
 * <p>Describes how comments for a language work.</p>
 * See {@code monaco.d.ts:4911:32}<br>
 * Original signature:<br>
 * {@code export interface CommentRule  }<br>
 */
@SuppressWarnings("unused")
public class CommentRule extends JsProxy {

	public CommentRule(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public CommentRule(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>The block comment character pair, like <code>/* block comment *&amp;#47;</code></p>
	 * See {@code monaco.d.ts:4919:20}<br>
	 * Original signature:<br>
	 * {@code blockComment?: CharacterPair | null; }<br>
	 */
	public Optional<JsUnion2<String, String>> blockComment() { return Optional.ofNullable(get("blockComment", null /*union*/)); }

 	/**
	 * <p>The block comment character pair, like <code>/* block comment *&amp;#47;</code></p>
	 * See {@code monaco.d.ts:4919:20}<br>
	 * Original signature:<br>
	 * {@code blockComment?: CharacterPair | null; }<br>
	 */
	public CommentRule blockComment(@Nullable JsUnion2<String, String> value) {
		set("blockComment", value);
		return this;
	}

 	/**
	 * <p>The line comment token, like <code>// this is a comment</code></p>
	 * See {@code monaco.d.ts:4915:19}<br>
	 * Original signature:<br>
	 * {@code lineComment?: string | null; }<br>
	 */
	public Optional<String> lineComment() { return Optional.ofNullable(get("lineComment", ofMapped(String.class))); }

 	/**
	 * <p>The line comment token, like <code>// this is a comment</code></p>
	 * See {@code monaco.d.ts:4915:19}<br>
	 * Original signature:<br>
	 * {@code lineComment?: string | null; }<br>
	 */
	public CommentRule lineComment(@Nullable String value) {
		set("lineComment", value);
		return this;
	}

 
}
