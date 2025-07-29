
package monaco_editor.monaco.editor;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>A line change</p>
 * See {@code monaco.d.ts:2024:32}<br>
 * Original signature:<br>
 * {@code export interface ILineChange extends IChange  }<br>
 */
@SuppressWarnings("unused")
public class ILineChange extends IChange {

	public ILineChange(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public ILineChange(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:2025:28}<br>
	 * Original signature:<br>
	 * {@code readonly charChanges: ICharChange[] | undefined; }<br>
	 */
	public Optional<List<ICharChange>> charChanges() { return Optional.ofNullable(get("charChanges", ofArray(ICharChange::new))); }

 	/**
	 * See {@code monaco.d.ts:2008:38}<br>
	 * Original signature:<br>
	 * {@code readonly modifiedEndLineNumber: number; }<br>
	 */
	public double modifiedEndLineNumber() { return get("modifiedEndLineNumber", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:2007:40}<br>
	 * Original signature:<br>
	 * {@code readonly modifiedStartLineNumber: number; }<br>
	 */
	public double modifiedStartLineNumber() { return get("modifiedStartLineNumber", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:2006:38}<br>
	 * Original signature:<br>
	 * {@code readonly originalEndLineNumber: number; }<br>
	 */
	public double originalEndLineNumber() { return get("originalEndLineNumber", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:2005:40}<br>
	 * Original signature:<br>
	 * {@code readonly originalStartLineNumber: number; }<br>
	 */
	public double originalStartLineNumber() { return get("originalStartLineNumber", ofMapped(double.class)); }

 
}
