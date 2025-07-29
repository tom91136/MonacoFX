
package monaco_editor.monaco;
import java.util.List;
import javax.annotation.Nonnull;
import monaco_editor.monaco.languages.CodeActionProvider;
import monaco_editor.monaco.languages.CodeLensProvider;
import monaco_editor.monaco.languages.CompletionItemProvider;
import monaco_editor.monaco.languages.CssModule;
import monaco_editor.monaco.languages.DeclarationProvider;
import monaco_editor.monaco.languages.DefinitionProvider;
import monaco_editor.monaco.languages.DocumentColorProvider;
import monaco_editor.monaco.languages.DocumentFormattingEditProvider;
import monaco_editor.monaco.languages.DocumentHighlightProvider;
import monaco_editor.monaco.languages.DocumentRangeFormattingEditProvider;
import monaco_editor.monaco.languages.DocumentRangeSemanticTokensProvider;
import monaco_editor.monaco.languages.DocumentSemanticTokensProvider;
import monaco_editor.monaco.languages.DocumentSymbolProvider;
import monaco_editor.monaco.languages.EncodedTokensProvider;
import monaco_editor.monaco.languages.FoldingRangeProvider;
import monaco_editor.monaco.languages.HoverProvider;
import monaco_editor.monaco.languages.HtmlModule;
import monaco_editor.monaco.languages.ILanguageExtensionPoint;
import monaco_editor.monaco.languages.IMonarchLanguage;
import monaco_editor.monaco.languages.ImplementationProvider;
import monaco_editor.monaco.languages.JsonModule;
import monaco_editor.monaco.languages.LanguageConfiguration;
import monaco_editor.monaco.languages.LinkProvider;
import monaco_editor.monaco.languages.OnTypeFormattingEditProvider;
import monaco_editor.monaco.languages.ReferenceProvider;
import monaco_editor.monaco.languages.RenameProvider;
import monaco_editor.monaco.languages.SelectionRangeProvider;
import monaco_editor.monaco.languages.SignatureHelpProvider;
import monaco_editor.monaco.languages.TokensProvider;
import monaco_editor.monaco.languages.TypeDefinitionProvider;
import monaco_editor.monaco.languages.TypescriptModule;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsPromise;
import net.kurobako.monacofx.js.JsProxy;
import net.kurobako.monacofx.js.JsUnion2;

/**
 * See {@code monaco.d.ts:4653:34}<br>
 * See {@code monaco.d.ts:6190:34}<br>
 * See {@code monaco.d.ts:6581:34}<br>
 * See {@code monaco.d.ts:6681:34}<br>
 * See {@code monaco.d.ts:6783:34}<br>
 * Original signature:<br>
 * {@code declare namespace monaco.languages  }<br>
 * {@code declare namespace monaco.languages.typescript  }<br>
 * {@code declare namespace monaco.languages.css  }<br>
 * {@code declare namespace monaco.languages.json  }<br>
 * {@code declare namespace monaco.languages.html  }<br>
 */
@SuppressWarnings("unused")
public class LanguagesModule extends JsProxy {

	public LanguagesModule(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public LanguagesModule(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:6581:38}<br>
	 * Original signature:<br>
	 * {@code declare namespace monaco.languages.css  }<br>
	 */
	public CssModule css() { return get("css", CssModule::new); }

 	/**
	 * See {@code monaco.d.ts:6783:39}<br>
	 * Original signature:<br>
	 * {@code declare namespace monaco.languages.html  }<br>
	 */
	public HtmlModule html() { return get("html", HtmlModule::new); }

 	/**
	 * See {@code monaco.d.ts:6681:39}<br>
	 * Original signature:<br>
	 * {@code declare namespace monaco.languages.json  }<br>
	 */
	public JsonModule json() { return get("json", JsonModule::new); }

 	/**
	 * See {@code monaco.d.ts:6190:45}<br>
	 * Original signature:<br>
	 * {@code declare namespace monaco.languages.typescript  }<br>
	 */
	public TypescriptModule typescript() { return get("typescript", TypescriptModule::new); }

 	/**
	 * See {@code monaco.d.ts:4666:40}<br>
	 * Original signature:<br>
	 * {@code export function getEncodedLanguageId(languageId: string): number; }<br>
	 */
	public double getEncodedLanguageId(@Nonnull String languageId) { return call("getEncodedLanguageId", ofMapped(double.class), languageId); }

 	/**
	 * <p>Get the information of all the registered languages.</p>
	 * See {@code monaco.d.ts:4664:32}<br>
	 * Original signature:<br>
	 * {@code export function getLanguages(): ILanguageExtensionPoint[]; }<br>
	 */
	public List<ILanguageExtensionPoint> getLanguages() { return call("getLanguages", ofArray(ILanguageExtensionPoint::new)); }

 	/**
	 * <p>Register information about a new language.</p>
	 * See {@code monaco.d.ts:4659:28}<br>
	 * Original signature:<br>
	 * {@code export function register(language: ILanguageExtensionPoint): void; }<br>
	 */
	public void register(@Nonnull ILanguageExtensionPoint language) { call("register", ofVoid(), language); }

 	/**
	 * <p>Register a code action provider (used by e.g. quick fix).</p>
	 * See {@code monaco.d.ts:4825:46}<br>
	 * Original signature:<br>
	 * {@code export function registerCodeActionProvider(languageId: string, provider: CodeActionProvider): IDisposable; }<br>
	 */
	public IDisposable registerCodeActionProvider(@Nonnull String languageId, @Nonnull CodeActionProvider provider) { return call("registerCodeActionProvider", IDisposable::new, languageId, provider); }

 	/**
	 * <p>Register a code lens provider (used by e.g. inline code lenses).</p>
	 * See {@code monaco.d.ts:4820:44}<br>
	 * Original signature:<br>
	 * {@code export function registerCodeLensProvider(languageId: string, provider: CodeLensProvider): IDisposable; }<br>
	 */
	public IDisposable registerCodeLensProvider(@Nonnull String languageId, @Nonnull CodeLensProvider provider) { return call("registerCodeLensProvider", IDisposable::new, languageId, provider); }

 	/**
	 * <p>Register a document color provider (used by Color Picker, Color Decorator).</p>
	 * See {@code monaco.d.ts:4855:41}<br>
	 * Original signature:<br>
	 * {@code export function registerColorProvider(languageId: string, provider: DocumentColorProvider): IDisposable; }<br>
	 */
	public IDisposable registerColorProvider(@Nonnull String languageId, @Nonnull DocumentColorProvider provider) { return call("registerColorProvider", IDisposable::new, languageId, provider); }

 	/**
	 * <p>Register a completion item provider (use by e.g. suggestions).</p>
	 * See {@code monaco.d.ts:4850:50}<br>
	 * Original signature:<br>
	 * {@code export function registerCompletionItemProvider(languageId: string, provider: CompletionItemProvider): IDisposable; }<br>
	 */
	public IDisposable registerCompletionItemProvider(@Nonnull String languageId, @Nonnull CompletionItemProvider provider) { return call("registerCompletionItemProvider", IDisposable::new, languageId, provider); }

 	/**
	 * <p>Register a declaration provider</p>
	 * See {@code monaco.d.ts:4865:47}<br>
	 * Original signature:<br>
	 * {@code export function registerDeclarationProvider(languageId: string, provider: DeclarationProvider): IDisposable; }<br>
	 */
	public IDisposable registerDeclarationProvider(@Nonnull String languageId, @Nonnull DeclarationProvider provider) { return call("registerDeclarationProvider", IDisposable::new, languageId, provider); }

 	/**
	 * <p>Register a definition provider (used by e.g. go to definition).</p>
	 * See {@code monaco.d.ts:4805:46}<br>
	 * Original signature:<br>
	 * {@code export function registerDefinitionProvider(languageId: string, provider: DefinitionProvider): IDisposable; }<br>
	 */
	public IDisposable registerDefinitionProvider(@Nonnull String languageId, @Nonnull DefinitionProvider provider) { return call("registerDefinitionProvider", IDisposable::new, languageId, provider); }

 	/**
	 * <p>Register a formatter that can handle only entire models.</p>
	 * See {@code monaco.d.ts:4830:58}<br>
	 * Original signature:<br>
	 * {@code export function registerDocumentFormattingEditProvider(languageId: string, provider: DocumentFormattingEditProvider): IDisposable; }<br>
	 */
	public IDisposable registerDocumentFormattingEditProvider(@Nonnull String languageId, @Nonnull DocumentFormattingEditProvider provider) { return call("registerDocumentFormattingEditProvider", IDisposable::new, languageId, provider); }

 	/**
	 * <p>Register a document highlight provider (used by e.g. highlight occurrences).</p>
	 * See {@code monaco.d.ts:4800:53}<br>
	 * Original signature:<br>
	 * {@code export function registerDocumentHighlightProvider(languageId: string, provider: DocumentHighlightProvider): IDisposable; }<br>
	 */
	public IDisposable registerDocumentHighlightProvider(@Nonnull String languageId, @Nonnull DocumentHighlightProvider provider) { return call("registerDocumentHighlightProvider", IDisposable::new, languageId, provider); }

 	/**
	 * <p>Register a formatter that can handle a range inside a model.</p>
	 * See {@code monaco.d.ts:4835:63}<br>
	 * Original signature:<br>
	 * {@code export function registerDocumentRangeFormattingEditProvider(languageId: string, provider: DocumentRangeFormattingEditProvider): IDisposable; }<br>
	 */
	public IDisposable registerDocumentRangeFormattingEditProvider(@Nonnull String languageId, @Nonnull DocumentRangeFormattingEditProvider provider) { return call("registerDocumentRangeFormattingEditProvider", IDisposable::new, languageId, provider); }

 	/**
	 * <p>Register a document range semantic tokens provider</p>
	 * See {@code monaco.d.ts:4880:63}<br>
	 * Original signature:<br>
	 * {@code export function registerDocumentRangeSemanticTokensProvider(languageId: string, provider: DocumentRangeSemanticTokensProvider): IDisposable; }<br>
	 */
	public IDisposable registerDocumentRangeSemanticTokensProvider(@Nonnull String languageId, @Nonnull DocumentRangeSemanticTokensProvider provider) { return call("registerDocumentRangeSemanticTokensProvider", IDisposable::new, languageId, provider); }

 	/**
	 * <p>Register a document semantic tokens provider</p>
	 * See {@code monaco.d.ts:4875:58}<br>
	 * Original signature:<br>
	 * {@code export function registerDocumentSemanticTokensProvider(languageId: string, provider: DocumentSemanticTokensProvider): IDisposable; }<br>
	 */
	public IDisposable registerDocumentSemanticTokensProvider(@Nonnull String languageId, @Nonnull DocumentSemanticTokensProvider provider) { return call("registerDocumentSemanticTokensProvider", IDisposable::new, languageId, provider); }

 	/**
	 * <p>Register a document symbol provider (used by e.g. outline).</p>
	 * See {@code monaco.d.ts:4795:50}<br>
	 * Original signature:<br>
	 * {@code export function registerDocumentSymbolProvider(languageId: string, provider: DocumentSymbolProvider): IDisposable; }<br>
	 */
	public IDisposable registerDocumentSymbolProvider(@Nonnull String languageId, @Nonnull DocumentSymbolProvider provider) { return call("registerDocumentSymbolProvider", IDisposable::new, languageId, provider); }

 	/**
	 * <p>Register a folding range provider</p>
	 * See {@code monaco.d.ts:4860:48}<br>
	 * Original signature:<br>
	 * {@code export function registerFoldingRangeProvider(languageId: string, provider: FoldingRangeProvider): IDisposable; }<br>
	 */
	public IDisposable registerFoldingRangeProvider(@Nonnull String languageId, @Nonnull FoldingRangeProvider provider) { return call("registerFoldingRangeProvider", IDisposable::new, languageId, provider); }

 	/**
	 * <p>Register a hover provider (used by e.g. editor hover).</p>
	 * See {@code monaco.d.ts:4790:41}<br>
	 * Original signature:<br>
	 * {@code export function registerHoverProvider(languageId: string, provider: HoverProvider): IDisposable; }<br>
	 */
	public IDisposable registerHoverProvider(@Nonnull String languageId, @Nonnull HoverProvider provider) { return call("registerHoverProvider", IDisposable::new, languageId, provider); }

 	/**
	 * <p>Register a implementation provider (used by e.g. go to implementation).</p>
	 * See {@code monaco.d.ts:4810:50}<br>
	 * Original signature:<br>
	 * {@code export function registerImplementationProvider(languageId: string, provider: ImplementationProvider): IDisposable; }<br>
	 */
	public IDisposable registerImplementationProvider(@Nonnull String languageId, @Nonnull ImplementationProvider provider) { return call("registerImplementationProvider", IDisposable::new, languageId, provider); }

 	/**
	 * <p>Register a link provider that can find links in text.</p>
	 * See {@code monaco.d.ts:4845:40}<br>
	 * Original signature:<br>
	 * {@code export function registerLinkProvider(languageId: string, provider: LinkProvider): IDisposable; }<br>
	 */
	public IDisposable registerLinkProvider(@Nonnull String languageId, @Nonnull LinkProvider provider) { return call("registerLinkProvider", IDisposable::new, languageId, provider); }

 	/**
	 * <p>Register a formatter than can do formatting as the user types.</p>
	 * See {@code monaco.d.ts:4840:56}<br>
	 * Original signature:<br>
	 * {@code export function registerOnTypeFormattingEditProvider(languageId: string, provider: OnTypeFormattingEditProvider): IDisposable; }<br>
	 */
	public IDisposable registerOnTypeFormattingEditProvider(@Nonnull String languageId, @Nonnull OnTypeFormattingEditProvider provider) { return call("registerOnTypeFormattingEditProvider", IDisposable::new, languageId, provider); }

 	/**
	 * <p>Register a reference provider (used by e.g. reference search).</p>
	 * See {@code monaco.d.ts:4775:45}<br>
	 * Original signature:<br>
	 * {@code export function registerReferenceProvider(languageId: string, provider: ReferenceProvider): IDisposable; }<br>
	 */
	public IDisposable registerReferenceProvider(@Nonnull String languageId, @Nonnull ReferenceProvider provider) { return call("registerReferenceProvider", IDisposable::new, languageId, provider); }

 	/**
	 * <p>Register a rename provider (used by e.g. rename symbol).</p>
	 * See {@code monaco.d.ts:4780:42}<br>
	 * Original signature:<br>
	 * {@code export function registerRenameProvider(languageId: string, provider: RenameProvider): IDisposable; }<br>
	 */
	public IDisposable registerRenameProvider(@Nonnull String languageId, @Nonnull RenameProvider provider) { return call("registerRenameProvider", IDisposable::new, languageId, provider); }

 	/**
	 * <p>Register a selection range provider</p>
	 * See {@code monaco.d.ts:4870:50}<br>
	 * Original signature:<br>
	 * {@code export function registerSelectionRangeProvider(languageId: string, provider: SelectionRangeProvider): IDisposable; }<br>
	 */
	public IDisposable registerSelectionRangeProvider(@Nonnull String languageId, @Nonnull SelectionRangeProvider provider) { return call("registerSelectionRangeProvider", IDisposable::new, languageId, provider); }

 	/**
	 * <p>Register a signature help provider (used by e.g. parameter hints).</p>
	 * See {@code monaco.d.ts:4785:49}<br>
	 * Original signature:<br>
	 * {@code export function registerSignatureHelpProvider(languageId: string, provider: SignatureHelpProvider): IDisposable; }<br>
	 */
	public IDisposable registerSignatureHelpProvider(@Nonnull String languageId, @Nonnull SignatureHelpProvider provider) { return call("registerSignatureHelpProvider", IDisposable::new, languageId, provider); }

 	/**
	 * <p>Register a type definition provider (used by e.g. go to type definition).</p>
	 * See {@code monaco.d.ts:4815:50}<br>
	 * Original signature:<br>
	 * {@code export function registerTypeDefinitionProvider(languageId: string, provider: TypeDefinitionProvider): IDisposable; }<br>
	 */
	public IDisposable registerTypeDefinitionProvider(@Nonnull String languageId, @Nonnull TypeDefinitionProvider provider) { return call("registerTypeDefinitionProvider", IDisposable::new, languageId, provider); }

 	/**
	 * <p>Set the editing configuration for a language.</p>
	 * See {@code monaco.d.ts:4677:44}<br>
	 * Original signature:<br>
	 * {@code export function setLanguageConfiguration(languageId: string, configuration: LanguageConfiguration): IDisposable; }<br>
	 */
	public IDisposable setLanguageConfiguration(@Nonnull String languageId, @Nonnull LanguageConfiguration configuration) { return call("setLanguageConfiguration", IDisposable::new, languageId, configuration); }

 	/**
	 * <p>Set the tokens provider for a language (monarch implementation).</p>
	 * See {@code monaco.d.ts:4770:44}<br>
	 * Original signature:<br>
	 * {@code export function setMonarchTokensProvider(languageId: string, languageDef: IMonarchLanguage | Thenable<IMonarchLanguage>): IDisposable; }<br>
	 */
	public IDisposable setMonarchTokensProvider(@Nonnull String languageId, @Nonnull IMonarchLanguage languageDef) { return call("setMonarchTokensProvider", IDisposable::new, languageId, languageDef); }

 	/**
	 * <p>Set the tokens provider for a language (monarch implementation).</p>
	 * See {@code monaco.d.ts:4770:44}<br>
	 * Original signature:<br>
	 * {@code export function setMonarchTokensProvider(languageId: string, languageDef: IMonarchLanguage | Thenable<IMonarchLanguage>): IDisposable; }<br>
	 */
	public IDisposable setMonarchTokensProvider(@Nonnull String languageId, @Nonnull JsPromise<IMonarchLanguage> languageDef) { return call("setMonarchTokensProvider", IDisposable::new, languageId, languageDef); }

 	/**
	 * <p>Set the tokens provider for a language (manual implementation).</p>
	 * See {@code monaco.d.ts:4765:37}<br>
	 * Original signature:<br>
	 * {@code export function setTokensProvider(languageId: string, provider: TokensProvider | EncodedTokensProvider | Thenable<TokensProvider | EncodedTokensProvider>): IDisposable; }<br>
	 */
	public IDisposable setTokensProvider(@Nonnull String languageId, @Nonnull TokensProvider provider) { return call("setTokensProvider", IDisposable::new, languageId, provider); }

 	/**
	 * <p>Set the tokens provider for a language (manual implementation).</p>
	 * See {@code monaco.d.ts:4765:37}<br>
	 * Original signature:<br>
	 * {@code export function setTokensProvider(languageId: string, provider: TokensProvider | EncodedTokensProvider | Thenable<TokensProvider | EncodedTokensProvider>): IDisposable; }<br>
	 */
	public IDisposable setTokensProvider(@Nonnull String languageId, @Nonnull JsPromise<JsUnion2<TokensProvider, EncodedTokensProvider>> provider) { return call("setTokensProvider", IDisposable::new, languageId, provider); }

 	/**
	 * <p>Set the tokens provider for a language (manual implementation).</p>
	 * See {@code monaco.d.ts:4765:37}<br>
	 * Original signature:<br>
	 * {@code export function setTokensProvider(languageId: string, provider: TokensProvider | EncodedTokensProvider | Thenable<TokensProvider | EncodedTokensProvider>): IDisposable; }<br>
	 */
	public IDisposable setTokensProvider(@Nonnull String languageId, @Nonnull EncodedTokensProvider provider) { return call("setTokensProvider", IDisposable::new, languageId, provider); }

 
}
