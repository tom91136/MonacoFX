
package monaco_editor.monaco.languages;

import net.kurobako.monacofx.js.JsEnum;

/**
 * See {@code monaco.d.ts:5672:25}<br>
 * Original signature:<br>
 * {@code export enum SymbolTag  }<br>
 */
@SuppressWarnings("unused")
public enum SymbolTag implements JsEnum<Integer> {
	/**
	 * See {@code monaco.d.ts:5673:18}<br>
	 * Original signature:<br>
	 * {@code Deprecated = 1 }<br>
	 */
	Deprecated(1);
	private final int value;
	SymbolTag(int value) { this.value = value; }
	public Integer value() { return value; }
}
