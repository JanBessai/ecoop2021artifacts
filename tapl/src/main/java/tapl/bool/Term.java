package tapl.bool;

public interface Term<Elem, Tm> extends tapl.Element<Elem, Tm>, tapl.Term<Elem, Tm>, Factory<Elem, Tm> {
	default boolean isConstTrue() { return false; }
	default boolean isConstFalse() { return false; }
}
