
package monaco_editor.monaco.editor;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import monaco_editor.monaco.Selection;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>An event describing that the cursor selection has changed.</p>
 * See {@code monaco.d.ts:2439:49}<br>
 * Original signature:<br>
 * {@code export interface ICursorSelectionChangedEvent  }<br>
 */
@SuppressWarnings("unused")
public class ICursorSelectionChangedEvent extends JsProxy {

	public ICursorSelectionChangedEvent(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public ICursorSelectionChangedEvent(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>The model version id.</p>
	 * See {@code monaco.d.ts:2451:31}<br>
	 * Original signature:<br>
	 * {@code readonly modelVersionId: number; }<br>
	 */
	public double modelVersionId() { return get("modelVersionId", ofMapped(double.class)); }

 	/**
	 * <p>The model version id the that <code>oldSelections</code> refer to.</p>
	 * See {@code monaco.d.ts:2459:34}<br>
	 * Original signature:<br>
	 * {@code readonly oldModelVersionId: number; }<br>
	 */
	public double oldModelVersionId() { return get("oldModelVersionId", ofMapped(double.class)); }

 	/**
	 * <p>The old selections.</p>
	 * See {@code monaco.d.ts:2455:30}<br>
	 * Original signature:<br>
	 * {@code readonly oldSelections: Selection[] | null; }<br>
	 */
	public Optional<List<Selection>> oldSelections() { return Optional.ofNullable(get("oldSelections", ofArray(Selection::new))); }

 	/**
	 * <p>Reason.</p>
	 * See {@code monaco.d.ts:2467:23}<br>
	 * Original signature:<br>
	 * {@code readonly reason: CursorChangeReason; }<br>
	 */
	public CursorChangeReason reason() { return get("reason", ofJsEnum(CursorChangeReason.class)); }

 	/**
	 * <p>The secondary selections.</p>
	 * See {@code monaco.d.ts:2447:36}<br>
	 * Original signature:<br>
	 * {@code readonly secondarySelections: Selection[]; }<br>
	 */
	public List<Selection> secondarySelections() { return get("secondarySelections", ofArray(Selection::new)); }

 	/**
	 * <p>The primary selection.</p>
	 * See {@code monaco.d.ts:2443:26}<br>
	 * Original signature:<br>
	 * {@code readonly selection: Selection; }<br>
	 */
	public Selection selection() { return get("selection", Selection::new); }

 	/**
	 * <p>Source of the call that caused the event.</p>
	 * See {@code monaco.d.ts:2463:23}<br>
	 * Original signature:<br>
	 * {@code readonly source: string; }<br>
	 */
	public String source() { return get("source", ofMapped(String.class)); }

 
}
