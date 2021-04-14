package tapl.nat.f;

public class Succ implements tapl.nat.Succ<Element, Term, UnaryNat>, UnaryNat {
	tapl.Term<Element, Term> inner;
	
	public Succ(tapl.Term<Element, Term>of) {
		this.inner = of;
	}

	@Override
	public tapl.Term<Element, Term> getOf() {
		return inner;
	}
}
