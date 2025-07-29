
package monaco_editor.monaco.languages;
import java.util.Optional;
import javax.annotation.Nonnull;
import monaco_editor.monaco.CancellationToken;
import monaco_editor.monaco.IEvent;
import monaco_editor.monaco.editor.ITextModel;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsPromise;
import net.kurobako.monacofx.js.JsProxy;
import net.kurobako.monacofx.js.JsUnion2;

/**
 * See {@code monaco.d.ts:5991:37}<br>
 * Original signature:<br>
 * {@code export interface CodeLensProvider  }<br>
 */
@SuppressWarnings("unused")
public class CodeLensProvider extends JsProxy {

	public CodeLensProvider(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public CodeLensProvider(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5992:19}<br>
	 * Original signature:<br>
	 * {@code onDidChange?: IEvent<this>; }<br>
	 */
	public IEvent<CodeLensProvider> onDidChange() { return get("onDidChange", IEvent ::new); }

 	/**
	 * See {@code monaco.d.ts:5992:19}<br>
	 * Original signature:<br>
	 * {@code onDidChange?: IEvent<this>; }<br>
	 */
	public CodeLensProvider onDidChange(@Nonnull IEvent<CodeLensProvider> value) {
		
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5993:25}<br>
	 * Original signature:<br>
	 * {@code provideCodeLenses(model: editor.ITextModel, token: CancellationToken): ProviderResult<CodeLensList>; }<br>
	 */
	public Optional<JsUnion2<CodeLensList, JsPromise<CodeLensList>>> provideCodeLenses(@Nonnull ITextModel model, @Nonnull CancellationToken token) { return Optional.ofNullable(call("provideCodeLenses", null /*union*/, model, token)); }

 	/**
	 * See {@code monaco.d.ts:5994:23}<br>
	 * Original signature:<br>
	 * {@code resolveCodeLens?(model: editor.ITextModel, codeLens: CodeLens, token: CancellationToken): ProviderResult<CodeLens>; }<br>
	 */
	public Optional<JsUnion2<CodeLens, JsPromise<CodeLens>>> resolveCodeLens(@Nonnull ITextModel model, @Nonnull CodeLens codeLens, @Nonnull CancellationToken token) { return Optional.ofNullable(call("resolveCodeLens", null /*union*/, model, codeLens, token)); }

 
}
