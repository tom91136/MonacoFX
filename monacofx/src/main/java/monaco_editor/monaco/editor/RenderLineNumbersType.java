
package monaco_editor.monaco.editor;

import net.kurobako.monacofx.js.JsEnum;

/**
 * See {@code monaco.d.ts:3400:37}<br>
 * Original signature:<br>
 * {@code export enum RenderLineNumbersType  }<br>
 */
@SuppressWarnings("unused")
public enum RenderLineNumbersType implements JsEnum<Integer> {
	/**
	 * See {@code monaco.d.ts:3405:14}<br>
	 * Original signature:<br>
	 * {@code Custom = 4 }<br>
	 */
	Custom(4),
	/**
	 * See {@code monaco.d.ts:3404:16}<br>
	 * Original signature:<br>
	 * {@code Interval = 3, }<br>
	 */
	Interval(3),
	/**
	 * See {@code monaco.d.ts:3401:11}<br>
	 * Original signature:<br>
	 * {@code Off = 0, }<br>
	 */
	Off(0),
	/**
	 * See {@code monaco.d.ts:3402:10}<br>
	 * Original signature:<br>
	 * {@code On = 1, }<br>
	 */
	On(1),
	/**
	 * See {@code monaco.d.ts:3403:16}<br>
	 * Original signature:<br>
	 * {@code Relative = 2, }<br>
	 */
	Relative(2);
	private final int value;
	RenderLineNumbersType(int value) { this.value = value; }
	public Integer value() { return value; }
}
