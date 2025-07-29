
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import monaco_editor.monaco.IPosition;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>A (serializable) state of the view.</p>
 * See {@code monaco.d.ts:2062:31}<br>
 * Original signature:<br>
 * {@code export interface IViewState  }<br>
 */
@SuppressWarnings("unused")
public class IViewState extends JsProxy {

	public IViewState(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IViewState(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:2068:21}<br>
	 * Original signature:<br>
	 * {@code firstPosition: IPosition; }<br>
	 */
	public IPosition firstPosition() { return get("firstPosition", IPosition::new); }

 	/**
	 * See {@code monaco.d.ts:2068:21}<br>
	 * Original signature:<br>
	 * {@code firstPosition: IPosition; }<br>
	 */
	public IViewState firstPosition(@Nonnull IPosition value) {
		set("firstPosition", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:2069:29}<br>
	 * Original signature:<br>
	 * {@code firstPositionDeltaTop: number; }<br>
	 */
	public double firstPositionDeltaTop() { return get("firstPositionDeltaTop", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:2069:29}<br>
	 * Original signature:<br>
	 * {@code firstPositionDeltaTop: number; }<br>
	 */
	public IViewState firstPositionDeltaTop(@Nonnull Double value) {
		set("firstPositionDeltaTop", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:2067:18}<br>
	 * Original signature:<br>
	 * {@code scrollLeft: number; }<br>
	 */
	public double scrollLeft() { return get("scrollLeft", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:2067:18}<br>
	 * Original signature:<br>
	 * {@code scrollLeft: number; }<br>
	 */
	public IViewState scrollLeft(@Nonnull Double value) {
		set("scrollLeft", value);
		return this;
	}

 	/**
	 * <p>written by previous versions</p>
	 * See {@code monaco.d.ts:2064:17}<br>
	 * Original signature:<br>
	 * {@code scrollTop?: number; }<br>
	 */
	public double scrollTop() { return get("scrollTop", ofMapped(double.class)); }

 	/**
	 * <p>written by previous versions</p>
	 * See {@code monaco.d.ts:2064:17}<br>
	 * Original signature:<br>
	 * {@code scrollTop?: number; }<br>
	 */
	public IViewState scrollTop(@Nonnull Double value) {
		set("scrollTop", value);
		return this;
	}

 	/**
	 * <p>written by previous versions</p>
	 * See {@code monaco.d.ts:2066:33}<br>
	 * Original signature:<br>
	 * {@code scrollTopWithoutViewZones?: number; }<br>
	 */
	public double scrollTopWithoutViewZones() { return get("scrollTopWithoutViewZones", ofMapped(double.class)); }

 	/**
	 * <p>written by previous versions</p>
	 * See {@code monaco.d.ts:2066:33}<br>
	 * Original signature:<br>
	 * {@code scrollTopWithoutViewZones?: number; }<br>
	 */
	public IViewState scrollTopWithoutViewZones(@Nonnull Double value) {
		set("scrollTopWithoutViewZones", value);
		return this;
	}

 
}
