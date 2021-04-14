package tapl.nat.f;

import org.junit.Test;

import tapl.nat.TestNat;

public class TestSuite implements TestNat<Element, Term, UnaryNat> {

	@Override
	public tapl.nat.Factory<Element, Term, UnaryNat> getFactory() {
		return new Factory() {};
	}
	
	// note: @Test annotations in default interface methods are not detected by JUnit reflection
	@Test
	public void testZero() { TestNat.super.testZero(); }
	
	@Test
	public void testSucc() { TestNat.super.testSucc(); }
	
	@Test
	public void testPred() { 
		TestNat.super.testPred(); 
	}
	
	@Test
	public void testPrintDecimal() { TestNat.super.testPrintDecimal(); }
}
