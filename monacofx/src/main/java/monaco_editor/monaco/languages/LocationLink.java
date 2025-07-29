
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import monaco_editor.monaco.IRange;
import monaco_editor.monaco.Uri;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:5572:33}<br>
 * Original signature:<br>
 * {@code export interface LocationLink  }<br>
 */
@SuppressWarnings("unused")
public class LocationLink extends JsProxy {

	public LocationLink(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public LocationLink(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>A range to select where this link originates from.</p>
	 * See {@code monaco.d.ts:5576:28}<br>
	 * Original signature:<br>
	 * {@code originSelectionRange?: IRange; }<br>
	 */
	public IRange originSelectionRange() { return get("originSelectionRange", IRange::new); }

 	/**
	 * <p>A range to select where this link originates from.</p>
	 * See {@code monaco.d.ts:5576:28}<br>
	 * Original signature:<br>
	 * {@code originSelectionRange?: IRange; }<br>
	 */
	public LocationLink originSelectionRange(@Nonnull IRange value) {
		set("originSelectionRange", value);
		return this;
	}

 	/**
	 * <p>The full range this link points to.</p>
	 * See {@code monaco.d.ts:5584:13}<br>
	 * Original signature:<br>
	 * {@code range: IRange; }<br>
	 */
	public IRange range() { return get("range", IRange::new); }

 	/**
	 * <p>The full range this link points to.</p>
	 * See {@code monaco.d.ts:5584:13}<br>
	 * Original signature:<br>
	 * {@code range: IRange; }<br>
	 */
	public LocationLink range(@Nonnull IRange value) {
		set("range", value);
		return this;
	}

 	/**
	 * <p>A range to select this link points to. Must be contained
	 * in <code>LocationLink.range</code>.</p>
	 * See {@code monaco.d.ts:5589:28}<br>
	 * Original signature:<br>
	 * {@code targetSelectionRange?: IRange; }<br>
	 */
	public IRange targetSelectionRange() { return get("targetSelectionRange", IRange::new); }

 	/**
	 * <p>A range to select this link points to. Must be contained
	 * in <code>LocationLink.range</code>.</p>
	 * See {@code monaco.d.ts:5589:28}<br>
	 * Original signature:<br>
	 * {@code targetSelectionRange?: IRange; }<br>
	 */
	public LocationLink targetSelectionRange(@Nonnull IRange value) {
		set("targetSelectionRange", value);
		return this;
	}

 	/**
	 * <p>The target uri this link points to.</p>
	 * See {@code monaco.d.ts:5580:11}<br>
	 * Original signature:<br>
	 * {@code uri: Uri; }<br>
	 */
	public Uri uri() { return get("uri", Uri::new); }

 	/**
	 * <p>The target uri this link points to.</p>
	 * See {@code monaco.d.ts:5580:11}<br>
	 * Original signature:<br>
	 * {@code uri: Uri; }<br>
	 */
	public LocationLink uri(@Nonnull Uri value) {
		set("uri", value);
		return this;
	}

 
}
