package tapl.nat;

import java.util.Optional;

public interface Pred<Elem, Tm, UNat> extends UnaryNat<Elem, Tm, UNat> {
	tapl.Term<Elem, Tm> getOf();

	default Pred<Elem, Tm, UNat> replaceOf(tapl.Term<Elem, Tm> by) { return pred(by); }
	
	@Override default tapl.Term<Elem, Tm> eval() {
		Term<Elem, Tm, UNat> evaluatedInner = convert(getOf().eval());
		if (evaluatedInner != getOf()) {
			return replaceOf(evaluatedInner);
		}
		Optional<? extends UnaryNat<Elem, Tm, UNat>> inner = evaluatedInner.matchUnaryNat();
		return inner.filter(Term::isNumericValue).map(UnaryNat::predecessor).orElse(this);
	}

	@Override default String printDecimal(int offset) {
		// Wrong in the EVF tapl: need to add offset-many succs
		StringBuilder result = new StringBuilder(String.format("pred(%s)", getOf().print()));
		for (int i = 0; i < offset; ++i) {
			result = new StringBuilder("succ(").append(result).append(")");
		}
		return result.toString();
	}

	@Override default tapl.Term<Elem, Tm> predecessor() { return pred(this); }
}
