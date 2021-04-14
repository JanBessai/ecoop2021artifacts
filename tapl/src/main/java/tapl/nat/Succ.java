package tapl.nat;

public interface Succ<Elem, Tm, UNat> extends UnaryNat<Elem, Tm, UNat> {
	tapl.Term<Elem, Tm> getOf();

	default Succ<Elem, Tm, UNat> replaceOf(tapl.Term<Elem, Tm> by) {	return succ(by); }

	@Override default tapl.Term<Elem, Tm> eval() {
		Term<Elem, Tm, UNat> evaluatedInner = convert(getOf().eval());
		if (evaluatedInner != getOf()) {
			return replaceOf(evaluatedInner);
		}
		return this;
	}

	@Override default boolean isNumericValue() { return convert(getOf()).isNumericValue(); }

	@Override default String printDecimal(int offset) {
		Term<Elem, Tm, UNat> of = convert(getOf());
		return of.matchUnaryNat()
				.map(x -> x.printDecimal(offset + 1))
				.orElseGet(() -> {
					// Wrong in the EVF tapl: need to add offset-many succs
					StringBuilder result = new StringBuilder(of.print());
					for (int i = 0; i < offset; ++i) {
						result = new StringBuilder("succ(").append(result).append(")");
					}
					return result.toString();
				});
	}
	
	@Override default tapl.Term<Elem, Tm> predecessor() { return getOf(); }
}
