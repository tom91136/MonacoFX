
package monaco_editor.monaco.languages;
import java.util.List;
import javax.annotation.Nonnull;
import monaco_editor.monaco.Uri;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:6029:44}<br>
 * Original signature:<br>
 * {@code export interface ILanguageExtensionPoint  }<br>
 */
@SuppressWarnings("unused")
public class ILanguageExtensionPoint extends JsProxy {

	public ILanguageExtensionPoint(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public ILanguageExtensionPoint(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:6035:15}<br>
	 * Original signature:<br>
	 * {@code aliases?: string[]; }<br>
	 */
	public List<String> aliases() { return get("aliases", ofArray(ofMapped(String.class))); }

 	/**
	 * See {@code monaco.d.ts:6035:15}<br>
	 * Original signature:<br>
	 * {@code aliases?: string[]; }<br>
	 */
	public ILanguageExtensionPoint aliases(@Nonnull List<String> value) {
		
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6037:21}<br>
	 * Original signature:<br>
	 * {@code configuration?: Uri; }<br>
	 */
	public Uri configuration() { return get("configuration", Uri::new); }

 	/**
	 * See {@code monaco.d.ts:6037:21}<br>
	 * Original signature:<br>
	 * {@code configuration?: Uri; }<br>
	 */
	public ILanguageExtensionPoint configuration(@Nonnull Uri value) {
		set("configuration", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6031:18}<br>
	 * Original signature:<br>
	 * {@code extensions?: string[]; }<br>
	 */
	public List<String> extensions() { return get("extensions", ofArray(ofMapped(String.class))); }

 	/**
	 * See {@code monaco.d.ts:6031:18}<br>
	 * Original signature:<br>
	 * {@code extensions?: string[]; }<br>
	 */
	public ILanguageExtensionPoint extensions(@Nonnull List<String> value) {
		
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6033:24}<br>
	 * Original signature:<br>
	 * {@code filenamePatterns?: string[]; }<br>
	 */
	public List<String> filenamePatterns() { return get("filenamePatterns", ofArray(ofMapped(String.class))); }

 	/**
	 * See {@code monaco.d.ts:6033:24}<br>
	 * Original signature:<br>
	 * {@code filenamePatterns?: string[]; }<br>
	 */
	public ILanguageExtensionPoint filenamePatterns(@Nonnull List<String> value) {
		
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6032:17}<br>
	 * Original signature:<br>
	 * {@code filenames?: string[]; }<br>
	 */
	public List<String> filenames() { return get("filenames", ofArray(ofMapped(String.class))); }

 	/**
	 * See {@code monaco.d.ts:6032:17}<br>
	 * Original signature:<br>
	 * {@code filenames?: string[]; }<br>
	 */
	public ILanguageExtensionPoint filenames(@Nonnull List<String> value) {
		
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6034:17}<br>
	 * Original signature:<br>
	 * {@code firstLine?: string; }<br>
	 */
	public String firstLine() { return get("firstLine", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:6034:17}<br>
	 * Original signature:<br>
	 * {@code firstLine?: string; }<br>
	 */
	public ILanguageExtensionPoint firstLine(@Nonnull String value) {
		set("firstLine", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6030:10}<br>
	 * Original signature:<br>
	 * {@code id: string; }<br>
	 */
	public String id() { return get("id", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:6030:10}<br>
	 * Original signature:<br>
	 * {@code id: string; }<br>
	 */
	public ILanguageExtensionPoint id(@Nonnull String value) {
		set("id", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6036:17}<br>
	 * Original signature:<br>
	 * {@code mimetypes?: string[]; }<br>
	 */
	public List<String> mimetypes() { return get("mimetypes", ofArray(ofMapped(String.class))); }

 	/**
	 * See {@code monaco.d.ts:6036:17}<br>
	 * Original signature:<br>
	 * {@code mimetypes?: string[]; }<br>
	 */
	public ILanguageExtensionPoint mimetypes(@Nonnull List<String> value) {
		
		return this;
	}

 
}
