package tapl.typed.nat.f;

public class Succ implements tapl.typed.nat.Succ<Element, Term, UnaryNat, Type>, UnaryNat {
	tapl.Term<Element, Term> inner;
	
	public Succ(tapl.Term<Element, Term>of) {
		this.inner = of;
	}

	@Override
	public tapl.Term<Element, Term> getOf() {
		return inner;
	}
}
