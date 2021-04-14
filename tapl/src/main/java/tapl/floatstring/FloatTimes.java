package tapl.floatstring;

public interface FloatTimes<Elem, Tm> extends Term<Elem, Tm> {
	tapl.Term<Elem, Tm> getLeft();
	tapl.Term<Elem, Tm> getRight();

	default FloatTimes<Elem, Tm> replaceLeft(tapl.Term<Elem, Tm> by) { return floatTimes(by, getRight()); }
	default FloatTimes<Elem, Tm> replaceRight(tapl.Term<Elem, Tm> by) { return floatTimes(getLeft(), by); }
	
	@Override default String print() {
		return String.format("(%s * %s)", getLeft().print(), getRight().print());
	}

	@Override default boolean isValue() { return false; }

	@Override default tapl.Term<Elem, Tm> eval() {
		Term<Elem, Tm> leftValue = convert(convert(getLeft()).eval());
		if (leftValue != getLeft()) {
			return replaceLeft(leftValue);
		}
		Term<Elem, Tm> rightValue = convert(convert(getRight()).eval());
		if (rightValue != getRight()) {
			return replaceRight(rightValue);
		}
		return leftValue.matchNumber().flatMap(left ->
					rightValue.matchNumber().<tapl.Term<Elem, Tm>>map(right -> constFloat(left * right))
				).orElse(this);
	}
}
