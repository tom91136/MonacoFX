
package monaco_editor.monaco.editor;
import java.util.Optional;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:1176:32}<br>
 * Original signature:<br>
 * {@code export interface IContextKey<T>  }<br>
 */
@SuppressWarnings("unused")
public class IContextKey <T> extends JsProxy {

	public IContextKey(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IContextKey(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:1179:11}<br>
	 * Original signature:<br>
	 * {@code get(): T | undefined; }<br>
	 */
	public Optional<T> get() { return Optional.ofNullable(call("get", null )); }

 	/**
	 * See {@code monaco.d.ts:1178:13}<br>
	 * Original signature:<br>
	 * {@code reset(): void; }<br>
	 */
	public void reset() { call("reset", ofVoid()); }

 	/**
	 * See {@code monaco.d.ts:1177:11}<br>
	 * Original signature:<br>
	 * {@code set(value: T): void; }<br>
	 */
	public void set(@Nonnull T value) { call("set", ofVoid(), value); }

 
}
