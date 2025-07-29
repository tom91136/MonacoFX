
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>Configuration options for quick suggestions</p>
 * See {@code monaco.d.ts:3390:45}<br>
 * Original signature:<br>
 * {@code export interface IQuickSuggestionsOptions  }<br>
 */
@SuppressWarnings("unused")
public class IQuickSuggestionsOptions extends JsProxy {

	public IQuickSuggestionsOptions(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IQuickSuggestionsOptions(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:3392:16}<br>
	 * Original signature:<br>
	 * {@code comments: boolean; }<br>
	 */
	public boolean comments() { return get("comments", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:3392:16}<br>
	 * Original signature:<br>
	 * {@code comments: boolean; }<br>
	 */
	public IQuickSuggestionsOptions comments(@Nonnull Boolean value) {
		set("comments", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:3391:13}<br>
	 * Original signature:<br>
	 * {@code other: boolean; }<br>
	 */
	public boolean other() { return get("other", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:3391:13}<br>
	 * Original signature:<br>
	 * {@code other: boolean; }<br>
	 */
	public IQuickSuggestionsOptions other(@Nonnull Boolean value) {
		set("other", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:3393:15}<br>
	 * Original signature:<br>
	 * {@code strings: boolean; }<br>
	 */
	public boolean strings() { return get("strings", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:3393:15}<br>
	 * Original signature:<br>
	 * {@code strings: boolean; }<br>
	 */
	public IQuickSuggestionsOptions strings(@Nonnull Boolean value) {
		set("strings", value);
		return this;
	}

 
}
