package tapl.typed.nat;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public interface NatTests<Elem, Tm, UNat, Ty> extends tapl.nat.NatTests<Elem, Tm, UNat>, tapl.typed.ToplevelTests<Elem, Tm, Ty> {
    @Override Factory<Elem, Tm, UNat, Ty> getFactory();
    @Override default Term<Elem, Tm, UNat, Ty> getTerm() { return getFactory().convert(tapl.nat.NatTests.super.getTerm()); }
    Term<Elem, Tm, UNat, Ty> getNonNatTerm();

    @Test
    default void testNat() {
        assertEquals("Nat", getFactory().nat().print());
        assertTrue(getFactory().nat().isNat());
        assertFalse(getFactory().convert(getNonNatTerm().getType()).isNat());
        assertTrue(getFactory().nat().equals(getFactory().nat()));
        assertFalse(getFactory().nat().equals(getNonNatTerm().getType()));
    }

    @Test
    @Override default void testZero() {
        tapl.nat.NatTests.super.testZero();
        assertTrue(getFactory().convert(getFactory().zero()).getType().equals(getFactory().nat()));
    }

    @Test
    @Override default void testSucc() {
        tapl.nat.NatTests.super.testSucc();
        assertTrue(getFactory().convert(getFactory().succ(getFactory().zero())).getType().equals(getFactory().nat()));
        assertThrows(tapl.typed.util.TypeError.class, getFactory().convert(getFactory().succ(getNonNatTerm()))::getType);
    }

    @Test
    @Override default void testPred() {
        tapl.nat.NatTests.super.testPred();
        assertTrue(getFactory().convert(getFactory().succ(getFactory().succ(getFactory().zero()))).getType().equals(getFactory().nat()));
        assertTrue(getFactory().convert(getFactory().pred(getFactory().zero())).getType().equals(getFactory().nat()));
        assertThrows(tapl.typed.util.TypeError.class, getFactory().convert(getFactory().pred(getNonNatTerm()))::getType);
    }

    @Test
    @Override default void testFactory() {
        tapl.nat.NatTests.super.testFactory();
        tapl.typed.ToplevelTests.super.testFactory();
    }
}
