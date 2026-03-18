package net.kurobako.monacofx.js;

/**
 * Marker interface for typed JavaScript functions (TypeScript {@code (...args) => R}).
 *
 * <p>On the JS side these are plain functions. JavaFX's Liveconnect bridge cannot discover methods on synthetic lambda
 * classes, so each {@code JsFunctionN} wraps itself into a concrete {@code Delegate} class via {@link #wrap()}.
 *
 * @see JsFunction0
 * @see JsFunction1
 * @see JsFunction2
 */
public interface JsFn {
    /** Returns a Liveconnect-visible delegate that forwards to this function. */
    Object wrap();
}
