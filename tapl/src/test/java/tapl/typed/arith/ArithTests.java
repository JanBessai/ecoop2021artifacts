package tapl.typed.arith;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public interface ArithTests<Elem, Tm, UNat, Ty> extends
        tapl.arith.ArithTests<Elem, Tm, UNat>,
        tapl.typed.nat.NatTests<Elem, Tm, UNat, Ty>,
        tapl.typed.bool.BoolTests<Elem, Tm, Ty> {
    @Override Factory<Elem, Tm, UNat, Ty> getFactory();
    @Override default Term<Elem, Tm, UNat, Ty> getTerm() { return getFactory().convert(tapl.arith.ArithTests.super.getTerm()); }
    @Override default Term<Elem, Tm, UNat, Ty> getNonNatTerm() { return getFactory().convert(tapl.typed.bool.BoolTests.super.getTerm()); }
    @Override default Term<Elem, Tm, UNat, Ty> getNonBoolTerm() { return getFactory().convert(tapl.typed.nat.NatTests.super.getTerm()); }

    @Test
    @Override default void testIsZero() {
        tapl.arith.ArithTests.super.testIsZero();
        assertTrue(getFactory().convert(getFactory().convert(getFactory().isZero(getFactory().zero())).getType()).isBool());
        assertThrows(tapl.typed.util.TypeError.class, getFactory().convert(getFactory().convert(getFactory().isZero(getFactory().constTrue())))::getType);
    }

    @Test
    @Override default void testIf() {
        tapl.arith.ArithTests.super.testIf();
        tapl.typed.bool.BoolTests.super.testIf();
    }

    @Test
    @Override default void testSucc() {
        tapl.arith.ArithTests.super.testSucc();
        tapl.typed.nat.NatTests.super.testSucc();
    }

    @Test
    @Override default void testTerm() {
        tapl.arith.ArithTests.super.testIf();
        tapl.typed.bool.BoolTests.super.testIf();
        tapl.typed.nat.NatTests.super.testSucc();
    }

}
