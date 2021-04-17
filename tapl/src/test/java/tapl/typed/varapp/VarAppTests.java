package tapl.typed.varapp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public interface VarAppTests<Elem, Tm, Ty> extends tapl.varapp.VarAppTests<Elem, Tm>, tapl.typed.ToplevelTests<Elem, Tm, Ty> {
    @Override Factory<Elem, Tm, Ty> getFactory();
    @Override default Term<Elem, Tm, Ty> getTerm() { return getFactory().var(0, "x", getType()); }
    tapl.typed.Type<Elem, Tm, Ty> getType();

    default boolean noAppRule() { return true; }

    @Test
    @Override default void testVar() {
        tapl.varapp.VarAppTests.super.testVar();
        tapl.typed.Type<Elem, Tm, Ty> ty = getType();
        Var<Elem, Tm, Ty> x = getFactory().var(0, "x", ty);
        assertSame(ty, x.getType());
        assertThrows(tapl.typed.util.TypeError.class, () -> getFactory().convert(x.clearType()).getType());
        assertSame(ty, getFactory().convert(getFactory().convert(x.clearType()).setTypeOfVariable(0, ty)).getType());
        assertThrows(tapl.typed.util.TypeError.class, () -> getFactory().convert(getFactory().convert(x.clearType()).setTypeOfVariable(1, ty)).getType());
        assertSame(ty, getFactory().convert(x.replaceName("y")).getType());
    }

    @Test
    @Override default void testApp() {
        tapl.varapp.VarAppTests.super.testApp();
        tapl.typed.Type<Elem, Tm, Ty> ty = getType();
        Term<Elem, Tm, Ty> app = getFactory().convert(getFactory().app(getFactory().var(0, "x"), getFactory().var(0, "y")));
        assertThrows(tapl.typed.util.TypeError.class, app::getType);
        assertEquals(app.print(),
                getFactory().convert(app.setTypeOfVariable(0, ty)).mapVariables(0, (offset, v) -> {
                    if (v.getBinderIndex() + offset == 0) {
                        return (getFactory().convert(v).getType().equals(ty) ? v : getFactory().var(999, "z"));
                    } else {
                        return v;
                    }
                }).print());
        if (noAppRule()) {
            assertThrows(tapl.typed.util.TypeError.class,
                    () -> getFactory().convert(getFactory().convert(app.setTypeOfVariable(0, ty)).setTypeOfVariable(1, ty)).getType()
            );
        }
    }

    @Test
    @Override default void testTerm() {
        tapl.varapp.VarAppTests.super.testTerm();
        tapl.typed.ToplevelTests.super.testTerm();
    }
}
