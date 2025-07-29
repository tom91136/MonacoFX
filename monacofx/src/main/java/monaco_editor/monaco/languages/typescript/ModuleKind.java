
package monaco_editor.monaco.languages.typescript;

import net.kurobako.monacofx.js.JsEnum;

/**
 * See {@code monaco.d.ts:6192:19}<br>
 * Original signature:<br>
 * {@code enum ModuleKind  }<br>
 */
@SuppressWarnings("unused")
public enum ModuleKind implements JsEnum<Integer> {
	/**
	 * See {@code monaco.d.ts:6195:11}<br>
	 * Original signature:<br>
	 * {@code AMD = 2, }<br>
	 */
	AMD(2),
	/**
	 * See {@code monaco.d.ts:6194:16}<br>
	 * Original signature:<br>
	 * {@code CommonJS = 1, }<br>
	 */
	CommonJS(1),
	/**
	 * See {@code monaco.d.ts:6198:14}<br>
	 * Original signature:<br>
	 * {@code ES2015 = 5, }<br>
	 */
	ES2015(5),
	/**
	 * See {@code monaco.d.ts:6199:14}<br>
	 * Original signature:<br>
	 * {@code ESNext = 99 }<br>
	 */
	ESNext(99),
	/**
	 * See {@code monaco.d.ts:6193:12}<br>
	 * Original signature:<br>
	 * {@code None = 0, }<br>
	 */
	None(0),
	/**
	 * See {@code monaco.d.ts:6197:14}<br>
	 * Original signature:<br>
	 * {@code System = 4, }<br>
	 */
	System(4),
	/**
	 * See {@code monaco.d.ts:6196:11}<br>
	 * Original signature:<br>
	 * {@code UMD = 3, }<br>
	 */
	UMD(3);
	private final int value;
	ModuleKind(int value) { this.value = value; }
	public Integer value() { return value; }
}
