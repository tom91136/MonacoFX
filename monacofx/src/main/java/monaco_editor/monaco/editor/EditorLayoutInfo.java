
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>The internal layout details of the editor.</p>
 * See {@code monaco.d.ts:3248:37}<br>
 * Original signature:<br>
 * {@code export interface EditorLayoutInfo  }<br>
 */
@SuppressWarnings("unused")
public class EditorLayoutInfo extends JsProxy {

	public EditorLayoutInfo(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public EditorLayoutInfo(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Left position for the content (actual text)</p>
	 * See {@code monaco.d.ts:3284:28}<br>
	 * Original signature:<br>
	 * {@code readonly contentLeft: number; }<br>
	 */
	public double contentLeft() { return get("contentLeft", ofMapped(double.class)); }

 	/**
	 * <p>The width of the content (actual text)</p>
	 * See {@code monaco.d.ts:3288:29}<br>
	 * Original signature:<br>
	 * {@code readonly contentWidth: number; }<br>
	 */
	public double contentWidth() { return get("contentWidth", ofMapped(double.class)); }

 	/**
	 * <p>Left position for the line decorations.</p>
	 * See {@code monaco.d.ts:3276:32}<br>
	 * Original signature:<br>
	 * {@code readonly decorationsLeft: number; }<br>
	 */
	public double decorationsLeft() { return get("decorationsLeft", ofMapped(double.class)); }

 	/**
	 * <p>The width of the line decorations.</p>
	 * See {@code monaco.d.ts:3280:33}<br>
	 * Original signature:<br>
	 * {@code readonly decorationsWidth: number; }<br>
	 */
	public double decorationsWidth() { return get("decorationsWidth", ofMapped(double.class)); }

 	/**
	 * <p>Left position for the glyph margin.</p>
	 * See {@code monaco.d.ts:3260:32}<br>
	 * Original signature:<br>
	 * {@code readonly glyphMarginLeft: number; }<br>
	 */
	public double glyphMarginLeft() { return get("glyphMarginLeft", ofMapped(double.class)); }

 	/**
	 * <p>The width of the glyph margin.</p>
	 * See {@code monaco.d.ts:3264:33}<br>
	 * Original signature:<br>
	 * {@code readonly glyphMarginWidth: number; }<br>
	 */
	public double glyphMarginWidth() { return get("glyphMarginWidth", ofMapped(double.class)); }

 	/**
	 * <p>Full editor height.</p>
	 * See {@code monaco.d.ts:3256:23}<br>
	 * Original signature:<br>
	 * {@code readonly height: number; }<br>
	 */
	public double height() { return get("height", ofMapped(double.class)); }

 	/**
	 * <p>The height of the horizontal scrollbar.</p>
	 * See {@code monaco.d.ts:3312:42}<br>
	 * Original signature:<br>
	 * {@code readonly horizontalScrollbarHeight: number; }<br>
	 */
	public double horizontalScrollbarHeight() { return get("horizontalScrollbarHeight", ofMapped(double.class)); }

 	/**
	 * <p>Left position for the line numbers.</p>
	 * See {@code monaco.d.ts:3268:32}<br>
	 * Original signature:<br>
	 * {@code readonly lineNumbersLeft: number; }<br>
	 */
	public double lineNumbersLeft() { return get("lineNumbersLeft", ofMapped(double.class)); }

 	/**
	 * <p>The width of the line numbers.</p>
	 * See {@code monaco.d.ts:3272:33}<br>
	 * Original signature:<br>
	 * {@code readonly lineNumbersWidth: number; }<br>
	 */
	public double lineNumbersWidth() { return get("lineNumbersWidth", ofMapped(double.class)); }

 	/**
	 * <p>The position for the minimap</p>
	 * See {@code monaco.d.ts:3292:28}<br>
	 * Original signature:<br>
	 * {@code readonly minimapLeft: number; }<br>
	 */
	public double minimapLeft() { return get("minimapLeft", ofMapped(double.class)); }

 	/**
	 * <p>The width of the minimap</p>
	 * See {@code monaco.d.ts:3296:29}<br>
	 * Original signature:<br>
	 * {@code readonly minimapWidth: number; }<br>
	 */
	public double minimapWidth() { return get("minimapWidth", ofMapped(double.class)); }

 	/**
	 * <p>The position of the overview ruler.</p>
	 * See {@code monaco.d.ts:3316:30}<br>
	 * Original signature:<br>
	 * {@code readonly overviewRuler: OverviewRulerPosition; }<br>
	 */
	public OverviewRulerPosition overviewRuler() { return get("overviewRuler", OverviewRulerPosition::new); }

 	/**
	 * <p>Minimap render type</p>
	 * See {@code monaco.d.ts:3300:30}<br>
	 * Original signature:<br>
	 * {@code readonly renderMinimap: RenderMinimap; }<br>
	 */
	public RenderMinimap renderMinimap() { return get("renderMinimap", ofJsEnum(RenderMinimap.class)); }

 	/**
	 * <p>The width of the vertical scrollbar.</p>
	 * See {@code monaco.d.ts:3308:39}<br>
	 * Original signature:<br>
	 * {@code readonly verticalScrollbarWidth: number; }<br>
	 */
	public double verticalScrollbarWidth() { return get("verticalScrollbarWidth", ofMapped(double.class)); }

 	/**
	 * <p>The number of columns (of typical characters) fitting on a viewport line.</p>
	 * See {@code monaco.d.ts:3304:31}<br>
	 * Original signature:<br>
	 * {@code readonly viewportColumn: number; }<br>
	 */
	public double viewportColumn() { return get("viewportColumn", ofMapped(double.class)); }

 	/**
	 * <p>Full editor width.</p>
	 * See {@code monaco.d.ts:3252:22}<br>
	 * Original signature:<br>
	 * {@code readonly width: number; }<br>
	 */
	public double width() { return get("width", ofMapped(double.class)); }

 
}
