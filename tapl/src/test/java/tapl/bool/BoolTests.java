package tapl.bool;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public interface BoolTests<Elem, Tm> extends tapl.ToplevelTests<Elem, Tm> {

	Factory<Elem, Tm> getFactory();
	@Override default tapl.Element<Elem, Tm> getElement() { return getFactory().constTrue(); }
	@Override default tapl.bool.Term<Elem, Tm> getTerm() { return getFactory().constTrue(); }

	@Test
	default void testConst() {
		assertEquals("false", getFactory().constFalse().print());
		assertEquals("true", getFactory().constTrue().print());
		
		assertTrue(getFactory().constFalse().isConstFalse());
		assertTrue(getFactory().constTrue().isConstTrue());
		
		assertTrue(getFactory().constFalse().isValue());
		assertTrue(getFactory().constTrue().isValue()); 
	}
	
	@Test
	default void testIf() {
		IfThenElse<Elem, Tm> ite = getFactory().ifThenElse(getFactory().constTrue(), getFactory().constFalse(), getFactory().constTrue());
		IfThenElse<Elem, Tm> iesecond = getFactory().ifThenElse(ite, getFactory().constFalse(), getFactory().constTrue());

		assertEquals("if (false) then { false } else { true }", iesecond.eval().print());
		assertEquals("true", iesecond.eval().eval().print());
		assertEquals("true", iesecond.evalFull().print());
		
		assertEquals(getFactory().constFalse().print(), 
				ite.eval().print());
		
		assertFalse(ite.isValue());
		assertFalse(ite.isConstFalse());
		assertFalse(ite.isConstTrue());
		assertTrue(ite.evalFull().isValue());

		assertEquals("if (true) then { true } else { true }", ite.replaceIfBranch(getFactory().constTrue()).print());
		assertEquals("if (true) then { false } else { false }", ite.replaceElseBranch(getFactory().constFalse()).print());
		assertEquals("if (false) then { false } else { true }", ite.replaceCondition(getFactory().constFalse()).print());
	}
}
