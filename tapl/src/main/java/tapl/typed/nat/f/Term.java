package tapl.typed.nat.f;

public interface Term extends tapl.typed.nat.Term<Element, Term, UnaryNat, Type>, Element, Factory {
	@Override default Term getSelfTerm() { return this; }
}
