
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>Describes folding rules for a language.</p>
 * See {@code monaco.d.ts:5019:33}<br>
 * Original signature:<br>
 * {@code export interface FoldingRules  }<br>
 */
@SuppressWarnings("unused")
public class FoldingRules extends JsProxy {

	public FoldingRules(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public FoldingRules(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Region markers used by the language.</p>
	 * See {@code monaco.d.ts:5030:15}<br>
	 * Original signature:<br>
	 * {@code markers?: FoldingMarkers; }<br>
	 */
	public FoldingMarkers markers() { return get("markers", FoldingMarkers::new); }

 	/**
	 * <p>Region markers used by the language.</p>
	 * See {@code monaco.d.ts:5030:15}<br>
	 * Original signature:<br>
	 * {@code markers?: FoldingMarkers; }<br>
	 */
	public FoldingRules markers(@Nonnull FoldingMarkers value) {
		set("markers", value);
		return this;
	}

 	/**
	 * <p>Used by the indentation based strategy to decide whether empty lines belong to the previous or the next block.
	 * A language adheres to the off-side rule if blocks in that language are expressed by their indentation.
	 * See <a href="https://en.wikipedia.org/wiki/Off-side_rule">wikipedia</a> for more information.
	 * If not set, <code>false</code> is used and empty lines belong to the previous block.</p>
	 * See {@code monaco.d.ts:5026:15}<br>
	 * Original signature:<br>
	 * {@code offSide?: boolean; }<br>
	 */
	public boolean offSide() { return get("offSide", ofMapped(boolean.class)); }

 	/**
	 * <p>Used by the indentation based strategy to decide whether empty lines belong to the previous or the next block.
	 * A language adheres to the off-side rule if blocks in that language are expressed by their indentation.
	 * See <a href="https://en.wikipedia.org/wiki/Off-side_rule">wikipedia</a> for more information.
	 * If not set, <code>false</code> is used and empty lines belong to the previous block.</p>
	 * See {@code monaco.d.ts:5026:15}<br>
	 * Original signature:<br>
	 * {@code offSide?: boolean; }<br>
	 */
	public FoldingRules offSide(@Nonnull Boolean value) {
		set("offSide", value);
		return this;
	}

 
}
