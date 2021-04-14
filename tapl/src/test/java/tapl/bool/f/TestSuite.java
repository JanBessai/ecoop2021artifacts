package tapl.bool.f;

import org.junit.Test;

import tapl.bool.TestBool;

public class TestSuite implements TestBool<Element, Term> {

	@Override
	public tapl.bool.Factory<Element, Term> getFactory() {
		return new Factory() {};
	}
	
	// note: @Test annotations in default interface methods are not detected by JUnit reflection
	@Test
	public void testConst() { TestBool.super.testConst(); }
	
	@Test
	public void testIf() { TestBool.super.testIf(); }
	
	@Test
	public void testReplace() { TestBool.super.testReplace(); }
	
}
