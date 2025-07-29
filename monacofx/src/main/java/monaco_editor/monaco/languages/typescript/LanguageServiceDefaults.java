
package monaco_editor.monaco.languages.typescript;
import java.util.List;
import javax.annotation.Nonnull;
import monaco_editor.monaco.IDisposable;
import monaco_editor.monaco.IEvent;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import netscape.javascript.JSObject;

/**
 * See {@code monaco.d.ts:6375:44}<br>
 * Original signature:<br>
 * {@code export interface LanguageServiceDefaults  }<br>
 */
@SuppressWarnings("unused")
public class LanguageServiceDefaults extends JsProxy {

	public LanguageServiceDefaults(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public LanguageServiceDefaults(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Event fired when compiler options or diagnostics options are changed.</p>
	 * See {@code monaco.d.ts:6379:28}<br>
	 * Original signature:<br>
	 * {@code readonly onDidChange: IEvent<void>; }<br>
	 */
	public IEvent<Void> onDidChange() { return get("onDidChange", IEvent ::new); }

 	/**
	 * <p>Event fired when extra libraries registered with the language service change.</p>
	 * See {@code monaco.d.ts:6384:37}<br>
	 * Original signature:<br>
	 * {@code readonly onDidExtraLibsChange: IEvent<void>; }<br>
	 */
	public IEvent<Void> onDidExtraLibsChange() { return get("onDidExtraLibsChange", IEvent ::new); }

 	/**
	 * <p>Add an additional source file to the language service. Use this
	 * for typescript (definition) files that won't be loaded as editor
	 * documents, like <code>jquery.d.ts</code>.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:6401:19}<br>
	 * Original signature:<br>
	 * {@code addExtraLib(content: string, filePath?: string): IDisposable; }<br>
	 */
	public IDisposable addExtraLib(@Nonnull String content) { return call("addExtraLib", IDisposable::new, content); }

 	/**
	 * <p>Add an additional source file to the language service. Use this
	 * for typescript (definition) files that won't be loaded as editor
	 * documents, like <code>jquery.d.ts</code>.</p>
	 * See {@code monaco.d.ts:6401:19}<br>
	 * Original signature:<br>
	 * {@code addExtraLib(content: string, filePath?: string): IDisposable; }<br>
	 * 
	 * @param content The file content
	 * @param filePath An optional file path
	 */
	public IDisposable addExtraLib(@Nonnull String content, @Nonnull String filePath) { return call("addExtraLib", IDisposable::new, content, filePath); }

 	/**
	 * <p>Get current TypeScript compiler options for the language service.</p>
	 * See {@code monaco.d.ts:6414:26}<br>
	 * Original signature:<br>
	 * {@code getCompilerOptions(): CompilerOptions; }<br>
	 */
	public CompilerOptions getCompilerOptions() { return call("getCompilerOptions", CompilerOptions::new); }

 	/**
	 * <p>Get the current diagnostics options for the language service.</p>
	 * See {@code monaco.d.ts:6424:29}<br>
	 * Original signature:<br>
	 * {@code getDiagnosticsOptions(): DiagnosticsOptions; }<br>
	 */
	public DiagnosticsOptions getDiagnosticsOptions() { return call("getDiagnosticsOptions", DiagnosticsOptions::new); }

 	/**
	 * <p>Get the current setting for whether all existing models should be eagerly sync'd
	 * to the worker on start or restart.</p>
	 * See {@code monaco.d.ts:6447:25}<br>
	 * Original signature:<br>
	 * {@code getEagerModelSync(): boolean; }<br>
	 */
	public boolean getEagerModelSync() { return call("getEagerModelSync", ofMapped(boolean.class)); }

 	/**
	 * <p>Get the current extra libs registered with the language service.</p>
	 * See {@code monaco.d.ts:6389:20}<br>
	 * Original signature:<br>
	 * {@code getExtraLibs(): IExtraLibs; }<br>
	 */
	public IExtraLibs getExtraLibs() { return call("getExtraLibs", IExtraLibs::new); }

 	/**
	 * <p>Set TypeScript compiler options.</p>
	 * See {@code monaco.d.ts:6419:26}<br>
	 * Original signature:<br>
	 * {@code setCompilerOptions(options: CompilerOptions): void; }<br>
	 */
	public void setCompilerOptions(@Nonnull CompilerOptions options) { call("setCompilerOptions", ofVoid(), options); }

 	/**
	 * <p>Configure whether syntactic and/or semantic validation should
	 * be performed</p>
	 * See {@code monaco.d.ts:6430:29}<br>
	 * Original signature:<br>
	 * {@code setDiagnosticsOptions(options: DiagnosticsOptions): void; }<br>
	 */
	public void setDiagnosticsOptions(@Nonnull DiagnosticsOptions options) { call("setDiagnosticsOptions", ofVoid(), options); }

 	/**
	 * <p>Configure if all existing models should be eagerly sync'd
	 * to the worker on start or restart.</p>
	 * See {@code monaco.d.ts:6441:25}<br>
	 * Original signature:<br>
	 * {@code setEagerModelSync(value: boolean): void; }<br>
	 */
	public void setEagerModelSync(@Nonnull Boolean value) { call("setEagerModelSync", ofVoid(), value); }

 	/**
	 * <p>Remove all existing extra libs and set the additional source
	 * files to the language service. Use this for typescript definition
	 * files that won't be loaded as editor documents, like <code>jquery.d.ts</code>.</p>
	 * See {@code monaco.d.ts:6409:20}<br>
	 * Original signature:<br>
	 * {@code setExtraLibs(libs:  content: string; filePath?: string []): void; }<br>
	 * 
	 * @param libs An array of entries to register.
	 */
	public void setExtraLibs(@Nonnull List<JSObject> libs) { call("setExtraLibs", ofVoid(), libs); }

 	/**
	 * <p>No-op.</p>
	 * See {@code monaco.d.ts:6435:32}<br>
	 * Original signature:<br>
	 * {@code setMaximumWorkerIdleTime(value: number): void; }<br>
	 */
	public void setMaximumWorkerIdleTime(@Nonnull Double value) { call("setMaximumWorkerIdleTime", ofVoid(), value); }

 
}
