
package monaco_editor.monaco.languages;

import net.kurobako.monacofx.js.JsEnum;

/**
 * <p>How a suggest provider was triggered.</p>
 * See {@code monaco.d.ts:5337:37}<br>
 * Original signature:<br>
 * {@code export enum CompletionTriggerKind  }<br>
 */
@SuppressWarnings("unused")
public enum CompletionTriggerKind implements JsEnum<Integer> {
	/**
	 * See {@code monaco.d.ts:5338:14}<br>
	 * Original signature:<br>
	 * {@code Invoke = 0, }<br>
	 */
	Invoke(0),
	/**
	 * See {@code monaco.d.ts:5339:24}<br>
	 * Original signature:<br>
	 * {@code TriggerCharacter = 1, }<br>
	 */
	TriggerCharacter(1),
	/**
	 * See {@code monaco.d.ts:5340:39}<br>
	 * Original signature:<br>
	 * {@code TriggerForIncompleteCompletions = 2 }<br>
	 */
	TriggerForIncompleteCompletions(2);
	private final int value;
	CompletionTriggerKind(int value) { this.value = value; }
	public Integer value() { return value; }
}
