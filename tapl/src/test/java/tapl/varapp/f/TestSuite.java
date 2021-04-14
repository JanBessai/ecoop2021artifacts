package tapl.varapp.f;

import org.junit.Test;

import tapl.varapp.TestVarApp;

public class TestSuite implements TestVarApp<Element, Term> {

	@Override
	public tapl.varapp.Factory<Element, Term> getFactory() {
		return new Factory() {};
	}
	
	// note: @Test annotations in default interface methods are not detected by JUnit reflection
	@Test
	public void testVar() { TestVarApp.super.testVar(); }
	
}
