
package monaco_editor.monaco.languages;

import net.kurobako.monacofx.js.JsEnum;

/**
 * See {@code monaco.d.ts:5463:40}<br>
 * Original signature:<br>
 * {@code export enum SignatureHelpTriggerKind  }<br>
 */
@SuppressWarnings("unused")
public enum SignatureHelpTriggerKind implements JsEnum<Integer> {
	/**
	 * See {@code monaco.d.ts:5466:21}<br>
	 * Original signature:<br>
	 * {@code ContentChange = 3 }<br>
	 */
	ContentChange(3),
	/**
	 * See {@code monaco.d.ts:5464:14}<br>
	 * Original signature:<br>
	 * {@code Invoke = 1, }<br>
	 */
	Invoke(1),
	/**
	 * See {@code monaco.d.ts:5465:24}<br>
	 * Original signature:<br>
	 * {@code TriggerCharacter = 2, }<br>
	 */
	TriggerCharacter(2);
	private final int value;
	SignatureHelpTriggerKind(int value) { this.value = value; }
	public Integer value() { return value; }
}
