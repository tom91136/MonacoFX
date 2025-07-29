
package monaco_editor.monaco.editor;
import java.util.List;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import netscape.javascript.JSObject;

/**
 * See {@code monaco.d.ts:955:41}<br>
 * Original signature:<br>
 * {@code export interface IStandaloneThemeData  }<br>
 */
@SuppressWarnings("unused")
public class IStandaloneThemeData extends JsProxy {

	public IStandaloneThemeData(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IStandaloneThemeData(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:960:14}<br>
	 * Original signature:<br>
	 * {@code colors: IColors; }<br>
	 */
	public JSObject colors() { return get("colors", ofMapped(JSObject.class)); }

 	/**
	 * See {@code monaco.d.ts:960:14}<br>
	 * Original signature:<br>
	 * {@code colors: IColors; }<br>
	 */
	public IStandaloneThemeData colors(@Nonnull JSObject value) {
		set("colors", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:959:27}<br>
	 * Original signature:<br>
	 * {@code encodedTokensColors?: string[]; }<br>
	 */
	public List<String> encodedTokensColors() { return get("encodedTokensColors", ofArray(ofMapped(String.class))); }

 	/**
	 * See {@code monaco.d.ts:959:27}<br>
	 * Original signature:<br>
	 * {@code encodedTokensColors?: string[]; }<br>
	 */
	public IStandaloneThemeData encodedTokensColors(@Nonnull List<String> value) {
		
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:957:15}<br>
	 * Original signature:<br>
	 * {@code inherit: boolean; }<br>
	 */
	public boolean inherit() { return get("inherit", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:957:15}<br>
	 * Original signature:<br>
	 * {@code inherit: boolean; }<br>
	 */
	public IStandaloneThemeData inherit(@Nonnull Boolean value) {
		set("inherit", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:958:13}<br>
	 * Original signature:<br>
	 * {@code rules: ITokenThemeRule[]; }<br>
	 */
	public List<ITokenThemeRule> rules() { return get("rules", ofArray(ITokenThemeRule::new)); }

 	/**
	 * See {@code monaco.d.ts:958:13}<br>
	 * Original signature:<br>
	 * {@code rules: ITokenThemeRule[]; }<br>
	 */
	public IStandaloneThemeData rules(@Nonnull List<ITokenThemeRule> value) {
		
		return this;
	}

 
}
