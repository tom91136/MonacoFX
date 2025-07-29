
package monaco_editor.monaco;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import netscape.javascript.JSObject;

/**
 * <p>Uniform Resource Identifier (Uri) http://tools.ietf.org/html/rfc3986.
 * This class is a simple parser which creates the basic component parts
 * (http://tools.ietf.org/html/rfc3986#section-3) with minimal validation
 * and encoding.
 * foo://example.com:8042/over/there?name=ferret#nose
 * _/   ____________<strong>/_______<strong>/ _</strong></strong>___<em>/ _</em>/
 * |           |            |            |        |
 * scheme     authority       path        query   fragment
 * |   ___________________<strong>|</strong>
 * / \ /                        <br />
 * urn:example:animal:ferret:nose</p>
 * See {@code monaco.d.ts:83:20}<br>
 * Original signature:<br>
 * {@code export class Uri implements UriComponents  }<br>
 */
@SuppressWarnings("unused")
public class Uri extends JsProxy {

	public Uri(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public Uri(@Nonnull JsContext context) { super(context); }

 
	/**
	 * <p>authority is the 'www.msft.com' part of 'http://www.msft.com/some/path?query#fragment'.
	 * The part between the first double slashes and the next slash.</p>
	 * See {@code monaco.d.ts:94:26}<br>
	 * Original signature:<br>
	 * {@code readonly authority: string; }<br>
	 */
	public String authority() { return get("authority", ofMapped(String.class)); }

 	/**
	 * <p>fragment is the 'fragment' part of 'http://www.msft.com/some/path?query#fragment'.</p>
	 * See {@code monaco.d.ts:106:25}<br>
	 * Original signature:<br>
	 * {@code readonly fragment: string; }<br>
	 */
	public String fragment() { return get("fragment", ofMapped(String.class)); }

 	/**
	 * <p>path is the '/some/path' part of 'http://www.msft.com/some/path?query#fragment'.</p>
	 * See {@code monaco.d.ts:98:21}<br>
	 * Original signature:<br>
	 * {@code readonly path: string; }<br>
	 */
	public String path() { return get("path", ofMapped(String.class)); }

 	/**
	 * <p>query is the 'query' part of 'http://www.msft.com/some/path?query#fragment'.</p>
	 * See {@code monaco.d.ts:102:22}<br>
	 * Original signature:<br>
	 * {@code readonly query: string; }<br>
	 */
	public String query() { return get("query", ofMapped(String.class)); }

 	/**
	 * <p>scheme is the 'http' part of 'http://www.msft.com/some/path?query#fragment'.
	 * The part before the first colon.</p>
	 * See {@code monaco.d.ts:89:23}<br>
	 * Original signature:<br>
	 * {@code readonly scheme: string; }<br>
	 */
	public String scheme() { return get("scheme", ofMapped(String.class)); }

 	/**
	 * <p>Returns a string representing the corresponding file system path of this Uri.
	 * Will handle UNC paths, normalizes windows drive letters to lower-case, and uses the
	 * platform specific path separator.</p>
	 * <ul>
	 * <li>Will <em>not</em> validate the path for invalid characters and semantics.</li>
	 * <li>Will <em>not</em> look at the scheme of this Uri.</li>
	 * <li>The result shall <em>not</em> be used for display purposes but for accessing a file on disk.</li>
	 * </ul>
	 * <p>The <em>difference</em> to <code>Uri#path</code> is the use of the platform specific separator and the handling
	 * of UNC paths. See the below sample of a file-uri with an authority (UNC path).</p>
	 * <pre><code class="language-ts">const u = Uri.parse('file://server/c$/folder/file.txt')
	 * u.authority === 'server'
	 * u.path === '/shares/c$/file.txt'
	 * u.fsPath === '\\server\c$\folder\file.txt'
	 * </code></pre>
	 * <p>Using <code>Uri#path</code> to read a file (using fs-apis) would not be enough because parts of the path,
	 * namely the server name, would be missing. Therefore <code>Uri#fsPath</code> exists - it's sugar to ease working
	 * with URIs that represent files on disk (<code>file</code> scheme).</p>
	 * See {@code monaco.d.ts:131:18}<br>
	 * Original signature:<br>
	 * {@code get fsPath(): string; }<br>
	 */
	public String fsPath() { return get("fsPath", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:187:14}<br>
	 * Original signature:<br>
	 * {@code toJSON(): UriComponents; }<br>
	 */
	public UriComponents toJSON() { return call("toJSON", UriComponents::new); }

 	/**
	 * <p>Creates a string representation for this Uri. It's guaranteed that calling
	 * <code>Uri.parse</code> with the result of this function creates an Uri which is equal
	 * to this Uri.</p>
	 * <ul>
	 * <li>The result shall <em>not</em> be used for display purposes but for externalization or transport.</li>
	 * <li>The result will be encoded using the percentage encoding and encoding happens mostly
	 * ignore the scheme-specific encoding rules.</li>
	 * </ul>
	 * See {@code monaco.d.ts:186:16}<br>
	 * Original signature:<br>
	 * {@code toString(skipEncoding?: boolean): string; }<br>
	 * 
	 * @param skipEncoding Do not encode the result, default is <code>false</code>
	 */
	public String toString(@Nonnull Boolean skipEncoding) { return call("toString", ofMapped(String.class), skipEncoding); }

 	/**
	 * <p>Creates a string representation for this Uri. It's guaranteed that calling
	 * <code>Uri.parse</code> with the result of this function creates an Uri which is equal
	 * to this Uri.</p>
	 * <ul>
	 * <li>The result shall <em>not</em> be used for display purposes but for externalization or transport.</li>
	 * <li>The result will be encoded using the percentage encoding and encoding happens mostly
	 * ignore the scheme-specific encoding rules.</li>
	 * </ul>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:186:16}<br>
	 * Original signature:<br>
	 * {@code toString(skipEncoding?: boolean): string; }<br>
	 */
	public String toString() { return call("toString", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:132:12}<br>
	 * Original signature:<br>
	 * {@code with(change:  }<br>
	 */
	public Uri with(@Nonnull JSObject change) { return call("with", Uri::new, change); }

 	/**
	 * <p>Creates a new Uri from a file system path, e.g. <code>c:\my\files</code>,
	 * <code>/usr/home</code>, or <code>\\server\share\some\path</code>.
	 * The <em>difference</em> between <code>Uri#parse</code> and <code>Uri#file</code> is that the latter treats the argument
	 * as path, not as stringified-uri. E.g. <code>Uri.file(path)</code> is <strong>not the same as</strong>
	 * <code>Uri.parse('file://' + path)</code> because the path might contain characters that are
	 * interpreted (# and ?). See the following sample:</p>
	 * <pre><code class="language-ts">const good = Uri.file('/coding/c#/project1');
	 * good.scheme === 'file';
	 * good.path === '/coding/c#/project1';
	 * good.fragment === '';
	 * const bad = Uri.parse('file://' + '/coding/c#/project1');
	 * bad.scheme === 'file';
	 * bad.path === '/coding/c'; // path is now broken
	 * bad.fragment === '/project1';
	 * </code></pre>
	 * See {@code monaco.d.ts:167:19}<br>
	 * Original signature:<br>
	 * {@code static file(path: string): Uri; }<br>
	 * 
	 * @param path A file system path (see <code>Uri#fsPath</code>)
	 */
	public Uri file(@Nonnull String path) { return call("file", Uri::new, path); }

 	/**
	 * See {@code monaco.d.ts:168:19}<br>
	 * Original signature:<br>
	 * {@code static from(components:  }<br>
	 */
	public Uri from(@Nonnull JSObject components) { return call("from", Uri::new, components); }

 	/**
	 * See {@code monaco.d.ts:84:20}<br>
	 * Original signature:<br>
	 * {@code static isUri(thing: any): thing is Uri; }<br>
	 */
	public boolean isUri(@Nonnull JSObject thing) { return call("isUri", ofMapped(boolean.class), thing); }

 	/**
	 * <p>Creates a new Uri from a string, e.g. <code>http://www.msft.com/some/path</code>,
	 * <code>file:///usr/home</code>, or <code>scheme:with/path</code>.</p>
	 * <p><strong>This is an overloaded method resulting from TypeScript unions/intersections, see original for parameter docs</strong></p>
	 * See {@code monaco.d.ts:145:20}<br>
	 * Original signature:<br>
	 * {@code static parse(value: string, _strict?: boolean): Uri; }<br>
	 */
	public Uri parse(@Nonnull String value) { return call("parse", Uri::new, value); }

 	/**
	 * <p>Creates a new Uri from a string, e.g. <code>http://www.msft.com/some/path</code>,
	 * <code>file:///usr/home</code>, or <code>scheme:with/path</code>.</p>
	 * See {@code monaco.d.ts:145:20}<br>
	 * Original signature:<br>
	 * {@code static parse(value: string, _strict?: boolean): Uri; }<br>
	 * 
	 * @param value A string which represents an Uri (see <code>Uri#toString</code>).
	 */
	public Uri parse(@Nonnull String value, @Nonnull Boolean _strict) { return call("parse", Uri::new, value, _strict); }

 	/**
	 * See {@code monaco.d.ts:188:21}<br>
	 * See {@code monaco.d.ts:189:21}<br>
	 * See {@code monaco.d.ts:190:21}<br>
	 * See {@code monaco.d.ts:191:21}<br>
	 * Original signature:<br>
	 * {@code static revive(data: UriComponents | Uri): Uri; }<br>
	 * {@code static revive(data: UriComponents | Uri | undefined): Uri | undefined; }<br>
	 * {@code static revive(data: UriComponents | Uri | null): Uri | null; }<br>
	 * {@code static revive(data: UriComponents | Uri | undefined | null): Uri | undefined | null; }<br>
	 */
	public Optional<Uri> revive(@Nullable UriComponents data) { return Optional.ofNullable(call("revive", Uri::new, data)); }

 	/**
	 * See {@code monaco.d.ts:188:21}<br>
	 * See {@code monaco.d.ts:189:21}<br>
	 * See {@code monaco.d.ts:190:21}<br>
	 * See {@code monaco.d.ts:191:21}<br>
	 * Original signature:<br>
	 * {@code static revive(data: UriComponents | Uri): Uri; }<br>
	 * {@code static revive(data: UriComponents | Uri | undefined): Uri | undefined; }<br>
	 * {@code static revive(data: UriComponents | Uri | null): Uri | null; }<br>
	 * {@code static revive(data: UriComponents | Uri | undefined | null): Uri | undefined | null; }<br>
	 */
	public Optional<Uri> revive(@Nullable Uri data) { return Optional.ofNullable(call("revive", Uri::new, data)); }

 
}
