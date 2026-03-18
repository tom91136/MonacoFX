package net.kurobako.monacofx.js;

import java.util.List;

/**
 * A fixed-size, heterogeneous collection of values representing a TypeScript tuple type ({@code [A, B]} &rarr; JS
 * array).
 *
 * <p>On the JS side this is a plain array; the Java representation provides typed accessors. Concrete implementations
 * ({@code JsTuple2}, {@code JsTuple3}, {@code JsTuple4}) are generated.
 */
public interface JsTuple {
    /** Returns the tuple elements in order. */
    List<Object> elements();
}
