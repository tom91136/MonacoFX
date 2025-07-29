
package monaco_editor.monaco.editor;

import net.kurobako.monacofx.js.JsEnum;

/**
 * <p>The default end of line to use when instantiating models.</p>
 * See {@code monaco.d.ts:1450:32}<br>
 * Original signature:<br>
 * {@code export enum DefaultEndOfLine  }<br>
 */
@SuppressWarnings("unused")
public enum DefaultEndOfLine implements JsEnum<Integer> {
	/**
	 * <p>Use carriage return and line feed (\r\n) as the end of line character.</p>
	 * See {@code monaco.d.ts:1458:12}<br>
	 * Original signature:<br>
	 * {@code CRLF = 2 }<br>
	 */
	CRLF(2),
	/**
	 * <p>Use line feed (\n) as the end of line character.</p>
	 * See {@code monaco.d.ts:1454:10}<br>
	 * Original signature:<br>
	 * {@code LF = 1, }<br>
	 */
	LF(1);
	private final int value;
	DefaultEndOfLine(int value) { this.value = value; }
	public Integer value() { return value; }
}
