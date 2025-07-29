
package monaco_editor.monaco.languages;
import java.util.List;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import netscape.javascript.JSObject;

/**
 * <p>A Monarch language definition</p>
 * See {@code monaco.d.ts:6042:37}<br>
 * Original signature:<br>
 * {@code export interface IMonarchLanguage  }<br>
 */
@SuppressWarnings("unused")
public class IMonarchLanguage extends JsProxy {

	public IMonarchLanguage(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IMonarchLanguage(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>for example [['{','}','delimiter.curly']]</p>
	 * See {@code monaco.d.ts:6060:16}<br>
	 * Original signature:<br>
	 * {@code brackets?: IMonarchLanguageBracket[]; }<br>
	 */
	public List<IMonarchLanguageBracket> brackets() { return get("brackets", ofArray(IMonarchLanguageBracket::new)); }

 	/**
	 * <p>for example [['{','}','delimiter.curly']]</p>
	 * See {@code monaco.d.ts:6060:16}<br>
	 * Original signature:<br>
	 * {@code brackets?: IMonarchLanguageBracket[]; }<br>
	 */
	public IMonarchLanguage brackets(@Nonnull List<IMonarchLanguageBracket> value) {
		
		return this;
	}

 	/**
	 * <p>if no match in the tokenizer assign this token class (default 'source')</p>
	 * See {@code monaco.d.ts:6056:20}<br>
	 * Original signature:<br>
	 * {@code defaultToken?: string; }<br>
	 */
	public String defaultToken() { return get("defaultToken", ofMapped(String.class)); }

 	/**
	 * <p>if no match in the tokenizer assign this token class (default 'source')</p>
	 * See {@code monaco.d.ts:6056:20}<br>
	 * Original signature:<br>
	 * {@code defaultToken?: string; }<br>
	 */
	public IMonarchLanguage defaultToken(@Nonnull String value) {
		set("defaultToken", value);
		return this;
	}

 	/**
	 * <p>is the language case insensitive?</p>
	 * See {@code monaco.d.ts:6052:18}<br>
	 * Original signature:<br>
	 * {@code ignoreCase?: boolean; }<br>
	 */
	public boolean ignoreCase() { return get("ignoreCase", ofMapped(boolean.class)); }

 	/**
	 * <p>is the language case insensitive?</p>
	 * See {@code monaco.d.ts:6052:18}<br>
	 * Original signature:<br>
	 * {@code ignoreCase?: boolean; }<br>
	 */
	public IMonarchLanguage ignoreCase(@Nonnull Boolean value) {
		set("ignoreCase", value);
		return this;
	}

 	/**
	 * <p>start symbol in the tokenizer (by default the first entry is used)</p>
	 * See {@code monaco.d.ts:6064:13}<br>
	 * Original signature:<br>
	 * {@code start?: string; }<br>
	 */
	public String start() { return get("start", ofMapped(String.class)); }

 	/**
	 * <p>start symbol in the tokenizer (by default the first entry is used)</p>
	 * See {@code monaco.d.ts:6064:13}<br>
	 * Original signature:<br>
	 * {@code start?: string; }<br>
	 */
	public IMonarchLanguage start(@Nonnull String value) {
		set("start", value);
		return this;
	}

 	/**
	 * <p>attach this to every token class (by default '.' + name)</p>
	 * See {@code monaco.d.ts:6068:20}<br>
	 * Original signature:<br>
	 * {@code tokenPostfix?: string; }<br>
	 */
	public String tokenPostfix() { return get("tokenPostfix", ofMapped(String.class)); }

 	/**
	 * <p>attach this to every token class (by default '.' + name)</p>
	 * See {@code monaco.d.ts:6068:20}<br>
	 * Original signature:<br>
	 * {@code tokenPostfix?: string; }<br>
	 */
	public IMonarchLanguage tokenPostfix(@Nonnull String value) {
		set("tokenPostfix", value);
		return this;
	}

 	/**
	 * <p>map from string to ILanguageRule[]</p>
	 * See {@code monaco.d.ts:6046:17}<br>
	 * Original signature:<br>
	 * {@code tokenizer:  }<br>
	 */
	public JSObject tokenizer() { return get("tokenizer", ofMapped(JSObject.class)); }

 	/**
	 * <p>map from string to ILanguageRule[]</p>
	 * See {@code monaco.d.ts:6046:17}<br>
	 * Original signature:<br>
	 * {@code tokenizer:  }<br>
	 */
	public IMonarchLanguage tokenizer(@Nonnull JSObject value) {
		set("tokenizer", value);
		return this;
	}

 
}
