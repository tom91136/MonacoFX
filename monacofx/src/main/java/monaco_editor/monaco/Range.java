
package monaco_editor.monaco;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import netscape.javascript.JSObject;

/**
 * <p>A range in the editor. (startLineNumber,startColumn) is &lt;= (endLineNumber,endColumn)</p>
 * See {@code monaco.d.ts:559:22}<br>
 * Original signature:<br>
 * {@code export class Range  }<br>
 */
@SuppressWarnings("unused")
public class Range extends JsProxy {

	public Range(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public Range(@Nonnull JsContext context) { super(context); }

 
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
	 * <p>Create a new empty range using this range's start position.</p>
	 * See {@code monaco.d.ts:658:23}<br>
	 * Original signature:<br>
	 * {@code collapseToStart(): Range; }<br>
	 */
	public Range collapseToStart() { return call("collapseToStart", Range::new); }

 	/**
	 * <p>Test if position is in this range. If the position is at the edges, will return true.</p>
	 * See {@code monaco.d.ts:588:24}<br>
	 * Original signature:<br>
	 * {@code containsPosition(position: IPosition): boolean; }<br>
	 */
	public boolean containsPosition(@Nonnull IPosition position) { return call("containsPosition", ofMapped(boolean.class), position); }

 	/**
	 * <p>Test if range is in this range. If the range is equal to this range, will return true.</p>
	 * See {@code monaco.d.ts:596:21}<br>
	 * Original signature:<br>
	 * {@code containsRange(range: IRange): boolean; }<br>
	 */
	public boolean containsRange(@Nonnull IRange range) { return call("containsRange", ofMapped(boolean.class), range); }

 	/**
	 * <p>Test if this range equals other.</p>
	 * See {@code monaco.d.ts:630:19}<br>
	 * Original signature:<br>
	 * {@code equalsRange(other: IRange | null): boolean; }<br>
	 */
	public boolean equalsRange(@Nullable IRange other) { return call("equalsRange", ofMapped(boolean.class), other); }

 	/**
	 * <p>Return the end position (which will be after or equal to the start position)</p>
	 * See {@code monaco.d.ts:638:22}<br>
	 * Original signature:<br>
	 * {@code getEndPosition(): Position; }<br>
	 */
	public Position getEndPosition() { return call("getEndPosition", Position::new); }

 	/**
	 * <p>Return the start position (which will be before or equal to the end position)</p>
	 * See {@code monaco.d.ts:642:24}<br>
	 * Original signature:<br>
	 * {@code getStartPosition(): Position; }<br>
	 */
	public Position getStartPosition() { return call("getStartPosition", Position::new); }

 	/**
	 * <p>A intersection of the two ranges.</p>
	 * See {@code monaco.d.ts:622:23}<br>
	 * Original signature:<br>
	 * {@code intersectRanges(range: IRange): Range | null; }<br>
	 */
	public Optional<Range> intersectRanges(@Nonnull IRange range) { return Optional.ofNullable(call("intersectRanges", Range::new, range)); }

 	/**
	 * <p>Test if this range is empty.</p>
	 * See {@code monaco.d.ts:580:15}<br>
	 * Original signature:<br>
	 * {@code isEmpty(): boolean; }<br>
	 */
	public boolean isEmpty() { return call("isEmpty", ofMapped(boolean.class)); }

 	/**
	 * <p>A reunion of the two ranges.
	 * The smallest position will be used as the start point, and the largest one as the end point.</p>
	 * See {@code monaco.d.ts:613:17}<br>
	 * Original signature:<br>
	 * {@code plusRange(range: IRange): Range; }<br>
	 */
	public Range plusRange(@Nonnull IRange range) { return call("plusRange", Range::new, range); }

 	/**
	 * <p>Create a new range using this range's start position, and using endLineNumber and endColumn as the end position.</p>
	 * See {@code monaco.d.ts:650:22}<br>
	 * Original signature:<br>
	 * {@code setEndPosition(endLineNumber: number, endColumn: number): Range; }<br>
	 */
	public Range setEndPosition(@Nonnull Double endLineNumber, @Nonnull Double endColumn) { return call("setEndPosition", Range::new, endLineNumber, endColumn); }

 	/**
	 * <p>Create a new range using this range's end position, and using startLineNumber and startColumn as the start position.</p>
	 * See {@code monaco.d.ts:654:24}<br>
	 * Original signature:<br>
	 * {@code setStartPosition(startLineNumber: number, startColumn: number): Range; }<br>
	 */
	public Range setStartPosition(@Nonnull Double startLineNumber, @Nonnull Double startColumn) { return call("setStartPosition", Range::new, startLineNumber, startColumn); }

 	/**
	 * <p>Test if <code>range</code> is strictly in this range. <code>range</code> must start after and end before this range for the result to be true.</p>
	 * See {@code monaco.d.ts:604:27}<br>
	 * Original signature:<br>
	 * {@code strictContainsRange(range: IRange): boolean; }<br>
	 */
	public boolean strictContainsRange(@Nonnull IRange range) { return call("strictContainsRange", ofMapped(boolean.class), range); }

 	/**
	 * <p>Transform to a user presentable string representation.</p>
	 * See {@code monaco.d.ts:646:16}<br>
	 * Original signature:<br>
	 * {@code toString(): string; }<br>
	 */
	public String toString() { return call("toString", ofMapped(String.class)); }

 	/**
	 * <p>Test if the two ranges are intersecting. If the ranges are touching it returns true.</p>
	 * See {@code monaco.d.ts:680:30}<br>
	 * Original signature:<br>
	 * {@code static areIntersecting(a: IRange, b: IRange): boolean; }<br>
	 */
	public boolean areIntersecting(@Nonnull IRange a, @Nonnull IRange b) { return call("areIntersecting", ofMapped(boolean.class), a, b); }

 	/**
	 * <p>Test if the two ranges are touching in any way.</p>
	 * See {@code monaco.d.ts:676:40}<br>
	 * Original signature:<br>
	 * {@code static areIntersectingOrTouching(a: IRange, b: IRange): boolean; }<br>
	 */
	public boolean areIntersectingOrTouching(@Nonnull IRange a, @Nonnull IRange b) { return call("areIntersectingOrTouching", ofMapped(boolean.class), a, b); }

 	/**
	 * <p>Create a new empty range using this range's start position.</p>
	 * See {@code monaco.d.ts:662:30}<br>
	 * Original signature:<br>
	 * {@code static collapseToStart(range: IRange): Range; }<br>
	 */
	public Range collapseToStart(@Nonnull IRange range) { return call("collapseToStart", Range::new, range); }

 	/**
	 * <p>A function that compares ranges, useful for sorting ranges
	 * It will first compare ranges on the endPosition and then on the startPosition</p>
	 * See {@code monaco.d.ts:690:37}<br>
	 * Original signature:<br>
	 * {@code static compareRangesUsingEnds(a: IRange, b: IRange): number; }<br>
	 */
	public double compareRangesUsingEnds(@Nonnull IRange a, @Nonnull IRange b) { return call("compareRangesUsingEnds", ofMapped(double.class), a, b); }

 	/**
	 * <p>A function that compares ranges, useful for sorting ranges
	 * It will first compare ranges on the startPosition and then on the endPosition</p>
	 * See {@code monaco.d.ts:685:39}<br>
	 * Original signature:<br>
	 * {@code static compareRangesUsingStarts(a: IRange | null | undefined, b: IRange | null | undefined): number; }<br>
	 */
	public double compareRangesUsingStarts(@Nullable IRange a, @Nullable IRange b) { return call("compareRangesUsingStarts", ofMapped(double.class), a, b); }

 	/**
	 * <p>Test if <code>position</code> is in <code>range</code>. If the position is at the edges, will return true.</p>
	 * See {@code monaco.d.ts:592:31}<br>
	 * Original signature:<br>
	 * {@code static containsPosition(range: IRange, position: IPosition): boolean; }<br>
	 */
	public boolean containsPosition(@Nonnull IRange range, @Nonnull IPosition position) { return call("containsPosition", ofMapped(boolean.class), range, position); }

 	/**
	 * <p>Test if <code>otherRange</code> is in <code>range</code>. If the ranges are equal, will return true.</p>
	 * See {@code monaco.d.ts:600:28}<br>
	 * Original signature:<br>
	 * {@code static containsRange(range: IRange, otherRange: IRange): boolean; }<br>
	 */
	public boolean containsRange(@Nonnull IRange range, @Nonnull IRange otherRange) { return call("containsRange", ofMapped(boolean.class), range, otherRange); }

 	/**
	 * <p>Test if range <code>a</code> equals <code>b</code>.</p>
	 * See {@code monaco.d.ts:634:26}<br>
	 * Original signature:<br>
	 * {@code static equalsRange(a: IRange | null, b: IRange | null): boolean; }<br>
	 */
	public boolean equalsRange(@Nullable IRange a, @Nullable IRange b) { return call("equalsRange", ofMapped(boolean.class), a, b); }

 	/**
	 * See {@code monaco.d.ts:663:28}<br>
	 * Original signature:<br>
	 * {@code static fromPositions(start: IPosition, end?: IPosition): Range; }<br>
	 */
	public Range fromPositions(@Nonnull IPosition start, @Nonnull IPosition end) { return call("fromPositions", Range::new, start, end); }

 	/**
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:663:28}<br>
	 * Original signature:<br>
	 * {@code static fromPositions(start: IPosition, end?: IPosition): Range; }<br>
	 */
	public Range fromPositions(@Nonnull IPosition start) { return call("fromPositions", Range::new, start); }

 	/**
	 * <p>A intersection of the two ranges.</p>
	 * See {@code monaco.d.ts:626:30}<br>
	 * Original signature:<br>
	 * {@code static intersectRanges(a: IRange, b: IRange): Range | null; }<br>
	 */
	public Optional<Range> intersectRanges(@Nonnull IRange a, @Nonnull IRange b) { return Optional.ofNullable(call("intersectRanges", Range::new, a, b)); }

 	/**
	 * <p>Test if <code>range</code> is empty.</p>
	 * See {@code monaco.d.ts:584:22}<br>
	 * Original signature:<br>
	 * {@code static isEmpty(range: IRange): boolean; }<br>
	 */
	public boolean isEmpty(@Nonnull IRange range) { return call("isEmpty", ofMapped(boolean.class), range); }

 	/**
	 * <p>Test if <code>obj</code> is an <code>IRange</code>.</p>
	 * See {@code monaco.d.ts:672:23}<br>
	 * Original signature:<br>
	 * {@code static isIRange(obj: any): obj is IRange; }<br>
	 */
	public boolean isIRange(@Nonnull JSObject obj) { return call("isIRange", ofMapped(boolean.class), obj); }

 	/**
	 * See {@code monaco.d.ts:667:19}<br>
	 * See {@code monaco.d.ts:668:19}<br>
	 * Original signature:<br>
	 * {@code static lift(range: undefined | null): null; }<br>
	 * {@code static lift(range: IRange): Range; }<br>
	 */
	public Range lift(@Nonnull IRange range) { return call("lift", Range::new, range); }

 	/**
	 * <p>A reunion of the two ranges.
	 * The smallest position will be used as the start point, and the largest one as the end point.</p>
	 * See {@code monaco.d.ts:618:24}<br>
	 * Original signature:<br>
	 * {@code static plusRange(a: IRange, b: IRange): Range; }<br>
	 */
	public Range plusRange(@Nonnull IRange a, @Nonnull IRange b) { return call("plusRange", Range::new, a, b); }

 	/**
	 * <p>Test if the range spans multiple lines.</p>
	 * See {@code monaco.d.ts:694:33}<br>
	 * Original signature:<br>
	 * {@code static spansMultipleLines(range: IRange): boolean; }<br>
	 */
	public boolean spansMultipleLines(@Nonnull IRange range) { return call("spansMultipleLines", ofMapped(boolean.class), range); }

 	/**
	 * <p>Test if <code>otherRange</code> is strinctly in <code>range</code> (must start after, and end before). If the ranges are equal, will return false.</p>
	 * See {@code monaco.d.ts:608:34}<br>
	 * Original signature:<br>
	 * {@code static strictContainsRange(range: IRange, otherRange: IRange): boolean; }<br>
	 */
	public boolean strictContainsRange(@Nonnull IRange range, @Nonnull IRange otherRange) { return call("strictContainsRange", ofMapped(boolean.class), range, otherRange); }

 
}
