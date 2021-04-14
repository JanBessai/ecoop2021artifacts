package tapl.nat.f;

public class Pred implements tapl.nat.Pred<Element, Term, UnaryNat>, UnaryNat {

	tapl.Term<Element, Term> inner;
	
	public Pred(tapl.Term<Element, Term> of) {
		this.inner = of;
	}

	@Override
	public tapl.Term<Element, Term> getOf() {
		return inner;
	}
}
