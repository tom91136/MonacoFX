
package monaco_editor.monaco;

import net.kurobako.monacofx.js.JsEnum;

/**
 * See {@code monaco.d.ts:42:25}<br>
 * Original signature:<br>
 * {@code export enum MarkerTag  }<br>
 */
@SuppressWarnings("unused")
public enum MarkerTag implements JsEnum<Integer> {
	/**
	 * See {@code monaco.d.ts:44:18}<br>
	 * Original signature:<br>
	 * {@code Deprecated = 2 }<br>
	 */
	Deprecated(2),
	/**
	 * See {@code monaco.d.ts:43:19}<br>
	 * Original signature:<br>
	 * {@code Unnecessary = 1, }<br>
	 */
	Unnecessary(1);
	private final int value;
	MarkerTag(int value) { this.value = value; }
	public Integer value() { return value; }
}
