package tapl.nat;

public interface Zero<Elem, Tm, UNat> extends UnaryNat<Elem, Tm, UNat> {
	@Override default boolean isNumericValue() { return true; }
	@Override default boolean isZero() { return true; }
	@Override default String printDecimal(int offset) { return String.valueOf(offset); }
	@Override default Term<Elem, Tm, UNat> predecessor() { return this; }
}
