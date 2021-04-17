package tapl.lambdacalculus;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public interface LambdacalculusTests<Elem, Tm> extends tapl.varapp.VarAppTests<Elem, Tm> {
    @Override Factory<Elem, Tm> getFactory();
    @Override default tapl.Element<Elem, Tm> getElement() { return s(); }

    default Lambda<Elem, Tm> k() {
        return getFactory().lambda("x", getFactory().lambda("y", getFactory().var(1, "x")));
    }

    default Lambda<Elem, Tm> s() {
        return getFactory().lambda("x",
                getFactory().lambda("y",
                        getFactory().lambda("z",
                                getFactory().app(
                                        getFactory().app(getFactory().var(2, "x"), getFactory().var(0, "z")),
                                        getFactory().app(getFactory().var(1, "y"), getFactory().var(0, "z"))
                                ))));
    }

    default tapl.varapp.App<Elem, Tm> i() {
        return getFactory().app(getFactory().app(s(), k()), k());
    }

    @Test
    default void testLambda() {
        Lambda<Elem, Tm> k = k();
        assertTrue(k.isValue());
        assertTrue(k.getBodyFromAbstraction().isPresent());
        assertSame(k.getBody(), k.getBodyFromAbstraction().get());
        assertEquals("x", k.getName());
        assertEquals(getFactory().lambda("z", getFactory().lambda("y", getFactory().var(1, "z"))).print(),
                k.replaceName("z").mapVariables(0, (offset, v) -> (offset == v.getBinderIndex() ? v.replaceName("z") : v)).print());

    }

    @Test
    @Override default void testApp() {
        tapl.varapp.VarAppTests.super.testApp();
        assertEquals(i().evalFull().print(), getFactory().app(i(), i()).evalFull().print());
        tapl.Term<Elem, Tm> kkk = getFactory().app(getFactory().app(k(), k()).eval(), k());
        assertEquals(k().print(), getFactory().convert(kkk).constantFunctionElimination().print());
        assertEquals(k().print(), getFactory().convert(getFactory().convert(getFactory().app(getFactory().app(kkk, kkk), k())).constantFunctionElimination().eval()).constantFunctionElimination().print());
    }
}
