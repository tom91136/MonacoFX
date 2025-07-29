
package monaco_editor.monaco.languages;
import java.util.List;
import javax.annotation.Nonnull;
import monaco_editor.monaco.editor.IMarkerData;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>Contains additional diagnostic information about the context in which
 * a <a href="#CodeActionProvider.provideCodeActions">code action</a> is run.</p>
 * See {@code monaco.d.ts:4886:38}<br>
 * Original signature:<br>
 * {@code export interface CodeActionContext  }<br>
 */
@SuppressWarnings("unused")
public class CodeActionContext extends JsProxy {

	public CodeActionContext(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public CodeActionContext(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>An array of diagnostics.</p>
	 * See {@code monaco.d.ts:4890:24}<br>
	 * Original signature:<br>
	 * {@code readonly markers: editor.IMarkerData[]; }<br>
	 */
	public List<IMarkerData> markers() { return get("markers", ofArray(IMarkerData::new)); }

 	/**
	 * <p>Requested kind of actions to return.</p>
	 * See {@code monaco.d.ts:4894:21}<br>
	 * Original signature:<br>
	 * {@code readonly only?: string; }<br>
	 */
	public String only() { return get("only", ofMapped(String.class)); }

 
}
