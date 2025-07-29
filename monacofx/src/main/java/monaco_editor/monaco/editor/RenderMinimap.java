
package monaco_editor.monaco.editor;

import net.kurobako.monacofx.js.JsEnum;

/**
 * See {@code monaco.d.ts:3239:29}<br>
 * Original signature:<br>
 * {@code export enum RenderMinimap  }<br>
 */
@SuppressWarnings("unused")
public enum RenderMinimap implements JsEnum<Integer> {
	/**
	 * See {@code monaco.d.ts:3242:14}<br>
	 * Original signature:<br>
	 * {@code Blocks = 2 }<br>
	 */
	Blocks(2),
	/**
	 * See {@code monaco.d.ts:3240:12}<br>
	 * Original signature:<br>
	 * {@code None = 0, }<br>
	 */
	None(0),
	/**
	 * See {@code monaco.d.ts:3241:12}<br>
	 * Original signature:<br>
	 * {@code Text = 1, }<br>
	 */
	Text(1);
	private final int value;
	RenderMinimap(int value) { this.value = value; }
	public Integer value() { return value; }
}
