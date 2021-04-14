package tapl.typed;

public interface Term<Elem, Tm, Ty> extends tapl.Term<Elem, Tm>, Factory<Elem, Tm, Ty> {
	Type<Elem, Tm, Ty> getType();
}
