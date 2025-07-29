
package monaco_editor.monaco.editor;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import net.kurobako.monacofx.js.JsUnion2;

/**
 * <p>Configuration options for the diff editor.</p>
 * See {@code monaco.d.ts:3030:39}<br>
 * Original signature:<br>
 * {@code export interface IDiffEditorOptions extends IEditorOptions  }<br>
 */
@SuppressWarnings("unused")
public class IDiffEditorOptions extends IEditorOptions {

	public IDiffEditorOptions(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IDiffEditorOptions(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Accept suggestions on provider defined characters.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2881:41}<br>
	 * Original signature:<br>
	 * {@code acceptSuggestionOnCommitCharacter?: boolean; }<br>
	 */
	public boolean acceptSuggestionOnCommitCharacter() { return get("acceptSuggestionOnCommitCharacter", ofMapped(boolean.class)); }

 	/**
	 * <p>Accept suggestions on provider defined characters.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2881:41}<br>
	 * Original signature:<br>
	 * {@code acceptSuggestionOnCommitCharacter?: boolean; }<br>
	 */
	public IDiffEditorOptions acceptSuggestionOnCommitCharacter(@Nonnull Boolean value) {
		set("acceptSuggestionOnCommitCharacter", value);
		return this;
	}

 	/**
	 * <p>Controls the number of lines in the editor that can be read out by a screen reader</p>
	 * See {@code monaco.d.ts:2805:29}<br>
	 * Original signature:<br>
	 * {@code accessibilityPageSize?: number; }<br>
	 */
	public double accessibilityPageSize() { return get("accessibilityPageSize", ofMapped(double.class)); }

 	/**
	 * <p>Controls the number of lines in the editor that can be read out by a screen reader</p>
	 * See {@code monaco.d.ts:2805:29}<br>
	 * Original signature:<br>
	 * {@code accessibilityPageSize?: number; }<br>
	 */
	public IDiffEditorOptions accessibilityPageSize(@Nonnull Double value) {
		set("accessibilityPageSize", value);
		return this;
	}

 	/**
	 * <p>The aria label for the editor's textarea (when it is focused).</p>
	 * See {@code monaco.d.ts:2516:17}<br>
	 * Original signature:<br>
	 * {@code ariaLabel?: string; }<br>
	 */
	public String ariaLabel() { return get("ariaLabel", ofMapped(String.class)); }

 	/**
	 * <p>The aria label for the editor's textarea (when it is focused).</p>
	 * See {@code monaco.d.ts:2516:17}<br>
	 * Original signature:<br>
	 * {@code ariaLabel?: string; }<br>
	 */
	public IDiffEditorOptions ariaLabel(@Nonnull String value) {
		set("ariaLabel", value);
		return this;
	}

 	/**
	 * <p>Enable that the editor will install an interval to check if its container dom node size has changed.
	 * Enabling this might have a severe performance impact.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:2700:23}<br>
	 * Original signature:<br>
	 * {@code automaticLayout?: boolean; }<br>
	 */
	public boolean automaticLayout() { return get("automaticLayout", ofMapped(boolean.class)); }

 	/**
	 * <p>Enable that the editor will install an interval to check if its container dom node size has changed.
	 * Enabling this might have a severe performance impact.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:2700:23}<br>
	 * Original signature:<br>
	 * {@code automaticLayout?: boolean; }<br>
	 */
	public IDiffEditorOptions automaticLayout(@Nonnull Boolean value) {
		set("automaticLayout", value);
		return this;
	}

 	/**
	 * <p>Timeout for running code actions on save.</p>
	 * See {@code monaco.d.ts:2934:32}<br>
	 * Original signature:<br>
	 * {@code codeActionsOnSaveTimeout?: number; }<br>
	 */
	public double codeActionsOnSaveTimeout() { return get("codeActionsOnSaveTimeout", ofMapped(double.class)); }

 	/**
	 * <p>Timeout for running code actions on save.</p>
	 * See {@code monaco.d.ts:2934:32}<br>
	 * Original signature:<br>
	 * {@code codeActionsOnSaveTimeout?: number; }<br>
	 */
	public IDiffEditorOptions codeActionsOnSaveTimeout(@Nonnull Double value) {
		set("codeActionsOnSaveTimeout", value);
		return this;
	}

 	/**
	 * <p>Show code lens
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2926:16}<br>
	 * Original signature:<br>
	 * {@code codeLens?: boolean; }<br>
	 */
	public boolean codeLens() { return get("codeLens", ofMapped(boolean.class)); }

 	/**
	 * <p>Show code lens
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2926:16}<br>
	 * Original signature:<br>
	 * {@code codeLens?: boolean; }<br>
	 */
	public IDiffEditorOptions codeLens(@Nonnull Boolean value) {
		set("codeLens", value);
		return this;
	}

 	/**
	 * <p>Enable inline color decorators and color picker rendering.</p>
	 * See {@code monaco.d.ts:2762:23}<br>
	 * Original signature:<br>
	 * {@code colorDecorators?: boolean; }<br>
	 */
	public boolean colorDecorators() { return get("colorDecorators", ofMapped(boolean.class)); }

 	/**
	 * <p>Enable inline color decorators and color picker rendering.</p>
	 * See {@code monaco.d.ts:2762:23}<br>
	 * Original signature:<br>
	 * {@code colorDecorators?: boolean; }<br>
	 */
	public IDiffEditorOptions colorDecorators(@Nonnull Boolean value) {
		set("colorDecorators", value);
		return this;
	}

 	/**
	 * <p>Control the behaviour of comments in the editor.</p>
	 * See {@code monaco.d.ts:2766:16}<br>
	 * Original signature:<br>
	 * {@code comments?: IEditorCommentsOptions; }<br>
	 */
	public IEditorCommentsOptions comments() { return get("comments", IEditorCommentsOptions::new); }

 	/**
	 * <p>Control the behaviour of comments in the editor.</p>
	 * See {@code monaco.d.ts:2766:16}<br>
	 * Original signature:<br>
	 * {@code comments?: IEditorCommentsOptions; }<br>
	 */
	public IDiffEditorOptions comments(@Nonnull IEditorCommentsOptions value) {
		set("comments", value);
		return this;
	}

 	/**
	 * <p>Enable custom contextmenu.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2771:19}<br>
	 * Original signature:<br>
	 * {@code contextmenu?: boolean; }<br>
	 */
	public boolean contextmenu() { return get("contextmenu", ofMapped(boolean.class)); }

 	/**
	 * <p>Enable custom contextmenu.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2771:19}<br>
	 * Original signature:<br>
	 * {@code contextmenu?: boolean; }<br>
	 */
	public IDiffEditorOptions contextmenu(@Nonnull Boolean value) {
		set("contextmenu", value);
		return this;
	}

 	/**
	 * <p>Syntax highlighting is copied.</p>
	 * See {@code monaco.d.ts:2893:34}<br>
	 * Original signature:<br>
	 * {@code copyWithSyntaxHighlighting?: boolean; }<br>
	 */
	public boolean copyWithSyntaxHighlighting() { return get("copyWithSyntaxHighlighting", ofMapped(boolean.class)); }

 	/**
	 * <p>Syntax highlighting is copied.</p>
	 * See {@code monaco.d.ts:2893:34}<br>
	 * Original signature:<br>
	 * {@code copyWithSyntaxHighlighting?: boolean; }<br>
	 */
	public IDiffEditorOptions copyWithSyntaxHighlighting(@Nonnull Boolean value) {
		set("copyWithSyntaxHighlighting", value);
		return this;
	}

 	/**
	 * <p>Enable smooth caret animation.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:2649:34}<br>
	 * Original signature:<br>
	 * {@code cursorSmoothCaretAnimation?: boolean; }<br>
	 */
	public boolean cursorSmoothCaretAnimation() { return get("cursorSmoothCaretAnimation", ofMapped(boolean.class)); }

 	/**
	 * <p>Enable smooth caret animation.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:2649:34}<br>
	 * Original signature:<br>
	 * {@code cursorSmoothCaretAnimation?: boolean; }<br>
	 */
	public IDiffEditorOptions cursorSmoothCaretAnimation(@Nonnull Boolean value) {
		set("cursorSmoothCaretAnimation", value);
		return this;
	}

 	/**
	 * <p>Controls the minimal number of visible leading and trailing lines surrounding the cursor.
	 * Defaults to 0.</p>
	 * See {@code monaco.d.ts:2544:30}<br>
	 * Original signature:<br>
	 * {@code cursorSurroundingLines?: number; }<br>
	 */
	public double cursorSurroundingLines() { return get("cursorSurroundingLines", ofMapped(double.class)); }

 	/**
	 * <p>Controls the minimal number of visible leading and trailing lines surrounding the cursor.
	 * Defaults to 0.</p>
	 * See {@code monaco.d.ts:2544:30}<br>
	 * Original signature:<br>
	 * {@code cursorSurroundingLines?: number; }<br>
	 */
	public IDiffEditorOptions cursorSurroundingLines(@Nonnull Double value) {
		set("cursorSurroundingLines", value);
		return this;
	}

 	/**
	 * <p>Control the width of the cursor when cursorStyle is set to 'line'</p>
	 * See {@code monaco.d.ts:2658:19}<br>
	 * Original signature:<br>
	 * {@code cursorWidth?: number; }<br>
	 */
	public double cursorWidth() { return get("cursorWidth", ofMapped(double.class)); }

 	/**
	 * <p>Control the width of the cursor when cursorStyle is set to 'line'</p>
	 * See {@code monaco.d.ts:2658:19}<br>
	 * Original signature:<br>
	 * {@code cursorWidth?: number; }<br>
	 */
	public IDiffEditorOptions cursorWidth(@Nonnull Double value) {
		set("cursorWidth", value);
		return this;
	}

 	/**
	 * <p>Disable the use of <code>transform: translate3d(0px, 0px, 0px)</code> for the editor margin and lines layers.
	 * The usage of <code>transform: translate3d(0px, 0px, 0px)</code> acts as a hint for browsers to create an extra layer.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:2669:27}<br>
	 * Original signature:<br>
	 * {@code disableLayerHinting?: boolean; }<br>
	 */
	public boolean disableLayerHinting() { return get("disableLayerHinting", ofMapped(boolean.class)); }

 	/**
	 * <p>Disable the use of <code>transform: translate3d(0px, 0px, 0px)</code> for the editor margin and lines layers.
	 * The usage of <code>transform: translate3d(0px, 0px, 0px)</code> acts as a hint for browsers to create an extra layer.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:2669:27}<br>
	 * Original signature:<br>
	 * {@code disableLayerHinting?: boolean; }<br>
	 */
	public IDiffEditorOptions disableLayerHinting(@Nonnull Boolean value) {
		set("disableLayerHinting", value);
		return this;
	}

 	/**
	 * <p>Disable the optimizations for monospace fonts.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:2674:37}<br>
	 * Original signature:<br>
	 * {@code disableMonospaceOptimizations?: boolean; }<br>
	 */
	public boolean disableMonospaceOptimizations() { return get("disableMonospaceOptimizations", ofMapped(boolean.class)); }

 	/**
	 * <p>Disable the optimizations for monospace fonts.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:2674:37}<br>
	 * Original signature:<br>
	 * {@code disableMonospaceOptimizations?: boolean; }<br>
	 */
	public IDiffEditorOptions disableMonospaceOptimizations(@Nonnull Boolean value) {
		set("disableMonospaceOptimizations", value);
		return this;
	}

 	/**
	 * <p>Controls if the editor should allow to move selections via drag and drop.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:2866:19}<br>
	 * Original signature:<br>
	 * {@code dragAndDrop?: boolean; }<br>
	 */
	public boolean dragAndDrop() { return get("dragAndDrop", ofMapped(boolean.class)); }

 	/**
	 * <p>Controls if the editor should allow to move selections via drag and drop.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:2866:19}<br>
	 * Original signature:<br>
	 * {@code dragAndDrop?: boolean; }<br>
	 */
	public IDiffEditorOptions dragAndDrop(@Nonnull Boolean value) {
		set("dragAndDrop", value);
		return this;
	}

 	/**
	 * <p>Copying without a selection copies the current line.</p>
	 * See {@code monaco.d.ts:2889:31}<br>
	 * Original signature:<br>
	 * {@code emptySelectionClipboard?: boolean; }<br>
	 */
	public boolean emptySelectionClipboard() { return get("emptySelectionClipboard", ofMapped(boolean.class)); }

 	/**
	 * <p>Copying without a selection copies the current line.</p>
	 * See {@code monaco.d.ts:2889:31}<br>
	 * Original signature:<br>
	 * {@code emptySelectionClipboard?: boolean; }<br>
	 */
	public IDiffEditorOptions emptySelectionClipboard(@Nonnull Boolean value) {
		set("emptySelectionClipboard", value);
		return this;
	}

 	/**
	 * <p>Allow the user to resize the diff editor split view.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:3035:31}<br>
	 * Original signature:<br>
	 * {@code enableSplitViewResizing?: boolean; }<br>
	 */
	public boolean enableSplitViewResizing() { return get("enableSplitViewResizing", ofMapped(boolean.class)); }

 	/**
	 * <p>Allow the user to resize the diff editor split view.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:3035:31}<br>
	 * Original signature:<br>
	 * {@code enableSplitViewResizing?: boolean; }<br>
	 */
	public IDiffEditorOptions enableSplitViewResizing(@Nonnull Boolean value) {
		set("enableSplitViewResizing", value);
		return this;
	}

 	/**
	 * <p>Class name to be added to the editor.</p>
	 * See {@code monaco.d.ts:2592:28}<br>
	 * Original signature:<br>
	 * {@code extraEditorClassName?: string; }<br>
	 */
	public String extraEditorClassName() { return get("extraEditorClassName", ofMapped(String.class)); }

 	/**
	 * <p>Class name to be added to the editor.</p>
	 * See {@code monaco.d.ts:2592:28}<br>
	 * Original signature:<br>
	 * {@code extraEditorClassName?: string; }<br>
	 */
	public IDiffEditorOptions extraEditorClassName(@Nonnull String value) {
		set("extraEditorClassName", value);
		return this;
	}

 	/**
	 * <p>FastScrolling mulitplier speed when pressing <code>Alt</code>
	 * Defaults to 5.</p>
	 * See {@code monaco.d.ts:2781:29}<br>
	 * Original signature:<br>
	 * {@code fastScrollSensitivity?: number; }<br>
	 */
	public double fastScrollSensitivity() { return get("fastScrollSensitivity", ofMapped(double.class)); }

 	/**
	 * <p>FastScrolling mulitplier speed when pressing <code>Alt</code>
	 * Defaults to 5.</p>
	 * See {@code monaco.d.ts:2781:29}<br>
	 * Original signature:<br>
	 * {@code fastScrollSensitivity?: number; }<br>
	 */
	public IDiffEditorOptions fastScrollSensitivity(@Nonnull Double value) {
		set("fastScrollSensitivity", value);
		return this;
	}

 	/**
	 * <p>Control the behavior of the find widget.</p>
	 * See {@code monaco.d.ts:2614:12}<br>
	 * Original signature:<br>
	 * {@code find?: IEditorFindOptions; }<br>
	 */
	public IEditorFindOptions find() { return get("find", IEditorFindOptions::new); }

 	/**
	 * <p>Control the behavior of the find widget.</p>
	 * See {@code monaco.d.ts:2614:12}<br>
	 * Original signature:<br>
	 * {@code find?: IEditorFindOptions; }<br>
	 */
	public IDiffEditorOptions find(@Nonnull IEditorFindOptions value) {
		set("find", value);
		return this;
	}

 	/**
	 * <p>Display overflow widgets as <code>fixed</code>.
	 * Defaults to <code>false</code>.</p>
	 * See {@code monaco.d.ts:2619:28}<br>
	 * Original signature:<br>
	 * {@code fixedOverflowWidgets?: boolean; }<br>
	 */
	public boolean fixedOverflowWidgets() { return get("fixedOverflowWidgets", ofMapped(boolean.class)); }

 	/**
	 * <p>Display overflow widgets as <code>fixed</code>.
	 * Defaults to <code>false</code>.</p>
	 * See {@code monaco.d.ts:2619:28}<br>
	 * Original signature:<br>
	 * {@code fixedOverflowWidgets?: boolean; }<br>
	 */
	public IDiffEditorOptions fixedOverflowWidgets(@Nonnull Boolean value) {
		set("fixedOverflowWidgets", value);
		return this;
	}

 	/**
	 * <p>Enable code folding.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2939:15}<br>
	 * Original signature:<br>
	 * {@code folding?: boolean; }<br>
	 */
	public boolean folding() { return get("folding", ofMapped(boolean.class)); }

 	/**
	 * <p>Enable code folding.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2939:15}<br>
	 * Original signature:<br>
	 * {@code folding?: boolean; }<br>
	 */
	public IDiffEditorOptions folding(@Nonnull Boolean value) {
		set("folding", value);
		return this;
	}

 	/**
	 * <p>Enable highlight for folded regions.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2949:24}<br>
	 * Original signature:<br>
	 * {@code foldingHighlight?: boolean; }<br>
	 */
	public boolean foldingHighlight() { return get("foldingHighlight", ofMapped(boolean.class)); }

 	/**
	 * <p>Enable highlight for folded regions.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2949:24}<br>
	 * Original signature:<br>
	 * {@code foldingHighlight?: boolean; }<br>
	 */
	public IDiffEditorOptions foldingHighlight(@Nonnull Boolean value) {
		set("foldingHighlight", value);
		return this;
	}

 	/**
	 * <p>The font family</p>
	 * See {@code monaco.d.ts:2992:18}<br>
	 * Original signature:<br>
	 * {@code fontFamily?: string; }<br>
	 */
	public String fontFamily() { return get("fontFamily", ofMapped(String.class)); }

 	/**
	 * <p>The font family</p>
	 * See {@code monaco.d.ts:2992:18}<br>
	 * Original signature:<br>
	 * {@code fontFamily?: string; }<br>
	 */
	public IDiffEditorOptions fontFamily(@Nonnull String value) {
		set("fontFamily", value);
		return this;
	}

 	/**
	 * <p>Enable font ligatures.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:2663:21}<br>
	 * Original signature:<br>
	 * {@code fontLigatures?: boolean | string; }<br>
	 */
	public Optional<JsUnion2<Boolean, String>> fontLigatures() { return Optional.ofNullable(get("fontLigatures", null /*union*/)); }

 	/**
	 * <p>Enable font ligatures.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:2663:21}<br>
	 * Original signature:<br>
	 * {@code fontLigatures?: boolean | string; }<br>
	 */
	public IDiffEditorOptions fontLigatures(@Nonnull Boolean value) {
		set("fontLigatures", value);
		return this;
	}

 	/**
	 * <p>Enable font ligatures.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:2663:21}<br>
	 * Original signature:<br>
	 * {@code fontLigatures?: boolean | string; }<br>
	 */
	public IDiffEditorOptions fontLigatures(@Nonnull String value) {
		set("fontLigatures", value);
		return this;
	}

 	/**
	 * <p>The font size</p>
	 * See {@code monaco.d.ts:3000:16}<br>
	 * Original signature:<br>
	 * {@code fontSize?: number; }<br>
	 */
	public double fontSize() { return get("fontSize", ofMapped(double.class)); }

 	/**
	 * <p>The font size</p>
	 * See {@code monaco.d.ts:3000:16}<br>
	 * Original signature:<br>
	 * {@code fontSize?: number; }<br>
	 */
	public IDiffEditorOptions fontSize(@Nonnull Double value) {
		set("fontSize", value);
		return this;
	}

 	/**
	 * <p>The font weight</p>
	 * See {@code monaco.d.ts:2996:18}<br>
	 * Original signature:<br>
	 * {@code fontWeight?: string; }<br>
	 */
	public String fontWeight() { return get("fontWeight", ofMapped(String.class)); }

 	/**
	 * <p>The font weight</p>
	 * See {@code monaco.d.ts:2996:18}<br>
	 * Original signature:<br>
	 * {@code fontWeight?: string; }<br>
	 */
	public IDiffEditorOptions fontWeight(@Nonnull String value) {
		set("fontWeight", value);
		return this;
	}

 	/**
	 * <p>Enable format on paste.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:2861:21}<br>
	 * Original signature:<br>
	 * {@code formatOnPaste?: boolean; }<br>
	 */
	public boolean formatOnPaste() { return get("formatOnPaste", ofMapped(boolean.class)); }

 	/**
	 * <p>Enable format on paste.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:2861:21}<br>
	 * Original signature:<br>
	 * {@code formatOnPaste?: boolean; }<br>
	 */
	public IDiffEditorOptions formatOnPaste(@Nonnull Boolean value) {
		set("formatOnPaste", value);
		return this;
	}

 	/**
	 * <p>Enable format on type.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:2856:20}<br>
	 * Original signature:<br>
	 * {@code formatOnType?: boolean; }<br>
	 */
	public boolean formatOnType() { return get("formatOnType", ofMapped(boolean.class)); }

 	/**
	 * <p>Enable format on type.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:2856:20}<br>
	 * Original signature:<br>
	 * {@code formatOnType?: boolean; }<br>
	 */
	public IDiffEditorOptions formatOnType(@Nonnull Boolean value) {
		set("formatOnType", value);
		return this;
	}

 	/**
	 * <p>Enable the rendering of the glyph margin.
	 * Defaults to true in vscode and to false in monaco-editor.</p>
	 * See {@code monaco.d.ts:2570:19}<br>
	 * Original signature:<br>
	 * {@code glyphMargin?: boolean; }<br>
	 */
	public boolean glyphMargin() { return get("glyphMargin", ofMapped(boolean.class)); }

 	/**
	 * <p>Enable the rendering of the glyph margin.
	 * Defaults to true in vscode and to false in monaco-editor.</p>
	 * See {@code monaco.d.ts:2570:19}<br>
	 * Original signature:<br>
	 * {@code glyphMargin?: boolean; }<br>
	 */
	public IDiffEditorOptions glyphMargin(@Nonnull Boolean value) {
		set("glyphMargin", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:2813:20}<br>
	 * Original signature:<br>
	 * {@code gotoLocation?: IGotoLocationOptions; }<br>
	 */
	public IGotoLocationOptions gotoLocation() { return get("gotoLocation", IGotoLocationOptions::new); }

 	/**
	 * See {@code monaco.d.ts:2813:20}<br>
	 * Original signature:<br>
	 * {@code gotoLocation?: IGotoLocationOptions; }<br>
	 */
	public IDiffEditorOptions gotoLocation(@Nonnull IGotoLocationOptions value) {
		set("gotoLocation", value);
		return this;
	}

 	/**
	 * <p>Should the cursor be hidden in the overview ruler.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:2679:33}<br>
	 * Original signature:<br>
	 * {@code hideCursorInOverviewRuler?: boolean; }<br>
	 */
	public boolean hideCursorInOverviewRuler() { return get("hideCursorInOverviewRuler", ofMapped(boolean.class)); }

 	/**
	 * <p>Should the cursor be hidden in the overview ruler.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:2679:33}<br>
	 * Original signature:<br>
	 * {@code hideCursorInOverviewRuler?: boolean; }<br>
	 */
	public IDiffEditorOptions hideCursorInOverviewRuler(@Nonnull Boolean value) {
		set("hideCursorInOverviewRuler", value);
		return this;
	}

 	/**
	 * <p>Enable highlighting of the active indent guide.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2979:34}<br>
	 * Original signature:<br>
	 * {@code highlightActiveIndentGuide?: boolean; }<br>
	 */
	public boolean highlightActiveIndentGuide() { return get("highlightActiveIndentGuide", ofMapped(boolean.class)); }

 	/**
	 * <p>Enable highlighting of the active indent guide.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2979:34}<br>
	 * Original signature:<br>
	 * {@code highlightActiveIndentGuide?: boolean; }<br>
	 */
	public IDiffEditorOptions highlightActiveIndentGuide(@Nonnull Boolean value) {
		set("highlightActiveIndentGuide", value);
		return this;
	}

 	/**
	 * <p>Configure the editor's hover.</p>
	 * See {@code monaco.d.ts:2753:13}<br>
	 * Original signature:<br>
	 * {@code hover?: IEditorHoverOptions; }<br>
	 */
	public IEditorHoverOptions hover() { return get("hover", IEditorHoverOptions::new); }

 	/**
	 * <p>Configure the editor's hover.</p>
	 * See {@code monaco.d.ts:2753:13}<br>
	 * Original signature:<br>
	 * {@code hover?: IEditorHoverOptions; }<br>
	 */
	public IDiffEditorOptions hover(@Nonnull IEditorHoverOptions value) {
		set("hover", value);
		return this;
	}

 	/**
	 * <p>Compute the diff by ignoring leading/trailing whitespace
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:3050:28}<br>
	 * Original signature:<br>
	 * {@code ignoreTrimWhitespace?: boolean; }<br>
	 */
	public boolean ignoreTrimWhitespace() { return get("ignoreTrimWhitespace", ofMapped(boolean.class)); }

 	/**
	 * <p>Compute the diff by ignoring leading/trailing whitespace
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:3050:28}<br>
	 * Original signature:<br>
	 * {@code ignoreTrimWhitespace?: boolean; }<br>
	 */
	public IDiffEditorOptions ignoreTrimWhitespace(@Nonnull Boolean value) {
		set("ignoreTrimWhitespace", value);
		return this;
	}

 	/**
	 * <p>This editor is used inside a diff editor.</p>
	 * See {@code monaco.d.ts:2512:20}<br>
	 * Original signature:<br>
	 * {@code inDiffEditor?: boolean; }<br>
	 */
	public boolean inDiffEditor() { return get("inDiffEditor", ofMapped(boolean.class)); }

 	/**
	 * <p>This editor is used inside a diff editor.</p>
	 * See {@code monaco.d.ts:2512:20}<br>
	 * Original signature:<br>
	 * {@code inDiffEditor?: boolean; }<br>
	 */
	public IDiffEditorOptions inDiffEditor(@Nonnull Boolean value) {
		set("inDiffEditor", value);
		return this;
	}

 	/**
	 * <p>The letter spacing</p>
	 * See {@code monaco.d.ts:3008:21}<br>
	 * Original signature:<br>
	 * {@code letterSpacing?: number; }<br>
	 */
	public double letterSpacing() { return get("letterSpacing", ofMapped(double.class)); }

 	/**
	 * <p>The letter spacing</p>
	 * See {@code monaco.d.ts:3008:21}<br>
	 * Original signature:<br>
	 * {@code letterSpacing?: number; }<br>
	 */
	public IDiffEditorOptions letterSpacing(@Nonnull Double value) {
		set("letterSpacing", value);
		return this;
	}

 	/**
	 * <p>Control the behavior and rendering of the code action lightbulb.</p>
	 * See {@code monaco.d.ts:2930:17}<br>
	 * Original signature:<br>
	 * {@code lightbulb?: IEditorLightbulbOptions; }<br>
	 */
	public IEditorLightbulbOptions lightbulb() { return get("lightbulb", IEditorLightbulbOptions::new); }

 	/**
	 * <p>Control the behavior and rendering of the code action lightbulb.</p>
	 * See {@code monaco.d.ts:2930:17}<br>
	 * Original signature:<br>
	 * {@code lightbulb?: IEditorLightbulbOptions; }<br>
	 */
	public IDiffEditorOptions lightbulb(@Nonnull IEditorLightbulbOptions value) {
		set("lightbulb", value);
		return this;
	}

 	/**
	 * <p>The width reserved for line decorations (in px).
	 * Line decorations are placed between line numbers and the editor content.
	 * You can pass in a string in the format floating point followed by &quot;ch&quot;. e.g. 1.3ch.
	 * Defaults to 10.</p>
	 * See {@code monaco.d.ts:2577:28}<br>
	 * Original signature:<br>
	 * {@code lineDecorationsWidth?: number | string; }<br>
	 */
	public Optional<JsUnion2<Double, String>> lineDecorationsWidth() { return Optional.ofNullable(get("lineDecorationsWidth", null /*union*/)); }

 	/**
	 * <p>The width reserved for line decorations (in px).
	 * Line decorations are placed between line numbers and the editor content.
	 * You can pass in a string in the format floating point followed by &quot;ch&quot;. e.g. 1.3ch.
	 * Defaults to 10.</p>
	 * See {@code monaco.d.ts:2577:28}<br>
	 * Original signature:<br>
	 * {@code lineDecorationsWidth?: number | string; }<br>
	 */
	public IDiffEditorOptions lineDecorationsWidth(@Nonnull Double value) {
		set("lineDecorationsWidth", value);
		return this;
	}

 	/**
	 * <p>The width reserved for line decorations (in px).
	 * Line decorations are placed between line numbers and the editor content.
	 * You can pass in a string in the format floating point followed by &quot;ch&quot;. e.g. 1.3ch.
	 * Defaults to 10.</p>
	 * See {@code monaco.d.ts:2577:28}<br>
	 * Original signature:<br>
	 * {@code lineDecorationsWidth?: number | string; }<br>
	 */
	public IDiffEditorOptions lineDecorationsWidth(@Nonnull String value) {
		set("lineDecorationsWidth", value);
		return this;
	}

 	/**
	 * <p>The line height</p>
	 * See {@code monaco.d.ts:3004:18}<br>
	 * Original signature:<br>
	 * {@code lineHeight?: number; }<br>
	 */
	public double lineHeight() { return get("lineHeight", ofMapped(double.class)); }

 	/**
	 * <p>The line height</p>
	 * See {@code monaco.d.ts:3004:18}<br>
	 * Original signature:<br>
	 * {@code lineHeight?: number; }<br>
	 */
	public IDiffEditorOptions lineHeight(@Nonnull Double value) {
		set("lineHeight", value);
		return this;
	}

 	/**
	 * <p>Control the width of line numbers, by reserving horizontal space for rendering at least an amount of digits.
	 * Defaults to 5.</p>
	 * See {@code monaco.d.ts:2565:27}<br>
	 * Original signature:<br>
	 * {@code lineNumbersMinChars?: number; }<br>
	 */
	public double lineNumbersMinChars() { return get("lineNumbersMinChars", ofMapped(double.class)); }

 	/**
	 * <p>Control the width of line numbers, by reserving horizontal space for rendering at least an amount of digits.
	 * Defaults to 5.</p>
	 * See {@code monaco.d.ts:2565:27}<br>
	 * Original signature:<br>
	 * {@code lineNumbersMinChars?: number; }<br>
	 */
	public IDiffEditorOptions lineNumbersMinChars(@Nonnull Double value) {
		set("lineNumbersMinChars", value);
		return this;
	}

 	/**
	 * <p>Enable detecting links and making them clickable.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2758:13}<br>
	 * Original signature:<br>
	 * {@code links?: boolean; }<br>
	 */
	public boolean links() { return get("links", ofMapped(boolean.class)); }

 	/**
	 * <p>Enable detecting links and making them clickable.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2758:13}<br>
	 * Original signature:<br>
	 * {@code links?: boolean; }<br>
	 */
	public IDiffEditorOptions links(@Nonnull Boolean value) {
		set("links", value);
		return this;
	}

 	/**
	 * <p>Timeout in milliseconds after which diff computation is cancelled.
	 * Defaults to 5000.</p>
	 * See {@code monaco.d.ts:3045:26}<br>
	 * Original signature:<br>
	 * {@code maxComputationTime?: number; }<br>
	 */
	public double maxComputationTime() { return get("maxComputationTime", ofMapped(double.class)); }

 	/**
	 * <p>Timeout in milliseconds after which diff computation is cancelled.
	 * Defaults to 5000.</p>
	 * See {@code monaco.d.ts:3045:26}<br>
	 * Original signature:<br>
	 * {@code maxComputationTime?: number; }<br>
	 */
	public IDiffEditorOptions maxComputationTime(@Nonnull Double value) {
		set("maxComputationTime", value);
		return this;
	}

 	/**
	 * <p>Control the behavior and rendering of the minimap.</p>
	 * See {@code monaco.d.ts:2610:15}<br>
	 * Original signature:<br>
	 * {@code minimap?: IEditorMinimapOptions; }<br>
	 */
	public IEditorMinimapOptions minimap() { return get("minimap", IEditorMinimapOptions::new); }

 	/**
	 * <p>Control the behavior and rendering of the minimap.</p>
	 * See {@code monaco.d.ts:2610:15}<br>
	 * Original signature:<br>
	 * {@code minimap?: IEditorMinimapOptions; }<br>
	 */
	public IDiffEditorOptions minimap(@Nonnull IEditorMinimapOptions value) {
		set("minimap", value);
		return this;
	}

 	/**
	 * <p>A multiplier to be used on the <code>deltaX</code> and <code>deltaY</code> of mouse wheel scroll events.
	 * Defaults to 1.</p>
	 * See {@code monaco.d.ts:2776:35}<br>
	 * Original signature:<br>
	 * {@code mouseWheelScrollSensitivity?: number; }<br>
	 */
	public double mouseWheelScrollSensitivity() { return get("mouseWheelScrollSensitivity", ofMapped(double.class)); }

 	/**
	 * <p>A multiplier to be used on the <code>deltaX</code> and <code>deltaY</code> of mouse wheel scroll events.
	 * Defaults to 1.</p>
	 * See {@code monaco.d.ts:2776:35}<br>
	 * Original signature:<br>
	 * {@code mouseWheelScrollSensitivity?: number; }<br>
	 */
	public IDiffEditorOptions mouseWheelScrollSensitivity(@Nonnull Double value) {
		set("mouseWheelScrollSensitivity", value);
		return this;
	}

 	/**
	 * <p>Zoom the font in the editor when using the mouse wheel in combination with holding Ctrl.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:2639:22}<br>
	 * Original signature:<br>
	 * {@code mouseWheelZoom?: boolean; }<br>
	 */
	public boolean mouseWheelZoom() { return get("mouseWheelZoom", ofMapped(boolean.class)); }

 	/**
	 * <p>Zoom the font in the editor when using the mouse wheel in combination with holding Ctrl.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:2639:22}<br>
	 * Original signature:<br>
	 * {@code mouseWheelZoom?: boolean; }<br>
	 */
	public IDiffEditorOptions mouseWheelZoom(@Nonnull Boolean value) {
		set("mouseWheelZoom", value);
		return this;
	}

 	/**
	 * <p>Merge overlapping selections.
	 * Defaults to true</p>
	 * See {@code monaco.d.ts:2791:35}<br>
	 * Original signature:<br>
	 * {@code multiCursorMergeOverlapping?: boolean; }<br>
	 */
	public boolean multiCursorMergeOverlapping() { return get("multiCursorMergeOverlapping", ofMapped(boolean.class)); }

 	/**
	 * <p>Merge overlapping selections.
	 * Defaults to true</p>
	 * See {@code monaco.d.ts:2791:35}<br>
	 * Original signature:<br>
	 * {@code multiCursorMergeOverlapping?: boolean; }<br>
	 */
	public IDiffEditorOptions multiCursorMergeOverlapping(@Nonnull Boolean value) {
		set("multiCursorMergeOverlapping", value);
		return this;
	}

 	/**
	 * <p>Enable semantic occurrences highlight.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2921:28}<br>
	 * Original signature:<br>
	 * {@code occurrencesHighlight?: boolean; }<br>
	 */
	public boolean occurrencesHighlight() { return get("occurrencesHighlight", ofMapped(boolean.class)); }

 	/**
	 * <p>Enable semantic occurrences highlight.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2921:28}<br>
	 * Original signature:<br>
	 * {@code occurrencesHighlight?: boolean; }<br>
	 */
	public IDiffEditorOptions occurrencesHighlight(@Nonnull Boolean value) {
		set("occurrencesHighlight", value);
		return this;
	}

 	/**
	 * <p>Original model should be editable?
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:3060:24}<br>
	 * Original signature:<br>
	 * {@code originalEditable?: boolean; }<br>
	 */
	public boolean originalEditable() { return get("originalEditable", ofMapped(boolean.class)); }

 	/**
	 * <p>Original model should be editable?
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:3060:24}<br>
	 * Original signature:<br>
	 * {@code originalEditable?: boolean; }<br>
	 */
	public IDiffEditorOptions originalEditable(@Nonnull Boolean value) {
		set("originalEditable", value);
		return this;
	}

 	/**
	 * <p>Controls if a border should be drawn around the overview ruler.
	 * Defaults to <code>true</code>.</p>
	 * See {@code monaco.d.ts:2629:27}<br>
	 * Original signature:<br>
	 * {@code overviewRulerBorder?: boolean; }<br>
	 */
	public boolean overviewRulerBorder() { return get("overviewRulerBorder", ofMapped(boolean.class)); }

 	/**
	 * <p>Controls if a border should be drawn around the overview ruler.
	 * Defaults to <code>true</code>.</p>
	 * See {@code monaco.d.ts:2629:27}<br>
	 * Original signature:<br>
	 * {@code overviewRulerBorder?: boolean; }<br>
	 */
	public IDiffEditorOptions overviewRulerBorder(@Nonnull Boolean value) {
		set("overviewRulerBorder", value);
		return this;
	}

 	/**
	 * <p>The number of vertical lanes the overview ruler should render.
	 * Defaults to 3.</p>
	 * See {@code monaco.d.ts:2624:26}<br>
	 * Original signature:<br>
	 * {@code overviewRulerLanes?: number; }<br>
	 */
	public double overviewRulerLanes() { return get("overviewRulerLanes", ofMapped(double.class)); }

 	/**
	 * <p>The number of vertical lanes the overview ruler should render.
	 * Defaults to 3.</p>
	 * See {@code monaco.d.ts:2624:26}<br>
	 * Original signature:<br>
	 * {@code overviewRulerLanes?: number; }<br>
	 */
	public IDiffEditorOptions overviewRulerLanes(@Nonnull Double value) {
		set("overviewRulerLanes", value);
		return this;
	}

 	/**
	 * <p>Parameter hint options.</p>
	 * See {@code monaco.d.ts:2827:22}<br>
	 * Original signature:<br>
	 * {@code parameterHints?: IEditorParameterHintOptions; }<br>
	 */
	public IEditorParameterHintOptions parameterHints() { return get("parameterHints", IEditorParameterHintOptions::new); }

 	/**
	 * <p>Parameter hint options.</p>
	 * See {@code monaco.d.ts:2827:22}<br>
	 * Original signature:<br>
	 * {@code parameterHints?: IEditorParameterHintOptions; }<br>
	 */
	public IDiffEditorOptions parameterHints(@Nonnull IEditorParameterHintOptions value) {
		set("parameterHints", value);
		return this;
	}

 	/**
	 * <p>Enable quick suggestions (shadow suggestions)
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2818:24}<br>
	 * Original signature:<br>
	 * {@code quickSuggestions?: boolean | IQuickSuggestionsOptions; }<br>
	 */
	public Optional<JsUnion2<Boolean, IQuickSuggestionsOptions>> quickSuggestions() { return Optional.ofNullable(get("quickSuggestions", null /*union*/)); }

 	/**
	 * <p>Enable quick suggestions (shadow suggestions)
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2818:24}<br>
	 * Original signature:<br>
	 * {@code quickSuggestions?: boolean | IQuickSuggestionsOptions; }<br>
	 */
	public IDiffEditorOptions quickSuggestions(@Nonnull Boolean value) {
		set("quickSuggestions", value);
		return this;
	}

 	/**
	 * <p>Enable quick suggestions (shadow suggestions)
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2818:24}<br>
	 * Original signature:<br>
	 * {@code quickSuggestions?: boolean | IQuickSuggestionsOptions; }<br>
	 */
	public IDiffEditorOptions quickSuggestions(@Nonnull IQuickSuggestionsOptions value) {
		set("quickSuggestions", value);
		return this;
	}

 	/**
	 * <p>Quick suggestions show delay (in ms)
	 * Defaults to 10 (ms)</p>
	 * See {@code monaco.d.ts:2823:29}<br>
	 * Original signature:<br>
	 * {@code quickSuggestionsDelay?: number; }<br>
	 */
	public double quickSuggestionsDelay() { return get("quickSuggestionsDelay", ofMapped(double.class)); }

 	/**
	 * <p>Quick suggestions show delay (in ms)
	 * Defaults to 10 (ms)</p>
	 * See {@code monaco.d.ts:2823:29}<br>
	 * Original signature:<br>
	 * {@code quickSuggestionsDelay?: number; }<br>
	 */
	public IDiffEditorOptions quickSuggestionsDelay(@Nonnull Double value) {
		set("quickSuggestionsDelay", value);
		return this;
	}

 	/**
	 * <p>Should the editor be read only.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:2597:16}<br>
	 * Original signature:<br>
	 * {@code readOnly?: boolean; }<br>
	 */
	public boolean readOnly() { return get("readOnly", ofMapped(boolean.class)); }

 	/**
	 * <p>Should the editor be read only.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:2597:16}<br>
	 * Original signature:<br>
	 * {@code readOnly?: boolean; }<br>
	 */
	public IDiffEditorOptions readOnly(@Nonnull Boolean value) {
		set("readOnly", value);
		return this;
	}

 	/**
	 * <p>Enable rendering of control characters.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:2969:31}<br>
	 * Original signature:<br>
	 * {@code renderControlCharacters?: boolean; }<br>
	 */
	public boolean renderControlCharacters() { return get("renderControlCharacters", ofMapped(boolean.class)); }

 	/**
	 * <p>Enable rendering of control characters.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:2969:31}<br>
	 * Original signature:<br>
	 * {@code renderControlCharacters?: boolean; }<br>
	 */
	public IDiffEditorOptions renderControlCharacters(@Nonnull Boolean value) {
		set("renderControlCharacters", value);
		return this;
	}

 	/**
	 * <p>Render last line number when the file ends with a newline.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2555:26}<br>
	 * Original signature:<br>
	 * {@code renderFinalNewline?: boolean; }<br>
	 */
	public boolean renderFinalNewline() { return get("renderFinalNewline", ofMapped(boolean.class)); }

 	/**
	 * <p>Render last line number when the file ends with a newline.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2555:26}<br>
	 * Original signature:<br>
	 * {@code renderFinalNewline?: boolean; }<br>
	 */
	public IDiffEditorOptions renderFinalNewline(@Nonnull Boolean value) {
		set("renderFinalNewline", value);
		return this;
	}

 	/**
	 * <p>Enable rendering of indent guides.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2974:26}<br>
	 * Original signature:<br>
	 * {@code renderIndentGuides?: boolean; }<br>
	 */
	public boolean renderIndentGuides() { return get("renderIndentGuides", ofMapped(boolean.class)); }

 	/**
	 * <p>Enable rendering of indent guides.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2974:26}<br>
	 * Original signature:<br>
	 * {@code renderIndentGuides?: boolean; }<br>
	 */
	public IDiffEditorOptions renderIndentGuides(@Nonnull Boolean value) {
		set("renderIndentGuides", value);
		return this;
	}

 	/**
	 * <p>Render +/- indicators for added/deleted changes.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:3055:24}<br>
	 * Original signature:<br>
	 * {@code renderIndicators?: boolean; }<br>
	 */
	public boolean renderIndicators() { return get("renderIndicators", ofMapped(boolean.class)); }

 	/**
	 * <p>Render +/- indicators for added/deleted changes.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:3055:24}<br>
	 * Original signature:<br>
	 * {@code renderIndicators?: boolean; }<br>
	 */
	public IDiffEditorOptions renderIndicators(@Nonnull Boolean value) {
		set("renderIndicators", value);
		return this;
	}

 	/**
	 * <p>Render the differences in two side-by-side editors.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:3040:24}<br>
	 * Original signature:<br>
	 * {@code renderSideBySide?: boolean; }<br>
	 */
	public boolean renderSideBySide() { return get("renderSideBySide", ofMapped(boolean.class)); }

 	/**
	 * <p>Render the differences in two side-by-side editors.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:3040:24}<br>
	 * Original signature:<br>
	 * {@code renderSideBySide?: boolean; }<br>
	 */
	public IDiffEditorOptions renderSideBySide(@Nonnull Boolean value) {
		set("renderSideBySide", value);
		return this;
	}

 	/**
	 * <p>When revealing the cursor, a virtual padding (px) is added to the cursor, turning it into a rectangle.
	 * This virtual padding ensures that the cursor gets revealed before hitting the edge of the viewport.
	 * Defaults to 30 (px).</p>
	 * See {@code monaco.d.ts:2583:36}<br>
	 * Original signature:<br>
	 * {@code revealHorizontalRightPadding?: number; }<br>
	 */
	public double revealHorizontalRightPadding() { return get("revealHorizontalRightPadding", ofMapped(double.class)); }

 	/**
	 * <p>When revealing the cursor, a virtual padding (px) is added to the cursor, turning it into a rectangle.
	 * This virtual padding ensures that the cursor gets revealed before hitting the edge of the viewport.
	 * Defaults to 30 (px).</p>
	 * See {@code monaco.d.ts:2583:36}<br>
	 * Original signature:<br>
	 * {@code revealHorizontalRightPadding?: number; }<br>
	 */
	public IDiffEditorOptions revealHorizontalRightPadding(@Nonnull Double value) {
		set("revealHorizontalRightPadding", value);
		return this;
	}

 	/**
	 * <p>Render the editor selection with rounded borders.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2588:24}<br>
	 * Original signature:<br>
	 * {@code roundedSelection?: boolean; }<br>
	 */
	public boolean roundedSelection() { return get("roundedSelection", ofMapped(boolean.class)); }

 	/**
	 * <p>Render the editor selection with rounded borders.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2588:24}<br>
	 * Original signature:<br>
	 * {@code roundedSelection?: boolean; }<br>
	 */
	public IDiffEditorOptions roundedSelection(@Nonnull Boolean value) {
		set("roundedSelection", value);
		return this;
	}

 	/**
	 * <p>Render vertical lines at the specified columns.
	 * Defaults to empty array.</p>
	 * See {@code monaco.d.ts:2521:14}<br>
	 * Original signature:<br>
	 * {@code rulers?: number[]; }<br>
	 */
	public List<Double> rulers() { return get("rulers", ofArray(ofMapped(double.class))); }

 	/**
	 * <p>Render vertical lines at the specified columns.
	 * Defaults to empty array.</p>
	 * See {@code monaco.d.ts:2521:14}<br>
	 * Original signature:<br>
	 * {@code rulers?: number[]; }<br>
	 */
	public IDiffEditorOptions rulers(@Nonnull List<Double> value) {
		
		return this;
	}

 	/**
	 * <p>Enable that scrolling can go beyond the last column by a number of columns.
	 * Defaults to 5.</p>
	 * See {@code monaco.d.ts:2689:30}<br>
	 * Original signature:<br>
	 * {@code scrollBeyondLastColumn?: number; }<br>
	 */
	public double scrollBeyondLastColumn() { return get("scrollBeyondLastColumn", ofMapped(double.class)); }

 	/**
	 * <p>Enable that scrolling can go beyond the last column by a number of columns.
	 * Defaults to 5.</p>
	 * See {@code monaco.d.ts:2689:30}<br>
	 * Original signature:<br>
	 * {@code scrollBeyondLastColumn?: number; }<br>
	 */
	public IDiffEditorOptions scrollBeyondLastColumn(@Nonnull Double value) {
		set("scrollBeyondLastColumn", value);
		return this;
	}

 	/**
	 * <p>Enable that scrolling can go one screen size after the last line.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2684:28}<br>
	 * Original signature:<br>
	 * {@code scrollBeyondLastLine?: boolean; }<br>
	 */
	public boolean scrollBeyondLastLine() { return get("scrollBeyondLastLine", ofMapped(boolean.class)); }

 	/**
	 * <p>Enable that scrolling can go one screen size after the last line.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2684:28}<br>
	 * Original signature:<br>
	 * {@code scrollBeyondLastLine?: boolean; }<br>
	 */
	public IDiffEditorOptions scrollBeyondLastLine(@Nonnull Boolean value) {
		set("scrollBeyondLastLine", value);
		return this;
	}

 	/**
	 * <p>Control the behavior and rendering of the scrollbars.</p>
	 * See {@code monaco.d.ts:2606:17}<br>
	 * Original signature:<br>
	 * {@code scrollbar?: IEditorScrollbarOptions; }<br>
	 */
	public IEditorScrollbarOptions scrollbar() { return get("scrollbar", IEditorScrollbarOptions::new); }

 	/**
	 * <p>Control the behavior and rendering of the scrollbars.</p>
	 * See {@code monaco.d.ts:2606:17}<br>
	 * Original signature:<br>
	 * {@code scrollbar?: IEditorScrollbarOptions; }<br>
	 */
	public IDiffEditorOptions scrollbar(@Nonnull IEditorScrollbarOptions value) {
		set("scrollbar", value);
		return this;
	}

 	/**
	 * <p>Should the corresponding line be selected when clicking on the line number?
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2560:27}<br>
	 * Original signature:<br>
	 * {@code selectOnLineNumbers?: boolean; }<br>
	 */
	public boolean selectOnLineNumbers() { return get("selectOnLineNumbers", ofMapped(boolean.class)); }

 	/**
	 * <p>Should the corresponding line be selected when clicking on the line number?
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2560:27}<br>
	 * Original signature:<br>
	 * {@code selectOnLineNumbers?: boolean; }<br>
	 */
	public IDiffEditorOptions selectOnLineNumbers(@Nonnull Boolean value) {
		set("selectOnLineNumbers", value);
		return this;
	}

 	/**
	 * <p>Enable Linux primary clipboard.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2531:26}<br>
	 * Original signature:<br>
	 * {@code selectionClipboard?: boolean; }<br>
	 */
	public boolean selectionClipboard() { return get("selectionClipboard", ofMapped(boolean.class)); }

 	/**
	 * <p>Enable Linux primary clipboard.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2531:26}<br>
	 * Original signature:<br>
	 * {@code selectionClipboard?: boolean; }<br>
	 */
	public IDiffEditorOptions selectionClipboard(@Nonnull Boolean value) {
		set("selectionClipboard", value);
		return this;
	}

 	/**
	 * <p>Enable selection highlight.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2916:26}<br>
	 * Original signature:<br>
	 * {@code selectionHighlight?: boolean; }<br>
	 */
	public boolean selectionHighlight() { return get("selectionHighlight", ofMapped(boolean.class)); }

 	/**
	 * <p>Enable selection highlight.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2916:26}<br>
	 * Original signature:<br>
	 * {@code selectionHighlight?: boolean; }<br>
	 */
	public IDiffEditorOptions selectionHighlight(@Nonnull Boolean value) {
		set("selectionHighlight", value);
		return this;
	}

 	/**
	 * <p>Controls fading out of unused variables.</p>
	 * See {@code monaco.d.ts:3012:18}<br>
	 * Original signature:<br>
	 * {@code showUnused?: boolean; }<br>
	 */
	public boolean showUnused() { return get("showUnused", ofMapped(boolean.class)); }

 	/**
	 * <p>Controls fading out of unused variables.</p>
	 * See {@code monaco.d.ts:3012:18}<br>
	 * Original signature:<br>
	 * {@code showUnused?: boolean; }<br>
	 */
	public IDiffEditorOptions showUnused(@Nonnull Boolean value) {
		set("showUnused", value);
		return this;
	}

 	/**
	 * <p>Enable that the editor animates scrolling to a position.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:2694:23}<br>
	 * Original signature:<br>
	 * {@code smoothScrolling?: boolean; }<br>
	 */
	public boolean smoothScrolling() { return get("smoothScrolling", ofMapped(boolean.class)); }

 	/**
	 * <p>Enable that the editor animates scrolling to a position.
	 * Defaults to false.</p>
	 * See {@code monaco.d.ts:2694:23}<br>
	 * Original signature:<br>
	 * {@code smoothScrolling?: boolean; }<br>
	 */
	public IDiffEditorOptions smoothScrolling(@Nonnull Boolean value) {
		set("smoothScrolling", value);
		return this;
	}

 	/**
	 * <p>Performance guard: Stop rendering a line after x characters.
	 * Defaults to 10000.
	 * Use -1 to never stop rendering</p>
	 * See {@code monaco.d.ts:2749:30}<br>
	 * Original signature:<br>
	 * {@code stopRenderingLineAfter?: number; }<br>
	 */
	public double stopRenderingLineAfter() { return get("stopRenderingLineAfter", ofMapped(double.class)); }

 	/**
	 * <p>Performance guard: Stop rendering a line after x characters.
	 * Defaults to 10000.
	 * Use -1 to never stop rendering</p>
	 * See {@code monaco.d.ts:2749:30}<br>
	 * Original signature:<br>
	 * {@code stopRenderingLineAfter?: number; }<br>
	 */
	public IDiffEditorOptions stopRenderingLineAfter(@Nonnull Double value) {
		set("stopRenderingLineAfter", value);
		return this;
	}

 	/**
	 * <p>Suggest options.</p>
	 * See {@code monaco.d.ts:2809:15}<br>
	 * Original signature:<br>
	 * {@code suggest?: ISuggestOptions; }<br>
	 */
	public ISuggestOptions suggest() { return get("suggest", ISuggestOptions::new); }

 	/**
	 * <p>Suggest options.</p>
	 * See {@code monaco.d.ts:2809:15}<br>
	 * Original signature:<br>
	 * {@code suggest?: ISuggestOptions; }<br>
	 */
	public IDiffEditorOptions suggest(@Nonnull ISuggestOptions value) {
		set("suggest", value);
		return this;
	}

 	/**
	 * <p>The font size for the suggest widget.
	 * Defaults to the editor font size.</p>
	 * See {@code monaco.d.ts:2902:23}<br>
	 * Original signature:<br>
	 * {@code suggestFontSize?: number; }<br>
	 */
	public double suggestFontSize() { return get("suggestFontSize", ofMapped(double.class)); }

 	/**
	 * <p>The font size for the suggest widget.
	 * Defaults to the editor font size.</p>
	 * See {@code monaco.d.ts:2902:23}<br>
	 * Original signature:<br>
	 * {@code suggestFontSize?: number; }<br>
	 */
	public IDiffEditorOptions suggestFontSize(@Nonnull Double value) {
		set("suggestFontSize", value);
		return this;
	}

 	/**
	 * <p>The line height for the suggest widget.
	 * Defaults to the editor line height.</p>
	 * See {@code monaco.d.ts:2907:25}<br>
	 * Original signature:<br>
	 * {@code suggestLineHeight?: number; }<br>
	 */
	public double suggestLineHeight() { return get("suggestLineHeight", ofMapped(double.class)); }

 	/**
	 * <p>The line height for the suggest widget.
	 * Defaults to the editor line height.</p>
	 * See {@code monaco.d.ts:2907:25}<br>
	 * Original signature:<br>
	 * {@code suggestLineHeight?: number; }<br>
	 */
	public IDiffEditorOptions suggestLineHeight(@Nonnull Double value) {
		set("suggestLineHeight", value);
		return this;
	}

 	/**
	 * <p>Enable the suggestion box to pop-up on trigger characters.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2871:34}<br>
	 * Original signature:<br>
	 * {@code suggestOnTriggerCharacters?: boolean; }<br>
	 */
	public boolean suggestOnTriggerCharacters() { return get("suggestOnTriggerCharacters", ofMapped(boolean.class)); }

 	/**
	 * <p>Enable the suggestion box to pop-up on trigger characters.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2871:34}<br>
	 * Original signature:<br>
	 * {@code suggestOnTriggerCharacters?: boolean; }<br>
	 */
	public IDiffEditorOptions suggestOnTriggerCharacters(@Nonnull Boolean value) {
		set("suggestOnTriggerCharacters", value);
		return this;
	}

 	/**
	 * <p>Inserting and deleting whitespace follows tab stops.</p>
	 * See {@code monaco.d.ts:2988:19}<br>
	 * Original signature:<br>
	 * {@code useTabStops?: boolean; }<br>
	 */
	public boolean useTabStops() { return get("useTabStops", ofMapped(boolean.class)); }

 	/**
	 * <p>Inserting and deleting whitespace follows tab stops.</p>
	 * See {@code monaco.d.ts:2988:19}<br>
	 * Original signature:<br>
	 * {@code useTabStops?: boolean; }<br>
	 */
	public IDiffEditorOptions useTabStops(@Nonnull Boolean value) {
		set("useTabStops", value);
		return this;
	}

 	/**
	 * <p>A string containing the word separators used when doing word navigation.
	 * Defaults to `~!@#$%^&amp;*()-=+[{]}\|;:'&quot;,.&lt;&gt;/?</p>
	 * See {@code monaco.d.ts:2526:22}<br>
	 * Original signature:<br>
	 * {@code wordSeparators?: string; }<br>
	 */
	public String wordSeparators() { return get("wordSeparators", ofMapped(String.class)); }

 	/**
	 * <p>A string containing the word separators used when doing word navigation.
	 * Defaults to `~!@#$%^&amp;*()-=+[{]}\|;:'&quot;,.&lt;&gt;/?</p>
	 * See {@code monaco.d.ts:2526:22}<br>
	 * Original signature:<br>
	 * {@code wordSeparators?: string; }<br>
	 */
	public IDiffEditorOptions wordSeparators(@Nonnull String value) {
		set("wordSeparators", value);
		return this;
	}

 	/**
	 * <p>Configure word wrapping characters. A break will be introduced after these characters.
	 * Defaults to ' \t})]?|/&amp;.,;¢°′″‰℃、。｡､￠，．：；？！％・･ゝゞヽヾーァィゥェォッャュョヮヵヶぁぃぅぇぉっゃゅょゎゕゖㇰㇱㇲㇳㇴㇵㇶㇷㇸㇹㇺㇻㇼㇽㇾㇿ々〻ｧｨｩｪｫｬｭｮｯｰ”〉》」』】〕）］｝｣'.</p>
	 * See {@code monaco.d.ts:2743:36}<br>
	 * Original signature:<br>
	 * {@code wordWrapBreakAfterCharacters?: string; }<br>
	 */
	public String wordWrapBreakAfterCharacters() { return get("wordWrapBreakAfterCharacters", ofMapped(String.class)); }

 	/**
	 * <p>Configure word wrapping characters. A break will be introduced after these characters.
	 * Defaults to ' \t})]?|/&amp;.,;¢°′″‰℃、。｡､￠，．：；？！％・･ゝゞヽヾーァィゥェォッャュョヮヵヶぁぃぅぇぉっゃゅょゎゕゖㇰㇱㇲㇳㇴㇵㇶㇷㇸㇹㇺㇻㇼㇽㇾㇿ々〻ｧｨｩｪｫｬｭｮｯｰ”〉》」』】〕）］｝｣'.</p>
	 * See {@code monaco.d.ts:2743:36}<br>
	 * Original signature:<br>
	 * {@code wordWrapBreakAfterCharacters?: string; }<br>
	 */
	public IDiffEditorOptions wordWrapBreakAfterCharacters(@Nonnull String value) {
		set("wordWrapBreakAfterCharacters", value);
		return this;
	}

 	/**
	 * <p>Configure word wrapping characters. A break will be introduced before these characters.
	 * Defaults to '([{‘“〈《「『【〔（［｛｢£¥＄￡￥+＋'.</p>
	 * See {@code monaco.d.ts:2738:37}<br>
	 * Original signature:<br>
	 * {@code wordWrapBreakBeforeCharacters?: string; }<br>
	 */
	public String wordWrapBreakBeforeCharacters() { return get("wordWrapBreakBeforeCharacters", ofMapped(String.class)); }

 	/**
	 * <p>Configure word wrapping characters. A break will be introduced before these characters.
	 * Defaults to '([{‘“〈《「『【〔（［｛｢£¥＄￡￥+＋'.</p>
	 * See {@code monaco.d.ts:2738:37}<br>
	 * Original signature:<br>
	 * {@code wordWrapBreakBeforeCharacters?: string; }<br>
	 */
	public IDiffEditorOptions wordWrapBreakBeforeCharacters(@Nonnull String value) {
		set("wordWrapBreakBeforeCharacters", value);
		return this;
	}

 	/**
	 * <p>Control the wrapping of the editor.
	 * When <code>wordWrap</code> = &quot;off&quot;, the lines will never wrap.
	 * When <code>wordWrap</code> = &quot;on&quot;, the lines will wrap at the viewport width.
	 * When <code>wordWrap</code> = &quot;wordWrapColumn&quot;, the lines will wrap at <code>wordWrapColumn</code>.
	 * When <code>wordWrap</code> = &quot;bounded&quot;, the lines will wrap at min(viewport width, wordWrapColumn).
	 * Defaults to 80.</p>
	 * See {@code monaco.d.ts:2718:22}<br>
	 * Original signature:<br>
	 * {@code wordWrapColumn?: number; }<br>
	 */
	public double wordWrapColumn() { return get("wordWrapColumn", ofMapped(double.class)); }

 	/**
	 * <p>Control the wrapping of the editor.
	 * When <code>wordWrap</code> = &quot;off&quot;, the lines will never wrap.
	 * When <code>wordWrap</code> = &quot;on&quot;, the lines will wrap at the viewport width.
	 * When <code>wordWrap</code> = &quot;wordWrapColumn&quot;, the lines will wrap at <code>wordWrapColumn</code>.
	 * When <code>wordWrap</code> = &quot;bounded&quot;, the lines will wrap at min(viewport width, wordWrapColumn).
	 * Defaults to 80.</p>
	 * See {@code monaco.d.ts:2718:22}<br>
	 * Original signature:<br>
	 * {@code wordWrapColumn?: number; }<br>
	 */
	public IDiffEditorOptions wordWrapColumn(@Nonnull Double value) {
		set("wordWrapColumn", value);
		return this;
	}

 	/**
	 * <p>Force word wrapping when the text appears to be of a minified/generated file.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2723:24}<br>
	 * Original signature:<br>
	 * {@code wordWrapMinified?: boolean; }<br>
	 */
	public boolean wordWrapMinified() { return get("wordWrapMinified", ofMapped(boolean.class)); }

 	/**
	 * <p>Force word wrapping when the text appears to be of a minified/generated file.
	 * Defaults to true.</p>
	 * See {@code monaco.d.ts:2723:24}<br>
	 * Original signature:<br>
	 * {@code wordWrapMinified?: boolean; }<br>
	 */
	public IDiffEditorOptions wordWrapMinified(@Nonnull Boolean value) {
		set("wordWrapMinified", value);
		return this;
	}

 
}
