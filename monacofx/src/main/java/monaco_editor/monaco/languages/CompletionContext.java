
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>Contains additional information about the context in which
 * <a href="#CompletionItemProvider.provideCompletionItems">completion provider</a> is triggered.</p>
 * See {@code monaco.d.ts:5347:38}<br>
 * Original signature:<br>
 * {@code export interface CompletionContext  }<br>
 */
@SuppressWarnings("unused")
public class CompletionContext extends JsProxy {

	public CompletionContext(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public CompletionContext(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Character that triggered the completion item provider.
	 * <code>undefined</code> if provider was not triggered by a character.</p>
	 * See {@code monaco.d.ts:5357:24}<br>
	 * Original signature:<br>
	 * {@code triggerCharacter?: string; }<br>
	 */
	public String triggerCharacter() { return get("triggerCharacter", ofMapped(String.class)); }

 	/**
	 * <p>Character that triggered the completion item provider.
	 * <code>undefined</code> if provider was not triggered by a character.</p>
	 * See {@code monaco.d.ts:5357:24}<br>
	 * Original signature:<br>
	 * {@code triggerCharacter?: string; }<br>
	 */
	public CompletionContext triggerCharacter(@Nonnull String value) {
		set("triggerCharacter", value);
		return this;
	}

 	/**
	 * <p>How the completion was triggered.</p>
	 * See {@code monaco.d.ts:5351:19}<br>
	 * Original signature:<br>
	 * {@code triggerKind: CompletionTriggerKind; }<br>
	 */
	public CompletionTriggerKind triggerKind() { return get("triggerKind", ofJsEnum(CompletionTriggerKind.class)); }

 	/**
	 * <p>How the completion was triggered.</p>
	 * See {@code monaco.d.ts:5351:19}<br>
	 * Original signature:<br>
	 * {@code triggerKind: CompletionTriggerKind; }<br>
	 */
	public CompletionContext triggerKind(@Nonnull CompletionTriggerKind value) {
		set("triggerKind", value);
		return this;
	}

 
}
