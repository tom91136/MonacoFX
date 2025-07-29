
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>Configuration options for editor comments</p>
 * See {@code monaco.d.ts:3086:43}<br>
 * Original signature:<br>
 * {@code export interface IEditorCommentsOptions  }<br>
 */
@SuppressWarnings("unused")
public class IEditorCommentsOptions extends JsProxy {

	public IEditorCommentsOptions(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IEditorCommentsOptions(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Insert a space after the line comment token and inside the block comments tokens.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:3091:19}<br>
	 * Original signature:<br>
	 * {@code insertSpace?: boolean; }<br>
	 */
	public boolean insertSpace() { return get("insertSpace", ofMapped(boolean.class)); }

 	/**
	 * <p>Insert a space after the line comment token and inside the block comments tokens.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:3091:19}<br>
	 * Original signature:<br>
	 * {@code insertSpace?: boolean; }<br>
	 */
	public IEditorCommentsOptions insertSpace(@Nonnull Boolean value) {
		set("insertSpace", value);
		return this;
	}

 
}
