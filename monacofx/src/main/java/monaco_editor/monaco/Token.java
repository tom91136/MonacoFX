
package monaco_editor.monaco;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:806:22}<br>
 * Original signature:<br>
 * {@code export class Token  }<br>
 */
@SuppressWarnings("unused")
public class Token extends JsProxy {

	public Token(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public Token(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:810:25}<br>
	 * Original signature:<br>
	 * {@code readonly language: string; }<br>
	 */
	public String language() { return get("language", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:808:23}<br>
	 * Original signature:<br>
	 * {@code readonly offset: number; }<br>
	 */
	public double offset() { return get("offset", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:809:21}<br>
	 * Original signature:<br>
	 * {@code readonly type: string; }<br>
	 */
	public String type() { return get("type", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:812:16}<br>
	 * Original signature:<br>
	 * {@code toString(): string; }<br>
	 */
	public String toString() { return call("toString", ofMapped(String.class)); }

 
}
