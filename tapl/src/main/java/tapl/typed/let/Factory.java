package tapl.typed.let;

public interface Factory<Elem, Tm, Ty> extends tapl.let.Factory<Elem, Tm>, tapl.typed.varapp.Factory<Elem, Tm, Ty> {}
