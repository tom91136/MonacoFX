
package monaco_editor.monaco.languages;

import net.kurobako.monacofx.js.JsEnum;

/**
 * <p>Describes what to do with the indentation when pressing Enter.</p>
 * See {@code monaco.d.ts:5087:28}<br>
 * Original signature:<br>
 * {@code export enum IndentAction  }<br>
 */
@SuppressWarnings("unused")
public enum IndentAction implements JsEnum<Integer> {
	/**
	 * <p>Insert new line and indent once (relative to the previous line's indentation).</p>
	 * See {@code monaco.d.ts:5095:14}<br>
	 * Original signature:<br>
	 * {@code Indent = 1, }<br>
	 */
	Indent(1),
	/**
	 * <p>Insert two new lines:</p>
	 * <ul>
	 * <li>the first one indented which will hold the cursor</li>
	 * <li>the second one at the same indentation level</li>
	 * </ul>
	 * See {@code monaco.d.ts:5101:21}<br>
	 * Original signature:<br>
	 * {@code IndentOutdent = 2, }<br>
	 */
	IndentOutdent(2),
	/**
	 * <p>Insert new line and copy the previous line's indentation.</p>
	 * See {@code monaco.d.ts:5091:12}<br>
	 * Original signature:<br>
	 * {@code None = 0, }<br>
	 */
	None(0),
	/**
	 * <p>Insert new line and outdent once (relative to the previous line's indentation).</p>
	 * See {@code monaco.d.ts:5105:15}<br>
	 * Original signature:<br>
	 * {@code Outdent = 3 }<br>
	 */
	Outdent(3);
	private final int value;
	IndentAction(int value) { this.value = value; }
	public Integer value() { return value; }
}
