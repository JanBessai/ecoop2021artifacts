package tapl.nat;

import java.util.Optional;

public interface UnaryNat<Elem, Tm, UNat> extends Term<Elem, Tm, UNat> {
	UNat getSelfUnaryNat();

	String printDecimal(int offset);
	tapl.Term<Elem, Tm> predecessor();

	@Override default Optional<UnaryNat<Elem, Tm, UNat>> matchUnaryNat() { return Optional.of(this); }
	@Override default String print() { return printDecimal(0); }
	@Override default boolean isValue() { return isNumericValue(); }
}
