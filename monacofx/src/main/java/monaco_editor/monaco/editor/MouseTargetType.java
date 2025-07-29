
package monaco_editor.monaco.editor;

import net.kurobako.monacofx.js.JsEnum;

/**
 * <p>Type of hit element with the mouse in the editor.</p>
 * See {@code monaco.d.ts:4090:31}<br>
 * Original signature:<br>
 * {@code export enum MouseTargetType  }<br>
 */
@SuppressWarnings("unused")
public enum MouseTargetType implements JsEnum<Integer> {
	/**
	 * <p>Mouse is on top of empty space in the content (e.g. after line text or below last line)</p>
	 * See {@code monaco.d.ts:4122:21}<br>
	 * Original signature:<br>
	 * {@code CONTENT_EMPTY = 7, }<br>
	 */
	CONTENT_EMPTY(7),
	/**
	 * <p>Mouse is on top of text in the content.</p>
	 * See {@code monaco.d.ts:4118:20}<br>
	 * Original signature:<br>
	 * {@code CONTENT_TEXT = 6, }<br>
	 */
	CONTENT_TEXT(6),
	/**
	 * <p>Mouse is on top of a view zone in the content.</p>
	 * See {@code monaco.d.ts:4126:25}<br>
	 * Original signature:<br>
	 * {@code CONTENT_VIEW_ZONE = 8, }<br>
	 */
	CONTENT_VIEW_ZONE(8),
	/**
	 * <p>Mouse is on top of a content widget.</p>
	 * See {@code monaco.d.ts:4130:22}<br>
	 * Original signature:<br>
	 * {@code CONTENT_WIDGET = 9, }<br>
	 */
	CONTENT_WIDGET(9),
	/**
	 * <p>Mouse is on top of the glyph margin</p>
	 * See {@code monaco.d.ts:4102:27}<br>
	 * Original signature:<br>
	 * {@code GUTTER_GLYPH_MARGIN = 2, }<br>
	 */
	GUTTER_GLYPH_MARGIN(2),
	/**
	 * <p>Mouse is on top of the line decorations</p>
	 * See {@code monaco.d.ts:4110:31}<br>
	 * Original signature:<br>
	 * {@code GUTTER_LINE_DECORATIONS = 4, }<br>
	 */
	GUTTER_LINE_DECORATIONS(4),
	/**
	 * <p>Mouse is on top of the line numbers</p>
	 * See {@code monaco.d.ts:4106:27}<br>
	 * Original signature:<br>
	 * {@code GUTTER_LINE_NUMBERS = 3, }<br>
	 */
	GUTTER_LINE_NUMBERS(3),
	/**
	 * <p>Mouse is on top of the whitespace left in the gutter by a view zone.</p>
	 * See {@code monaco.d.ts:4114:24}<br>
	 * Original signature:<br>
	 * {@code GUTTER_VIEW_ZONE = 5, }<br>
	 */
	GUTTER_VIEW_ZONE(5),
	/**
	 * <p>Mouse is outside of the editor.</p>
	 * See {@code monaco.d.ts:4146:22}<br>
	 * Original signature:<br>
	 * {@code OUTSIDE_EDITOR = 13 }<br>
	 */
	OUTSIDE_EDITOR(13),
	/**
	 * <p>Mouse is on top of an overlay widget.</p>
	 * See {@code monaco.d.ts:4142:22}<br>
	 * Original signature:<br>
	 * {@code OVERLAY_WIDGET = 12, }<br>
	 */
	OVERLAY_WIDGET(12),
	/**
	 * <p>Mouse is on top of the decorations overview ruler.</p>
	 * See {@code monaco.d.ts:4134:22}<br>
	 * Original signature:<br>
	 * {@code OVERVIEW_RULER = 10, }<br>
	 */
	OVERVIEW_RULER(10),
	/**
	 * <p>Mouse is on top of a scrollbar.</p>
	 * See {@code monaco.d.ts:4138:17}<br>
	 * Original signature:<br>
	 * {@code SCROLLBAR = 11, }<br>
	 */
	SCROLLBAR(11),
	/**
	 * <p>Mouse is on top of the textarea used for input.</p>
	 * See {@code monaco.d.ts:4098:16}<br>
	 * Original signature:<br>
	 * {@code TEXTAREA = 1, }<br>
	 */
	TEXTAREA(1),
	/**
	 * <p>Mouse is on top of an unknown element.</p>
	 * See {@code monaco.d.ts:4094:15}<br>
	 * Original signature:<br>
	 * {@code UNKNOWN = 0, }<br>
	 */
	UNKNOWN(0);
	private final int value;
	MouseTargetType(int value) { this.value = value; }
	public Integer value() { return value; }
}
