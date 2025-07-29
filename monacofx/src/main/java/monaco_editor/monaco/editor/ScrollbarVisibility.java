
package monaco_editor.monaco.editor;

import net.kurobako.monacofx.js.JsEnum;

/**
 * See {@code monaco.d.ts:1244:35}<br>
 * Original signature:<br>
 * {@code export enum ScrollbarVisibility  }<br>
 */
@SuppressWarnings("unused")
public enum ScrollbarVisibility implements JsEnum<Integer> {
	/**
	 * See {@code monaco.d.ts:1245:12}<br>
	 * Original signature:<br>
	 * {@code Auto = 1, }<br>
	 */
	Auto(1),
	/**
	 * See {@code monaco.d.ts:1246:14}<br>
	 * Original signature:<br>
	 * {@code Hidden = 2, }<br>
	 */
	Hidden(2),
	/**
	 * See {@code monaco.d.ts:1247:15}<br>
	 * Original signature:<br>
	 * {@code Visible = 3 }<br>
	 */
	Visible(3);
	private final int value;
	ScrollbarVisibility(int value) { this.value = value; }
	public Integer value() { return value; }
}
