package tapl.typed.nat;

public interface UnaryNat<Elem, Tm, UNat, Ty> extends tapl.nat.UnaryNat<Elem, Tm, UNat>, Term<Elem, Tm, UNat, Ty> {}
