
package monaco_editor.monaco.editor;

import net.kurobako.monacofx.js.JsEnum;

/**
 * See {@code monaco.d.ts:2470:36}<br>
 * Original signature:<br>
 * {@code export enum AccessibilitySupport  }<br>
 */
@SuppressWarnings("unused")
public enum AccessibilitySupport implements JsEnum<Integer> {
	/**
	 * See {@code monaco.d.ts:2475:16}<br>
	 * Original signature:<br>
	 * {@code Disabled = 1, }<br>
	 */
	Disabled(1),
	/**
	 * See {@code monaco.d.ts:2476:15}<br>
	 * Original signature:<br>
	 * {@code Enabled = 2 }<br>
	 */
	Enabled(2),
	/**
	 * <p>This should be the browser case where it is not known if a screen reader is attached or no.</p>
	 * See {@code monaco.d.ts:2474:15}<br>
	 * Original signature:<br>
	 * {@code Unknown = 0, }<br>
	 */
	Unknown(0);
	private final int value;
	AccessibilitySupport(int value) { this.value = value; }
	public Integer value() { return value; }
}
