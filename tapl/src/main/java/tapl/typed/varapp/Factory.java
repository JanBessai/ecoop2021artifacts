package tapl.typed.varapp;

public interface Factory<Elem, Tm, Ty> extends tapl.varapp.Factory<Elem, Tm>, tapl.typed.Factory<Elem, Tm, Ty> {
    tapl.typed.varapp.Var<Elem, Tm, Ty> var(int binderIndex, String name, tapl.typed.Type<Elem, Tm, Ty> type);

    @Override Term<Elem, Tm, Ty> convert(tapl.Term<Elem, Tm> other);
}
