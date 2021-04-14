package tapl.nat;

public interface Factory<Elem, Tm, UNat> extends tapl.Factory<Elem, Tm> {
	Zero<Elem, Tm, UNat> zero();
	Succ<Elem, Tm, UNat> succ(tapl.Term<Elem, Tm> of);
	Pred<Elem, Tm, UNat> pred(tapl.Term<Elem, Tm> of);

	@Override Term<Elem, Tm, UNat> convert(tapl.Term<Elem, Tm> other);
	UnaryNat<Elem, Tm, UNat> convert(UnaryNat<Elem, Tm, UNat> other);
}
