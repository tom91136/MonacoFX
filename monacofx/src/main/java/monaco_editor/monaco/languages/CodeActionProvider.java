
package monaco_editor.monaco.languages;
import java.util.Optional;
import javax.annotation.Nonnull;
import monaco_editor.monaco.CancellationToken;
import monaco_editor.monaco.Range;
import monaco_editor.monaco.editor.ITextModel;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsPromise;
import net.kurobako.monacofx.js.JsProxy;
import net.kurobako.monacofx.js.JsUnion2;

/**
 * <p>The code action interface defines the contract between extensions and
 * the <a href="https://code.visualstudio.com/docs/editor/editingevolved#_code-action">light bulb</a> feature.</p>
 * See {@code monaco.d.ts:4901:39}<br>
 * Original signature:<br>
 * {@code export interface CodeActionProvider  }<br>
 */
@SuppressWarnings("unused")
public class CodeActionProvider extends JsProxy {

	public CodeActionProvider(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public CodeActionProvider(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Provide commands for the given document and range.</p>
	 * See {@code monaco.d.ts:4905:26}<br>
	 * Original signature:<br>
	 * {@code provideCodeActions(model: editor.ITextModel, range: Range, context: CodeActionContext, token: CancellationToken): ProviderResult<CodeActionList>; }<br>
	 */
	public Optional<JsUnion2<CodeActionList, JsPromise<CodeActionList>>> provideCodeActions(@Nonnull ITextModel model, @Nonnull Range range, @Nonnull CodeActionContext context, @Nonnull CancellationToken token) { return Optional.ofNullable(call("provideCodeActions", null /*union*/, model, range, context, token)); }

 
}
