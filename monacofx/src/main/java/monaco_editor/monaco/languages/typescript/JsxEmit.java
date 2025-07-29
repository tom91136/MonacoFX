
package monaco_editor.monaco.languages.typescript;

import net.kurobako.monacofx.js.JsEnum;

/**
 * See {@code monaco.d.ts:6202:16}<br>
 * Original signature:<br>
 * {@code enum JsxEmit  }<br>
 */
@SuppressWarnings("unused")
public enum JsxEmit implements JsEnum<Integer> {
	/**
	 * See {@code monaco.d.ts:6203:12}<br>
	 * Original signature:<br>
	 * {@code None = 0, }<br>
	 */
	None(0),
	/**
	 * See {@code monaco.d.ts:6204:16}<br>
	 * Original signature:<br>
	 * {@code Preserve = 1, }<br>
	 */
	Preserve(1),
	/**
	 * See {@code monaco.d.ts:6205:13}<br>
	 * Original signature:<br>
	 * {@code React = 2, }<br>
	 */
	React(2),
	/**
	 * See {@code monaco.d.ts:6206:19}<br>
	 * Original signature:<br>
	 * {@code ReactNative = 3 }<br>
	 */
	ReactNative(3);
	private final int value;
	JsxEmit(int value) { this.value = value; }
	public Integer value() { return value; }
}
