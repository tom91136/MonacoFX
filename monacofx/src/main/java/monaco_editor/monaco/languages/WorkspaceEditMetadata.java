
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import netscape.javascript.JSObject;

/**
 * See {@code monaco.d.ts:5922:42}<br>
 * Original signature:<br>
 * {@code export interface WorkspaceEditMetadata  }<br>
 */
@SuppressWarnings("unused")
public class WorkspaceEditMetadata extends JsProxy {

	public WorkspaceEditMetadata(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public WorkspaceEditMetadata(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5925:19}<br>
	 * Original signature:<br>
	 * {@code description?: string; }<br>
	 */
	public String description() { return get("description", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:5925:19}<br>
	 * Original signature:<br>
	 * {@code description?: string; }<br>
	 */
	public WorkspaceEditMetadata description(@Nonnull String value) {
		set("description", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5926:16}<br>
	 * Original signature:<br>
	 * {@code iconPath?:  }<br>
	 */
	public JSObject iconPath() { return get("iconPath", ofMapped(JSObject.class)); }

 	/**
	 * See {@code monaco.d.ts:5926:16}<br>
	 * Original signature:<br>
	 * {@code iconPath?:  }<br>
	 */
	public WorkspaceEditMetadata iconPath(@Nonnull JSObject value) {
		set("iconPath", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5924:13}<br>
	 * Original signature:<br>
	 * {@code label: string; }<br>
	 */
	public String label() { return get("label", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:5924:13}<br>
	 * Original signature:<br>
	 * {@code label: string; }<br>
	 */
	public WorkspaceEditMetadata label(@Nonnull String value) {
		set("label", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5923:25}<br>
	 * Original signature:<br>
	 * {@code needsConfirmation: boolean; }<br>
	 */
	public boolean needsConfirmation() { return get("needsConfirmation", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:5923:25}<br>
	 * Original signature:<br>
	 * {@code needsConfirmation: boolean; }<br>
	 */
	public WorkspaceEditMetadata needsConfirmation(@Nonnull Boolean value) {
		set("needsConfirmation", value);
		return this;
	}

 
}
