package tapl.typed.nat;

public interface Nat<Elem, Tm, UNat, Ty> extends Type<Elem, Tm, UNat, Ty> {
	@Override default String print() { return "Nat"; }
	@Override  default boolean equals(tapl.typed.Type<Elem, Tm, Ty> other) { return convert(other).isNat(); }
	@Override default boolean isNat() {	return true; }
}
