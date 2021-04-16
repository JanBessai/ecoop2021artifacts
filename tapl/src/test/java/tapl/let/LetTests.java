package tapl.let;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public interface LetTests<Elem, Tm> extends tapl.varapp.VarAppTests<Elem, Tm> {
    @Override Factory<Elem, Tm> getFactory();

    @Test
    default void testLet() {
        tapl.varapp.Var<Elem, Tm> y = getFactory().var(0, "y");
        Let<Elem, Tm> simpleLet =
                getFactory().let(
                        "x",
                        y,
                        getFactory().var(0, "x")
                );
        assertEquals("(let x = y in x)", simpleLet.print());
        assertTrue(simpleLet.isValue());
        assertTrue(simpleLet.isVarUsed(0));
        assertTrue(simpleLet.eval().isValue());
        assertTrue(simpleLet.evalFull().isValue());
        assertSame(y, simpleLet.evalFull());

        Let<Elem, Tm> evalLet =
                getFactory().let(
                        "x",
                        simpleLet,
                        getFactory().let(
                                "x",
                                getFactory().var(0, "x"),
                                getFactory().var(0, "x")
                        )
                );
        assertEquals("(let x = (let x = y in x) in (let x = x in x))", evalLet.print());
        assertTrue(evalLet.isVarUsed(0));
        assertFalse(evalLet.isVarUsed(1));
        assertNotSame(evalLet, evalLet.eval());
        assertEquals("(let x = y in (let x = x in x))", evalLet.eval().print());
        assertEquals("(let x = y in x)", evalLet.eval().eval().print());
        assertEquals("y", evalLet.eval().eval().eval().print());
        assertEquals("y", evalLet.evalFull().print());
        assertSame(y, evalLet.evalFull());

        assertEquals("z", evalLet.replaceName("z").getName());
    }
}
