
package monaco_editor.monaco.languages.typescript;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import net.kurobako.monacofx.js.JsUnion2;
import netscape.javascript.JSObject;

/**
 * See {@code monaco.d.ts:6348:24}<br>
 * Original signature:<br>
 * {@code interface Diagnostic extends DiagnosticRelatedInformation  }<br>
 */
@SuppressWarnings("unused")
public class Diagnostic extends DiagnosticRelatedInformation {

	public Diagnostic(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public Diagnostic(@Nonnull JsContext context) { super(context); }

 
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
	public Diagnostic code(@Nonnull Double value) {
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
	public Diagnostic length(@Nullable Double value) {
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
	public Diagnostic messageText(@Nonnull String value) {
		set("messageText", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6362:19}<br>
	 * Original signature:<br>
	 * {@code messageText: string | DiagnosticMessageChain; }<br>
	 */
	public Diagnostic messageText(@Nonnull DiagnosticMessageChain value) {
		set("messageText", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6352:26}<br>
	 * Original signature:<br>
	 * {@code relatedInformation?: DiagnosticRelatedInformation[]; }<br>
	 */
	public List<DiagnosticRelatedInformation> relatedInformation() { return get("relatedInformation", ofArray(DiagnosticRelatedInformation::new)); }

 	/**
	 * See {@code monaco.d.ts:6352:26}<br>
	 * Original signature:<br>
	 * {@code relatedInformation?: DiagnosticRelatedInformation[]; }<br>
	 */
	public Diagnostic relatedInformation(@Nonnull List<DiagnosticRelatedInformation> value) {
		
		return this;
	}

 	/**
	 * <p>May store more in future. For now, this will simply be <code>true</code> to indicate when a diagnostic is an unused-identifier diagnostic.</p>
	 * See {@code monaco.d.ts:6350:26}<br>
	 * Original signature:<br>
	 * {@code reportsUnnecessary?: ; }<br>
	 */
	public JSObject reportsUnnecessary() { return get("reportsUnnecessary", ofMapped(JSObject.class)); }

 	/**
	 * <p>May store more in future. For now, this will simply be <code>true</code> to indicate when a diagnostic is an unused-identifier diagnostic.</p>
	 * See {@code monaco.d.ts:6350:26}<br>
	 * Original signature:<br>
	 * {@code reportsUnnecessary?: ; }<br>
	 */
	public Diagnostic reportsUnnecessary(@Nonnull JSObject value) {
		set("reportsUnnecessary", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6351:14}<br>
	 * Original signature:<br>
	 * {@code source?: string; }<br>
	 */
	public String source() { return get("source", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:6351:14}<br>
	 * Original signature:<br>
	 * {@code source?: string; }<br>
	 */
	public Diagnostic source(@Nonnull String value) {
		set("source", value);
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
	public Diagnostic start(@Nullable Double value) {
		set("start", value);
		return this;
	}

 
}
