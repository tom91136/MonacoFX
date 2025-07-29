
package monaco_editor.monaco.languages;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import monaco_editor.monaco.IMarkdownString;
import monaco_editor.monaco.IRange;
import monaco_editor.monaco.editor.ISingleEditOperation;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import net.kurobako.monacofx.js.JsUnion2;
import netscape.javascript.JSObject;

/**
 * <p>A completion item represents a text snippet that is
 * proposed to complete text that is being typed.</p>
 * See {@code monaco.d.ts:5242:35}<br>
 * Original signature:<br>
 * {@code export interface CompletionItem  }<br>
 */
@SuppressWarnings("unused")
public class CompletionItem extends JsProxy {

	public CompletionItem(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public CompletionItem(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>An optional array of additional text edits that are applied when
	 * selecting this completion. Edits must not overlap with the main edit
	 * nor with themselves.</p>
	 * See {@code monaco.d.ts:5321:27}<br>
	 * Original signature:<br>
	 * {@code additionalTextEdits?: editor.ISingleEditOperation[]; }<br>
	 */
	public List<ISingleEditOperation> additionalTextEdits() { return get("additionalTextEdits", ofArray(ISingleEditOperation::new)); }

 	/**
	 * <p>An optional array of additional text edits that are applied when
	 * selecting this completion. Edits must not overlap with the main edit
	 * nor with themselves.</p>
	 * See {@code monaco.d.ts:5321:27}<br>
	 * Original signature:<br>
	 * {@code additionalTextEdits?: editor.ISingleEditOperation[]; }<br>
	 */
	public CompletionItem additionalTextEdits(@Nonnull List<ISingleEditOperation> value) {
		
		return this;
	}

 	/**
	 * <p>A command that should be run upon acceptance of this item.</p>
	 * See {@code monaco.d.ts:5325:15}<br>
	 * Original signature:<br>
	 * {@code command?: Command; }<br>
	 */
	public Command command() { return get("command", Command::new); }

 	/**
	 * <p>A command that should be run upon acceptance of this item.</p>
	 * See {@code monaco.d.ts:5325:15}<br>
	 * Original signature:<br>
	 * {@code command?: Command; }<br>
	 */
	public CompletionItem command(@Nonnull Command value) {
		set("command", value);
		return this;
	}

 	/**
	 * <p>An optional set of characters that when pressed while this completion is active will accept it first and
	 * then type that character. <em>Note</em> that all commit characters should have <code>length=1</code> and that superfluous
	 * characters will be ignored.</p>
	 * See {@code monaco.d.ts:5315:24}<br>
	 * Original signature:<br>
	 * {@code commitCharacters?: string[]; }<br>
	 */
	public List<String> commitCharacters() { return get("commitCharacters", ofArray(ofMapped(String.class))); }

 	/**
	 * <p>An optional set of characters that when pressed while this completion is active will accept it first and
	 * then type that character. <em>Note</em> that all commit characters should have <code>length=1</code> and that superfluous
	 * characters will be ignored.</p>
	 * See {@code monaco.d.ts:5315:24}<br>
	 * Original signature:<br>
	 * {@code commitCharacters?: string[]; }<br>
	 */
	public CompletionItem commitCharacters(@Nonnull List<String> value) {
		
		return this;
	}

 	/**
	 * <p>A human-readable string with additional information
	 * about this item, like type or symbol information.</p>
	 * See {@code monaco.d.ts:5263:14}<br>
	 * Original signature:<br>
	 * {@code detail?: string; }<br>
	 */
	public String detail() { return get("detail", ofMapped(String.class)); }

 	/**
	 * <p>A human-readable string with additional information
	 * about this item, like type or symbol information.</p>
	 * See {@code monaco.d.ts:5263:14}<br>
	 * Original signature:<br>
	 * {@code detail?: string; }<br>
	 */
	public CompletionItem detail(@Nonnull String value) {
		set("detail", value);
		return this;
	}

 	/**
	 * <p>A human-readable string that represents a doc-comment.</p>
	 * See {@code monaco.d.ts:5267:21}<br>
	 * Original signature:<br>
	 * {@code documentation?: string | IMarkdownString; }<br>
	 */
	public Optional<JsUnion2<String, IMarkdownString>> documentation() { return Optional.ofNullable(get("documentation", null /*union*/)); }

 	/**
	 * <p>A human-readable string that represents a doc-comment.</p>
	 * See {@code monaco.d.ts:5267:21}<br>
	 * Original signature:<br>
	 * {@code documentation?: string | IMarkdownString; }<br>
	 */
	public CompletionItem documentation(@Nonnull String value) {
		set("documentation", value);
		return this;
	}

 	/**
	 * <p>A human-readable string that represents a doc-comment.</p>
	 * See {@code monaco.d.ts:5267:21}<br>
	 * Original signature:<br>
	 * {@code documentation?: string | IMarkdownString; }<br>
	 */
	public CompletionItem documentation(@Nonnull IMarkdownString value) {
		set("documentation", value);
		return this;
	}

 	/**
	 * <p>A string that should be used when filtering a set of
	 * completion items. When <code>falsy</code> the <a href="#CompletionItem.label">label</a>
	 * is used.</p>
	 * See {@code monaco.d.ts:5279:18}<br>
	 * Original signature:<br>
	 * {@code filterText?: string; }<br>
	 */
	public String filterText() { return get("filterText", ofMapped(String.class)); }

 	/**
	 * <p>A string that should be used when filtering a set of
	 * completion items. When <code>falsy</code> the <a href="#CompletionItem.label">label</a>
	 * is used.</p>
	 * See {@code monaco.d.ts:5279:18}<br>
	 * Original signature:<br>
	 * {@code filterText?: string; }<br>
	 */
	public CompletionItem filterText(@Nonnull String value) {
		set("filterText", value);
		return this;
	}

 	/**
	 * <p>A string or snippet that should be inserted in a document when selecting
	 * this completion. When <code>falsy</code> the <a href="#CompletionItem.label">label</a>
	 * is used.</p>
	 * See {@code monaco.d.ts:5291:18}<br>
	 * Original signature:<br>
	 * {@code insertText: string; }<br>
	 */
	public String insertText() { return get("insertText", ofMapped(String.class)); }

 	/**
	 * <p>A string or snippet that should be inserted in a document when selecting
	 * this completion. When <code>falsy</code> the <a href="#CompletionItem.label">label</a>
	 * is used.</p>
	 * See {@code monaco.d.ts:5291:18}<br>
	 * Original signature:<br>
	 * {@code insertText: string; }<br>
	 */
	public CompletionItem insertText(@Nonnull String value) {
		set("insertText", value);
		return this;
	}

 	/**
	 * <p>Addition rules (as bitmask) that should be applied when inserting
	 * this completion.</p>
	 * See {@code monaco.d.ts:5296:23}<br>
	 * Original signature:<br>
	 * {@code insertTextRules?: CompletionItemInsertTextRule; }<br>
	 */
	public CompletionItemInsertTextRule insertTextRules() { return get("insertTextRules", ofJsEnum(CompletionItemInsertTextRule.class)); }

 	/**
	 * <p>Addition rules (as bitmask) that should be applied when inserting
	 * this completion.</p>
	 * See {@code monaco.d.ts:5296:23}<br>
	 * Original signature:<br>
	 * {@code insertTextRules?: CompletionItemInsertTextRule; }<br>
	 */
	public CompletionItem insertTextRules(@Nonnull CompletionItemInsertTextRule value) {
		set("insertTextRules", value);
		return this;
	}

 	/**
	 * <p>The kind of this completion item. Based on the kind
	 * an icon is chosen by the editor.</p>
	 * See {@code monaco.d.ts:5253:12}<br>
	 * Original signature:<br>
	 * {@code kind: CompletionItemKind; }<br>
	 */
	public CompletionItemKind kind() { return get("kind", ofJsEnum(CompletionItemKind.class)); }

 	/**
	 * <p>The kind of this completion item. Based on the kind
	 * an icon is chosen by the editor.</p>
	 * See {@code monaco.d.ts:5253:12}<br>
	 * Original signature:<br>
	 * {@code kind: CompletionItemKind; }<br>
	 */
	public CompletionItem kind(@Nonnull CompletionItemKind value) {
		set("kind", value);
		return this;
	}

 	/**
	 * <p>The label of this completion item. By default
	 * this is also the text that is inserted when selecting
	 * this completion.</p>
	 * See {@code monaco.d.ts:5248:13}<br>
	 * Original signature:<br>
	 * {@code label: string | CompletionItemLabel; }<br>
	 */
	public JsUnion2<String, CompletionItemLabel> label() { return get("label", null /*union*/); }

 	/**
	 * <p>The label of this completion item. By default
	 * this is also the text that is inserted when selecting
	 * this completion.</p>
	 * See {@code monaco.d.ts:5248:13}<br>
	 * Original signature:<br>
	 * {@code label: string | CompletionItemLabel; }<br>
	 */
	public CompletionItem label(@Nonnull String value) {
		set("label", value);
		return this;
	}

 	/**
	 * <p>The label of this completion item. By default
	 * this is also the text that is inserted when selecting
	 * this completion.</p>
	 * See {@code monaco.d.ts:5248:13}<br>
	 * Original signature:<br>
	 * {@code label: string | CompletionItemLabel; }<br>
	 */
	public CompletionItem label(@Nonnull CompletionItemLabel value) {
		set("label", value);
		return this;
	}

 	/**
	 * <p>Select this item when showing. <em>Note</em> that only one completion item can be selected and
	 * that the editor decides which item that is. The rule is that the <em>first</em> item of those
	 * that match best is selected.</p>
	 * See {@code monaco.d.ts:5285:17}<br>
	 * Original signature:<br>
	 * {@code preselect?: boolean; }<br>
	 */
	public boolean preselect() { return get("preselect", ofMapped(boolean.class)); }

 	/**
	 * <p>Select this item when showing. <em>Note</em> that only one completion item can be selected and
	 * that the editor decides which item that is. The rule is that the <em>first</em> item of those
	 * that match best is selected.</p>
	 * See {@code monaco.d.ts:5285:17}<br>
	 * Original signature:<br>
	 * {@code preselect?: boolean; }<br>
	 */
	public CompletionItem preselect(@Nonnull Boolean value) {
		set("preselect", value);
		return this;
	}

 	/**
	 * <p>A range of text that should be replaced by this completion item.
	 * Defaults to a range from the start of the <a href="#TextDocument.getWordRangeAtPosition">current word</a> to the
	 * current position.</p>
	 * <p><em>Note:</em> The range must be a <a href="#Range.isSingleLine">single line</a> and it must
	 * <a href="#Range.contains">contain</a> the position at which completion has been <a href="#CompletionItemProvider.provideCompletionItems">requested</a>.</p>
	 * See {@code monaco.d.ts:5306:13}<br>
	 * Original signature:<br>
	 * {@code range: IRange |  }<br>
	 */
	public JsUnion2<IRange, JSObject> range() { return get("range", null /*union*/); }

 	/**
	 * <p>A range of text that should be replaced by this completion item.
	 * Defaults to a range from the start of the <a href="#TextDocument.getWordRangeAtPosition">current word</a> to the
	 * current position.</p>
	 * <p><em>Note:</em> The range must be a <a href="#Range.isSingleLine">single line</a> and it must
	 * <a href="#Range.contains">contain</a> the position at which completion has been <a href="#CompletionItemProvider.provideCompletionItems">requested</a>.</p>
	 * See {@code monaco.d.ts:5306:13}<br>
	 * Original signature:<br>
	 * {@code range: IRange |  }<br>
	 */
	public CompletionItem range(@Nonnull IRange value) {
		set("range", value);
		return this;
	}

 	/**
	 * <p>A range of text that should be replaced by this completion item.
	 * Defaults to a range from the start of the <a href="#TextDocument.getWordRangeAtPosition">current word</a> to the
	 * current position.</p>
	 * <p><em>Note:</em> The range must be a <a href="#Range.isSingleLine">single line</a> and it must
	 * <a href="#Range.contains">contain</a> the position at which completion has been <a href="#CompletionItemProvider.provideCompletionItems">requested</a>.</p>
	 * See {@code monaco.d.ts:5306:13}<br>
	 * Original signature:<br>
	 * {@code range: IRange |  }<br>
	 */
	public CompletionItem range(@Nonnull JSObject value) {
		set("range", value);
		return this;
	}

 	/**
	 * <p>A string that should be used when comparing this item
	 * with other items. When <code>falsy</code> the <a href="#CompletionItem.label">label</a>
	 * is used.</p>
	 * See {@code monaco.d.ts:5273:16}<br>
	 * Original signature:<br>
	 * {@code sortText?: string; }<br>
	 */
	public String sortText() { return get("sortText", ofMapped(String.class)); }

 	/**
	 * <p>A string that should be used when comparing this item
	 * with other items. When <code>falsy</code> the <a href="#CompletionItem.label">label</a>
	 * is used.</p>
	 * See {@code monaco.d.ts:5273:16}<br>
	 * Original signature:<br>
	 * {@code sortText?: string; }<br>
	 */
	public CompletionItem sortText(@Nonnull String value) {
		set("sortText", value);
		return this;
	}

 	/**
	 * <p>A modifier to the <code>kind</code> which affect how the item
	 * is rendered, e.g. Deprecated is rendered with a strikeout</p>
	 * See {@code monaco.d.ts:5258:12}<br>
	 * Original signature:<br>
	 * {@code tags?: ReadonlyArray<CompletionItemTag>; }<br>
	 */
	public List<CompletionItemTag> tags() { return get("tags", ofArray(ofJsEnum(CompletionItemTag.class))); }

 	/**
	 * <p>A modifier to the <code>kind</code> which affect how the item
	 * is rendered, e.g. Deprecated is rendered with a strikeout</p>
	 * See {@code monaco.d.ts:5258:12}<br>
	 * Original signature:<br>
	 * {@code tags?: ReadonlyArray<CompletionItemTag>; }<br>
	 */
	public CompletionItem tags(@Nonnull List<CompletionItemTag> value) {
		
		return this;
	}

 
}
