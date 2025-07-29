
package monaco_editor.monaco.languages;

import net.kurobako.monacofx.js.JsEnum;

/**
 * <p>A document highlight kind.</p>
 * See {@code monaco.d.ts:5492:37}<br>
 * Original signature:<br>
 * {@code export enum DocumentHighlightKind  }<br>
 */
@SuppressWarnings("unused")
public enum DocumentHighlightKind implements JsEnum<Integer> {
	/**
	 * <p>Read-access of a symbol, like reading a variable.</p>
	 * See {@code monaco.d.ts:5500:12}<br>
	 * Original signature:<br>
	 * {@code Read = 1, }<br>
	 */
	Read(1),
	/**
	 * <p>A textual occurrence.</p>
	 * See {@code monaco.d.ts:5496:12}<br>
	 * Original signature:<br>
	 * {@code Text = 0, }<br>
	 */
	Text(0),
	/**
	 * <p>Write-access of a symbol, like writing to a variable.</p>
	 * See {@code monaco.d.ts:5504:13}<br>
	 * Original signature:<br>
	 * {@code Write = 2 }<br>
	 */
	Write(2);
	private final int value;
	DocumentHighlightKind(int value) { this.value = value; }
	public Integer value() { return value; }
}
