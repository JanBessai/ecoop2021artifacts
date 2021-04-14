package tapl.typed.bool;

public interface Bool<Elem, Tm, Ty> extends Type<Elem, Tm, Ty> {
	@Override default String print() {
		return "Bool";
	}
	@Override default boolean equals(tapl.typed.Type<Elem, Tm, Ty> other) {
		return convert(other).isBool();
	}
	@Override default boolean isBool() { return true; }
}
