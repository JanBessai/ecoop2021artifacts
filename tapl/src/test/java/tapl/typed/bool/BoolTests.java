package tapl.typed.bool;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public interface BoolTests<Elem, Tm, Ty> extends tapl.typed.ToplevelTests<Elem, Tm, Ty>, tapl.bool.BoolTests<Elem, Tm> {
    @Override Factory<Elem, Tm, Ty> getFactory();
    @Override default Term<Elem, Tm, Ty> getTerm() { return getFactory().convert(tapl.bool.BoolTests.super.getTerm()); }
    Term<Elem, Tm, Ty> getNonBoolTerm();

    @Test
    default void testBool() {
        assertEquals("Bool", getFactory().bool().print());
        assertTrue(getFactory().bool().isBool());
        assertFalse(getFactory().convert(getNonBoolTerm().getType()).isBool());
        assertTrue(getFactory().bool().equals(getFactory().bool()));
        assertFalse(getFactory().bool().equals(getNonBoolTerm().getType()));
    }

    @Test
    @Override default void testConst() {
        tapl.bool.BoolTests.super.testConst();
        assertTrue(getFactory().bool().equals(getFactory().convert(getFactory().constTrue()).getType()));
        assertTrue(getFactory().bool().equals(getFactory().convert(getFactory().constFalse()).getType()));
    }

    @Test
    @Override default void testIf() {
        tapl.bool.BoolTests.super.testIf();
        Term<Elem, Tm, Ty> ite = getFactory().convert(getFactory().ifThenElse(getFactory().constTrue(), getFactory().constFalse(), getFactory().constTrue()));
        assertTrue(ite.bool().equals(ite.getType()));

        Term<Elem, Tm, Ty> iteFailCond = getFactory().convert(getFactory().ifThenElse(getNonBoolTerm(), getFactory().constFalse(), getFactory().constTrue()));
        assertThrows(tapl.typed.util.TypeError.class, iteFailCond::getType);

        Term<Elem, Tm, Ty> iteFailBranchesFirst = getFactory().convert(getFactory().ifThenElse(getFactory().constTrue(), getNonBoolTerm(), getFactory().constTrue()));
        assertThrows(tapl.typed.util.TypeError.class, iteFailBranchesFirst::getType);

        Term<Elem, Tm, Ty> iteFailBranchesSecond = getFactory().convert(getFactory().ifThenElse(getFactory().constTrue(), getFactory().constFalse(), getNonBoolTerm()));
        assertThrows(tapl.typed.util.TypeError.class, iteFailBranchesSecond::getType);
    }
}
