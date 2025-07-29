
package monaco_editor.monaco.languages;
import java.util.Optional;
import javax.annotation.Nonnull;
import monaco_editor.monaco.CancellationToken;
import monaco_editor.monaco.editor.ITextModel;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsPromise;
import net.kurobako.monacofx.js.JsProxy;
import net.kurobako.monacofx.js.JsUnion2;
import netscape.javascript.JSObject;

/**
 * <p>A provider of links.</p>
 * See {@code monaco.d.ts:5780:33}<br>
 * Original signature:<br>
 * {@code export interface LinkProvider  }<br>
 */
@SuppressWarnings("unused")
public class LinkProvider extends JsProxy {

	public LinkProvider(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public LinkProvider(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5782:19}<br>
	 * Original signature:<br>
	 * {@code resolveLink?: (link: ILink, token: CancellationToken) => ProviderResult<ILink>; }<br>
	 */
	public JSObject resolveLink() { return get("resolveLink", ofMapped(JSObject.class)); }

 	/**
	 * See {@code monaco.d.ts:5782:19}<br>
	 * Original signature:<br>
	 * {@code resolveLink?: (link: ILink, token: CancellationToken) => ProviderResult<ILink>; }<br>
	 */
	public LinkProvider resolveLink(@Nonnull JSObject value) {
		set("resolveLink", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5781:20}<br>
	 * Original signature:<br>
	 * {@code provideLinks(model: editor.ITextModel, token: CancellationToken): ProviderResult<ILinksList>; }<br>
	 */
	public Optional<JsUnion2<ILinksList, JsPromise<ILinksList>>> provideLinks(@Nonnull ITextModel model, @Nonnull CancellationToken token) { return Optional.ofNullable(call("provideLinks", null /*union*/, model, token)); }

 
}
