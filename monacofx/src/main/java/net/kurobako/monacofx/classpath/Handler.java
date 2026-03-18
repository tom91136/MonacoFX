package net.kurobako.monacofx.classpath;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import net.kurobako.monacofx.ClasspathStreamHandler;

/**
 * Convention-based {@link URLStreamHandler} for the {@code classpath:} protocol.
 *
 * <p>Discovered via {@code java.protocol.handler.pkgs} when {@link java.net.URL#setURLStreamHandlerFactory} is
 * unavailable (i.e. another library already registered a factory). Delegates to {@link ClasspathStreamHandler}.
 */
public class Handler extends URLStreamHandler {

    private volatile ClasspathStreamHandler cached;

    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        ClasspathStreamHandler h = cached;
        if (h == null) {
            Class<?> anchor = ClasspathStreamHandler.factoryAnchor();
            if (anchor == null) throw new IOException("ClasspathStreamHandler not initialised — call register() first");
            h = new ClasspathStreamHandler(anchor);
            cached = h;
        }
        return h.openConnection(u);
    }
}
