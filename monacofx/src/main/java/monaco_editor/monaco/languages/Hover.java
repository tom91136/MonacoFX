
package monaco_editor.monaco.languages;
import java.util.List;
import javax.annotation.Nonnull;
import monaco_editor.monaco.IMarkdownString;
import monaco_editor.monaco.IRange;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>A hover represents additional information for a symbol or word. Hovers are
 * rendered in a tooltip-like widget.</p>
 * See {@code monaco.d.ts:5148:26}<br>
 * Original signature:<br>
 * {@code export interface Hover  }<br>
 */
@SuppressWarnings("unused")
public class Hover extends JsProxy {

	public Hover(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public Hover(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>The contents of this hover.</p>
	 * See {@code monaco.d.ts:5152:16}<br>
	 * Original signature:<br>
	 * {@code contents: IMarkdownString[]; }<br>
	 */
	public List<IMarkdownString> contents() { return get("contents", ofArray(IMarkdownString::new)); }

 	/**
	 * <p>The contents of this hover.</p>
	 * See {@code monaco.d.ts:5152:16}<br>
	 * Original signature:<br>
	 * {@code contents: IMarkdownString[]; }<br>
	 */
	public Hover contents(@Nonnull List<IMarkdownString> value) {
		
		return this;
	}

 	/**
	 * <p>The range to which this hover applies. When missing, the
	 * editor will use the range at the current position or the
	 * current position itself.</p>
	 * See {@code monaco.d.ts:5158:13}<br>
	 * Original signature:<br>
	 * {@code range?: IRange; }<br>
	 */
	public IRange range() { return get("range", IRange::new); }

 	/**
	 * <p>The range to which this hover applies. When missing, the
	 * editor will use the range at the current position or the
	 * current position itself.</p>
	 * See {@code monaco.d.ts:5158:13}<br>
	 * Original signature:<br>
	 * {@code range?: IRange; }<br>
	 */
	public Hover range(@Nonnull IRange value) {
		set("range", value);
		return this;
	}

 
}
