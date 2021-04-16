package tapl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public interface ToplevelTests<Elem, Tm> {
    Factory<Elem, Tm> getFactory();
    Element<Elem, Tm> getElement();
    Term<Elem, Tm> getTerm();

    @Test
    default void testFactory() {
        Element<Elem, Tm> elem = getElement();
        Term<Elem, Tm> term = getTerm();
        assertSame(elem, getFactory().convert(elem));
        assertSame(term, getFactory().convert(term));
    }

    @Test
    default void testElement() {
        Element<Elem, Tm> elem = getElement();
        assertSame(elem, elem.getSelf());
    }

    @Test
    default void testTerm() {
        Term<Elem, Tm> term = getTerm();
        assertSame(term, term.getSelfTerm());
        assertTrue(term.matchTerm().isPresent());
        assertSame(term, term.matchTerm().get());
    }
}
