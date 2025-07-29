
package monaco_editor.monaco.languages.html;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:6803:28}<br>
 * Original signature:<br>
 * {@code export interface Options  }<br>
 */
@SuppressWarnings("unused")
public class Options extends JsProxy {

	public Options(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public Options(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>If set, comments are tolerated. If set to false, syntax errors will be emitted for comments.</p>
	 * See {@code monaco.d.ts:6807:23}<br>
	 * Original signature:<br>
	 * {@code readonly format?: HTMLFormatConfiguration; }<br>
	 */
	public HTMLFormatConfiguration format() { return get("format", HTMLFormatConfiguration::new); }

 	/**
	 * <p>A list of known schemas and/or associations of schemas to file names.</p>
	 * See {@code monaco.d.ts:6811:24}<br>
	 * Original signature:<br>
	 * {@code readonly suggest?: CompletionConfiguration; }<br>
	 */
	public CompletionConfiguration suggest() { return get("suggest", CompletionConfiguration::new); }

 
}
