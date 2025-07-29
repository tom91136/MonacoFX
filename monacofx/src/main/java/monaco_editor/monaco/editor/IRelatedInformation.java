
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import monaco_editor.monaco.Uri;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:1226:40}<br>
 * Original signature:<br>
 * {@code export interface IRelatedInformation  }<br>
 */
@SuppressWarnings("unused")
public class IRelatedInformation extends JsProxy {

	public IRelatedInformation(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IRelatedInformation(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:1232:17}<br>
	 * Original signature:<br>
	 * {@code endColumn: number; }<br>
	 */
	public double endColumn() { return get("endColumn", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:1232:17}<br>
	 * Original signature:<br>
	 * {@code endColumn: number; }<br>
	 */
	public IRelatedInformation endColumn(@Nonnull Double value) {
		set("endColumn", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1231:21}<br>
	 * Original signature:<br>
	 * {@code endLineNumber: number; }<br>
	 */
	public double endLineNumber() { return get("endLineNumber", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:1231:21}<br>
	 * Original signature:<br>
	 * {@code endLineNumber: number; }<br>
	 */
	public IRelatedInformation endLineNumber(@Nonnull Double value) {
		set("endLineNumber", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1228:15}<br>
	 * Original signature:<br>
	 * {@code message: string; }<br>
	 */
	public String message() { return get("message", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:1228:15}<br>
	 * Original signature:<br>
	 * {@code message: string; }<br>
	 */
	public IRelatedInformation message(@Nonnull String value) {
		set("message", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1227:16}<br>
	 * Original signature:<br>
	 * {@code resource: Uri; }<br>
	 */
	public Uri resource() { return get("resource", Uri::new); }

 	/**
	 * See {@code monaco.d.ts:1227:16}<br>
	 * Original signature:<br>
	 * {@code resource: Uri; }<br>
	 */
	public IRelatedInformation resource(@Nonnull Uri value) {
		set("resource", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1230:19}<br>
	 * Original signature:<br>
	 * {@code startColumn: number; }<br>
	 */
	public double startColumn() { return get("startColumn", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:1230:19}<br>
	 * Original signature:<br>
	 * {@code startColumn: number; }<br>
	 */
	public IRelatedInformation startColumn(@Nonnull Double value) {
		set("startColumn", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1229:23}<br>
	 * Original signature:<br>
	 * {@code startLineNumber: number; }<br>
	 */
	public double startLineNumber() { return get("startLineNumber", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:1229:23}<br>
	 * Original signature:<br>
	 * {@code startLineNumber: number; }<br>
	 */
	public IRelatedInformation startLineNumber(@Nonnull Double value) {
		set("startLineNumber", value);
		return this;
	}

 
}
