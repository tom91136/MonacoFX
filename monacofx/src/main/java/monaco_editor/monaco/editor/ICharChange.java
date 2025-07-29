
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>A character level change.</p>
 * See {@code monaco.d.ts:2014:32}<br>
 * Original signature:<br>
 * {@code export interface ICharChange extends IChange  }<br>
 */
@SuppressWarnings("unused")
public class ICharChange extends IChange {

	public ICharChange(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public ICharChange(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:2018:34}<br>
	 * Original signature:<br>
	 * {@code readonly modifiedEndColumn: number; }<br>
	 */
	public double modifiedEndColumn() { return get("modifiedEndColumn", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:2008:38}<br>
	 * Original signature:<br>
	 * {@code readonly modifiedEndLineNumber: number; }<br>
	 */
	public double modifiedEndLineNumber() { return get("modifiedEndLineNumber", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:2017:36}<br>
	 * Original signature:<br>
	 * {@code readonly modifiedStartColumn: number; }<br>
	 */
	public double modifiedStartColumn() { return get("modifiedStartColumn", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:2007:40}<br>
	 * Original signature:<br>
	 * {@code readonly modifiedStartLineNumber: number; }<br>
	 */
	public double modifiedStartLineNumber() { return get("modifiedStartLineNumber", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:2016:34}<br>
	 * Original signature:<br>
	 * {@code readonly originalEndColumn: number; }<br>
	 */
	public double originalEndColumn() { return get("originalEndColumn", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:2006:38}<br>
	 * Original signature:<br>
	 * {@code readonly originalEndLineNumber: number; }<br>
	 */
	public double originalEndLineNumber() { return get("originalEndLineNumber", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:2015:36}<br>
	 * Original signature:<br>
	 * {@code readonly originalStartColumn: number; }<br>
	 */
	public double originalStartColumn() { return get("originalStartColumn", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:2005:40}<br>
	 * Original signature:<br>
	 * {@code readonly originalStartLineNumber: number; }<br>
	 */
	public double originalStartLineNumber() { return get("originalStartLineNumber", ofMapped(double.class)); }

 
}
