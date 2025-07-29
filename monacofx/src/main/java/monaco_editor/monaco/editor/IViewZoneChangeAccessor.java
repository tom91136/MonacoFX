
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>An accessor that allows for zones to be added or removed.</p>
 * See {@code monaco.d.ts:3959:44}<br>
 * Original signature:<br>
 * {@code export interface IViewZoneChangeAccessor  }<br>
 */
@SuppressWarnings("unused")
public class IViewZoneChangeAccessor extends JsProxy {

	public IViewZoneChangeAccessor(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IViewZoneChangeAccessor(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Create a new view zone.</p>
	 * See {@code monaco.d.ts:3965:15}<br>
	 * Original signature:<br>
	 * {@code addZone(zone: IViewZone): string; }<br>
	 * 
	 * @param zone Zone to create
	 */
	public String addZone(@Nonnull IViewZone zone) { return call("addZone", ofMapped(String.class), zone); }

 	/**
	 * <p>Change a zone's position.
	 * The editor will rescan the <code>afterLineNumber</code> and <code>afterColumn</code> properties of a view zone.</p>
	 * See {@code monaco.d.ts:3975:18}<br>
	 * Original signature:<br>
	 * {@code layoutZone(id: string): void; }<br>
	 */
	public void layoutZone(@Nonnull String id) { call("layoutZone", ofVoid(), id); }

 	/**
	 * <p>Remove a zone</p>
	 * See {@code monaco.d.ts:3970:18}<br>
	 * Original signature:<br>
	 * {@code removeZone(id: string): void; }<br>
	 * 
	 * @param id A unique identifier to the view zone, as returned by the <code>addZone</code> call.
	 */
	public void removeZone(@Nonnull String id) { call("removeZone", ofVoid(), id); }

 
}
