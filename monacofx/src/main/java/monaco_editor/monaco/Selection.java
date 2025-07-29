
package monaco_editor.monaco;
import java.util.List;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import netscape.javascript.JSObject;

/**
 * <p>A selection in the editor.
 * The selection is a range that has an orientation.</p>
 * See {@code monaco.d.ts:724:26}<br>
 * Original signature:<br>
 * {@code export class Selection extends Range  }<br>
 */
@SuppressWarnings("unused")
public class Selection extends Range {

	public Selection(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public Selection(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Column on which the range ends in line <code>endLineNumber</code>.</p>
	 * See {@code monaco.d.ts:575:26}<br>
	 * Original signature:<br>
	 * {@code readonly endColumn: number; }<br>
	 */
	public double endColumn() { return get("endColumn", ofMapped(double.class)); }

 	/**
	 * <p>Line number on which the range ends.</p>
	 * See {@code monaco.d.ts:571:30}<br>
	 * Original signature:<br>
	 * {@code readonly endLineNumber: number; }<br>
	 */
	public double endLineNumber() { return get("endLineNumber", ofMapped(double.class)); }

 	/**
	 * <p>The column on <code>positionLineNumber</code> where the selection has ended.</p>
	 * See {@code monaco.d.ts:740:31}<br>
	 * Original signature:<br>
	 * {@code readonly positionColumn: number; }<br>
	 */
	public double positionColumn() { return get("positionColumn", ofMapped(double.class)); }

 	/**
	 * <p>The line number on which the selection has ended.</p>
	 * See {@code monaco.d.ts:736:35}<br>
	 * Original signature:<br>
	 * {@code readonly positionLineNumber: number; }<br>
	 */
	public double positionLineNumber() { return get("positionLineNumber", ofMapped(double.class)); }

 	/**
	 * <p>The column on <code>selectionStartLineNumber</code> where the selection has started.</p>
	 * See {@code monaco.d.ts:732:37}<br>
	 * Original signature:<br>
	 * {@code readonly selectionStartColumn: number; }<br>
	 */
	public double selectionStartColumn() { return get("selectionStartColumn", ofMapped(double.class)); }

 	/**
	 * <p>The line number on which the selection has started.</p>
	 * See {@code monaco.d.ts:728:41}<br>
	 * Original signature:<br>
	 * {@code readonly selectionStartLineNumber: number; }<br>
	 */
	public double selectionStartLineNumber() { return get("selectionStartLineNumber", ofMapped(double.class)); }

 	/**
	 * <p>Column on which the range starts in line <code>startLineNumber</code> (starts at 1).</p>
	 * See {@code monaco.d.ts:567:28}<br>
	 * Original signature:<br>
	 * {@code readonly startColumn: number; }<br>
	 */
	public double startColumn() { return get("startColumn", ofMapped(double.class)); }

 	/**
	 * <p>Line number on which the range starts (starts at 1).</p>
	 * See {@code monaco.d.ts:563:32}<br>
	 * Original signature:<br>
	 * {@code readonly startLineNumber: number; }<br>
	 */
	public double startLineNumber() { return get("startLineNumber", ofMapped(double.class)); }

 	/**
	 * <p>Test if equals other selection.</p>
	 * See {@code monaco.d.ts:749:23}<br>
	 * Original signature:<br>
	 * {@code equalsSelection(other: ISelection): boolean; }<br>
	 */
	public boolean equalsSelection(@Nonnull ISelection other) { return call("equalsSelection", ofMapped(boolean.class), other); }

 	/**
	 * <p>Get directions (LTR or RTL).</p>
	 * See {@code monaco.d.ts:757:20}<br>
	 * Original signature:<br>
	 * {@code getDirection(): SelectionDirection; }<br>
	 */
	public SelectionDirection getDirection() { return call("getDirection", ofJsEnum(SelectionDirection.class)); }

 	/**
	 * <p>Get the position at <code>positionLineNumber</code> and <code>positionColumn</code>.</p>
	 * See {@code monaco.d.ts:765:19}<br>
	 * Original signature:<br>
	 * {@code getPosition(): Position; }<br>
	 */
	public Position getPosition() { return call("getPosition", Position::new); }

 	/**
	 * <p>Create a new selection with a different <code>positionLineNumber</code> and <code>positionColumn</code>.</p>
	 * See {@code monaco.d.ts:761:22}<br>
	 * Original signature:<br>
	 * {@code setEndPosition(endLineNumber: number, endColumn: number): Selection; }<br>
	 */
	public Selection setEndPosition_(@Nonnull Double endLineNumber, @Nonnull Double endColumn) { return call("setEndPosition", Selection::new, endLineNumber, endColumn); }

 	/**
	 * <p>Create a new selection with a different <code>selectionStartLineNumber</code> and <code>selectionStartColumn</code>.</p>
	 * See {@code monaco.d.ts:769:24}<br>
	 * Original signature:<br>
	 * {@code setStartPosition(startLineNumber: number, startColumn: number): Selection; }<br>
	 */
	public Selection setStartPosition_(@Nonnull Double startLineNumber, @Nonnull Double startColumn) { return call("setStartPosition", Selection::new, startLineNumber, startColumn); }

 	/**
	 * <p>Transform to a human-readable representation.</p>
	 * See {@code monaco.d.ts:745:16}<br>
	 * Original signature:<br>
	 * {@code toString(): string; }<br>
	 */
	public String toString_() { return call("toString", ofMapped(String.class)); }

 	/**
	 * <p>Create with a direction.</p>
	 * See {@code monaco.d.ts:789:34}<br>
	 * Original signature:<br>
	 * {@code static createWithDirection(startLineNumber: number, startColumn: number, endLineNumber: number, endColumn: number, direction: SelectionDirection): Selection; }<br>
	 */
	public Selection createWithDirection(@Nonnull Double startLineNumber, @Nonnull Double startColumn, @Nonnull Double endLineNumber, @Nonnull Double endColumn, @Nonnull SelectionDirection direction) { return call("createWithDirection", Selection::new, startLineNumber, startColumn, endLineNumber, endColumn, direction); }

 	/**
	 * <p>Create a <code>Selection</code> from one or two positions</p>
	 * See {@code monaco.d.ts:773:28}<br>
	 * Original signature:<br>
	 * {@code static fromPositions(start: IPosition, end?: IPosition): Selection; }<br>
	 */
	public Selection fromPositions_(@Nonnull IPosition start, @Nonnull IPosition end) { return call("fromPositions", Selection::new, start, end); }

 	/**
	 * <p>Create a <code>Selection</code> from one or two positions</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:773:28}<br>
	 * Original signature:<br>
	 * {@code static fromPositions(start: IPosition, end?: IPosition): Selection; }<br>
	 */
	public Selection fromPositions_(@Nonnull IPosition start) { return call("fromPositions", Selection::new, start); }

 	/**
	 * <p>Test if <code>obj</code> is an <code>ISelection</code>.</p>
	 * See {@code monaco.d.ts:785:27}<br>
	 * Original signature:<br>
	 * {@code static isISelection(obj: any): obj is ISelection; }<br>
	 */
	public boolean isISelection(@Nonnull JSObject obj) { return call("isISelection", ofMapped(boolean.class), obj); }

 	/**
	 * <p>Create a <code>Selection</code> from an <code>ISelection</code>.</p>
	 * See {@code monaco.d.ts:777:28}<br>
	 * Original signature:<br>
	 * {@code static liftSelection(sel: ISelection): Selection; }<br>
	 */
	public Selection liftSelection(@Nonnull ISelection sel) { return call("liftSelection", Selection::new, sel); }

 	/**
	 * <p><code>a</code> equals <code>b</code>.</p>
	 * See {@code monaco.d.ts:781:33}<br>
	 * Original signature:<br>
	 * {@code static selectionsArrEqual(a: ISelection[], b: ISelection[]): boolean; }<br>
	 */
	public boolean selectionsArrEqual(@Nonnull List<ISelection> a, @Nonnull List<ISelection> b) { return call("selectionsArrEqual", ofMapped(boolean.class), a, b); }

 	/**
	 * <p>Test if the two selections are equal.</p>
	 * See {@code monaco.d.ts:753:30}<br>
	 * Original signature:<br>
	 * {@code static selectionsEqual(a: ISelection, b: ISelection): boolean; }<br>
	 */
	public boolean selectionsEqual(@Nonnull ISelection a, @Nonnull ISelection b) { return call("selectionsEqual", ofMapped(boolean.class), a, b); }

 
}
