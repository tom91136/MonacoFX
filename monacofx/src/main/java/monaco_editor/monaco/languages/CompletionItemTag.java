
package monaco_editor.monaco.languages;

import net.kurobako.monacofx.js.JsEnum;

/**
 * See {@code monaco.d.ts:5222:33}<br>
 * Original signature:<br>
 * {@code export enum CompletionItemTag  }<br>
 */
@SuppressWarnings("unused")
public enum CompletionItemTag implements JsEnum<Integer> {
	/**
	 * See {@code monaco.d.ts:5223:18}<br>
	 * Original signature:<br>
	 * {@code Deprecated = 1 }<br>
	 */
	Deprecated(1);
	private final int value;
	CompletionItemTag(int value) { this.value = value; }
	public Integer value() { return value; }
}
