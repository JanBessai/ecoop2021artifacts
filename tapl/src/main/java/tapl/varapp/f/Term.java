package tapl.varapp.f;

public interface Term extends tapl.varapp.Term<Element, Term>, Element {
	@Override default Term getSelfTerm() { return this; }
}
