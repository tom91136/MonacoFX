
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
 * See {@code monaco.d.ts:5599:39}<br>
 * Original signature:<br>
 * {@code export interface DefinitionProvider  }<br>
 */
@SuppressWarnings("unused")
public class DefinitionProvider extends JsProxy {

	public DefinitionProvider(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public DefinitionProvider(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Provide the definition of the symbol at the given position and document.</p>
	 * See {@code monaco.d.ts:5603:25}<br>
	 * Original signature:<br>
	 * {@code provideDefinition(model: editor.ITextModel, position: Position, token: CancellationToken): ProviderResult<Definition | LocationLink[]>; }<br>
	 */
	public Optional<JsUnion4<Location, List<Location>, List<LocationLink>, JsPromise<JsUnion3<Location, List<Location>, List<LocationLink>>>>> provideDefinition(@Nonnull ITextModel model, @Nonnull Position position, @Nonnull CancellationToken token) { return Optional.ofNullable(call("provideDefinition", null /*union*/, model, position, token)); }

 
}
