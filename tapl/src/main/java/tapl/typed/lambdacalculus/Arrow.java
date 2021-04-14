package tapl.typed.lambdacalculus;
import java.util.Optional;

public interface Arrow<Elem, Tm, Ty> extends Type<Elem, Tm, Ty> {
    tapl.typed.Type<Elem, Tm, Ty> getSource();
    tapl.typed.Type<Elem, Tm, Ty> getTarget();

    default Arrow<Elem, Tm, Ty> replaceSource(tapl.typed.Type<Elem, Tm, Ty> by) { return arrow(by, getTarget()); }
    default Arrow<Elem, Tm, Ty> replaceTarget(tapl.typed.Type<Elem, Tm, Ty> by) { return arrow(getSource(), by); }

    @Override default String print() {
        return String.format("(%s -> %s)", getSource().print(), getTarget().print());
    }
    @Override default boolean equals(tapl.typed.Type<Elem, Tm, Ty> other) {
        Optional<Arrow<Elem, Tm, Ty>> otherArrow = convert(other).matchArrow();
        return otherArrow
                .map(arr -> getSource().equals(arr.getSource()) && getTarget().equals(arr.getTarget()))
                .orElse(false);
    }
    @Override default Optional<Arrow<Elem, Tm, Ty>> matchArrow() { return Optional.of(this); }
}
