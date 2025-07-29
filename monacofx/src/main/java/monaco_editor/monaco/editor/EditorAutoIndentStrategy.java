
package monaco_editor.monaco.editor;

import net.kurobako.monacofx.js.JsEnum;

/**
 * <p>Configuration options for auto indentation in the editor</p>
 * See {@code monaco.d.ts:2497:40}<br>
 * Original signature:<br>
 * {@code export enum EditorAutoIndentStrategy  }<br>
 */
@SuppressWarnings("unused")
public enum EditorAutoIndentStrategy implements JsEnum<Integer> {
	/**
	 * See {@code monaco.d.ts:2501:16}<br>
	 * Original signature:<br>
	 * {@code Advanced = 3, }<br>
	 */
	Advanced(3),
	/**
	 * See {@code monaco.d.ts:2500:16}<br>
	 * Original signature:<br>
	 * {@code Brackets = 2, }<br>
	 */
	Brackets(2),
	/**
	 * See {@code monaco.d.ts:2502:12}<br>
	 * Original signature:<br>
	 * {@code Full = 4 }<br>
	 */
	Full(4),
	/**
	 * See {@code monaco.d.ts:2499:12}<br>
	 * Original signature:<br>
	 * {@code Keep = 1, }<br>
	 */
	Keep(1),
	/**
	 * See {@code monaco.d.ts:2498:12}<br>
	 * Original signature:<br>
	 * {@code None = 0, }<br>
	 */
	None(0);
	private final int value;
	EditorAutoIndentStrategy(int value) { this.value = value; }
	public Integer value() { return value; }
}
