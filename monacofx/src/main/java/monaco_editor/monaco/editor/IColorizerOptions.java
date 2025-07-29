
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:1235:38}<br>
 * Original signature:<br>
 * {@code export interface IColorizerOptions  }<br>
 */
@SuppressWarnings("unused")
public class IColorizerOptions extends JsProxy {

	public IColorizerOptions(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IColorizerOptions(@Nonnull JsContext context) { super(context); }

 
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
	public IColorizerOptions tabSize(@Nonnull Double value) {
		set("tabSize", value);
		return this;
	}

 
}
