
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:3077:34}<br>
 * Original signature:<br>
 * {@code export interface IEditorOption<K1 extends EditorOption, V>  }<br>
 */
@SuppressWarnings("unused")
public class IEditorOption <K1, V> extends JsProxy {

	public IEditorOption(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IEditorOption(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:3080:20}<br>
	 * Original signature:<br>
	 * {@code defaultValue: V; }<br>
	 */
	public V defaultValue() { return get("defaultValue", null ); }

 	/**
	 * See {@code monaco.d.ts:3080:20}<br>
	 * Original signature:<br>
	 * {@code defaultValue: V; }<br>
	 */
	public IEditorOption<K1, V> defaultValue(@Nonnull V value) {
		
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:3078:19}<br>
	 * Original signature:<br>
	 * {@code readonly id: K1; }<br>
	 */
	public K1 id() { return get("id", null ); }

 	/**
	 * See {@code monaco.d.ts:3079:21}<br>
	 * Original signature:<br>
	 * {@code readonly name: string; }<br>
	 */
	public String name() { return get("name", ofMapped(String.class)); }

 
}
