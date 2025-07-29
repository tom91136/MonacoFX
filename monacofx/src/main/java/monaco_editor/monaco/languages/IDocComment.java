
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>Definition of documentation comments (e.g. Javadoc/JSdoc)</p>
 * See {@code monaco.d.ts:5058:32}<br>
 * Original signature:<br>
 * {@code export interface IDocComment  }<br>
 */
@SuppressWarnings("unused")
public class IDocComment extends JsProxy {

	public IDocComment(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IDocComment(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>The string that appears on the last line and closes the doc comment (e.g. ' * /').</p>
	 * See {@code monaco.d.ts:5066:13}<br>
	 * Original signature:<br>
	 * {@code close?: string; }<br>
	 */
	public String close() { return get("close", ofMapped(String.class)); }

 	/**
	 * <p>The string that appears on the last line and closes the doc comment (e.g. ' * /').</p>
	 * See {@code monaco.d.ts:5066:13}<br>
	 * Original signature:<br>
	 * {@code close?: string; }<br>
	 */
	public IDocComment close(@Nonnull String value) {
		set("close", value);
		return this;
	}

 	/**
	 * <p>The string that starts a doc comment (e.g. '/**')</p>
	 * See {@code monaco.d.ts:5062:12}<br>
	 * Original signature:<br>
	 * {@code open: string; }<br>
	 */
	public String open() { return get("open", ofMapped(String.class)); }

 	/**
	 * <p>The string that starts a doc comment (e.g. '/**')</p>
	 * See {@code monaco.d.ts:5062:12}<br>
	 * Original signature:<br>
	 * {@code open: string; }<br>
	 */
	public IDocComment open(@Nonnull String value) {
		set("open", value);
		return this;
	}

 
}
