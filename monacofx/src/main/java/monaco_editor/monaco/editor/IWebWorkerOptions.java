
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import netscape.javascript.JSObject;

/**
 * See {@code monaco.d.ts:993:38}<br>
 * Original signature:<br>
 * {@code export interface IWebWorkerOptions  }<br>
 */
@SuppressWarnings("unused")
public class IWebWorkerOptions extends JsProxy {

	public IWebWorkerOptions(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IWebWorkerOptions(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>The data to send over when calling create on the module.</p>
	 * See {@code monaco.d.ts:1002:18}<br>
	 * Original signature:<br>
	 * {@code createData?: any; }<br>
	 */
	public JSObject createData() { return get("createData", ofMapped(JSObject.class)); }

 	/**
	 * <p>The data to send over when calling create on the module.</p>
	 * See {@code monaco.d.ts:1002:18}<br>
	 * Original signature:<br>
	 * {@code createData?: any; }<br>
	 */
	public IWebWorkerOptions createData(@Nonnull JSObject value) {
		set("createData", value);
		return this;
	}

 	/**
	 * <p>An object that can be used by the web worker to make calls back to the main thread.</p>
	 * See {@code monaco.d.ts:1010:12}<br>
	 * Original signature:<br>
	 * {@code host?: any; }<br>
	 */
	public JSObject host() { return get("host", ofMapped(JSObject.class)); }

 	/**
	 * <p>An object that can be used by the web worker to make calls back to the main thread.</p>
	 * See {@code monaco.d.ts:1010:12}<br>
	 * Original signature:<br>
	 * {@code host?: any; }<br>
	 */
	public IWebWorkerOptions host(@Nonnull JSObject value) {
		set("host", value);
		return this;
	}

 	/**
	 * <p>Keep idle models.
	 * Defaults to false, which means that idle models will stop syncing after a while.</p>
	 * See {@code monaco.d.ts:1015:22}<br>
	 * Original signature:<br>
	 * {@code keepIdleModels?: boolean; }<br>
	 */
	public boolean keepIdleModels() { return get("keepIdleModels", ofMapped(boolean.class)); }

 	/**
	 * <p>Keep idle models.
	 * Defaults to false, which means that idle models will stop syncing after a while.</p>
	 * See {@code monaco.d.ts:1015:22}<br>
	 * Original signature:<br>
	 * {@code keepIdleModels?: boolean; }<br>
	 */
	public IWebWorkerOptions keepIdleModels(@Nonnull Boolean value) {
		set("keepIdleModels", value);
		return this;
	}

 	/**
	 * <p>A label to be used to identify the web worker for debugging purposes.</p>
	 * See {@code monaco.d.ts:1006:13}<br>
	 * Original signature:<br>
	 * {@code label?: string; }<br>
	 */
	public String label() { return get("label", ofMapped(String.class)); }

 	/**
	 * <p>A label to be used to identify the web worker for debugging purposes.</p>
	 * See {@code monaco.d.ts:1006:13}<br>
	 * Original signature:<br>
	 * {@code label?: string; }<br>
	 */
	public IWebWorkerOptions label(@Nonnull String value) {
		set("label", value);
		return this;
	}

 	/**
	 * <p>The AMD moduleId to load.
	 * It should export a function <code>create</code> that should return the exported proxy.</p>
	 * See {@code monaco.d.ts:998:16}<br>
	 * Original signature:<br>
	 * {@code moduleId: string; }<br>
	 */
	public String moduleId() { return get("moduleId", ofMapped(String.class)); }

 	/**
	 * <p>The AMD moduleId to load.
	 * It should export a function <code>create</code> that should return the exported proxy.</p>
	 * See {@code monaco.d.ts:998:16}<br>
	 * Original signature:<br>
	 * {@code moduleId: string; }<br>
	 */
	public IWebWorkerOptions moduleId(@Nonnull String value) {
		set("moduleId", value);
		return this;
	}

 
}
