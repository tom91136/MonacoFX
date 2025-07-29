
package monaco_editor.monaco.languages;
import java.util.List;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>Signature help represents the signature of something
 * callable. There can be multiple signatures but only one
 * active and only one active parameter.</p>
 * See {@code monaco.d.ts:5444:34}<br>
 * Original signature:<br>
 * {@code export interface SignatureHelp  }<br>
 */
@SuppressWarnings("unused")
public class SignatureHelp extends JsProxy {

	public SignatureHelp(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public SignatureHelp(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>The active parameter of the active signature.</p>
	 * See {@code monaco.d.ts:5456:23}<br>
	 * Original signature:<br>
	 * {@code activeParameter: number; }<br>
	 */
	public double activeParameter() { return get("activeParameter", ofMapped(double.class)); }

 	/**
	 * <p>The active parameter of the active signature.</p>
	 * See {@code monaco.d.ts:5456:23}<br>
	 * Original signature:<br>
	 * {@code activeParameter: number; }<br>
	 */
	public SignatureHelp activeParameter(@Nonnull Double value) {
		set("activeParameter", value);
		return this;
	}

 	/**
	 * <p>The active signature.</p>
	 * See {@code monaco.d.ts:5452:23}<br>
	 * Original signature:<br>
	 * {@code activeSignature: number; }<br>
	 */
	public double activeSignature() { return get("activeSignature", ofMapped(double.class)); }

 	/**
	 * <p>The active signature.</p>
	 * See {@code monaco.d.ts:5452:23}<br>
	 * Original signature:<br>
	 * {@code activeSignature: number; }<br>
	 */
	public SignatureHelp activeSignature(@Nonnull Double value) {
		set("activeSignature", value);
		return this;
	}

 	/**
	 * <p>One or more signatures.</p>
	 * See {@code monaco.d.ts:5448:18}<br>
	 * Original signature:<br>
	 * {@code signatures: SignatureInformation[]; }<br>
	 */
	public List<SignatureInformation> signatures() { return get("signatures", ofArray(SignatureInformation::new)); }

 	/**
	 * <p>One or more signatures.</p>
	 * See {@code monaco.d.ts:5448:18}<br>
	 * Original signature:<br>
	 * {@code signatures: SignatureInformation[]; }<br>
	 */
	public SignatureHelp signatures(@Nonnull List<SignatureInformation> value) {
		
		return this;
	}

 
}
