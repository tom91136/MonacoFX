
package monaco_editor.monaco.languages;
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
 * <p>The hover provider interface defines the contract between extensions and
 * the <a href="https://code.visualstudio.com/docs/editor/intellisense">hover</a>-feature.</p>
 * See {@code monaco.d.ts:5165:34}<br>
 * Original signature:<br>
 * {@code export interface HoverProvider  }<br>
 */
@SuppressWarnings("unused")
public class HoverProvider extends JsProxy {

	public HoverProvider(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public HoverProvider(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Provide a hover for the given position and document. Multiple hovers at the same
	 * position will be merged by the editor. A hover can have a range which defaults
	 * to the word range at the position when omitted.</p>
	 * See {@code monaco.d.ts:5171:20}<br>
	 * Original signature:<br>
	 * {@code provideHover(model: editor.ITextModel, position: Position, token: CancellationToken): ProviderResult<Hover>; }<br>
	 */
	public Optional<JsUnion2<Hover, JsPromise<Hover>>> provideHover(@Nonnull ITextModel model, @Nonnull Position position, @Nonnull CancellationToken token) { return Optional.ofNullable(call("provideHover", null /*union*/, model, position, token)); }

 
}
