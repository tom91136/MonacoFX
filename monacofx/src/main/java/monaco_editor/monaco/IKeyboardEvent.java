
package monaco_editor.monaco;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import netscape.javascript.JSObject;

/**
 * See {@code monaco.d.ts:400:35}<br>
 * Original signature:<br>
 * {@code export interface IKeyboardEvent  }<br>
 */
@SuppressWarnings("unused")
public class IKeyboardEvent extends JsProxy {

	public IKeyboardEvent(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IKeyboardEvent(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:401:44}<br>
	 * Original signature:<br>
	 * {@code readonly _standardKeyboardEventBrand: true; }<br>
	 */
	public boolean _standardKeyboardEventBrand() { return get("_standardKeyboardEventBrand", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:406:23}<br>
	 * Original signature:<br>
	 * {@code readonly altKey: boolean; }<br>
	 */
	public boolean altKey() { return get("altKey", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:402:29}<br>
	 * Original signature:<br>
	 * {@code readonly browserEvent: KeyboardEvent; }<br>
	 */
	public JSObject browserEvent() { return get("browserEvent", ofMapped(JSObject.class)); }

 	/**
	 * See {@code monaco.d.ts:409:21}<br>
	 * Original signature:<br>
	 * {@code readonly code: string; }<br>
	 */
	public String code() { return get("code", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:404:24}<br>
	 * Original signature:<br>
	 * {@code readonly ctrlKey: boolean; }<br>
	 */
	public boolean ctrlKey() { return get("ctrlKey", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:408:24}<br>
	 * Original signature:<br>
	 * {@code readonly keyCode: KeyCode; }<br>
	 */
	public KeyCode keyCode() { return get("keyCode", ofJsEnum(KeyCode.class)); }

 	/**
	 * See {@code monaco.d.ts:407:24}<br>
	 * Original signature:<br>
	 * {@code readonly metaKey: boolean; }<br>
	 */
	public boolean metaKey() { return get("metaKey", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:405:25}<br>
	 * Original signature:<br>
	 * {@code readonly shiftKey: boolean; }<br>
	 */
	public boolean shiftKey() { return get("shiftKey", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:403:23}<br>
	 * Original signature:<br>
	 * {@code readonly target: HTMLElement; }<br>
	 */
	public JSObject target() { return get("target", ofMapped(JSObject.class)); }

 	/**
	 * See {@code monaco.d.ts:410:14}<br>
	 * Original signature:<br>
	 * {@code equals(keybinding: number): boolean; }<br>
	 */
	public boolean equals(@Nonnull Double keybinding) { return call("equals", ofMapped(boolean.class), keybinding); }

 	/**
	 * See {@code monaco.d.ts:411:22}<br>
	 * Original signature:<br>
	 * {@code preventDefault(): void; }<br>
	 */
	public void preventDefault() { call("preventDefault", ofVoid()); }

 	/**
	 * See {@code monaco.d.ts:412:23}<br>
	 * Original signature:<br>
	 * {@code stopPropagation(): void; }<br>
	 */
	public void stopPropagation() { call("stopPropagation", ofVoid()); }

 
}
