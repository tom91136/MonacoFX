
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import monaco_editor.monaco.Uri;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import netscape.javascript.JSObject;

/**
 * See {@code monaco.d.ts:5948:38}<br>
 * Original signature:<br>
 * {@code export interface WorkspaceTextEdit  }<br>
 */
@SuppressWarnings("unused")
public class WorkspaceTextEdit extends JsProxy {

	public WorkspaceTextEdit(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public WorkspaceTextEdit(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5950:12}<br>
	 * Original signature:<br>
	 * {@code edit: TextEdit; }<br>
	 */
	public JSObject edit() { return get("edit", ofMapped(JSObject.class)); }

 	/**
	 * See {@code monaco.d.ts:5950:12}<br>
	 * Original signature:<br>
	 * {@code edit: TextEdit; }<br>
	 */
	public WorkspaceTextEdit edit(@Nonnull JSObject value) {
		set("edit", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5952:16}<br>
	 * Original signature:<br>
	 * {@code metadata?: WorkspaceEditMetadata; }<br>
	 */
	public WorkspaceEditMetadata metadata() { return get("metadata", WorkspaceEditMetadata::new); }

 	/**
	 * See {@code monaco.d.ts:5952:16}<br>
	 * Original signature:<br>
	 * {@code metadata?: WorkspaceEditMetadata; }<br>
	 */
	public WorkspaceTextEdit metadata(@Nonnull WorkspaceEditMetadata value) {
		set("metadata", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5951:22}<br>
	 * Original signature:<br>
	 * {@code modelVersionId?: number; }<br>
	 */
	public double modelVersionId() { return get("modelVersionId", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:5951:22}<br>
	 * Original signature:<br>
	 * {@code modelVersionId?: number; }<br>
	 */
	public WorkspaceTextEdit modelVersionId(@Nonnull Double value) {
		set("modelVersionId", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5949:16}<br>
	 * Original signature:<br>
	 * {@code resource: Uri; }<br>
	 */
	public Uri resource() { return get("resource", Uri::new); }

 	/**
	 * See {@code monaco.d.ts:5949:16}<br>
	 * Original signature:<br>
	 * {@code resource: Uri; }<br>
	 */
	public WorkspaceTextEdit resource(@Nonnull Uri value) {
		set("resource", value);
		return this;
	}

 
}
