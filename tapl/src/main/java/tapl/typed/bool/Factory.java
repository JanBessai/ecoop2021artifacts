package tapl.typed.bool;

public interface Factory<Elem, Tm, Ty> extends tapl.bool.Factory<Elem, Tm>, tapl.typed.Factory<Elem, Tm, Ty> {
	Bool<Elem, Tm, Ty> bool();

	@Override Term<Elem, Tm, Ty> convert(tapl.Term<Elem, Tm> other);
	@Override Type<Elem, Tm, Ty> convert(tapl.typed.Type<Elem, Tm, Ty> other);
}
