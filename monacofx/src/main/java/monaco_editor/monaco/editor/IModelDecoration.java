
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import monaco_editor.monaco.Range;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>A decoration in the model.</p>
 * See {@code monaco.d.ts:1392:37}<br>
 * Original signature:<br>
 * {@code export interface IModelDecoration  }<br>
 */
@SuppressWarnings("unused")
public class IModelDecoration extends JsProxy {

	public IModelDecoration(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IModelDecoration(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Identifier for a decoration.</p>
	 * See {@code monaco.d.ts:1396:19}<br>
	 * Original signature:<br>
	 * {@code readonly id: string; }<br>
	 */
	public String id() { return get("id", ofMapped(String.class)); }

 	/**
	 * <p>Options associated with this decoration.</p>
	 * See {@code monaco.d.ts:1408:24}<br>
	 * Original signature:<br>
	 * {@code readonly options: IModelDecorationOptions; }<br>
	 */
	public IModelDecorationOptions options() { return get("options", IModelDecorationOptions::new); }

 	/**
	 * <p>Identifier for a decoration's owner.</p>
	 * See {@code monaco.d.ts:1400:24}<br>
	 * Original signature:<br>
	 * {@code readonly ownerId: number; }<br>
	 */
	public double ownerId() { return get("ownerId", ofMapped(double.class)); }

 	/**
	 * <p>Range that this decoration covers.</p>
	 * See {@code monaco.d.ts:1404:22}<br>
	 * Original signature:<br>
	 * {@code readonly range: Range; }<br>
	 */
	public Range range() { return get("range", Range::new); }

 
}
