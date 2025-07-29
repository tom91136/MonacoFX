
package monaco_editor.monaco.editor;

import net.kurobako.monacofx.js.JsEnum;

/**
 * <p>Describes the behavior of decorations when typing/editing near their edges.
 * Note: Please do not edit the values, as they very carefully match <code>DecorationRangeBehavior</code></p>
 * See {@code monaco.d.ts:1550:38}<br>
 * Original signature:<br>
 * {@code export enum TrackedRangeStickiness  }<br>
 */
@SuppressWarnings("unused")
public enum TrackedRangeStickiness implements JsEnum<Integer> {
	/**
	 * See {@code monaco.d.ts:1551:36}<br>
	 * Original signature:<br>
	 * {@code AlwaysGrowsWhenTypingAtEdges = 0, }<br>
	 */
	AlwaysGrowsWhenTypingAtEdges(0),
	/**
	 * See {@code monaco.d.ts:1554:32}<br>
	 * Original signature:<br>
	 * {@code GrowsOnlyWhenTypingAfter = 3 }<br>
	 */
	GrowsOnlyWhenTypingAfter(3),
	/**
	 * See {@code monaco.d.ts:1553:33}<br>
	 * Original signature:<br>
	 * {@code GrowsOnlyWhenTypingBefore = 2, }<br>
	 */
	GrowsOnlyWhenTypingBefore(2),
	/**
	 * See {@code monaco.d.ts:1552:35}<br>
	 * Original signature:<br>
	 * {@code NeverGrowsWhenTypingAtEdges = 1, }<br>
	 */
	NeverGrowsWhenTypingAtEdges(1);
	private final int value;
	TrackedRangeStickiness(int value) { this.value = value; }
	public Integer value() { return value; }
}
