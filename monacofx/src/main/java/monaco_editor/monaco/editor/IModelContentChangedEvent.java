
package monaco_editor.monaco.editor;
import java.util.List;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>An event describing a change in the text of a model.</p>
 * See {@code monaco.d.ts:2342:46}<br>
 * Original signature:<br>
 * {@code export interface IModelContentChangedEvent  }<br>
 */
@SuppressWarnings("unused")
public class IModelContentChangedEvent extends JsProxy {

	public IModelContentChangedEvent(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IModelContentChangedEvent(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:2343:24}<br>
	 * Original signature:<br>
	 * {@code readonly changes: IModelContentChange[]; }<br>
	 */
	public List<IModelContentChange> changes() { return get("changes", ofArray(IModelContentChange::new)); }

 	/**
	 * <p>The (new) end-of-line character.</p>
	 * See {@code monaco.d.ts:2347:20}<br>
	 * Original signature:<br>
	 * {@code readonly eol: string; }<br>
	 */
	public String eol() { return get("eol", ofMapped(String.class)); }

 	/**
	 * <p>Flag that indicates that all decorations were lost with this edit.
	 * The model has been reset to a new value.</p>
	 * See {@code monaco.d.ts:2364:24}<br>
	 * Original signature:<br>
	 * {@code readonly isFlush: boolean; }<br>
	 */
	public boolean isFlush() { return get("isFlush", ofMapped(boolean.class)); }

 	/**
	 * <p>Flag that indicates that this event was generated while redoing.</p>
	 * See {@code monaco.d.ts:2359:26}<br>
	 * Original signature:<br>
	 * {@code readonly isRedoing: boolean; }<br>
	 */
	public boolean isRedoing() { return get("isRedoing", ofMapped(boolean.class)); }

 	/**
	 * <p>Flag that indicates that this event was generated while undoing.</p>
	 * See {@code monaco.d.ts:2355:26}<br>
	 * Original signature:<br>
	 * {@code readonly isUndoing: boolean; }<br>
	 */
	public boolean isUndoing() { return get("isUndoing", ofMapped(boolean.class)); }

 	/**
	 * <p>The new version id the model has transitioned to.</p>
	 * See {@code monaco.d.ts:2351:26}<br>
	 * Original signature:<br>
	 * {@code readonly versionId: number; }<br>
	 */
	public double versionId() { return get("versionId", ofMapped(double.class)); }

 
}
