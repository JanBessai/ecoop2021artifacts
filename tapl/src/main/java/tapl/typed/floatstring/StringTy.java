package tapl.typed.floatstring;

public interface StringTy<Elem, Tm, Ty> extends Type<Elem, Tm, Ty> {
	@Override default String print() { return "String"; }
	@Override default boolean equals(tapl.typed.Type<Elem, Tm, Ty> other) { return convert(other).isString();	}
	@Override default boolean isString() { return true; }
}
