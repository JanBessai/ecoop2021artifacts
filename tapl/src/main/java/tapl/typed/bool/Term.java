package tapl.typed.bool;

public interface Term<Elem, Tm, Ty> extends tapl.typed.bool.Factory<Elem, Tm, Ty>, tapl.bool.Term<Elem, Tm>, tapl.typed.Term<Elem, Tm, Ty> {}
