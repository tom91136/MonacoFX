
package monaco_editor.monaco.editor;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>(Serializable) View state for the diff editor.</p>
 * See {@code monaco.d.ts:2086:41}<br>
 * Original signature:<br>
 * {@code export interface IDiffEditorViewState  }<br>
 */
@SuppressWarnings("unused")
public class IDiffEditorViewState extends JsProxy {

	public IDiffEditorViewState(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IDiffEditorViewState(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:2088:16}<br>
	 * Original signature:<br>
	 * {@code modified: ICodeEditorViewState | null; }<br>
	 */
	public Optional<ICodeEditorViewState> modified() { return Optional.ofNullable(get("modified", ICodeEditorViewState::new)); }

 	/**
	 * See {@code monaco.d.ts:2088:16}<br>
	 * Original signature:<br>
	 * {@code modified: ICodeEditorViewState | null; }<br>
	 */
	public IDiffEditorViewState modified(@Nullable ICodeEditorViewState value) {
		set("modified", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:2087:16}<br>
	 * Original signature:<br>
	 * {@code original: ICodeEditorViewState | null; }<br>
	 */
	public Optional<ICodeEditorViewState> original() { return Optional.ofNullable(get("original", ICodeEditorViewState::new)); }

 	/**
	 * See {@code monaco.d.ts:2087:16}<br>
	 * Original signature:<br>
	 * {@code original: ICodeEditorViewState | null; }<br>
	 */
	public IDiffEditorViewState original(@Nullable ICodeEditorViewState value) {
		set("original", value);
		return this;
	}

 
}
