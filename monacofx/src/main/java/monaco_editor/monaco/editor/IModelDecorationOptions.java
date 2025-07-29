
package monaco_editor.monaco.editor;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import monaco_editor.monaco.IMarkdownString;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import net.kurobako.monacofx.js.JsUnion2;

/**
 * <p>Options for a model decoration.</p>
 * See {@code monaco.d.ts:1308:44}<br>
 * Original signature:<br>
 * {@code export interface IModelDecorationOptions  }<br>
 */
@SuppressWarnings("unused")
public class IModelDecorationOptions extends JsProxy {

	public IModelDecorationOptions(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IModelDecorationOptions(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>If set, the decoration will be rendered after the text with this CSS class name.</p>
	 * See {@code monaco.d.ts:1372:29}<br>
	 * Original signature:<br>
	 * {@code afterContentClassName?: string | null; }<br>
	 */
	public Optional<String> afterContentClassName() { return Optional.ofNullable(get("afterContentClassName", ofMapped(String.class))); }

 	/**
	 * <p>If set, the decoration will be rendered after the text with this CSS class name.</p>
	 * See {@code monaco.d.ts:1372:29}<br>
	 * Original signature:<br>
	 * {@code afterContentClassName?: string | null; }<br>
	 */
	public IModelDecorationOptions afterContentClassName(@Nullable String value) {
		set("afterContentClassName", value);
		return this;
	}

 	/**
	 * <p>If set, the decoration will be rendered before the text with this CSS class name.</p>
	 * See {@code monaco.d.ts:1368:30}<br>
	 * Original signature:<br>
	 * {@code beforeContentClassName?: string | null; }<br>
	 */
	public Optional<String> beforeContentClassName() { return Optional.ofNullable(get("beforeContentClassName", ofMapped(String.class))); }

 	/**
	 * <p>If set, the decoration will be rendered before the text with this CSS class name.</p>
	 * See {@code monaco.d.ts:1368:30}<br>
	 * Original signature:<br>
	 * {@code beforeContentClassName?: string | null; }<br>
	 */
	public IModelDecorationOptions beforeContentClassName(@Nullable String value) {
		set("beforeContentClassName", value);
		return this;
	}

 	/**
	 * <p>CSS class name describing the decoration.</p>
	 * See {@code monaco.d.ts:1317:17}<br>
	 * Original signature:<br>
	 * {@code className?: string | null; }<br>
	 */
	public Optional<String> className() { return Optional.ofNullable(get("className", ofMapped(String.class))); }

 	/**
	 * <p>CSS class name describing the decoration.</p>
	 * See {@code monaco.d.ts:1317:17}<br>
	 * Original signature:<br>
	 * {@code className?: string | null; }<br>
	 */
	public IModelDecorationOptions className(@Nullable String value) {
		set("className", value);
		return this;
	}

 	/**
	 * <p>If set, the decoration will be rendered in the glyph margin with this CSS class name.</p>
	 * See {@code monaco.d.ts:1346:28}<br>
	 * Original signature:<br>
	 * {@code glyphMarginClassName?: string | null; }<br>
	 */
	public Optional<String> glyphMarginClassName() { return Optional.ofNullable(get("glyphMarginClassName", ofMapped(String.class))); }

 	/**
	 * <p>If set, the decoration will be rendered in the glyph margin with this CSS class name.</p>
	 * See {@code monaco.d.ts:1346:28}<br>
	 * Original signature:<br>
	 * {@code glyphMarginClassName?: string | null; }<br>
	 */
	public IModelDecorationOptions glyphMarginClassName(@Nullable String value) {
		set("glyphMarginClassName", value);
		return this;
	}

 	/**
	 * <p>Message to be rendered when hovering over the glyph margin decoration.</p>
	 * See {@code monaco.d.ts:1321:31}<br>
	 * Original signature:<br>
	 * {@code glyphMarginHoverMessage?: IMarkdownString | IMarkdownString[] | null; }<br>
	 */
	public Optional<JsUnion2<IMarkdownString, List<IMarkdownString>>> glyphMarginHoverMessage() { return Optional.ofNullable(get("glyphMarginHoverMessage", null /*union*/)); }

 	/**
	 * <p>Message to be rendered when hovering over the glyph margin decoration.</p>
	 * See {@code monaco.d.ts:1321:31}<br>
	 * Original signature:<br>
	 * {@code glyphMarginHoverMessage?: IMarkdownString | IMarkdownString[] | null; }<br>
	 */
	public IModelDecorationOptions glyphMarginHoverMessage(@Nullable IMarkdownString value) {
		set("glyphMarginHoverMessage", value);
		return this;
	}

 	/**
	 * <p>Message to be rendered when hovering over the glyph margin decoration.</p>
	 * See {@code monaco.d.ts:1321:31}<br>
	 * Original signature:<br>
	 * {@code glyphMarginHoverMessage?: IMarkdownString | IMarkdownString[] | null; }<br>
	 */
	public IModelDecorationOptions glyphMarginHoverMessage(@Nullable List<IMarkdownString> value) {
		
		return this;
	}

 	/**
	 * <p>Array of MarkdownString to render as the decoration message.</p>
	 * See {@code monaco.d.ts:1325:20}<br>
	 * Original signature:<br>
	 * {@code hoverMessage?: IMarkdownString | IMarkdownString[] | null; }<br>
	 */
	public Optional<JsUnion2<IMarkdownString, List<IMarkdownString>>> hoverMessage() { return Optional.ofNullable(get("hoverMessage", null /*union*/)); }

 	/**
	 * <p>Array of MarkdownString to render as the decoration message.</p>
	 * See {@code monaco.d.ts:1325:20}<br>
	 * Original signature:<br>
	 * {@code hoverMessage?: IMarkdownString | IMarkdownString[] | null; }<br>
	 */
	public IModelDecorationOptions hoverMessage(@Nullable IMarkdownString value) {
		set("hoverMessage", value);
		return this;
	}

 	/**
	 * <p>Array of MarkdownString to render as the decoration message.</p>
	 * See {@code monaco.d.ts:1325:20}<br>
	 * Original signature:<br>
	 * {@code hoverMessage?: IMarkdownString | IMarkdownString[] | null; }<br>
	 */
	public IModelDecorationOptions hoverMessage(@Nullable List<IMarkdownString> value) {
		
		return this;
	}

 	/**
	 * <p>If set, the decoration will be rendered inline with the text with this CSS class name.
	 * Please use this only for CSS rules that must impact the text. For example, use <code>className</code>
	 * to have a background color decoration.</p>
	 * See {@code monaco.d.ts:1360:23}<br>
	 * Original signature:<br>
	 * {@code inlineClassName?: string | null; }<br>
	 */
	public Optional<String> inlineClassName() { return Optional.ofNullable(get("inlineClassName", ofMapped(String.class))); }

 	/**
	 * <p>If set, the decoration will be rendered inline with the text with this CSS class name.
	 * Please use this only for CSS rules that must impact the text. For example, use <code>className</code>
	 * to have a background color decoration.</p>
	 * See {@code monaco.d.ts:1360:23}<br>
	 * Original signature:<br>
	 * {@code inlineClassName?: string | null; }<br>
	 */
	public IModelDecorationOptions inlineClassName(@Nullable String value) {
		set("inlineClassName", value);
		return this;
	}

 	/**
	 * <p>If there is an <code>inlineClassName</code> which affects letter spacing.</p>
	 * See {@code monaco.d.ts:1364:43}<br>
	 * Original signature:<br>
	 * {@code inlineClassNameAffectsLetterSpacing?: boolean; }<br>
	 */
	public boolean inlineClassNameAffectsLetterSpacing() { return get("inlineClassNameAffectsLetterSpacing", ofMapped(boolean.class)); }

 	/**
	 * <p>If there is an <code>inlineClassName</code> which affects letter spacing.</p>
	 * See {@code monaco.d.ts:1364:43}<br>
	 * Original signature:<br>
	 * {@code inlineClassNameAffectsLetterSpacing?: boolean; }<br>
	 */
	public IModelDecorationOptions inlineClassNameAffectsLetterSpacing(@Nonnull Boolean value) {
		set("inlineClassNameAffectsLetterSpacing", value);
		return this;
	}

 	/**
	 * <p>Should the decoration expand to encompass a whole line.</p>
	 * See {@code monaco.d.ts:1329:19}<br>
	 * Original signature:<br>
	 * {@code isWholeLine?: boolean; }<br>
	 */
	public boolean isWholeLine() { return get("isWholeLine", ofMapped(boolean.class)); }

 	/**
	 * <p>Should the decoration expand to encompass a whole line.</p>
	 * See {@code monaco.d.ts:1329:19}<br>
	 * Original signature:<br>
	 * {@code isWholeLine?: boolean; }<br>
	 */
	public IModelDecorationOptions isWholeLine(@Nonnull Boolean value) {
		set("isWholeLine", value);
		return this;
	}

 	/**
	 * <p>If set, the decoration will be rendered in the lines decorations with this CSS class name.</p>
	 * See {@code monaco.d.ts:1350:33}<br>
	 * Original signature:<br>
	 * {@code linesDecorationsClassName?: string | null; }<br>
	 */
	public Optional<String> linesDecorationsClassName() { return Optional.ofNullable(get("linesDecorationsClassName", ofMapped(String.class))); }

 	/**
	 * <p>If set, the decoration will be rendered in the lines decorations with this CSS class name.</p>
	 * See {@code monaco.d.ts:1350:33}<br>
	 * Original signature:<br>
	 * {@code linesDecorationsClassName?: string | null; }<br>
	 */
	public IModelDecorationOptions linesDecorationsClassName(@Nullable String value) {
		set("linesDecorationsClassName", value);
		return this;
	}

 	/**
	 * <p>If set, the decoration will be rendered in the margin (covering its full width) with this CSS class name.</p>
	 * See {@code monaco.d.ts:1354:23}<br>
	 * Original signature:<br>
	 * {@code marginClassName?: string | null; }<br>
	 */
	public Optional<String> marginClassName() { return Optional.ofNullable(get("marginClassName", ofMapped(String.class))); }

 	/**
	 * <p>If set, the decoration will be rendered in the margin (covering its full width) with this CSS class name.</p>
	 * See {@code monaco.d.ts:1354:23}<br>
	 * Original signature:<br>
	 * {@code marginClassName?: string | null; }<br>
	 */
	public IModelDecorationOptions marginClassName(@Nullable String value) {
		set("marginClassName", value);
		return this;
	}

 	/**
	 * <p>If set, render this decoration in the minimap.</p>
	 * See {@code monaco.d.ts:1342:15}<br>
	 * Original signature:<br>
	 * {@code minimap?: IModelDecorationMinimapOptions | null; }<br>
	 */
	public Optional<IModelDecorationMinimapOptions> minimap() { return Optional.ofNullable(get("minimap", IModelDecorationMinimapOptions::new)); }

 	/**
	 * <p>If set, render this decoration in the minimap.</p>
	 * See {@code monaco.d.ts:1342:15}<br>
	 * Original signature:<br>
	 * {@code minimap?: IModelDecorationMinimapOptions | null; }<br>
	 */
	public IModelDecorationOptions minimap(@Nullable IModelDecorationMinimapOptions value) {
		set("minimap", value);
		return this;
	}

 	/**
	 * <p>If set, render this decoration in the overview ruler.</p>
	 * See {@code monaco.d.ts:1338:21}<br>
	 * Original signature:<br>
	 * {@code overviewRuler?: IModelDecorationOverviewRulerOptions | null; }<br>
	 */
	public Optional<IModelDecorationOverviewRulerOptions> overviewRuler() { return Optional.ofNullable(get("overviewRuler", IModelDecorationOverviewRulerOptions::new)); }

 	/**
	 * <p>If set, render this decoration in the overview ruler.</p>
	 * See {@code monaco.d.ts:1338:21}<br>
	 * Original signature:<br>
	 * {@code overviewRuler?: IModelDecorationOverviewRulerOptions | null; }<br>
	 */
	public IModelDecorationOptions overviewRuler(@Nullable IModelDecorationOverviewRulerOptions value) {
		set("overviewRuler", value);
		return this;
	}

 	/**
	 * <p>Customize the growing behavior of the decoration when typing at the edges of the decoration.
	 * Defaults to TrackedRangeStickiness.AlwaysGrowsWhenTypingAtEdges</p>
	 * See {@code monaco.d.ts:1313:18}<br>
	 * Original signature:<br>
	 * {@code stickiness?: TrackedRangeStickiness; }<br>
	 */
	public TrackedRangeStickiness stickiness() { return get("stickiness", ofJsEnum(TrackedRangeStickiness.class)); }

 	/**
	 * <p>Customize the growing behavior of the decoration when typing at the edges of the decoration.
	 * Defaults to TrackedRangeStickiness.AlwaysGrowsWhenTypingAtEdges</p>
	 * See {@code monaco.d.ts:1313:18}<br>
	 * Original signature:<br>
	 * {@code stickiness?: TrackedRangeStickiness; }<br>
	 */
	public IModelDecorationOptions stickiness(@Nonnull TrackedRangeStickiness value) {
		set("stickiness", value);
		return this;
	}

 	/**
	 * <p>Specifies the stack order of a decoration.
	 * A decoration with greater stack order is always in front of a decoration with a lower stack order.</p>
	 * See {@code monaco.d.ts:1334:14}<br>
	 * Original signature:<br>
	 * {@code zIndex?: number; }<br>
	 */
	public double zIndex() { return get("zIndex", ofMapped(double.class)); }

 	/**
	 * <p>Specifies the stack order of a decoration.
	 * A decoration with greater stack order is always in front of a decoration with a lower stack order.</p>
	 * See {@code monaco.d.ts:1334:14}<br>
	 * Original signature:<br>
	 * {@code zIndex?: number; }<br>
	 */
	public IModelDecorationOptions zIndex(@Nonnull Double value) {
		set("zIndex", value);
		return this;
	}

 
}
