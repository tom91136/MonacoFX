
package monaco_editor.monaco;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import netscape.javascript.JSObject;

/**
 * See {@code monaco.d.ts:17:32}<br>
 * Original signature:<br>
 * {@code export interface Environment  }<br>
 */
@SuppressWarnings("unused")
public class Environment extends JsProxy {

	public Environment(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public Environment(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:18:15}<br>
	 * Original signature:<br>
	 * {@code baseUrl?: string; }<br>
	 */
	public String baseUrl() { return get("baseUrl", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:18:15}<br>
	 * Original signature:<br>
	 * {@code baseUrl?: string; }<br>
	 */
	public Environment baseUrl(@Nonnull String value) {
		set("baseUrl", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:19:17}<br>
	 * Original signature:<br>
	 * {@code getWorker?(workerId: string, label: string): Worker; }<br>
	 */
	public JSObject getWorker(@Nonnull String workerId, @Nonnull String label) { return call("getWorker", ofMapped(JSObject.class), workerId, label); }

 	/**
	 * See {@code monaco.d.ts:20:20}<br>
	 * Original signature:<br>
	 * {@code getWorkerUrl?(workerId: string, label: string): string; }<br>
	 */
	public String getWorkerUrl(@Nonnull String workerId, @Nonnull String label) { return call("getWorkerUrl", ofMapped(String.class), workerId, label); }

 
}
