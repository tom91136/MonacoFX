
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import monaco_editor.monaco.IRange;
import monaco_editor.monaco.Uri;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>Represents a location inside a resource, such as a line
 * inside a text file.</p>
 * See {@code monaco.d.ts:5561:29}<br>
 * Original signature:<br>
 * {@code export interface Location  }<br>
 */
@SuppressWarnings("unused")
public class Location extends JsProxy {

	public Location(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public Location(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>The document range of this locations.</p>
	 * See {@code monaco.d.ts:5569:13}<br>
	 * Original signature:<br>
	 * {@code range: IRange; }<br>
	 */
	public IRange range() { return get("range", IRange::new); }

 	/**
	 * <p>The document range of this locations.</p>
	 * See {@code monaco.d.ts:5569:13}<br>
	 * Original signature:<br>
	 * {@code range: IRange; }<br>
	 */
	public Location range(@Nonnull IRange value) {
		set("range", value);
		return this;
	}

 	/**
	 * <p>The resource identifier of this location.</p>
	 * See {@code monaco.d.ts:5565:11}<br>
	 * Original signature:<br>
	 * {@code uri: Uri; }<br>
	 */
	public Uri uri() { return get("uri", Uri::new); }

 	/**
	 * <p>The resource identifier of this location.</p>
	 * See {@code monaco.d.ts:5565:11}<br>
	 * Original signature:<br>
	 * {@code uri: Uri; }<br>
	 */
	public Location uri(@Nonnull Uri value) {
		set("uri", value);
		return this;
	}

 
}
