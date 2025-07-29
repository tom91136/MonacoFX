
package monaco_editor.monaco.editor;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import monaco_editor.monaco.Range;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>A single edit operation, that has an identifier.</p>
 * See {@code monaco.d.ts:1498:51}<br>
 * Original signature:<br>
 * {@code export interface IIdentifiedSingleEditOperation  }<br>
 */
@SuppressWarnings("unused")
public class IIdentifiedSingleEditOperation extends JsProxy {

	public IIdentifiedSingleEditOperation(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IIdentifiedSingleEditOperation(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>This indicates that this operation has &quot;insert&quot; semantics.
	 * i.e. forceMoveMarkers = true =&gt; if <code>range</code> is collapsed, all markers at the position will be moved.</p>
	 * See {@code monaco.d.ts:1511:24}<br>
	 * Original signature:<br>
	 * {@code forceMoveMarkers?: boolean; }<br>
	 */
	public boolean forceMoveMarkers() { return get("forceMoveMarkers", ofMapped(boolean.class)); }

 	/**
	 * <p>This indicates that this operation has &quot;insert&quot; semantics.
	 * i.e. forceMoveMarkers = true =&gt; if <code>range</code> is collapsed, all markers at the position will be moved.</p>
	 * See {@code monaco.d.ts:1511:24}<br>
	 * Original signature:<br>
	 * {@code forceMoveMarkers?: boolean; }<br>
	 */
	public IIdentifiedSingleEditOperation forceMoveMarkers(@Nonnull Boolean value) {
		set("forceMoveMarkers", value);
		return this;
	}

 	/**
	 * <p>The range to replace. This can be empty to emulate a simple insert.</p>
	 * See {@code monaco.d.ts:1502:13}<br>
	 * Original signature:<br>
	 * {@code range: Range; }<br>
	 */
	public Range range() { return get("range", Range::new); }

 	/**
	 * <p>The range to replace. This can be empty to emulate a simple insert.</p>
	 * See {@code monaco.d.ts:1502:13}<br>
	 * Original signature:<br>
	 * {@code range: Range; }<br>
	 */
	public IIdentifiedSingleEditOperation range(@Nonnull Range value) {
		set("range", value);
		return this;
	}

 	/**
	 * <p>The text to replace with. This can be null to emulate a simple delete.</p>
	 * See {@code monaco.d.ts:1506:12}<br>
	 * Original signature:<br>
	 * {@code text: string | null; }<br>
	 */
	public Optional<String> text() { return Optional.ofNullable(get("text", ofMapped(String.class))); }

 	/**
	 * <p>The text to replace with. This can be null to emulate a simple delete.</p>
	 * See {@code monaco.d.ts:1506:12}<br>
	 * Original signature:<br>
	 * {@code text: string | null; }<br>
	 */
	public IIdentifiedSingleEditOperation text(@Nullable String value) {
		set("text", value);
		return this;
	}

 
}
