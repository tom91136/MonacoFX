
package monaco_editor.monaco.editor;
import java.util.List;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import netscape.javascript.JSObject;

/**
 * <p>A (serializable) state of the code editor.</p>
 * See {@code monaco.d.ts:2075:41}<br>
 * Original signature:<br>
 * {@code export interface ICodeEditorViewState  }<br>
 */
@SuppressWarnings("unused")
public class ICodeEditorViewState extends JsProxy {

	public ICodeEditorViewState(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public ICodeEditorViewState(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:2078:26}<br>
	 * Original signature:<br>
	 * {@code contributionsState:  }<br>
	 */
	public JSObject contributionsState() { return get("contributionsState", ofMapped(JSObject.class)); }

 	/**
	 * See {@code monaco.d.ts:2078:26}<br>
	 * Original signature:<br>
	 * {@code contributionsState:  }<br>
	 */
	public ICodeEditorViewState contributionsState(@Nonnull JSObject value) {
		set("contributionsState", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:2076:19}<br>
	 * Original signature:<br>
	 * {@code cursorState: ICursorState[]; }<br>
	 */
	public List<ICursorState> cursorState() { return get("cursorState", ofArray(ICursorState::new)); }

 	/**
	 * See {@code monaco.d.ts:2076:19}<br>
	 * Original signature:<br>
	 * {@code cursorState: ICursorState[]; }<br>
	 */
	public ICodeEditorViewState cursorState(@Nonnull List<ICursorState> value) {
		
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:2077:17}<br>
	 * Original signature:<br>
	 * {@code viewState: IViewState; }<br>
	 */
	public IViewState viewState() { return get("viewState", IViewState::new); }

 	/**
	 * See {@code monaco.d.ts:2077:17}<br>
	 * Original signature:<br>
	 * {@code viewState: IViewState; }<br>
	 */
	public ICodeEditorViewState viewState(@Nonnull IViewState value) {
		set("viewState", value);
		return this;
	}

 
}
