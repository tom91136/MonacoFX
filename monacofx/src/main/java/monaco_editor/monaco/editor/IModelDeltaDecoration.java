
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import monaco_editor.monaco.IRange;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>New model decorations.</p>
 * See {@code monaco.d.ts:1378:42}<br>
 * Original signature:<br>
 * {@code export interface IModelDeltaDecoration  }<br>
 */
@SuppressWarnings("unused")
public class IModelDeltaDecoration extends JsProxy {

	public IModelDeltaDecoration(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IModelDeltaDecoration(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Options associated with this decoration.</p>
	 * See {@code monaco.d.ts:1386:15}<br>
	 * Original signature:<br>
	 * {@code options: IModelDecorationOptions; }<br>
	 */
	public IModelDecorationOptions options() { return get("options", IModelDecorationOptions::new); }

 	/**
	 * <p>Options associated with this decoration.</p>
	 * See {@code monaco.d.ts:1386:15}<br>
	 * Original signature:<br>
	 * {@code options: IModelDecorationOptions; }<br>
	 */
	public IModelDeltaDecoration options(@Nonnull IModelDecorationOptions value) {
		set("options", value);
		return this;
	}

 	/**
	 * <p>Range that this decoration covers.</p>
	 * See {@code monaco.d.ts:1382:13}<br>
	 * Original signature:<br>
	 * {@code range: IRange; }<br>
	 */
	public IRange range() { return get("range", IRange::new); }

 	/**
	 * <p>Range that this decoration covers.</p>
	 * See {@code monaco.d.ts:1382:13}<br>
	 * Original signature:<br>
	 * {@code range: IRange; }<br>
	 */
	public IModelDeltaDecoration range(@Nonnull IRange value) {
		set("range", value);
		return this;
	}

 
}
