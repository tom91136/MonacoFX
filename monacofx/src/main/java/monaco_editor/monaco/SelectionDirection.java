
package monaco_editor.monaco;

import net.kurobako.monacofx.js.JsEnum;

/**
 * <p>The direction of a selection.</p>
 * See {@code monaco.d.ts:795:34}<br>
 * Original signature:<br>
 * {@code export enum SelectionDirection  }<br>
 */
@SuppressWarnings("unused")
public enum SelectionDirection implements JsEnum<Integer> {
	/**
	 * <p>The selection starts above where it ends.</p>
	 * See {@code monaco.d.ts:799:11}<br>
	 * Original signature:<br>
	 * {@code LTR = 0, }<br>
	 */
	LTR(0),
	/**
	 * <p>The selection starts below where it ends.</p>
	 * See {@code monaco.d.ts:803:11}<br>
	 * Original signature:<br>
	 * {@code RTL = 1 }<br>
	 */
	RTL(1);
	private final int value;
	SelectionDirection(int value) { this.value = value; }
	public Integer value() { return value; }
}
