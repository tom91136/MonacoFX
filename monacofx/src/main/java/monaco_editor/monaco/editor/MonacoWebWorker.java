
package monaco_editor.monaco.editor;
import java.util.List;
import javax.annotation.Nonnull;
import monaco_editor.monaco.Uri;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsPromise;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>A web worker that can provide a proxy to an arbitrary file.</p>
 * See {@code monaco.d.ts:977:36}<br>
 * Original signature:<br>
 * {@code export interface MonacoWebWorker<T>  }<br>
 */
@SuppressWarnings("unused")
public class MonacoWebWorker <T> extends JsProxy {

	public MonacoWebWorker(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public MonacoWebWorker(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Terminate the web worker, thus invalidating the returned proxy.</p>
	 * See {@code monaco.d.ts:981:15}<br>
	 * Original signature:<br>
	 * {@code dispose(): void; }<br>
	 */
	public void dispose() { call("dispose", ofVoid()); }

 	/**
	 * <p>Get a proxy to the arbitrary loaded code.</p>
	 * See {@code monaco.d.ts:985:16}<br>
	 * Original signature:<br>
	 * {@code getProxy(): Promise<T>; }<br>
	 */
	public JsPromise<T> getProxy() { return call("getProxy", JsPromise ::new); }

 	/**
	 * <p>Synchronize (send) the models at <code>resources</code> to the web worker,
	 * making them available in the monaco.worker.getMirrorModels().</p>
	 * See {@code monaco.d.ts:990:27}<br>
	 * Original signature:<br>
	 * {@code withSyncedResources(resources: Uri[]): Promise<T>; }<br>
	 */
	public JsPromise<T> withSyncedResources(@Nonnull List<Uri> resources) { return call("withSyncedResources", JsPromise ::new, resources); }

 
}
