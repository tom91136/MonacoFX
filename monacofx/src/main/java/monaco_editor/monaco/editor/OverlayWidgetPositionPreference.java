
package monaco_editor.monaco.editor;

import net.kurobako.monacofx.js.JsEnum;

/**
 * <p>A positioning preference for rendering overlay widgets.</p>
 * See {@code monaco.d.ts:4043:47}<br>
 * Original signature:<br>
 * {@code export enum OverlayWidgetPositionPreference  }<br>
 */
@SuppressWarnings("unused")
public enum OverlayWidgetPositionPreference implements JsEnum<Integer> {
	/**
	 * <p>Position the overlay widget in the bottom right corner</p>
	 * See {@code monaco.d.ts:4051:27}<br>
	 * Original signature:<br>
	 * {@code BOTTOM_RIGHT_CORNER = 1, }<br>
	 */
	BOTTOM_RIGHT_CORNER(1),
	/**
	 * <p>Position the overlay widget in the top center</p>
	 * See {@code monaco.d.ts:4055:18}<br>
	 * Original signature:<br>
	 * {@code TOP_CENTER = 2 }<br>
	 */
	TOP_CENTER(2),
	/**
	 * <p>Position the overlay widget in the top right corner</p>
	 * See {@code monaco.d.ts:4047:24}<br>
	 * Original signature:<br>
	 * {@code TOP_RIGHT_CORNER = 0, }<br>
	 */
	TOP_RIGHT_CORNER(0);
	private final int value;
	OverlayWidgetPositionPreference(int value) { this.value = value; }
	public Integer value() { return value; }
}
