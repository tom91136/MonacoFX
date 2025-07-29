
package monaco_editor.monaco.languages;

import net.kurobako.monacofx.js.JsEnum;

/**
 * See {@code monaco.d.ts:5174:34}<br>
 * Original signature:<br>
 * {@code export enum CompletionItemKind  }<br>
 */
@SuppressWarnings("unused")
public enum CompletionItemKind implements JsEnum<Integer> {
	/**
	 * See {@code monaco.d.ts:5180:13}<br>
	 * Original signature:<br>
	 * {@code Class = 5, }<br>
	 */
	Class(5),
	/**
	 * See {@code monaco.d.ts:5194:13}<br>
	 * Original signature:<br>
	 * {@code Color = 19, }<br>
	 */
	Color(19),
	/**
	 * See {@code monaco.d.ts:5189:16}<br>
	 * Original signature:<br>
	 * {@code Constant = 14, }<br>
	 */
	Constant(14),
	/**
	 * See {@code monaco.d.ts:5177:19}<br>
	 * Original signature:<br>
	 * {@code Constructor = 2, }<br>
	 */
	Constructor(2),
	/**
	 * See {@code monaco.d.ts:5197:19}<br>
	 * Original signature:<br>
	 * {@code Customcolor = 22, }<br>
	 */
	Customcolor(22),
	/**
	 * See {@code monaco.d.ts:5190:12}<br>
	 * Original signature:<br>
	 * {@code Enum = 15, }<br>
	 */
	Enum(15),
	/**
	 * See {@code monaco.d.ts:5191:18}<br>
	 * Original signature:<br>
	 * {@code EnumMember = 16, }<br>
	 */
	EnumMember(16),
	/**
	 * See {@code monaco.d.ts:5185:13}<br>
	 * Original signature:<br>
	 * {@code Event = 10, }<br>
	 */
	Event(10),
	/**
	 * See {@code monaco.d.ts:5178:13}<br>
	 * Original signature:<br>
	 * {@code Field = 3, }<br>
	 */
	Field(3),
	/**
	 * See {@code monaco.d.ts:5195:12}<br>
	 * Original signature:<br>
	 * {@code File = 20, }<br>
	 */
	File(20),
	/**
	 * See {@code monaco.d.ts:5198:14}<br>
	 * Original signature:<br>
	 * {@code Folder = 23, }<br>
	 */
	Folder(23),
	/**
	 * See {@code monaco.d.ts:5176:16}<br>
	 * Original signature:<br>
	 * {@code Function = 1, }<br>
	 */
	Function(1),
	/**
	 * See {@code monaco.d.ts:5182:17}<br>
	 * Original signature:<br>
	 * {@code Interface = 7, }<br>
	 */
	Interface(7),
	/**
	 * See {@code monaco.d.ts:5192:15}<br>
	 * Original signature:<br>
	 * {@code Keyword = 17, }<br>
	 */
	Keyword(17),
	/**
	 * See {@code monaco.d.ts:5175:14}<br>
	 * Original signature:<br>
	 * {@code Method = 0, }<br>
	 */
	Method(0),
	/**
	 * See {@code monaco.d.ts:5183:14}<br>
	 * Original signature:<br>
	 * {@code Module = 8, }<br>
	 */
	Module(8),
	/**
	 * See {@code monaco.d.ts:5186:16}<br>
	 * Original signature:<br>
	 * {@code Operator = 11, }<br>
	 */
	Operator(11),
	/**
	 * See {@code monaco.d.ts:5184:16}<br>
	 * Original signature:<br>
	 * {@code Property = 9, }<br>
	 */
	Property(9),
	/**
	 * See {@code monaco.d.ts:5196:17}<br>
	 * Original signature:<br>
	 * {@code Reference = 21, }<br>
	 */
	Reference(21),
	/**
	 * See {@code monaco.d.ts:5200:15}<br>
	 * Original signature:<br>
	 * {@code Snippet = 25 }<br>
	 */
	Snippet(25),
	/**
	 * See {@code monaco.d.ts:5181:14}<br>
	 * Original signature:<br>
	 * {@code Struct = 6, }<br>
	 */
	Struct(6),
	/**
	 * See {@code monaco.d.ts:5193:12}<br>
	 * Original signature:<br>
	 * {@code Text = 18, }<br>
	 */
	Text(18),
	/**
	 * See {@code monaco.d.ts:5199:21}<br>
	 * Original signature:<br>
	 * {@code TypeParameter = 24, }<br>
	 */
	TypeParameter(24),
	/**
	 * See {@code monaco.d.ts:5187:12}<br>
	 * Original signature:<br>
	 * {@code Unit = 12, }<br>
	 */
	Unit(12),
	/**
	 * See {@code monaco.d.ts:5188:13}<br>
	 * Original signature:<br>
	 * {@code Value = 13, }<br>
	 */
	Value(13),
	/**
	 * See {@code monaco.d.ts:5179:16}<br>
	 * Original signature:<br>
	 * {@code Variable = 4, }<br>
	 */
	Variable(4);
	private final int value;
	CompletionItemKind(int value) { this.value = value; }
	public Integer value() { return value; }
}
