package tapl.arith.f;

public interface Term extends tapl.arith.Term<Element, Term, UnaryNat>, Element, Factory {
	@Override default Term getSelfTerm() { return this; }
}
