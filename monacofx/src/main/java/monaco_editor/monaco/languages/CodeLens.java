
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import monaco_editor.monaco.IRange;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:5980:29}<br>
 * Original signature:<br>
 * {@code export interface CodeLens  }<br>
 */
@SuppressWarnings("unused")
public class CodeLens extends JsProxy {

	public CodeLens(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public CodeLens(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5983:15}<br>
	 * Original signature:<br>
	 * {@code command?: Command; }<br>
	 */
	public Command command() { return get("command", Command::new); }

 	/**
	 * See {@code monaco.d.ts:5983:15}<br>
	 * Original signature:<br>
	 * {@code command?: Command; }<br>
	 */
	public CodeLens command(@Nonnull Command value) {
		set("command", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5982:10}<br>
	 * Original signature:<br>
	 * {@code id?: string; }<br>
	 */
	public String id() { return get("id", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:5982:10}<br>
	 * Original signature:<br>
	 * {@code id?: string; }<br>
	 */
	public CodeLens id(@Nonnull String value) {
		set("id", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5981:13}<br>
	 * Original signature:<br>
	 * {@code range: IRange; }<br>
	 */
	public IRange range() { return get("range", IRange::new); }

 	/**
	 * See {@code monaco.d.ts:5981:13}<br>
	 * Original signature:<br>
	 * {@code range: IRange; }<br>
	 */
	public CodeLens range(@Nonnull IRange value) {
		set("range", value);
		return this;
	}

 
}
