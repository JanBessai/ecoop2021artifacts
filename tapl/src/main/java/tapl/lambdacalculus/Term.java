package tapl.lambdacalculus;

import java.util.Optional;

public interface Term<Elem, Tm> extends tapl.varapp.Term<Elem, Tm>, Factory<Elem, Tm> {
    default Optional<Lambda<Elem, Tm>> matchAbstraction() { return Optional.empty(); }
}
