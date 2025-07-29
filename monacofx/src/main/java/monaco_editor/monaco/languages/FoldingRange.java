
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:5881:33}<br>
 * Original signature:<br>
 * {@code export interface FoldingRange  }<br>
 */
@SuppressWarnings("unused")
public class FoldingRange extends JsProxy {

	public FoldingRange(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public FoldingRange(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>The one-based end line of the range to fold. The folded area ends with the line's last character.</p>
	 * See {@code monaco.d.ts:5889:11}<br>
	 * Original signature:<br>
	 * {@code end: number; }<br>
	 */
	public double end() { return get("end", ofMapped(double.class)); }

 	/**
	 * <p>The one-based end line of the range to fold. The folded area ends with the line's last character.</p>
	 * See {@code monaco.d.ts:5889:11}<br>
	 * Original signature:<br>
	 * {@code end: number; }<br>
	 */
	public FoldingRange end(@Nonnull Double value) {
		set("end", value);
		return this;
	}

 	/**
	 * <p>Describes the <a href="#FoldingRangeKind">Kind</a> of the folding range such as <a href="#FoldingRangeKind.Comment">Comment</a> or
	 * <a href="#FoldingRangeKind.Region">Region</a>. The kind is used to categorize folding ranges and used by commands
	 * like 'Fold all comments'. See
	 * <a href="#FoldingRangeKind">FoldingRangeKind</a> for an enumeration of standardized kinds.</p>
	 * See {@code monaco.d.ts:5896:12}<br>
	 * Original signature:<br>
	 * {@code kind?: FoldingRangeKind; }<br>
	 */
	public FoldingRangeKind kind() { return get("kind", FoldingRangeKind::new); }

 	/**
	 * <p>Describes the <a href="#FoldingRangeKind">Kind</a> of the folding range such as <a href="#FoldingRangeKind.Comment">Comment</a> or
	 * <a href="#FoldingRangeKind.Region">Region</a>. The kind is used to categorize folding ranges and used by commands
	 * like 'Fold all comments'. See
	 * <a href="#FoldingRangeKind">FoldingRangeKind</a> for an enumeration of standardized kinds.</p>
	 * See {@code monaco.d.ts:5896:12}<br>
	 * Original signature:<br>
	 * {@code kind?: FoldingRangeKind; }<br>
	 */
	public FoldingRange kind(@Nonnull FoldingRangeKind value) {
		set("kind", value);
		return this;
	}

 	/**
	 * <p>The one-based start line of the range to fold. The folded area starts after the line's last character.</p>
	 * See {@code monaco.d.ts:5885:13}<br>
	 * Original signature:<br>
	 * {@code start: number; }<br>
	 */
	public double start() { return get("start", ofMapped(double.class)); }

 	/**
	 * <p>The one-based start line of the range to fold. The folded area starts after the line's last character.</p>
	 * See {@code monaco.d.ts:5885:13}<br>
	 * Original signature:<br>
	 * {@code start: number; }<br>
	 */
	public FoldingRange start(@Nonnull Double value) {
		set("start", value);
		return this;
	}

 
}
