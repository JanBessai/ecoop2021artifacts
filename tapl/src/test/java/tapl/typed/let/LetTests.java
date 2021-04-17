package tapl.typed.let;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public interface LetTests<Elem, Tm, Ty> extends tapl.let.LetTests<Elem, Tm>, tapl.typed.varapp.VarAppTests<Elem, Tm, Ty> {
    @Override Factory<Elem, Tm, Ty> getFactory();

    @Test
    @Override default void testLet() {
        tapl.let.LetTests.super.testLet();
        tapl.typed.Term<Elem, Tm, Ty> dummyValue = getFactory().convert(getValueTerm());
        tapl.typed.Type<Elem, Tm, Ty> dummyType = dummyValue.getType();
        tapl.typed.Term<Elem, Tm, Ty> let = getFactory().convert(getFactory().let("x", dummyValue, getFactory().var(0, "x")));
        assertTrue(dummyType.equals(let.getType()));
        tapl.typed.Term<Elem, Tm, Ty> letFailLeft = getFactory().convert(getFactory().let("x", getFactory().var(123, "y"), getFactory().var(0, "x")));
        assertThrows(tapl.typed.util.TypeError.class, letFailLeft::getType);
        tapl.typed.Term<Elem, Tm, Ty> letFailRight = getFactory().convert(getFactory().let("x", getFactory().var(123, "y", dummyType), getFactory().var(123, "y")));
        assertThrows(tapl.typed.util.TypeError.class, letFailRight::getType);
        assertTrue(dummyType.equals(getFactory().convert(getFactory().convert(letFailLeft).setTypeOfVariable(123, dummyType)).getType()));
    }

}
