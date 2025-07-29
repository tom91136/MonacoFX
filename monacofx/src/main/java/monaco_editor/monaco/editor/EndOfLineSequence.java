
package monaco_editor.monaco.editor;

import net.kurobako.monacofx.js.JsEnum;

/**
 * <p>End of line character preference.</p>
 * See {@code monaco.d.ts:1464:33}<br>
 * Original signature:<br>
 * {@code export enum EndOfLineSequence  }<br>
 */
@SuppressWarnings("unused")
public enum EndOfLineSequence implements JsEnum<Integer> {
	/**
	 * <p>Use carriage return and line feed (\r\n) as the end of line character.</p>
	 * See {@code monaco.d.ts:1472:12}<br>
	 * Original signature:<br>
	 * {@code CRLF = 1 }<br>
	 */
	CRLF(1),
	/**
	 * <p>Use line feed (\n) as the end of line character.</p>
	 * See {@code monaco.d.ts:1468:10}<br>
	 * Original signature:<br>
	 * {@code LF = 0, }<br>
	 */
	LF(0);
	private final int value;
	EndOfLineSequence(int value) { this.value = value; }
	public Integer value() { return value; }
}
