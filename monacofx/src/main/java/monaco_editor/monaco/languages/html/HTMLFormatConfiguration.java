
package monaco_editor.monaco.languages.html;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:6784:44}<br>
 * Original signature:<br>
 * {@code export interface HTMLFormatConfiguration  }<br>
 */
@SuppressWarnings("unused")
public class HTMLFormatConfiguration extends JsProxy {

	public HTMLFormatConfiguration(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public HTMLFormatConfiguration(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:6789:35}<br>
	 * Original signature:<br>
	 * {@code readonly contentUnformatted: string; }<br>
	 */
	public String contentUnformatted() { return get("contentUnformatted", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:6794:31}<br>
	 * Original signature:<br>
	 * {@code readonly endWithNewline: boolean; }<br>
	 */
	public boolean endWithNewline() { return get("endWithNewline", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6795:28}<br>
	 * Original signature:<br>
	 * {@code readonly extraLiners: string; }<br>
	 */
	public String extraLiners() { return get("extraLiners", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:6793:33}<br>
	 * Original signature:<br>
	 * {@code readonly indentHandlebars: boolean; }<br>
	 */
	public boolean indentHandlebars() { return get("indentHandlebars", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6790:32}<br>
	 * Original signature:<br>
	 * {@code readonly indentInnerHtml: boolean; }<br>
	 */
	public boolean indentInnerHtml() { return get("indentInnerHtml", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6786:29}<br>
	 * Original signature:<br>
	 * {@code readonly insertSpaces: boolean; }<br>
	 */
	public boolean insertSpaces() { return get("insertSpaces", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6792:36}<br>
	 * Original signature:<br>
	 * {@code readonly maxPreserveNewLines: number; }<br>
	 */
	public double maxPreserveNewLines() { return get("maxPreserveNewLines", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:6791:33}<br>
	 * Original signature:<br>
	 * {@code readonly preserveNewLines: boolean; }<br>
	 */
	public boolean preserveNewLines() { return get("preserveNewLines", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6785:24}<br>
	 * Original signature:<br>
	 * {@code readonly tabSize: number; }<br>
	 */
	public double tabSize() { return get("tabSize", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:6788:28}<br>
	 * Original signature:<br>
	 * {@code readonly unformatted: string; }<br>
	 */
	public String unformatted() { return get("unformatted", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:6787:31}<br>
	 * Original signature:<br>
	 * {@code readonly wrapLineLength: number; }<br>
	 */
	public double wrapLineLength() { return get("wrapLineLength", ofMapped(double.class)); }

 
}
