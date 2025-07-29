
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import monaco_editor.monaco.IRange;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:5963:35}<br>
 * Original signature:<br>
 * {@code export interface RenameLocation  }<br>
 */
@SuppressWarnings("unused")
public class RenameLocation extends JsProxy {

	public RenameLocation(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public RenameLocation(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5964:13}<br>
	 * Original signature:<br>
	 * {@code range: IRange; }<br>
	 */
	public IRange range() { return get("range", IRange::new); }

 	/**
	 * See {@code monaco.d.ts:5964:13}<br>
	 * Original signature:<br>
	 * {@code range: IRange; }<br>
	 */
	public RenameLocation range(@Nonnull IRange value) {
		set("range", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5965:12}<br>
	 * Original signature:<br>
	 * {@code text: string; }<br>
	 */
	public String text() { return get("text", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:5965:12}<br>
	 * Original signature:<br>
	 * {@code text: string; }<br>
	 */
	public RenameLocation text(@Nonnull String value) {
		set("text", value);
		return this;
	}

 
}
