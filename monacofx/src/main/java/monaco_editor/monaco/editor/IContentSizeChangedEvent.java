
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:2028:45}<br>
 * Original signature:<br>
 * {@code export interface IContentSizeChangedEvent  }<br>
 */
@SuppressWarnings("unused")
public class IContentSizeChangedEvent extends JsProxy {

	public IContentSizeChangedEvent(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IContentSizeChangedEvent(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:2030:30}<br>
	 * Original signature:<br>
	 * {@code readonly contentHeight: number; }<br>
	 */
	public double contentHeight() { return get("contentHeight", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:2032:37}<br>
	 * Original signature:<br>
	 * {@code readonly contentHeightChanged: boolean; }<br>
	 */
	public boolean contentHeightChanged() { return get("contentHeightChanged", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:2029:29}<br>
	 * Original signature:<br>
	 * {@code readonly contentWidth: number; }<br>
	 */
	public double contentWidth() { return get("contentWidth", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:2031:36}<br>
	 * Original signature:<br>
	 * {@code readonly contentWidthChanged: boolean; }<br>
	 */
	public boolean contentWidthChanged() { return get("contentWidthChanged", ofMapped(boolean.class)); }

 
}
