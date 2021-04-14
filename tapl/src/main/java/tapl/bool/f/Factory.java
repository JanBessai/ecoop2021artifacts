package tapl.bool.f;


public interface Factory extends tapl.bool.Factory<Element, Term> {
	@Override public default ConstTrue constTrue() {
		return new ConstTrue();
	}
	@Override public default ConstFalse constFalse() {
		return new ConstFalse();
	}
	@Override public default IfThenElse ifThenElse(tapl.Term<Element, Term> cond, tapl.Term<Element, Term> ifBranch, tapl.Term<Element, Term> elseBranch) {
		return new IfThenElse(cond, ifBranch, elseBranch);
	}

	@Override public default Element convert(tapl.Element<Element, Term> other) { return other.getSelf(); }
	@Override public default Term convert(tapl.Term<Element, Term> other) { return other.getSelfTerm(); }
}
