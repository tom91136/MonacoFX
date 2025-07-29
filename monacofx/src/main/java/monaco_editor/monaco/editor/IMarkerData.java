
package monaco_editor.monaco.editor;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import monaco_editor.monaco.MarkerSeverity;
import monaco_editor.monaco.MarkerTag;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import net.kurobako.monacofx.js.JsUnion2;
import netscape.javascript.JSObject;

/**
 * <p>A structure defining a problem/warning/etc.</p>
 * See {@code monaco.d.ts:1207:32}<br>
 * Original signature:<br>
 * {@code export interface IMarkerData  }<br>
 */
@SuppressWarnings("unused")
public class IMarkerData extends JsProxy {

	public IMarkerData(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IMarkerData(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:1208:12}<br>
	 * Original signature:<br>
	 * {@code code?: string |  }<br>
	 */
	public Optional<JsUnion2<String, JSObject>> code() { return Optional.ofNullable(get("code", null /*union*/)); }

 	/**
	 * See {@code monaco.d.ts:1208:12}<br>
	 * Original signature:<br>
	 * {@code code?: string |  }<br>
	 */
	public IMarkerData code(@Nonnull String value) {
		set("code", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1208:12}<br>
	 * Original signature:<br>
	 * {@code code?: string |  }<br>
	 */
	public IMarkerData code(@Nonnull JSObject value) {
		set("code", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1218:17}<br>
	 * Original signature:<br>
	 * {@code endColumn: number; }<br>
	 */
	public double endColumn() { return get("endColumn", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:1218:17}<br>
	 * Original signature:<br>
	 * {@code endColumn: number; }<br>
	 */
	public IMarkerData endColumn(@Nonnull Double value) {
		set("endColumn", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1217:21}<br>
	 * Original signature:<br>
	 * {@code endLineNumber: number; }<br>
	 */
	public double endLineNumber() { return get("endLineNumber", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:1217:21}<br>
	 * Original signature:<br>
	 * {@code endLineNumber: number; }<br>
	 */
	public IMarkerData endLineNumber(@Nonnull Double value) {
		set("endLineNumber", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1213:15}<br>
	 * Original signature:<br>
	 * {@code message: string; }<br>
	 */
	public String message() { return get("message", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:1213:15}<br>
	 * Original signature:<br>
	 * {@code message: string; }<br>
	 */
	public IMarkerData message(@Nonnull String value) {
		set("message", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1219:26}<br>
	 * Original signature:<br>
	 * {@code relatedInformation?: IRelatedInformation[]; }<br>
	 */
	public List<IRelatedInformation> relatedInformation() { return get("relatedInformation", ofArray(IRelatedInformation::new)); }

 	/**
	 * See {@code monaco.d.ts:1219:26}<br>
	 * Original signature:<br>
	 * {@code relatedInformation?: IRelatedInformation[]; }<br>
	 */
	public IMarkerData relatedInformation(@Nonnull List<IRelatedInformation> value) {
		
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1212:16}<br>
	 * Original signature:<br>
	 * {@code severity: MarkerSeverity; }<br>
	 */
	public MarkerSeverity severity() { return get("severity", ofJsEnum(MarkerSeverity.class)); }

 	/**
	 * See {@code monaco.d.ts:1212:16}<br>
	 * Original signature:<br>
	 * {@code severity: MarkerSeverity; }<br>
	 */
	public IMarkerData severity(@Nonnull MarkerSeverity value) {
		set("severity", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1214:14}<br>
	 * Original signature:<br>
	 * {@code source?: string; }<br>
	 */
	public String source() { return get("source", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:1214:14}<br>
	 * Original signature:<br>
	 * {@code source?: string; }<br>
	 */
	public IMarkerData source(@Nonnull String value) {
		set("source", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1216:19}<br>
	 * Original signature:<br>
	 * {@code startColumn: number; }<br>
	 */
	public double startColumn() { return get("startColumn", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:1216:19}<br>
	 * Original signature:<br>
	 * {@code startColumn: number; }<br>
	 */
	public IMarkerData startColumn(@Nonnull Double value) {
		set("startColumn", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1215:23}<br>
	 * Original signature:<br>
	 * {@code startLineNumber: number; }<br>
	 */
	public double startLineNumber() { return get("startLineNumber", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:1215:23}<br>
	 * Original signature:<br>
	 * {@code startLineNumber: number; }<br>
	 */
	public IMarkerData startLineNumber(@Nonnull Double value) {
		set("startLineNumber", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1220:12}<br>
	 * Original signature:<br>
	 * {@code tags?: MarkerTag[]; }<br>
	 */
	public List<MarkerTag> tags() { return get("tags", ofArray(ofJsEnum(MarkerTag.class))); }

 	/**
	 * See {@code monaco.d.ts:1220:12}<br>
	 * Original signature:<br>
	 * {@code tags?: MarkerTag[]; }<br>
	 */
	public IMarkerData tags(@Nonnull List<MarkerTag> value) {
		
		return this;
	}

 
}
