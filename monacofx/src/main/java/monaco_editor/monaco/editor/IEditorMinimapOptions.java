
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>Configuration options for editor minimap</p>
 * See {@code monaco.d.ts:3335:42}<br>
 * Original signature:<br>
 * {@code export interface IEditorMinimapOptions  }<br>
 */
@SuppressWarnings("unused")
public class IEditorMinimapOptions extends JsProxy {

	public IEditorMinimapOptions(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IEditorMinimapOptions(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Enable the rendering of the minimap.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:3340:15}<br>
	 * Original signature:<br>
	 * {@code enabled?: boolean; }<br>
	 */
	public boolean enabled() { return get("enabled", ofMapped(boolean.class)); }

 	/**
	 * <p>Enable the rendering of the minimap.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:3340:15}<br>
	 * Original signature:<br>
	 * {@code enabled?: boolean; }<br>
	 */
	public IEditorMinimapOptions enabled(@Nonnull Boolean value) {
		set("enabled", value);
		return this;
	}

 	/**
	 * <p>Limit the width of the minimap to render at most a certain number of columns.
	 * Defaults to 120.</p>
	 * See {@code monaco.d.ts:3360:17}<br>
	 * Original signature:<br>
	 * {@code maxColumn?: number; }<br>
	 */
	public double maxColumn() { return get("maxColumn", ofMapped(double.class)); }

 	/**
	 * <p>Limit the width of the minimap to render at most a certain number of columns.
	 * Defaults to 120.</p>
	 * See {@code monaco.d.ts:3360:17}<br>
	 * Original signature:<br>
	 * {@code maxColumn?: number; }<br>
	 */
	public IEditorMinimapOptions maxColumn(@Nonnull Double value) {
		set("maxColumn", value);
		return this;
	}

 	/**
	 * <p>Render the actual text on a line (as opposed to color blocks).
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:3355:24}<br>
	 * Original signature:<br>
	 * {@code renderCharacters?: boolean; }<br>
	 */
	public boolean renderCharacters() { return get("renderCharacters", ofMapped(boolean.class)); }

 	/**
	 * <p>Render the actual text on a line (as opposed to color blocks).
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:3355:24}<br>
	 * Original signature:<br>
	 * {@code renderCharacters?: boolean; }<br>
	 */
	public IEditorMinimapOptions renderCharacters(@Nonnull Boolean value) {
		set("renderCharacters", value);
		return this;
	}

 	/**
	 * <p>Relative size of the font in the minimap. Defaults to 1.</p>
	 * See {@code monaco.d.ts:3364:13}<br>
	 * Original signature:<br>
	 * {@code scale?: number; }<br>
	 */
	public double scale() { return get("scale", ofMapped(double.class)); }

 	/**
	 * <p>Relative size of the font in the minimap. Defaults to 1.</p>
	 * See {@code monaco.d.ts:3364:13}<br>
	 * Original signature:<br>
	 * {@code scale?: number; }<br>
	 */
	public IEditorMinimapOptions scale(@Nonnull Double value) {
		set("scale", value);
		return this;
	}

 
}
