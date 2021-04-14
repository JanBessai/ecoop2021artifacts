package tapl.typed.arith;

public interface UnaryNat<Elem, Tm, UNat, Ty> extends tapl.typed.nat.UnaryNat<Elem, Tm, UNat, Ty>, tapl.arith.UnaryNat<Elem, Tm, UNat>, Term<Elem, Tm, UNat, Ty> {}
