package tapl.typed.floatstring;

public interface Factory<Elem, Tm, Ty> extends tapl.floatstring.Factory<Elem, Tm>, tapl.typed.Factory<Elem, Tm, Ty> {
	FloatTy<Elem, Tm, Ty> floatTy();
	StringTy<Elem, Tm, Ty> stringTy();

	@Override Term<Elem, Tm, Ty> convert(tapl.Term<Elem, Tm> other);
	@Override Type<Elem, Tm, Ty> convert(tapl.typed.Type<Elem, Tm, Ty> other);
}
