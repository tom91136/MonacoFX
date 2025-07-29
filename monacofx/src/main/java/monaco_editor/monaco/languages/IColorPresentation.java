
package monaco_editor.monaco.languages;
import java.util.List;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import netscape.javascript.JSObject;

/**
 * <p>String representations for a color</p>
 * See {@code monaco.d.ts:5810:39}<br>
 * Original signature:<br>
 * {@code export interface IColorPresentation  }<br>
 */
@SuppressWarnings("unused")
public class IColorPresentation extends JsProxy {

	public IColorPresentation(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IColorPresentation(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>An optional array of additional <a href="#TextEdit">text edits</a> that are applied when
	 * selecting this color presentation.</p>
	 * See {@code monaco.d.ts:5826:27}<br>
	 * Original signature:<br>
	 * {@code additionalTextEdits?: TextEdit[]; }<br>
	 */
	public List<JSObject> additionalTextEdits() { return get("additionalTextEdits", ofArray(ofMapped(JSObject.class))); }

 	/**
	 * <p>An optional array of additional <a href="#TextEdit">text edits</a> that are applied when
	 * selecting this color presentation.</p>
	 * See {@code monaco.d.ts:5826:27}<br>
	 * Original signature:<br>
	 * {@code additionalTextEdits?: TextEdit[]; }<br>
	 */
	public IColorPresentation additionalTextEdits(@Nonnull List<JSObject> value) {
		
		return this;
	}

 	/**
	 * <p>The label of this color presentation. It will be shown on the color
	 * picker header. By default this is also the text that is inserted when selecting
	 * this color presentation.</p>
	 * See {@code monaco.d.ts:5816:13}<br>
	 * Original signature:<br>
	 * {@code label: string; }<br>
	 */
	public String label() { return get("label", ofMapped(String.class)); }

 	/**
	 * <p>The label of this color presentation. It will be shown on the color
	 * picker header. By default this is also the text that is inserted when selecting
	 * this color presentation.</p>
	 * See {@code monaco.d.ts:5816:13}<br>
	 * Original signature:<br>
	 * {@code label: string; }<br>
	 */
	public IColorPresentation label(@Nonnull String value) {
		set("label", value);
		return this;
	}

 	/**
	 * <p>An <a href="#TextEdit">edit</a> which is applied to a document when selecting
	 * this presentation for the color.</p>
	 * See {@code monaco.d.ts:5821:16}<br>
	 * Original signature:<br>
	 * {@code textEdit?: TextEdit; }<br>
	 */
	public JSObject textEdit() { return get("textEdit", ofMapped(JSObject.class)); }

 	/**
	 * <p>An <a href="#TextEdit">edit</a> which is applied to a document when selecting
	 * this presentation for the color.</p>
	 * See {@code monaco.d.ts:5821:16}<br>
	 * Original signature:<br>
	 * {@code textEdit?: TextEdit; }<br>
	 */
	public IColorPresentation textEdit(@Nonnull JSObject value) {
		set("textEdit", value);
		return this;
	}

 
}
