package tapl.lambdacalculus;

public interface Factory<Elem, Tm> extends tapl.varapp.Factory<Elem, Tm> {
    Lambda<Elem, Tm> lambda(String name, tapl.Term<Elem, Tm> body);

    @Override Term<Elem, Tm> convert(tapl.Term<Elem, Tm> other);
}
