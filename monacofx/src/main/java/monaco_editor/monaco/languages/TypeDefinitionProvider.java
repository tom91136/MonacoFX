
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
 * <p>The type definition provider interface defines the contract between extensions and
 * the go to type definition feature.</p>
 * See {@code monaco.d.ts:5633:43}<br>
 * Original signature:<br>
 * {@code export interface TypeDefinitionProvider  }<br>
 */
@SuppressWarnings("unused")
public class TypeDefinitionProvider extends JsProxy {

	public TypeDefinitionProvider(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public TypeDefinitionProvider(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Provide the type definition of the symbol at the given position and document.</p>
	 * See {@code monaco.d.ts:5637:29}<br>
	 * Original signature:<br>
	 * {@code provideTypeDefinition(model: editor.ITextModel, position: Position, token: CancellationToken): ProviderResult<Definition | LocationLink[]>; }<br>
	 */
	public Optional<JsUnion4<Location, List<Location>, List<LocationLink>, JsPromise<JsUnion3<Location, List<Location>, List<LocationLink>>>>> provideTypeDefinition(@Nonnull ITextModel model, @Nonnull Position position, @Nonnull CancellationToken token) { return Optional.ofNullable(call("provideTypeDefinition", null /*union*/, model, position, token)); }

 
}
