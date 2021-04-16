package tapl.varapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public interface VarAppTests<Element, Tm> {
	Factory<Element, Tm> getFactory();

	@Test
	default void testVar() {
		Var<Element, Tm> v = getFactory().var(0, "x");
		assertEquals(0, v.getBinderIndex());
		assertEquals("x", v.getName());
		
		Var<Element, Tm> vy = v.replaceName("y");
		assertEquals("y", vy.getName());
		
		Var<Element, Tm> vz = vy.replaceBinderIndex(13);
		assertEquals(13, vz.getBinderIndex());
		
		assertFalse(vz.isVarUsed(7));
		assertTrue(vz.isVarUsed(13));
		
		tapl.Term<Element, Tm> vSecond = vz.nameVariable(13, "second");
		assertEquals("second", vSecond.print());
	}

}