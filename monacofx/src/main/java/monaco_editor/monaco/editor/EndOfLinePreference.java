
package monaco_editor.monaco.editor;

import net.kurobako.monacofx.js.JsEnum;

/**
 * <p>End of line character preference.</p>
 * See {@code monaco.d.ts:1432:35}<br>
 * Original signature:<br>
 * {@code export enum EndOfLinePreference  }<br>
 */
@SuppressWarnings("unused")
public enum EndOfLinePreference implements JsEnum<Integer> {
	/**
	 * <p>Use carriage return and line feed (\r\n) as the end of line character.</p>
	 * See {@code monaco.d.ts:1444:12}<br>
	 * Original signature:<br>
	 * {@code CRLF = 2 }<br>
	 */
	CRLF(2),
	/**
	 * <p>Use line feed (\n) as the end of line character.</p>
	 * See {@code monaco.d.ts:1440:10}<br>
	 * Original signature:<br>
	 * {@code LF = 1, }<br>
	 */
	LF(1),
	/**
	 * <p>Use the end of line character identified in the text buffer.</p>
	 * See {@code monaco.d.ts:1436:19}<br>
	 * Original signature:<br>
	 * {@code TextDefined = 0, }<br>
	 */
	TextDefined(0);
	private final int value;
	EndOfLinePreference(int value) { this.value = value; }
	public Integer value() { return value; }
}
