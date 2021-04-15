package tapl.nat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public interface TestNat<Element, Term, UNat> {
	Factory<Element, Term, UNat> getFactory();

	@Test
	default void testZero() {
		Zero<Element, Term, UNat> z = getFactory().zero();
		assertEquals("0", z.print()); 
		assertTrue(z.isZero());
		assertTrue(z.isNumericValue());
		assertTrue(z.matchUnaryNat().isPresent());   //not really sure what this does!
	}

	@Test
	default void testSucc() {
		Succ<Element, Term, UNat> s = getFactory().succ(getFactory().zero());
		assertEquals("1", s.print());
	}

	@Test
	default void testPred() {
		Zero<Element, Term, UNat> z = getFactory().zero();
		Succ<Element, Term, UNat> one = getFactory().succ(z);   // succ(0)
		Succ<Element, Term, UNat> two = getFactory().succ(one);  // succ(succ(0))
		Pred<Element, Term, UNat> pred = getFactory().pred(two);  // pred(succ(succ(0)))
		assertEquals("1", pred.eval().print()); 
		
		assertEquals("1", one.printDecimal(0));
		assertEquals("2", two.printDecimal(0));
		assertEquals("pred(2)", pred.printDecimal(0));
		
		assertTrue(one.isNumericValue());
		
		Pred<Element, Term, UNat> bad = getFactory().pred(z);
		assertEquals("pred(0)", bad.printDecimal(0));
		Succ<Element, Term, UNat> backToZero = getFactory().succ(bad);
		assertEquals("succ(pred(0))", backToZero.printDecimal(0));
	}
	
	@Test
	default void testPrintDecimal() {
		assertEquals("0", getFactory().zero().printDecimal(0)); 
		assertEquals("1", getFactory().succ(getFactory().zero()).printDecimal(0));
		
		assertEquals("0", getFactory().succ(getFactory().zero()).predecessor().print());
	}
}
