package tapl.nat.f;

public interface Term extends tapl.nat.Term<Element, Term, UnaryNat>, Element, Factory {
	@Override default Term getSelfTerm() { return this; }
}
