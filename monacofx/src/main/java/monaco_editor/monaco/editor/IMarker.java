
package monaco_editor.monaco.editor;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import monaco_editor.monaco.MarkerSeverity;
import monaco_editor.monaco.MarkerTag;
import monaco_editor.monaco.Uri;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import net.kurobako.monacofx.js.JsUnion2;
import netscape.javascript.JSObject;

/**
 * See {@code monaco.d.ts:1186:28}<br>
 * Original signature:<br>
 * {@code export interface IMarker  }<br>
 */
@SuppressWarnings("unused")
public class IMarker extends JsProxy {

	public IMarker(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IMarker(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:1190:12}<br>
	 * Original signature:<br>
	 * {@code code?: string |  }<br>
	 */
	public Optional<JsUnion2<String, JSObject>> code() { return Optional.ofNullable(get("code", null /*union*/)); }

 	/**
	 * See {@code monaco.d.ts:1190:12}<br>
	 * Original signature:<br>
	 * {@code code?: string |  }<br>
	 */
	public IMarker code(@Nonnull String value) {
		set("code", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1190:12}<br>
	 * Original signature:<br>
	 * {@code code?: string |  }<br>
	 */
	public IMarker code(@Nonnull JSObject value) {
		set("code", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1199:17}<br>
	 * Original signature:<br>
	 * {@code endColumn: number; }<br>
	 */
	public double endColumn() { return get("endColumn", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:1199:17}<br>
	 * Original signature:<br>
	 * {@code endColumn: number; }<br>
	 */
	public IMarker endColumn(@Nonnull Double value) {
		set("endColumn", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1198:21}<br>
	 * Original signature:<br>
	 * {@code endLineNumber: number; }<br>
	 */
	public double endLineNumber() { return get("endLineNumber", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:1198:21}<br>
	 * Original signature:<br>
	 * {@code endLineNumber: number; }<br>
	 */
	public IMarker endLineNumber(@Nonnull Double value) {
		set("endLineNumber", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1194:15}<br>
	 * Original signature:<br>
	 * {@code message: string; }<br>
	 */
	public String message() { return get("message", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:1194:15}<br>
	 * Original signature:<br>
	 * {@code message: string; }<br>
	 */
	public IMarker message(@Nonnull String value) {
		set("message", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1187:13}<br>
	 * Original signature:<br>
	 * {@code owner: string; }<br>
	 */
	public String owner() { return get("owner", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:1187:13}<br>
	 * Original signature:<br>
	 * {@code owner: string; }<br>
	 */
	public IMarker owner(@Nonnull String value) {
		set("owner", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1200:26}<br>
	 * Original signature:<br>
	 * {@code relatedInformation?: IRelatedInformation[]; }<br>
	 */
	public List<IRelatedInformation> relatedInformation() { return get("relatedInformation", ofArray(IRelatedInformation::new)); }

 	/**
	 * See {@code monaco.d.ts:1200:26}<br>
	 * Original signature:<br>
	 * {@code relatedInformation?: IRelatedInformation[]; }<br>
	 */
	public IMarker relatedInformation(@Nonnull List<IRelatedInformation> value) {
		
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1188:16}<br>
	 * Original signature:<br>
	 * {@code resource: Uri; }<br>
	 */
	public Uri resource() { return get("resource", Uri::new); }

 	/**
	 * See {@code monaco.d.ts:1188:16}<br>
	 * Original signature:<br>
	 * {@code resource: Uri; }<br>
	 */
	public IMarker resource(@Nonnull Uri value) {
		set("resource", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1189:16}<br>
	 * Original signature:<br>
	 * {@code severity: MarkerSeverity; }<br>
	 */
	public MarkerSeverity severity() { return get("severity", ofJsEnum(MarkerSeverity.class)); }

 	/**
	 * See {@code monaco.d.ts:1189:16}<br>
	 * Original signature:<br>
	 * {@code severity: MarkerSeverity; }<br>
	 */
	public IMarker severity(@Nonnull MarkerSeverity value) {
		set("severity", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1195:14}<br>
	 * Original signature:<br>
	 * {@code source?: string; }<br>
	 */
	public String source() { return get("source", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:1195:14}<br>
	 * Original signature:<br>
	 * {@code source?: string; }<br>
	 */
	public IMarker source(@Nonnull String value) {
		set("source", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1197:19}<br>
	 * Original signature:<br>
	 * {@code startColumn: number; }<br>
	 */
	public double startColumn() { return get("startColumn", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:1197:19}<br>
	 * Original signature:<br>
	 * {@code startColumn: number; }<br>
	 */
	public IMarker startColumn(@Nonnull Double value) {
		set("startColumn", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1196:23}<br>
	 * Original signature:<br>
	 * {@code startLineNumber: number; }<br>
	 */
	public double startLineNumber() { return get("startLineNumber", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:1196:23}<br>
	 * Original signature:<br>
	 * {@code startLineNumber: number; }<br>
	 */
	public IMarker startLineNumber(@Nonnull Double value) {
		set("startLineNumber", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:1201:12}<br>
	 * Original signature:<br>
	 * {@code tags?: MarkerTag[]; }<br>
	 */
	public List<MarkerTag> tags() { return get("tags", ofArray(ofJsEnum(MarkerTag.class))); }

 	/**
	 * See {@code monaco.d.ts:1201:12}<br>
	 * Original signature:<br>
	 * {@code tags?: MarkerTag[]; }<br>
	 */
	public IMarker tags(@Nonnull List<MarkerTag> value) {
		
		return this;
	}

 
}
