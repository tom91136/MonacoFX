
package monaco_editor.monaco.editor;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import netscape.javascript.JSObject;

/**
 * <p>A view zone is a full horizontal rectangle that 'pushes' text down.
 * The editor reserves space for view zones when rendering.</p>
 * See {@code monaco.d.ts:3904:30}<br>
 * Original signature:<br>
 * {@code export interface IViewZone  }<br>
 */
@SuppressWarnings("unused")
public class IViewZone extends JsProxy {

	public IViewZone(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IViewZone(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>The column after which this zone should appear.
	 * If not set, the maxLineColumn of <code>afterLineNumber</code> will be used.</p>
	 * See {@code monaco.d.ts:3914:19}<br>
	 * Original signature:<br>
	 * {@code afterColumn?: number; }<br>
	 */
	public double afterColumn() { return get("afterColumn", ofMapped(double.class)); }

 	/**
	 * <p>The column after which this zone should appear.
	 * If not set, the maxLineColumn of <code>afterLineNumber</code> will be used.</p>
	 * See {@code monaco.d.ts:3914:19}<br>
	 * Original signature:<br>
	 * {@code afterColumn?: number; }<br>
	 */
	public IViewZone afterColumn(@Nonnull Double value) {
		set("afterColumn", value);
		return this;
	}

 	/**
	 * <p>The line number after which this zone should appear.
	 * Use 0 to place a view zone before the first line number.</p>
	 * See {@code monaco.d.ts:3909:23}<br>
	 * Original signature:<br>
	 * {@code afterLineNumber: number; }<br>
	 */
	public double afterLineNumber() { return get("afterLineNumber", ofMapped(double.class)); }

 	/**
	 * <p>The line number after which this zone should appear.
	 * Use 0 to place a view zone before the first line number.</p>
	 * See {@code monaco.d.ts:3909:23}<br>
	 * Original signature:<br>
	 * {@code afterLineNumber: number; }<br>
	 */
	public IViewZone afterLineNumber(@Nonnull Double value) {
		set("afterLineNumber", value);
		return this;
	}

 	/**
	 * <p>The dom node of the view zone</p>
	 * See {@code monaco.d.ts:3941:15}<br>
	 * Original signature:<br>
	 * {@code domNode: HTMLElement; }<br>
	 */
	public JSObject domNode() { return get("domNode", ofMapped(JSObject.class)); }

 	/**
	 * <p>The dom node of the view zone</p>
	 * See {@code monaco.d.ts:3941:15}<br>
	 * Original signature:<br>
	 * {@code domNode: HTMLElement; }<br>
	 */
	public IViewZone domNode(@Nonnull JSObject value) {
		set("domNode", value);
		return this;
	}

 	/**
	 * <p>The height in lines of the view zone.
	 * If specified, <code>heightInPx</code> will be used instead of this.
	 * If neither <code>heightInPx</code> nor <code>heightInLines</code> is specified, a default of <code>heightInLines</code> = 1 will be chosen.</p>
	 * See {@code monaco.d.ts:3926:21}<br>
	 * Original signature:<br>
	 * {@code heightInLines?: number; }<br>
	 */
	public double heightInLines() { return get("heightInLines", ofMapped(double.class)); }

 	/**
	 * <p>The height in lines of the view zone.
	 * If specified, <code>heightInPx</code> will be used instead of this.
	 * If neither <code>heightInPx</code> nor <code>heightInLines</code> is specified, a default of <code>heightInLines</code> = 1 will be chosen.</p>
	 * See {@code monaco.d.ts:3926:21}<br>
	 * Original signature:<br>
	 * {@code heightInLines?: number; }<br>
	 */
	public IViewZone heightInLines(@Nonnull Double value) {
		set("heightInLines", value);
		return this;
	}

 	/**
	 * <p>The height in px of the view zone.
	 * If this is set, the editor will give preference to it rather than <code>heightInLines</code> above.
	 * If neither <code>heightInPx</code> nor <code>heightInLines</code> is specified, a default of <code>heightInLines</code> = 1 will be chosen.</p>
	 * See {@code monaco.d.ts:3932:18}<br>
	 * Original signature:<br>
	 * {@code heightInPx?: number; }<br>
	 */
	public double heightInPx() { return get("heightInPx", ofMapped(double.class)); }

 	/**
	 * <p>The height in px of the view zone.
	 * If this is set, the editor will give preference to it rather than <code>heightInLines</code> above.
	 * If neither <code>heightInPx</code> nor <code>heightInLines</code> is specified, a default of <code>heightInLines</code> = 1 will be chosen.</p>
	 * See {@code monaco.d.ts:3932:18}<br>
	 * Original signature:<br>
	 * {@code heightInPx?: number; }<br>
	 */
	public IViewZone heightInPx(@Nonnull Double value) {
		set("heightInPx", value);
		return this;
	}

 	/**
	 * <p>An optional dom node for the view zone that will be placed in the margin area.</p>
	 * See {@code monaco.d.ts:3945:21}<br>
	 * Original signature:<br>
	 * {@code marginDomNode?: HTMLElement | null; }<br>
	 */
	public Optional<JSObject> marginDomNode() { return Optional.ofNullable(get("marginDomNode", ofMapped(JSObject.class))); }

 	/**
	 * <p>An optional dom node for the view zone that will be placed in the margin area.</p>
	 * See {@code monaco.d.ts:3945:21}<br>
	 * Original signature:<br>
	 * {@code marginDomNode?: HTMLElement | null; }<br>
	 */
	public IViewZone marginDomNode(@Nullable JSObject value) {
		set("marginDomNode", value);
		return this;
	}

 	/**
	 * <p>The minimum width in px of the view zone.
	 * If this is set, the editor will ensure that the scroll width is &gt;= than this value.</p>
	 * See {@code monaco.d.ts:3937:20}<br>
	 * Original signature:<br>
	 * {@code minWidthInPx?: number; }<br>
	 */
	public double minWidthInPx() { return get("minWidthInPx", ofMapped(double.class)); }

 	/**
	 * <p>The minimum width in px of the view zone.
	 * If this is set, the editor will ensure that the scroll width is &gt;= than this value.</p>
	 * See {@code monaco.d.ts:3937:20}<br>
	 * Original signature:<br>
	 * {@code minWidthInPx?: number; }<br>
	 */
	public IViewZone minWidthInPx(@Nonnull Double value) {
		set("minWidthInPx", value);
		return this;
	}

 	/**
	 * <p>Callback which gives the height in pixels of the view zone.</p>
	 * See {@code monaco.d.ts:3953:24}<br>
	 * Original signature:<br>
	 * {@code onComputedHeight?: (height: number) => void; }<br>
	 */
	public JSObject onComputedHeight() { return get("onComputedHeight", ofMapped(JSObject.class)); }

 	/**
	 * <p>Callback which gives the height in pixels of the view zone.</p>
	 * See {@code monaco.d.ts:3953:24}<br>
	 * Original signature:<br>
	 * {@code onComputedHeight?: (height: number) => void; }<br>
	 */
	public IViewZone onComputedHeight(@Nonnull JSObject value) {
		set("onComputedHeight", value);
		return this;
	}

 	/**
	 * <p>Callback which gives the relative top of the view zone as it appears (taking scrolling into account).</p>
	 * See {@code monaco.d.ts:3949:20}<br>
	 * Original signature:<br>
	 * {@code onDomNodeTop?: (top: number) => void; }<br>
	 */
	public JSObject onDomNodeTop() { return get("onDomNodeTop", ofMapped(JSObject.class)); }

 	/**
	 * <p>Callback which gives the relative top of the view zone as it appears (taking scrolling into account).</p>
	 * See {@code monaco.d.ts:3949:20}<br>
	 * Original signature:<br>
	 * {@code onDomNodeTop?: (top: number) => void; }<br>
	 */
	public IViewZone onDomNodeTop(@Nonnull JSObject value) {
		set("onDomNodeTop", value);
		return this;
	}

 	/**
	 * <p>Suppress mouse down events.
	 * If set, the editor will attach a mouse down listener to the view zone and .preventDefault on it.
	 * Defaults to false</p>
	 * See {@code monaco.d.ts:3920:25}<br>
	 * Original signature:<br>
	 * {@code suppressMouseDown?: boolean; }<br>
	 */
	public boolean suppressMouseDown() { return get("suppressMouseDown", ofMapped(boolean.class)); }

 	/**
	 * <p>Suppress mouse down events.
	 * If set, the editor will attach a mouse down listener to the view zone and .preventDefault on it.
	 * Defaults to false</p>
	 * See {@code monaco.d.ts:3920:25}<br>
	 * Original signature:<br>
	 * {@code suppressMouseDown?: boolean; }<br>
	 */
	public IViewZone suppressMouseDown(@Nonnull Boolean value) {
		set("suppressMouseDown", value);
		return this;
	}

 
}
