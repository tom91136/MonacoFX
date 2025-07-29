
package monaco_editor.monaco.languages.typescript;
import java.util.List;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:6365:24}<br>
 * Original signature:<br>
 * {@code interface EmitOutput  }<br>
 */
@SuppressWarnings("unused")
public class EmitOutput extends JsProxy {

	public EmitOutput(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public EmitOutput(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:6367:19}<br>
	 * Original signature:<br>
	 * {@code emitSkipped: boolean; }<br>
	 */
	public boolean emitSkipped() { return get("emitSkipped", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6367:19}<br>
	 * Original signature:<br>
	 * {@code emitSkipped: boolean; }<br>
	 */
	public EmitOutput emitSkipped(@Nonnull Boolean value) {
		set("emitSkipped", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6366:19}<br>
	 * Original signature:<br>
	 * {@code outputFiles: OutputFile[]; }<br>
	 */
	public List<OutputFile> outputFiles() { return get("outputFiles", ofArray(OutputFile::new)); }

 	/**
	 * See {@code monaco.d.ts:6366:19}<br>
	 * Original signature:<br>
	 * {@code outputFiles: OutputFile[]; }<br>
	 */
	public EmitOutput outputFiles(@Nonnull List<OutputFile> value) {
		
		return this;
	}

 
}
