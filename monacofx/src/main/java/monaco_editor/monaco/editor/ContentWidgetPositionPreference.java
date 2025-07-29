
package monaco_editor.monaco.editor;

import net.kurobako.monacofx.js.JsEnum;

/**
 * <p>A positioning preference for rendering content widgets.</p>
 * See {@code monaco.d.ts:3981:47}<br>
 * Original signature:<br>
 * {@code export enum ContentWidgetPositionPreference  }<br>
 */
@SuppressWarnings("unused")
public enum ContentWidgetPositionPreference implements JsEnum<Integer> {
	/**
	 * <p>Place the content widget above a position</p>
	 * See {@code monaco.d.ts:3989:13}<br>
	 * Original signature:<br>
	 * {@code ABOVE = 1, }<br>
	 */
	ABOVE(1),
	/**
	 * <p>Place the content widget below a position</p>
	 * See {@code monaco.d.ts:3993:13}<br>
	 * Original signature:<br>
	 * {@code BELOW = 2 }<br>
	 */
	BELOW(2),
	/**
	 * <p>Place the content widget exactly at a position</p>
	 * See {@code monaco.d.ts:3985:13}<br>
	 * Original signature:<br>
	 * {@code EXACT = 0, }<br>
	 */
	EXACT(0);
	private final int value;
	ContentWidgetPositionPreference(int value) { this.value = value; }
	public Integer value() { return value; }
}
