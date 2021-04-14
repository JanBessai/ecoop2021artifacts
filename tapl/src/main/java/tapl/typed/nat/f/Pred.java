package tapl.typed.nat.f;

public class Pred implements tapl.typed.nat.Pred<Element, Term, UnaryNat, Type>, UnaryNat {

	tapl.Term<Element, Term> inner;
	
	public Pred(tapl.Term<Element, Term> of) {
		this.inner = of;
	}

	@Override
	public tapl.Term<Element, Term> getOf() {
		return inner;
	}
}
