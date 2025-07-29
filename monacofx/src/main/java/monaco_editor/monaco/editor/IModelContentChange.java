
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import monaco_editor.monaco.IRange;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:2320:40}<br>
 * Original signature:<br>
 * {@code export interface IModelContentChange  }<br>
 */
@SuppressWarnings("unused")
public class IModelContentChange extends JsProxy {

	public IModelContentChange(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IModelContentChange(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>The range that got replaced.</p>
	 * See {@code monaco.d.ts:2324:22}<br>
	 * Original signature:<br>
	 * {@code readonly range: IRange; }<br>
	 */
	public IRange range() { return get("range", IRange::new); }

 	/**
	 * <p>The length of the range that got replaced.</p>
	 * See {@code monaco.d.ts:2332:28}<br>
	 * Original signature:<br>
	 * {@code readonly rangeLength: number; }<br>
	 */
	public double rangeLength() { return get("rangeLength", ofMapped(double.class)); }

 	/**
	 * <p>The offset of the range that got replaced.</p>
	 * See {@code monaco.d.ts:2328:28}<br>
	 * Original signature:<br>
	 * {@code readonly rangeOffset: number; }<br>
	 */
	public double rangeOffset() { return get("rangeOffset", ofMapped(double.class)); }

 	/**
	 * <p>The new text for the range.</p>
	 * See {@code monaco.d.ts:2336:21}<br>
	 * Original signature:<br>
	 * {@code readonly text: string; }<br>
	 */
	public String text() { return get("text", ofMapped(String.class)); }

 
}
