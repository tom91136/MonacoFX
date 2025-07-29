
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:5203:40}<br>
 * Original signature:<br>
 * {@code export interface CompletionItemLabel  }<br>
 */
@SuppressWarnings("unused")
public class CompletionItemLabel extends JsProxy {

	public CompletionItemLabel(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public CompletionItemLabel(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>The function or variable. Rendered leftmost.</p>
	 * See {@code monaco.d.ts:5207:12}<br>
	 * Original signature:<br>
	 * {@code name: string; }<br>
	 */
	public String name() { return get("name", ofMapped(String.class)); }

 	/**
	 * <p>The function or variable. Rendered leftmost.</p>
	 * See {@code monaco.d.ts:5207:12}<br>
	 * Original signature:<br>
	 * {@code name: string; }<br>
	 */
	public CompletionItemLabel name(@Nonnull String value) {
		set("name", value);
		return this;
	}

 	/**
	 * <p>The fully qualified name, like package name or file path. Rendered after <code>signature</code>.</p>
	 * See {@code monaco.d.ts:5215:17}<br>
	 * Original signature:<br>
	 * {@code qualifier?: string; }<br>
	 */
	public String qualifier() { return get("qualifier", ofMapped(String.class)); }

 	/**
	 * <p>The fully qualified name, like package name or file path. Rendered after <code>signature</code>.</p>
	 * See {@code monaco.d.ts:5215:17}<br>
	 * Original signature:<br>
	 * {@code qualifier?: string; }<br>
	 */
	public CompletionItemLabel qualifier(@Nonnull String value) {
		set("qualifier", value);
		return this;
	}

 	/**
	 * <p>The signature without the return type. Render after <code>name</code>.</p>
	 * See {@code monaco.d.ts:5211:17}<br>
	 * Original signature:<br>
	 * {@code signature?: string; }<br>
	 */
	public String signature() { return get("signature", ofMapped(String.class)); }

 	/**
	 * <p>The signature without the return type. Render after <code>name</code>.</p>
	 * See {@code monaco.d.ts:5211:17}<br>
	 * Original signature:<br>
	 * {@code signature?: string; }<br>
	 */
	public CompletionItemLabel signature(@Nonnull String value) {
		set("signature", value);
		return this;
	}

 	/**
	 * <p>The return-type of a function or type of a property/variable. Rendered rightmost.</p>
	 * See {@code monaco.d.ts:5219:12}<br>
	 * Original signature:<br>
	 * {@code type?: string; }<br>
	 */
	public String type() { return get("type", ofMapped(String.class)); }

 	/**
	 * <p>The return-type of a function or type of a property/variable. Rendered rightmost.</p>
	 * See {@code monaco.d.ts:5219:12}<br>
	 * Original signature:<br>
	 * {@code type?: string; }<br>
	 */
	public CompletionItemLabel type(@Nonnull String value) {
		set("type", value);
		return this;
	}

 
}
