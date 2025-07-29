
package monaco_editor.monaco.languages;

import net.kurobako.monacofx.js.JsEnum;

/**
 * <p>A symbol kind.</p>
 * See {@code monaco.d.ts:5643:26}<br>
 * Original signature:<br>
 * {@code export enum SymbolKind  }<br>
 */
@SuppressWarnings("unused")
public enum SymbolKind implements JsEnum<Integer> {
	/**
	 * See {@code monaco.d.ts:5661:13}<br>
	 * Original signature:<br>
	 * {@code Array = 17, }<br>
	 */
	Array(17),
	/**
	 * See {@code monaco.d.ts:5660:15}<br>
	 * Original signature:<br>
	 * {@code Boolean = 16, }<br>
	 */
	Boolean(16),
	/**
	 * See {@code monaco.d.ts:5648:13}<br>
	 * Original signature:<br>
	 * {@code Class = 4, }<br>
	 */
	Class(4),
	/**
	 * See {@code monaco.d.ts:5657:16}<br>
	 * Original signature:<br>
	 * {@code Constant = 13, }<br>
	 */
	Constant(13),
	/**
	 * See {@code monaco.d.ts:5652:19}<br>
	 * Original signature:<br>
	 * {@code Constructor = 8, }<br>
	 */
	Constructor(8),
	/**
	 * See {@code monaco.d.ts:5653:12}<br>
	 * Original signature:<br>
	 * {@code Enum = 9, }<br>
	 */
	Enum(9),
	/**
	 * See {@code monaco.d.ts:5665:18}<br>
	 * Original signature:<br>
	 * {@code EnumMember = 21, }<br>
	 */
	EnumMember(21),
	/**
	 * See {@code monaco.d.ts:5667:13}<br>
	 * Original signature:<br>
	 * {@code Event = 23, }<br>
	 */
	Event(23),
	/**
	 * See {@code monaco.d.ts:5651:13}<br>
	 * Original signature:<br>
	 * {@code Field = 7, }<br>
	 */
	Field(7),
	/**
	 * See {@code monaco.d.ts:5644:12}<br>
	 * Original signature:<br>
	 * {@code File = 0, }<br>
	 */
	File(0),
	/**
	 * See {@code monaco.d.ts:5655:16}<br>
	 * Original signature:<br>
	 * {@code Function = 11, }<br>
	 */
	Function(11),
	/**
	 * See {@code monaco.d.ts:5654:17}<br>
	 * Original signature:<br>
	 * {@code Interface = 10, }<br>
	 */
	Interface(10),
	/**
	 * See {@code monaco.d.ts:5663:11}<br>
	 * Original signature:<br>
	 * {@code Key = 19, }<br>
	 */
	Key(19),
	/**
	 * See {@code monaco.d.ts:5649:14}<br>
	 * Original signature:<br>
	 * {@code Method = 5, }<br>
	 */
	Method(5),
	/**
	 * See {@code monaco.d.ts:5645:14}<br>
	 * Original signature:<br>
	 * {@code Module = 1, }<br>
	 */
	Module(1),
	/**
	 * See {@code monaco.d.ts:5646:17}<br>
	 * Original signature:<br>
	 * {@code Namespace = 2, }<br>
	 */
	Namespace(2),
	/**
	 * See {@code monaco.d.ts:5664:12}<br>
	 * Original signature:<br>
	 * {@code Null = 20, }<br>
	 */
	Null(20),
	/**
	 * See {@code monaco.d.ts:5659:14}<br>
	 * Original signature:<br>
	 * {@code Number = 15, }<br>
	 */
	Number(15),
	/**
	 * See {@code monaco.d.ts:5662:14}<br>
	 * Original signature:<br>
	 * {@code Object = 18, }<br>
	 */
	Object(18),
	/**
	 * See {@code monaco.d.ts:5668:16}<br>
	 * Original signature:<br>
	 * {@code Operator = 24, }<br>
	 */
	Operator(24),
	/**
	 * See {@code monaco.d.ts:5647:15}<br>
	 * Original signature:<br>
	 * {@code Package = 3, }<br>
	 */
	Package(3),
	/**
	 * See {@code monaco.d.ts:5650:16}<br>
	 * Original signature:<br>
	 * {@code Property = 6, }<br>
	 */
	Property(6),
	/**
	 * See {@code monaco.d.ts:5658:14}<br>
	 * Original signature:<br>
	 * {@code String = 14, }<br>
	 */
	String(14),
	/**
	 * See {@code monaco.d.ts:5666:14}<br>
	 * Original signature:<br>
	 * {@code Struct = 22, }<br>
	 */
	Struct(22),
	/**
	 * See {@code monaco.d.ts:5669:21}<br>
	 * Original signature:<br>
	 * {@code TypeParameter = 25 }<br>
	 */
	TypeParameter(25),
	/**
	 * See {@code monaco.d.ts:5656:16}<br>
	 * Original signature:<br>
	 * {@code Variable = 12, }<br>
	 */
	Variable(12);
	private final int value;
	SymbolKind(int value) { this.value = value; }
	public Integer value() { return value; }
}
