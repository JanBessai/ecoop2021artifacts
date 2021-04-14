package tapl.bool;

public interface ConstTrue<Elem, Tm> extends Term<Elem, Tm> {
	@Override default String print() { return "true"; }
	@Override default boolean isConstTrue() { return true; }
}
