package tapl.typed.nat.f;

public interface Factory extends tapl.typed.nat.Factory<Element, Term, UnaryNat, Type> {
	@Override default Zero zero() { return new Zero(); }
	@Override default Succ succ(tapl.Term<Element, Term> of) { return new Succ(of); }
	@Override default Pred pred(tapl.Term<Element, Term> of) { return new Pred(of); }
	@Override default Nat nat() { return new Nat(); }

	@Override default Term convert(tapl.Term<Element, Term> other) { return other.getSelfTerm(); }
	@Override default UnaryNat convert(tapl.nat.UnaryNat<Element, Term, UnaryNat> other) { return other.getSelfUnaryNat(); }
	@Override default Element convert(tapl.Element<Element, Term> other) { return other.getSelf(); }
	@Override default Type convert(tapl.typed.Type<Element, Term, Type> other) { return other.getSelfType(); }
}
