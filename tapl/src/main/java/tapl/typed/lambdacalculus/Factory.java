package tapl.typed.lambdacalculus;

public interface Factory<Elem, Tm, Ty> extends tapl.lambdacalculus.Factory<Elem, Tm>, tapl.typed.varapp.Factory<Elem, Tm, Ty> {
    Lambda<Elem, Tm, Ty> lambda(String name, tapl.typed.Type<Elem, Tm, Ty> type, tapl.Term<Elem, Tm> body);
    Arrow<Elem, Tm, Ty> arrow(tapl.typed.Type<Elem, Tm, Ty> source, tapl.typed.Type<Elem, Tm, Ty> target);

    @Override Term<Elem, Tm, Ty> convert(tapl.Term<Elem, Tm> other);
    @Override Type<Elem, Tm, Ty> convert(tapl.typed.Type<Elem, Tm, Ty> other);
}
