package tapl.typed.varapp.f;

public interface Term extends tapl.typed.varapp.Term<Element, Term, Type>, Element {
	@Override default Term getSelfTerm() { return this; }
}
