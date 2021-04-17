package tapl.typed.lambdacalculus;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public interface LambdacalculusTests<Elem, Tm, Ty> extends tapl.typed.varapp.VarAppTests<Elem, Tm, Ty>, tapl.lambdacalculus.LambdacalculusTests<Elem, Tm> {
    @Override Factory<Elem, Tm, Ty> getFactory();
    default boolean omegaDoesNotHaveType() { return true; }

    @Test
    default void testArrow() {
        Type<Elem, Tm, Ty> ty = getFactory().convert(getType());
        Arrow<Elem, Tm, Ty> arr = getFactory().arrow(ty, ty);
        assertEquals(String.format("(%s -> %s)", ty.print(), ty.print()), arr.print());
        assertTrue(arr.matchArrow().isPresent());
        assertSame(ty, arr.matchArrow().get().getSource());
        assertSame(ty, arr.matchArrow().get().getTarget());
        assertSame(arr, arr.replaceSource(arr).matchArrow().get().getSource());
        assertSame(ty, arr.replaceSource(arr).matchArrow().get().getTarget());
        assertSame(arr, arr.replaceTarget(arr).matchArrow().get().getTarget());
        assertSame(ty, arr.replaceTarget(arr).matchArrow().get().getSource());
        assertFalse(getFactory().convert(ty).matchArrow().isPresent());
        assertTrue(arr.equals(arr));
        assertFalse(arr.equals(ty));
    }

    @Test
    @Override default void testLambda() {
        tapl.lambdacalculus.LambdacalculusTests.super.testLambda();
        Type<Elem, Tm, Ty> ty = getFactory().convert(getType());
        Lambda<Elem, Tm, Ty> k = getFactory().lambda("x", ty, getFactory().lambda("y", ty, getFactory().var(1, "x")));
        assertTrue(getFactory().arrow(ty, getFactory().arrow(ty, ty)).equals(k.getType()));
        assertTrue(getFactory().arrow(getFactory().arrow(ty, ty), getFactory().arrow(ty, getFactory().arrow(ty, ty))).equals(k.replaceBoundType(getFactory().arrow(ty, ty)).getType()));
        Lambda<Elem, Tm, Ty> omega = getFactory().lambda("x", getFactory().app(getFactory().var(0, "x"), getFactory().var(0, "x")));
        if (omegaDoesNotHaveType()) {
            assertThrows(tapl.typed.util.TypeError.class, omega::getType);
        }
        assertThrows(tapl.typed.util.TypeError.class, omega.replaceBoundType(getFactory().arrow(ty, ty))::getType);
    }

    @Test
    @Override default void testApp() {
        tapl.typed.varapp.VarAppTests.super.testApp();
        tapl.lambdacalculus.LambdacalculusTests.super.testApp();
        Type<Elem, Tm, Ty> ty = getFactory().convert(getTerm().getType());
        Lambda<Elem, Tm, Ty> k = getFactory().lambda("x", ty, getFactory().lambda("y", ty, getFactory().var(1, "x")));
        assertTrue(getFactory().arrow(ty, ty).equals(getFactory().convert(getFactory().app(k, getTerm())).getType()));
        Lambda<Elem, Tm, Ty> omega = getFactory().lambda("x", getFactory().app(getFactory().var(0, "x"), getFactory().var(0, "x")));
        Term<Elem, Tm, Ty> appFailLeft = getFactory().convert(getFactory().app(omega.replaceBoundType(ty), k));
        assertThrows(tapl.typed.util.TypeError.class, appFailLeft::getType);
        Term<Elem, Tm, Ty> appFailRight = getFactory().convert(getFactory().app(k, omega.replaceBoundType(ty)));
        assertThrows(tapl.typed.util.TypeError.class, appFailRight::getType);
        Term<Elem, Tm, Ty> appFailMatch = getFactory().convert(getFactory().app(k, k));
        assertThrows(tapl.typed.util.TypeError.class, appFailMatch::getType);
    }

}
