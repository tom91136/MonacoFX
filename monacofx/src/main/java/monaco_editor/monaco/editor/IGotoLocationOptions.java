
package monaco_editor.monaco.editor;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * <p>Configuration options for go to location</p>
 * See {@code monaco.d.ts:3178:41}<br>
 * Original signature:<br>
 * {@code export interface IGotoLocationOptions  }<br>
 */
@SuppressWarnings("unused")
public class IGotoLocationOptions extends JsProxy {

	public IGotoLocationOptions(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IGotoLocationOptions(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:3187:37}<br>
	 * Original signature:<br>
	 * {@code alternativeDeclarationCommand?: string; }<br>
	 */
	public String alternativeDeclarationCommand() { return get("alternativeDeclarationCommand", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:3187:37}<br>
	 * Original signature:<br>
	 * {@code alternativeDeclarationCommand?: string; }<br>
	 */
	public IGotoLocationOptions alternativeDeclarationCommand(@Nonnull String value) {
		set("alternativeDeclarationCommand", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:3185:36}<br>
	 * Original signature:<br>
	 * {@code alternativeDefinitionCommand?: string; }<br>
	 */
	public String alternativeDefinitionCommand() { return get("alternativeDefinitionCommand", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:3185:36}<br>
	 * Original signature:<br>
	 * {@code alternativeDefinitionCommand?: string; }<br>
	 */
	public IGotoLocationOptions alternativeDefinitionCommand(@Nonnull String value) {
		set("alternativeDefinitionCommand", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:3188:40}<br>
	 * Original signature:<br>
	 * {@code alternativeImplementationCommand?: string; }<br>
	 */
	public String alternativeImplementationCommand() { return get("alternativeImplementationCommand", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:3188:40}<br>
	 * Original signature:<br>
	 * {@code alternativeImplementationCommand?: string; }<br>
	 */
	public IGotoLocationOptions alternativeImplementationCommand(@Nonnull String value) {
		set("alternativeImplementationCommand", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:3189:35}<br>
	 * Original signature:<br>
	 * {@code alternativeReferenceCommand?: string; }<br>
	 */
	public String alternativeReferenceCommand() { return get("alternativeReferenceCommand", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:3189:35}<br>
	 * Original signature:<br>
	 * {@code alternativeReferenceCommand?: string; }<br>
	 */
	public IGotoLocationOptions alternativeReferenceCommand(@Nonnull String value) {
		set("alternativeReferenceCommand", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:3186:40}<br>
	 * Original signature:<br>
	 * {@code alternativeTypeDefinitionCommand?: string; }<br>
	 */
	public String alternativeTypeDefinitionCommand() { return get("alternativeTypeDefinitionCommand", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:3186:40}<br>
	 * Original signature:<br>
	 * {@code alternativeTypeDefinitionCommand?: string; }<br>
	 */
	public IGotoLocationOptions alternativeTypeDefinitionCommand(@Nonnull String value) {
		set("alternativeTypeDefinitionCommand", value);
		return this;
	}

 
}
