
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>Describes a rule to be evaluated when pressing Enter.</p>
 * See {@code monaco.d.ts:5036:32}<br>
 * Original signature:<br>
 * {@code export interface OnEnterRule  }<br>
 */
@SuppressWarnings("unused")
public class OnEnterRule extends JsProxy {

	public OnEnterRule(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public OnEnterRule(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>The action to execute.</p>
	 * See {@code monaco.d.ts:5052:14}<br>
	 * Original signature:<br>
	 * {@code action: EnterAction; }<br>
	 */
	public EnterAction action() { return get("action", EnterAction::new); }

 	/**
	 * <p>The action to execute.</p>
	 * See {@code monaco.d.ts:5052:14}<br>
	 * Original signature:<br>
	 * {@code action: EnterAction; }<br>
	 */
	public OnEnterRule action(@Nonnull EnterAction value) {
		set("action", value);
		return this;
	}

 	/**
	 * <p>This rule will only execute if the text after the cursor matches this regular expression.</p>
	 * See {@code monaco.d.ts:5044:17}<br>
	 * Original signature:<br>
	 * {@code afterText?: RegExp; }<br>
	 */
	public String afterText() { return get("afterText", ofMapped(String.class)); }

 	/**
	 * <p>This rule will only execute if the text after the cursor matches this regular expression.</p>
	 * See {@code monaco.d.ts:5044:17}<br>
	 * Original signature:<br>
	 * {@code afterText?: RegExp; }<br>
	 */
	public OnEnterRule afterText(@Nonnull String value) {
		set("afterText", value);
		return this;
	}

 	/**
	 * <p>This rule will only execute if the text before the cursor matches this regular expression.</p>
	 * See {@code monaco.d.ts:5040:18}<br>
	 * Original signature:<br>
	 * {@code beforeText: RegExp; }<br>
	 */
	public String beforeText() { return get("beforeText", ofMapped(String.class)); }

 	/**
	 * <p>This rule will only execute if the text before the cursor matches this regular expression.</p>
	 * See {@code monaco.d.ts:5040:18}<br>
	 * Original signature:<br>
	 * {@code beforeText: RegExp; }<br>
	 */
	public OnEnterRule beforeText(@Nonnull String value) {
		set("beforeText", value);
		return this;
	}

 	/**
	 * <p>This rule will only execute if the text above the this line matches this regular expression.</p>
	 * See {@code monaco.d.ts:5048:24}<br>
	 * Original signature:<br>
	 * {@code oneLineAboveText?: RegExp; }<br>
	 */
	public String oneLineAboveText() { return get("oneLineAboveText", ofMapped(String.class)); }

 	/**
	 * <p>This rule will only execute if the text above the this line matches this regular expression.</p>
	 * See {@code monaco.d.ts:5048:24}<br>
	 * Original signature:<br>
	 * {@code oneLineAboveText?: RegExp; }<br>
	 */
	public OnEnterRule oneLineAboveText(@Nonnull String value) {
		set("oneLineAboveText", value);
		return this;
	}

 
}
