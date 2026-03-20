package net.kurobako.monacofx;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Objects;
import java.util.function.Consumer;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.concurrent.Worker.State;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import monaco_editor.MonacoModule;
import monaco_editor.monaco.editor.IStandaloneEditorConstructionOptions;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;
import netscape.javascript.JSObject;

/**
 * A JavaFX pane that embeds a full Monaco (VS Code) editor inside a {@link WebView}.
 *
 * <p>MonacoPane serves the bundled Monaco distribution into a WebView via a {@code classpath:} URL protocol handler,
 * and exposes the editor through a typed Java API generated from Monaco's TypeScript definitions. A two-way JavaScript
 * bridge handles clipboard, console output, scroll events, and editor resizing.
 *
 * <h3>Basic usage</h3>
 *
 * <pre>{@code
 * // Default editor (TypeScript, dark theme)
 * var pane = new MonacoPane();
 * stage.setScene(new Scene(pane, 800, 600));
 * }</pre>
 *
 * <h3>Custom setup</h3>
 *
 * <pre>{@code
 * var pane = new MonacoPane(ctx -> {
 *     var opts = new IStandaloneEditorConstructionOptions(ctx)
 *             .language("java")
 *             .theme("vs")
 *             .value("public class Hello {}")
 *             .automaticLayout(true);
 *     var editor = ctx.monaco().editor().create(ctx.editorElement(), opts);
 *
 *     // React to content changes
 *     editor.onDidChangeModelContent(e ->
 *             System.out.println("Changed: " + editor.getValue()));
 * });
 * }</pre>
 *
 * <p>The setup callback fires once on the JavaFX Application Thread after Monaco has loaded. The {@link MonacoContext}
 * gives access to the full {@code monaco.*} API through generated Java proxy classes.
 *
 * @see MonacoContext
 * @see monaco_editor.MonacoModule
 */
public class MonacoPane extends StackPane {

    private static final String VENDOR = "/vendor";

    private static final String EDITOR_HTML = "<!doctype html><html lang=\"en\"><head>"
            + "<meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\">"
            + "<style>html,body{margin:0;overflow:hidden;width:100%;height:100%;background-color:#1e1e1e}</style>"
            + "</head><body>"
            + "<div id=\"editor\" style=\"position:absolute;top:0;left:0;bottom:0;right:0;overflow:hidden\"></div>"
            + "</body></html>";

    private static final String JS_INIT_MONACO = "(function(){"
            + "  require.config({paths:{'vs':'classpath:///vendor/vs'}});"
            + "  require(['vs/editor/editor.main'],function(){window['bridge'](document.getElementById('editor'));});"
            + "})()";

    private static final String REQUIRE_JS;

    static {
        try (var s = Objects.requireNonNull(MonacoPane.class.getResource(VENDOR + "/require.js"))
                .openConnection()
                .getInputStream()) {
            REQUIRE_JS = new String(s.readAllBytes(), UTF_8);
        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    @SuppressWarnings("unused")
    private volatile MonacoContext pendingCtx;

    private final ObjectProperty<MonacoContext> editor = new SimpleObjectProperty<>(null);
    private final WebView webView;
    private final IntegerProperty scrollDeltaLines = new SimpleIntegerProperty(5);

    /** Returns the context once Monaco has loaded, or {@code null} if not yet ready. */
    @Nullable
    public MonacoContext getEditor() {
        return editor.get();
    }
    /** Observable property set once when Monaco finishes loading in the WebView. */
    @Nonnull
    public ObjectProperty<MonacoContext> editorProperty() {
        return editor;
    }

    /** Lines scrolled per mouse wheel notch. */
    public int getScrollDeltaLines() {
        return scrollDeltaLines.get();
    }

    /** Lines scrolled per mouse wheel notch. */
    public void setScrollDeltaLines(int lines) {
        scrollDeltaLines.set(lines);
    }

    /** Lines scrolled per mouse wheel notch. Default is {@code 5}. */
    @Nonnull
    public IntegerProperty scrollDeltaLinesProperty() {
        return scrollDeltaLines;
    }

    /** Returns the {@link WebView} that hosts the Monaco editor. */
    @Nonnull
    public WebView getWebView() {
        return webView;
    }

    /**
     * Forwarded to the WebEngine as {@code window.__javaConsole} so JS console output can be captured on the Java side.
     * Must be public with public methods for WebEngine's reflection-based bridge to work.
     */
    public static final class ConsoleBridge {
        private final PrintStream out;

        /** @param out stream to receive JS console messages */
        public ConsoleBridge(PrintStream out) {
            this.out = out;
        }

        /** Called from JS to forward a console message. */
        public void log(String msg) {
            out.println("[JS] " + msg);
        }
    }

    /**
     * Exposed to the WebEngine as {@code window.__javaClip} so Monaco JS can read/write the system clipboard during
     * paste. Must be public with public methods for WebEngine's reflection-based bridge to work.
     */
    public static final class ClipboardBridge {
        /** Reads the system clipboard text, returning empty string if none. */
        @Nonnull
        public String read() {
            String s = Clipboard.getSystemClipboard().getString();
            return s != null ? s : "";
        }

        /** Writes text to the system clipboard. No-op if text is null or empty. */
        public void write(@Nullable String text) {
            if (text == null || text.isEmpty()) return;
            var cc = new ClipboardContent();
            cc.putString(text);
            Clipboard.getSystemClipboard().setContent(cc);
        }
    }

    /**
     * Bridge between Java and the Monaco editor instance running inside the WebView. Provides access to the
     * {@code monaco} global object and the DOM container element.
     */
    public static class MonacoContext extends JsContext {
        private JSObject element;
        private MonacoModule monaco;

        MonacoContext(WebEngine engine) {
            super(engine);
        }

        private void initialise(JSObject element, MonacoModule monaco) {
            this.element = Objects.requireNonNull(element);
            this.monaco = Objects.requireNonNull(monaco);
        }

        /** Returns the DOM element that contains the Monaco editor. */
        @Nonnull
        public JSObject editorElement() {
            return element;
        }

        /** Returns the typed {@code monaco} global -- entry point for the full editor API. */
        @Nonnull
        public MonacoModule monaco() {
            return monaco;
        }
    }

    // Polyfills navigator.clipboard (Clipboard API) using the Java ClipboardBridge.
    // JavaFX WebView doesn't implement this API, so Monaco's clipboard.write() throws on focus.
    private static final String JS_CLIPBOARD_POLYFILL = "(function(){" + "  if(!window.__javaClip)return;"
            +
            // Minimal Blob polyfill --WebView may lack it entirely.
            "  if(typeof Blob==='undefined'){"
            + "    window.Blob=function Blob(parts,opts){"
            + "      this._text=(parts||[]).map(function(p){return typeof p==='string'?p:''}).join('');"
            + "      this.type=(opts&&opts.type)||'';"
            + "      this.size=this._text.length;"
            + "    };"
            + "    Blob.prototype.text=function(){return Promise.resolve(this._text);};"
            + "    Blob.prototype.arrayBuffer=function(){"
            + "      var enc=new TextEncoder();return Promise.resolve(enc.encode(this._text).buffer);"
            + "    };"
            + "  }"
            +
            // ClipboardItem polyfill --values can be String, Blob, or Promise<Blob>.
            "  if(typeof ClipboardItem==='undefined'){"
            + "    window.ClipboardItem=function ClipboardItem(items){this._items=items;};"
            + "    ClipboardItem.prototype.getType=function(t){"
            + "      var v=this._items[t];"
            + "      if(v===undefined)return Promise.reject(new Error('type not found: '+t));"
            + "      if(v instanceof Blob)return Promise.resolve(v);"
            + "      if(typeof v==='string')return Promise.resolve(new Blob([v],{type:t}));"
            + "      if(v&&typeof v.then==='function')return v.then(function(r){"
            + "        return r instanceof Blob?r:new Blob([String(r)],{type:t});"
            + "      });"
            + "      return Promise.resolve(new Blob([String(v)],{type:t}));"
            + "    };"
            + "    Object.defineProperty(ClipboardItem.prototype,'types',{"
            + "      get:function(){return Object.keys(this._items);}"
            + "    });"
            + "  }"
            +
            // navigator.clipboard backed by Java bridge.
            // Monaco cancels pending clipboard writes on every re-focus, producing harmless
            // rejections --catch them silently so they don't spam the console.
            "  var clip={"
            + "    readText:function(){return Promise.resolve(window.__javaClip.read());},"
            + "    writeText:function(t){window.__javaClip.write(t);return Promise.resolve();},"
            + "    read:function(){"
            + "      var t=window.__javaClip.read();"
            + "      var blob=new Blob([t],{type:'text/plain'});"
            + "      var item=new ClipboardItem({'text/plain':blob});"
            + "      return Promise.resolve([item]);"
            + "    },"
            + "    write:function(items){"
            + "      if(!items||!items.length)return Promise.resolve();"
            + "      var item=items[0];"
            + "      if(!item||!item.getType)return Promise.resolve();"
            + "      return item.getType('text/plain').then(function(blob){"
            + "        return blob.text();"
            + "      }).then(function(t){"
            + "        window.__javaClip.write(t);"
            + "      }).catch(function(){});"
            + // swallow cancellation/rejection errors
            "    }"
            + "  };"
            + "  Object.defineProperty(navigator,'clipboard',{value:clip,writable:false,configurable:true});"
            + "})()";

    // Redirects console.{log,warn,error,info} to window.__javaConsole.log().
    // Also installs window.onerror and unhandledrejection handlers so uncaught
    // JS errors surface as [JS] error: lines on the Java console.
    private static final String JS_CONSOLE_BRIDGE = "(function(){" + "  if(!window.__javaConsole)return;"
            + "  function str(x){"
            + "    if(x instanceof Error)return x.stack||x.toString();"
            + "    if(typeof x==='object'){try{var s=JSON.stringify(x);return s==='{}' ? String(x):s;}catch(e){return String(x);}}"
            + "    return String(x);"
            + "  }"
            + "  function fmt(args){"
            + "    var a=Array.prototype.slice.call(args);"
            +
            // Strip %c format specifiers and their corresponding style arguments.
            "    if(a.length>0&&typeof a[0]==='string'){"
            + "      var parts=[];var ai=1;var f=a[0];"
            + "      var re=/%[coOdifs]/g;var m;var last=0;"
            + "      while((m=re.exec(f))!==null){"
            + "        parts.push(f.substring(last,m.index));"
            + "        if(m[0]==='%c'){ai++;}else if(ai<a.length){"
            + "          parts.push(str(a[ai]));ai++;"
            + "        }"
            + "        last=re.lastIndex;"
            + "      }"
            + "      parts.push(f.substring(last));"
            + "      var rest=a.slice(ai).map(str);"
            + "      return parts.join('').trim()+(rest.length?' '+rest.join(' '):'');"
            + "    }"
            + "    return a.map(str).join(' ');"
            + "  }"
            + "  ['log','warn','error','info'].forEach(function(m){"
            + "    console[m]=function(){"
            + "      var s=fmt(arguments);"
            + "      if(s)window.__javaConsole.log(m+': '+s);"
            + "    };"
            + "  });"
            + "  window.onerror=function(msg,src,line,col,err){"
            + "    window.__javaConsole.log('error: [uncaught] '+msg+(err?' | '+err.stack:''));"
            + "  };"
            + "  window.addEventListener('unhandledrejection',function(e){"
            + "    window.__javaConsole.log('error: [unhandled promise] '+e.reason);"
            + "  });"
            + "})()";

    // Returns the selected text in the active Monaco editor, or null.
    private static final String JS_GET_SELECTION =
            "(function(){" + "  if(typeof monaco==='undefined'||!monaco.editor)return null;"
                    + "  var active=document.activeElement;"
                    + "  var all=monaco.editor.getEditors?monaco.editor.getEditors():[];"
                    + "  var ed=null;"
                    + "  for(var i=0;i<all.length;i++){"
                    + "    var c=all[i].getContainerDomNode&&all[i].getContainerDomNode();"
                    + "    if(c&&c.contains(active)){ed=all[i];break;}"
                    + "  }"
                    + "  if(!ed&&all.length===1)ed=all[0];"
                    + "  return ed?ed.getModel().getValueInRange(ed.getSelection()):null;"
                    + "})()";

    // Deletes the current selection (used for cut after clipboard is already written).
    private static final String JS_DELETE_SELECTION =
            "(function(){" + "  if(typeof monaco==='undefined'||!monaco.editor)return;"
                    + "  var active=document.activeElement;"
                    + "  var all=monaco.editor.getEditors?monaco.editor.getEditors():[];"
                    + "  var ed=null;"
                    + "  for(var i=0;i<all.length;i++){"
                    + "    var c=all[i].getContainerDomNode&&all[i].getContainerDomNode();"
                    + "    if(c&&c.contains(active)){ed=all[i];break;}"
                    + "  }"
                    + "  if(!ed&&all.length===1)ed=all[0];"
                    + "  if(ed)ed.executeEdits('cut',[{range:ed.getSelection(),text:'',forceMoveMarkers:true}]);"
                    + "})()";

    // Synthesizes a WheelEvent at the cursor position and dispatches it into the DOM.
    // Monaco attaches its own wheel listeners to the editor container and all overlay widgets,
    // so they receive and handle the event without any Monaco-specific API calls here.
    // With overflow:hidden on html/body, any events that bubble past Monaco's handlers
    // cannot move the WebKit viewport.
    // JavaFX dy: negative = scroll down; WheelEvent deltaY: positive = scroll down -> invert in Java.
    private static final String JS_SCROLL_BY = "(function(dy,dx,mx,my){" + "  var t=document.elementFromPoint(mx,my);"
            + "  if(t)t.dispatchEvent(new WheelEvent('wheel',{"
            + "    bubbles:true,cancelable:true,"
            + "    deltaY:dy,deltaX:dx,deltaMode:WheelEvent.DOM_DELTA_LINE"
            + "  }));"
            + "})(%s,%s,%s,%s)";

    // Initialises Monaco's clipboard service to use the Java ClipboardBridge.
    // Called after Monaco loads but before the user's setup lambda, so
    // StandaloneServices.initialize() picks up the override for all editors.
    // Monaco's built-in BrowserClipboardService uses navigator.clipboard which
    // requires user gestures and lacks triggerPaste in non-Electron contexts;
    // this replacement makes all clipboard operations (keyboard, context menu,
    // command palette) work through the Java system clipboard.
    private static final String JS_CLIPBOARD_SERVICE = "(function(){" + "  if(!window.__javaClip)return;"
            + "  var typeMap={};"
            + "  var findText='';"
            + "  var resources=[];"
            + "  var resourcesHash=undefined;"
            +
            // Polyfill DataTransfer.items for paste events --WebView's DataTransfer
            // lacks the DataTransferItemList that Monaco's paste handler expects.
            "  document.addEventListener('paste',function(e){"
            + "    var cd=e.clipboardData;"
            + "    if(cd&&!cd.items){"
            + "      var items=[];"
            + "      var types=cd.types||[];"
            + "      for(var i=0;i<types.length;i++){"
            + "        (function(t){items.push({kind:'string',type:t,getAsFile:function(){return null;},getAsString:function(cb){cb(cd.getData(t));}});})(types[i]);"
            + "      }"
            + "      items.length=items.length;"
            + // ensure length property
            "      Object.defineProperty(cd,'items',{value:items,configurable:true});"
            + "    }"
            + "  },true);"
            +
            // Override execCommand for copy/cut --Monaco's copy command uses
            // document.execCommand('copy') which doesn't work in WebView.
            "  var origExec=document.execCommand.bind(document);"
            + "  document.execCommand=function(cmd){"
            + "    var c=cmd.toLowerCase();"
            + "    if(c==='copy'||c==='cut'){"
            + "      var eds=typeof monaco!=='undefined'&&monaco.editor.getEditors?monaco.editor.getEditors():[];"
            + "      for(var i=0;i<eds.length;i++){"
            + "        var sel=eds[i].getModel().getValueInRange(eds[i].getSelection());"
            + "        if(sel){"
            + "          window.__javaClip.write(sel);"
            + "          if(c==='cut')eds[i].executeEdits('cut',[{range:eds[i].getSelection(),text:'',forceMoveMarkers:true}]);"
            + "          return true;"
            + "        }"
            + "      }"
            + "    }"
            + "    return origExec.apply(document,arguments);"
            + "  };"
            + "  window.__clipboardService={"
            + "    readText:function(type){"
            + "      if(type)return Promise.resolve(typeMap[type]||'');"
            + "      return Promise.resolve(window.__javaClip.read());"
            + "    },"
            + "    writeText:function(text,type){"
            + "      if(type){typeMap[type]=text;return Promise.resolve();}"
            + "      window.__javaClip.write(text);"
            + "      return Promise.resolve();"
            + "    },"
            + "    readFindText:function(){return Promise.resolve(findText);},"
            + "    writeFindText:function(text){findText=text;return Promise.resolve();},"
            + "    readResources:function(){return Promise.resolve(resources);},"
            + "    writeResources:function(r){resources=r||[];},"
            + "    clearInternalState:function(){resources=[];resourcesHash=undefined;},"
            + "    triggerPaste:function(){"
            +
            // Return undefined so Monaco's paste command falls through to the
            // isWeb readText() path, which calls our readText() above.
            // Returning a Promise would take the triggerPaste path which expects
            // a native paste event with clipboardData.items (unsupported in WebView).
            "    }"
            + "  };"
            + "})()";

    /** Creates a pane with a default TypeScript editor in the {@code vs-dark} theme. */
    public MonacoPane() {
        this(System.err);
    }

    /** Creates a pane with a default TypeScript editor, routing JS console output to the given stream. */
    public MonacoPane(PrintStream console) {
        this(
                ctx -> {
                    IStandaloneEditorConstructionOptions ops = new IStandaloneEditorConstructionOptions(ctx)
                            .value("// First line\nfunction hello() {\n\talert('Hello world!');\n}\n// Last line\n")
                            .language("typescript")
                            .fixedOverflowWidgets(true)
                            .theme("vs-dark");
                    ctx.monaco().editor().create(ctx.element, ops);
                },
                console);
    }

    /**
     * Creates a pane with a custom editor setup. JS console output goes to {@code System.err}.
     *
     * @param setup callback invoked once on the FX thread after Monaco loads
     */
    public MonacoPane(@Nonnull Consumer<MonacoContext> setup) {
        this(setup, System.err);
    }

    /**
     * Creates a pane with a custom editor setup and explicit console stream.
     *
     * @param setup callback invoked once on the FX thread after Monaco loads
     * @param console stream for JS console output, or {@code null} to discard
     */
    @SuppressWarnings("this-escape")
    public MonacoPane(@Nonnull Consumer<MonacoContext> setup, @Nullable PrintStream console) {
        webView = new WebView();
        getChildren().add(webView);
        var engine = webView.getEngine();

        // Keep strong Java references; WebEngine holds weak ones.
        var clipBridge = new ClipboardBridge();
        var consoleBridge = console != null ? new ConsoleBridge(console) : null;

        editor.addListener((xx, p, ctx) -> setup.accept(ctx));

        engine.getLoadWorker().stateProperty().addListener((o, p, n) -> {
            if (n != State.SUCCEEDED) return;
            var win = (JSObject) engine.executeScript("window");
            win.setMember("__javaClip", clipBridge);
            engine.executeScript(JS_CLIPBOARD_POLYFILL);
            if (consoleBridge != null) {
                win.setMember("__javaConsole", consoleBridge);
                engine.executeScript(JS_CONSOLE_BRIDGE);
            }
            var ctx = new MonacoContext(engine);
            pendingCtx = ctx; // prevent GC before async bridge callback fires
            ctx.window.set("bridge", ctx.callback1(JsProxy.ofMapped(JSObject.class), element -> {
                ctx.initialise(element, ctx.window.get("monaco", MonacoModule::new));
                // Install clipboard service override before any editor.create() call.
                // StandaloneServices.initialize() is called by the first create() and
                // picks up service overrides by string key from the override map.
                // We pre-initialize with our clipboard service so all editors use it.
                try {
                    ctx.window.asJsObject().eval(JS_CLIPBOARD_SERVICE);
                    // Wrap both create() and createDiffEditor() to inject clipboard service.
                    ctx.window
                            .asJsObject()
                            .eval("(function(){" + "  if(!window.__clipboardService)return;"
                                    + "  function wrap(name){"
                                    + "    var orig=monaco.editor[name];"
                                    + "    monaco.editor[name]=function(el,opts,overrides){"
                                    + "      overrides=overrides||{};"
                                    + "      if(!overrides.clipboardService)overrides.clipboardService=window.__clipboardService;"
                                    + "      return orig.call(monaco.editor,el,opts,overrides);"
                                    + "    };"
                                    + "  }"
                                    + "  wrap('create');wrap('createDiffEditor');"
                                    + "})()");
                } catch (Exception e) {
                    if (console != null) console.println("[MonacoPane/clipboard-service] " + e.getMessage());
                }
                this.editor.set(ctx); // fires setup.accept(ctx) --editor is created here
                pendingCtx = null; // editor property now holds the strong reference
                // Sync body background with Monaco's theme so resize
                // flashes the correct colour instead of white.
                try {
                    ctx.window
                            .asJsObject()
                            .eval("(function(){" + "  function sync(){"
                                    + "    var ed=document.querySelector('.monaco-editor');"
                                    + "    if(ed)document.body.style.backgroundColor=getComputedStyle(ed).backgroundColor;"
                                    + "  }"
                                    + "  sync();"
                                    + "  if(monaco.editor.onDidChangeTheme)monaco.editor.onDidChangeTheme(sync);"
                                    + "})()");
                } catch (Exception e) {
                    if (console != null) console.println("[MonacoPane/theme-sync] " + e.getMessage());
                }
                // Context menu clipboard: Monaco's paste command requires hasTextFocus()
                // which is false while the context menu is open. Monaco renders its
                // context menu in a shadow DOM, so we detect clicks via shadowRoot and
                // dispatch the action on the next tick after ed.focus().
                try {
                    ctx.window
                            .asJsObject()
                            .eval("(function(){" + "  document.addEventListener('mousedown',function(e){"
                                    + "    var t=e.target;if(!t)return;"
                                    + "    var li=t.closest&&t.closest('.action-item');"
                                    + "    if(!li&&t.shadowRoot){"
                                    + "      var inner=t.shadowRoot.elementFromPoint(e.clientX,e.clientY);"
                                    + "      if(inner)li=inner.closest&&inner.closest('.action-item');"
                                    + "    }"
                                    + "    if(!li)return;"
                                    + "    var label=li.querySelector('.action-label');"
                                    + "    if(!label)return;"
                                    + "    var text=(label.textContent||label.getAttribute('aria-label')||'').toLowerCase().trim();"
                                    + "    if(text==='paste'){"
                                    + "      setTimeout(function(){"
                                    +
                                    // Find the focused editor --check all regular and diff inner editors.
                                    "        var eds=monaco.editor.getEditors?monaco.editor.getEditors():[];"
                                    + "        var ed=eds.length===1?eds[0]:null;"
                                    + "        if(!ed)for(var i=0;i<eds.length;i++){"
                                    + "          var c=eds[i].getContainerDomNode&&eds[i].getContainerDomNode();"
                                    + "          if(c&&c.contains(document.activeElement)){ed=eds[i];break;}"
                                    + "        }"
                                    + "        if(!ed&&eds.length>0)ed=eds[0];"
                                    + "        if(ed){ed.focus();if(window.__javaClip)ed.trigger('menu','type',{text:window.__javaClip.read()});}"
                                    + "      },0);"
                                    + "    }"
                                    + "  },true);"
                                    + "})()");
                } catch (Exception e) {
                    if (console != null) console.println("[MonacoPane/context-menu] " + e.getMessage());
                }
            }));
            engine.executeScript(REQUIRE_JS);
            engine.executeScript(JS_INIT_MONACO);
        });

        // Copy/cut: intercept before WebKit so its platform clipboard handler cannot
        // overwrite what we write to the Java clipboard.
        webView.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (!event.isShortcutDown()) return;
            var code = event.getCode();
            if (code != KeyCode.C && code != KeyCode.X) return;
            try {
                Object sel = engine.executeScript(JS_GET_SELECTION);
                if (sel instanceof String && !((String) sel).isEmpty()) {
                    var cc = new ClipboardContent();
                    cc.putString((String) sel);
                    Clipboard.getSystemClipboard().setContent(cc);
                    if (code == KeyCode.X) engine.executeScript(JS_DELETE_SELECTION);
                }
            } catch (Exception e) {
                if (console != null) console.println("[MonacoPane/copy] " + e.getMessage());
            }
            event.consume();
        });

        webView.addEventFilter(ScrollEvent.ANY, event -> {
            if (engine.getLoadWorker().getState() != State.SUCCEEDED) return;
            int lines = Math.max(1, scrollDeltaLines.get());
            double dy = -event.getDeltaY() * lines;
            double dx = event.getDeltaX() * lines;
            try {
                engine.executeScript(String.format(JS_SCROLL_BY, dy, dx, event.getX(), event.getY()));
            } catch (Exception e) {
                if (console != null) console.println("[MonacoPane/scroll] " + e.getMessage());
            }
            event.consume();
        });

        // Drive Monaco layout() from JavaFX size properties rather than WebKit's onresize,
        // which fires for internal reasons unrelated to actual pane resizing.
        // Calls layout() on all editors: regular (getEditors) and diff (getDiffEditors).
        String layoutAll = "(function(){" + "  if(typeof monaco==='undefined'||!monaco.editor)return;"
                + "  var eds=monaco.editor.getEditors?monaco.editor.getEditors():[];"
                + "  for(var i=0;i<eds.length;i++)eds[i].layout();"
                + "  var diffs=monaco.editor.getDiffEditors?monaco.editor.getDiffEditors():[];"
                + "  for(var i=0;i<diffs.length;i++)diffs[i].layout();"
                + "})()";
        Runnable scheduleLayout = () -> {
            if (engine.getLoadWorker().getState() == State.SUCCEEDED)
                javafx.application.Platform.runLater(() -> engine.executeScript(layoutAll));
        };
        widthProperty().addListener((obs, o, n) -> scheduleLayout.run());
        heightProperty().addListener((obs, o, n) -> scheduleLayout.run());

        ClasspathStreamHandler.register(MonacoPane.class);
        engine.loadContent(EDITOR_HTML);
    }
}
