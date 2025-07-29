
package monaco_editor.monaco;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:383:23}<br>
 * Original signature:<br>
 * {@code export class KeyMod  }<br>
 */
@SuppressWarnings("unused")
public class KeyMod extends JsProxy {

	public KeyMod(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public KeyMod(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:386:27}<br>
	 * Original signature:<br>
	 * {@code static readonly Alt: number; }<br>
	 */
	public double Alt() { return get("Alt", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:384:31}<br>
	 * Original signature:<br>
	 * {@code static readonly CtrlCmd: number; }<br>
	 */
	public double CtrlCmd() { return get("CtrlCmd", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:385:29}<br>
	 * Original signature:<br>
	 * {@code static readonly Shift: number; }<br>
	 */
	public double Shift() { return get("Shift", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:387:31}<br>
	 * Original signature:<br>
	 * {@code static readonly WinCtrl: number; }<br>
	 */
	public double WinCtrl() { return get("WinCtrl", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:388:20}<br>
	 * Original signature:<br>
	 * {@code static chord(firstPart: number, secondPart: number): number; }<br>
	 */
	public double chord(@Nonnull Double firstPart, @Nonnull Double secondPart) { return call("chord", ofMapped(double.class), firstPart, secondPart); }

 
}
