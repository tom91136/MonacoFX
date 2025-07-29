
package monaco_editor.monaco.editor;
import java.util.Optional;
import javax.annotation.Nonnull;
import monaco_editor.monaco.IDisposable;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:1158:42}<br>
 * Original signature:<br>
 * {@code export interface IStandaloneCodeEditor extends ICodeEditor  }<br>
 */
@SuppressWarnings("unused")
public class IStandaloneCodeEditor extends ICodeEditor {

	public IStandaloneCodeEditor(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IStandaloneCodeEditor(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:1162:17}<br>
	 * Original signature:<br>
	 * {@code addAction(descriptor: IActionDescriptor): IDisposable; }<br>
	 */
	public IDisposable addAction(@Nonnull IActionDescriptor descriptor) { return call("addAction", IDisposable::new, descriptor); }

 	/**
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:1160:18}<br>
	 * Original signature:<br>
	 * {@code addCommand(keybinding: number, handler: ICommandHandler, context?: string): string | null; }<br>
	 */
	public Optional<String> addCommand(@Nonnull Double keybinding, @Nonnull ICommandHandler handler) { return Optional.ofNullable(call("addCommand", ofMapped(String.class), keybinding, handler)); }

 	/**
	 * See {@code monaco.d.ts:1160:18}<br>
	 * Original signature:<br>
	 * {@code addCommand(keybinding: number, handler: ICommandHandler, context?: string): string | null; }<br>
	 */
	public Optional<String> addCommand(@Nonnull Double keybinding, @Nonnull ICommandHandler handler, @Nonnull String context) { return Optional.ofNullable(call("addCommand", ofMapped(String.class), keybinding, handler, context)); }

 	/**
	 * See {@code monaco.d.ts:1161:24}<br>
	 * Original signature:<br>
	 * {@code createContextKey<T>(key: string, defaultValue: T): IContextKey<T>; }<br>
	 */
	public <T> IContextKey<T> createContextKey(@Nonnull String key, @Nonnull T defaultValue) { return call("createContextKey", IContextKey ::new, key, defaultValue); }

 	/**
	 * See {@code monaco.d.ts:1159:21}<br>
	 * Original signature:<br>
	 * {@code updateOptions(newOptions: IEditorOptions & IGlobalEditorOptions): void; }<br>
	 */
	public void updateOptions_(@Nonnull IGlobalEditorOptions newOptions) { call("updateOptions", ofVoid(), newOptions); }

 	/**
	 * See {@code monaco.d.ts:1159:21}<br>
	 * Original signature:<br>
	 * {@code updateOptions(newOptions: IEditorOptions & IGlobalEditorOptions): void; }<br>
	 */
	public void updateOptions_(@Nonnull IEditorOptions newOptions) { call("updateOptions", ofVoid(), newOptions); }

 
}
