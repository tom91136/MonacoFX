
package monaco_editor.monaco.worker;
import javax.annotation.Nonnull;
import monaco_editor.monaco.Uri;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:6168:33}<br>
 * Original signature:<br>
 * {@code export interface IMirrorModel  }<br>
 */
@SuppressWarnings("unused")
public class IMirrorModel extends JsProxy {

	public IMirrorModel(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IMirrorModel(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:6169:20}<br>
	 * Original signature:<br>
	 * {@code readonly uri: Uri; }<br>
	 */
	public Uri uri() { return get("uri", Uri::new); }

 	/**
	 * See {@code monaco.d.ts:6170:24}<br>
	 * Original signature:<br>
	 * {@code readonly version: number; }<br>
	 */
	public double version() { return get("version", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:6171:16}<br>
	 * Original signature:<br>
	 * {@code getValue(): string; }<br>
	 */
	public String getValue() { return call("getValue", ofMapped(String.class)); }

 
}
