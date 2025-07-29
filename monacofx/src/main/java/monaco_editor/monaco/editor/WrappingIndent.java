
package monaco_editor.monaco.editor;

import net.kurobako.monacofx.js.JsEnum;

/**
 * <p>Describes how to indent wrapped lines.</p>
 * See {@code monaco.d.ts:3641:30}<br>
 * Original signature:<br>
 * {@code export enum WrappingIndent  }<br>
 */
@SuppressWarnings("unused")
public enum WrappingIndent implements JsEnum<Integer> {
	/**
	 * <p>DeepIndent =&gt; wrapped lines get +2 indentation toward the parent.</p>
	 * See {@code monaco.d.ts:3657:18}<br>
	 * Original signature:<br>
	 * {@code DeepIndent = 3 }<br>
	 */
	DeepIndent(3),
	/**
	 * <p>Indent =&gt; wrapped lines get +1 indentation toward the parent.</p>
	 * See {@code monaco.d.ts:3653:14}<br>
	 * Original signature:<br>
	 * {@code Indent = 2, }<br>
	 */
	Indent(2),
	/**
	 * <p>No indentation =&gt; wrapped lines begin at column 1.</p>
	 * See {@code monaco.d.ts:3645:12}<br>
	 * Original signature:<br>
	 * {@code None = 0, }<br>
	 */
	None(0),
	/**
	 * <p>Same =&gt; wrapped lines get the same indentation as the parent.</p>
	 * See {@code monaco.d.ts:3649:12}<br>
	 * Original signature:<br>
	 * {@code Same = 1, }<br>
	 */
	Same(1);
	private final int value;
	WrappingIndent(int value) { this.value = value; }
	public Integer value() { return value; }
}
