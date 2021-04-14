package tapl.typed.nat;

public interface Factory<Elem, Tm, UNat, Ty> extends tapl.nat.Factory<Elem, Tm, UNat>, tapl.typed.Factory<Elem, Tm, Ty> {
	Nat<Elem, Tm, UNat, Ty> nat();
	
	@Override Term<Elem, Tm, UNat, Ty> convert(tapl.Term<Elem, Tm> other);
	@Override Type<Elem, Tm, UNat, Ty> convert(tapl.typed.Type<Elem, Tm, Ty> other);
	@Override UnaryNat<Elem, Tm, UNat, Ty> convert(tapl.nat.UnaryNat<Elem, Tm, UNat> other);
}
