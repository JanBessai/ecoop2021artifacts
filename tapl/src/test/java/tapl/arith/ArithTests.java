package tapl.arith;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public interface ArithTests<Elem, Tm, UNat> extends tapl.nat.NatTests<Elem, Tm, UNat>, tapl.bool.BoolTests<Elem, Tm> {
    @Override Factory<Elem, Tm, UNat> getFactory();

    @Test
    default void testIsZero() {
        IsZero<Elem, Tm, UNat> isZero = getFactory().isZero(getFactory().pred(getFactory().succ(getFactory().zero())));
        IsZero<Elem, Tm, UNat> isNotZero = getFactory().isZero(getFactory().pred(getFactory().succ(getFactory().succ(getFactory().zero()))));

        assertEquals("(iszero pred(1))", isZero.print());
        assertEquals("(iszero pred(2))", isNotZero.print());

        assertFalse(isZero.isValue());
        assertFalse(isNotZero.isValue());
        assertFalse(isZero.isNumericValue());
        assertFalse(isNotZero.isNumericValue());

        assertEquals("(iszero 0)", isZero.eval().print());

        assertTrue(getFactory().convert(isZero.evalFull()).isValue());
        assertTrue(getFactory().convert(isZero.evalFull()).isConstTrue());
        assertTrue(getFactory().convert(isNotZero.evalFull()).isValue());
        assertTrue(getFactory().convert(isNotZero.evalFull()).isConstFalse());
    }

    @Test
    @Override default void testIf() {
        tapl.bool.BoolTests.super.testIf();

        IfThenElse<Elem, Tm, UNat> ite = getFactory().ifThenElse(getFactory().isZero(getFactory().zero()), getFactory().constTrue(), getFactory().constFalse());


    }
}
