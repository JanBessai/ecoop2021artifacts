package tapl;

public interface Factory<Elem, Tm> {
	Element<Elem, Tm> convert(Element<Elem, Tm> other);
	Term<Elem, Tm> convert(Term<Elem, Tm> other);
}
