
package monaco_editor.monaco.languages.typescript;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import net.kurobako.monacofx.js.JsUnion2;

/**
 * See {@code monaco.d.ts:6354:42}<br>
 * Original signature:<br>
 * {@code interface DiagnosticRelatedInformation  }<br>
 */
@SuppressWarnings("unused")
public class DiagnosticRelatedInformation extends JsProxy {

	public DiagnosticRelatedInformation(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public DiagnosticRelatedInformation(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:6357:12}<br>
	 * Original signature:<br>
	 * {@code code: number; }<br>
	 */
	public double code() { return get("code", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:6357:12}<br>
	 * Original signature:<br>
	 * {@code code: number; }<br>
	 */
	public DiagnosticRelatedInformation code(@Nonnull Double value) {
		set("code", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6361:14}<br>
	 * Original signature:<br>
	 * {@code length: number | undefined; }<br>
	 */
	public Optional<Double> length() { return Optional.ofNullable(get("length", ofMapped(double.class))); }

 	/**
	 * See {@code monaco.d.ts:6361:14}<br>
	 * Original signature:<br>
	 * {@code length: number | undefined; }<br>
	 */
	public DiagnosticRelatedInformation length(@Nullable Double value) {
		set("length", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6362:19}<br>
	 * Original signature:<br>
	 * {@code messageText: string | DiagnosticMessageChain; }<br>
	 */
	public JsUnion2<String, DiagnosticMessageChain> messageText() { return get("messageText", null /*union*/); }

 	/**
	 * See {@code monaco.d.ts:6362:19}<br>
	 * Original signature:<br>
	 * {@code messageText: string | DiagnosticMessageChain; }<br>
	 */
	public DiagnosticRelatedInformation messageText(@Nonnull String value) {
		set("messageText", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6362:19}<br>
	 * Original signature:<br>
	 * {@code messageText: string | DiagnosticMessageChain; }<br>
	 */
	public DiagnosticRelatedInformation messageText(@Nonnull DiagnosticMessageChain value) {
		set("messageText", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6360:13}<br>
	 * Original signature:<br>
	 * {@code start: number | undefined; }<br>
	 */
	public Optional<Double> start() { return Optional.ofNullable(get("start", ofMapped(double.class))); }

 	/**
	 * See {@code monaco.d.ts:6360:13}<br>
	 * Original signature:<br>
	 * {@code start: number | undefined; }<br>
	 */
	public DiagnosticRelatedInformation start(@Nullable Double value) {
		set("start", value);
		return this;
	}

 
}
