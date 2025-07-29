
package monaco_editor.monaco.languages;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import monaco_editor.monaco.CancellationToken;
import monaco_editor.monaco.editor.ITextModel;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsPromise;
import net.kurobako.monacofx.js.JsProxy;
import net.kurobako.monacofx.js.JsUnion2;

/**
 * <p>A provider of colors for editor models.</p>
 * See {@code monaco.d.ts:5874:41}<br>
 * Original signature:<br>
 * {@code export interface FoldingRangeProvider  }<br>
 */
@SuppressWarnings("unused")
public class FoldingRangeProvider extends JsProxy {

	public FoldingRangeProvider(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public FoldingRangeProvider(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Provides the color ranges for a specific model.</p>
	 * See {@code monaco.d.ts:5878:28}<br>
	 * Original signature:<br>
	 * {@code provideFoldingRanges(model: editor.ITextModel, context: FoldingContext, token: CancellationToken): ProviderResult<FoldingRange[]>; }<br>
	 */
	public Optional<JsUnion2<List<FoldingRange>, JsPromise<List<FoldingRange>>>> provideFoldingRanges(@Nonnull ITextModel model, @Nonnull FoldingContext context, @Nonnull CancellationToken token) { return Optional.ofNullable(call("provideFoldingRanges", null /*union*/, model, context, token)); }

 
}
