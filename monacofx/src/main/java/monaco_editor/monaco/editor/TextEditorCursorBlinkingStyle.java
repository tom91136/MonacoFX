
package monaco_editor.monaco.editor;

import net.kurobako.monacofx.js.JsEnum;

/**
 * <p>The kind of animation in which the editor's cursor should be rendered.</p>
 * See {@code monaco.d.ts:3099:45}<br>
 * Original signature:<br>
 * {@code export enum TextEditorCursorBlinkingStyle  }<br>
 */
@SuppressWarnings("unused")
public enum TextEditorCursorBlinkingStyle implements JsEnum<Integer> {
	/**
	 * <p>Blinking</p>
	 * See {@code monaco.d.ts:3107:13}<br>
	 * Original signature:<br>
	 * {@code Blink = 1, }<br>
	 */
	Blink(1),
	/**
	 * <p>Expand collapse animation on the y axis</p>
	 * See {@code monaco.d.ts:3119:14}<br>
	 * Original signature:<br>
	 * {@code Expand = 4, }<br>
	 */
	Expand(4),
	/**
	 * <p>Hidden</p>
	 * See {@code monaco.d.ts:3103:14}<br>
	 * Original signature:<br>
	 * {@code Hidden = 0, }<br>
	 */
	Hidden(0),
	/**
	 * <p>Blinking with prolonged filled state and smooth fading</p>
	 * See {@code monaco.d.ts:3115:13}<br>
	 * Original signature:<br>
	 * {@code Phase = 3, }<br>
	 */
	Phase(3),
	/**
	 * <p>Blinking with smooth fading</p>
	 * See {@code monaco.d.ts:3111:14}<br>
	 * Original signature:<br>
	 * {@code Smooth = 2, }<br>
	 */
	Smooth(2),
	/**
	 * <p>No-Blinking</p>
	 * See {@code monaco.d.ts:3123:13}<br>
	 * Original signature:<br>
	 * {@code Solid = 5 }<br>
	 */
	Solid(5);
	private final int value;
	TextEditorCursorBlinkingStyle(int value) { this.value = value; }
	public Integer value() { return value; }
}
