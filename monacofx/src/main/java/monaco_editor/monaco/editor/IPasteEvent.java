
package monaco_editor.monaco.editor;
import java.util.Optional;
import javax.annotation.Nonnull;
import monaco_editor.monaco.Range;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>A paste event originating from the editor.</p>
 * See {@code monaco.d.ts:4195:32}<br>
 * Original signature:<br>
 * {@code export interface IPasteEvent  }<br>
 */
@SuppressWarnings("unused")
public class IPasteEvent extends JsProxy {

	public IPasteEvent(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IPasteEvent(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:4197:21}<br>
	 * Original signature:<br>
	 * {@code readonly mode: string | null; }<br>
	 */
	public Optional<String> mode() { return Optional.ofNullable(get("mode", ofMapped(String.class))); }

 	/**
	 * See {@code monaco.d.ts:4196:22}<br>
	 * Original signature:<br>
	 * {@code readonly range: Range; }<br>
	 */
	public Range range() { return get("range", Range::new); }

 
}
