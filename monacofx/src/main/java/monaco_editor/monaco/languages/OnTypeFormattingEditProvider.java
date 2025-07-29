
package monaco_editor.monaco.languages;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import monaco_editor.monaco.CancellationToken;
import monaco_editor.monaco.Position;
import monaco_editor.monaco.editor.ITextModel;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsPromise;
import net.kurobako.monacofx.js.JsProxy;
import net.kurobako.monacofx.js.JsUnion2;
import netscape.javascript.JSObject;

/**
 * <p>The document formatting provider interface defines the contract between extensions and
 * the formatting-feature.</p>
 * See {@code monaco.d.ts:5751:49}<br>
 * Original signature:<br>
 * {@code export interface OnTypeFormattingEditProvider  }<br>
 */
@SuppressWarnings("unused")
public class OnTypeFormattingEditProvider extends JsProxy {

	public OnTypeFormattingEditProvider(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public OnTypeFormattingEditProvider(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5752:35}<br>
	 * Original signature:<br>
	 * {@code autoFormatTriggerCharacters: string[]; }<br>
	 */
	public List<String> autoFormatTriggerCharacters() { return get("autoFormatTriggerCharacters", ofArray(ofMapped(String.class))); }

 	/**
	 * See {@code monaco.d.ts:5752:35}<br>
	 * Original signature:<br>
	 * {@code autoFormatTriggerCharacters: string[]; }<br>
	 */
	public OnTypeFormattingEditProvider autoFormatTriggerCharacters(@Nonnull List<String> value) {
		
		return this;
	}

 	/**
	 * <p>Provide formatting edits after a character has been typed.
	 * The given position and character should hint to the provider
	 * what range the position to expand to, like find the matching <code>{</code>
	 * when <code>}</code> has been entered.</p>
	 * See {@code monaco.d.ts:5760:36}<br>
	 * Original signature:<br>
	 * {@code provideOnTypeFormattingEdits(model: editor.ITextModel, position: Position, ch: string, options: FormattingOptions, token: CancellationToken): ProviderResult<TextEdit[]>; }<br>
	 */
	public Optional<JsUnion2<List<JSObject>, JsPromise<List<JSObject>>>> provideOnTypeFormattingEdits(@Nonnull ITextModel model, @Nonnull Position position, @Nonnull String ch, @Nonnull FormattingOptions options, @Nonnull CancellationToken token) { return Optional.ofNullable(call("provideOnTypeFormattingEdits", null /*union*/, model, position, ch, options, token)); }

 
}
