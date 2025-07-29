
package monaco_editor.monaco.languages.typescript;

import net.kurobako.monacofx.js.JsEnum;

/**
 * See {@code monaco.d.ts:6227:36}<br>
 * Original signature:<br>
 * {@code export enum ModuleResolutionKind  }<br>
 */
@SuppressWarnings("unused")
public enum ModuleResolutionKind implements JsEnum<Integer> {
	/**
	 * See {@code monaco.d.ts:6228:15}<br>
	 * Original signature:<br>
	 * {@code Classic = 1, }<br>
	 */
	Classic(1),
	/**
	 * See {@code monaco.d.ts:6229:14}<br>
	 * Original signature:<br>
	 * {@code NodeJs = 2 }<br>
	 */
	NodeJs(2);
	private final int value;
	ModuleResolutionKind(int value) { this.value = value; }
	public Integer value() { return value; }
}
