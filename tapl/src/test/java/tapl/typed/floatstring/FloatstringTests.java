package tapl.typed.floatstring;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public interface FloatstringTests<Elem, Tm, Ty> extends tapl.typed.ToplevelTests<Elem, Tm, Ty>, tapl.floatstring.FloatStringTests<Elem, Tm> {
    @Override Factory<Elem, Tm, Ty> getFactory();
    @Override default Term<Elem, Tm, Ty> getTerm() { return getFactory().convert(tapl.floatstring.FloatStringTests.super.getTerm()); }

    @Test
    default void testStringTy() {
        assertEquals("String", getFactory().stringTy().print());
        assertTrue(getFactory().stringTy().isString());
        assertFalse(getFactory().stringTy().isFloat());
        assertTrue(getFactory().stringTy().equals(getFactory().stringTy()));
        assertFalse(getFactory().stringTy().equals(getFactory().floatTy()));
    }

    @Test
    default void testFloatTy() {
        assertEquals("Float", getFactory().floatTy().print());
        assertTrue(getFactory().floatTy().isFloat());
        assertFalse(getFactory().floatTy().isString());
        assertTrue(getFactory().floatTy().equals(getFactory().floatTy()));
        assertFalse(getFactory().floatTy().equals(getFactory().stringTy()));
    }

    @Test
    @Override default void testConstFloat() {
        tapl.floatstring.FloatStringTests.super.testConstFloat();
        assertTrue(getFactory().floatTy().equals(getFactory().convert(getFactory().constFloat(3.141f)).getType()));
    }

    @Test
    @Override default void testConstString() {
        tapl.floatstring.FloatStringTests.super.testConstString();
        assertTrue(getFactory().stringTy().equals(getFactory().convert(getFactory().constString("123")).getType()));
    }

    @Test
    @Override default void testFloatTimes() {
        tapl.floatstring.FloatStringTests.super.testFloatTimes();
        Term<Elem, Tm, Ty> prod = getFactory().convert(getFactory().floatTimes(getFactory().constFloat(1.5f), getFactory().constFloat(2f)));
        assertTrue(getFactory().floatTy().equals(prod.getType()));

        Term<Elem, Tm, Ty> prodFailLeft = getFactory().convert(getFactory().floatTimes(getFactory().constString("xxx"), getFactory().constFloat(2f)));
        assertThrows(tapl.typed.util.TypeError.class, prodFailLeft::getType);

        Term<Elem, Tm, Ty> prodFailRight = getFactory().convert(getFactory().floatTimes(getFactory().constFloat(2f), getFactory().constString("xxx")));
        assertThrows(tapl.typed.util.TypeError.class, prodFailRight::getType);
    }
}
