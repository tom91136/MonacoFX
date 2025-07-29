
package monaco_editor.monaco;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import netscape.javascript.JSObject;

/**
 * <p>A position in the editor.</p>
 * See {@code monaco.d.ts:460:25}<br>
 * Original signature:<br>
 * {@code export class Position  }<br>
 */
@SuppressWarnings("unused")
public class Position extends JsProxy {

	public Position(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public Position(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>column (the first character in a line is between column 1 and column 2)</p>
	 * See {@code monaco.d.ts:468:23}<br>
	 * Original signature:<br>
	 * {@code readonly column: number; }<br>
	 */
	public double column() { return get("column", ofMapped(double.class)); }

 	/**
	 * <p>line number (starts at 1)</p>
	 * See {@code monaco.d.ts:464:27}<br>
	 * Original signature:<br>
	 * {@code readonly lineNumber: number; }<br>
	 */
	public double lineNumber() { return get("lineNumber", ofMapped(double.class)); }

 	/**
	 * <p>Clone this position.</p>
	 * See {@code monaco.d.ts:519:13}<br>
	 * Original signature:<br>
	 * {@code clone(): Position; }<br>
	 */
	public Position clone() { return call("clone", Position::new); }

 	/**
	 * <p>Derive a new position from this position.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:483:13}<br>
	 * Original signature:<br>
	 * {@code delta(deltaLineNumber?: number, deltaColumn?: number): Position; }<br>
	 */
	public Position delta(@Nonnull Double deltaLineNumber) { return call("delta", Position::new, deltaLineNumber); }

 	/**
	 * <p>Derive a new position from this position.</p>
	 * See {@code monaco.d.ts:483:13}<br>
	 * Original signature:<br>
	 * {@code delta(deltaLineNumber?: number, deltaColumn?: number): Position; }<br>
	 * 
	 * @param deltaLineNumber line number delta
	 * @param deltaColumn column delta
	 */
	public Position delta(@Nonnull Double deltaLineNumber, @Nonnull Double deltaColumn) { return call("delta", Position::new, deltaLineNumber, deltaColumn); }

 	/**
	 * <p>Derive a new position from this position.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:483:13}<br>
	 * Original signature:<br>
	 * {@code delta(deltaLineNumber?: number, deltaColumn?: number): Position; }<br>
	 */
	public Position delta() { return call("delta", Position::new); }

 	/**
	 * <p>Test if this position equals other position</p>
	 * See {@code monaco.d.ts:487:14}<br>
	 * Original signature:<br>
	 * {@code equals(other: IPosition): boolean; }<br>
	 */
	public boolean equals(@Nonnull IPosition other) { return call("equals", ofMapped(boolean.class), other); }

 	/**
	 * <p>Test if this position is before other position.
	 * If the two positions are equal, the result will be false.</p>
	 * See {@code monaco.d.ts:496:16}<br>
	 * Original signature:<br>
	 * {@code isBefore(other: IPosition): boolean; }<br>
	 */
	public boolean isBefore(@Nonnull IPosition other) { return call("isBefore", ofMapped(boolean.class), other); }

 	/**
	 * <p>Test if this position is before other position.
	 * If the two positions are equal, the result will be true.</p>
	 * See {@code monaco.d.ts:506:23}<br>
	 * Original signature:<br>
	 * {@code isBeforeOrEqual(other: IPosition): boolean; }<br>
	 */
	public boolean isBeforeOrEqual(@Nonnull IPosition other) { return call("isBeforeOrEqual", ofMapped(boolean.class), other); }

 	/**
	 * <p>Convert to a human-readable representation.</p>
	 * See {@code monaco.d.ts:523:16}<br>
	 * Original signature:<br>
	 * {@code toString(): string; }<br>
	 */
	public String toString() { return call("toString", ofMapped(String.class)); }

 	/**
	 * <p>Create a new position from this position.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:476:12}<br>
	 * Original signature:<br>
	 * {@code with(newLineNumber?: number, newColumn?: number): Position; }<br>
	 */
	public Position with(@Nonnull Double newLineNumber) { return call("with", Position::new, newLineNumber); }

 	/**
	 * <p>Create a new position from this position.</p>
	 * See {@code monaco.d.ts:476:12}<br>
	 * Original signature:<br>
	 * {@code with(newLineNumber?: number, newColumn?: number): Position; }<br>
	 * 
	 * @param newLineNumber new line number
	 * @param newColumn new column
	 */
	public Position with(@Nonnull Double newLineNumber, @Nonnull Double newColumn) { return call("with", Position::new, newLineNumber, newColumn); }

 	/**
	 * <p>Create a new position from this position.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:476:12}<br>
	 * Original signature:<br>
	 * {@code with(newLineNumber?: number, newColumn?: number): Position; }<br>
	 */
	public Position with() { return call("with", Position::new); }

 	/**
	 * <p>A function that compares positions, useful for sorting</p>
	 * See {@code monaco.d.ts:515:22}<br>
	 * Original signature:<br>
	 * {@code static compare(a: IPosition, b: IPosition): number; }<br>
	 */
	public double compare(@Nonnull IPosition a, @Nonnull IPosition b) { return call("compare", ofMapped(double.class), a, b); }

 	/**
	 * <p>Test if position <code>a</code> equals position <code>b</code></p>
	 * See {@code monaco.d.ts:491:21}<br>
	 * Original signature:<br>
	 * {@code static equals(a: IPosition | null, b: IPosition | null): boolean; }<br>
	 */
	public boolean equals(@Nullable IPosition a, @Nullable IPosition b) { return call("equals", ofMapped(boolean.class), a, b); }

 	/**
	 * <p>Test if position <code>a</code> is before position <code>b</code>.
	 * If the two positions are equal, the result will be false.</p>
	 * See {@code monaco.d.ts:501:23}<br>
	 * Original signature:<br>
	 * {@code static isBefore(a: IPosition, b: IPosition): boolean; }<br>
	 */
	public boolean isBefore(@Nonnull IPosition a, @Nonnull IPosition b) { return call("isBefore", ofMapped(boolean.class), a, b); }

 	/**
	 * <p>Test if position <code>a</code> is before position <code>b</code>.
	 * If the two positions are equal, the result will be true.</p>
	 * See {@code monaco.d.ts:511:30}<br>
	 * Original signature:<br>
	 * {@code static isBeforeOrEqual(a: IPosition, b: IPosition): boolean; }<br>
	 */
	public boolean isBeforeOrEqual(@Nonnull IPosition a, @Nonnull IPosition b) { return call("isBeforeOrEqual", ofMapped(boolean.class), a, b); }

 	/**
	 * <p>Test if <code>obj</code> is an <code>IPosition</code>.</p>
	 * See {@code monaco.d.ts:531:26}<br>
	 * Original signature:<br>
	 * {@code static isIPosition(obj: any): obj is IPosition; }<br>
	 */
	public boolean isIPosition(@Nonnull JSObject obj) { return call("isIPosition", ofMapped(boolean.class), obj); }

 	/**
	 * <p>Create a <code>Position</code> from an <code>IPosition</code>.</p>
	 * See {@code monaco.d.ts:527:19}<br>
	 * Original signature:<br>
	 * {@code static lift(pos: IPosition): Position; }<br>
	 */
	public Position lift(@Nonnull IPosition pos) { return call("lift", Position::new, pos); }

 
}
