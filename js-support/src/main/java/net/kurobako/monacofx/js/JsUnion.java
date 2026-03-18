package net.kurobako.monacofx.js;

/**
 * A tagged union representing a TypeScript union type ({@code A | B | C}) on the Java side.
 *
 * <p>On the JS side this is simply one of several possible values; the Java representation adds type safety via
 * projections. Concrete implementations ({@code JsUnion2}, {@code JsUnion3}, {@code JsUnion4}) are generated and
 * provide {@code isT0()}/{@code getT0()}, {@code fold(...)}, etc.
 */
public interface JsUnion {
    /** Returns the underlying value, erasing the type tag. */
    Object unite();
}
