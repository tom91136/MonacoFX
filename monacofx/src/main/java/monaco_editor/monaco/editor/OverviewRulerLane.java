
package monaco_editor.monaco.editor;

import net.kurobako.monacofx.js.JsEnum;

/**
 * <p>Vertical Lane in the overview ruler of the editor.</p>
 * See {@code monaco.d.ts:1257:33}<br>
 * Original signature:<br>
 * {@code export enum OverviewRulerLane  }<br>
 */
@SuppressWarnings("unused")
public enum OverviewRulerLane implements JsEnum<Integer> {
	/**
	 * See {@code monaco.d.ts:1259:14}<br>
	 * Original signature:<br>
	 * {@code Center = 2, }<br>
	 */
	Center(2),
	/**
	 * See {@code monaco.d.ts:1261:12}<br>
	 * Original signature:<br>
	 * {@code Full = 7 }<br>
	 */
	Full(7),
	/**
	 * See {@code monaco.d.ts:1258:12}<br>
	 * Original signature:<br>
	 * {@code Left = 1, }<br>
	 */
	Left(1),
	/**
	 * See {@code monaco.d.ts:1260:13}<br>
	 * Original signature:<br>
	 * {@code Right = 4, }<br>
	 */
	Right(4);
	private final int value;
	OverviewRulerLane(int value) { this.value = value; }
	public Integer value() { return value; }
}
