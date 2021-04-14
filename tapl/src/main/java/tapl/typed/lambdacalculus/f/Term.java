package tapl.typed.lambdacalculus.f;

public interface Term extends tapl.typed.lambdacalculus.Term<Element, Term, Type>, Element {
	@Override default Term getSelfTerm() { return this; }
}
