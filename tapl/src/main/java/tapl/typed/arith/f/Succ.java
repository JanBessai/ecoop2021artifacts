package tapl.typed.arith.f;

public class Succ implements tapl.typed.arith.Succ<Element, Term, UnaryNat, Type>, UnaryNat {
	tapl.Term<Element, Term> inner;
	
	public Succ(tapl.Term<Element, Term>of) {
		this.inner = of;
	}

	@Override
	public tapl.Term<Element, Term> getOf() {
		return inner;
	}
}
