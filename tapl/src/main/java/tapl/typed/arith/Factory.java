package tapl.typed.arith;

public interface Factory<Elem, Tm, UNat, Ty> extends tapl.typed.bool.Factory<Elem, Tm, Ty>, tapl.typed.nat.Factory<Elem, Tm, UNat, Ty>, tapl.arith.Factory<Elem, Tm, UNat> {

	@Override Term<Elem, Tm, UNat, Ty> convert(tapl.Term<Elem, Tm> other);
	@Override UnaryNat<Elem, Tm, UNat, Ty> convert(tapl.nat.UnaryNat<Elem, Tm, UNat> other);
	@Override Type<Elem, Tm, UNat, Ty> convert(tapl.typed.Type<Elem, Tm, Ty> other);
}
