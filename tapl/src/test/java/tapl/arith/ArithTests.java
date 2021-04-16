package tapl.arith;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public interface ArithTests<Elem, Tm, UNat> extends tapl.nat.NatTests<Elem, Tm, UNat>, tapl.bool.BoolTests<Elem, Tm> {
    @Override Factory<Elem, Tm, UNat> getFactory();
    @Override default tapl.Element<Elem, Tm> getElement() { return getFactory().isZero(getFactory().zero()); }
    @Override default tapl.arith.Term<Elem, Tm, UNat> getTerm() { return getFactory().isZero(getFactory().zero()); }

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

        IsZero<Elem, Tm, UNat> isZeroStuck = getFactory().isZero(getFactory().constTrue());
        assertSame(isZeroStuck, isZeroStuck.eval());
        assertSame(isZeroStuck, isZeroStuck.evalFull());
    }

    @Test
    @Override default void testIf() {
        tapl.bool.BoolTests.super.testIf();

        tapl.bool.IfThenElse<Elem, Tm> ite = getFactory().ifThenElse(getFactory().isZero(getFactory().zero()), getFactory().constTrue(), getFactory().constFalse());
        assertTrue(getFactory().convert(ite.evalFull()).isConstTrue());

        tapl.bool.IfThenElse<Elem, Tm> iteStuck = getFactory().ifThenElse(getFactory().zero(), getFactory().constTrue(), getFactory().constFalse());
        assertFalse(getFactory().convert(iteStuck.evalFull()).isValue());
    }

    @Test
    @Override default void testSucc() {
        tapl.nat.NatTests.super.testSucc();

        tapl.nat.Succ<Elem, Tm, UNat> succSuccStuck = getFactory().succ(getFactory().succ(getFactory().constTrue()));
        assertFalse(succSuccStuck.evalFull().isValue());
        assertFalse(succSuccStuck.isNumericValue());
        assertEquals("succ(succ(true))", succSuccStuck.print());
    }

    @Test
    @Override default void testTerm() {
        tapl.nat.NatTests.super.testTerm();
        tapl.bool.BoolTests.super.testTerm();
        assertFalse(getFactory().isZero(getFactory().zero()).matchUnaryNat().isPresent());
    }
}
