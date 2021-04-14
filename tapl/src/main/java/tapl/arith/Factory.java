package tapl.arith;

public interface Factory<Elem, Tm, UNat> extends tapl.bool.Factory<Elem, Tm>, tapl.nat.Factory<Elem, Tm, UNat> {
    IsZero<Elem, Tm, UNat> isZero(tapl.Term<Elem, Tm> toTest);

	@Override Term<Elem, Tm, UNat> convert(tapl.Term<Elem, Tm> other);
	@Override UnaryNat<Elem, Tm, UNat> convert(tapl.nat.UnaryNat<Elem, Tm, UNat> other);
}
