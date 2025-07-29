
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:1239:45}<br>
 * Original signature:<br>
 * {@code export interface IColorizerElementOptions extends IColorizerOptions  }<br>
 */
@SuppressWarnings("unused")
public class IColorizerElementOptions extends IColorizerOptions {

	public IColorizerElementOptions(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IColorizerElementOptions(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:1241:16}<br>
	 * Original signature:<br>
	 * {@code mimeType?: string; }<br>
	 */
	public String mimeType() { return get("mimeType", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:1241:16}<br>
	 * Original signature:<br>
	 * {@code mimeType?: string; }<br>
	 */
	public IColorizerElementOptions mimeType(@Nonnull String value) {
		set("mimeType", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1236:15}<br>
	 * Original signature:<br>
	 * {@code tabSize?: number; }<br>
	 */
	public double tabSize() { return get("tabSize", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:1236:15}<br>
	 * Original signature:<br>
	 * {@code tabSize?: number; }<br>
	 */
	public IColorizerElementOptions tabSize(@Nonnull Double value) {
		set("tabSize", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1240:13}<br>
	 * Original signature:<br>
	 * {@code theme?: string; }<br>
	 */
	public String theme() { return get("theme", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:1240:13}<br>
	 * Original signature:<br>
	 * {@code theme?: string; }<br>
	 */
	public IColorizerElementOptions theme(@Nonnull String value) {
		set("theme", value);
		return this;
	}

 
}
