
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

/**
 * <p>The signature help provider interface defines the contract between extensions and
 * the <a href="https://code.visualstudio.com/docs/editor/intellisense">parameter hints</a>-feature.</p>
 * See {@code monaco.d.ts:5480:42}<br>
 * Original signature:<br>
 * {@code export interface SignatureHelpProvider  }<br>
 */
@SuppressWarnings("unused")
public class SignatureHelpProvider extends JsProxy {

	public SignatureHelpProvider(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public SignatureHelpProvider(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5482:49}<br>
	 * Original signature:<br>
	 * {@code readonly signatureHelpRetriggerCharacters?: ReadonlyArray<string>; }<br>
	 */
	public List<String> signatureHelpRetriggerCharacters() { return get("signatureHelpRetriggerCharacters", ofArray(ofMapped(String.class))); }

 	/**
	 * See {@code monaco.d.ts:5481:47}<br>
	 * Original signature:<br>
	 * {@code readonly signatureHelpTriggerCharacters?: ReadonlyArray<string>; }<br>
	 */
	public List<String> signatureHelpTriggerCharacters() { return get("signatureHelpTriggerCharacters", ofArray(ofMapped(String.class))); }

 	/**
	 * <p>Provide help for the signature at the given position and document.</p>
	 * See {@code monaco.d.ts:5486:28}<br>
	 * Original signature:<br>
	 * {@code provideSignatureHelp(model: editor.ITextModel, position: Position, token: CancellationToken, context: SignatureHelpContext): ProviderResult<SignatureHelpResult>; }<br>
	 */
	public Optional<JsUnion2<SignatureHelpResult, JsPromise<SignatureHelpResult>>> provideSignatureHelp(@Nonnull ITextModel model, @Nonnull Position position, @Nonnull CancellationToken token, @Nonnull SignatureHelpContext context) { return Optional.ofNullable(call("provideSignatureHelp", null /*union*/, model, position, token, context)); }

 
}
