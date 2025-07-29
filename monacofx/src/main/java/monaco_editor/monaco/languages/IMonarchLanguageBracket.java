
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>This interface can be shortened as an array, ie. ['{','}','delimiter.curly']</p>
 * See {@code monaco.d.ts:6148:44}<br>
 * Original signature:<br>
 * {@code export interface IMonarchLanguageBracket  }<br>
 */
@SuppressWarnings("unused")
public class IMonarchLanguageBracket extends JsProxy {

	public IMonarchLanguageBracket(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IMonarchLanguageBracket(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>closing bracket</p>
	 * See {@code monaco.d.ts:6156:13}<br>
	 * Original signature:<br>
	 * {@code close: string; }<br>
	 */
	public String close() { return get("close", ofMapped(String.class)); }

 	/**
	 * <p>closing bracket</p>
	 * See {@code monaco.d.ts:6156:13}<br>
	 * Original signature:<br>
	 * {@code close: string; }<br>
	 */
	public IMonarchLanguageBracket close(@Nonnull String value) {
		set("close", value);
		return this;
	}

 	/**
	 * <p>open bracket</p>
	 * See {@code monaco.d.ts:6152:12}<br>
	 * Original signature:<br>
	 * {@code open: string; }<br>
	 */
	public String open() { return get("open", ofMapped(String.class)); }

 	/**
	 * <p>open bracket</p>
	 * See {@code monaco.d.ts:6152:12}<br>
	 * Original signature:<br>
	 * {@code open: string; }<br>
	 */
	public IMonarchLanguageBracket open(@Nonnull String value) {
		set("open", value);
		return this;
	}

 	/**
	 * <p>token class</p>
	 * See {@code monaco.d.ts:6160:13}<br>
	 * Original signature:<br>
	 * {@code token: string; }<br>
	 */
	public String token() { return get("token", ofMapped(String.class)); }

 	/**
	 * <p>token class</p>
	 * See {@code monaco.d.ts:6160:13}<br>
	 * Original signature:<br>
	 * {@code token: string; }<br>
	 */
	public IMonarchLanguageBracket token(@Nonnull String value) {
		set("token", value);
		return this;
	}

 
}
