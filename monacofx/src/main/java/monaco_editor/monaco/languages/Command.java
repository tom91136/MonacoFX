
package monaco_editor.monaco.languages;
import java.util.List;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import netscape.javascript.JSObject;

/**
 * See {@code monaco.d.ts:5973:28}<br>
 * Original signature:<br>
 * {@code export interface Command  }<br>
 */
@SuppressWarnings("unused")
public class Command extends JsProxy {

	public Command(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public Command(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5977:17}<br>
	 * Original signature:<br>
	 * {@code arguments?: any[]; }<br>
	 */
	public List<JSObject> arguments() { return get("arguments", ofArray(ofMapped(JSObject.class))); }

 	/**
	 * See {@code monaco.d.ts:5977:17}<br>
	 * Original signature:<br>
	 * {@code arguments?: any[]; }<br>
	 */
	public Command arguments(@Nonnull List<JSObject> value) {
		
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5974:10}<br>
	 * Original signature:<br>
	 * {@code id: string; }<br>
	 */
	public String id() { return get("id", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:5974:10}<br>
	 * Original signature:<br>
	 * {@code id: string; }<br>
	 */
	public Command id(@Nonnull String value) {
		set("id", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5975:13}<br>
	 * Original signature:<br>
	 * {@code title: string; }<br>
	 */
	public String title() { return get("title", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:5975:13}<br>
	 * Original signature:<br>
	 * {@code title: string; }<br>
	 */
	public Command title(@Nonnull String value) {
		set("title", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5976:15}<br>
	 * Original signature:<br>
	 * {@code tooltip?: string; }<br>
	 */
	public String tooltip() { return get("tooltip", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:5976:15}<br>
	 * Original signature:<br>
	 * {@code tooltip?: string; }<br>
	 */
	public Command tooltip(@Nonnull String value) {
		set("tooltip", value);
		return this;
	}

 
}
