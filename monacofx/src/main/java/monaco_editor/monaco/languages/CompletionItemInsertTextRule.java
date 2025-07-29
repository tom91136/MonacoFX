
package monaco_editor.monaco.languages;

import net.kurobako.monacofx.js.JsEnum;

/**
 * See {@code monaco.d.ts:5226:44}<br>
 * Original signature:<br>
 * {@code export enum CompletionItemInsertTextRule  }<br>
 */
@SuppressWarnings("unused")
public enum CompletionItemInsertTextRule implements JsEnum<Integer> {
	/**
	 * <p><code>insertText</code> is a snippet.</p>
	 * See {@code monaco.d.ts:5235:23}<br>
	 * Original signature:<br>
	 * {@code InsertAsSnippet = 4 }<br>
	 */
	InsertAsSnippet(4),
	/**
	 * <p>Adjust whitespace/indentation of multiline insert texts to
	 * match the current line indentation.</p>
	 * See {@code monaco.d.ts:5231:22}<br>
	 * Original signature:<br>
	 * {@code KeepWhitespace = 1, }<br>
	 */
	KeepWhitespace(1);
	private final int value;
	CompletionItemInsertTextRule(int value) { this.value = value; }
	public Integer value() { return value; }
}
