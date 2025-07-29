
package monaco_editor.monaco.languages;
import java.util.List;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:5328:35}<br>
 * Original signature:<br>
 * {@code export interface CompletionList  }<br>
 */
@SuppressWarnings("unused")
public class CompletionList extends JsProxy {

	public CompletionList(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public CompletionList(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5330:18}<br>
	 * Original signature:<br>
	 * {@code incomplete?: boolean; }<br>
	 */
	public boolean incomplete() { return get("incomplete", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:5330:18}<br>
	 * Original signature:<br>
	 * {@code incomplete?: boolean; }<br>
	 */
	public CompletionList incomplete(@Nonnull Boolean value) {
		set("incomplete", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5329:19}<br>
	 * Original signature:<br>
	 * {@code suggestions: CompletionItem[]; }<br>
	 */
	public List<CompletionItem> suggestions() { return get("suggestions", ofArray(CompletionItem::new)); }

 	/**
	 * See {@code monaco.d.ts:5329:19}<br>
	 * Original signature:<br>
	 * {@code suggestions: CompletionItem[]; }<br>
	 */
	public CompletionList suggestions(@Nonnull List<CompletionItem> value) {
		
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5331:15}<br>
	 * Original signature:<br>
	 * {@code dispose?(): void; }<br>
	 */
	public void dispose() { call("dispose", ofVoid()); }

 
}
