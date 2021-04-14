package tapl.typed.floatstring;

public interface FloatTy<Elem, Tm, Ty> extends Type<Elem, Tm, Ty> {
	@Override default String print() { return "Float"; }
	@Override default boolean equals(tapl.typed.Type<Elem, Tm, Ty> other) { return convert(other).isFloat(); }
	@Override default boolean isFloat() { return true; }
}
