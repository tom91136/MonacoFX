
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:2373:46}<br>
 * Original signature:<br>
 * {@code export interface IModelOptionsChangedEvent  }<br>
 */
@SuppressWarnings("unused")
public class IModelOptionsChangedEvent extends JsProxy {

	public IModelOptionsChangedEvent(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IModelOptionsChangedEvent(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:2375:27}<br>
	 * Original signature:<br>
	 * {@code readonly indentSize: boolean; }<br>
	 */
	public boolean indentSize() { return get("indentSize", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:2376:29}<br>
	 * Original signature:<br>
	 * {@code readonly insertSpaces: boolean; }<br>
	 */
	public boolean insertSpaces() { return get("insertSpaces", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:2374:24}<br>
	 * Original signature:<br>
	 * {@code readonly tabSize: boolean; }<br>
	 */
	public boolean tabSize() { return get("tabSize", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:2377:35}<br>
	 * Original signature:<br>
	 * {@code readonly trimAutoWhitespace: boolean; }<br>
	 */
	public boolean trimAutoWhitespace() { return get("trimAutoWhitespace", ofMapped(boolean.class)); }

 
}
