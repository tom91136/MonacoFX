
package monaco_editor.monaco.languages.typescript;
import java.util.List;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsPromise;
import net.kurobako.monacofx.js.JsProxy;
import netscape.javascript.JSObject;

/**
 * See {@code monaco.d.ts:6450:37}<br>
 * Original signature:<br>
 * {@code export interface TypeScriptWorker  }<br>
 */
@SuppressWarnings("unused")
public class TypeScriptWorker extends JsProxy {

	public TypeScriptWorker(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public TypeScriptWorker(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Get other occurrences which should be updated when renaming the item at the given file and position.</p>
	 * See {@code monaco.d.ts:6545:27}<br>
	 * Original signature:<br>
	 * {@code findRenameLocations(fileName: string, positon: number, findInStrings: boolean, findInComments: boolean, providePrefixAndSuffixTextForRename: boolean): Promise<readonly any[] | undefined>; }<br>
	 */
	public JsPromise<JSObject> findRenameLocations(@Nonnull String fileName, @Nonnull Double positon, @Nonnull Boolean findInStrings, @Nonnull Boolean findInComments, @Nonnull Boolean providePrefixAndSuffixTextForRename) { return call("findRenameLocations", JsPromise ::new, fileName, positon, findInStrings, findInComments, providePrefixAndSuffixTextForRename); }

 	/**
	 * <p>Get possible code fixes at the given position in the file.</p>
	 * See {@code monaco.d.ts:6565:30}<br>
	 * Original signature:<br>
	 * {@code getCodeFixesAtPosition(fileName: string, start: number, end: number, errorCodes: number[], formatOptions: any): Promise<ReadonlyArray<any>>; }<br>
	 * 
	 * @param formatOptions <code>typescript.FormatCodeOptions</code>
	 */
	public JsPromise<List<JSObject>> getCodeFixesAtPosition(@Nonnull String fileName, @Nonnull Double start, @Nonnull Double end, @Nonnull List<Double> errorCodes, @Nonnull JSObject formatOptions) { return call("getCodeFixesAtPosition", JsPromise ::new, fileName, start, end, errorCodes, formatOptions); }

 	/**
	 * <p>Get diagnostic messages related to the current compiler options.</p>
	 * See {@code monaco.d.ts:6470:37}<br>
	 * Original signature:<br>
	 * {@code getCompilerOptionsDiagnostics(fileName: string): Promise<Diagnostic[]>; }<br>
	 * 
	 * @param fileName Not used
	 */
	public JsPromise<List<Diagnostic>> getCompilerOptionsDiagnostics(@Nonnull String fileName) { return call("getCompilerOptionsDiagnostics", JsPromise ::new, fileName); }

 	/**
	 * <p>Get code completion details for the given file, position, and entry.</p>
	 * See {@code monaco.d.ts:6482:33}<br>
	 * Original signature:<br>
	 * {@code getCompletionEntryDetails(fileName: string, position: number, entry: string): Promise<any | undefined>; }<br>
	 */
	public JsPromise<JSObject> getCompletionEntryDetails(@Nonnull String fileName, @Nonnull Double position, @Nonnull String entry) { return call("getCompletionEntryDetails", JsPromise ::new, fileName, position, entry); }

 	/**
	 * <p>Get code completions for the given file and position.</p>
	 * See {@code monaco.d.ts:6476:32}<br>
	 * Original signature:<br>
	 * {@code getCompletionsAtPosition(fileName: string, position: number): Promise<any | undefined>; }<br>
	 */
	public JsPromise<JSObject> getCompletionsAtPosition(@Nonnull String fileName, @Nonnull Double position) { return call("getCompletionsAtPosition", JsPromise ::new, fileName, position); }

 	/**
	 * <p>Get the definition of the item at the given position in the file.</p>
	 * See {@code monaco.d.ts:6506:31}<br>
	 * Original signature:<br>
	 * {@code getDefinitionAtPosition(fileName: string, position: number): Promise<ReadonlyArray<any> | undefined>; }<br>
	 */
	public JsPromise<List<JSObject>> getDefinitionAtPosition(@Nonnull String fileName, @Nonnull Double position) { return call("getDefinitionAtPosition", JsPromise ::new, fileName, position); }

 	/**
	 * <p>Get transpiled output for the given file.</p>
	 * See {@code monaco.d.ts:6558:21}<br>
	 * Original signature:<br>
	 * {@code getEmitOutput(fileName: string): Promise<any>; }<br>
	 */
	public JsPromise<JSObject> getEmitOutput(@Nonnull String fileName) { return call("getEmitOutput", JsPromise ::new, fileName); }

 	/**
	 * <p>Get formatting changes which should be applied after the given keystroke.</p>
	 * See {@code monaco.d.ts:6539:40}<br>
	 * Original signature:<br>
	 * {@code getFormattingEditsAfterKeystroke(fileName: string, postion: number, ch: string, options: any): Promise<any[]>; }<br>
	 * 
	 * @param options <code>typescript.FormatCodeOptions</code>
	 */
	public JsPromise<List<JSObject>> getFormattingEditsAfterKeystroke(@Nonnull String fileName, @Nonnull Double postion, @Nonnull String ch, @Nonnull JSObject options) { return call("getFormattingEditsAfterKeystroke", JsPromise ::new, fileName, postion, ch, options); }

 	/**
	 * <p>Get changes which should be applied to format the given file.</p>
	 * See {@code monaco.d.ts:6525:37}<br>
	 * Original signature:<br>
	 * {@code getFormattingEditsForDocument(fileName: string, options: any): Promise<any[]>; }<br>
	 * 
	 * @param options <code>typescript.FormatCodeOptions</code>
	 */
	public JsPromise<List<JSObject>> getFormattingEditsForDocument(@Nonnull String fileName, @Nonnull JSObject options) { return call("getFormattingEditsForDocument", JsPromise ::new, fileName, options); }

 	/**
	 * <p>Get changes which should be applied to format the given range in the file.</p>
	 * See {@code monaco.d.ts:6532:34}<br>
	 * Original signature:<br>
	 * {@code getFormattingEditsForRange(fileName: string, start: number, end: number, options: any): Promise<any[]>; }<br>
	 * 
	 * @param options <code>typescript.FormatCodeOptions</code>
	 */
	public JsPromise<List<JSObject>> getFormattingEditsForRange(@Nonnull String fileName, @Nonnull Double start, @Nonnull Double end, @Nonnull JSObject options) { return call("getFormattingEditsForRange", JsPromise ::new, fileName, start, end, options); }

 	/**
	 * <p>Get outline entries for the item at the given position in the file.</p>
	 * See {@code monaco.d.ts:6518:29}<br>
	 * Original signature:<br>
	 * {@code getNavigationBarItems(fileName: string): Promise<any[]>; }<br>
	 */
	public JsPromise<List<JSObject>> getNavigationBarItems(@Nonnull String fileName) { return call("getNavigationBarItems", JsPromise ::new, fileName); }

 	/**
	 * <p>Get other ranges which are related to the item at the given position in the file (often used for highlighting).</p>
	 * See {@code monaco.d.ts:6500:32}<br>
	 * Original signature:<br>
	 * {@code getOccurrencesAtPosition(fileName: string, position: number): Promise<ReadonlyArray<any> | undefined>; }<br>
	 */
	public JsPromise<List<JSObject>> getOccurrencesAtPosition(@Nonnull String fileName, @Nonnull Double position) { return call("getOccurrencesAtPosition", JsPromise ::new, fileName, position); }

 	/**
	 * <p>Get quick info for the item at the given position in the file.</p>
	 * See {@code monaco.d.ts:6494:30}<br>
	 * Original signature:<br>
	 * {@code getQuickInfoAtPosition(fileName: string, position: number): Promise<any | undefined>; }<br>
	 */
	public JsPromise<JSObject> getQuickInfoAtPosition(@Nonnull String fileName, @Nonnull Double position) { return call("getQuickInfoAtPosition", JsPromise ::new, fileName, position); }

 	/**
	 * <p>Get references to the item at the given position in the file.</p>
	 * See {@code monaco.d.ts:6512:31}<br>
	 * Original signature:<br>
	 * {@code getReferencesAtPosition(fileName: string, position: number): Promise<any[] | undefined>; }<br>
	 */
	public JsPromise<List<JSObject>> getReferencesAtPosition(@Nonnull String fileName, @Nonnull Double position) { return call("getReferencesAtPosition", JsPromise ::new, fileName, position); }

 	/**
	 * <p>Get edits which should be applied to rename the item at the given file and position (or a failure reason).</p>
	 * See {@code monaco.d.ts:6552:21}<br>
	 * Original signature:<br>
	 * {@code getRenameInfo(fileName: string, positon: number, options: any): Promise<any>; }<br>
	 * 
	 * @param options <code>typescript.RenameInfoOptions</code>
	 */
	public JsPromise<JSObject> getRenameInfo(@Nonnull String fileName, @Nonnull Double positon, @Nonnull JSObject options) { return call("getRenameInfo", JsPromise ::new, fileName, positon, options); }

 	/**
	 * <p>Get diagnostic messages for any semantic issues in the given file.</p>
	 * See {@code monaco.d.ts:6459:30}<br>
	 * Original signature:<br>
	 * {@code getSemanticDiagnostics(fileName: string): Promise<Diagnostic[]>; }<br>
	 */
	public JsPromise<List<Diagnostic>> getSemanticDiagnostics(@Nonnull String fileName) { return call("getSemanticDiagnostics", JsPromise ::new, fileName); }

 	/**
	 * <p>Get signature help items for the item at the given file and position.</p>
	 * See {@code monaco.d.ts:6488:29}<br>
	 * Original signature:<br>
	 * {@code getSignatureHelpItems(fileName: string, position: number): Promise<any | undefined>; }<br>
	 */
	public JsPromise<JSObject> getSignatureHelpItems(@Nonnull String fileName, @Nonnull Double position) { return call("getSignatureHelpItems", JsPromise ::new, fileName, position); }

 	/**
	 * <p>Get diagnostic messages for any suggestions related to the given file.</p>
	 * See {@code monaco.d.ts:6464:32}<br>
	 * Original signature:<br>
	 * {@code getSuggestionDiagnostics(fileName: string): Promise<Diagnostic[]>; }<br>
	 */
	public JsPromise<List<Diagnostic>> getSuggestionDiagnostics(@Nonnull String fileName) { return call("getSuggestionDiagnostics", JsPromise ::new, fileName); }

 	/**
	 * <p>Get diagnostic messages for any syntax issues in the given file.</p>
	 * See {@code monaco.d.ts:6454:31}<br>
	 * Original signature:<br>
	 * {@code getSyntacticDiagnostics(fileName: string): Promise<Diagnostic[]>; }<br>
	 */
	public JsPromise<List<Diagnostic>> getSyntacticDiagnostics(@Nonnull String fileName) { return call("getSyntacticDiagnostics", JsPromise ::new, fileName); }

 
}
