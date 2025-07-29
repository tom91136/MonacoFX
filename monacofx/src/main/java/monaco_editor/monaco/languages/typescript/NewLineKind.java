
package monaco_editor.monaco.languages.typescript;

import net.kurobako.monacofx.js.JsEnum;

/**
 * See {@code monaco.d.ts:6208:20}<br>
 * Original signature:<br>
 * {@code enum NewLineKind  }<br>
 */
@SuppressWarnings("unused")
public enum NewLineKind implements JsEnum<Integer> {
	/**
	 * See {@code monaco.d.ts:6209:30}<br>
	 * Original signature:<br>
	 * {@code CarriageReturnLineFeed = 0, }<br>
	 */
	CarriageReturnLineFeed(0),
	/**
	 * See {@code monaco.d.ts:6210:16}<br>
	 * Original signature:<br>
	 * {@code LineFeed = 1 }<br>
	 */
	LineFeed(1);
	private final int value;
	NewLineKind(int value) { this.value = value; }
	public Integer value() { return value; }
}
