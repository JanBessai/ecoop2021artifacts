package tapl.bool;

public interface IfThenElse<Elem, Tm> extends Term<Elem, Tm> {
	tapl.Term<Elem, Tm> getCondition();
	tapl.Term<Elem, Tm> getIfBranch();
	tapl.Term<Elem, Tm> getElseBranch();

	default IfThenElse<Elem, Tm> replaceCondition(tapl.Term<Elem, Tm> by) {
		return ifThenElse(by, getIfBranch(), getElseBranch());
	}
	default IfThenElse<Elem, Tm> replaceIfBranch(tapl.Term<Elem, Tm> by) {
		return ifThenElse(getCondition(), by, getElseBranch());
	}
	default IfThenElse<Elem, Tm> replaceElseBranch(tapl.Term<Elem, Tm> by) {
		return ifThenElse(getCondition(), getIfBranch(), by);
	}

	@Override default boolean isValue() { return false; }
	
	@Override default String print() {
		return String.format(
				"if (%s) then { %s } else { %s }", 
				convert(getCondition()).print(),
				convert(getIfBranch()).print(),
				convert(getElseBranch()).print());
	}

	@Override default tapl.Term<Elem, Tm> eval() {
		Term<Elem, Tm> evaluatedCondition = convert(convert(getCondition()).eval());  // IF don't make progress, always returns SELF
		if (evaluatedCondition != getCondition()) {
			return replaceCondition(evaluatedCondition);
		} else if (evaluatedCondition.isConstTrue()) {
			return getIfBranch();
		} else if (evaluatedCondition.isConstFalse()) {
			return getElseBranch();
		} else {
			return this;
		}
	}
}
