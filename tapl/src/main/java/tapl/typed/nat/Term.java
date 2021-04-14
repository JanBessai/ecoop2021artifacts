package tapl.typed.nat;

public interface Term<Elem, Tm, UNat, Ty> extends tapl.nat.Term<Elem, Tm, UNat>, tapl.typed.Term<Elem, Tm, Ty>, Factory<Elem, Tm, UNat, Ty> {}
