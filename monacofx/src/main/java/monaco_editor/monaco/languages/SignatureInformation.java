
package monaco_editor.monaco.languages;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import monaco_editor.monaco.IMarkdownString;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import net.kurobako.monacofx.js.JsUnion2;

/**
 * <p>Represents the signature of something callable. A signature
 * can have a label, like a function-name, a doc-comment, and
 * a set of parameters.</p>
 * See {@code monaco.d.ts:5422:41}<br>
 * Original signature:<br>
 * {@code export interface SignatureInformation  }<br>
 */
@SuppressWarnings("unused")
public class SignatureInformation extends JsProxy {

	public SignatureInformation(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public SignatureInformation(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>The human-readable doc-comment of this signature. Will be shown
	 * in the UI but can be omitted.</p>
	 * See {@code monaco.d.ts:5432:21}<br>
	 * Original signature:<br>
	 * {@code documentation?: string | IMarkdownString; }<br>
	 */
	public Optional<JsUnion2<String, IMarkdownString>> documentation() { return Optional.ofNullable(get("documentation", null /*union*/)); }

 	/**
	 * <p>The human-readable doc-comment of this signature. Will be shown
	 * in the UI but can be omitted.</p>
	 * See {@code monaco.d.ts:5432:21}<br>
	 * Original signature:<br>
	 * {@code documentation?: string | IMarkdownString; }<br>
	 */
	public SignatureInformation documentation(@Nonnull String value) {
		set("documentation", value);
		return this;
	}

 	/**
	 * <p>The human-readable doc-comment of this signature. Will be shown
	 * in the UI but can be omitted.</p>
	 * See {@code monaco.d.ts:5432:21}<br>
	 * Original signature:<br>
	 * {@code documentation?: string | IMarkdownString; }<br>
	 */
	public SignatureInformation documentation(@Nonnull IMarkdownString value) {
		set("documentation", value);
		return this;
	}

 	/**
	 * <p>The label of this signature. Will be shown in
	 * the UI.</p>
	 * See {@code monaco.d.ts:5427:13}<br>
	 * Original signature:<br>
	 * {@code label: string; }<br>
	 */
	public String label() { return get("label", ofMapped(String.class)); }

 	/**
	 * <p>The label of this signature. Will be shown in
	 * the UI.</p>
	 * See {@code monaco.d.ts:5427:13}<br>
	 * Original signature:<br>
	 * {@code label: string; }<br>
	 */
	public SignatureInformation label(@Nonnull String value) {
		set("label", value);
		return this;
	}

 	/**
	 * <p>The parameters of this signature.</p>
	 * See {@code monaco.d.ts:5436:18}<br>
	 * Original signature:<br>
	 * {@code parameters: ParameterInformation[]; }<br>
	 */
	public List<ParameterInformation> parameters() { return get("parameters", ofArray(ParameterInformation::new)); }

 	/**
	 * <p>The parameters of this signature.</p>
	 * See {@code monaco.d.ts:5436:18}<br>
	 * Original signature:<br>
	 * {@code parameters: ParameterInformation[]; }<br>
	 */
	public SignatureInformation parameters(@Nonnull List<ParameterInformation> value) {
		
		return this;
	}

 
}
