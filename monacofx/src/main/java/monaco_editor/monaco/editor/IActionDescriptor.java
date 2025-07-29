
package monaco_editor.monaco.editor;
import java.util.List;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsPromise;
import net.kurobako.monacofx.js.JsProxy;
import net.kurobako.monacofx.js.JsUnion2;
import netscape.javascript.JSObject;

/**
 * <p>Description of an action contribution</p>
 * See {@code monaco.d.ts:1021:38}<br>
 * Original signature:<br>
 * {@code export interface IActionDescriptor  }<br>
 */
@SuppressWarnings("unused")
public class IActionDescriptor extends JsProxy {

	public IActionDescriptor(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IActionDescriptor(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>Control if the action should show up in the context menu and where.
	 * The context menu of the editor has these default:
	 * navigation - The navigation group comes first in all cases.
	 * 1_modification - This group comes next and contains commands that modify your code.
	 * 9_cutcopypaste - The last default group with the basic editing commands.
	 * You can also create your own group.
	 * Defaults to null (don't show in context menu).</p>
	 * See {@code monaco.d.ts:1051:26}<br>
	 * Original signature:<br>
	 * {@code contextMenuGroupId?: string; }<br>
	 */
	public String contextMenuGroupId() { return get("contextMenuGroupId", ofMapped(String.class)); }

 	/**
	 * <p>Control if the action should show up in the context menu and where.
	 * The context menu of the editor has these default:
	 * navigation - The navigation group comes first in all cases.
	 * 1_modification - This group comes next and contains commands that modify your code.
	 * 9_cutcopypaste - The last default group with the basic editing commands.
	 * You can also create your own group.
	 * Defaults to null (don't show in context menu).</p>
	 * See {@code monaco.d.ts:1051:26}<br>
	 * Original signature:<br>
	 * {@code contextMenuGroupId?: string; }<br>
	 */
	public IActionDescriptor contextMenuGroupId(@Nonnull String value) {
		set("contextMenuGroupId", value);
		return this;
	}

 	/**
	 * <p>Control the order in the context menu group.</p>
	 * See {@code monaco.d.ts:1055:24}<br>
	 * Original signature:<br>
	 * {@code contextMenuOrder?: number; }<br>
	 */
	public double contextMenuOrder() { return get("contextMenuOrder", ofMapped(double.class)); }

 	/**
	 * <p>Control the order in the context menu group.</p>
	 * See {@code monaco.d.ts:1055:24}<br>
	 * Original signature:<br>
	 * {@code contextMenuOrder?: number; }<br>
	 */
	public IActionDescriptor contextMenuOrder(@Nonnull Double value) {
		set("contextMenuOrder", value);
		return this;
	}

 	/**
	 * <p>An unique identifier of the contributed action.</p>
	 * See {@code monaco.d.ts:1025:10}<br>
	 * Original signature:<br>
	 * {@code id: string; }<br>
	 */
	public String id() { return get("id", ofMapped(String.class)); }

 	/**
	 * <p>An unique identifier of the contributed action.</p>
	 * See {@code monaco.d.ts:1025:10}<br>
	 * Original signature:<br>
	 * {@code id: string; }<br>
	 */
	public IActionDescriptor id(@Nonnull String value) {
		set("id", value);
		return this;
	}

 	/**
	 * <p>The keybinding rule (condition on top of precondition).</p>
	 * See {@code monaco.d.ts:1041:25}<br>
	 * Original signature:<br>
	 * {@code keybindingContext?: string; }<br>
	 */
	public String keybindingContext() { return get("keybindingContext", ofMapped(String.class)); }

 	/**
	 * <p>The keybinding rule (condition on top of precondition).</p>
	 * See {@code monaco.d.ts:1041:25}<br>
	 * Original signature:<br>
	 * {@code keybindingContext?: string; }<br>
	 */
	public IActionDescriptor keybindingContext(@Nonnull String value) {
		set("keybindingContext", value);
		return this;
	}

 	/**
	 * <p>An array of keybindings for the action.</p>
	 * See {@code monaco.d.ts:1037:19}<br>
	 * Original signature:<br>
	 * {@code keybindings?: number[]; }<br>
	 */
	public List<Double> keybindings() { return get("keybindings", ofArray(ofMapped(double.class))); }

 	/**
	 * <p>An array of keybindings for the action.</p>
	 * See {@code monaco.d.ts:1037:19}<br>
	 * Original signature:<br>
	 * {@code keybindings?: number[]; }<br>
	 */
	public IActionDescriptor keybindings(@Nonnull List<Double> value) {
		
		return this;
	}

 	/**
	 * <p>A label of the action that will be presented to the user.</p>
	 * See {@code monaco.d.ts:1029:13}<br>
	 * Original signature:<br>
	 * {@code label: string; }<br>
	 */
	public String label() { return get("label", ofMapped(String.class)); }

 	/**
	 * <p>A label of the action that will be presented to the user.</p>
	 * See {@code monaco.d.ts:1029:13}<br>
	 * Original signature:<br>
	 * {@code label: string; }<br>
	 */
	public IActionDescriptor label(@Nonnull String value) {
		set("label", value);
		return this;
	}

 	/**
	 * <p>Precondition rule.</p>
	 * See {@code monaco.d.ts:1033:20}<br>
	 * Original signature:<br>
	 * {@code precondition?: string; }<br>
	 */
	public String precondition() { return get("precondition", ofMapped(String.class)); }

 	/**
	 * <p>Precondition rule.</p>
	 * See {@code monaco.d.ts:1033:20}<br>
	 * Original signature:<br>
	 * {@code precondition?: string; }<br>
	 */
	public IActionDescriptor precondition(@Nonnull String value) {
		set("precondition", value);
		return this;
	}

 	/**
	 * <p>Method that will be executed when the action is triggered.</p>
	 * See {@code monaco.d.ts:1060:11}<br>
	 * Original signature:<br>
	 * {@code run(editor: ICodeEditor, ...args: any[]): void | Promise<void>; }<br>
	 * 
	 * @param editor The editor instance is passed in as a convenience
	 */
	public JsUnion2<Void, JsPromise<Void>> run(@Nonnull ICodeEditor editor, @Nonnull List<JSObject> args) { return call("run", null /*union*/, editor, args); }

 
}
