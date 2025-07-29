
package monaco_editor.monaco.worker;
import java.util.List;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:6174:35}<br>
 * Original signature:<br>
 * {@code export interface IWorkerContext<H = undefined>  }<br>
 */
@SuppressWarnings("unused")
public class IWorkerContext <H> extends JsProxy {

	public IWorkerContext(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IWorkerContext(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>A proxy to the main thread host object.</p>
	 * See {@code monaco.d.ts:6178:12}<br>
	 * Original signature:<br>
	 * {@code host: H; }<br>
	 */
	public H host() { return get("host", null ); }

 	/**
	 * <p>A proxy to the main thread host object.</p>
	 * See {@code monaco.d.ts:6178:12}<br>
	 * Original signature:<br>
	 * {@code host: H; }<br>
	 */
	public IWorkerContext<H> host(@Nonnull H value) {
		
		return this;
	}

 	/**
	 * <p>Get all available mirror models in this worker.</p>
	 * See {@code monaco.d.ts:6182:23}<br>
	 * Original signature:<br>
	 * {@code getMirrorModels(): IMirrorModel[]; }<br>
	 */
	public List<IMirrorModel> getMirrorModels() { return call("getMirrorModels", ofArray(IMirrorModel::new)); }

 
}
