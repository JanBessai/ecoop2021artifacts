package tapl.bool;

public interface ConstFalse<Elem, Tm> extends Term<Elem, Tm> {
	@Override default String print() { return "false"; }
	@Override default boolean isConstFalse() { return true; }
}
