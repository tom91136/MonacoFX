
package monaco_editor.monaco.editor;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import monaco_editor.monaco.IRange;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>A single edit operation, that acts as a simple replace.
 * i.e. Replace text at <code>range</code> with <code>text</code> in model.</p>
 * See {@code monaco.d.ts:1479:41}<br>
 * Original signature:<br>
 * {@code export interface ISingleEditOperation  }<br>
 */
@SuppressWarnings("unused")
public class ISingleEditOperation extends JsProxy {

	public ISingleEditOperation(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public ISingleEditOperation(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>This indicates that this operation has &quot;insert&quot; semantics.
	 * i.e. forceMoveMarkers = true =&gt; if <code>range</code> is collapsed, all markers at the position will be moved.</p>
	 * See {@code monaco.d.ts:1492:24}<br>
	 * Original signature:<br>
	 * {@code forceMoveMarkers?: boolean; }<br>
	 */
	public boolean forceMoveMarkers() { return get("forceMoveMarkers", ofMapped(boolean.class)); }

 	/**
	 * <p>This indicates that this operation has &quot;insert&quot; semantics.
	 * i.e. forceMoveMarkers = true =&gt; if <code>range</code> is collapsed, all markers at the position will be moved.</p>
	 * See {@code monaco.d.ts:1492:24}<br>
	 * Original signature:<br>
	 * {@code forceMoveMarkers?: boolean; }<br>
	 */
	public ISingleEditOperation forceMoveMarkers(@Nonnull Boolean value) {
		set("forceMoveMarkers", value);
		return this;
	}

 	/**
	 * <p>The range to replace. This can be empty to emulate a simple insert.</p>
	 * See {@code monaco.d.ts:1483:13}<br>
	 * Original signature:<br>
	 * {@code range: IRange; }<br>
	 */
	public IRange range() { return get("range", IRange::new); }

 	/**
	 * <p>The range to replace. This can be empty to emulate a simple insert.</p>
	 * See {@code monaco.d.ts:1483:13}<br>
	 * Original signature:<br>
	 * {@code range: IRange; }<br>
	 */
	public ISingleEditOperation range(@Nonnull IRange value) {
		set("range", value);
		return this;
	}

 	/**
	 * <p>The text to replace with. This can be null to emulate a simple delete.</p>
	 * See {@code monaco.d.ts:1487:12}<br>
	 * Original signature:<br>
	 * {@code text: string | null; }<br>
	 */
	public Optional<String> text() { return Optional.ofNullable(get("text", ofMapped(String.class))); }

 	/**
	 * <p>The text to replace with. This can be null to emulate a simple delete.</p>
	 * See {@code monaco.d.ts:1487:12}<br>
	 * Original signature:<br>
	 * {@code text: string | null; }<br>
	 */
	public ISingleEditOperation text(@Nullable String value) {
		set("text", value);
		return this;
	}

 
}
