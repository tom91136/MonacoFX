
package monaco_editor.monaco.languages;
import java.util.List;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:5080:48}<br>
 * Original signature:<br>
 * {@code export interface IAutoClosingPairConditional extends IAutoClosingPair  }<br>
 */
@SuppressWarnings("unused")
public class IAutoClosingPairConditional extends IAutoClosingPair {

	public IAutoClosingPairConditional(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IAutoClosingPairConditional(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5077:13}<br>
	 * Original signature:<br>
	 * {@code close: string; }<br>
	 */
	public String close() { return get("close", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:5077:13}<br>
	 * Original signature:<br>
	 * {@code close: string; }<br>
	 */
	public IAutoClosingPairConditional close(@Nonnull String value) {
		set("close", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5081:13}<br>
	 * Original signature:<br>
	 * {@code notIn?: string[]; }<br>
	 */
	public List<String> notIn() { return get("notIn", ofArray(ofMapped(String.class))); }

 	/**
	 * See {@code monaco.d.ts:5081:13}<br>
	 * Original signature:<br>
	 * {@code notIn?: string[]; }<br>
	 */
	public IAutoClosingPairConditional notIn(@Nonnull List<String> value) {
		
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5076:12}<br>
	 * Original signature:<br>
	 * {@code open: string; }<br>
	 */
	public String open() { return get("open", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:5076:12}<br>
	 * Original signature:<br>
	 * {@code open: string; }<br>
	 */
	public IAutoClosingPairConditional open(@Nonnull String value) {
		set("open", value);
		return this;
	}

 
}
