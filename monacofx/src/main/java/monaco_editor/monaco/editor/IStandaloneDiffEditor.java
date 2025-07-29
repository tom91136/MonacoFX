
package monaco_editor.monaco.editor;
import java.util.Optional;
import javax.annotation.Nonnull;
import monaco_editor.monaco.IDisposable;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:1165:42}<br>
 * Original signature:<br>
 * {@code export interface IStandaloneDiffEditor extends IDiffEditor  }<br>
 */
@SuppressWarnings("unused")
public class IStandaloneDiffEditor extends IDiffEditor {

	public IStandaloneDiffEditor(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IStandaloneDiffEditor(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:1168:17}<br>
	 * Original signature:<br>
	 * {@code addAction(descriptor: IActionDescriptor): IDisposable; }<br>
	 */
	public IDisposable addAction(@Nonnull IActionDescriptor descriptor) { return call("addAction", IDisposable::new, descriptor); }

 	/**
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:1166:18}<br>
	 * Original signature:<br>
	 * {@code addCommand(keybinding: number, handler: ICommandHandler, context?: string): string | null; }<br>
	 */
	public Optional<String> addCommand(@Nonnull Double keybinding, @Nonnull ICommandHandler handler) { return Optional.ofNullable(call("addCommand", ofMapped(String.class), keybinding, handler)); }

 	/**
	 * See {@code monaco.d.ts:1166:18}<br>
	 * Original signature:<br>
	 * {@code addCommand(keybinding: number, handler: ICommandHandler, context?: string): string | null; }<br>
	 */
	public Optional<String> addCommand(@Nonnull Double keybinding, @Nonnull ICommandHandler handler, @Nonnull String context) { return Optional.ofNullable(call("addCommand", ofMapped(String.class), keybinding, handler, context)); }

 	/**
	 * See {@code monaco.d.ts:1167:24}<br>
	 * Original signature:<br>
	 * {@code createContextKey<T>(key: string, defaultValue: T): IContextKey<T>; }<br>
	 */
	public <T> IContextKey<T> createContextKey(@Nonnull String key, @Nonnull T defaultValue) { return call("createContextKey", IContextKey ::new, key, defaultValue); }

 	/**
	 * See {@code monaco.d.ts:1170:25}<br>
	 * Original signature:<br>
	 * {@code getModifiedEditor(): IStandaloneCodeEditor; }<br>
	 */
	public IStandaloneCodeEditor getModifiedEditor_() { return call("getModifiedEditor", IStandaloneCodeEditor::new); }

 	/**
	 * See {@code monaco.d.ts:1169:25}<br>
	 * Original signature:<br>
	 * {@code getOriginalEditor(): IStandaloneCodeEditor; }<br>
	 */
	public IStandaloneCodeEditor getOriginalEditor_() { return call("getOriginalEditor", IStandaloneCodeEditor::new); }

 
}
