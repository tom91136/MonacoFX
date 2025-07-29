
package monaco_editor.monaco.editor;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import net.kurobako.monacofx.js.JsUnion2;

/**
 * <p>Options for rendering a model decoration in the overview ruler.</p>
 * See {@code monaco.d.ts:1288:57}<br>
 * Original signature:<br>
 * {@code export interface IModelDecorationOverviewRulerOptions extends IDecorationOptions  }<br>
 */
@SuppressWarnings("unused")
public class IModelDecorationOverviewRulerOptions extends IDecorationOptions {

	public IModelDecorationOverviewRulerOptions(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IModelDecorationOverviewRulerOptions(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>CSS color to render.
	 * e.g.: rgba(100, 100, 100, 0.5) or a color from the color registry</p>
	 * See {@code monaco.d.ts:1277:13}<br>
	 * Original signature:<br>
	 * {@code color: string | ThemeColor | undefined; }<br>
	 */
	public Optional<JsUnion2<String, ThemeColor>> color() { return Optional.ofNullable(get("color", null /*union*/)); }

 	/**
	 * <p>CSS color to render.
	 * e.g.: rgba(100, 100, 100, 0.5) or a color from the color registry</p>
	 * See {@code monaco.d.ts:1277:13}<br>
	 * Original signature:<br>
	 * {@code color: string | ThemeColor | undefined; }<br>
	 */
	public IModelDecorationOverviewRulerOptions color(@Nullable String value) {
		set("color", value);
		return this;
	}

 	/**
	 * <p>CSS color to render.
	 * e.g.: rgba(100, 100, 100, 0.5) or a color from the color registry</p>
	 * See {@code monaco.d.ts:1277:13}<br>
	 * Original signature:<br>
	 * {@code color: string | ThemeColor | undefined; }<br>
	 */
	public IModelDecorationOverviewRulerOptions color(@Nullable ThemeColor value) {
		set("color", value);
		return this;
	}

 	/**
	 * <p>CSS color to render.
	 * e.g.: rgba(100, 100, 100, 0.5) or a color from the color registry</p>
	 * See {@code monaco.d.ts:1282:17}<br>
	 * Original signature:<br>
	 * {@code darkColor?: string | ThemeColor; }<br>
	 */
	public Optional<JsUnion2<String, ThemeColor>> darkColor() { return Optional.ofNullable(get("darkColor", null /*union*/)); }

 	/**
	 * <p>CSS color to render.
	 * e.g.: rgba(100, 100, 100, 0.5) or a color from the color registry</p>
	 * See {@code monaco.d.ts:1282:17}<br>
	 * Original signature:<br>
	 * {@code darkColor?: string | ThemeColor; }<br>
	 */
	public IModelDecorationOverviewRulerOptions darkColor(@Nonnull String value) {
		set("darkColor", value);
		return this;
	}

 	/**
	 * <p>CSS color to render.
	 * e.g.: rgba(100, 100, 100, 0.5) or a color from the color registry</p>
	 * See {@code monaco.d.ts:1282:17}<br>
	 * Original signature:<br>
	 * {@code darkColor?: string | ThemeColor; }<br>
	 */
	public IModelDecorationOverviewRulerOptions darkColor(@Nonnull ThemeColor value) {
		set("darkColor", value);
		return this;
	}

 	/**
	 * <p>The position in the overview ruler.</p>
	 * See {@code monaco.d.ts:1292:16}<br>
	 * Original signature:<br>
	 * {@code position: OverviewRulerLane; }<br>
	 */
	public OverviewRulerLane position() { return get("position", ofJsEnum(OverviewRulerLane.class)); }

 	/**
	 * <p>The position in the overview ruler.</p>
	 * See {@code monaco.d.ts:1292:16}<br>
	 * Original signature:<br>
	 * {@code position: OverviewRulerLane; }<br>
	 */
	public IModelDecorationOverviewRulerOptions position(@Nonnull OverviewRulerLane value) {
		set("position", value);
		return this;
	}

 
}
