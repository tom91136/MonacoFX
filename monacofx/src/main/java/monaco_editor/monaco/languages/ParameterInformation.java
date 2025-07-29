
package monaco_editor.monaco.languages;
import java.util.Optional;
import javax.annotation.Nonnull;
import monaco_editor.monaco.IMarkdownString;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import net.kurobako.monacofx.js.JsUnion2;

/**
 * <p>Represents a parameter of a callable-signature. A parameter can
 * have a label and a doc-comment.</p>
 * See {@code monaco.d.ts:5404:41}<br>
 * Original signature:<br>
 * {@code export interface ParameterInformation  }<br>
 */
@SuppressWarnings("unused")
public class ParameterInformation extends JsProxy {

	public ParameterInformation(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public ParameterInformation(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>The human-readable doc-comment of this signature. Will be shown
	 * in the UI but can be omitted.</p>
	 * See {@code monaco.d.ts:5414:21}<br>
	 * Original signature:<br>
	 * {@code documentation?: string | IMarkdownString; }<br>
	 */
	public Optional<JsUnion2<String, IMarkdownString>> documentation() { return Optional.ofNullable(get("documentation", null /*union*/)); }

 	/**
	 * <p>The human-readable doc-comment of this signature. Will be shown
	 * in the UI but can be omitted.</p>
	 * See {@code monaco.d.ts:5414:21}<br>
	 * Original signature:<br>
	 * {@code documentation?: string | IMarkdownString; }<br>
	 */
	public ParameterInformation documentation(@Nonnull String value) {
		set("documentation", value);
		return this;
	}

 	/**
	 * <p>The human-readable doc-comment of this signature. Will be shown
	 * in the UI but can be omitted.</p>
	 * See {@code monaco.d.ts:5414:21}<br>
	 * Original signature:<br>
	 * {@code documentation?: string | IMarkdownString; }<br>
	 */
	public ParameterInformation documentation(@Nonnull IMarkdownString value) {
		set("documentation", value);
		return this;
	}

 	/**
	 * <p>The label of this signature. Will be shown in
	 * the UI.</p>
	 * See {@code monaco.d.ts:5409:13}<br>
	 * Original signature:<br>
	 * {@code label: string | [number, number]; }<br>
	 */
	public JsUnion2<String, JsUnion2<Double, Double>> label() { return get("label", null /*union*/); }

 	/**
	 * <p>The label of this signature. Will be shown in
	 * the UI.</p>
	 * See {@code monaco.d.ts:5409:13}<br>
	 * Original signature:<br>
	 * {@code label: string | [number, number]; }<br>
	 */
	public ParameterInformation label(@Nonnull String value) {
		set("label", value);
		return this;
	}

 	/**
	 * <p>The label of this signature. Will be shown in
	 * the UI.</p>
	 * See {@code monaco.d.ts:5409:13}<br>
	 * Original signature:<br>
	 * {@code label: string | [number, number]; }<br>
	 */
	public ParameterInformation label(@Nonnull JsUnion2<Double, Double> value) {
		set("label", value);
		return this;
	}

 
}
