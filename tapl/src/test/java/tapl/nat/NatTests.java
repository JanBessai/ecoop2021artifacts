package tapl.nat;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public interface NatTests<Elem, Tm, UNat> extends tapl.ToplevelTests<Elem, Tm> {
	@Override Factory<Elem, Tm, UNat> getFactory();
	@Override default tapl.Element<Elem, Tm> getElement() { return getFactory().zero(); }
	@Override default tapl.nat.Term<Elem, Tm, UNat> getTerm() { return getFactory().zero(); }
	default tapl.nat.UnaryNat<Elem, Tm, UNat> getUnaryNat() { return getFactory().zero(); }

	@Test
	default void testZero() {
		Zero<Elem, Tm, UNat> z = getFactory().zero();
		assertEquals("0", z.print()); 
		assertTrue(z.isZero());
		assertTrue(z.isNumericValue());
		assertTrue(z.isValue());
		assertTrue(z.matchUnaryNat().isPresent());
		assertEquals("0", z.printDecimal(0));
		assertEquals("0", z.print());
		assertEquals("0", z.predecessor().print());
	}

	@Test
	default void testSucc() {
		Succ<Elem, Tm, UNat> one = getFactory().succ(getFactory().zero());
		Succ<Elem, Tm, UNat> two = getFactory().succ(getFactory().succ(getFactory().pred(one)));
		Succ<Elem, Tm, UNat> three = getFactory().succ(getFactory().succ(getFactory().pred(two)));
		assertEquals("1", one.print());
		assertTrue(one.isNumericValue());
		assertTrue(one.isValue());
		assertEquals("1", one.print());
		assertEquals("1", one.printDecimal(0));
		assertEquals("0", one.predecessor().print());
		assertEquals("succ(succ(pred(1)))", two.print());
		assertEquals("2", two.eval().print());
		assertEquals("2", two.evalFull().print());
		assertEquals("succ(succ(pred(succ(succ(pred(1))))))", three.print());
		assertEquals("succ(succ(pred(2)))", three.eval().print());
		assertEquals("3", three.evalFull().print());
	}

	@Test
	default void testPred() {
		Zero<Elem, Tm, UNat> z = getFactory().zero();
		Succ<Elem, Tm, UNat> one = getFactory().succ(z);   // succ(0)
		Succ<Elem, Tm, UNat> two = getFactory().succ(one);  // succ(succ(0))
		Pred<Elem, Tm, UNat> pred = getFactory().pred(two);  // pred(succ(succ(0)))
		Pred<Elem, Tm, UNat> predPred = getFactory().pred(pred);  // pred(pred(succ(succ(0))))
		assertEquals("1", pred.eval().print());
		assertEquals("pred(1)", predPred.eval().print());
		assertEquals("0", predPred.eval().eval().print());
		
		assertEquals("1", one.printDecimal(0));
		assertEquals("2", two.printDecimal(0));
		assertEquals("pred(2)", pred.printDecimal(0));
		assertEquals("pred(pred(2))", predPred.printDecimal(0));

		assertEquals("pred(pred(2))", pred.predecessor().print());

		Pred<Elem, Tm, UNat> bad = getFactory().pred(z);
		assertEquals("pred(0)", bad.printDecimal(0));
		Succ<Elem, Tm, UNat> backToZero = getFactory().succ(bad);
		assertEquals("succ(pred(0))", backToZero.printDecimal(0));

		assertFalse(bad.isNumericValue());
		assertFalse(bad.isValue());
	}

	@Test
	@Override default void testFactory() {
		tapl.ToplevelTests.super.testFactory();
		UnaryNat<Elem, Tm, UNat> unat = getUnaryNat();
		assertSame(unat, getFactory().convert(unat));
	}

	@Test
	default void testUnaryNat() {
		UnaryNat<Elem, Tm, UNat> unat = getUnaryNat();
		assertSame(unat, unat.getSelfUnaryNat());
		assertTrue(unat.matchUnaryNat().isPresent());
		assertSame(unat, unat.matchUnaryNat().get());
	}
}
