
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
 * <p>The reference provider interface defines the contract between extensions and
 * the <a href="https://code.visualstudio.com/docs/editor/editingevolved#_peek">find references</a>-feature.</p>
 * See {@code monaco.d.ts:5550:38}<br>
 * Original signature:<br>
 * {@code export interface ReferenceProvider  }<br>
 */
@SuppressWarnings("unused")
public class ReferenceProvider extends JsProxy {

	public ReferenceProvider(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public ReferenceProvider(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Provide a set of project-wide references for the given position and document.</p>
	 * See {@code monaco.d.ts:5554:25}<br>
	 * Original signature:<br>
	 * {@code provideReferences(model: editor.ITextModel, position: Position, context: ReferenceContext, token: CancellationToken): ProviderResult<Location[]>; }<br>
	 */
	public Optional<JsUnion2<List<Location>, JsPromise<List<Location>>>> provideReferences(@Nonnull ITextModel model, @Nonnull Position position, @Nonnull ReferenceContext context, @Nonnull CancellationToken token) { return Optional.ofNullable(call("provideReferences", null /*union*/, model, position, context, token)); }

 
}
