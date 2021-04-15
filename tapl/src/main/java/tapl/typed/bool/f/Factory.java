package tapl.typed.bool.f;

public interface Factory extends tapl.typed.bool.Factory<Element, Term, Type> {
	@Override default ConstTrue constTrue() {
		return new ConstTrue();
	}
	@Override default ConstFalse constFalse() {
		return new ConstFalse();
	}
	@Override default IfThenElse ifThenElse(tapl.Term<Element, Term> cond, tapl.Term<Element, Term> ifBranch, tapl.Term<Element, Term> elseBranch) {
		return new IfThenElse(cond, ifBranch, elseBranch);
	}
	@Override default Bool bool() { return new Bool(); }

	@Override default Element convert(tapl.Element<Element, Term> other) { return other.getSelf(); }
	@Override default Term convert(tapl.Term<Element, Term> other) { return other.getSelfTerm(); }
	@Override default Type convert(tapl.typed.Type<Element, Term, Type> other) { return other.getSelfType(); }
}
