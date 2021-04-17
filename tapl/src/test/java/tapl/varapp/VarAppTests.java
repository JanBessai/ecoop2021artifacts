package tapl.varapp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.function.Function;
import java.util.function.BiFunction;

public interface VarAppTests<Elem, Tm> extends tapl.ToplevelTests<Elem, Tm>  {
	Factory<Elem, Tm> getFactory();
	@Override default tapl.Element<Elem, Tm> getElement() { return getFactory().var(0, "x"); }
	@Override default tapl.varapp.Term<Elem, Tm> getTerm() { return getFactory().var(0, "x"); }

	@Test
	default void testVar() {
		Var<Elem, Tm> v = getFactory().var(0, "x");
		assertEquals(0, v.getBinderIndex());
		assertEquals("x", v.getName());

		assertEquals("y", v.replaceName("y").getName());

		assertEquals(13, v.replaceBinderIndex(13).getBinderIndex());

		assertTrue(v.isVarUsed(0));
		assertFalse(v.isVarUsed(1));

		assertSame(v, v.nameVariable(0, v.getName()));
		assertEquals("y", v.nameVariable(0, "y").print());
		assertEquals("x", v.nameVariable(1, "y").print());

		Function<Integer, BiFunction<Integer, Var<Elem, Tm>, tapl.Term<Elem, Tm>>> replacement =
				i -> (offset, x) -> (x.getBinderIndex() == i ? getFactory().var(1, "y") : x);
		assertEquals("y", v.mapVariables(0, replacement.apply(0)).print());
		assertSame(v, v.mapVariables(0, replacement.apply(1)));

		assertFalse(v.isValue());
		assertSame(v, v.eval());
		assertSame(v, v.evalFull());
		assertSame(v, v.constantFunctionElimination());
	}

	@Test
	default void testApp() {
		App<Elem, Tm> xz_yz =
				getFactory().app(
						getFactory().app(getFactory().var(0, "x"), getFactory().var(2, "z")),
						getFactory().app(getFactory().var(1, "y"), getFactory().var(2, "z"))
				);

		assertEquals("((x z) (y z))", xz_yz.print());
		assertSame(xz_yz, xz_yz.eval());
		assertSame(xz_yz, xz_yz.evalFull());
		assertFalse(xz_yz.isValue());

		assertTrue(xz_yz.isVarUsed(0));
		assertTrue(xz_yz.isVarUsed(1));
		assertTrue(xz_yz.isVarUsed(2));
		assertFalse(xz_yz.isVarUsed(3));

		assertEquals("((a z) (y z))", xz_yz.nameVariable(0, "a").print());
		assertEquals("((x z) (a z))", xz_yz.nameVariable(1, "a").print());
		assertEquals("((x a) (y a))", xz_yz.nameVariable(2, "a").print());
		assertSame(xz_yz, xz_yz.nameVariable(3, "a"));

		Function<Integer, BiFunction<Integer, Var<Elem, Tm>, tapl.Term<Elem, Tm>>> replacement =
				i -> (offset, x) -> (x.getBinderIndex() == i ? getFactory().var(3, "a") : x);
		assertEquals("((a z) (y z))", xz_yz.mapVariables(0, replacement.apply(0)).print());
		assertEquals("((x z) (a z))", xz_yz.mapVariables(0, replacement.apply(1)).print());
		assertEquals("((x a) (y a))", xz_yz.mapVariables(0, replacement.apply(2)).print());
		assertSame(xz_yz, xz_yz.mapVariables(0, replacement.apply(3)));

		assertSame(xz_yz,  xz_yz.constantFunctionElimination());
	}

	@Test
	@Override default void testTerm() {
		tapl.ToplevelTests.super.testTerm();
		App<Elem, Tm> xz_yz =
				getFactory().app(
						getFactory().app(getFactory().var(0, "x"), getFactory().var(2, "z")),
						getFactory().app(getFactory().var(1, "y"), getFactory().var(2, "z"))
				);
		assertSame(xz_yz, xz_yz.termShiftAbove(0, 0));
		assertSame(xz_yz, xz_yz.termShiftAbove(0, 1));
		assertSame(xz_yz, xz_yz.termShiftAbove(1, 3));
		Term<Elem, Tm> xz_yz_shifted1 = getFactory().convert(xz_yz.termShiftAbove(1, 1));
		assertTrue(xz_yz_shifted1.isVarUsed(0));
		assertFalse(xz_yz_shifted1.isVarUsed(1));
		assertTrue(xz_yz_shifted1.isVarUsed(2));
		assertTrue(xz_yz_shifted1.isVarUsed(3));


		Term<Elem, Tm> xz_yz_shifted = getFactory().convert(xz_yz.termShift(1));
		assertFalse(xz_yz_shifted.isVarUsed(0));
		assertTrue(xz_yz_shifted.isVarUsed(1));
		assertTrue(xz_yz_shifted.isVarUsed(2));
		assertTrue(xz_yz_shifted.isVarUsed(3));

		assertSame(xz_yz, xz_yz.subst(3, xz_yz));
		assertEquals(String.format("((x %s) (y %s))", xz_yz.print(), xz_yz.print()), xz_yz.subst(2, xz_yz).print());
		assertEquals(String.format("((%s z) (y z))", xz_yz.print()), xz_yz.termSubstTop(xz_yz).print());

		assertSame(xz_yz_shifted, xz_yz_shifted.termSubstTop(getFactory().var(0, "x")));
		assertEquals("((a z) (y z))", xz_yz.termSubstTop(getFactory().var(0, "a")).print());
		assertTrue(getFactory().convert(xz_yz.termSubstTop(getFactory().var(0, "a"))).isVarUsed(0));
		assertTrue(getFactory().convert(xz_yz.termSubstTop(getFactory().var(3, "a"))).isVarUsed(3));
	}
}