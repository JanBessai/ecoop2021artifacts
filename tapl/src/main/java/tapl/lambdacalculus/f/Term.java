package tapl.lambdacalculus.f;

public interface Term extends tapl.lambdacalculus.Term<Element, Term>, Element {
	@Override default Term getSelfTerm() { return this; }
}
