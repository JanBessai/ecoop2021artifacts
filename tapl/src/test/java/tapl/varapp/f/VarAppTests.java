package tapl.varapp.f;

public class VarAppTests implements tapl.varapp.VarAppTests<Element, Term> {

	@Override
	public tapl.varapp.Factory<Element, Term> getFactory() {
		return new Factory() {};
	}
}
