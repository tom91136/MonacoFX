
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>Options which apply for all editors.</p>
 * See {@code monaco.d.ts:1066:41}<br>
 * Original signature:<br>
 * {@code export interface IGlobalEditorOptions  }<br>
 */
@SuppressWarnings("unused")
public class IGlobalEditorOptions extends JsProxy {

	public IGlobalEditorOptions(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IGlobalEditorOptions(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Controls whether <code>tabSize</code> and <code>insertSpaces</code> will be automatically detected when a file is opened based on the file contents.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:1083:25}<br>
	 * Original signature:<br>
	 * {@code detectIndentation?: boolean; }<br>
	 */
	public boolean detectIndentation() { return get("detectIndentation", ofMapped(boolean.class)); }

 	/**
	 * <p>Controls whether <code>tabSize</code> and <code>insertSpaces</code> will be automatically detected when a file is opened based on the file contents.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:1083:25}<br>
	 * Original signature:<br>
	 * {@code detectIndentation?: boolean; }<br>
	 */
	public IGlobalEditorOptions detectIndentation(@Nonnull Boolean value) {
		set("detectIndentation", value);
		return this;
	}

 	/**
	 * <p>Insert spaces when pressing <code>Tab</code>.
	 * This setting is overridden based on the file contents when <code>detectIndentation</code> is on.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:1078:20}<br>
	 * Original signature:<br>
	 * {@code insertSpaces?: boolean; }<br>
	 */
	public boolean insertSpaces() { return get("insertSpaces", ofMapped(boolean.class)); }

 	/**
	 * <p>Insert spaces when pressing <code>Tab</code>.
	 * This setting is overridden based on the file contents when <code>detectIndentation</code> is on.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:1078:20}<br>
	 * Original signature:<br>
	 * {@code insertSpaces?: boolean; }<br>
	 */
	public IGlobalEditorOptions insertSpaces(@Nonnull Boolean value) {
		set("insertSpaces", value);
		return this;
	}

 	/**
	 * <p>Special handling for large files to disable certain memory intensive features.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:1093:30}<br>
	 * Original signature:<br>
	 * {@code largeFileOptimizations?: boolean; }<br>
	 */
	public boolean largeFileOptimizations() { return get("largeFileOptimizations", ofMapped(boolean.class)); }

 	/**
	 * <p>Special handling for large files to disable certain memory intensive features.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:1093:30}<br>
	 * Original signature:<br>
	 * {@code largeFileOptimizations?: boolean; }<br>
	 */
	public IGlobalEditorOptions largeFileOptimizations(@Nonnull Boolean value) {
		set("largeFileOptimizations", value);
		return this;
	}

 	/**
	 * <p>Lines above this length will not be tokenized for performance reasons.
	 * Defaults to 20000.</p>
	 * See {@code monaco.d.ts:1108:33}<br>
	 * Original signature:<br>
	 * {@code maxTokenizationLineLength?: number; }<br>
	 */
	public double maxTokenizationLineLength() { return get("maxTokenizationLineLength", ofMapped(double.class)); }

 	/**
	 * <p>Lines above this length will not be tokenized for performance reasons.
	 * Defaults to 20000.</p>
	 * See {@code monaco.d.ts:1108:33}<br>
	 * Original signature:<br>
	 * {@code maxTokenizationLineLength?: number; }<br>
	 */
	public IGlobalEditorOptions maxTokenizationLineLength(@Nonnull Double value) {
		set("maxTokenizationLineLength", value);
		return this;
	}

 	/**
	 * <p>Keep peek editors open even when double clicking their content or when hitting <code>Escape</code>.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:1103:18}<br>
	 * Original signature:<br>
	 * {@code stablePeek?: boolean; }<br>
	 */
	public boolean stablePeek() { return get("stablePeek", ofMapped(boolean.class)); }

 	/**
	 * <p>Keep peek editors open even when double clicking their content or when hitting <code>Escape</code>.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:1103:18}<br>
	 * Original signature:<br>
	 * {@code stablePeek?: boolean; }<br>
	 */
	public IGlobalEditorOptions stablePeek(@Nonnull Boolean value) {
		set("stablePeek", value);
		return this;
	}

 	/**
	 * <p>The number of spaces a tab is equal to.
	 * This setting is overridden based on the file contents when <code>detectIndentation</code> is on.
	 * Defaults to 4.</p>
	 * See {@code monaco.d.ts:1072:15}<br>
	 * Original signature:<br>
	 * {@code tabSize?: number; }<br>
	 */
	public double tabSize() { return get("tabSize", ofMapped(double.class)); }

 	/**
	 * <p>The number of spaces a tab is equal to.
	 * This setting is overridden based on the file contents when <code>detectIndentation</code> is on.
	 * Defaults to 4.</p>
	 * See {@code monaco.d.ts:1072:15}<br>
	 * Original signature:<br>
	 * {@code tabSize?: number; }<br>
	 */
	public IGlobalEditorOptions tabSize(@Nonnull Double value) {
		set("tabSize", value);
		return this;
	}

 	/**
	 * <p>Remove trailing auto inserted whitespace.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:1088:26}<br>
	 * Original signature:<br>
	 * {@code trimAutoWhitespace?: boolean; }<br>
	 */
	public boolean trimAutoWhitespace() { return get("trimAutoWhitespace", ofMapped(boolean.class)); }

 	/**
	 * <p>Remove trailing auto inserted whitespace.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:1088:26}<br>
	 * Original signature:<br>
	 * {@code trimAutoWhitespace?: boolean; }<br>
	 */
	public IGlobalEditorOptions trimAutoWhitespace(@Nonnull Boolean value) {
		set("trimAutoWhitespace", value);
		return this;
	}

 	/**
	 * <p>Controls whether completions should be computed based on words in the document.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:1098:28}<br>
	 * Original signature:<br>
	 * {@code wordBasedSuggestions?: boolean; }<br>
	 */
	public boolean wordBasedSuggestions() { return get("wordBasedSuggestions", ofMapped(boolean.class)); }

 	/**
	 * <p>Controls whether completions should be computed based on words in the document.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:1098:28}<br>
	 * Original signature:<br>
	 * {@code wordBasedSuggestions?: boolean; }<br>
	 */
	public IGlobalEditorOptions wordBasedSuggestions(@Nonnull Boolean value) {
		set("wordBasedSuggestions", value);
		return this;
	}

 
}
