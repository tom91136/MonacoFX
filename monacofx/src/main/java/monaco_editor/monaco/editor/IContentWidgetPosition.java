
package monaco_editor.monaco.editor;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import monaco_editor.monaco.IPosition;
import monaco_editor.monaco.IRange;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>A position for rendering content widgets.</p>
 * See {@code monaco.d.ts:3999:43}<br>
 * Original signature:<br>
 * {@code export interface IContentWidgetPosition  }<br>
 */
@SuppressWarnings("unused")
public class IContentWidgetPosition extends JsProxy {

	public IContentWidgetPosition(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IContentWidgetPosition(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Desired position for the content widget.
	 * <code>preference</code> will also affect the placement.</p>
	 * See {@code monaco.d.ts:4004:16}<br>
	 * Original signature:<br>
	 * {@code position: IPosition | null; }<br>
	 */
	public Optional<IPosition> position() { return Optional.ofNullable(get("position", IPosition::new)); }

 	/**
	 * <p>Desired position for the content widget.
	 * <code>preference</code> will also affect the placement.</p>
	 * See {@code monaco.d.ts:4004:16}<br>
	 * Original signature:<br>
	 * {@code position: IPosition | null; }<br>
	 */
	public IContentWidgetPosition position(@Nullable IPosition value) {
		set("position", value);
		return this;
	}

 	/**
	 * <p>Placement preference for position, in order of preference.</p>
	 * See {@code monaco.d.ts:4013:18}<br>
	 * Original signature:<br>
	 * {@code preference: ContentWidgetPositionPreference[]; }<br>
	 */
	public List<ContentWidgetPositionPreference> preference() { return get("preference", ofArray(ofJsEnum(ContentWidgetPositionPreference.class))); }

 	/**
	 * <p>Placement preference for position, in order of preference.</p>
	 * See {@code monaco.d.ts:4013:18}<br>
	 * Original signature:<br>
	 * {@code preference: ContentWidgetPositionPreference[]; }<br>
	 */
	public IContentWidgetPosition preference(@Nonnull List<ContentWidgetPositionPreference> value) {
		
		return this;
	}

 	/**
	 * <p>Optionally, a range can be provided to further
	 * define the position of the content widget.</p>
	 * See {@code monaco.d.ts:4009:13}<br>
	 * Original signature:<br>
	 * {@code range?: IRange | null; }<br>
	 */
	public Optional<IRange> range() { return Optional.ofNullable(get("range", IRange::new)); }

 	/**
	 * <p>Optionally, a range can be provided to further
	 * define the position of the content widget.</p>
	 * See {@code monaco.d.ts:4009:13}<br>
	 * Original signature:<br>
	 * {@code range?: IRange | null; }<br>
	 */
	public IContentWidgetPosition range(@Nullable IRange value) {
		set("range", value);
		return this;
	}

 
}
