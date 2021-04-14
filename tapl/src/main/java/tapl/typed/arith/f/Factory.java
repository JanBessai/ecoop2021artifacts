package tapl.typed.arith.f;


public interface Factory extends tapl.typed.arith.Factory<Element, Term, UnaryNat, Type> {
	@Override public default ConstTrue constTrue() {
		return new ConstTrue();
	}
	@Override public default ConstFalse constFalse() {
		return new ConstFalse();
	}
	@Override public default IfThenElse ifThenElse(tapl.Term<Element, Term> cond, tapl.Term<Element, Term> ifBranch, tapl.Term<Element, Term> elseBranch) {
		return new IfThenElse(cond, ifBranch, elseBranch);
	}
	@Override public default Bool bool() { return new Bool(); }
	@Override default Zero zero() { return new Zero(); }
	@Override default Succ succ(tapl.Term<Element, Term> of) { return new Succ(of); }
	@Override default Pred pred(tapl.Term<Element, Term> of) { return new Pred(of); }
	@Override default Nat nat() { return new Nat(); }
	@Override public default IsZero isZero(tapl.Term<Element, Term> toTest) { return new IsZero(toTest); }

	@Override default Term convert(tapl.Term<Element, Term> other) { return other.getSelfTerm(); }
	@Override default UnaryNat convert(tapl.nat.UnaryNat<Element, Term, UnaryNat> other) { return other.getSelfUnaryNat(); }
	@Override default Element convert(tapl.Element<Element, Term> other) { return other.getSelf(); }
	@Override default Type convert(tapl.typed.Type<Element, Term, Type> other) { return other.getSelfType(); }
}
