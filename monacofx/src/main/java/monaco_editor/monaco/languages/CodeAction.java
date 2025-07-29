
package monaco_editor.monaco.languages;
import java.util.List;
import javax.annotation.Nonnull;
import monaco_editor.monaco.editor.IMarkerData;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:5386:31}<br>
 * Original signature:<br>
 * {@code export interface CodeAction  }<br>
 */
@SuppressWarnings("unused")
public class CodeAction extends JsProxy {

	public CodeAction(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public CodeAction(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5388:15}<br>
	 * Original signature:<br>
	 * {@code command?: Command; }<br>
	 */
	public Command command() { return get("command", Command::new); }

 	/**
	 * See {@code monaco.d.ts:5388:15}<br>
	 * Original signature:<br>
	 * {@code command?: Command; }<br>
	 */
	public CodeAction command(@Nonnull Command value) {
		set("command", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5390:19}<br>
	 * Original signature:<br>
	 * {@code diagnostics?: editor.IMarkerData[]; }<br>
	 */
	public List<IMarkerData> diagnostics() { return get("diagnostics", ofArray(IMarkerData::new)); }

 	/**
	 * See {@code monaco.d.ts:5390:19}<br>
	 * Original signature:<br>
	 * {@code diagnostics?: editor.IMarkerData[]; }<br>
	 */
	public CodeAction diagnostics(@Nonnull List<IMarkerData> value) {
		
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5393:16}<br>
	 * Original signature:<br>
	 * {@code disabled?: string; }<br>
	 */
	public String disabled() { return get("disabled", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:5393:16}<br>
	 * Original signature:<br>
	 * {@code disabled?: string; }<br>
	 */
	public CodeAction disabled(@Nonnull String value) {
		set("disabled", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5389:12}<br>
	 * Original signature:<br>
	 * {@code edit?: WorkspaceEdit; }<br>
	 */
	public WorkspaceEdit edit() { return get("edit", WorkspaceEdit::new); }

 	/**
	 * See {@code monaco.d.ts:5389:12}<br>
	 * Original signature:<br>
	 * {@code edit?: WorkspaceEdit; }<br>
	 */
	public CodeAction edit(@Nonnull WorkspaceEdit value) {
		set("edit", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5392:19}<br>
	 * Original signature:<br>
	 * {@code isPreferred?: boolean; }<br>
	 */
	public boolean isPreferred() { return get("isPreferred", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:5392:19}<br>
	 * Original signature:<br>
	 * {@code isPreferred?: boolean; }<br>
	 */
	public CodeAction isPreferred(@Nonnull Boolean value) {
		set("isPreferred", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5391:12}<br>
	 * Original signature:<br>
	 * {@code kind?: string; }<br>
	 */
	public String kind() { return get("kind", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:5391:12}<br>
	 * Original signature:<br>
	 * {@code kind?: string; }<br>
	 */
	public CodeAction kind(@Nonnull String value) {
		set("kind", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5387:13}<br>
	 * Original signature:<br>
	 * {@code title: string; }<br>
	 */
	public String title() { return get("title", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:5387:13}<br>
	 * Original signature:<br>
	 * {@code title: string; }<br>
	 */
	public CodeAction title(@Nonnull String value) {
		set("title", value);
		return this;
	}

 
}
