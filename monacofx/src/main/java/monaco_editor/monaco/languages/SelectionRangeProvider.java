
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
 * See {@code monaco.d.ts:5861:43}<br>
 * Original signature:<br>
 * {@code export interface SelectionRangeProvider  }<br>
 */
@SuppressWarnings("unused")
public class SelectionRangeProvider extends JsProxy {

	public SelectionRangeProvider(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public SelectionRangeProvider(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Provide ranges that should be selected from the given position.</p>
	 * See {@code monaco.d.ts:5865:30}<br>
	 * Original signature:<br>
	 * {@code provideSelectionRanges(model: editor.ITextModel, positions: Position[], token: CancellationToken): ProviderResult<SelectionRange[][]>; }<br>
	 */
	public Optional<JsUnion2<List<List<SelectionRange>>, JsPromise<List<List<SelectionRange>>>>> provideSelectionRanges(@Nonnull ITextModel model, @Nonnull List<Position> positions, @Nonnull CancellationToken token) { return Optional.ofNullable(call("provideSelectionRanges", null /*union*/, model, positions, token)); }

 
}
