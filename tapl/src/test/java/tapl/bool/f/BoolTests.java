package tapl.bool.f;

public class BoolTests implements tapl.bool.BoolTests<Element, Term> {
	@Override public tapl.bool.Factory<Element, Term> getFactory() {
		return new Factory() {};
	}
}
