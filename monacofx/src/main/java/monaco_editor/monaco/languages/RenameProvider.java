
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
import net.kurobako.monacofx.js.JsUnion3;

/**
 * See {@code monaco.d.ts:5968:35}<br>
 * Original signature:<br>
 * {@code export interface RenameProvider  }<br>
 */
@SuppressWarnings("unused")
public class RenameProvider extends JsProxy {

	public RenameProvider(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public RenameProvider(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5969:26}<br>
	 * Original signature:<br>
	 * {@code provideRenameEdits(model: editor.ITextModel, position: Position, newName: string, token: CancellationToken): ProviderResult<WorkspaceEdit & Rejection>; }<br>
	 */
	public Optional<JsUnion3<WorkspaceEdit, Rejection, JsPromise<JsUnion2<WorkspaceEdit, Rejection>>>> provideRenameEdits(@Nonnull ITextModel model, @Nonnull Position position, @Nonnull String newName, @Nonnull CancellationToken token) { return Optional.ofNullable(call("provideRenameEdits", null /*union*/, model, position, newName, token)); }

 	/**
	 * See {@code monaco.d.ts:5970:29}<br>
	 * Original signature:<br>
	 * {@code resolveRenameLocation?(model: editor.ITextModel, position: Position, token: CancellationToken): ProviderResult<RenameLocation & Rejection>; }<br>
	 */
	public Optional<JsUnion3<RenameLocation, Rejection, JsPromise<JsUnion2<RenameLocation, Rejection>>>> resolveRenameLocation(@Nonnull ITextModel model, @Nonnull Position position, @Nonnull CancellationToken token) { return Optional.ofNullable(call("resolveRenameLocation", null /*union*/, model, position, token)); }

 
}
