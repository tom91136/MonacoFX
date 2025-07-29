
package monaco_editor.monaco;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import monaco_editor.monaco.editor.IColorizerElementOptions;
import monaco_editor.monaco.editor.IColorizerOptions;
import monaco_editor.monaco.editor.IDiffEditorConstructionOptions;
import monaco_editor.monaco.editor.IDiffNavigator;
import monaco_editor.monaco.editor.IDiffNavigatorOptions;
import monaco_editor.monaco.editor.IEditorOverrideServices;
import monaco_editor.monaco.editor.IMarker;
import monaco_editor.monaco.editor.IMarkerData;
import monaco_editor.monaco.editor.IStandaloneCodeEditor;
import monaco_editor.monaco.editor.IStandaloneDiffEditor;
import monaco_editor.monaco.editor.IStandaloneEditorConstructionOptions;
import monaco_editor.monaco.editor.IStandaloneThemeData;
import monaco_editor.monaco.editor.ITextModel;
import monaco_editor.monaco.editor.IWebWorkerOptions;
import monaco_editor.monaco.editor.MonacoWebWorker;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsPromise;
import net.kurobako.monacofx.js.JsProxy;
import netscape.javascript.JSObject;

/**
 * See {@code monaco.d.ts:816:31}<br>
 * Original signature:<br>
 * {@code declare namespace monaco.editor  }<br>
 */
@SuppressWarnings("unused")
public class EditorModule extends JsProxy {

	public EditorModule(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public EditorModule(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:3778:30}<br>
	 * Original signature:<br>
	 * {@code export const EditorOptions:  }<br>
	 */
	public JSObject EditorOptions() { return get("EditorOptions", ofMapped(JSObject.class)); }

 	/**
	 * <p>The type of the <code>IEditor</code>.</p>
	 * See {@code monaco.d.ts:2295:27}<br>
	 * Original signature:<br>
	 * {@code export const EditorType:  }<br>
	 */
	public JSObject EditorType() { return get("EditorType", ofMapped(JSObject.class)); }

 	/**
	 * <p>Colorize <code>text</code> using language <code>languageId</code>.</p>
	 * See {@code monaco.d.ts:926:28}<br>
	 * Original signature:<br>
	 * {@code export function colorize(text: string, languageId: string, options: IColorizerOptions): Promise<string>; }<br>
	 */
	public JsPromise<String> colorize(@Nonnull String text, @Nonnull String languageId, @Nonnull IColorizerOptions options) { return call("colorize", JsPromise ::new, text, languageId, options); }

 	/**
	 * <p>Colorize the contents of <code>domNode</code> using attribute <code>data-lang</code>.</p>
	 * See {@code monaco.d.ts:921:35}<br>
	 * Original signature:<br>
	 * {@code export function colorizeElement(domNode: HTMLElement, options: IColorizerElementOptions): Promise<void>; }<br>
	 */
	public JsPromise<Void> colorizeElement(@Nonnull JSObject domNode, @Nonnull IColorizerElementOptions options) { return call("colorizeElement", JsPromise ::new, domNode, options); }

 	/**
	 * <p>Colorize a line in a model.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:931:37}<br>
	 * Original signature:<br>
	 * {@code export function colorizeModelLine(model: ITextModel, lineNumber: number, tabSize?: number): string; }<br>
	 */
	public String colorizeModelLine(@Nonnull ITextModel model, @Nonnull Double lineNumber) { return call("colorizeModelLine", ofMapped(String.class), model, lineNumber); }

 	/**
	 * <p>Colorize a line in a model.</p>
	 * See {@code monaco.d.ts:931:37}<br>
	 * Original signature:<br>
	 * {@code export function colorizeModelLine(model: ITextModel, lineNumber: number, tabSize?: number): string; }<br>
	 */
	public String colorizeModelLine(@Nonnull ITextModel model, @Nonnull Double lineNumber, @Nonnull Double tabSize) { return call("colorizeModelLine", ofMapped(String.class), model, lineNumber, tabSize); }

 	/**
	 * <p>Create a new editor under <code>domElement</code>.
	 * <code>domElement</code> should be empty (not contain other dom nodes).
	 * The editor will read the size of <code>domElement</code>.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:830:26}<br>
	 * Original signature:<br>
	 * {@code export function create(domElement: HTMLElement, options?: IStandaloneEditorConstructionOptions, override?: IEditorOverrideServices): IStandaloneCodeEditor; }<br>
	 */
	public IStandaloneCodeEditor create(@Nonnull JSObject domElement) { return call("create", IStandaloneCodeEditor::new, domElement); }

 	/**
	 * <p>Create a new editor under <code>domElement</code>.
	 * <code>domElement</code> should be empty (not contain other dom nodes).
	 * The editor will read the size of <code>domElement</code>.</p>
	 * See {@code monaco.d.ts:830:26}<br>
	 * Original signature:<br>
	 * {@code export function create(domElement: HTMLElement, options?: IStandaloneEditorConstructionOptions, override?: IEditorOverrideServices): IStandaloneCodeEditor; }<br>
	 */
	public IStandaloneCodeEditor create(@Nonnull JSObject domElement, @Nonnull IStandaloneEditorConstructionOptions options, @Nonnull IEditorOverrideServices override) { return call("create", IStandaloneCodeEditor::new, domElement, options, override); }

 	/**
	 * <p>Create a new editor under <code>domElement</code>.
	 * <code>domElement</code> should be empty (not contain other dom nodes).
	 * The editor will read the size of <code>domElement</code>.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:830:26}<br>
	 * Original signature:<br>
	 * {@code export function create(domElement: HTMLElement, options?: IStandaloneEditorConstructionOptions, override?: IEditorOverrideServices): IStandaloneCodeEditor; }<br>
	 */
	public IStandaloneCodeEditor create(@Nonnull JSObject domElement, @Nonnull IStandaloneEditorConstructionOptions options) { return call("create", IStandaloneCodeEditor::new, domElement, options); }

 	/**
	 * <p>Create a new diff editor under <code>domElement</code>.
	 * <code>domElement</code> should be empty (not contain other dom nodes).
	 * The editor will read the size of <code>domElement</code>.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:844:36}<br>
	 * Original signature:<br>
	 * {@code export function createDiffEditor(domElement: HTMLElement, options?: IDiffEditorConstructionOptions, override?: IEditorOverrideServices): IStandaloneDiffEditor; }<br>
	 */
	public IStandaloneDiffEditor createDiffEditor(@Nonnull JSObject domElement) { return call("createDiffEditor", IStandaloneDiffEditor::new, domElement); }

 	/**
	 * <p>Create a new diff editor under <code>domElement</code>.
	 * <code>domElement</code> should be empty (not contain other dom nodes).
	 * The editor will read the size of <code>domElement</code>.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:844:36}<br>
	 * Original signature:<br>
	 * {@code export function createDiffEditor(domElement: HTMLElement, options?: IDiffEditorConstructionOptions, override?: IEditorOverrideServices): IStandaloneDiffEditor; }<br>
	 */
	public IStandaloneDiffEditor createDiffEditor(@Nonnull JSObject domElement, @Nonnull IDiffEditorConstructionOptions options) { return call("createDiffEditor", IStandaloneDiffEditor::new, domElement, options); }

 	/**
	 * <p>Create a new diff editor under <code>domElement</code>.
	 * <code>domElement</code> should be empty (not contain other dom nodes).
	 * The editor will read the size of <code>domElement</code>.</p>
	 * See {@code monaco.d.ts:844:36}<br>
	 * Original signature:<br>
	 * {@code export function createDiffEditor(domElement: HTMLElement, options?: IDiffEditorConstructionOptions, override?: IEditorOverrideServices): IStandaloneDiffEditor; }<br>
	 */
	public IStandaloneDiffEditor createDiffEditor(@Nonnull JSObject domElement, @Nonnull IDiffEditorConstructionOptions options, @Nonnull IEditorOverrideServices override) { return call("createDiffEditor", IStandaloneDiffEditor::new, domElement, options, override); }

 	/**
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:852:39}<br>
	 * Original signature:<br>
	 * {@code export function createDiffNavigator(diffEditor: IStandaloneDiffEditor, opts?: IDiffNavigatorOptions): IDiffNavigator; }<br>
	 */
	public IDiffNavigator createDiffNavigator(@Nonnull IStandaloneDiffEditor diffEditor) { return call("createDiffNavigator", IDiffNavigator::new, diffEditor); }

 	/**
	 * See {@code monaco.d.ts:852:39}<br>
	 * Original signature:<br>
	 * {@code export function createDiffNavigator(diffEditor: IStandaloneDiffEditor, opts?: IDiffNavigatorOptions): IDiffNavigator; }<br>
	 */
	public IDiffNavigator createDiffNavigator(@Nonnull IStandaloneDiffEditor diffEditor, @Nonnull IDiffNavigatorOptions opts) { return call("createDiffNavigator", IDiffNavigator::new, diffEditor, opts); }

 	/**
	 * <p>Create a new editor model.
	 * You can specify the language that should be set for this model or let the language be inferred from the <code>uri</code>.</p>
	 * See {@code monaco.d.ts:858:31}<br>
	 * Original signature:<br>
	 * {@code export function createModel(value: string, language?: string, uri?: Uri): ITextModel; }<br>
	 */
	public ITextModel createModel(@Nonnull String value, @Nonnull String language, @Nonnull Uri uri) { return call("createModel", ITextModel::new, value, language, uri); }

 	/**
	 * <p>Create a new editor model.
	 * You can specify the language that should be set for this model or let the language be inferred from the <code>uri</code>.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:858:31}<br>
	 * Original signature:<br>
	 * {@code export function createModel(value: string, language?: string, uri?: Uri): ITextModel; }<br>
	 */
	public ITextModel createModel(@Nonnull String value) { return call("createModel", ITextModel::new, value); }

 	/**
	 * <p>Create a new editor model.
	 * You can specify the language that should be set for this model or let the language be inferred from the <code>uri</code>.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:858:31}<br>
	 * Original signature:<br>
	 * {@code export function createModel(value: string, language?: string, uri?: Uri): ITextModel; }<br>
	 */
	public ITextModel createModel(@Nonnull String value, @Nonnull String language) { return call("createModel", ITextModel::new, value, language); }

 	/**
	 * <p>Create a new web worker that has model syncing capabilities built in.
	 * Specify an AMD module to load that will <code>create</code> an object that will be proxied.</p>
	 * See {@code monaco.d.ts:916:35}<br>
	 * Original signature:<br>
	 * {@code export function createWebWorker<T>(opts: IWebWorkerOptions): MonacoWebWorker<T>; }<br>
	 */
	public <T> MonacoWebWorker<T> createWebWorker(@Nonnull IWebWorkerOptions opts) { return call("createWebWorker", MonacoWebWorker ::new, opts); }

 	/**
	 * <p>Define a new theme or update an existing theme.</p>
	 * See {@code monaco.d.ts:941:31}<br>
	 * Original signature:<br>
	 * {@code export function defineTheme(themeName: string, themeData: IStandaloneThemeData): void; }<br>
	 */
	public void defineTheme(@Nonnull String themeName, @Nonnull IStandaloneThemeData themeData) { call("defineTheme", ofVoid(), themeName, themeData); }

 	/**
	 * <p>Get the model that has <code>uri</code> if it exists.</p>
	 * See {@code monaco.d.ts:884:28}<br>
	 * Original signature:<br>
	 * {@code export function getModel(uri: Uri): ITextModel | null; }<br>
	 */
	public Optional<ITextModel> getModel(@Nonnull Uri uri) { return Optional.ofNullable(call("getModel", ITextModel::new, uri)); }

 	/**
	 * <p>Get markers for owner and/or resource</p>
	 * See {@code monaco.d.ts:875:35}<br>
	 * Original signature:<br>
	 * {@code export function getModelMarkers(filter:  }<br>
	 */
	public List<IMarker> getModelMarkers(@Nonnull JSObject filter) { return call("getModelMarkers", ofArray(IMarker::new), filter); }

 	/**
	 * <p>Get all the created models.</p>
	 * See {@code monaco.d.ts:889:29}<br>
	 * Original signature:<br>
	 * {@code export function getModels(): ITextModel[]; }<br>
	 */
	public List<ITextModel> getModels() { return call("getModels", ofArray(ITextModel::new)); }

 	/**
	 * <p>Clears all cached font measurements and triggers re-measurement.</p>
	 * See {@code monaco.d.ts:951:34}<br>
	 * Original signature:<br>
	 * {@code export function remeasureFonts(): void; }<br>
	 */
	public void remeasureFonts() { call("remeasureFonts", ofVoid()); }

 	/**
	 * <p>Change the language for a model.</p>
	 * See {@code monaco.d.ts:863:36}<br>
	 * Original signature:<br>
	 * {@code export function setModelLanguage(model: ITextModel, languageId: string): void; }<br>
	 */
	public void setModelLanguage(@Nonnull ITextModel model, @Nonnull String languageId) { call("setModelLanguage", ofVoid(), model, languageId); }

 	/**
	 * <p>Set the markers for a model.</p>
	 * See {@code monaco.d.ts:868:35}<br>
	 * Original signature:<br>
	 * {@code export function setModelMarkers(model: ITextModel, owner: string, markers: IMarkerData[]): void; }<br>
	 */
	public void setModelMarkers(@Nonnull ITextModel model, @Nonnull String owner, @Nonnull List<IMarkerData> markers) { call("setModelMarkers", ofVoid(), model, owner, markers); }

 	/**
	 * <p>Switches to a theme.</p>
	 * See {@code monaco.d.ts:946:28}<br>
	 * Original signature:<br>
	 * {@code export function setTheme(themeName: string): void; }<br>
	 */
	public void setTheme(@Nonnull String themeName) { call("setTheme", ofVoid(), themeName); }

 	/**
	 * <p>Tokenize <code>text</code> using language <code>languageId</code></p>
	 * See {@code monaco.d.ts:936:28}<br>
	 * Original signature:<br>
	 * {@code export function tokenize(text: string, languageId: string): Token[][]; }<br>
	 */
	public List<List<Token>> tokenize(@Nonnull String text, @Nonnull String languageId) { return call("tokenize", ofArray(ofArray(Token::new)), text, languageId); }

 
}
