package net.kurobako.monacofx;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.Objects;

/**
 * A {@link URLStreamHandler} that resolves {@code classpath:///path} URLs against the classpath.
 *
 * <p>This allows JavaFX {@link javafx.scene.web.WebEngine} to load HTML, JS, and CSS directly from bundled resources
 * without an embedded HTTP server. XHR and Web Worker requests issued from JavaScript inside WebEngine also go through
 * Java's URL infrastructure, so RequireJS module loading and Monaco's language workers work transparently.
 *
 * <p>The handler maps the URL path to a resource relative to the anchor class provided at construction. For example,
 * {@code classpath:///vendor/vs/editor/editor.main.js} resolves to the resource
 * {@code /vendor/vs/editor/editor.main.js} relative to the anchor.
 */
public final class ClasspathStreamHandler extends URLStreamHandler {

    private static final String PROTOCOL = "classpath";

    private final Class<?> anchor;

    /** Creates a handler that resolves paths against the given anchor class's classloader. */
    public ClasspathStreamHandler(Class<?> anchor) {
        this.anchor = Objects.requireNonNull(anchor);
    }

    @Override
    public URLConnection openConnection(URL u) throws IOException {
        String path = u.getPath();
        URL resource = anchor.getResource(path);
        if (resource == null) throw new IOException("Classpath resource not found: " + path);
        URLConnection conn = resource.openConnection();
        // Guess content type from extension so WebEngine handles JS/CSS/fonts correctly.
        String ct = guessContentType(path);
        if (ct != null) {
            conn = new ContentTypeOverride(conn, ct);
        }
        return conn;
    }

    private static String guessContentType(String path) {
        if (path.endsWith(".js")) return "text/javascript; charset=UTF-8";
        if (path.endsWith(".html")) return "text/html; charset=UTF-8";
        if (path.endsWith(".css")) return "text/css; charset=UTF-8";
        if (path.endsWith(".ttf")) return "font/ttf";
        if (path.endsWith(".woff")) return "font/woff";
        if (path.endsWith(".woff2")) return "font/woff2";
        if (path.endsWith(".json")) return "application/json; charset=UTF-8";
        return null;
    }

    /**
     * Registers the {@code classpath:} protocol handler globally. Safe to call multiple times; only the first
     * invocation has an effect.
     */
    static synchronized void register(Class<?> anchor) {
        if (registered) return;
        try {
            URL.setURLStreamHandlerFactory(new ClasspathHandlerFactory(anchor));
            registered = true;
        } catch (Error e) {
            // A factory was already set by the application or another library.
            // Fall back to the system-property approach.
            String existing = System.getProperty("java.protocol.handler.pkgs", "");
            String pkg = ClasspathStreamHandler.class.getPackageName();
            if (!existing.contains(pkg)) {
                System.setProperty("java.protocol.handler.pkgs", existing.isEmpty() ? pkg : existing + "|" + pkg);
            }
            fallbackAnchor = anchor;
            registered = true;
        }
    }

    private static volatile boolean registered;
    private static volatile Class<?> fallbackAnchor;

    /** Returns the fallback anchor class, or {@code null} if not yet registered. */
    public static Class<?> factoryAnchor() {
        return fallbackAnchor;
    }

    private static final class ClasspathHandlerFactory implements URLStreamHandlerFactory {
        private final Class<?> anchor;

        ClasspathHandlerFactory(Class<?> anchor) {
            this.anchor = anchor;
        }

        @Override
        public URLStreamHandler createURLStreamHandler(String protocol) {
            if (PROTOCOL.equals(protocol)) return new ClasspathStreamHandler(anchor);
            return null;
        }
    }

    /** Wraps a {@link URLConnection} to override the content type. */
    private static final class ContentTypeOverride extends URLConnection {
        private final URLConnection delegate;
        private final String contentType;

        ContentTypeOverride(URLConnection delegate, String contentType) {
            super(delegate.getURL());
            this.delegate = delegate;
            this.contentType = contentType;
        }

        @Override
        public void connect() throws IOException {
            delegate.connect();
        }

        @Override
        public InputStream getInputStream() throws IOException {
            return delegate.getInputStream();
        }

        @Override
        public String getContentType() {
            return contentType;
        }

        @Override
        public int getContentLength() {
            return delegate.getContentLength();
        }

        @Override
        public long getContentLengthLong() {
            return delegate.getContentLengthLong();
        }

        @Override
        public String getHeaderField(String name) {
            if ("content-type".equalsIgnoreCase(name)) return contentType;
            return delegate.getHeaderField(name);
        }
    }
}
