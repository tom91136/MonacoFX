
package monaco_editor.monaco.editor;

import net.kurobako.monacofx.js.JsEnum;

/**
 * <p>The style in which the editor's cursor should be rendered.</p>
 * See {@code monaco.d.ts:3129:37}<br>
 * Original signature:<br>
 * {@code export enum TextEditorCursorStyle  }<br>
 */
@SuppressWarnings("unused")
public enum TextEditorCursorStyle implements JsEnum<Integer> {
	/**
	 * <p>As a block (sitting on top of a character).</p>
	 * See {@code monaco.d.ts:3137:13}<br>
	 * Original signature:<br>
	 * {@code Block = 2, }<br>
	 */
	Block(2),
	/**
	 * <p>As an outlined block (sitting on top of a character).</p>
	 * See {@code monaco.d.ts:3149:20}<br>
	 * Original signature:<br>
	 * {@code BlockOutline = 5, }<br>
	 */
	BlockOutline(5),
	/**
	 * <p>As a vertical line (sitting between two characters).</p>
	 * See {@code monaco.d.ts:3133:12}<br>
	 * Original signature:<br>
	 * {@code Line = 1, }<br>
	 */
	Line(1),
	/**
	 * <p>As a thin vertical line (sitting between two characters).</p>
	 * See {@code monaco.d.ts:3145:16}<br>
	 * Original signature:<br>
	 * {@code LineThin = 4, }<br>
	 */
	LineThin(4),
	/**
	 * <p>As a horizontal line (sitting under a character).</p>
	 * See {@code monaco.d.ts:3141:17}<br>
	 * Original signature:<br>
	 * {@code Underline = 3, }<br>
	 */
	Underline(3),
	/**
	 * <p>As a thin horizontal line (sitting under a character).</p>
	 * See {@code monaco.d.ts:3153:21}<br>
	 * Original signature:<br>
	 * {@code UnderlineThin = 6 }<br>
	 */
	UnderlineThin(6);
	private final int value;
	TextEditorCursorStyle(int value) { this.value = value; }
	public Integer value() { return value; }
}
