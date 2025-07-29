
package monaco_editor.monaco.editor;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import monaco_editor.monaco.Range;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:1540:26}<br>
 * Original signature:<br>
 * {@code export class FindMatch  }<br>
 */
@SuppressWarnings("unused")
public class FindMatch extends JsProxy {

	public FindMatch(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public FindMatch(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:1543:24}<br>
	 * Original signature:<br>
	 * {@code readonly matches: string[] | null; }<br>
	 */
	public Optional<List<String>> matches() { return Optional.ofNullable(get("matches", ofArray(ofMapped(String.class)))); }

 	/**
	 * See {@code monaco.d.ts:1542:22}<br>
	 * Original signature:<br>
	 * {@code readonly range: Range; }<br>
	 */
	public Range range() { return get("range", Range::new); }

 
}
