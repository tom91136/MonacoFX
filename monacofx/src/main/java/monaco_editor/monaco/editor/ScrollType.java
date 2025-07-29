
package monaco_editor.monaco.editor;

import net.kurobako.monacofx.js.JsEnum;

/**
 * See {@code monaco.d.ts:2096:26}<br>
 * Original signature:<br>
 * {@code export enum ScrollType  }<br>
 */
@SuppressWarnings("unused")
public enum ScrollType implements JsEnum<Integer> {
	/**
	 * See {@code monaco.d.ts:2098:17}<br>
	 * Original signature:<br>
	 * {@code Immediate = 1 }<br>
	 */
	Immediate(1),
	/**
	 * See {@code monaco.d.ts:2097:14}<br>
	 * Original signature:<br>
	 * {@code Smooth = 0, }<br>
	 */
	Smooth(0);
	private final int value;
	ScrollType(int value) { this.value = value; }
	public Integer value() { return value; }
}
