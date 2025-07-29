
package monaco_editor.monaco.languages;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import monaco_editor.monaco.CancellationToken;
import monaco_editor.monaco.Position;
import monaco_editor.monaco.editor.ITextModel;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsPromise;
import net.kurobako.monacofx.js.JsProxy;
import net.kurobako.monacofx.js.JsUnion2;

/**
 * <p>The completion item provider interface defines the contract between extensions and
 * the <a href="https://code.visualstudio.com/docs/editor/intellisense">IntelliSense</a>.
 * When computing <em>complete</em> completion items is expensive, providers can optionally implement
 * the <code>resolveCompletionItem</code>-function. In that case it is enough to return completion
 * items with a <a href="#CompletionItem.label">label</a> from the
 * <a href="#CompletionItemProvider.provideCompletionItems">provideCompletionItems</a>-function. Subsequently,
 * when a completion item is shown in the UI and gains focus this provider is asked to resolve
 * the item, like adding <a href="#CompletionItem.documentation">doc-comment</a> or <a href="#CompletionItem.detail">details</a>.</p>
 * See {@code monaco.d.ts:5371:43}<br>
 * Original signature:<br>
 * {@code export interface CompletionItemProvider  }<br>
 */
@SuppressWarnings("unused")
public class CompletionItemProvider extends JsProxy {

	public CompletionItemProvider(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public CompletionItemProvider(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5372:25}<br>
	 * Original signature:<br>
	 * {@code triggerCharacters?: string[]; }<br>
	 */
	public List<String> triggerCharacters() { return get("triggerCharacters", ofArray(ofMapped(String.class))); }

 	/**
	 * See {@code monaco.d.ts:5372:25}<br>
	 * Original signature:<br>
	 * {@code triggerCharacters?: string[]; }<br>
	 */
	public CompletionItemProvider triggerCharacters(@Nonnull List<String> value) {
		
		return this;
	}

 	/**
	 * <p>Provide completion items for the given position and document.</p>
	 * See {@code monaco.d.ts:5376:30}<br>
	 * Original signature:<br>
	 * {@code provideCompletionItems(model: editor.ITextModel, position: Position, context: CompletionContext, token: CancellationToken): ProviderResult<CompletionList>; }<br>
	 */
	public Optional<JsUnion2<CompletionList, JsPromise<CompletionList>>> provideCompletionItems(@Nonnull ITextModel model, @Nonnull Position position, @Nonnull CompletionContext context, @Nonnull CancellationToken token) { return Optional.ofNullable(call("provideCompletionItems", null /*union*/, model, position, context, token)); }

 	/**
	 * <p>Given a completion item fill in more data, like <a href="#CompletionItem.documentation">doc-comment</a>
	 * or <a href="#CompletionItem.detail">details</a>.
	 * The editor will only resolve a completion item once.</p>
	 * See {@code monaco.d.ts:5383:29}<br>
	 * Original signature:<br>
	 * {@code resolveCompletionItem?(model: editor.ITextModel, position: Position, item: CompletionItem, token: CancellationToken): ProviderResult<CompletionItem>; }<br>
	 */
	public Optional<JsUnion2<CompletionItem, JsPromise<CompletionItem>>> resolveCompletionItem(@Nonnull ITextModel model, @Nonnull Position position, @Nonnull CompletionItem item, @Nonnull CancellationToken token) { return Optional.ofNullable(call("resolveCompletionItem", null /*union*/, model, position, item, token)); }

 
}
