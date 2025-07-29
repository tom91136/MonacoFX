
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
 * <p>The implementation provider interface defines the contract between extensions and
 * the go to implementation feature.</p>
 * See {@code monaco.d.ts:5622:43}<br>
 * Original signature:<br>
 * {@code export interface ImplementationProvider  }<br>
 */
@SuppressWarnings("unused")
public class ImplementationProvider extends JsProxy {

	public ImplementationProvider(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public ImplementationProvider(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Provide the implementation of the symbol at the given position and document.</p>
	 * See {@code monaco.d.ts:5626:29}<br>
	 * Original signature:<br>
	 * {@code provideImplementation(model: editor.ITextModel, position: Position, token: CancellationToken): ProviderResult<Definition | LocationLink[]>; }<br>
	 */
	public Optional<JsUnion4<Location, List<Location>, List<LocationLink>, JsPromise<JsUnion3<Location, List<Location>, List<LocationLink>>>>> provideImplementation(@Nonnull ITextModel model, @Nonnull Position position, @Nonnull CancellationToken token) { return Optional.ofNullable(call("provideImplementation", null /*union*/, model, position, token)); }

 
}
