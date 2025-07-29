
package monaco_editor.monaco;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import netscape.javascript.JSObject;

/**
 * See {@code monaco.d.ts:414:32}<br>
 * Original signature:<br>
 * {@code export interface IMouseEvent  }<br>
 */
@SuppressWarnings("unused")
public class IMouseEvent extends JsProxy {

	public IMouseEvent(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IMouseEvent(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:426:23}<br>
	 * Original signature:<br>
	 * {@code readonly altKey: boolean; }<br>
	 */
	public boolean altKey() { return get("altKey", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:415:29}<br>
	 * Original signature:<br>
	 * {@code readonly browserEvent: MouseEvent; }<br>
	 */
	public JSObject browserEvent() { return get("browserEvent", ofMapped(JSObject.class)); }

 	/**
	 * See {@code monaco.d.ts:419:24}<br>
	 * Original signature:<br>
	 * {@code readonly buttons: number; }<br>
	 */
	public double buttons() { return get("buttons", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:424:24}<br>
	 * Original signature:<br>
	 * {@code readonly ctrlKey: boolean; }<br>
	 */
	public boolean ctrlKey() { return get("ctrlKey", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:421:23}<br>
	 * Original signature:<br>
	 * {@code readonly detail: number; }<br>
	 */
	public double detail() { return get("detail", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:416:27}<br>
	 * Original signature:<br>
	 * {@code readonly leftButton: boolean; }<br>
	 */
	public boolean leftButton() { return get("leftButton", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:427:24}<br>
	 * Original signature:<br>
	 * {@code readonly metaKey: boolean; }<br>
	 */
	public boolean metaKey() { return get("metaKey", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:417:29}<br>
	 * Original signature:<br>
	 * {@code readonly middleButton: boolean; }<br>
	 */
	public boolean middleButton() { return get("middleButton", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:422:21}<br>
	 * Original signature:<br>
	 * {@code readonly posx: number; }<br>
	 */
	public double posx() { return get("posx", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:423:21}<br>
	 * Original signature:<br>
	 * {@code readonly posy: number; }<br>
	 */
	public double posy() { return get("posy", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:418:28}<br>
	 * Original signature:<br>
	 * {@code readonly rightButton: boolean; }<br>
	 */
	public boolean rightButton() { return get("rightButton", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:425:25}<br>
	 * Original signature:<br>
	 * {@code readonly shiftKey: boolean; }<br>
	 */
	public boolean shiftKey() { return get("shiftKey", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:420:23}<br>
	 * Original signature:<br>
	 * {@code readonly target: HTMLElement; }<br>
	 */
	public JSObject target() { return get("target", ofMapped(JSObject.class)); }

 	/**
	 * See {@code monaco.d.ts:428:26}<br>
	 * Original signature:<br>
	 * {@code readonly timestamp: number; }<br>
	 */
	public double timestamp() { return get("timestamp", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:429:22}<br>
	 * Original signature:<br>
	 * {@code preventDefault(): void; }<br>
	 */
	public void preventDefault() { call("preventDefault", ofVoid()); }

 	/**
	 * See {@code monaco.d.ts:430:23}<br>
	 * Original signature:<br>
	 * {@code stopPropagation(): void; }<br>
	 */
	public void stopPropagation() { call("stopPropagation", ofVoid()); }

 
}
