
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>Configuration options for parameter hints</p>
 * See {@code monaco.d.ts:3372:48}<br>
 * Original signature:<br>
 * {@code export interface IEditorParameterHintOptions  }<br>
 */
@SuppressWarnings("unused")
public class IEditorParameterHintOptions extends JsProxy {

	public IEditorParameterHintOptions(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IEditorParameterHintOptions(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Enable cycling of parameter hints.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:3382:13}<br>
	 * Original signature:<br>
	 * {@code cycle?: boolean; }<br>
	 */
	public boolean cycle() { return get("cycle", ofMapped(boolean.class)); }

 	/**
	 * <p>Enable cycling of parameter hints.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:3382:13}<br>
	 * Original signature:<br>
	 * {@code cycle?: boolean; }<br>
	 */
	public IEditorParameterHintOptions cycle(@Nonnull Boolean value) {
		set("cycle", value);
		return this;
	}

 	/**
	 * <p>Enable parameter hints.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:3377:15}<br>
	 * Original signature:<br>
	 * {@code enabled?: boolean; }<br>
	 */
	public boolean enabled() { return get("enabled", ofMapped(boolean.class)); }

 	/**
	 * <p>Enable parameter hints.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:3377:15}<br>
	 * Original signature:<br>
	 * {@code enabled?: boolean; }<br>
	 */
	public IEditorParameterHintOptions enabled(@Nonnull Boolean value) {
		set("enabled", value);
		return this;
	}

 
}
