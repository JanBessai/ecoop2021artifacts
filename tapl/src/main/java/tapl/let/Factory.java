package tapl.let;

public interface Factory<Elem, Tm> extends tapl.varapp.Factory<Elem, Tm> {
    Let<Elem, Tm> let(String name, tapl.Term<Elem, Tm> value, tapl.Term<Elem, Tm> in);
}
