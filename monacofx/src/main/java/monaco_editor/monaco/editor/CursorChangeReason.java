
package monaco_editor.monaco.editor;

import net.kurobako.monacofx.js.JsEnum;

/**
 * <p>Describes the reason the cursor has changed its position.</p>
 * See {@code monaco.d.ts:2383:34}<br>
 * Original signature:<br>
 * {@code export enum CursorChangeReason  }<br>
 */
@SuppressWarnings("unused")
public enum CursorChangeReason implements JsEnum<Integer> {
	/**
	 * <p>A <code>model.setValue()</code> was called.</p>
	 * See {@code monaco.d.ts:2391:20}<br>
	 * Original signature:<br>
	 * {@code ContentFlush = 1, }<br>
	 */
	ContentFlush(1),
	/**
	 * <p>There was an explicit user gesture.</p>
	 * See {@code monaco.d.ts:2399:16}<br>
	 * Original signature:<br>
	 * {@code Explicit = 3, }<br>
	 */
	Explicit(3),
	/**
	 * <p>Unknown or not set.</p>
	 * See {@code monaco.d.ts:2387:14}<br>
	 * Original signature:<br>
	 * {@code NotSet = 0, }<br>
	 */
	NotSet(0),
	/**
	 * <p>There was a Paste.</p>
	 * See {@code monaco.d.ts:2403:13}<br>
	 * Original signature:<br>
	 * {@code Paste = 4, }<br>
	 */
	Paste(4),
	/**
	 * <p>The <code>model</code> has been changed outside of this cursor and the cursor recovers its position from associated markers.</p>
	 * See {@code monaco.d.ts:2395:26}<br>
	 * Original signature:<br>
	 * {@code RecoverFromMarkers = 2, }<br>
	 */
	RecoverFromMarkers(2),
	/**
	 * <p>There was a Redo.</p>
	 * See {@code monaco.d.ts:2411:12}<br>
	 * Original signature:<br>
	 * {@code Redo = 6 }<br>
	 */
	Redo(6),
	/**
	 * <p>There was an Undo.</p>
	 * See {@code monaco.d.ts:2407:12}<br>
	 * Original signature:<br>
	 * {@code Undo = 5, }<br>
	 */
	Undo(5);
	private final int value;
	CursorChangeReason(int value) { this.value = value; }
	public Integer value() { return value; }
}
