
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import monaco_editor.monaco.Range;
import monaco_editor.monaco.Selection;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>A builder and helper for edit operations for a command.</p>
 * See {@code monaco.d.ts:1907:42}<br>
 * Original signature:<br>
 * {@code export interface IEditOperationBuilder  }<br>
 */
@SuppressWarnings("unused")
public class IEditOperationBuilder extends JsProxy {

	public IEditOperationBuilder(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IEditOperationBuilder(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Add a new edit operation (a replace operation).</p>
	 * See {@code monaco.d.ts:1913:24}<br>
	 * Original signature:<br>
	 * {@code addEditOperation(range: Range, text: string | null, forceMoveMarkers?: boolean): void; }<br>
	 * 
	 * @param range The range to replace (delete). May be empty to represent a simple insert.
	 * @param text The text to replace with. May be null to represent a simple delete.
	 */
	public void addEditOperation(@Nonnull Range range, @Nullable String text, @Nonnull Boolean forceMoveMarkers) { call("addEditOperation", ofVoid(), range, text, forceMoveMarkers); }

 	/**
	 * <p>Add a new edit operation (a replace operation).</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:1913:24}<br>
	 * Original signature:<br>
	 * {@code addEditOperation(range: Range, text: string | null, forceMoveMarkers?: boolean): void; }<br>
	 */
	public void addEditOperation(@Nonnull Range range, @Nullable String text) { call("addEditOperation", ofVoid(), range, text); }

 	/**
	 * <p>Add a new edit operation (a replace operation).
	 * The inverse edits will be accessible in <code>ICursorStateComputerData.getInverseEditOperations()</code></p>
	 * See {@code monaco.d.ts:1920:31}<br>
	 * Original signature:<br>
	 * {@code addTrackedEditOperation(range: Range, text: string | null, forceMoveMarkers?: boolean): void; }<br>
	 * 
	 * @param range The range to replace (delete). May be empty to represent a simple insert.
	 * @param text The text to replace with. May be null to represent a simple delete.
	 */
	public void addTrackedEditOperation(@Nonnull Range range, @Nullable String text, @Nonnull Boolean forceMoveMarkers) { call("addTrackedEditOperation", ofVoid(), range, text, forceMoveMarkers); }

 	/**
	 * <p>Add a new edit operation (a replace operation).
	 * The inverse edits will be accessible in <code>ICursorStateComputerData.getInverseEditOperations()</code></p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:1920:31}<br>
	 * Original signature:<br>
	 * {@code addTrackedEditOperation(range: Range, text: string | null, forceMoveMarkers?: boolean): void; }<br>
	 */
	public void addTrackedEditOperation(@Nonnull Range range, @Nullable String text) { call("addTrackedEditOperation", ofVoid(), range, text); }

 	/**
	 * <p>Track <code>selection</code> when applying edit operations.
	 * A best effort will be made to not grow/expand the selection.
	 * An empty selection will clamp to a nearby character.</p>
	 * See {@code monaco.d.ts:1930:22}<br>
	 * Original signature:<br>
	 * {@code trackSelection(selection: Selection, trackPreviousOnEmpty?: boolean): string; }<br>
	 * 
	 * @param selection The selection to track.
	 * @param trackPreviousOnEmpty <p>If set, and the selection is empty, indicates whether the selection
should clamp to the previous or the next character.</p>
	 */
	public String trackSelection(@Nonnull Selection selection, @Nonnull Boolean trackPreviousOnEmpty) { return call("trackSelection", ofMapped(String.class), selection, trackPreviousOnEmpty); }

 	/**
	 * <p>Track <code>selection</code> when applying edit operations.
	 * A best effort will be made to not grow/expand the selection.
	 * An empty selection will clamp to a nearby character.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:1930:22}<br>
	 * Original signature:<br>
	 * {@code trackSelection(selection: Selection, trackPreviousOnEmpty?: boolean): string; }<br>
	 */
	public String trackSelection(@Nonnull Selection selection) { return call("trackSelection", ofMapped(String.class), selection); }

 
}
