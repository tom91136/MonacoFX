
package monaco_editor.monaco;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:194:34}<br>
 * Original signature:<br>
 * {@code export interface UriComponents  }<br>
 */
@SuppressWarnings("unused")
public class UriComponents extends JsProxy {

	public UriComponents(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public UriComponents(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:196:17}<br>
	 * Original signature:<br>
	 * {@code authority: string; }<br>
	 */
	public String authority() { return get("authority", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:196:17}<br>
	 * Original signature:<br>
	 * {@code authority: string; }<br>
	 */
	public UriComponents authority(@Nonnull String value) {
		set("authority", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:199:16}<br>
	 * Original signature:<br>
	 * {@code fragment: string; }<br>
	 */
	public String fragment() { return get("fragment", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:199:16}<br>
	 * Original signature:<br>
	 * {@code fragment: string; }<br>
	 */
	public UriComponents fragment(@Nonnull String value) {
		set("fragment", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:197:12}<br>
	 * Original signature:<br>
	 * {@code path: string; }<br>
	 */
	public String path() { return get("path", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:197:12}<br>
	 * Original signature:<br>
	 * {@code path: string; }<br>
	 */
	public UriComponents path(@Nonnull String value) {
		set("path", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:198:13}<br>
	 * Original signature:<br>
	 * {@code query: string; }<br>
	 */
	public String query() { return get("query", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:198:13}<br>
	 * Original signature:<br>
	 * {@code query: string; }<br>
	 */
	public UriComponents query(@Nonnull String value) {
		set("query", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:195:14}<br>
	 * Original signature:<br>
	 * {@code scheme: string; }<br>
	 */
	public String scheme() { return get("scheme", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:195:14}<br>
	 * Original signature:<br>
	 * {@code scheme: string; }<br>
	 */
	public UriComponents scheme(@Nonnull String value) {
		set("scheme", value);
		return this;
	}

 
}
