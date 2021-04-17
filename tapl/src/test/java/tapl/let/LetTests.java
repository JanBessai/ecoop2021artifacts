package tapl.let;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public interface LetTests<Elem, Tm> extends tapl.varapp.VarAppTests<Elem, Tm> {
    @Override Factory<Elem, Tm> getFactory();
    tapl.Term<Elem, Tm> getValueTerm();

    @Test
    default void testLet() {
        tapl.Term<Elem, Tm> y = getValueTerm();
        assertTrue(y.isValue());
        Let<Elem, Tm> simpleLet =
                getFactory().let(
                        "x",
                        y,
                        getFactory().var(0, "x")
                );
        assertEquals(String.format("(let x = %s in x)", y.print()), simpleLet.print());
        assertFalse(simpleLet.isValue());
        assertFalse(simpleLet.isVarUsed(0));
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
        assertEquals(String.format("(let x = (let x = %s in x) in (let x = x in x))", y.print()), evalLet.print());
        assertFalse(evalLet.isVarUsed(0));
        assertFalse(evalLet.isVarUsed(1));
        assertNotSame(evalLet, evalLet.eval());
        assertEquals(String.format("(let x = %s in (let x = x in x))", y.print()), evalLet.eval().print());
        assertEquals(String.format("(let x = %s in x)", y.print()), evalLet.eval().eval().print());
        assertEquals(y.print(), evalLet.eval().eval().eval().print());
        assertEquals(y.print(), evalLet.evalFull().print());
        assertSame(y, evalLet.evalFull());

        assertEquals("z", evalLet.replaceName("z").getName());
        assertSame(y, evalLet.replaceIn(y).getIn());
    }
}
