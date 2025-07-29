
package monaco_editor.monaco.editor;

import net.kurobako.monacofx.js.JsEnum;

/**
 * <p>Position in the minimap to render the decoration.</p>
 * See {@code monaco.d.ts:1267:31}<br>
 * Original signature:<br>
 * {@code export enum MinimapPosition  }<br>
 */
@SuppressWarnings("unused")
public enum MinimapPosition implements JsEnum<Integer> {
	/**
	 * See {@code monaco.d.ts:1269:14}<br>
	 * Original signature:<br>
	 * {@code Gutter = 2 }<br>
	 */
	Gutter(2),
	/**
	 * See {@code monaco.d.ts:1268:14}<br>
	 * Original signature:<br>
	 * {@code Inline = 1, }<br>
	 */
	Inline(1);
	private final int value;
	MinimapPosition(int value) { this.value = value; }
	public Integer value() { return value; }
}
