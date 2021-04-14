package tapl.typed.lambdacalculus;

public interface Term<Elem, Tm, Ty> extends tapl.lambdacalculus.Term<Elem, Tm>, tapl.typed.varapp.Term<Elem, Tm, Ty>, Factory<Elem, Tm, Ty> {}
