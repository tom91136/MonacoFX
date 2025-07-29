
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import monaco_editor.monaco.IRange;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>A document highlight is a range inside a text document which deserves
 * special attention. Usually a document highlight is visualized by changing
 * the background color of its range.</p>
 * See {@code monaco.d.ts:5512:38}<br>
 * Original signature:<br>
 * {@code export interface DocumentHighlight  }<br>
 */
@SuppressWarnings("unused")
public class DocumentHighlight extends JsProxy {

	public DocumentHighlight(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public DocumentHighlight(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>The highlight kind, default is <a href="#DocumentHighlightKind.Text">text</a>.</p>
	 * See {@code monaco.d.ts:5520:12}<br>
	 * Original signature:<br>
	 * {@code kind?: DocumentHighlightKind; }<br>
	 */
	public DocumentHighlightKind kind() { return get("kind", ofJsEnum(DocumentHighlightKind.class)); }

 	/**
	 * <p>The highlight kind, default is <a href="#DocumentHighlightKind.Text">text</a>.</p>
	 * See {@code monaco.d.ts:5520:12}<br>
	 * Original signature:<br>
	 * {@code kind?: DocumentHighlightKind; }<br>
	 */
	public DocumentHighlight kind(@Nonnull DocumentHighlightKind value) {
		set("kind", value);
		return this;
	}

 	/**
	 * <p>The range this highlight applies to.</p>
	 * See {@code monaco.d.ts:5516:13}<br>
	 * Original signature:<br>
	 * {@code range: IRange; }<br>
	 */
	public IRange range() { return get("range", IRange::new); }

 	/**
	 * <p>The range this highlight applies to.</p>
	 * See {@code monaco.d.ts:5516:13}<br>
	 * Original signature:<br>
	 * {@code range: IRange; }<br>
	 */
	public DocumentHighlight range(@Nonnull IRange value) {
		set("range", value);
		return this;
	}

 
}
