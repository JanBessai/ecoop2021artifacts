package tapl.bool;

import static org.junit.Assert.*;

import org.junit.Test;

public interface TestBool<Elem, Tm> {

	Factory<Elem, Tm> getFactory();

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
		Term<Elem, Tm> ite = getFactory().ifThenElse(getFactory().constTrue(), getFactory().constFalse(), getFactory().constTrue());
		Term<Elem, Tm> iesecond = getFactory().ifThenElse(ite, getFactory().constFalse(), getFactory().constTrue());
		
		// one step evaluation
		assertEquals("if (false) then { false } else { true }", iesecond.eval().print());
		
		assertEquals("true", iesecond.eval().eval().print());
		
		assertEquals(getFactory().constFalse().print(), 
				ite.eval().print());
		
		assertFalse(ite.isValue());
		assertFalse(ite.isConstFalse());
		assertFalse(ite.isConstTrue());
	}
	
	@Test
	default void testReplace() {
		IfThenElse<Elem, Tm> ite = getFactory().ifThenElse(getFactory().constFalse(), getFactory().constFalse(), getFactory().constTrue());
		
		// one step evaluation
		assertEquals("if (false) then { false } else { true }", ite.print());
		
		ite = ite.replaceElseBranch(getFactory().constFalse());
		assertEquals("if (false) then { false } else { false }", ite.print());
		
		ite = ite.replaceIfBranch(getFactory().constTrue());
		assertEquals("if (false) then { true } else { false }", ite.print());
	}
}
