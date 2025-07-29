
package monaco_editor.monaco;

import net.kurobako.monacofx.js.JsEnum;

/**
 * See {@code monaco.d.ts:47:30}<br>
 * Original signature:<br>
 * {@code export enum MarkerSeverity  }<br>
 */
@SuppressWarnings("unused")
public enum MarkerSeverity implements JsEnum<Integer> {
	/**
	 * See {@code monaco.d.ts:51:13}<br>
	 * Original signature:<br>
	 * {@code Error = 8 }<br>
	 */
	Error(8),
	/**
	 * See {@code monaco.d.ts:48:12}<br>
	 * Original signature:<br>
	 * {@code Hint = 1, }<br>
	 */
	Hint(1),
	/**
	 * See {@code monaco.d.ts:49:12}<br>
	 * Original signature:<br>
	 * {@code Info = 2, }<br>
	 */
	Info(2),
	/**
	 * See {@code monaco.d.ts:50:15}<br>
	 * Original signature:<br>
	 * {@code Warning = 4, }<br>
	 */
	Warning(4);
	private final int value;
	MarkerSeverity(int value) { this.value = value; }
	public Integer value() { return value; }
}
