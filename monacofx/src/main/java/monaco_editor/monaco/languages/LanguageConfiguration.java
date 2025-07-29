
package monaco_editor.monaco.languages;
import java.util.List;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import net.kurobako.monacofx.js.JsUnion2;
import netscape.javascript.JSObject;

/**
 * <p>The language configuration interface defines the contract between extensions and
 * various editor features, like automatic bracket insertion, automatic indentation etc.</p>
 * See {@code monaco.d.ts:4926:42}<br>
 * Original signature:<br>
 * {@code export interface LanguageConfiguration  }<br>
 */
@SuppressWarnings("unused")
public class LanguageConfiguration extends JsProxy {

	public LanguageConfiguration(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public LanguageConfiguration(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p><strong>Deprecated</strong> Do not use.</p>
	 * See {@code monaco.d.ts:4978:34}<br>
	 * Original signature:<br>
	 * {@code __electricCharacterSupport?:  }<br>
	 */
	public JSObject __electricCharacterSupport() { return get("__electricCharacterSupport", ofMapped(JSObject.class)); }

 	/**
	 * <p><strong>Deprecated</strong> Do not use.</p>
	 * See {@code monaco.d.ts:4978:34}<br>
	 * Original signature:<br>
	 * {@code __electricCharacterSupport?:  }<br>
	 */
	public LanguageConfiguration __electricCharacterSupport(@Nonnull JSObject value) {
		set("__electricCharacterSupport", value);
		return this;
	}

 	/**
	 * <p>Defines what characters must be after the cursor for bracket or quote autoclosing to occur when using the 'languageDefined' autoclosing setting.
	 * This is typically the set of characters which can not start an expression, such as whitespace, closing brackets, non-unary operators, etc.</p>
	 * See {@code monaco.d.ts:4968:23}<br>
	 * Original signature:<br>
	 * {@code autoCloseBefore?: string; }<br>
	 */
	public String autoCloseBefore() { return get("autoCloseBefore", ofMapped(String.class)); }

 	/**
	 * <p>Defines what characters must be after the cursor for bracket or quote autoclosing to occur when using the 'languageDefined' autoclosing setting.
	 * This is typically the set of characters which can not start an expression, such as whitespace, closing brackets, non-unary operators, etc.</p>
	 * See {@code monaco.d.ts:4968:23}<br>
	 * Original signature:<br>
	 * {@code autoCloseBefore?: string; }<br>
	 */
	public LanguageConfiguration autoCloseBefore(@Nonnull String value) {
		set("autoCloseBefore", value);
		return this;
	}

 	/**
	 * <p>The language's auto closing pairs. The 'close' character is automatically inserted with the
	 * 'open' character is typed. If not set, the configured brackets will be used.</p>
	 * See {@code monaco.d.ts:4956:24}<br>
	 * Original signature:<br>
	 * {@code autoClosingPairs?: IAutoClosingPairConditional[]; }<br>
	 */
	public List<IAutoClosingPairConditional> autoClosingPairs() { return get("autoClosingPairs", ofArray(IAutoClosingPairConditional::new)); }

 	/**
	 * <p>The language's auto closing pairs. The 'close' character is automatically inserted with the
	 * 'open' character is typed. If not set, the configured brackets will be used.</p>
	 * See {@code monaco.d.ts:4956:24}<br>
	 * Original signature:<br>
	 * {@code autoClosingPairs?: IAutoClosingPairConditional[]; }<br>
	 */
	public LanguageConfiguration autoClosingPairs(@Nonnull List<IAutoClosingPairConditional> value) {
		
		return this;
	}

 	/**
	 * <p>The language's brackets.
	 * This configuration implicitly affects pressing Enter around these brackets.</p>
	 * See {@code monaco.d.ts:4935:16}<br>
	 * Original signature:<br>
	 * {@code brackets?: CharacterPair[]; }<br>
	 */
	public List<JsUnion2<String, String>> brackets() { return get("brackets", ofArray(null /*union*/)); }

 	/**
	 * <p>The language's brackets.
	 * This configuration implicitly affects pressing Enter around these brackets.</p>
	 * See {@code monaco.d.ts:4935:16}<br>
	 * Original signature:<br>
	 * {@code brackets?: CharacterPair[]; }<br>
	 */
	public LanguageConfiguration brackets(@Nonnull List<JsUnion2<String, String>> value) {
		
		return this;
	}

 	/**
	 * <p>The language's comment settings.</p>
	 * See {@code monaco.d.ts:4930:16}<br>
	 * Original signature:<br>
	 * {@code comments?: CommentRule; }<br>
	 */
	public CommentRule comments() { return get("comments", CommentRule::new); }

 	/**
	 * <p>The language's comment settings.</p>
	 * See {@code monaco.d.ts:4930:16}<br>
	 * Original signature:<br>
	 * {@code comments?: CommentRule; }<br>
	 */
	public LanguageConfiguration comments(@Nonnull CommentRule value) {
		set("comments", value);
		return this;
	}

 	/**
	 * <p>The language's folding rules.</p>
	 * See {@code monaco.d.ts:4972:15}<br>
	 * Original signature:<br>
	 * {@code folding?: FoldingRules; }<br>
	 */
	public FoldingRules folding() { return get("folding", FoldingRules::new); }

 	/**
	 * <p>The language's folding rules.</p>
	 * See {@code monaco.d.ts:4972:15}<br>
	 * Original signature:<br>
	 * {@code folding?: FoldingRules; }<br>
	 */
	public LanguageConfiguration folding(@Nonnull FoldingRules value) {
		set("folding", value);
		return this;
	}

 	/**
	 * <p>The language's indentation settings.</p>
	 * See {@code monaco.d.ts:4947:24}<br>
	 * Original signature:<br>
	 * {@code indentationRules?: IndentationRule; }<br>
	 */
	public IndentationRule indentationRules() { return get("indentationRules", IndentationRule::new); }

 	/**
	 * <p>The language's indentation settings.</p>
	 * See {@code monaco.d.ts:4947:24}<br>
	 * Original signature:<br>
	 * {@code indentationRules?: IndentationRule; }<br>
	 */
	public LanguageConfiguration indentationRules(@Nonnull IndentationRule value) {
		set("indentationRules", value);
		return this;
	}

 	/**
	 * <p>The language's rules to be evaluated when pressing Enter.</p>
	 * See {@code monaco.d.ts:4951:20}<br>
	 * Original signature:<br>
	 * {@code onEnterRules?: OnEnterRule[]; }<br>
	 */
	public List<OnEnterRule> onEnterRules() { return get("onEnterRules", ofArray(OnEnterRule::new)); }

 	/**
	 * <p>The language's rules to be evaluated when pressing Enter.</p>
	 * See {@code monaco.d.ts:4951:20}<br>
	 * Original signature:<br>
	 * {@code onEnterRules?: OnEnterRule[]; }<br>
	 */
	public LanguageConfiguration onEnterRules(@Nonnull List<OnEnterRule> value) {
		
		return this;
	}

 	/**
	 * <p>The language's surrounding pairs. When the 'open' character is typed on a selection, the
	 * selected string is surrounded by the open and close characters. If not set, the autoclosing pairs
	 * settings will be used.</p>
	 * See {@code monaco.d.ts:4962:24}<br>
	 * Original signature:<br>
	 * {@code surroundingPairs?: IAutoClosingPair[]; }<br>
	 */
	public List<IAutoClosingPair> surroundingPairs() { return get("surroundingPairs", ofArray(IAutoClosingPair::new)); }

 	/**
	 * <p>The language's surrounding pairs. When the 'open' character is typed on a selection, the
	 * selected string is surrounded by the open and close characters. If not set, the autoclosing pairs
	 * settings will be used.</p>
	 * See {@code monaco.d.ts:4962:24}<br>
	 * Original signature:<br>
	 * {@code surroundingPairs?: IAutoClosingPair[]; }<br>
	 */
	public LanguageConfiguration surroundingPairs(@Nonnull List<IAutoClosingPair> value) {
		
		return this;
	}

 	/**
	 * <p>The language's word definition.
	 * If the language supports Unicode identifiers (e.g. JavaScript), it is preferable
	 * to provide a word definition that uses exclusion of known separators.
	 * e.g.: A regex that matches anything except known separators (and dot is allowed to occur in a floating point number):
	 * /(-?\d*.\d\w*)|([^`~!@#%^&amp;*()-=+[{]}\|;:'&quot;,.&lt;&gt;/?\s]+)/g</p>
	 * See {@code monaco.d.ts:4943:19}<br>
	 * Original signature:<br>
	 * {@code wordPattern?: RegExp; }<br>
	 */
	public String wordPattern() { return get("wordPattern", ofMapped(String.class)); }

 	/**
	 * <p>The language's word definition.
	 * If the language supports Unicode identifiers (e.g. JavaScript), it is preferable
	 * to provide a word definition that uses exclusion of known separators.
	 * e.g.: A regex that matches anything except known separators (and dot is allowed to occur in a floating point number):
	 * /(-?\d*.\d\w*)|([^`~!@#%^&amp;*()-=+[{]}\|;:'&quot;,.&lt;&gt;/?\s]+)/g</p>
	 * See {@code monaco.d.ts:4943:19}<br>
	 * Original signature:<br>
	 * {@code wordPattern?: RegExp; }<br>
	 */
	public LanguageConfiguration wordPattern(@Nonnull String value) {
		set("wordPattern", value);
		return this;
	}

 
}
