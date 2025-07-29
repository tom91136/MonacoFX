
package monaco_editor.monaco.languages.json;
import java.util.List;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import netscape.javascript.JSObject;

/**
 * See {@code monaco.d.ts:6682:39}<br>
 * Original signature:<br>
 * {@code export interface DiagnosticsOptions  }<br>
 */
@SuppressWarnings("unused")
public class DiagnosticsOptions extends JsProxy {

	public DiagnosticsOptions(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public DiagnosticsOptions(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>If set, comments are tolerated. If set to false, syntax errors will be emitted for comments.</p>
	 * See {@code monaco.d.ts:6690:30}<br>
	 * Original signature:<br>
	 * {@code readonly allowComments?: boolean; }<br>
	 */
	public boolean allowComments() { return get("allowComments", ofMapped(boolean.class)); }

 	/**
	 * <p>If set, the schema service would load schema content on-demand with 'fetch' if available</p>
	 * See {@code monaco.d.ts:6711:36}<br>
	 * Original signature:<br>
	 * {@code readonly enableSchemaRequest?: boolean; }<br>
	 */
	public boolean enableSchemaRequest() { return get("enableSchemaRequest", ofMapped(boolean.class)); }

 	/**
	 * <p>A list of known schemas and/or associations of schemas to file names.</p>
	 * See {@code monaco.d.ts:6694:24}<br>
	 * Original signature:<br>
	 * {@code readonly schemas?:  }<br>
	 */
	public List<JSObject> schemas() { return get("schemas", ofArray(ofMapped(JSObject.class))); }

 	/**
	 * <p>If set, the validator will be enabled and perform syntax validation as well as schema based validation.</p>
	 * See {@code monaco.d.ts:6686:25}<br>
	 * Original signature:<br>
	 * {@code readonly validate?: boolean; }<br>
	 */
	public boolean validate() { return get("validate", ofMapped(boolean.class)); }

 
}
