
package monaco_editor.monaco.languages;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import net.kurobako.monacofx.js.JsUnion4;

/**
 * See {@code monaco.d.ts:6080:49}<br>
 * Original signature:<br>
 * {@code export interface IExpandedMonarchLanguageRule  }<br>
 */
@SuppressWarnings("unused")
public class IExpandedMonarchLanguageRule extends JsProxy {

	public IExpandedMonarchLanguageRule(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IExpandedMonarchLanguageRule(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>action to take on match</p>
	 * See {@code monaco.d.ts:6088:14}<br>
	 * Original signature:<br>
	 * {@code action?: IMonarchLanguageAction; }<br>
	 */
	public Optional<JsUnion4<String, IExpandedMonarchLanguageAction, List<String>, List<IExpandedMonarchLanguageAction>>> action() { return Optional.ofNullable(get("action", null /*union*/)); }

 	/**
	 * <p>action to take on match</p>
	 * See {@code monaco.d.ts:6088:14}<br>
	 * Original signature:<br>
	 * {@code action?: IMonarchLanguageAction; }<br>
	 */
	public IExpandedMonarchLanguageRule action(@Nullable JsUnion4<String, IExpandedMonarchLanguageAction, List<String>, List<IExpandedMonarchLanguageAction>> value) {
		set("action", value);
		return this;
	}

 	/**
	 * <p>or an include rule. include all rules from the included state</p>
	 * See {@code monaco.d.ts:6092:15}<br>
	 * Original signature:<br>
	 * {@code include?: string; }<br>
	 */
	public String include() { return get("include", ofMapped(String.class)); }

 	/**
	 * <p>or an include rule. include all rules from the included state</p>
	 * See {@code monaco.d.ts:6092:15}<br>
	 * Original signature:<br>
	 * {@code include?: string; }<br>
	 */
	public IExpandedMonarchLanguageRule include(@Nonnull String value) {
		set("include", value);
		return this;
	}

 	/**
	 * <p>match tokens</p>
	 * See {@code monaco.d.ts:6084:13}<br>
	 * Original signature:<br>
	 * {@code regex?: string | RegExp; }<br>
	 */
	public String regex() { return get("regex", ofMapped(String.class)); }

 	/**
	 * <p>match tokens</p>
	 * See {@code monaco.d.ts:6084:13}<br>
	 * Original signature:<br>
	 * {@code regex?: string | RegExp; }<br>
	 */
	public IExpandedMonarchLanguageRule regex(@Nonnull String value) {
		set("regex", value);
		return this;
	}

 
}
