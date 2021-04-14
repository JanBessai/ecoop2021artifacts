package tapl.typed.floatstring;

public interface ConstFloat<Elem, Tm, Ty> extends tapl.floatstring.ConstFloat<Elem, Tm>, Term<Elem, Tm, Ty> {
	@Override default tapl.typed.Type<Elem, Tm, Ty> getType() { return floatTy(); }
}
