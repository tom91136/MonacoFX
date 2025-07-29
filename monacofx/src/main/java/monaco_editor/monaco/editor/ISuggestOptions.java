
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>Configuration options for editor suggest widget</p>
 * See {@code monaco.d.ts:3497:36}<br>
 * Original signature:<br>
 * {@code export interface ISuggestOptions  }<br>
 */
@SuppressWarnings("unused")
public class ISuggestOptions extends JsProxy {

	public ISuggestOptions(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public ISuggestOptions(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Enable graceful matching. Defaults to true.</p>
	 * See {@code monaco.d.ts:3509:22}<br>
	 * Original signature:<br>
	 * {@code filterGraceful?: boolean; }<br>
	 */
	public boolean filterGraceful() { return get("filterGraceful", ofMapped(boolean.class)); }

 	/**
	 * <p>Enable graceful matching. Defaults to true.</p>
	 * See {@code monaco.d.ts:3509:22}<br>
	 * Original signature:<br>
	 * {@code filterGraceful?: boolean; }<br>
	 */
	public ISuggestOptions filterGraceful(@Nonnull Boolean value) {
		set("filterGraceful", value);
		return this;
	}

 	/**
	 * <p>Controls the visibility of the status bar at the bottom of the suggest widget.</p>
	 * See {@code monaco.d.ts:3633:21}<br>
	 * Original signature:<br>
	 * {@code hideStatusBar?: boolean; }<br>
	 */
	public boolean hideStatusBar() { return get("hideStatusBar", ofMapped(boolean.class)); }

 	/**
	 * <p>Controls the visibility of the status bar at the bottom of the suggest widget.</p>
	 * See {@code monaco.d.ts:3633:21}<br>
	 * Original signature:<br>
	 * {@code hideStatusBar?: boolean; }<br>
	 */
	public ISuggestOptions hideStatusBar(@Nonnull Boolean value) {
		set("hideStatusBar", value);
		return this;
	}

 	/**
	 * <p>Show a highlight when suggestion replaces or keep text after the cursor. Defaults to false.</p>
	 * See {@code monaco.d.ts:3505:23}<br>
	 * Original signature:<br>
	 * {@code insertHighlight?: boolean; }<br>
	 */
	public boolean insertHighlight() { return get("insertHighlight", ofMapped(boolean.class)); }

 	/**
	 * <p>Show a highlight when suggestion replaces or keep text after the cursor. Defaults to false.</p>
	 * See {@code monaco.d.ts:3505:23}<br>
	 * Original signature:<br>
	 * {@code insertHighlight?: boolean; }<br>
	 */
	public ISuggestOptions insertHighlight(@Nonnull Boolean value) {
		set("insertHighlight", value);
		return this;
	}

 	/**
	 * <p>Favours words that appear close to the cursor.</p>
	 * See {@code monaco.d.ts:3517:21}<br>
	 * Original signature:<br>
	 * {@code localityBonus?: boolean; }<br>
	 */
	public boolean localityBonus() { return get("localityBonus", ofMapped(boolean.class)); }

 	/**
	 * <p>Favours words that appear close to the cursor.</p>
	 * See {@code monaco.d.ts:3517:21}<br>
	 * Original signature:<br>
	 * {@code localityBonus?: boolean; }<br>
	 */
	public ISuggestOptions localityBonus(@Nonnull Boolean value) {
		set("localityBonus", value);
		return this;
	}

 	/**
	 * <p>Max suggestions to show in suggestions. Defaults to 12.</p>
	 * See {@code monaco.d.ts:3529:29}<br>
	 * Original signature:<br>
	 * {@code maxVisibleSuggestions?: number; }<br>
	 */
	public double maxVisibleSuggestions() { return get("maxVisibleSuggestions", ofMapped(double.class)); }

 	/**
	 * <p>Max suggestions to show in suggestions. Defaults to 12.</p>
	 * See {@code monaco.d.ts:3529:29}<br>
	 * Original signature:<br>
	 * {@code maxVisibleSuggestions?: number; }<br>
	 */
	public ISuggestOptions maxVisibleSuggestions(@Nonnull Double value) {
		set("maxVisibleSuggestions", value);
		return this;
	}

 	/**
	 * <p>Enable using global storage for remembering suggestions.</p>
	 * See {@code monaco.d.ts:3521:30}<br>
	 * Original signature:<br>
	 * {@code shareSuggestSelections?: boolean; }<br>
	 */
	public boolean shareSuggestSelections() { return get("shareSuggestSelections", ofMapped(boolean.class)); }

 	/**
	 * <p>Enable using global storage for remembering suggestions.</p>
	 * See {@code monaco.d.ts:3521:30}<br>
	 * Original signature:<br>
	 * {@code shareSuggestSelections?: boolean; }<br>
	 */
	public ISuggestOptions shareSuggestSelections(@Nonnull Boolean value) {
		set("shareSuggestSelections", value);
		return this;
	}

 	/**
	 * <p>Show class-suggestions.</p>
	 * See {@code monaco.d.ts:3553:19}<br>
	 * Original signature:<br>
	 * {@code showClasses?: boolean; }<br>
	 */
	public boolean showClasses() { return get("showClasses", ofMapped(boolean.class)); }

 	/**
	 * <p>Show class-suggestions.</p>
	 * See {@code monaco.d.ts:3553:19}<br>
	 * Original signature:<br>
	 * {@code showClasses?: boolean; }<br>
	 */
	public ISuggestOptions showClasses(@Nonnull Boolean value) {
		set("showClasses", value);
		return this;
	}

 	/**
	 * <p>Show color-suggestions.</p>
	 * See {@code monaco.d.ts:3609:18}<br>
	 * Original signature:<br>
	 * {@code showColors?: boolean; }<br>
	 */
	public boolean showColors() { return get("showColors", ofMapped(boolean.class)); }

 	/**
	 * <p>Show color-suggestions.</p>
	 * See {@code monaco.d.ts:3609:18}<br>
	 * Original signature:<br>
	 * {@code showColors?: boolean; }<br>
	 */
	public ISuggestOptions showColors(@Nonnull Boolean value) {
		set("showColors", value);
		return this;
	}

 	/**
	 * <p>Show constant-suggestions.</p>
	 * See {@code monaco.d.ts:3589:21}<br>
	 * Original signature:<br>
	 * {@code showConstants?: boolean; }<br>
	 */
	public boolean showConstants() { return get("showConstants", ofMapped(boolean.class)); }

 	/**
	 * <p>Show constant-suggestions.</p>
	 * See {@code monaco.d.ts:3589:21}<br>
	 * Original signature:<br>
	 * {@code showConstants?: boolean; }<br>
	 */
	public ISuggestOptions showConstants(@Nonnull Boolean value) {
		set("showConstants", value);
		return this;
	}

 	/**
	 * <p>Show constructor-suggestions.</p>
	 * See {@code monaco.d.ts:3541:24}<br>
	 * Original signature:<br>
	 * {@code showConstructors?: boolean; }<br>
	 */
	public boolean showConstructors() { return get("showConstructors", ofMapped(boolean.class)); }

 	/**
	 * <p>Show constructor-suggestions.</p>
	 * See {@code monaco.d.ts:3541:24}<br>
	 * Original signature:<br>
	 * {@code showConstructors?: boolean; }<br>
	 */
	public ISuggestOptions showConstructors(@Nonnull Boolean value) {
		set("showConstructors", value);
		return this;
	}

 	/**
	 * <p>Show enumMember-suggestions.</p>
	 * See {@code monaco.d.ts:3597:23}<br>
	 * Original signature:<br>
	 * {@code showEnumMembers?: boolean; }<br>
	 */
	public boolean showEnumMembers() { return get("showEnumMembers", ofMapped(boolean.class)); }

 	/**
	 * <p>Show enumMember-suggestions.</p>
	 * See {@code monaco.d.ts:3597:23}<br>
	 * Original signature:<br>
	 * {@code showEnumMembers?: boolean; }<br>
	 */
	public ISuggestOptions showEnumMembers(@Nonnull Boolean value) {
		set("showEnumMembers", value);
		return this;
	}

 	/**
	 * <p>Show enum-suggestions.</p>
	 * See {@code monaco.d.ts:3593:17}<br>
	 * Original signature:<br>
	 * {@code showEnums?: boolean; }<br>
	 */
	public boolean showEnums() { return get("showEnums", ofMapped(boolean.class)); }

 	/**
	 * <p>Show enum-suggestions.</p>
	 * See {@code monaco.d.ts:3593:17}<br>
	 * Original signature:<br>
	 * {@code showEnums?: boolean; }<br>
	 */
	public ISuggestOptions showEnums(@Nonnull Boolean value) {
		set("showEnums", value);
		return this;
	}

 	/**
	 * <p>Show event-suggestions.</p>
	 * See {@code monaco.d.ts:3573:18}<br>
	 * Original signature:<br>
	 * {@code showEvents?: boolean; }<br>
	 */
	public boolean showEvents() { return get("showEvents", ofMapped(boolean.class)); }

 	/**
	 * <p>Show event-suggestions.</p>
	 * See {@code monaco.d.ts:3573:18}<br>
	 * Original signature:<br>
	 * {@code showEvents?: boolean; }<br>
	 */
	public ISuggestOptions showEvents(@Nonnull Boolean value) {
		set("showEvents", value);
		return this;
	}

 	/**
	 * <p>Show field-suggestions.</p>
	 * See {@code monaco.d.ts:3545:18}<br>
	 * Original signature:<br>
	 * {@code showFields?: boolean; }<br>
	 */
	public boolean showFields() { return get("showFields", ofMapped(boolean.class)); }

 	/**
	 * <p>Show field-suggestions.</p>
	 * See {@code monaco.d.ts:3545:18}<br>
	 * Original signature:<br>
	 * {@code showFields?: boolean; }<br>
	 */
	public ISuggestOptions showFields(@Nonnull Boolean value) {
		set("showFields", value);
		return this;
	}

 	/**
	 * <p>Show file-suggestions.</p>
	 * See {@code monaco.d.ts:3613:17}<br>
	 * Original signature:<br>
	 * {@code showFiles?: boolean; }<br>
	 */
	public boolean showFiles() { return get("showFiles", ofMapped(boolean.class)); }

 	/**
	 * <p>Show file-suggestions.</p>
	 * See {@code monaco.d.ts:3613:17}<br>
	 * Original signature:<br>
	 * {@code showFiles?: boolean; }<br>
	 */
	public ISuggestOptions showFiles(@Nonnull Boolean value) {
		set("showFiles", value);
		return this;
	}

 	/**
	 * <p>Show folder-suggestions.</p>
	 * See {@code monaco.d.ts:3621:19}<br>
	 * Original signature:<br>
	 * {@code showFolders?: boolean; }<br>
	 */
	public boolean showFolders() { return get("showFolders", ofMapped(boolean.class)); }

 	/**
	 * <p>Show folder-suggestions.</p>
	 * See {@code monaco.d.ts:3621:19}<br>
	 * Original signature:<br>
	 * {@code showFolders?: boolean; }<br>
	 */
	public ISuggestOptions showFolders(@Nonnull Boolean value) {
		set("showFolders", value);
		return this;
	}

 	/**
	 * <p>Show function-suggestions.</p>
	 * See {@code monaco.d.ts:3537:21}<br>
	 * Original signature:<br>
	 * {@code showFunctions?: boolean; }<br>
	 */
	public boolean showFunctions() { return get("showFunctions", ofMapped(boolean.class)); }

 	/**
	 * <p>Show function-suggestions.</p>
	 * See {@code monaco.d.ts:3537:21}<br>
	 * Original signature:<br>
	 * {@code showFunctions?: boolean; }<br>
	 */
	public ISuggestOptions showFunctions(@Nonnull Boolean value) {
		set("showFunctions", value);
		return this;
	}

 	/**
	 * <p>Enable or disable icons in suggestions. Defaults to true.</p>
	 * See {@code monaco.d.ts:3525:17}<br>
	 * Original signature:<br>
	 * {@code showIcons?: boolean; }<br>
	 */
	public boolean showIcons() { return get("showIcons", ofMapped(boolean.class)); }

 	/**
	 * <p>Enable or disable icons in suggestions. Defaults to true.</p>
	 * See {@code monaco.d.ts:3525:17}<br>
	 * Original signature:<br>
	 * {@code showIcons?: boolean; }<br>
	 */
	public ISuggestOptions showIcons(@Nonnull Boolean value) {
		set("showIcons", value);
		return this;
	}

 	/**
	 * <p>Show interface-suggestions.</p>
	 * See {@code monaco.d.ts:3561:22}<br>
	 * Original signature:<br>
	 * {@code showInterfaces?: boolean; }<br>
	 */
	public boolean showInterfaces() { return get("showInterfaces", ofMapped(boolean.class)); }

 	/**
	 * <p>Show interface-suggestions.</p>
	 * See {@code monaco.d.ts:3561:22}<br>
	 * Original signature:<br>
	 * {@code showInterfaces?: boolean; }<br>
	 */
	public ISuggestOptions showInterfaces(@Nonnull Boolean value) {
		set("showInterfaces", value);
		return this;
	}

 	/**
	 * <p>Show keyword-suggestions.</p>
	 * See {@code monaco.d.ts:3601:20}<br>
	 * Original signature:<br>
	 * {@code showKeywords?: boolean; }<br>
	 */
	public boolean showKeywords() { return get("showKeywords", ofMapped(boolean.class)); }

 	/**
	 * <p>Show keyword-suggestions.</p>
	 * See {@code monaco.d.ts:3601:20}<br>
	 * Original signature:<br>
	 * {@code showKeywords?: boolean; }<br>
	 */
	public ISuggestOptions showKeywords(@Nonnull Boolean value) {
		set("showKeywords", value);
		return this;
	}

 	/**
	 * <p>Show method-suggestions.</p>
	 * See {@code monaco.d.ts:3533:19}<br>
	 * Original signature:<br>
	 * {@code showMethods?: boolean; }<br>
	 */
	public boolean showMethods() { return get("showMethods", ofMapped(boolean.class)); }

 	/**
	 * <p>Show method-suggestions.</p>
	 * See {@code monaco.d.ts:3533:19}<br>
	 * Original signature:<br>
	 * {@code showMethods?: boolean; }<br>
	 */
	public ISuggestOptions showMethods(@Nonnull Boolean value) {
		set("showMethods", value);
		return this;
	}

 	/**
	 * <p>Show module-suggestions.</p>
	 * See {@code monaco.d.ts:3565:19}<br>
	 * Original signature:<br>
	 * {@code showModules?: boolean; }<br>
	 */
	public boolean showModules() { return get("showModules", ofMapped(boolean.class)); }

 	/**
	 * <p>Show module-suggestions.</p>
	 * See {@code monaco.d.ts:3565:19}<br>
	 * Original signature:<br>
	 * {@code showModules?: boolean; }<br>
	 */
	public ISuggestOptions showModules(@Nonnull Boolean value) {
		set("showModules", value);
		return this;
	}

 	/**
	 * <p>Show operator-suggestions.</p>
	 * See {@code monaco.d.ts:3577:21}<br>
	 * Original signature:<br>
	 * {@code showOperators?: boolean; }<br>
	 */
	public boolean showOperators() { return get("showOperators", ofMapped(boolean.class)); }

 	/**
	 * <p>Show operator-suggestions.</p>
	 * See {@code monaco.d.ts:3577:21}<br>
	 * Original signature:<br>
	 * {@code showOperators?: boolean; }<br>
	 */
	public ISuggestOptions showOperators(@Nonnull Boolean value) {
		set("showOperators", value);
		return this;
	}

 	/**
	 * <p>Show property-suggestions.</p>
	 * See {@code monaco.d.ts:3569:22}<br>
	 * Original signature:<br>
	 * {@code showProperties?: boolean; }<br>
	 */
	public boolean showProperties() { return get("showProperties", ofMapped(boolean.class)); }

 	/**
	 * <p>Show property-suggestions.</p>
	 * See {@code monaco.d.ts:3569:22}<br>
	 * Original signature:<br>
	 * {@code showProperties?: boolean; }<br>
	 */
	public ISuggestOptions showProperties(@Nonnull Boolean value) {
		set("showProperties", value);
		return this;
	}

 	/**
	 * <p>Show reference-suggestions.</p>
	 * See {@code monaco.d.ts:3617:22}<br>
	 * Original signature:<br>
	 * {@code showReferences?: boolean; }<br>
	 */
	public boolean showReferences() { return get("showReferences", ofMapped(boolean.class)); }

 	/**
	 * <p>Show reference-suggestions.</p>
	 * See {@code monaco.d.ts:3617:22}<br>
	 * Original signature:<br>
	 * {@code showReferences?: boolean; }<br>
	 */
	public ISuggestOptions showReferences(@Nonnull Boolean value) {
		set("showReferences", value);
		return this;
	}

 	/**
	 * <p>Show snippet-suggestions.</p>
	 * See {@code monaco.d.ts:3629:20}<br>
	 * Original signature:<br>
	 * {@code showSnippets?: boolean; }<br>
	 */
	public boolean showSnippets() { return get("showSnippets", ofMapped(boolean.class)); }

 	/**
	 * <p>Show snippet-suggestions.</p>
	 * See {@code monaco.d.ts:3629:20}<br>
	 * Original signature:<br>
	 * {@code showSnippets?: boolean; }<br>
	 */
	public ISuggestOptions showSnippets(@Nonnull Boolean value) {
		set("showSnippets", value);
		return this;
	}

 	/**
	 * <p>Show struct-suggestions.</p>
	 * See {@code monaco.d.ts:3557:19}<br>
	 * Original signature:<br>
	 * {@code showStructs?: boolean; }<br>
	 */
	public boolean showStructs() { return get("showStructs", ofMapped(boolean.class)); }

 	/**
	 * <p>Show struct-suggestions.</p>
	 * See {@code monaco.d.ts:3557:19}<br>
	 * Original signature:<br>
	 * {@code showStructs?: boolean; }<br>
	 */
	public ISuggestOptions showStructs(@Nonnull Boolean value) {
		set("showStructs", value);
		return this;
	}

 	/**
	 * <p>Show typeParameter-suggestions.</p>
	 * See {@code monaco.d.ts:3625:26}<br>
	 * Original signature:<br>
	 * {@code showTypeParameters?: boolean; }<br>
	 */
	public boolean showTypeParameters() { return get("showTypeParameters", ofMapped(boolean.class)); }

 	/**
	 * <p>Show typeParameter-suggestions.</p>
	 * See {@code monaco.d.ts:3625:26}<br>
	 * Original signature:<br>
	 * {@code showTypeParameters?: boolean; }<br>
	 */
	public ISuggestOptions showTypeParameters(@Nonnull Boolean value) {
		set("showTypeParameters", value);
		return this;
	}

 	/**
	 * <p>Show unit-suggestions.</p>
	 * See {@code monaco.d.ts:3581:17}<br>
	 * Original signature:<br>
	 * {@code showUnits?: boolean; }<br>
	 */
	public boolean showUnits() { return get("showUnits", ofMapped(boolean.class)); }

 	/**
	 * <p>Show unit-suggestions.</p>
	 * See {@code monaco.d.ts:3581:17}<br>
	 * Original signature:<br>
	 * {@code showUnits?: boolean; }<br>
	 */
	public ISuggestOptions showUnits(@Nonnull Boolean value) {
		set("showUnits", value);
		return this;
	}

 	/**
	 * <p>Show value-suggestions.</p>
	 * See {@code monaco.d.ts:3585:18}<br>
	 * Original signature:<br>
	 * {@code showValues?: boolean; }<br>
	 */
	public boolean showValues() { return get("showValues", ofMapped(boolean.class)); }

 	/**
	 * <p>Show value-suggestions.</p>
	 * See {@code monaco.d.ts:3585:18}<br>
	 * Original signature:<br>
	 * {@code showValues?: boolean; }<br>
	 */
	public ISuggestOptions showValues(@Nonnull Boolean value) {
		set("showValues", value);
		return this;
	}

 	/**
	 * <p>Show variable-suggestions.</p>
	 * See {@code monaco.d.ts:3549:21}<br>
	 * Original signature:<br>
	 * {@code showVariables?: boolean; }<br>
	 */
	public boolean showVariables() { return get("showVariables", ofMapped(boolean.class)); }

 	/**
	 * <p>Show variable-suggestions.</p>
	 * See {@code monaco.d.ts:3549:21}<br>
	 * Original signature:<br>
	 * {@code showVariables?: boolean; }<br>
	 */
	public ISuggestOptions showVariables(@Nonnull Boolean value) {
		set("showVariables", value);
		return this;
	}

 	/**
	 * <p>Show text-suggestions.</p>
	 * See {@code monaco.d.ts:3605:17}<br>
	 * Original signature:<br>
	 * {@code showWords?: boolean; }<br>
	 */
	public boolean showWords() { return get("showWords", ofMapped(boolean.class)); }

 	/**
	 * <p>Show text-suggestions.</p>
	 * See {@code monaco.d.ts:3605:17}<br>
	 * Original signature:<br>
	 * {@code showWords?: boolean; }<br>
	 */
	public ISuggestOptions showWords(@Nonnull Boolean value) {
		set("showWords", value);
		return this;
	}

 	/**
	 * <p>Prevent quick suggestions when a snippet is active. Defaults to true.</p>
	 * See {@code monaco.d.ts:3513:39}<br>
	 * Original signature:<br>
	 * {@code snippetsPreventQuickSuggestions?: boolean; }<br>
	 */
	public boolean snippetsPreventQuickSuggestions() { return get("snippetsPreventQuickSuggestions", ofMapped(boolean.class)); }

 	/**
	 * <p>Prevent quick suggestions when a snippet is active. Defaults to true.</p>
	 * See {@code monaco.d.ts:3513:39}<br>
	 * Original signature:<br>
	 * {@code snippetsPreventQuickSuggestions?: boolean; }<br>
	 */
	public ISuggestOptions snippetsPreventQuickSuggestions(@Nonnull Boolean value) {
		set("snippetsPreventQuickSuggestions", value);
		return this;
	}

 
}
