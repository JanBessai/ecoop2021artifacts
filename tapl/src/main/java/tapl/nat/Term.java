package tapl.nat;

import java.util.Optional;

public interface Term<Elem, Tm, UNat> extends tapl.Term<Elem, Tm>, Factory<Elem, Tm, UNat> {
	default boolean isNumericValue() {
		return false;
	}
	default boolean isZero() {
		return false;
	}
	default Optional<UnaryNat<Elem, Tm, UNat>> matchUnaryNat() {
		return Optional.empty();
	}
}
