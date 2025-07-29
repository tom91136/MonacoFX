
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
 * See {@code monaco.d.ts:5846:42}<br>
 * Original signature:<br>
 * {@code export interface DocumentColorProvider  }<br>
 */
@SuppressWarnings("unused")
public class DocumentColorProvider extends JsProxy {

	public DocumentColorProvider(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public DocumentColorProvider(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Provide the string representations for a color.</p>
	 * See {@code monaco.d.ts:5854:33}<br>
	 * Original signature:<br>
	 * {@code provideColorPresentations(model: editor.ITextModel, colorInfo: IColorInformation, token: CancellationToken): ProviderResult<IColorPresentation[]>; }<br>
	 */
	public Optional<JsUnion2<List<IColorPresentation>, JsPromise<List<IColorPresentation>>>> provideColorPresentations(@Nonnull ITextModel model, @Nonnull IColorInformation colorInfo, @Nonnull CancellationToken token) { return Optional.ofNullable(call("provideColorPresentations", null /*union*/, model, colorInfo, token)); }

 	/**
	 * <p>Provides the color ranges for a specific model.</p>
	 * See {@code monaco.d.ts:5850:29}<br>
	 * Original signature:<br>
	 * {@code provideDocumentColors(model: editor.ITextModel, token: CancellationToken): ProviderResult<IColorInformation[]>; }<br>
	 */
	public Optional<JsUnion2<List<IColorInformation>, JsPromise<List<IColorInformation>>>> provideDocumentColors(@Nonnull ITextModel model, @Nonnull CancellationToken token) { return Optional.ofNullable(call("provideDocumentColors", null /*union*/, model, token)); }

 
}
