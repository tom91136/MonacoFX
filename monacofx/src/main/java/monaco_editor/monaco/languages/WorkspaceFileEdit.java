
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import monaco_editor.monaco.Uri;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:5941:38}<br>
 * Original signature:<br>
 * {@code export interface WorkspaceFileEdit  }<br>
 */
@SuppressWarnings("unused")
public class WorkspaceFileEdit extends JsProxy {

	public WorkspaceFileEdit(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public WorkspaceFileEdit(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5945:16}<br>
	 * Original signature:<br>
	 * {@code metadata?: WorkspaceEditMetadata; }<br>
	 */
	public WorkspaceEditMetadata metadata() { return get("metadata", WorkspaceEditMetadata::new); }

 	/**
	 * See {@code monaco.d.ts:5945:16}<br>
	 * Original signature:<br>
	 * {@code metadata?: WorkspaceEditMetadata; }<br>
	 */
	public WorkspaceFileEdit metadata(@Nonnull WorkspaceEditMetadata value) {
		set("metadata", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5943:14}<br>
	 * Original signature:<br>
	 * {@code newUri?: Uri; }<br>
	 */
	public Uri newUri() { return get("newUri", Uri::new); }

 	/**
	 * See {@code monaco.d.ts:5943:14}<br>
	 * Original signature:<br>
	 * {@code newUri?: Uri; }<br>
	 */
	public WorkspaceFileEdit newUri(@Nonnull Uri value) {
		set("newUri", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5942:14}<br>
	 * Original signature:<br>
	 * {@code oldUri?: Uri; }<br>
	 */
	public Uri oldUri() { return get("oldUri", Uri::new); }

 	/**
	 * See {@code monaco.d.ts:5942:14}<br>
	 * Original signature:<br>
	 * {@code oldUri?: Uri; }<br>
	 */
	public WorkspaceFileEdit oldUri(@Nonnull Uri value) {
		set("oldUri", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5944:15}<br>
	 * Original signature:<br>
	 * {@code options?: WorkspaceFileEditOptions; }<br>
	 */
	public WorkspaceFileEditOptions options() { return get("options", WorkspaceFileEditOptions::new); }

 	/**
	 * See {@code monaco.d.ts:5944:15}<br>
	 * Original signature:<br>
	 * {@code options?: WorkspaceFileEditOptions; }<br>
	 */
	public WorkspaceFileEdit options(@Nonnull WorkspaceFileEditOptions value) {
		set("options", value);
		return this;
	}

 
}
