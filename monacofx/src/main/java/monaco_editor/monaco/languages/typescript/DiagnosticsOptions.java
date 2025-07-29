
package monaco_editor.monaco.languages.typescript;
import java.util.List;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:6321:39}<br>
 * Original signature:<br>
 * {@code export interface DiagnosticsOptions  }<br>
 */
@SuppressWarnings("unused")
public class DiagnosticsOptions extends JsProxy {

	public DiagnosticsOptions(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public DiagnosticsOptions(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:6325:31}<br>
	 * Original signature:<br>
	 * {@code diagnosticCodesToIgnore?: number[]; }<br>
	 */
	public List<Double> diagnosticCodesToIgnore() { return get("diagnosticCodesToIgnore", ofArray(ofMapped(double.class))); }

 	/**
	 * See {@code monaco.d.ts:6325:31}<br>
	 * Original signature:<br>
	 * {@code diagnosticCodesToIgnore?: number[]; }<br>
	 */
	public DiagnosticsOptions diagnosticCodesToIgnore(@Nonnull List<Double> value) {
		
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6322:28}<br>
	 * Original signature:<br>
	 * {@code noSemanticValidation?: boolean; }<br>
	 */
	public boolean noSemanticValidation() { return get("noSemanticValidation", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6322:28}<br>
	 * Original signature:<br>
	 * {@code noSemanticValidation?: boolean; }<br>
	 */
	public DiagnosticsOptions noSemanticValidation(@Nonnull Boolean value) {
		set("noSemanticValidation", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6324:31}<br>
	 * Original signature:<br>
	 * {@code noSuggestionDiagnostics?: boolean; }<br>
	 */
	public boolean noSuggestionDiagnostics() { return get("noSuggestionDiagnostics", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6324:31}<br>
	 * Original signature:<br>
	 * {@code noSuggestionDiagnostics?: boolean; }<br>
	 */
	public DiagnosticsOptions noSuggestionDiagnostics(@Nonnull Boolean value) {
		set("noSuggestionDiagnostics", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6323:26}<br>
	 * Original signature:<br>
	 * {@code noSyntaxValidation?: boolean; }<br>
	 */
	public boolean noSyntaxValidation() { return get("noSyntaxValidation", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6323:26}<br>
	 * Original signature:<br>
	 * {@code noSyntaxValidation?: boolean; }<br>
	 */
	public DiagnosticsOptions noSyntaxValidation(@Nonnull Boolean value) {
		set("noSyntaxValidation", value);
		return this;
	}

 
}
