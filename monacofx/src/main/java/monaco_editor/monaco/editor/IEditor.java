
package monaco_editor.monaco.editor;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import monaco_editor.monaco.IPosition;
import monaco_editor.monaco.IRange;
import monaco_editor.monaco.ISelection;
import monaco_editor.monaco.Position;
import monaco_editor.monaco.Range;
import monaco_editor.monaco.Selection;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import net.kurobako.monacofx.js.JsUnion2;
import netscape.javascript.JSObject;

/**
 * <p>An editor.</p>
 * See {@code monaco.d.ts:2104:28}<br>
 * Original signature:<br>
 * {@code export interface IEditor  }<br>
 */
@SuppressWarnings("unused")
public class IEditor extends JsProxy {

	public IEditor(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IEditor(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Dispose the editor.</p>
	 * See {@code monaco.d.ts:2113:15}<br>
	 * Original signature:<br>
	 * {@code dispose(): void; }<br>
	 */
	public void dispose() { call("dispose", ofVoid()); }

 	/**
	 * <p>Brings browser focus to the editor text</p>
	 * See {@code monaco.d.ts:2137:13}<br>
	 * Original signature:<br>
	 * {@code focus(): void; }<br>
	 */
	public void focus() { call("focus", ofVoid()); }

 	/**
	 * <p>Get the editor type. Please see <code>EditorType</code>.
	 * This is to avoid an instanceof check</p>
	 * See {@code monaco.d.ts:2122:21}<br>
	 * Original signature:<br>
	 * {@code getEditorType(): string; }<br>
	 */
	public String getEditorType() { return call("getEditorType", ofMapped(String.class)); }

 	/**
	 * <p>Get a unique id for this editor instance.</p>
	 * See {@code monaco.d.ts:2117:13}<br>
	 * Original signature:<br>
	 * {@code getId(): string; }<br>
	 */
	public String getId() { return call("getId", ofMapped(String.class)); }

 	/**
	 * <p>Gets the current model attached to this editor.</p>
	 * See {@code monaco.d.ts:2262:16}<br>
	 * Original signature:<br>
	 * {@code getModel(): IEditorModel | null; }<br>
	 */
	public Optional<JsUnion2<ITextModel, IDiffEditorModel>> getModel() { return Optional.ofNullable(call("getModel", null /*union*/)); }

 	/**
	 * <p>Returns the primary position of the cursor.</p>
	 * See {@code monaco.d.ts:2161:19}<br>
	 * Original signature:<br>
	 * {@code getPosition(): Position | null; }<br>
	 */
	public Optional<Position> getPosition() { return Optional.ofNullable(call("getPosition", Position::new)); }

 	/**
	 * <p>Returns the primary selection of the editor.</p>
	 * See {@code monaco.d.ts:2194:20}<br>
	 * Original signature:<br>
	 * {@code getSelection(): Selection | null; }<br>
	 */
	public Optional<Selection> getSelection() { return Optional.ofNullable(call("getSelection", Selection::new)); }

 	/**
	 * <p>Returns all the selections of the editor.</p>
	 * See {@code monaco.d.ts:2198:21}<br>
	 * Original signature:<br>
	 * {@code getSelections(): Selection[] | null; }<br>
	 */
	public Optional<List<Selection>> getSelections() { return Optional.ofNullable(call("getSelections", ofArray(Selection::new))); }

 	/**
	 * <p>Returns all actions associated with this editor.</p>
	 * See {@code monaco.d.ts:2145:27}<br>
	 * Original signature:<br>
	 * {@code getSupportedActions(): IEditorAction[]; }<br>
	 */
	public List<IEditorAction> getSupportedActions() { return call("getSupportedActions", ofArray(IEditorAction::new)); }

 	/**
	 * <p>Given a position, returns a column number that takes tab-widths into account.</p>
	 * See {@code monaco.d.ts:2157:36}<br>
	 * Original signature:<br>
	 * {@code getVisibleColumnFromPosition(position: IPosition): number; }<br>
	 */
	public double getVisibleColumnFromPosition(@Nonnull IPosition position) { return call("getVisibleColumnFromPosition", ofMapped(double.class), position); }

 	/**
	 * <p>Returns true if the text inside this editor is focused (i.e. cursor is blinking).</p>
	 * See {@code monaco.d.ts:2141:20}<br>
	 * Original signature:<br>
	 * {@code hasTextFocus(): boolean; }<br>
	 */
	public boolean hasTextFocus() { return call("hasTextFocus", ofMapped(boolean.class)); }

 	/**
	 * <p>Instructs the editor to remeasure its container. This method should
	 * be called when the container of the editor gets resized.
	 * If a dimension is passed in, the passed in value will be used.</p>
	 * See {@code monaco.d.ts:2133:14}<br>
	 * Original signature:<br>
	 * {@code layout(dimension?: IDimension): void; }<br>
	 */
	public void layout(@Nonnull IDimension dimension) { call("layout", ofVoid(), dimension); }

 	/**
	 * <p>Instructs the editor to remeasure its container. This method should
	 * be called when the container of the editor gets resized.
	 * If a dimension is passed in, the passed in value will be used.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:2133:14}<br>
	 * Original signature:<br>
	 * {@code layout(dimension?: IDimension): void; }<br>
	 */
	public void layout() { call("layout", ofVoid()); }

 	/**
	 * <p>Restores the view state of the editor from a serializable object generated by <code>saveViewState</code>.</p>
	 * See {@code monaco.d.ts:2153:24}<br>
	 * Original signature:<br>
	 * {@code restoreViewState(state: IEditorViewState): void; }<br>
	 */
	public void restoreViewState(@Nonnull ICodeEditorViewState state) { call("restoreViewState", ofVoid(), state); }

 	/**
	 * <p>Restores the view state of the editor from a serializable object generated by <code>saveViewState</code>.</p>
	 * See {@code monaco.d.ts:2153:24}<br>
	 * Original signature:<br>
	 * {@code restoreViewState(state: IEditorViewState): void; }<br>
	 */
	public void restoreViewState(@Nonnull IDiffEditorViewState state) { call("restoreViewState", ofVoid(), state); }

 	/**
	 * <p>Scroll vertically as necessary and reveal a line.</p>
	 * See {@code monaco.d.ts:2170:18}<br>
	 * Original signature:<br>
	 * {@code revealLine(lineNumber: number, scrollType?: ScrollType): void; }<br>
	 */
	public void revealLine(@Nonnull Double lineNumber, @Nonnull ScrollType scrollType) { call("revealLine", ofVoid(), lineNumber, scrollType); }

 	/**
	 * <p>Scroll vertically as necessary and reveal a line.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:2170:18}<br>
	 * Original signature:<br>
	 * {@code revealLine(lineNumber: number, scrollType?: ScrollType): void; }<br>
	 */
	public void revealLine(@Nonnull Double lineNumber) { call("revealLine", ofVoid(), lineNumber); }

 	/**
	 * <p>Scroll vertically as necessary and reveal a line centered vertically.</p>
	 * See {@code monaco.d.ts:2174:26}<br>
	 * Original signature:<br>
	 * {@code revealLineInCenter(lineNumber: number, scrollType?: ScrollType): void; }<br>
	 */
	public void revealLineInCenter(@Nonnull Double lineNumber, @Nonnull ScrollType scrollType) { call("revealLineInCenter", ofVoid(), lineNumber, scrollType); }

 	/**
	 * <p>Scroll vertically as necessary and reveal a line centered vertically.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:2174:26}<br>
	 * Original signature:<br>
	 * {@code revealLineInCenter(lineNumber: number, scrollType?: ScrollType): void; }<br>
	 */
	public void revealLineInCenter(@Nonnull Double lineNumber) { call("revealLineInCenter", ofVoid(), lineNumber); }

 	/**
	 * <p>Scroll vertically as necessary and reveal a line centered vertically only if it lies outside the viewport.</p>
	 * See {@code monaco.d.ts:2178:43}<br>
	 * Original signature:<br>
	 * {@code revealLineInCenterIfOutsideViewport(lineNumber: number, scrollType?: ScrollType): void; }<br>
	 */
	public void revealLineInCenterIfOutsideViewport(@Nonnull Double lineNumber, @Nonnull ScrollType scrollType) { call("revealLineInCenterIfOutsideViewport", ofVoid(), lineNumber, scrollType); }

 	/**
	 * <p>Scroll vertically as necessary and reveal a line centered vertically only if it lies outside the viewport.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:2178:43}<br>
	 * Original signature:<br>
	 * {@code revealLineInCenterIfOutsideViewport(lineNumber: number, scrollType?: ScrollType): void; }<br>
	 */
	public void revealLineInCenterIfOutsideViewport(@Nonnull Double lineNumber) { call("revealLineInCenterIfOutsideViewport", ofVoid(), lineNumber); }

 	/**
	 * <p>Scroll vertically as necessary and reveal lines.</p>
	 * See {@code monaco.d.ts:2227:19}<br>
	 * Original signature:<br>
	 * {@code revealLines(startLineNumber: number, endLineNumber: number, scrollType?: ScrollType): void; }<br>
	 */
	public void revealLines(@Nonnull Double startLineNumber, @Nonnull Double endLineNumber, @Nonnull ScrollType scrollType) { call("revealLines", ofVoid(), startLineNumber, endLineNumber, scrollType); }

 	/**
	 * <p>Scroll vertically as necessary and reveal lines.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:2227:19}<br>
	 * Original signature:<br>
	 * {@code revealLines(startLineNumber: number, endLineNumber: number, scrollType?: ScrollType): void; }<br>
	 */
	public void revealLines(@Nonnull Double startLineNumber, @Nonnull Double endLineNumber) { call("revealLines", ofVoid(), startLineNumber, endLineNumber); }

 	/**
	 * <p>Scroll vertically as necessary and reveal lines centered vertically.</p>
	 * See {@code monaco.d.ts:2231:27}<br>
	 * Original signature:<br>
	 * {@code revealLinesInCenter(lineNumber: number, endLineNumber: number, scrollType?: ScrollType): void; }<br>
	 */
	public void revealLinesInCenter(@Nonnull Double lineNumber, @Nonnull Double endLineNumber, @Nonnull ScrollType scrollType) { call("revealLinesInCenter", ofVoid(), lineNumber, endLineNumber, scrollType); }

 	/**
	 * <p>Scroll vertically as necessary and reveal lines centered vertically.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:2231:27}<br>
	 * Original signature:<br>
	 * {@code revealLinesInCenter(lineNumber: number, endLineNumber: number, scrollType?: ScrollType): void; }<br>
	 */
	public void revealLinesInCenter(@Nonnull Double lineNumber, @Nonnull Double endLineNumber) { call("revealLinesInCenter", ofVoid(), lineNumber, endLineNumber); }

 	/**
	 * <p>Scroll vertically as necessary and reveal lines centered vertically only if it lies outside the viewport.</p>
	 * See {@code monaco.d.ts:2235:44}<br>
	 * Original signature:<br>
	 * {@code revealLinesInCenterIfOutsideViewport(lineNumber: number, endLineNumber: number, scrollType?: ScrollType): void; }<br>
	 */
	public void revealLinesInCenterIfOutsideViewport(@Nonnull Double lineNumber, @Nonnull Double endLineNumber, @Nonnull ScrollType scrollType) { call("revealLinesInCenterIfOutsideViewport", ofVoid(), lineNumber, endLineNumber, scrollType); }

 	/**
	 * <p>Scroll vertically as necessary and reveal lines centered vertically only if it lies outside the viewport.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:2235:44}<br>
	 * Original signature:<br>
	 * {@code revealLinesInCenterIfOutsideViewport(lineNumber: number, endLineNumber: number, scrollType?: ScrollType): void; }<br>
	 */
	public void revealLinesInCenterIfOutsideViewport(@Nonnull Double lineNumber, @Nonnull Double endLineNumber) { call("revealLinesInCenterIfOutsideViewport", ofVoid(), lineNumber, endLineNumber); }

 	/**
	 * <p>Scroll vertically or horizontally as necessary and reveal a position.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:2182:22}<br>
	 * Original signature:<br>
	 * {@code revealPosition(position: IPosition, scrollType?: ScrollType): void; }<br>
	 */
	public void revealPosition(@Nonnull IPosition position) { call("revealPosition", ofVoid(), position); }

 	/**
	 * <p>Scroll vertically or horizontally as necessary and reveal a position.</p>
	 * See {@code monaco.d.ts:2182:22}<br>
	 * Original signature:<br>
	 * {@code revealPosition(position: IPosition, scrollType?: ScrollType): void; }<br>
	 */
	public void revealPosition(@Nonnull IPosition position, @Nonnull ScrollType scrollType) { call("revealPosition", ofVoid(), position, scrollType); }

 	/**
	 * <p>Scroll vertically or horizontally as necessary and reveal a position centered vertically.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:2186:30}<br>
	 * Original signature:<br>
	 * {@code revealPositionInCenter(position: IPosition, scrollType?: ScrollType): void; }<br>
	 */
	public void revealPositionInCenter(@Nonnull IPosition position) { call("revealPositionInCenter", ofVoid(), position); }

 	/**
	 * <p>Scroll vertically or horizontally as necessary and reveal a position centered vertically.</p>
	 * See {@code monaco.d.ts:2186:30}<br>
	 * Original signature:<br>
	 * {@code revealPositionInCenter(position: IPosition, scrollType?: ScrollType): void; }<br>
	 */
	public void revealPositionInCenter(@Nonnull IPosition position, @Nonnull ScrollType scrollType) { call("revealPositionInCenter", ofVoid(), position, scrollType); }

 	/**
	 * <p>Scroll vertically or horizontally as necessary and reveal a position centered vertically only if it lies outside the viewport.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:2190:47}<br>
	 * Original signature:<br>
	 * {@code revealPositionInCenterIfOutsideViewport(position: IPosition, scrollType?: ScrollType): void; }<br>
	 */
	public void revealPositionInCenterIfOutsideViewport(@Nonnull IPosition position) { call("revealPositionInCenterIfOutsideViewport", ofVoid(), position); }

 	/**
	 * <p>Scroll vertically or horizontally as necessary and reveal a position centered vertically only if it lies outside the viewport.</p>
	 * See {@code monaco.d.ts:2190:47}<br>
	 * Original signature:<br>
	 * {@code revealPositionInCenterIfOutsideViewport(position: IPosition, scrollType?: ScrollType): void; }<br>
	 */
	public void revealPositionInCenterIfOutsideViewport(@Nonnull IPosition position, @Nonnull ScrollType scrollType) { call("revealPositionInCenterIfOutsideViewport", ofVoid(), position, scrollType); }

 	/**
	 * <p>Scroll vertically or horizontally as necessary and reveal a range.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:2239:19}<br>
	 * Original signature:<br>
	 * {@code revealRange(range: IRange, scrollType?: ScrollType): void; }<br>
	 */
	public void revealRange(@Nonnull IRange range) { call("revealRange", ofVoid(), range); }

 	/**
	 * <p>Scroll vertically or horizontally as necessary and reveal a range.</p>
	 * See {@code monaco.d.ts:2239:19}<br>
	 * Original signature:<br>
	 * {@code revealRange(range: IRange, scrollType?: ScrollType): void; }<br>
	 */
	public void revealRange(@Nonnull IRange range, @Nonnull ScrollType scrollType) { call("revealRange", ofVoid(), range, scrollType); }

 	/**
	 * <p>Scroll vertically or horizontally as necessary and reveal a range at the top of the viewport.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:2247:24}<br>
	 * Original signature:<br>
	 * {@code revealRangeAtTop(range: IRange, scrollType?: ScrollType): void; }<br>
	 */
	public void revealRangeAtTop(@Nonnull IRange range) { call("revealRangeAtTop", ofVoid(), range); }

 	/**
	 * <p>Scroll vertically or horizontally as necessary and reveal a range at the top of the viewport.</p>
	 * See {@code monaco.d.ts:2247:24}<br>
	 * Original signature:<br>
	 * {@code revealRangeAtTop(range: IRange, scrollType?: ScrollType): void; }<br>
	 */
	public void revealRangeAtTop(@Nonnull IRange range, @Nonnull ScrollType scrollType) { call("revealRangeAtTop", ofVoid(), range, scrollType); }

 	/**
	 * <p>Scroll vertically or horizontally as necessary and reveal a range centered vertically.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:2243:27}<br>
	 * Original signature:<br>
	 * {@code revealRangeInCenter(range: IRange, scrollType?: ScrollType): void; }<br>
	 */
	public void revealRangeInCenter(@Nonnull IRange range) { call("revealRangeInCenter", ofVoid(), range); }

 	/**
	 * <p>Scroll vertically or horizontally as necessary and reveal a range centered vertically.</p>
	 * See {@code monaco.d.ts:2243:27}<br>
	 * Original signature:<br>
	 * {@code revealRangeInCenter(range: IRange, scrollType?: ScrollType): void; }<br>
	 */
	public void revealRangeInCenter(@Nonnull IRange range, @Nonnull ScrollType scrollType) { call("revealRangeInCenter", ofVoid(), range, scrollType); }

 	/**
	 * <p>Scroll vertically or horizontally as necessary and reveal a range centered vertically only if it lies outside the viewport.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:2251:44}<br>
	 * Original signature:<br>
	 * {@code revealRangeInCenterIfOutsideViewport(range: IRange, scrollType?: ScrollType): void; }<br>
	 */
	public void revealRangeInCenterIfOutsideViewport(@Nonnull IRange range) { call("revealRangeInCenterIfOutsideViewport", ofVoid(), range); }

 	/**
	 * <p>Scroll vertically or horizontally as necessary and reveal a range centered vertically only if it lies outside the viewport.</p>
	 * See {@code monaco.d.ts:2251:44}<br>
	 * Original signature:<br>
	 * {@code revealRangeInCenterIfOutsideViewport(range: IRange, scrollType?: ScrollType): void; }<br>
	 */
	public void revealRangeInCenterIfOutsideViewport(@Nonnull IRange range, @Nonnull ScrollType scrollType) { call("revealRangeInCenterIfOutsideViewport", ofVoid(), range, scrollType); }

 	/**
	 * <p>Saves current view state of the editor in a serializable object.</p>
	 * See {@code monaco.d.ts:2149:21}<br>
	 * Original signature:<br>
	 * {@code saveViewState(): IEditorViewState | null; }<br>
	 */
	public Optional<JsUnion2<ICodeEditorViewState, IDiffEditorViewState>> saveViewState() { return Optional.ofNullable(call("saveViewState", null /*union*/)); }

 	/**
	 * <p>Sets the current model attached to this editor.
	 * If the previous model was created by the editor via the value key in the options
	 * literal object, it will be destroyed. Otherwise, if the previous model was set
	 * via setModel, or the model key in the options literal object, the previous model
	 * will not be destroyed.
	 * It is safe to call setModel(null) to simply detach the current model from the editor.</p>
	 * See {@code monaco.d.ts:2271:16}<br>
	 * Original signature:<br>
	 * {@code setModel(model: IEditorModel | null): void; }<br>
	 */
	public void setModel(@Nullable ITextModel model) { call("setModel", ofVoid(), model); }

 	/**
	 * <p>Sets the current model attached to this editor.
	 * If the previous model was created by the editor via the value key in the options
	 * literal object, it will be destroyed. Otherwise, if the previous model was set
	 * via setModel, or the model key in the options literal object, the previous model
	 * will not be destroyed.
	 * It is safe to call setModel(null) to simply detach the current model from the editor.</p>
	 * See {@code monaco.d.ts:2271:16}<br>
	 * Original signature:<br>
	 * {@code setModel(model: IEditorModel | null): void; }<br>
	 */
	public void setModel(@Nullable IDiffEditorModel model) { call("setModel", ofVoid(), model); }

 	/**
	 * <p>Set the primary position of the cursor. This will remove any secondary cursors.</p>
	 * See {@code monaco.d.ts:2166:19}<br>
	 * Original signature:<br>
	 * {@code setPosition(position: IPosition): void; }<br>
	 * 
	 * @param position New primary cursor's position
	 */
	public void setPosition(@Nonnull IPosition position) { call("setPosition", ofVoid(), position); }

 	/**
	 * <p>Set the primary selection of the editor. This will remove any secondary cursors.</p>
	 * See {@code monaco.d.ts:2203:20}<br>
	 * See {@code monaco.d.ts:2208:20}<br>
	 * See {@code monaco.d.ts:2213:20}<br>
	 * See {@code monaco.d.ts:2218:20}<br>
	 * Original signature:<br>
	 * {@code setSelection(selection: IRange): void; }<br>
	 * {@code setSelection(selection: Range): void; }<br>
	 * {@code setSelection(selection: ISelection): void; }<br>
	 * {@code setSelection(selection: Selection): void; }<br>
	 * 
	 * @param selection The new selection
	 */
	public void setSelection(@Nonnull IRange selection) { call("setSelection", ofVoid(), selection); }

 	/**
	 * <p>Set the primary selection of the editor. This will remove any secondary cursors.</p>
	 * See {@code monaco.d.ts:2203:20}<br>
	 * See {@code monaco.d.ts:2208:20}<br>
	 * See {@code monaco.d.ts:2213:20}<br>
	 * See {@code monaco.d.ts:2218:20}<br>
	 * Original signature:<br>
	 * {@code setSelection(selection: IRange): void; }<br>
	 * {@code setSelection(selection: Range): void; }<br>
	 * {@code setSelection(selection: ISelection): void; }<br>
	 * {@code setSelection(selection: Selection): void; }<br>
	 * 
	 * @param selection The new selection
	 */
	public void setSelection(@Nonnull ISelection selection) { call("setSelection", ofVoid(), selection); }

 	/**
	 * <p>Set the primary selection of the editor. This will remove any secondary cursors.</p>
	 * See {@code monaco.d.ts:2203:20}<br>
	 * See {@code monaco.d.ts:2208:20}<br>
	 * See {@code monaco.d.ts:2213:20}<br>
	 * See {@code monaco.d.ts:2218:20}<br>
	 * Original signature:<br>
	 * {@code setSelection(selection: IRange): void; }<br>
	 * {@code setSelection(selection: Range): void; }<br>
	 * {@code setSelection(selection: ISelection): void; }<br>
	 * {@code setSelection(selection: Selection): void; }<br>
	 * 
	 * @param selection The new selection
	 */
	public void setSelection(@Nonnull Selection selection) { call("setSelection", ofVoid(), selection); }

 	/**
	 * <p>Set the primary selection of the editor. This will remove any secondary cursors.</p>
	 * See {@code monaco.d.ts:2203:20}<br>
	 * See {@code monaco.d.ts:2208:20}<br>
	 * See {@code monaco.d.ts:2213:20}<br>
	 * See {@code monaco.d.ts:2218:20}<br>
	 * Original signature:<br>
	 * {@code setSelection(selection: IRange): void; }<br>
	 * {@code setSelection(selection: Range): void; }<br>
	 * {@code setSelection(selection: ISelection): void; }<br>
	 * {@code setSelection(selection: Selection): void; }<br>
	 * 
	 * @param selection The new selection
	 */
	public void setSelection(@Nonnull Range selection) { call("setSelection", ofVoid(), selection); }

 	/**
	 * <p>Set the selections for all the cursors of the editor.
	 * Cursors will be removed or added, as necessary.</p>
	 * See {@code monaco.d.ts:2223:21}<br>
	 * Original signature:<br>
	 * {@code setSelections(selections: readonly ISelection[]): void; }<br>
	 */
	public void setSelections(@Nonnull JSObject selections) { call("setSelections", ofVoid(), selections); }

 	/**
	 * <p>Directly trigger a handler or an editor action.</p>
	 * See {@code monaco.d.ts:2258:15}<br>
	 * Original signature:<br>
	 * {@code trigger(source: string, handlerId: string, payload: any): void; }<br>
	 * 
	 * @param source The source of the call.
	 * @param handlerId The id of the handler or the id of a contribution.
	 * @param payload Extra data to be sent to the handler.
	 */
	public void trigger(@Nonnull String source, @Nonnull String handlerId, @Nonnull JSObject payload) { call("trigger", ofVoid(), source, handlerId, payload); }

 	/**
	 * <p>Update the editor's options after the editor has been created.</p>
	 * See {@code monaco.d.ts:2126:21}<br>
	 * Original signature:<br>
	 * {@code updateOptions(newOptions: IEditorOptions): void; }<br>
	 */
	public void updateOptions(@Nonnull IEditorOptions newOptions) { call("updateOptions", ofVoid(), newOptions); }

 
}
