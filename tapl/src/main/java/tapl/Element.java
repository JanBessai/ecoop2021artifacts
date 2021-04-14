package tapl;

import java.util.Optional;

public interface Element<Elem, Tm> extends Factory<Elem, Tm> {
    Elem getSelf();

    String print();
    default Optional<Term<Elem, Tm>> matchTerm() { return Optional.empty(); }
}
