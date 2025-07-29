
package monaco_editor.monaco.languages.typescript;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:6328:23}<br>
 * Original signature:<br>
 * {@code interface IExtraLib  }<br>
 */
@SuppressWarnings("unused")
public class IExtraLib extends JsProxy {

	public IExtraLib(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IExtraLib(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:6329:15}<br>
	 * Original signature:<br>
	 * {@code content: string; }<br>
	 */
	public String content() { return get("content", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:6329:15}<br>
	 * Original signature:<br>
	 * {@code content: string; }<br>
	 */
	public IExtraLib content(@Nonnull String value) {
		set("content", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6330:15}<br>
	 * Original signature:<br>
	 * {@code version: number; }<br>
	 */
	public double version() { return get("version", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:6330:15}<br>
	 * Original signature:<br>
	 * {@code version: number; }<br>
	 */
	public IExtraLib version(@Nonnull Double value) {
		set("version", value);
		return this;
	}

 
}
