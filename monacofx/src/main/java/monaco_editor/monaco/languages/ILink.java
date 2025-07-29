
package monaco_editor.monaco.languages;
import java.util.Optional;
import javax.annotation.Nonnull;
import monaco_editor.monaco.IRange;
import monaco_editor.monaco.Uri;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import net.kurobako.monacofx.js.JsUnion2;

/**
 * <p>A link inside the editor.</p>
 * See {@code monaco.d.ts:5766:26}<br>
 * Original signature:<br>
 * {@code export interface ILink  }<br>
 */
@SuppressWarnings("unused")
public class ILink extends JsProxy {

	public ILink(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public ILink(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5767:13}<br>
	 * Original signature:<br>
	 * {@code range: IRange; }<br>
	 */
	public IRange range() { return get("range", IRange::new); }

 	/**
	 * See {@code monaco.d.ts:5767:13}<br>
	 * Original signature:<br>
	 * {@code range: IRange; }<br>
	 */
	public ILink range(@Nonnull IRange value) {
		set("range", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5769:15}<br>
	 * Original signature:<br>
	 * {@code tooltip?: string; }<br>
	 */
	public String tooltip() { return get("tooltip", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:5769:15}<br>
	 * Original signature:<br>
	 * {@code tooltip?: string; }<br>
	 */
	public ILink tooltip(@Nonnull String value) {
		set("tooltip", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5768:11}<br>
	 * Original signature:<br>
	 * {@code url?: Uri | string; }<br>
	 */
	public Optional<JsUnion2<Uri, String>> url() { return Optional.ofNullable(get("url", null /*union*/)); }

 	/**
	 * See {@code monaco.d.ts:5768:11}<br>
	 * Original signature:<br>
	 * {@code url?: Uri | string; }<br>
	 */
	public ILink url(@Nonnull Uri value) {
		set("url", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5768:11}<br>
	 * Original signature:<br>
	 * {@code url?: Uri | string; }<br>
	 */
	public ILink url(@Nonnull String value) {
		set("url", value);
		return this;
	}

 
}
