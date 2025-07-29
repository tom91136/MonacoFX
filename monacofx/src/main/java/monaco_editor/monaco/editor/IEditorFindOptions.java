
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>Configuration options for editor find widget</p>
 * See {@code monaco.d.ts:3159:39}<br>
 * Original signature:<br>
 * {@code export interface IEditorFindOptions  }<br>
 */
@SuppressWarnings("unused")
public class IEditorFindOptions extends JsProxy {

	public IEditorFindOptions(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IEditorFindOptions(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:3168:26}<br>
	 * Original signature:<br>
	 * {@code addExtraSpaceOnTop?: boolean; }<br>
	 */
	public boolean addExtraSpaceOnTop() { return get("addExtraSpaceOnTop", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:3168:26}<br>
	 * Original signature:<br>
	 * {@code addExtraSpaceOnTop?: boolean; }<br>
	 */
	public IEditorFindOptions addExtraSpaceOnTop(@Nonnull Boolean value) {
		set("addExtraSpaceOnTop", value);
		return this;
	}

 	/**
	 * <p>Controls if we seed search string in the Find Widget with editor selection.</p>
	 * See {@code monaco.d.ts:3163:37}<br>
	 * Original signature:<br>
	 * {@code seedSearchStringFromSelection?: boolean; }<br>
	 */
	public boolean seedSearchStringFromSelection() { return get("seedSearchStringFromSelection", ofMapped(boolean.class)); }

 	/**
	 * <p>Controls if we seed search string in the Find Widget with editor selection.</p>
	 * See {@code monaco.d.ts:3163:37}<br>
	 * Original signature:<br>
	 * {@code seedSearchStringFromSelection?: boolean; }<br>
	 */
	public IEditorFindOptions seedSearchStringFromSelection(@Nonnull Boolean value) {
		set("seedSearchStringFromSelection", value);
		return this;
	}

 
}
