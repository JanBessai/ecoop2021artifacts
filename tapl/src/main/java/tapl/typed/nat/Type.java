package tapl.typed.nat;

public interface Type<Elem, Tm, UNat, Ty> extends tapl.typed.Type<Elem, Tm, Ty>, Factory<Elem, Tm, UNat, Ty> {
	default boolean isNat() { return false; }
}
