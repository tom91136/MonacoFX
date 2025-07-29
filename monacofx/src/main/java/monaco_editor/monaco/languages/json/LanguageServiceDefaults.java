
package monaco_editor.monaco.languages.json;
import javax.annotation.Nonnull;
import monaco_editor.monaco.IEvent;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:6767:44}<br>
 * Original signature:<br>
 * {@code export interface LanguageServiceDefaults  }<br>
 */
@SuppressWarnings("unused")
public class LanguageServiceDefaults extends JsProxy {

	public LanguageServiceDefaults(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public LanguageServiceDefaults(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:6769:35}<br>
	 * Original signature:<br>
	 * {@code readonly diagnosticsOptions: DiagnosticsOptions; }<br>
	 */
	public DiagnosticsOptions diagnosticsOptions() { return get("diagnosticsOptions", DiagnosticsOptions::new); }

 	/**
	 * See {@code monaco.d.ts:6770:34}<br>
	 * Original signature:<br>
	 * {@code readonly modeConfiguration: ModeConfiguration; }<br>
	 */
	public ModeConfiguration modeConfiguration() { return get("modeConfiguration", ModeConfiguration::new); }

 	/**
	 * See {@code monaco.d.ts:6768:28}<br>
	 * Original signature:<br>
	 * {@code readonly onDidChange: IEvent<LanguageServiceDefaults>; }<br>
	 */
	public IEvent<LanguageServiceDefaults> onDidChange() { return get("onDidChange", IEvent ::new); }

 	/**
	 * See {@code monaco.d.ts:6771:29}<br>
	 * Original signature:<br>
	 * {@code setDiagnosticsOptions(options: DiagnosticsOptions): void; }<br>
	 */
	public void setDiagnosticsOptions(@Nonnull DiagnosticsOptions options) { call("setDiagnosticsOptions", ofVoid(), options); }

 	/**
	 * See {@code monaco.d.ts:6772:28}<br>
	 * Original signature:<br>
	 * {@code setModeConfiguration(modeConfiguration: ModeConfiguration): void; }<br>
	 */
	public void setModeConfiguration(@Nonnull ModeConfiguration modeConfiguration) { call("setModeConfiguration", ofVoid(), modeConfiguration); }

 
}
