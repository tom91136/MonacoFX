
package monaco_editor.monaco.editor;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import net.kurobako.monacofx.js.JsUnion2;

/**
 * <p>Options for rendering a model decoration in the overview ruler.</p>
 * See {@code monaco.d.ts:1298:51}<br>
 * Original signature:<br>
 * {@code export interface IModelDecorationMinimapOptions extends IDecorationOptions  }<br>
 */
@SuppressWarnings("unused")
public class IModelDecorationMinimapOptions extends IDecorationOptions {

	public IModelDecorationMinimapOptions(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IModelDecorationMinimapOptions(@Nonnull JsContext context) { super(context); }

 
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
	public IModelDecorationMinimapOptions color(@Nullable String value) {
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
	public IModelDecorationMinimapOptions color(@Nullable ThemeColor value) {
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
	public IModelDecorationMinimapOptions darkColor(@Nonnull String value) {
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
	public IModelDecorationMinimapOptions darkColor(@Nonnull ThemeColor value) {
		set("darkColor", value);
		return this;
	}

 	/**
	 * <p>The position in the overview ruler.</p>
	 * See {@code monaco.d.ts:1302:16}<br>
	 * Original signature:<br>
	 * {@code position: MinimapPosition; }<br>
	 */
	public MinimapPosition position() { return get("position", ofJsEnum(MinimapPosition.class)); }

 	/**
	 * <p>The position in the overview ruler.</p>
	 * See {@code monaco.d.ts:1302:16}<br>
	 * Original signature:<br>
	 * {@code position: MinimapPosition; }<br>
	 */
	public IModelDecorationMinimapOptions position(@Nonnull MinimapPosition value) {
		set("position", value);
		return this;
	}

 
}
