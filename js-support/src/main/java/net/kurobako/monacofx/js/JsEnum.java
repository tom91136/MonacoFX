package net.kurobako.monacofx.js;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Optional;

/**
 * Marker interface for Java enums that map to TypeScript {@code enum} values (numeric or string constants on the JS
 * side).
 *
 * <p>Generated Java enums implement this so they can be round-tripped through the JS bridge.
 *
 * @param <T> the JS-side value type (typically {@link Integer} or {@link String})
 */
public interface JsEnum<T> {
    /** Returns the JavaScript-side constant for this enum member. */
    T value();

    /**
     * Looks up an enum constant by its JavaScript value.
     *
     * @return the matching member, or empty if no match
     */
    static <T, E extends Enum<E> & JsEnum<T>> Optional<E> from(Class<E> cls, T t) {
        return EnumSet.allOf(cls).stream()
                .filter(e -> Objects.equals(e.value(), t))
                .findFirst();
    }
}
