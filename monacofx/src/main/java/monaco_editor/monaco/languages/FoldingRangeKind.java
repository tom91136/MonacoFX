
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:5899:33}<br>
 * Original signature:<br>
 * {@code export class FoldingRangeKind  }<br>
 */
@SuppressWarnings("unused")
public class FoldingRangeKind extends JsProxy {

	public FoldingRangeKind(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public FoldingRangeKind(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5900:13}<br>
	 * Original signature:<br>
	 * {@code value: string; }<br>
	 */
	public String value() { return get("value", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:5900:13}<br>
	 * Original signature:<br>
	 * {@code value: string; }<br>
	 */
	public FoldingRangeKind value(@Nonnull String value) {
		set("value", value);
		return this;
	}

 	/**
	 * <p>Kind for folding range representing a comment. The value of the kind is 'comment'.</p>
	 * See {@code monaco.d.ts:5904:31}<br>
	 * Original signature:<br>
	 * {@code static readonly Comment: FoldingRangeKind; }<br>
	 */
	public FoldingRangeKind Comment() { return get("Comment", FoldingRangeKind::new); }

 	/**
	 * <p>Kind for folding range representing a import. The value of the kind is 'imports'.</p>
	 * See {@code monaco.d.ts:5908:31}<br>
	 * Original signature:<br>
	 * {@code static readonly Imports: FoldingRangeKind; }<br>
	 */
	public FoldingRangeKind Imports() { return get("Imports", FoldingRangeKind::new); }

 	/**
	 * <p>Kind for folding range representing regions (for example marked by <code>#region</code>, <code>#endregion</code>).
	 * The value of the kind is 'region'.</p>
	 * See {@code monaco.d.ts:5913:30}<br>
	 * Original signature:<br>
	 * {@code static readonly Region: FoldingRangeKind; }<br>
	 */
	public FoldingRangeKind Region() { return get("Region", FoldingRangeKind::new); }

 
}
