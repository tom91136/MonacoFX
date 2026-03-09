
package monaco_editor.monaco.editor;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import monaco_editor.monaco.IPosition;
import monaco_editor.monaco.IRange;
import monaco_editor.monaco.Position;
import monaco_editor.monaco.Range;
import monaco_editor.monaco.Selection;
import monaco_editor.monaco.Uri;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>A model.</p>
 * See {@code monaco.d.ts:1560:31}<br>
 * Original signature:<br>
 * {@code export interface ITextModel  }<br>
 */
@SuppressWarnings("unused")
public class ITextModel extends JsProxy {

	public ITextModel(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public ITextModel(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>A unique identifier associated with this model.</p>
	 * See {@code monaco.d.ts:1568:19}<br>
	 * Original signature:<br>
	 * {@code readonly id: string; }<br>
	 */
	public String id() { return get("id", ofMapped(String.class)); }

 	/**
	 * <p>Gets the resource associated with this editor model.</p>
	 * See {@code monaco.d.ts:1564:20}<br>
	 * Original signature:<br>
	 * {@code readonly uri: Uri; }<br>
	 */
	public Uri uri() { return get("uri", Uri::new); }

 	/**
	 * <p>Edit the model without adding the edits to the undo stack.
	 * This can have dire consequences on the undo stack! See @pushEditOperations for the preferred way.</p>
	 * See {@code monaco.d.ts:1861:18}<br>
	 * Original signature:<br>
	 * {@code applyEdits(operations: IIdentifiedSingleEditOperation[]): IIdentifiedSingleEditOperation[]; }<br>
	 * 
	 * @param operations The edit operations.
	 */
	public List<IIdentifiedSingleEditOperation> applyEdits(@Nonnull List<IIdentifiedSingleEditOperation> operations) { return call("applyEdits", ofArray(IIdentifiedSingleEditOperation::new), operations); }

 	/**
	 * <p>Perform a minimum amount of operations, in order to transform the decorations
	 * identified by <code>oldDecorations</code> to the decorations described by <code>newDecorations</code>
	 * and returns the new identifiers associated with the resulting decorations.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:1772:24}<br>
	 * Original signature:<br>
	 * {@code deltaDecorations(oldDecorations: string[], newDecorations: IModelDeltaDecoration[], ownerId?: number): string[]; }<br>
	 */
	public List<String> deltaDecorations(@Nonnull List<String> oldDecorations, @Nonnull List<IModelDeltaDecoration> newDecorations) { return call("deltaDecorations", ofArray(ofMapped(String.class)), oldDecorations, newDecorations); }

 	/**
	 * <p>Perform a minimum amount of operations, in order to transform the decorations
	 * identified by <code>oldDecorations</code> to the decorations described by <code>newDecorations</code>
	 * and returns the new identifiers associated with the resulting decorations.</p>
	 * See {@code monaco.d.ts:1772:24}<br>
	 * Original signature:<br>
	 * {@code deltaDecorations(oldDecorations: string[], newDecorations: IModelDeltaDecoration[], ownerId?: number): string[]; }<br>
	 * 
	 * @param oldDecorations Array containing previous decorations identifiers.
	 * @param newDecorations Array describing what decorations should result after the call.
	 * @param ownerId Identifies the editor id in which these decorations should appear. If no <code>ownerId</code> is provided, the decorations will appear in all editors that attach this model.
	 */
	public List<String> deltaDecorations(@Nonnull List<String> oldDecorations, @Nonnull List<IModelDeltaDecoration> newDecorations, @Nonnull Double ownerId) { return call("deltaDecorations", ofArray(ofMapped(String.class)), oldDecorations, newDecorations, ownerId); }

 	/**
	 * <p>Detect the indentation options for this model from its content.</p>
	 * See {@code monaco.d.ts:1834:25}<br>
	 * Original signature:<br>
	 * {@code detectIndentation(defaultInsertSpaces: boolean, defaultTabSize: number): void; }<br>
	 */
	public void detectIndentation(@Nonnull Boolean defaultInsertSpaces, @Nonnull Double defaultTabSize) { call("detectIndentation", ofVoid(), defaultInsertSpaces, defaultTabSize); }

 	/**
	 * <p>Destroy this model. This will unbind the model from the mode
	 * and make all necessary clean-up to release this object to the GC.</p>
	 * See {@code monaco.d.ts:1901:15}<br>
	 * Original signature:<br>
	 * {@code dispose(): void; }<br>
	 */
	public void dispose() { call("dispose", ofVoid()); }

 	/**
	 * <p>Search the model.</p>
	 * See {@code monaco.d.ts:1711:19}<br>
	 * See {@code monaco.d.ts:1723:19}<br>
	 * Original signature:<br>
	 * {@code findMatches(searchString: string, searchOnlyEditableRange: boolean, isRegex: boolean, matchCase: boolean, wordSeparators: string | null, captureMatches: boolean, limitResultCount?: number): FindMatch[]; }<br>
	 * {@code findMatches(searchString: string, searchScope: IRange, isRegex: boolean, matchCase: boolean, wordSeparators: string | null, captureMatches: boolean, limitResultCount?: number): FindMatch[]; }<br>
	 * 
	 * @param searchString The string used to search. If it is a regular expression, set <code>isRegex</code> to true.
	 * @param searchOnlyEditableRange Limit the searching to only search inside the editable range of the model.
	 * @param isRegex Used to indicate that <code>searchString</code> is a regular expression.
	 * @param matchCase Force the matching to match lower/upper case exactly.
	 * @param wordSeparators Force the matching to match entire words only. Pass null otherwise.
	 * @param captureMatches The result will contain the captured groups.
	 * @param limitResultCount Limit the number of results
	 */
	public List<FindMatch> findMatches(@Nonnull String searchString, @Nonnull Boolean searchOnlyEditableRange, @Nonnull Boolean isRegex, @Nonnull Boolean matchCase, @Nullable String wordSeparators, @Nonnull Boolean captureMatches, @Nonnull Double limitResultCount) { return call("findMatches", ofArray(FindMatch::new), searchString, searchOnlyEditableRange, isRegex, matchCase, wordSeparators, captureMatches, limitResultCount); }

 	/**
	 * <p>Search the model.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:1711:19}<br>
	 * See {@code monaco.d.ts:1723:19}<br>
	 * Original signature:<br>
	 * {@code findMatches(searchString: string, searchOnlyEditableRange: boolean, isRegex: boolean, matchCase: boolean, wordSeparators: string | null, captureMatches: boolean, limitResultCount?: number): FindMatch[]; }<br>
	 * {@code findMatches(searchString: string, searchScope: IRange, isRegex: boolean, matchCase: boolean, wordSeparators: string | null, captureMatches: boolean, limitResultCount?: number): FindMatch[]; }<br>
	 */
	public List<FindMatch> findMatches(@Nonnull String searchString, @Nonnull IRange searchScope, @Nonnull Boolean isRegex, @Nonnull Boolean matchCase, @Nullable String wordSeparators, @Nonnull Boolean captureMatches) { return call("findMatches", ofArray(FindMatch::new), searchString, searchScope, isRegex, matchCase, wordSeparators, captureMatches); }

 	/**
	 * <p>Search the model.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:1711:19}<br>
	 * See {@code monaco.d.ts:1723:19}<br>
	 * Original signature:<br>
	 * {@code findMatches(searchString: string, searchOnlyEditableRange: boolean, isRegex: boolean, matchCase: boolean, wordSeparators: string | null, captureMatches: boolean, limitResultCount?: number): FindMatch[]; }<br>
	 * {@code findMatches(searchString: string, searchScope: IRange, isRegex: boolean, matchCase: boolean, wordSeparators: string | null, captureMatches: boolean, limitResultCount?: number): FindMatch[]; }<br>
	 */
	public List<FindMatch> findMatches(@Nonnull String searchString, @Nonnull Boolean searchOnlyEditableRange, @Nonnull Boolean isRegex, @Nonnull Boolean matchCase, @Nullable String wordSeparators, @Nonnull Boolean captureMatches) { return call("findMatches", ofArray(FindMatch::new), searchString, searchOnlyEditableRange, isRegex, matchCase, wordSeparators, captureMatches); }

 	/**
	 * <p>Search the model.</p>
	 * See {@code monaco.d.ts:1711:19}<br>
	 * See {@code monaco.d.ts:1723:19}<br>
	 * Original signature:<br>
	 * {@code findMatches(searchString: string, searchOnlyEditableRange: boolean, isRegex: boolean, matchCase: boolean, wordSeparators: string | null, captureMatches: boolean, limitResultCount?: number): FindMatch[]; }<br>
	 * {@code findMatches(searchString: string, searchScope: IRange, isRegex: boolean, matchCase: boolean, wordSeparators: string | null, captureMatches: boolean, limitResultCount?: number): FindMatch[]; }<br>
	 * 
	 * @param searchString The string used to search. If it is a regular expression, set <code>isRegex</code> to true.
	 * @param searchScope Limit the searching to only search inside this range.
	 * @param isRegex Used to indicate that <code>searchString</code> is a regular expression.
	 * @param matchCase Force the matching to match lower/upper case exactly.
	 * @param wordSeparators Force the matching to match entire words only. Pass null otherwise.
	 * @param captureMatches The result will contain the captured groups.
	 * @param limitResultCount Limit the number of results
	 */
	public List<FindMatch> findMatches(@Nonnull String searchString, @Nonnull IRange searchScope, @Nonnull Boolean isRegex, @Nonnull Boolean matchCase, @Nullable String wordSeparators, @Nonnull Boolean captureMatches, @Nonnull Double limitResultCount) { return call("findMatches", ofArray(FindMatch::new), searchString, searchScope, isRegex, matchCase, wordSeparators, captureMatches, limitResultCount); }

 	/**
	 * <p>Search the model for the next match. Loops to the beginning of the model if needed.</p>
	 * See {@code monaco.d.ts:1734:21}<br>
	 * Original signature:<br>
	 * {@code findNextMatch(searchString: string, searchStart: IPosition, isRegex: boolean, matchCase: boolean, wordSeparators: string | null, captureMatches: boolean): FindMatch | null; }<br>
	 * 
	 * @param searchString The string used to search. If it is a regular expression, set <code>isRegex</code> to true.
	 * @param searchStart Start the searching at the specified position.
	 * @param isRegex Used to indicate that <code>searchString</code> is a regular expression.
	 * @param matchCase Force the matching to match lower/upper case exactly.
	 * @param wordSeparators Force the matching to match entire words only. Pass null otherwise.
	 * @param captureMatches The result will contain the captured groups.
	 */
	public Optional<FindMatch> findNextMatch(@Nonnull String searchString, @Nonnull IPosition searchStart, @Nonnull Boolean isRegex, @Nonnull Boolean matchCase, @Nullable String wordSeparators, @Nonnull Boolean captureMatches) { return Optional.ofNullable(call("findNextMatch", FindMatch::new, searchString, searchStart, isRegex, matchCase, wordSeparators, captureMatches)); }

 	/**
	 * <p>Search the model for the previous match. Loops to the end of the model if needed.</p>
	 * See {@code monaco.d.ts:1745:25}<br>
	 * Original signature:<br>
	 * {@code findPreviousMatch(searchString: string, searchStart: IPosition, isRegex: boolean, matchCase: boolean, wordSeparators: string | null, captureMatches: boolean): FindMatch | null; }<br>
	 * 
	 * @param searchString The string used to search. If it is a regular expression, set <code>isRegex</code> to true.
	 * @param searchStart Start the searching at the specified position.
	 * @param isRegex Used to indicate that <code>searchString</code> is a regular expression.
	 * @param matchCase Force the matching to match lower/upper case exactly.
	 * @param wordSeparators Force the matching to match entire words only. Pass null otherwise.
	 * @param captureMatches The result will contain the captured groups.
	 */
	public Optional<FindMatch> findPreviousMatch(@Nonnull String searchString, @Nonnull IPosition searchStart, @Nonnull Boolean isRegex, @Nonnull Boolean matchCase, @Nullable String wordSeparators, @Nonnull Boolean captureMatches) { return Optional.ofNullable(call("findPreviousMatch", FindMatch::new, searchString, searchStart, isRegex, matchCase, wordSeparators, captureMatches)); }

 	/**
	 * <p>Gets all the decorations as an array.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:1816:25}<br>
	 * Original signature:<br>
	 * {@code getAllDecorations(ownerId?: number, filterOutValidation?: boolean): IModelDecoration[]; }<br>
	 */
	public List<IModelDecoration> getAllDecorations(@Nonnull Double ownerId) { return call("getAllDecorations", ofArray(IModelDecoration::new), ownerId); }

 	/**
	 * <p>Gets all the decorations as an array.</p>
	 * See {@code monaco.d.ts:1816:25}<br>
	 * Original signature:<br>
	 * {@code getAllDecorations(ownerId?: number, filterOutValidation?: boolean): IModelDecoration[]; }<br>
	 * 
	 * @param ownerId If set, it will ignore decorations belonging to other owners.
	 * @param filterOutValidation If set, it will ignore decorations specific to validation (i.e. warnings, errors).
	 */
	public List<IModelDecoration> getAllDecorations(@Nonnull Double ownerId, @Nonnull Boolean filterOutValidation) { return call("getAllDecorations", ofArray(IModelDecoration::new), ownerId, filterOutValidation); }

 	/**
	 * <p>Gets all the decorations as an array.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:1816:25}<br>
	 * Original signature:<br>
	 * {@code getAllDecorations(ownerId?: number, filterOutValidation?: boolean): IModelDecoration[]; }<br>
	 */
	public List<IModelDecoration> getAllDecorations() { return call("getAllDecorations", ofArray(IModelDecoration::new)); }

 	/**
	 * <p>Get the alternative version id of the model.
	 * This alternative version id is not always incremented,
	 * it will return the same values in the case of undo-redo.</p>
	 * See {@code monaco.d.ts:1584:31}<br>
	 * Original signature:<br>
	 * {@code getAlternativeVersionId(): number; }<br>
	 */
	public double getAlternativeVersionId() { return call("getAlternativeVersionId", ofMapped(double.class)); }

 	/**
	 * <p>Get the character count of text in a certain range.</p>
	 * See {@code monaco.d.ts:1617:32}<br>
	 * Original signature:<br>
	 * {@code getCharacterCountInRange(range: IRange): number; }<br>
	 * 
	 * @param range The range describing what text length to get.
	 */
	public double getCharacterCountInRange(@Nonnull IRange range) { return call("getCharacterCountInRange", ofMapped(double.class), range); }

 	/**
	 * <p>Get the options associated with a decoration.</p>
	 * See {@code monaco.d.ts:1778:28}<br>
	 * Original signature:<br>
	 * {@code getDecorationOptions(id: string): IModelDecorationOptions | null; }<br>
	 * 
	 * @param id The decoration id.
	 */
	public Optional<IModelDecorationOptions> getDecorationOptions(@Nonnull String id) { return Optional.ofNullable(call("getDecorationOptions", IModelDecorationOptions::new, id)); }

 	/**
	 * <p>Get the range associated with a decoration.</p>
	 * See {@code monaco.d.ts:1784:26}<br>
	 * Original signature:<br>
	 * {@code getDecorationRange(id: string): Range | null; }<br>
	 * 
	 * @param id The decoration id.
	 */
	public Optional<Range> getDecorationRange(@Nonnull String id) { return Optional.ofNullable(call("getDecorationRange", Range::new, id)); }

 	/**
	 * <p>Gets all the decorations in a range as an array. Only <code>startLineNumber</code> and <code>endLineNumber</code> from <code>range</code> are used for filtering.
	 * So for now it returns all the decorations on the same line as <code>range</code>.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:1810:29}<br>
	 * Original signature:<br>
	 * {@code getDecorationsInRange(range: IRange, ownerId?: number, filterOutValidation?: boolean): IModelDecoration[]; }<br>
	 */
	public List<IModelDecoration> getDecorationsInRange(@Nonnull IRange range) { return call("getDecorationsInRange", ofArray(IModelDecoration::new), range); }

 	/**
	 * <p>Gets all the decorations in a range as an array. Only <code>startLineNumber</code> and <code>endLineNumber</code> from <code>range</code> are used for filtering.
	 * So for now it returns all the decorations on the same line as <code>range</code>.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:1810:29}<br>
	 * Original signature:<br>
	 * {@code getDecorationsInRange(range: IRange, ownerId?: number, filterOutValidation?: boolean): IModelDecoration[]; }<br>
	 */
	public List<IModelDecoration> getDecorationsInRange(@Nonnull IRange range, @Nonnull Double ownerId) { return call("getDecorationsInRange", ofArray(IModelDecoration::new), range, ownerId); }

 	/**
	 * <p>Gets all the decorations in a range as an array. Only <code>startLineNumber</code> and <code>endLineNumber</code> from <code>range</code> are used for filtering.
	 * So for now it returns all the decorations on the same line as <code>range</code>.</p>
	 * See {@code monaco.d.ts:1810:29}<br>
	 * Original signature:<br>
	 * {@code getDecorationsInRange(range: IRange, ownerId?: number, filterOutValidation?: boolean): IModelDecoration[]; }<br>
	 * 
	 * @param range The range to search in
	 * @param ownerId If set, it will ignore decorations belonging to other owners.
	 * @param filterOutValidation If set, it will ignore decorations specific to validation (i.e. warnings, errors).
	 */
	public List<IModelDecoration> getDecorationsInRange(@Nonnull IRange range, @Nonnull Double ownerId, @Nonnull Boolean filterOutValidation) { return call("getDecorationsInRange", ofArray(IModelDecoration::new), range, ownerId, filterOutValidation); }

 	/**
	 * <p>Get the end of line sequence predominantly used in the text buffer.</p>
	 * See {@code monaco.d.ts:1638:14}<br>
	 * Original signature:<br>
	 * {@code getEOL(): string; }<br>
	 */
	public String getEOL() { return call("getEOL", ofMapped(String.class)); }

 	/**
	 * <p>Get a range covering the entire model</p>
	 * See {@code monaco.d.ts:1695:25}<br>
	 * Original signature:<br>
	 * {@code getFullModelRange(): Range; }<br>
	 */
	public Range getFullModelRange() { return call("getFullModelRange", Range::new); }

 	/**
	 * <p>Get the text for a certain line.</p>
	 * See {@code monaco.d.ts:1625:22}<br>
	 * Original signature:<br>
	 * {@code getLineContent(lineNumber: number): string; }<br>
	 */
	public String getLineContent(@Nonnull Double lineNumber) { return call("getLineContent", ofMapped(String.class), lineNumber); }

 	/**
	 * <p>Get the number of lines in the model.</p>
	 * See {@code monaco.d.ts:1621:20}<br>
	 * Original signature:<br>
	 * {@code getLineCount(): number; }<br>
	 */
	public double getLineCount() { return call("getLineCount", ofMapped(double.class)); }

 	/**
	 * <p>Gets all the decorations for the line <code>lineNumber</code> as an array.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:1792:26}<br>
	 * Original signature:<br>
	 * {@code getLineDecorations(lineNumber: number, ownerId?: number, filterOutValidation?: boolean): IModelDecoration[]; }<br>
	 */
	public List<IModelDecoration> getLineDecorations(@Nonnull Double lineNumber) { return call("getLineDecorations", ofArray(IModelDecoration::new), lineNumber); }

 	/**
	 * <p>Gets all the decorations for the line <code>lineNumber</code> as an array.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:1792:26}<br>
	 * Original signature:<br>
	 * {@code getLineDecorations(lineNumber: number, ownerId?: number, filterOutValidation?: boolean): IModelDecoration[]; }<br>
	 */
	public List<IModelDecoration> getLineDecorations(@Nonnull Double lineNumber, @Nonnull Double ownerId) { return call("getLineDecorations", ofArray(IModelDecoration::new), lineNumber, ownerId); }

 	/**
	 * <p>Gets all the decorations for the line <code>lineNumber</code> as an array.</p>
	 * See {@code monaco.d.ts:1792:26}<br>
	 * Original signature:<br>
	 * {@code getLineDecorations(lineNumber: number, ownerId?: number, filterOutValidation?: boolean): IModelDecoration[]; }<br>
	 * 
	 * @param lineNumber The line number
	 * @param ownerId If set, it will ignore decorations belonging to other owners.
	 * @param filterOutValidation If set, it will ignore decorations specific to validation (i.e. warnings, errors).
	 */
	public List<IModelDecoration> getLineDecorations(@Nonnull Double lineNumber, @Nonnull Double ownerId, @Nonnull Boolean filterOutValidation) { return call("getLineDecorations", ofArray(IModelDecoration::new), lineNumber, ownerId, filterOutValidation); }

 	/**
	 * <p>Returns the column before the first non whitespace character for line at <code>lineNumber</code>.
	 * Returns 0 if line is empty or contains only whitespace.</p>
	 * See {@code monaco.d.ts:1651:39}<br>
	 * Original signature:<br>
	 * {@code getLineFirstNonWhitespaceColumn(lineNumber: number): number; }<br>
	 */
	public double getLineFirstNonWhitespaceColumn(@Nonnull Double lineNumber) { return call("getLineFirstNonWhitespaceColumn", ofMapped(double.class), lineNumber); }

 	/**
	 * <p>Returns the column after the last non whitespace character for line at <code>lineNumber</code>.
	 * Returns 0 if line is empty or contains only whitespace.</p>
	 * See {@code monaco.d.ts:1656:38}<br>
	 * Original signature:<br>
	 * {@code getLineLastNonWhitespaceColumn(lineNumber: number): number; }<br>
	 */
	public double getLineLastNonWhitespaceColumn(@Nonnull Double lineNumber) { return call("getLineLastNonWhitespaceColumn", ofMapped(double.class), lineNumber); }

 	/**
	 * <p>Get the text length for a certain line.</p>
	 * See {@code monaco.d.ts:1629:21}<br>
	 * Original signature:<br>
	 * {@code getLineLength(lineNumber: number): number; }<br>
	 */
	public double getLineLength(@Nonnull Double lineNumber) { return call("getLineLength", ofMapped(double.class), lineNumber); }

 	/**
	 * <p>Get the maximum legal column for line at <code>lineNumber</code></p>
	 * See {@code monaco.d.ts:1646:24}<br>
	 * Original signature:<br>
	 * {@code getLineMaxColumn(lineNumber: number): number; }<br>
	 */
	public double getLineMaxColumn(@Nonnull Double lineNumber) { return call("getLineMaxColumn", ofMapped(double.class), lineNumber); }

 	/**
	 * <p>Get the minimum legal column for line at <code>lineNumber</code></p>
	 * See {@code monaco.d.ts:1642:24}<br>
	 * Original signature:<br>
	 * {@code getLineMinColumn(lineNumber: number): number; }<br>
	 */
	public double getLineMinColumn(@Nonnull Double lineNumber) { return call("getLineMinColumn", ofMapped(double.class), lineNumber); }

 	/**
	 * <p>Get the text for all lines.</p>
	 * See {@code monaco.d.ts:1633:23}<br>
	 * Original signature:<br>
	 * {@code getLinesContent(): string[]; }<br>
	 */
	public List<String> getLinesContent() { return call("getLinesContent", ofArray(ofMapped(String.class))); }

 	/**
	 * <p>Gets all the decorations for the lines between <code>startLineNumber</code> and <code>endLineNumber</code> as an array.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:1801:27}<br>
	 * Original signature:<br>
	 * {@code getLinesDecorations(startLineNumber: number, endLineNumber: number, ownerId?: number, filterOutValidation?: boolean): IModelDecoration[]; }<br>
	 */
	public List<IModelDecoration> getLinesDecorations(@Nonnull Double startLineNumber, @Nonnull Double endLineNumber, @Nonnull Double ownerId) { return call("getLinesDecorations", ofArray(IModelDecoration::new), startLineNumber, endLineNumber, ownerId); }

 	/**
	 * <p>Gets all the decorations for the lines between <code>startLineNumber</code> and <code>endLineNumber</code> as an array.</p>
	 * See {@code monaco.d.ts:1801:27}<br>
	 * Original signature:<br>
	 * {@code getLinesDecorations(startLineNumber: number, endLineNumber: number, ownerId?: number, filterOutValidation?: boolean): IModelDecoration[]; }<br>
	 * 
	 * @param startLineNumber The start line number
	 * @param endLineNumber The end line number
	 * @param ownerId If set, it will ignore decorations belonging to other owners.
	 * @param filterOutValidation If set, it will ignore decorations specific to validation (i.e. warnings, errors).
	 */
	public List<IModelDecoration> getLinesDecorations(@Nonnull Double startLineNumber, @Nonnull Double endLineNumber, @Nonnull Double ownerId, @Nonnull Boolean filterOutValidation) { return call("getLinesDecorations", ofArray(IModelDecoration::new), startLineNumber, endLineNumber, ownerId, filterOutValidation); }

 	/**
	 * <p>Gets all the decorations for the lines between <code>startLineNumber</code> and <code>endLineNumber</code> as an array.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:1801:27}<br>
	 * Original signature:<br>
	 * {@code getLinesDecorations(startLineNumber: number, endLineNumber: number, ownerId?: number, filterOutValidation?: boolean): IModelDecoration[]; }<br>
	 */
	public List<IModelDecoration> getLinesDecorations(@Nonnull Double startLineNumber, @Nonnull Double endLineNumber) { return call("getLinesDecorations", ofArray(IModelDecoration::new), startLineNumber, endLineNumber); }

 	/**
	 * <p>Get the language associated with this model.</p>
	 * See {@code monaco.d.ts:1749:17}<br>
	 * Original signature:<br>
	 * {@code getModeId(): string; }<br>
	 */
	public String getModeId() { return call("getModeId", ofMapped(String.class)); }

 	/**
	 * <p>Converts the position to a zero-based offset.
	 * The position will be <a href="#TextDocument.validatePosition">adjusted</a>.</p>
	 * See {@code monaco.d.ts:1684:19}<br>
	 * Original signature:<br>
	 * {@code getOffsetAt(position: IPosition): number; }<br>
	 * 
	 * @param position A position.
	 */
	public double getOffsetAt(@Nonnull IPosition position) { return call("getOffsetAt", ofMapped(double.class), position); }

 	/**
	 * <p>Get the resolved options for this model.</p>
	 * See {@code monaco.d.ts:1572:18}<br>
	 * Original signature:<br>
	 * {@code getOptions(): TextModelResolvedOptions; }<br>
	 */
	public TextModelResolvedOptions getOptions() { return call("getOptions", TextModelResolvedOptions::new); }

 	/**
	 * <p>Gets all the decorations that should be rendered in the overview ruler as an array.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:1822:35}<br>
	 * Original signature:<br>
	 * {@code getOverviewRulerDecorations(ownerId?: number, filterOutValidation?: boolean): IModelDecoration[]; }<br>
	 */
	public List<IModelDecoration> getOverviewRulerDecorations(@Nonnull Double ownerId) { return call("getOverviewRulerDecorations", ofArray(IModelDecoration::new), ownerId); }

 	/**
	 * <p>Gets all the decorations that should be rendered in the overview ruler as an array.</p>
	 * See {@code monaco.d.ts:1822:35}<br>
	 * Original signature:<br>
	 * {@code getOverviewRulerDecorations(ownerId?: number, filterOutValidation?: boolean): IModelDecoration[]; }<br>
	 * 
	 * @param ownerId If set, it will ignore decorations belonging to other owners.
	 * @param filterOutValidation If set, it will ignore decorations specific to validation (i.e. warnings, errors).
	 */
	public List<IModelDecoration> getOverviewRulerDecorations(@Nonnull Double ownerId, @Nonnull Boolean filterOutValidation) { return call("getOverviewRulerDecorations", ofArray(IModelDecoration::new), ownerId, filterOutValidation); }

 	/**
	 * <p>Gets all the decorations that should be rendered in the overview ruler as an array.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:1822:35}<br>
	 * Original signature:<br>
	 * {@code getOverviewRulerDecorations(ownerId?: number, filterOutValidation?: boolean): IModelDecoration[]; }<br>
	 */
	public List<IModelDecoration> getOverviewRulerDecorations() { return call("getOverviewRulerDecorations", ofArray(IModelDecoration::new)); }

 	/**
	 * <p>Converts a zero-based offset to a position.</p>
	 * See {@code monaco.d.ts:1691:21}<br>
	 * Original signature:<br>
	 * {@code getPositionAt(offset: number): Position; }<br>
	 * 
	 * @param offset A zero-based offset.
	 */
	public Position getPositionAt(@Nonnull Double offset) { return call("getPositionAt", Position::new, offset); }

 	/**
	 * <p>Get the text stored in this model.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:1595:16}<br>
	 * Original signature:<br>
	 * {@code getValue(eol?: EndOfLinePreference, preserveBOM?: boolean): string; }<br>
	 */
	public String getValue(@Nonnull EndOfLinePreference eol) { return call("getValue", ofMapped(String.class), eol); }

 	/**
	 * <p>Get the text stored in this model.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:1595:16}<br>
	 * Original signature:<br>
	 * {@code getValue(eol?: EndOfLinePreference, preserveBOM?: boolean): string; }<br>
	 */
	public String getValue() { return call("getValue", ofMapped(String.class)); }

 	/**
	 * <p>Get the text stored in this model.</p>
	 * See {@code monaco.d.ts:1595:16}<br>
	 * Original signature:<br>
	 * {@code getValue(eol?: EndOfLinePreference, preserveBOM?: boolean): string; }<br>
	 * 
	 * @param eol The end of line character preference. Defaults to <code>EndOfLinePreference.TextDefined</code>.
	 */
	public String getValue(@Nonnull EndOfLinePreference eol, @Nonnull Boolean preserveBOM) { return call("getValue", ofMapped(String.class), eol, preserveBOM); }

 	/**
	 * <p>Get the text in a certain range.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:1606:23}<br>
	 * Original signature:<br>
	 * {@code getValueInRange(range: IRange, eol?: EndOfLinePreference): string; }<br>
	 */
	public String getValueInRange(@Nonnull IRange range) { return call("getValueInRange", ofMapped(String.class), range); }

 	/**
	 * <p>Get the text in a certain range.</p>
	 * See {@code monaco.d.ts:1606:23}<br>
	 * Original signature:<br>
	 * {@code getValueInRange(range: IRange, eol?: EndOfLinePreference): string; }<br>
	 * 
	 * @param range The range describing what text to get.
	 * @param eol The end of line character preference. This will only be used for multiline ranges. Defaults to <code>EndOfLinePreference.TextDefined</code>.
	 */
	public String getValueInRange(@Nonnull IRange range, @Nonnull EndOfLinePreference eol) { return call("getValueInRange", ofMapped(String.class), range, eol); }

 	/**
	 * <p>Get the length of the text stored in this model.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:1599:22}<br>
	 * Original signature:<br>
	 * {@code getValueLength(eol?: EndOfLinePreference, preserveBOM?: boolean): number; }<br>
	 */
	public double getValueLength(@Nonnull EndOfLinePreference eol) { return call("getValueLength", ofMapped(double.class), eol); }

 	/**
	 * <p>Get the length of the text stored in this model.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:1599:22}<br>
	 * Original signature:<br>
	 * {@code getValueLength(eol?: EndOfLinePreference, preserveBOM?: boolean): number; }<br>
	 */
	public double getValueLength() { return call("getValueLength", ofMapped(double.class)); }

 	/**
	 * <p>Get the length of the text stored in this model.</p>
	 * See {@code monaco.d.ts:1599:22}<br>
	 * Original signature:<br>
	 * {@code getValueLength(eol?: EndOfLinePreference, preserveBOM?: boolean): number; }<br>
	 */
	public double getValueLength(@Nonnull EndOfLinePreference eol, @Nonnull Boolean preserveBOM) { return call("getValueLength", ofMapped(double.class), eol, preserveBOM); }

 	/**
	 * <p>Get the length of text in a certain range.</p>
	 * See {@code monaco.d.ts:1612:29}<br>
	 * Original signature:<br>
	 * {@code getValueLengthInRange(range: IRange): number; }<br>
	 * 
	 * @param range The range describing what text length to get.
	 */
	public double getValueLengthInRange(@Nonnull IRange range) { return call("getValueLengthInRange", ofMapped(double.class), range); }

 	/**
	 * <p>Get the current version id of the model.
	 * Anytime a change happens to the model (even undo/redo),
	 * the version id is incremented.</p>
	 * See {@code monaco.d.ts:1578:20}<br>
	 * Original signature:<br>
	 * {@code getVersionId(): number; }<br>
	 */
	public double getVersionId() { return call("getVersionId", ofMapped(double.class)); }

 	/**
	 * <p>Get the word under or besides <code>position</code>.</p>
	 * See {@code monaco.d.ts:1755:25}<br>
	 * Original signature:<br>
	 * {@code getWordAtPosition(position: IPosition): IWordAtPosition | null; }<br>
	 * 
	 * @param position The position to look for a word.
	 */
	public Optional<IWordAtPosition> getWordAtPosition(@Nonnull IPosition position) { return Optional.ofNullable(call("getWordAtPosition", IWordAtPosition::new, position)); }

 	/**
	 * <p>Get the word under or besides <code>position</code> trimmed to <code>position</code>.column</p>
	 * See {@code monaco.d.ts:1761:28}<br>
	 * Original signature:<br>
	 * {@code getWordUntilPosition(position: IPosition): IWordAtPosition; }<br>
	 * 
	 * @param position The position to look for a word.
	 */
	public IWordAtPosition getWordUntilPosition(@Nonnull IPosition position) { return call("getWordUntilPosition", IWordAtPosition::new, position); }

 	/**
	 * <p>Returns if the model was disposed or not.</p>
	 * See {@code monaco.d.ts:1699:18}<br>
	 * Original signature:<br>
	 * {@code isDisposed(): boolean; }<br>
	 */
	public boolean isDisposed() { return call("isDisposed", ofMapped(boolean.class)); }

 	/**
	 * <p>Advances the given position by the given offset (negative offsets are also accepted)
	 * and returns it as a new valid position.
	 * If the offset and position are such that their combination goes beyond the beginning or
	 * end of the model, throws an exception.</p>
	 * <p>If the offset is such that the new position would be in the middle of a multi-byte
	 * line terminator, throws an exception.</p>
	 * See {@code monaco.d.ts:1671:22}<br>
	 * Original signature:<br>
	 * {@code modifyPosition(position: IPosition, offset: number): Position; }<br>
	 */
	public Position modifyPosition(@Nonnull IPosition position, @Nonnull Double offset) { return call("modifyPosition", Position::new, position, offset); }

 	/**
	 * <p>Normalize a string containing whitespace according to indentation rules (converts to spaces or to tabs).</p>
	 * See {@code monaco.d.ts:1826:28}<br>
	 * Original signature:<br>
	 * {@code normalizeIndentation(str: string): string; }<br>
	 */
	public String normalizeIndentation(@Nonnull String str) { return call("normalizeIndentation", ofMapped(String.class), str); }

 	/**
	 * <p>Change the end of line sequence. This is the preferred way of
	 * changing the eol sequence. This will land on the undo stack.</p>
	 * See {@code monaco.d.ts:1854:15}<br>
	 * Original signature:<br>
	 * {@code pushEOL(eol: EndOfLineSequence): void; }<br>
	 */
	public void pushEOL(@Nonnull EndOfLineSequence eol) { call("pushEOL", ofVoid(), eol); }

 	/**
	 * <p>Push edit operations, basically editing the model. This is the preferred way
	 * of editing the model. The edit operations will land on the undo stack.</p>
	 * See {@code monaco.d.ts:1849:26}<br>
	 * Original signature:<br>
	 * {@code pushEditOperations(beforeCursorState: Selection[], editOperations: IIdentifiedSingleEditOperation[], cursorStateComputer: ICursorStateComputer): Selection[] | null; }<br>
	 * 
	 * @param beforeCursorState The cursor state before the edit operations. This cursor state will be returned when <code>undo</code> or <code>redo</code> are invoked.
	 * @param editOperations The edit operations.
	 * @param cursorStateComputer A callback that can compute the resulting cursors state after the edit operations have been executed.
	 */
	public Optional<List<Selection>> pushEditOperations(@Nonnull List<Selection> beforeCursorState, @Nonnull List<IIdentifiedSingleEditOperation> editOperations, @Nonnull ICursorStateComputer cursorStateComputer) { return Optional.ofNullable(call("pushEditOperations", ofArray(Selection::new), beforeCursorState, editOperations, cursorStateComputer)); }

 	/**
	 * <p>Push a stack element onto the undo stack. This acts as an undo/redo point.
	 * The idea is to use <code>pushEditOperations</code> to edit the model and then to
	 * <code>pushStackElement</code> to create an undo/redo stop point.</p>
	 * See {@code monaco.d.ts:1840:24}<br>
	 * Original signature:<br>
	 * {@code pushStackElement(): void; }<br>
	 */
	public void pushStackElement() { call("pushStackElement", ofVoid()); }

 	/**
	 * <p>Change the end of line sequence without recording in the undo stack.
	 * This can have dire consequences on the undo stack! See @pushEOL for the preferred way.</p>
	 * See {@code monaco.d.ts:1866:14}<br>
	 * Original signature:<br>
	 * {@code setEOL(eol: EndOfLineSequence): void; }<br>
	 */
	public void setEOL(@Nonnull EndOfLineSequence eol) { call("setEOL", ofVoid(), eol); }

 	/**
	 * <p>Replace the entire text buffer value contained in this model.</p>
	 * See {@code monaco.d.ts:1588:16}<br>
	 * Original signature:<br>
	 * {@code setValue(newValue: string): void; }<br>
	 */
	public void setValue(@Nonnull String newValue) { call("setValue", ofVoid(), newValue); }

 	/**
	 * <p>Change the options of this model.</p>
	 * See {@code monaco.d.ts:1830:21}<br>
	 * Original signature:<br>
	 * {@code updateOptions(newOpts: ITextModelUpdateOptions): void; }<br>
	 */
	public void updateOptions(@Nonnull ITextModelUpdateOptions newOpts) { call("updateOptions", ofVoid(), newOpts); }

 	/**
	 * <p>Create a valid position,</p>
	 * See {@code monaco.d.ts:1660:24}<br>
	 * Original signature:<br>
	 * {@code validatePosition(position: IPosition): Position; }<br>
	 */
	public Position validatePosition(@Nonnull IPosition position) { return call("validatePosition", Position::new, position); }

 	/**
	 * <p>Create a valid range.</p>
	 * See {@code monaco.d.ts:1675:21}<br>
	 * Original signature:<br>
	 * {@code validateRange(range: IRange): Range; }<br>
	 */
	public Range validateRange(@Nonnull IRange range) { return call("validateRange", Range::new, range); }

 
}
