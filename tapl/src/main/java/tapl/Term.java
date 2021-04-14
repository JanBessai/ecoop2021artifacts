package tapl;

import java.util.Optional;

public interface Term<Elem, Tm> extends Element<Elem, Tm> {
    Tm getSelfTerm();

    default Term<Elem, Tm> eval() { return this; }
    default Term<Elem, Tm> evalFull() {
        Term<Elem, Tm> last = this;
        Term<Elem, Tm> next = eval();
        while (next != last) {
            last = next;
            next = next.eval();
        }
        return next;
    }
    default boolean isValue() { return true; }
    @Override default Optional<Term<Elem, Tm>> matchTerm() { return Optional.of(this); }
}
