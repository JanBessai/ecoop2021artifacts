package tapl.typed.floatstring;

public interface Type<Elem, Tm, Ty> extends tapl.typed.Type<Elem, Tm, Ty>, Factory<Elem, Tm, Ty> {
	default boolean isString() {	return false; }
	default boolean isFloat() { return false; }
}
