
package monaco_editor.monaco.languages.typescript;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:6369:24}<br>
 * Original signature:<br>
 * {@code interface OutputFile  }<br>
 */
@SuppressWarnings("unused")
public class OutputFile extends JsProxy {

	public OutputFile(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public OutputFile(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:6370:12}<br>
	 * Original signature:<br>
	 * {@code name: string; }<br>
	 */
	public String name() { return get("name", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:6370:12}<br>
	 * Original signature:<br>
	 * {@code name: string; }<br>
	 */
	public OutputFile name(@Nonnull String value) {
		set("name", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6372:12}<br>
	 * Original signature:<br>
	 * {@code text: string; }<br>
	 */
	public String text() { return get("text", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:6372:12}<br>
	 * Original signature:<br>
	 * {@code text: string; }<br>
	 */
	public OutputFile text(@Nonnull String value) {
		set("text", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6371:26}<br>
	 * Original signature:<br>
	 * {@code writeByteOrderMark: boolean; }<br>
	 */
	public boolean writeByteOrderMark() { return get("writeByteOrderMark", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6371:26}<br>
	 * Original signature:<br>
	 * {@code writeByteOrderMark: boolean; }<br>
	 */
	public OutputFile writeByteOrderMark(@Nonnull Boolean value) {
		set("writeByteOrderMark", value);
		return this;
	}

 
}
