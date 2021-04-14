package tapl.typed.arith.f;

public interface Term extends Element, tapl.typed.arith.Term<Element, Term, UnaryNat, Type> {
	@Override default Term getSelfTerm() { return this;	}
}
