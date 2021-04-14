package tapl.typed;

public interface Factory<Elem, Tm, Ty> extends tapl.Factory<Elem, Tm> {
	@Override Term<Elem, Tm, Ty> convert(tapl.Term<Elem, Tm> other);
	Type<Elem, Tm, Ty> convert(Type<Elem, Tm, Ty> other);
}
