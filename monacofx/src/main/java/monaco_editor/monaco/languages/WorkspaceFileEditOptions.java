
package monaco_editor.monaco.languages;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:5934:45}<br>
 * Original signature:<br>
 * {@code export interface WorkspaceFileEditOptions  }<br>
 */
@SuppressWarnings("unused")
public class WorkspaceFileEditOptions extends JsProxy {

	public WorkspaceFileEditOptions(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public WorkspaceFileEditOptions(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:5937:22}<br>
	 * Original signature:<br>
	 * {@code ignoreIfExists?: boolean; }<br>
	 */
	public boolean ignoreIfExists() { return get("ignoreIfExists", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:5937:22}<br>
	 * Original signature:<br>
	 * {@code ignoreIfExists?: boolean; }<br>
	 */
	public WorkspaceFileEditOptions ignoreIfExists(@Nonnull Boolean value) {
		set("ignoreIfExists", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5936:25}<br>
	 * Original signature:<br>
	 * {@code ignoreIfNotExists?: boolean; }<br>
	 */
	public boolean ignoreIfNotExists() { return get("ignoreIfNotExists", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:5936:25}<br>
	 * Original signature:<br>
	 * {@code ignoreIfNotExists?: boolean; }<br>
	 */
	public WorkspaceFileEditOptions ignoreIfNotExists(@Nonnull Boolean value) {
		set("ignoreIfNotExists", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5935:17}<br>
	 * Original signature:<br>
	 * {@code overwrite?: boolean; }<br>
	 */
	public boolean overwrite() { return get("overwrite", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:5935:17}<br>
	 * Original signature:<br>
	 * {@code overwrite?: boolean; }<br>
	 */
	public WorkspaceFileEditOptions overwrite(@Nonnull Boolean value) {
		set("overwrite", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:5938:17}<br>
	 * Original signature:<br>
	 * {@code recursive?: boolean; }<br>
	 */
	public boolean recursive() { return get("recursive", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:5938:17}<br>
	 * Original signature:<br>
	 * {@code recursive?: boolean; }<br>
	 */
	public WorkspaceFileEditOptions recursive(@Nonnull Boolean value) {
		set("recursive", value);
		return this;
	}

 
}
