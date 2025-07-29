
package monaco_editor.monaco.editor;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import monaco_editor.monaco.IDisposable;
import monaco_editor.monaco.IPosition;
import monaco_editor.monaco.Range;
import monaco_editor.monaco.Selection;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import netscape.javascript.JSObject;

/**
 * <p>A rich code editor.</p>
 * See {@code monaco.d.ts:4203:32}<br>
 * Original signature:<br>
 * {@code export interface ICodeEditor extends IEditor  }<br>
 */
@SuppressWarnings("unused")
public class ICodeEditor extends IEditor {

	public ICodeEditor(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public ICodeEditor(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Add a content widget. Widgets must have unique ids, otherwise they will be overwritten.</p>
	 * See {@code monaco.d.ts:4494:24}<br>
	 * Original signature:<br>
	 * {@code addContentWidget(widget: IContentWidget): void; }<br>
	 */
	public void addContentWidget(@Nonnull IContentWidget widget) { call("addContentWidget", ofVoid(), widget); }

 	/**
	 * <p>Add an overlay widget. Widgets must have unique ids, otherwise they will be overwritten.</p>
	 * See {@code monaco.d.ts:4507:24}<br>
	 * Original signature:<br>
	 * {@code addOverlayWidget(widget: IOverlayWidget): void; }<br>
	 */
	public void addOverlayWidget(@Nonnull IOverlayWidget widget) { call("addOverlayWidget", ofVoid(), widget); }

 	/**
	 * <p>Apply the same font settings as the editor to <code>target</code>.</p>
	 * See {@code monaco.d.ts:4553:21}<br>
	 * Original signature:<br>
	 * {@code applyFontInfo(target: HTMLElement): void; }<br>
	 */
	public void applyFontInfo(@Nonnull JSObject target) { call("applyFontInfo", ofVoid(), target); }

 	/**
	 * <p>Change the view zones. View zones are lost when a new model is attached to the editor.</p>
	 * See {@code monaco.d.ts:4520:23}<br>
	 * Original signature:<br>
	 * {@code changeViewZones(callback: (accessor: IViewZoneChangeAccessor) => void): void; }<br>
	 */
	public void changeViewZones(@Nonnull JSObject callback) { call("changeViewZones", ofVoid(), callback); }

 	/**
	 * <p>All decorations added through this call will get the ownerId of this editor.</p>
	 * See {@code monaco.d.ts:4465:24}<br>
	 * Original signature:<br>
	 * {@code deltaDecorations(oldDecorations: string[], newDecorations: IModelDeltaDecoration[]): string[]; }<br>
	 */
	public List<String> deltaDecorations(@Nonnull List<String> oldDecorations, @Nonnull List<IModelDeltaDecoration> newDecorations) { return call("deltaDecorations", ofArray(ofMapped(String.class)), oldDecorations, newDecorations); }

 	/**
	 * <p>Execute a command on the editor.
	 * The edits will land on the undo-redo stack, but no &quot;undo stop&quot; will be pushed.</p>
	 * See {@code monaco.d.ts:4438:22}<br>
	 * Original signature:<br>
	 * {@code executeCommand(source: string, command: ICommand): void; }<br>
	 * 
	 * @param source The source of the call.
	 * @param command The command to execute
	 */
	public void executeCommand(@Nonnull String source, @Nonnull ICommand command) { call("executeCommand", ofVoid(), source, command); }

 	/**
	 * <p>Execute multiple (concomitant) commands on the editor.</p>
	 * See {@code monaco.d.ts:4456:23}<br>
	 * Original signature:<br>
	 * {@code executeCommands(source: string, commands: (ICommand | null)[]): void; }<br>
	 * 
	 * @param source The source of the call.
	 */
	public void executeCommands(@Nonnull String source, @Nonnull List<ICommand> commands) { call("executeCommands", ofVoid(), source, commands); }

 	/**
	 * <p>Execute edits on the editor.
	 * The edits will land on the undo-redo stack, but no &quot;undo stop&quot; will be pushed.</p>
	 * See {@code monaco.d.ts:4450:20}<br>
	 * Original signature:<br>
	 * {@code executeEdits(source: string, edits: IIdentifiedSingleEditOperation[], endCursorState?: ICursorStateComputer | Selection[]): boolean; }<br>
	 * 
	 * @param source The source of the call.
	 * @param edits The edits to execute.
	 * @param endCursorState Cursor state after the edits were applied.
	 */
	public boolean executeEdits(@Nonnull String source, @Nonnull List<IIdentifiedSingleEditOperation> edits, @Nonnull List<Selection> endCursorState) { return call("executeEdits", ofMapped(boolean.class), source, edits, endCursorState); }

 	/**
	 * <p>Execute edits on the editor.
	 * The edits will land on the undo-redo stack, but no &quot;undo stop&quot; will be pushed.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:4450:20}<br>
	 * Original signature:<br>
	 * {@code executeEdits(source: string, edits: IIdentifiedSingleEditOperation[], endCursorState?: ICursorStateComputer | Selection[]): boolean; }<br>
	 */
	public boolean executeEdits(@Nonnull String source, @Nonnull List<IIdentifiedSingleEditOperation> edits) { return call("executeEdits", ofMapped(boolean.class), source, edits); }

 	/**
	 * <p>Execute edits on the editor.
	 * The edits will land on the undo-redo stack, but no &quot;undo stop&quot; will be pushed.</p>
	 * See {@code monaco.d.ts:4450:20}<br>
	 * Original signature:<br>
	 * {@code executeEdits(source: string, edits: IIdentifiedSingleEditOperation[], endCursorState?: ICursorStateComputer | Selection[]): boolean; }<br>
	 * 
	 * @param source The source of the call.
	 * @param edits The edits to execute.
	 * @param endCursorState Cursor state after the edits were applied.
	 */
	public boolean executeEdits(@Nonnull String source, @Nonnull List<IIdentifiedSingleEditOperation> edits, @Nonnull ICursorStateComputer endCursorState) { return call("executeEdits", ofMapped(boolean.class), source, edits, endCursorState); }

 	/**
	 * <p>Get an action that is a contribution to this editor.</p>
	 * See {@code monaco.d.ts:4431:17}<br>
	 * Original signature:<br>
	 * {@code getAction(id: string): IEditorAction; }<br>
	 */
	public IEditorAction getAction(@Nonnull String id) { return call("getAction", IEditorAction::new, id); }

 	/**
	 * <p>Returns the editor's container dom node</p>
	 * See {@code monaco.d.ts:4486:27}<br>
	 * Original signature:<br>
	 * {@code getContainerDomNode(): HTMLElement; }<br>
	 */
	public JSObject getContainerDomNode() { return call("getContainerDomNode", ofMapped(JSObject.class)); }

 	/**
	 * <p>Get the height of the editor's content.
	 * This is information that is &quot;erased&quot; when computing <code>scrollHeight = Math.max(contentHeight, height)</code></p>
	 * See {@code monaco.d.ts:4405:24}<br>
	 * Original signature:<br>
	 * {@code getContentHeight(): number; }<br>
	 */
	public double getContentHeight() { return call("getContentHeight", ofMapped(double.class)); }

 	/**
	 * <p>Get the width of the editor's content.
	 * This is information that is &quot;erased&quot; when computing <code>scrollWidth = Math.max(contentWidth, width)</code></p>
	 * See {@code monaco.d.ts:4392:23}<br>
	 * Original signature:<br>
	 * {@code getContentWidth(): number; }<br>
	 */
	public double getContentWidth() { return call("getContentWidth", ofMapped(double.class)); }

 	/**
	 * <p>Get a contribution of this editor.</p>
	 * See {@code monaco.d.ts:4349:23}<br>
	 * Original signature:<br>
	 * {@code getContribution<T extends IEditorContribution>(id: string): T; }<br>
	 */
	public <T extends IEditorContribution> T getContribution(@Nonnull String id) { return call("getContribution", null , id); }

 	/**
	 * <p>Returns the editor's dom node</p>
	 * See {@code monaco.d.ts:4490:18}<br>
	 * Original signature:<br>
	 * {@code getDomNode(): HTMLElement | null; }<br>
	 */
	public Optional<JSObject> getDomNode() { return Optional.ofNullable(call("getDomNode", ofMapped(JSObject.class))); }

 	/**
	 * <p>Get the layout info for the editor.</p>
	 * See {@code monaco.d.ts:4469:21}<br>
	 * Original signature:<br>
	 * {@code getLayoutInfo(): EditorLayoutInfo; }<br>
	 */
	public EditorLayoutInfo getLayoutInfo() { return call("getLayoutInfo", EditorLayoutInfo::new); }

 	/**
	 * <p>Get all the decorations on a line (filtering out decorations from other editors).</p>
	 * See {@code monaco.d.ts:4460:26}<br>
	 * Original signature:<br>
	 * {@code getLineDecorations(lineNumber: number): IModelDecoration[] | null; }<br>
	 */
	public Optional<List<IModelDecoration>> getLineDecorations(@Nonnull Double lineNumber) { return Optional.ofNullable(call("getLineDecorations", ofArray(IModelDecoration::new), lineNumber)); }

 	/**
	 * <p>Type the getModel() of IEditor.</p>
	 * See {@code monaco.d.ts:4353:16}<br>
	 * Original signature:<br>
	 * {@code getModel(): ITextModel | null; }<br>
	 */
	public Optional<ITextModel> getModel_() { return Optional.ofNullable(call("getModel", ITextModel::new)); }

 	/**
	 * <p>Get the horizontal position (left offset) for the column w.r.t to the beginning of the line.
	 * This method works only if the line <code>lineNumber</code> is currently rendered (in the editor's viewport).
	 * Use this method with caution.</p>
	 * See {@code monaco.d.ts:4526:26}<br>
	 * Original signature:<br>
	 * {@code getOffsetForColumn(lineNumber: number, column: number): number; }<br>
	 */
	public double getOffsetForColumn(@Nonnull Double lineNumber, @Nonnull Double column) { return call("getOffsetForColumn", ofMapped(double.class), lineNumber, column); }

 	/**
	 * <p>Gets a specific editor option.</p>
	 * See {@code monaco.d.ts:4370:17}<br>
	 * Original signature:<br>
	 * {@code getOption<T extends EditorOption>(id: T): FindComputedEditorOptionValueById<T>; }<br>
	 */
	public <T extends EditorOption> T getOption(@Nonnull T id) { return call("getOption", null , id); }

 	/**
	 * <p>Gets all the editor computed options.</p>
	 * See {@code monaco.d.ts:4366:18}<br>
	 * Original signature:<br>
	 * {@code getOptions(): IComputedEditorOptions; }<br>
	 */
	public IComputedEditorOptions getOptions() { return call("getOptions", IComputedEditorOptions::new); }

 	/**
	 * <p>Returns the editor's configuration (without any validation or defaults).</p>
	 * See {@code monaco.d.ts:4374:21}<br>
	 * Original signature:<br>
	 * {@code getRawOptions(): IEditorOptions; }<br>
	 */
	public IEditorOptions getRawOptions() { return call("getRawOptions", IEditorOptions::new); }

 	/**
	 * <p>Get the scrollHeight of the editor's viewport.</p>
	 * See {@code monaco.d.ts:4409:23}<br>
	 * Original signature:<br>
	 * {@code getScrollHeight(): number; }<br>
	 */
	public double getScrollHeight() { return call("getScrollHeight", ofMapped(double.class)); }

 	/**
	 * <p>Get the scrollLeft of the editor's viewport.</p>
	 * See {@code monaco.d.ts:4400:21}<br>
	 * Original signature:<br>
	 * {@code getScrollLeft(): number; }<br>
	 */
	public double getScrollLeft() { return call("getScrollLeft", ofMapped(double.class)); }

 	/**
	 * <p>Get the scrollTop of the editor's viewport.</p>
	 * See {@code monaco.d.ts:4413:20}<br>
	 * Original signature:<br>
	 * {@code getScrollTop(): number; }<br>
	 */
	public double getScrollTop() { return call("getScrollTop", ofMapped(double.class)); }

 	/**
	 * <p>Get the scrollWidth of the editor's viewport.</p>
	 * See {@code monaco.d.ts:4396:22}<br>
	 * Original signature:<br>
	 * {@code getScrollWidth(): number; }<br>
	 */
	public double getScrollWidth() { return call("getScrollWidth", ofMapped(double.class)); }

 	/**
	 * <p>Get the visible position for <code>position</code>.
	 * The result position takes scrolling into account and is relative to the top left corner of the editor.
	 * Explanation 1: the results of this method will change for the same <code>position</code> if the user scrolls the editor.
	 * Explanation 2: the results of this method will not change if the container of the editor gets repositioned.
	 * Warning: the results of this method are inaccurate for positions that are outside the current editor viewport.</p>
	 * See {@code monaco.d.ts:4545:34}<br>
	 * Original signature:<br>
	 * {@code getScrolledVisiblePosition(position: IPosition):  }<br>
	 */
	public Optional<JSObject> getScrolledVisiblePosition(@Nonnull IPosition position) { return Optional.ofNullable(call("getScrolledVisiblePosition", ofMapped(JSObject.class), position)); }

 	/**
	 * <p>Get the hit test target at coordinates <code>clientX</code> and <code>clientY</code>.
	 * The coordinates are relative to the top-left of the viewport.</p>
	 * See {@code monaco.d.ts:4537:30}<br>
	 * Original signature:<br>
	 * {@code getTargetAtClientPoint(clientX: number, clientY: number): IMouseTarget | null; }<br>
	 */
	public Optional<IMouseTarget> getTargetAtClientPoint(@Nonnull Double clientX, @Nonnull Double clientY) { return Optional.ofNullable(call("getTargetAtClientPoint", IMouseTarget::new, clientX, clientY)); }

 	/**
	 * <p>Get the vertical position (top offset) for the line w.r.t. to the first line.</p>
	 * See {@code monaco.d.ts:4478:27}<br>
	 * Original signature:<br>
	 * {@code getTopForLineNumber(lineNumber: number): number; }<br>
	 */
	public double getTopForLineNumber(@Nonnull Double lineNumber) { return call("getTopForLineNumber", ofMapped(double.class), lineNumber); }

 	/**
	 * <p>Get the vertical position (top offset) for the position w.r.t. to the first line.</p>
	 * See {@code monaco.d.ts:4482:25}<br>
	 * Original signature:<br>
	 * {@code getTopForPosition(lineNumber: number, column: number): number; }<br>
	 */
	public double getTopForPosition(@Nonnull Double lineNumber, @Nonnull Double column) { return call("getTopForPosition", ofMapped(double.class), lineNumber, column); }

 	/**
	 * <p>Get value of the current model attached to this editor.</p>
	 * See {@code monaco.d.ts:4379:16}<br>
	 * Original signature:<br>
	 * {@code getValue(options?:  }<br>
	 */
	public String getValue(@Nonnull JSObject options) { return call("getValue", ofMapped(String.class), options); }

 	/**
	 * <p>Get value of the current model attached to this editor.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:4379:16}<br>
	 * Original signature:<br>
	 * {@code getValue(options?:  }<br>
	 */
	public String getValue() { return call("getValue", ofMapped(String.class)); }

 	/**
	 * <p>Returns the ranges that are currently visible.
	 * Does not account for horizontal scrolling.</p>
	 * See {@code monaco.d.ts:4474:24}<br>
	 * Original signature:<br>
	 * {@code getVisibleRanges(): Range[]; }<br>
	 */
	public List<Range> getVisibleRanges() { return call("getVisibleRanges", ofArray(Range::new)); }

 	/**
	 * <p>Returns true if the text inside this editor or an editor widget has focus.</p>
	 * See {@code monaco.d.ts:4343:22}<br>
	 * Original signature:<br>
	 * {@code hasWidgetFocus(): boolean; }<br>
	 */
	public boolean hasWidgetFocus() { return call("hasWidgetFocus", ofMapped(boolean.class)); }

 	/**
	 * <p>Layout/Reposition a content widget. This is a ping to the editor to call widget.getPosition()
	 * and update appropriately.</p>
	 * See {@code monaco.d.ts:4499:27}<br>
	 * Original signature:<br>
	 * {@code layoutContentWidget(widget: IContentWidget): void; }<br>
	 */
	public void layoutContentWidget(@Nonnull IContentWidget widget) { call("layoutContentWidget", ofVoid(), widget); }

 	/**
	 * <p>Layout/Reposition an overlay widget. This is a ping to the editor to call widget.getPosition()
	 * and update appropriately.</p>
	 * See {@code monaco.d.ts:4512:27}<br>
	 * Original signature:<br>
	 * {@code layoutOverlayWidget(widget: IOverlayWidget): void; }<br>
	 */
	public void layoutOverlayWidget(@Nonnull IOverlayWidget widget) { call("layoutOverlayWidget", ofVoid(), widget); }

 	/**
	 * <p>An event emitted after composition has ended.</p>
	 * See {@code monaco.d.ts:4276:27}<br>
	 * Original signature:<br>
	 * {@code onDidCompositionEnd(listener: () => void): IDisposable; }<br>
	 */
	public IDisposable onDidCompositionEnd(@Nonnull JSObject listener) { return call("onDidCompositionEnd", IDisposable::new, listener); }

 	/**
	 * <p>An event emitted after composition has started.</p>
	 * See {@code monaco.d.ts:4272:29}<br>
	 * Original signature:<br>
	 * {@code onDidCompositionStart(listener: () => void): IDisposable; }<br>
	 */
	public IDisposable onDidCompositionStart(@Nonnull JSObject listener) { return call("onDidCompositionStart", IDisposable::new, listener); }

 	/**
	 * <p>Push an &quot;undo stop&quot; in the undo-redo stack.</p>
	 * See {@code monaco.d.ts:4442:20}<br>
	 * Original signature:<br>
	 * {@code pushUndoStop(): boolean; }<br>
	 */
	public boolean pushUndoStop() { return call("pushUndoStop", ofMapped(boolean.class)); }

 	/**
	 * <p>Remove a content widget.</p>
	 * See {@code monaco.d.ts:4503:27}<br>
	 * Original signature:<br>
	 * {@code removeContentWidget(widget: IContentWidget): void; }<br>
	 */
	public void removeContentWidget(@Nonnull IContentWidget widget) { call("removeContentWidget", ofVoid(), widget); }

 	/**
	 * <p>Remove an overlay widget.</p>
	 * See {@code monaco.d.ts:4516:27}<br>
	 * Original signature:<br>
	 * {@code removeOverlayWidget(widget: IOverlayWidget): void; }<br>
	 */
	public void removeOverlayWidget(@Nonnull IOverlayWidget widget) { call("removeOverlayWidget", ofVoid(), widget); }

 	/**
	 * <p>Force an editor render now.</p>
	 * See {@code monaco.d.ts:4530:14}<br>
	 * Original signature:<br>
	 * {@code render(forceRedraw?: boolean): void; }<br>
	 */
	public void render(@Nonnull Boolean forceRedraw) { call("render", ofVoid(), forceRedraw); }

 	/**
	 * <p>Force an editor render now.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:4530:14}<br>
	 * Original signature:<br>
	 * {@code render(forceRedraw?: boolean): void; }<br>
	 */
	public void render() { call("render", ofVoid()); }

 	/**
	 * <p>Restores the view state of the editor from a serializable object generated by <code>saveViewState</code>.</p>
	 * See {@code monaco.d.ts:4339:24}<br>
	 * Original signature:<br>
	 * {@code restoreViewState(state: ICodeEditorViewState): void; }<br>
	 */
	public void restoreViewState_(@Nonnull ICodeEditorViewState state) { call("restoreViewState", ofVoid(), state); }

 	/**
	 * <p>Saves current view state of the editor in a serializable object.</p>
	 * See {@code monaco.d.ts:4335:21}<br>
	 * Original signature:<br>
	 * {@code saveViewState(): ICodeEditorViewState | null; }<br>
	 */
	public Optional<ICodeEditorViewState> saveViewState_() { return Optional.ofNullable(call("saveViewState", ICodeEditorViewState::new)); }

 	/**
	 * <p>Sets the current model attached to this editor.
	 * If the previous model was created by the editor via the value key in the options
	 * literal object, it will be destroyed. Otherwise, if the previous model was set
	 * via setModel, or the model key in the options literal object, the previous model
	 * will not be destroyed.
	 * It is safe to call setModel(null) to simply detach the current model from the editor.</p>
	 * See {@code monaco.d.ts:4362:16}<br>
	 * Original signature:<br>
	 * {@code setModel(model: ITextModel | null): void; }<br>
	 */
	public void setModel_(@Nullable ITextModel model) { call("setModel", ofVoid(), model); }

 	/**
	 * <p>Change the scrollLeft of the editor's viewport.</p>
	 * See {@code monaco.d.ts:4417:21}<br>
	 * Original signature:<br>
	 * {@code setScrollLeft(newScrollLeft: number): void; }<br>
	 */
	public void setScrollLeft(@Nonnull Double newScrollLeft) { call("setScrollLeft", ofVoid(), newScrollLeft); }

 	/**
	 * <p>Change the scroll position of the editor's viewport.</p>
	 * See {@code monaco.d.ts:4425:25}<br>
	 * Original signature:<br>
	 * {@code setScrollPosition(position: INewScrollPosition): void; }<br>
	 */
	public void setScrollPosition(@Nonnull INewScrollPosition position) { call("setScrollPosition", ofVoid(), position); }

 	/**
	 * <p>Change the scrollTop of the editor's viewport.</p>
	 * See {@code monaco.d.ts:4421:20}<br>
	 * Original signature:<br>
	 * {@code setScrollTop(newScrollTop: number): void; }<br>
	 */
	public void setScrollTop(@Nonnull Double newScrollTop) { call("setScrollTop", ofVoid(), newScrollTop); }

 	/**
	 * <p>Set the value of the current model attached to this editor.</p>
	 * See {@code monaco.d.ts:4387:16}<br>
	 * Original signature:<br>
	 * {@code setValue(newValue: string): void; }<br>
	 */
	public void setValue(@Nonnull String newValue) { call("setValue", ofVoid(), newValue); }

 
}
