
package monaco_editor.monaco.languages;
import java.util.List;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:5772:31}<br>
 * Original signature:<br>
 * {@code export interface ILinksList  }<br>
 */
@SuppressWarnings("unused")
public class ILinksList extends JsProxy {

	public ILinksList(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public ILinksList(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5773:13}<br>
	 * Original signature:<br>
	 * {@code links: ILink[]; }<br>
	 */
	public List<ILink> links() { return get("links", ofArray(ILink::new)); }

 	/**
	 * See {@code monaco.d.ts:5773:13}<br>
	 * Original signature:<br>
	 * {@code links: ILink[]; }<br>
	 */
	public ILinksList links(@Nonnull List<ILink> value) {
		
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5774:15}<br>
	 * Original signature:<br>
	 * {@code dispose?(): void; }<br>
	 */
	public void dispose() { call("dispose", ofVoid()); }

 
}
