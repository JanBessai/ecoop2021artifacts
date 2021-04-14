package tapl.typed.varapp;

public interface Term<Elem, Tm, Ty> extends tapl.varapp.Term<Elem, Tm>, tapl.typed.Term<Elem, Tm, Ty>, Factory<Elem, Tm, Ty> {
    tapl.Term<Elem, Tm> setTypeOfVariable(int binderIndex, tapl.typed.Type<Elem, Tm, Ty> type);
}
