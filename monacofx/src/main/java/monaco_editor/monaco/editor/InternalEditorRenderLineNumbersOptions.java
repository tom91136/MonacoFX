
package monaco_editor.monaco.editor;
import java.util.Optional;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import netscape.javascript.JSObject;

/**
 * See {@code monaco.d.ts:3408:59}<br>
 * Original signature:<br>
 * {@code export interface InternalEditorRenderLineNumbersOptions  }<br>
 */
@SuppressWarnings("unused")
public class InternalEditorRenderLineNumbersOptions extends JsProxy {

	public InternalEditorRenderLineNumbersOptions(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public InternalEditorRenderLineNumbersOptions(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:3410:25}<br>
	 * Original signature:<br>
	 * {@code readonly renderFn: ((lineNumber: number) => string) | null; }<br>
	 */
	public Optional<JSObject> renderFn() { return Optional.ofNullable(get("renderFn", ofMapped(JSObject.class))); }

 	/**
	 * See {@code monaco.d.ts:3409:27}<br>
	 * Original signature:<br>
	 * {@code readonly renderType: RenderLineNumbersType; }<br>
	 */
	public RenderLineNumbersType renderType() { return get("renderType", ofJsEnum(RenderLineNumbersType.class)); }

 
}
