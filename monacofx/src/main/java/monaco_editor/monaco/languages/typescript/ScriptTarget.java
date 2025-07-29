
package monaco_editor.monaco.languages.typescript;

import net.kurobako.monacofx.js.JsEnum;

/**
 * See {@code monaco.d.ts:6213:21}<br>
 * Original signature:<br>
 * {@code enum ScriptTarget  }<br>
 */
@SuppressWarnings("unused")
public enum ScriptTarget implements JsEnum<Integer> {
	/**
	 * See {@code monaco.d.ts:6216:14}<br>
	 * Original signature:<br>
	 * {@code ES2015 = 2, }<br>
	 */
	ES2015(2),
	/**
	 * See {@code monaco.d.ts:6217:14}<br>
	 * Original signature:<br>
	 * {@code ES2016 = 3, }<br>
	 */
	ES2016(3),
	/**
	 * See {@code monaco.d.ts:6218:14}<br>
	 * Original signature:<br>
	 * {@code ES2017 = 4, }<br>
	 */
	ES2017(4),
	/**
	 * See {@code monaco.d.ts:6219:14}<br>
	 * Original signature:<br>
	 * {@code ES2018 = 5, }<br>
	 */
	ES2018(5),
	/**
	 * See {@code monaco.d.ts:6220:14}<br>
	 * Original signature:<br>
	 * {@code ES2019 = 6, }<br>
	 */
	ES2019(6),
	/**
	 * See {@code monaco.d.ts:6221:14}<br>
	 * Original signature:<br>
	 * {@code ES2020 = 7, }<br>
	 */
	ES2020(7),
	/**
	 * See {@code monaco.d.ts:6214:11}<br>
	 * Original signature:<br>
	 * {@code ES3 = 0, }<br>
	 */
	ES3(0),
	/**
	 * See {@code monaco.d.ts:6215:11}<br>
	 * Original signature:<br>
	 * {@code ES5 = 1, }<br>
	 */
	ES5(1),
	/**
	 * See {@code monaco.d.ts:6222:14}<br>
	 * Original signature:<br>
	 * {@code ESNext = 99, }<br>
	 */
	ESNext(99),
	/**
	 * See {@code monaco.d.ts:6223:12}<br>
	 * Original signature:<br>
	 * {@code JSON = 100, }<br>
	 */
	JSON(100),
	/**
	 * See {@code monaco.d.ts:6224:14}<br>
	 * Original signature:<br>
	 * {@code Latest = ESNext, }<br>
	 */
	Latest(99);
	private final int value;
	ScriptTarget(int value) { this.value = value; }
	public Integer value() { return value; }
}
