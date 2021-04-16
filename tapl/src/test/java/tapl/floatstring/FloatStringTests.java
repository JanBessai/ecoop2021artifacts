package tapl.floatstring;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public interface FloatStringTests<Elem, Tm> extends tapl.ToplevelTests<Elem, Tm> {
    @Override Factory<Elem, Tm> getFactory();
    @Override default tapl.Element<Elem, Tm> getElement() { return getFactory().constString("test"); }
    @Override default tapl.floatstring.Term<Elem, Tm> getTerm() { return getFactory().constString("test"); }

    @Test
    default void testConstFloat() {
        ConstFloat<Elem, Tm> pi = getFactory().constFloat(3.141f);
        assertEquals("3.141", pi.print());
        assertTrue(pi.isValue());
        assertTrue(pi.matchNumber().isPresent());
        assertEquals(pi.getNumber(), pi.matchNumber().get());
        assertSame(pi, pi.eval());
        assertSame(pi, pi.evalFull());
        assertEquals(3.141f, pi.getNumber());
    }

    @Test
    default void testConstString() {
        ConstString<Elem, Tm> test = getFactory().constString("test");
        assertEquals("\"test\"", test.print());
        assertEquals("test", test.getText());
        assertTrue(test.isValue());
        assertSame(test, test.eval());
        assertSame(test, test.evalFull());
        assertFalse(test.matchNumber().isPresent());
    }

    @Test
    default void testFloatTimes() {
        FloatTimes<Elem, Tm> prod = getFactory().floatTimes(getFactory().constFloat(1.5f), getFactory().constFloat(2f));
        assertEquals("(1.5 * 2.0)", prod.print());

        assertFalse(prod.isValue());
        assertTrue(prod.eval().isValue());
        assertTrue(getFactory().convert(prod.eval()).matchNumber().isPresent());
        assertEquals(3.0f, getFactory().convert(prod.eval()).matchNumber().get());
        assertTrue(prod.evalFull().isValue());
        assertTrue(getFactory().convert(prod.evalFull()).matchNumber().isPresent());
        assertEquals(3.0f, getFactory().convert(prod.evalFull()).matchNumber().get());

        FloatTimes<Elem, Tm> prodProd = getFactory().floatTimes(prod, prod);
        assertEquals("((1.5 * 2.0) * (1.5 * 2.0))", prodProd.print());
        assertFalse(prod.matchNumber().isPresent());
        assertFalse(prodProd.eval().isValue());
        assertTrue(prod.evalFull().isValue());
        assertTrue(getFactory().convert(prod.evalFull()).matchNumber().isPresent());
        assertEquals(9.0f, getFactory().convert(prodProd.evalFull()).matchNumber().get());

        FloatTimes<Elem, Tm> prodStuckRight = getFactory().floatTimes(prodProd, getFactory().constString("xxx"));
        assertFalse(prodStuckRight.evalFull().isValue());
        assertEquals("(9.0 * \"xxx\")", prodStuckRight.evalFull().print());
        FloatTimes<Elem, Tm> prodStuckLeft = getFactory().floatTimes(getFactory().constString("xxx"), prodProd);
        assertFalse(prodStuckLeft.evalFull().isValue());
        assertEquals("(\"xxx\" * 9.0)", prodStuckLeft.evalFull().print());
    }

}
