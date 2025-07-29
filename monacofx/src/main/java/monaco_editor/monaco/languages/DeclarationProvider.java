
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
import net.kurobako.monacofx.js.JsUnion3;
import net.kurobako.monacofx.js.JsUnion4;

/**
 * <p>The definition provider interface defines the contract between extensions and
 * the <a href="https://code.visualstudio.com/docs/editor/editingevolved#_go-to-definition">go to definition</a>
 * and peek definition features.</p>
 * See {@code monaco.d.ts:5611:40}<br>
 * Original signature:<br>
 * {@code export interface DeclarationProvider  }<br>
 */
@SuppressWarnings("unused")
public class DeclarationProvider extends JsProxy {

	public DeclarationProvider(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public DeclarationProvider(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Provide the declaration of the symbol at the given position and document.</p>
	 * See {@code monaco.d.ts:5615:26}<br>
	 * Original signature:<br>
	 * {@code provideDeclaration(model: editor.ITextModel, position: Position, token: CancellationToken): ProviderResult<Definition | LocationLink[]>; }<br>
	 */
	public Optional<JsUnion4<Location, List<Location>, List<LocationLink>, JsPromise<JsUnion3<Location, List<Location>, List<LocationLink>>>>> provideDeclaration(@Nonnull ITextModel model, @Nonnull Position position, @Nonnull CancellationToken token) { return Optional.ofNullable(call("provideDeclaration", null /*union*/, model, position, token)); }

 
}
