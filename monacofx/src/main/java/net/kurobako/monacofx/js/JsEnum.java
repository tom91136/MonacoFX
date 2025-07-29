package net.kurobako.monacofx.js;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Optional;

public interface JsEnum<T> {
    T value();

    static <T, E extends Enum<E> & JsEnum<T>> Optional<E> from(Class<E> cls, T t) {
        return EnumSet.allOf(cls).stream().filter(e -> Objects.equals(e.value(), t)).findFirst();
    }

}
