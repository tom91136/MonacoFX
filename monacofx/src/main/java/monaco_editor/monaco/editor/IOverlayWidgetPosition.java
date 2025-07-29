
package monaco_editor.monaco.editor;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>A position for rendering overlay widgets.</p>
 * See {@code monaco.d.ts:4061:43}<br>
 * Original signature:<br>
 * {@code export interface IOverlayWidgetPosition  }<br>
 */
@SuppressWarnings("unused")
public class IOverlayWidgetPosition extends JsProxy {

	public IOverlayWidgetPosition(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IOverlayWidgetPosition(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>The position preference for the overlay widget.</p>
	 * See {@code monaco.d.ts:4065:18}<br>
	 * Original signature:<br>
	 * {@code preference: OverlayWidgetPositionPreference | null; }<br>
	 */
	public Optional<OverlayWidgetPositionPreference> preference() { return Optional.ofNullable(get("preference", ofJsEnum(OverlayWidgetPositionPreference.class))); }

 	/**
	 * <p>The position preference for the overlay widget.</p>
	 * See {@code monaco.d.ts:4065:18}<br>
	 * Original signature:<br>
	 * {@code preference: OverlayWidgetPositionPreference | null; }<br>
	 */
	public IOverlayWidgetPosition preference(@Nullable OverlayWidgetPositionPreference value) {
		set("preference", value);
		return this;
	}

 
}
