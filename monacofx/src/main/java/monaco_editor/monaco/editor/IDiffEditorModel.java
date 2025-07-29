
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>A model for the diff editor.</p>
 * See {@code monaco.d.ts:1971:37}<br>
 * Original signature:<br>
 * {@code export interface IDiffEditorModel  }<br>
 */
@SuppressWarnings("unused")
public class IDiffEditorModel extends JsProxy {

	public IDiffEditorModel(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IDiffEditorModel(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Modified model.</p>
	 * See {@code monaco.d.ts:1979:16}<br>
	 * Original signature:<br>
	 * {@code modified: ITextModel; }<br>
	 */
	public ITextModel modified() { return get("modified", ITextModel::new); }

 	/**
	 * <p>Modified model.</p>
	 * See {@code monaco.d.ts:1979:16}<br>
	 * Original signature:<br>
	 * {@code modified: ITextModel; }<br>
	 */
	public IDiffEditorModel modified(@Nonnull ITextModel value) {
		set("modified", value);
		return this;
	}

 	/**
	 * <p>Original model.</p>
	 * See {@code monaco.d.ts:1975:16}<br>
	 * Original signature:<br>
	 * {@code original: ITextModel; }<br>
	 */
	public ITextModel original() { return get("original", ITextModel::new); }

 	/**
	 * <p>Original model.</p>
	 * See {@code monaco.d.ts:1975:16}<br>
	 * Original signature:<br>
	 * {@code original: ITextModel; }<br>
	 */
	public IDiffEditorModel original(@Nonnull ITextModel value) {
		set("original", value);
		return this;
	}

 
}
