
package monaco_editor.monaco.languages;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>Describes indentation rules for a language.</p>
 * See {@code monaco.d.ts:4986:36}<br>
 * Original signature:<br>
 * {@code export interface IndentationRule  }<br>
 */
@SuppressWarnings("unused")
public class IndentationRule extends JsProxy {

	public IndentationRule(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IndentationRule(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>If a line matches this pattern, then all the lines after it should be unindented once (until another rule matches).</p>
	 * See {@code monaco.d.ts:4990:29}<br>
	 * Original signature:<br>
	 * {@code decreaseIndentPattern: RegExp; }<br>
	 */
	public String decreaseIndentPattern() { return get("decreaseIndentPattern", ofMapped(String.class)); }

 	/**
	 * <p>If a line matches this pattern, then all the lines after it should be unindented once (until another rule matches).</p>
	 * See {@code monaco.d.ts:4990:29}<br>
	 * Original signature:<br>
	 * {@code decreaseIndentPattern: RegExp; }<br>
	 */
	public IndentationRule decreaseIndentPattern(@Nonnull String value) {
		set("decreaseIndentPattern", value);
		return this;
	}

 	/**
	 * <p>If a line matches this pattern, then all the lines after it should be indented once (until another rule matches).</p>
	 * See {@code monaco.d.ts:4994:29}<br>
	 * Original signature:<br>
	 * {@code increaseIndentPattern: RegExp; }<br>
	 */
	public String increaseIndentPattern() { return get("increaseIndentPattern", ofMapped(String.class)); }

 	/**
	 * <p>If a line matches this pattern, then all the lines after it should be indented once (until another rule matches).</p>
	 * See {@code monaco.d.ts:4994:29}<br>
	 * Original signature:<br>
	 * {@code increaseIndentPattern: RegExp; }<br>
	 */
	public IndentationRule increaseIndentPattern(@Nonnull String value) {
		set("increaseIndentPattern", value);
		return this;
	}

 	/**
	 * <p>If a line matches this pattern, then <strong>only the next line</strong> after it should be indented once.</p>
	 * See {@code monaco.d.ts:4998:29}<br>
	 * Original signature:<br>
	 * {@code indentNextLinePattern?: RegExp | null; }<br>
	 */
	public Optional<String> indentNextLinePattern() { return Optional.ofNullable(get("indentNextLinePattern", ofMapped(String.class))); }

 	/**
	 * <p>If a line matches this pattern, then <strong>only the next line</strong> after it should be indented once.</p>
	 * See {@code monaco.d.ts:4998:29}<br>
	 * Original signature:<br>
	 * {@code indentNextLinePattern?: RegExp | null; }<br>
	 */
	public IndentationRule indentNextLinePattern(@Nullable String value) {
		set("indentNextLinePattern", value);
		return this;
	}

 	/**
	 * <p>If a line matches this pattern, then its indentation should not be changed and it should not be evaluated against the other rules.</p>
	 * See {@code monaco.d.ts:5002:29}<br>
	 * Original signature:<br>
	 * {@code unIndentedLinePattern?: RegExp | null; }<br>
	 */
	public Optional<String> unIndentedLinePattern() { return Optional.ofNullable(get("unIndentedLinePattern", ofMapped(String.class))); }

 	/**
	 * <p>If a line matches this pattern, then its indentation should not be changed and it should not be evaluated against the other rules.</p>
	 * See {@code monaco.d.ts:5002:29}<br>
	 * Original signature:<br>
	 * {@code unIndentedLinePattern?: RegExp | null; }<br>
	 */
	public IndentationRule unIndentedLinePattern(@Nullable String value) {
		set("unIndentedLinePattern", value);
		return this;
	}

 
}
