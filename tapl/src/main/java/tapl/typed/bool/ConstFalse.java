package tapl.typed.bool;

public interface ConstFalse<Elem, Tm, Ty> extends tapl.bool.ConstFalse<Elem, Tm>, Term<Elem, Tm, Ty> {
	@Override default tapl.typed.Type<Elem, Tm, Ty> getType() { return bool(); }
}
