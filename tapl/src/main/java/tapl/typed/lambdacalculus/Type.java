package tapl.typed.lambdacalculus;
import java.util.Optional;

public interface Type<Elem, Tm, Ty> extends tapl.typed.Type<Elem, Tm, Ty>, Factory<Elem, Tm, Ty> {
    default Optional<Arrow<Elem, Tm, Ty>> matchArrow() { return Optional.empty(); }
}

