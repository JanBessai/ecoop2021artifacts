package tapl.typed.bool;

public interface ConstTrue<Elem, Tm, Ty> extends tapl.bool.ConstTrue<Elem, Tm>, Term<Elem, Tm, Ty> {
	@Override default tapl.typed.Type<Elem, Tm, Ty> getType() { return bool(); }
}
