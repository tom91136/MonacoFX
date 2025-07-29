
package monaco_editor.monaco.languages;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import net.kurobako.monacofx.js.JsUnion4;
import netscape.javascript.JSObject;

/**
 * See {@code monaco.d.ts:6104:51}<br>
 * Original signature:<br>
 * {@code export interface IExpandedMonarchLanguageAction  }<br>
 */
@SuppressWarnings("unused")
public class IExpandedMonarchLanguageAction extends JsProxy {

	public IExpandedMonarchLanguageAction(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public IExpandedMonarchLanguageAction(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:6132:15}<br>
	 * Original signature:<br>
	 * {@code bracket?: string; }<br>
	 */
	public String bracket() { return get("bracket", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:6132:15}<br>
	 * Original signature:<br>
	 * {@code bracket?: string; }<br>
	 */
	public IExpandedMonarchLanguageAction bracket(@Nonnull String value) {
		set("bracket", value);
		return this;
	}

 	/**
	 * <p>map from string to ILanguageAction</p>
	 * See {@code monaco.d.ts:6112:13}<br>
	 * Original signature:<br>
	 * {@code cases?: Object; }<br>
	 */
	public JSObject cases() { return get("cases", ofMapped(JSObject.class)); }

 	/**
	 * <p>map from string to ILanguageAction</p>
	 * See {@code monaco.d.ts:6112:13}<br>
	 * Original signature:<br>
	 * {@code cases?: Object; }<br>
	 */
	public IExpandedMonarchLanguageAction cases(@Nonnull JSObject value) {
		set("cases", value);
		return this;
	}

 	/**
	 * <p>go back n characters in the stream</p>
	 * See {@code monaco.d.ts:6128:14}<br>
	 * Original signature:<br>
	 * {@code goBack?: number; }<br>
	 */
	public double goBack() { return get("goBack", ofMapped(double.class)); }

 	/**
	 * <p>go back n characters in the stream</p>
	 * See {@code monaco.d.ts:6128:14}<br>
	 * Original signature:<br>
	 * {@code goBack?: number; }<br>
	 */
	public IExpandedMonarchLanguageAction goBack(@Nonnull Double value) {
		set("goBack", value);
		return this;
	}

 	/**
	 * <p>array of actions for each parenthesized match group</p>
	 * See {@code monaco.d.ts:6108:13}<br>
	 * Original signature:<br>
	 * {@code group?: IMonarchLanguageAction[]; }<br>
	 */
	public Optional<JsUnion4<List<String>, List<IExpandedMonarchLanguageAction>, List<List<String>>, List<List<IExpandedMonarchLanguageAction>>>> group() { return Optional.ofNullable(get("group", null /*union*/)); }

 	/**
	 * <p>array of actions for each parenthesized match group</p>
	 * See {@code monaco.d.ts:6108:13}<br>
	 * Original signature:<br>
	 * {@code group?: IMonarchLanguageAction[]; }<br>
	 */
	public IExpandedMonarchLanguageAction group(@Nullable JsUnion4<List<String>, List<IExpandedMonarchLanguageAction>, List<List<String>>, List<List<IExpandedMonarchLanguageAction>>> value) {
		set("group", value);
		return this;
	}

 	/**
	 * <p>log a message to the browser console window</p>
	 * See {@code monaco.d.ts:6140:11}<br>
	 * Original signature:<br>
	 * {@code log?: string; }<br>
	 */
	public String log() { return get("log", ofMapped(String.class)); }

 	/**
	 * <p>log a message to the browser console window</p>
	 * See {@code monaco.d.ts:6140:11}<br>
	 * Original signature:<br>
	 * {@code log?: string; }<br>
	 */
	public IExpandedMonarchLanguageAction log(@Nonnull String value) {
		set("log", value);
		return this;
	}

 	/**
	 * <p>the next state to push, or &quot;@push&quot;, &quot;@pop&quot;, &quot;@popall&quot;</p>
	 * See {@code monaco.d.ts:6120:12}<br>
	 * Original signature:<br>
	 * {@code next?: string; }<br>
	 */
	public String next() { return get("next", ofMapped(String.class)); }

 	/**
	 * <p>the next state to push, or &quot;@push&quot;, &quot;@pop&quot;, &quot;@popall&quot;</p>
	 * See {@code monaco.d.ts:6120:12}<br>
	 * Original signature:<br>
	 * {@code next?: string; }<br>
	 */
	public IExpandedMonarchLanguageAction next(@Nonnull String value) {
		set("next", value);
		return this;
	}

 	/**
	 * <p>switch to embedded language (using the mimetype) or get out using &quot;@pop&quot;</p>
	 * See {@code monaco.d.ts:6136:20}<br>
	 * Original signature:<br>
	 * {@code nextEmbedded?: string; }<br>
	 */
	public String nextEmbedded() { return get("nextEmbedded", ofMapped(String.class)); }

 	/**
	 * <p>switch to embedded language (using the mimetype) or get out using &quot;@pop&quot;</p>
	 * See {@code monaco.d.ts:6136:20}<br>
	 * Original signature:<br>
	 * {@code nextEmbedded?: string; }<br>
	 */
	public IExpandedMonarchLanguageAction nextEmbedded(@Nonnull String value) {
		set("nextEmbedded", value);
		return this;
	}

 	/**
	 * <p>switch to this state</p>
	 * See {@code monaco.d.ts:6124:16}<br>
	 * Original signature:<br>
	 * {@code switchTo?: string; }<br>
	 */
	public String switchTo() { return get("switchTo", ofMapped(String.class)); }

 	/**
	 * <p>switch to this state</p>
	 * See {@code monaco.d.ts:6124:16}<br>
	 * Original signature:<br>
	 * {@code switchTo?: string; }<br>
	 */
	public IExpandedMonarchLanguageAction switchTo(@Nonnull String value) {
		set("switchTo", value);
		return this;
	}

 	/**
	 * <p>token class (ie. css class) (or &quot;@brackets&quot; or &quot;@rematch&quot;)</p>
	 * See {@code monaco.d.ts:6116:13}<br>
	 * Original signature:<br>
	 * {@code token?: string; }<br>
	 */
	public String token() { return get("token", ofMapped(String.class)); }

 	/**
	 * <p>token class (ie. css class) (or &quot;@brackets&quot; or &quot;@rematch&quot;)</p>
	 * See {@code monaco.d.ts:6116:13}<br>
	 * Original signature:<br>
	 * {@code token?: string; }<br>
	 */
	public IExpandedMonarchLanguageAction token(@Nonnull String value) {
		set("token", value);
		return this;
	}

 
}
