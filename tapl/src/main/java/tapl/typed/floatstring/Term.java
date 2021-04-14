package tapl.typed.floatstring;

public interface Term<Elem, Tm, Ty> extends tapl.floatstring.Term<Elem, Tm>, tapl.typed.Term<Elem, Tm, Ty>, Factory<Elem, Tm, Ty> {}
