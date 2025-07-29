
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:3479:51}<br>
 * Original signature:<br>
 * {@code export interface InternalEditorScrollbarOptions  }<br>
 */
@SuppressWarnings("unused")
public class InternalEditorScrollbarOptions extends JsProxy {

	public InternalEditorScrollbarOptions(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public InternalEditorScrollbarOptions(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:3487:40}<br>
	 * Original signature:<br>
	 * {@code readonly alwaysConsumeMouseWheel: boolean; }<br>
	 */
	public boolean alwaysConsumeMouseWheel() { return get("alwaysConsumeMouseWheel", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:3480:26}<br>
	 * Original signature:<br>
	 * {@code readonly arrowSize: number; }<br>
	 */
	public double arrowSize() { return get("arrowSize", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:3486:33}<br>
	 * Original signature:<br>
	 * {@code readonly handleMouseWheel: boolean; }<br>
	 */
	public boolean handleMouseWheel() { return get("handleMouseWheel", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:3482:27}<br>
	 * Original signature:<br>
	 * {@code readonly horizontal: ScrollbarVisibility; }<br>
	 */
	public ScrollbarVisibility horizontal() { return get("horizontal", ofJsEnum(ScrollbarVisibility.class)); }

 	/**
	 * See {@code monaco.d.ts:3485:36}<br>
	 * Original signature:<br>
	 * {@code readonly horizontalHasArrows: boolean; }<br>
	 */
	public boolean horizontalHasArrows() { return get("horizontalHasArrows", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:3488:40}<br>
	 * Original signature:<br>
	 * {@code readonly horizontalScrollbarSize: number; }<br>
	 */
	public double horizontalScrollbarSize() { return get("horizontalScrollbarSize", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:3489:37}<br>
	 * Original signature:<br>
	 * {@code readonly horizontalSliderSize: number; }<br>
	 */
	public double horizontalSliderSize() { return get("horizontalSliderSize", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:3483:27}<br>
	 * Original signature:<br>
	 * {@code readonly useShadows: boolean; }<br>
	 */
	public boolean useShadows() { return get("useShadows", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:3481:25}<br>
	 * Original signature:<br>
	 * {@code readonly vertical: ScrollbarVisibility; }<br>
	 */
	public ScrollbarVisibility vertical() { return get("vertical", ofJsEnum(ScrollbarVisibility.class)); }

 	/**
	 * See {@code monaco.d.ts:3484:34}<br>
	 * Original signature:<br>
	 * {@code readonly verticalHasArrows: boolean; }<br>
	 */
	public boolean verticalHasArrows() { return get("verticalHasArrows", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:3490:38}<br>
	 * Original signature:<br>
	 * {@code readonly verticalScrollbarSize: number; }<br>
	 */
	public double verticalScrollbarSize() { return get("verticalScrollbarSize", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:3491:35}<br>
	 * Original signature:<br>
	 * {@code readonly verticalSliderSize: number; }<br>
	 */
	public double verticalSliderSize() { return get("verticalSliderSize", ofMapped(double.class)); }

 
}
