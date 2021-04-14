package tapl.typed.floatstring;

public interface ConstString<Elem, Tm, Ty> extends tapl.floatstring.ConstString<Elem, Tm>, Term<Elem, Tm, Ty> {
	@Override default tapl.typed.Type<Elem, Tm, Ty> getType() { return stringTy(); }
}
