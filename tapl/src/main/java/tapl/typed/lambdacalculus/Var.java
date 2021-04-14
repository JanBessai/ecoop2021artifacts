package tapl.typed.lambdacalculus;

public interface Var<Elem, Tm, Ty> extends tapl.typed.varapp.Var<Elem, Tm, Ty>, Term<Elem, Tm, Ty>, Factory<Elem, Tm, Ty> {}
