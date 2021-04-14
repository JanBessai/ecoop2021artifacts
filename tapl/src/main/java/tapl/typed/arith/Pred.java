package tapl.typed.arith;

public interface Pred<Elem, Tm, UNat, Ty> extends tapl.typed.nat.Pred<Elem, Tm, UNat, Ty>, tapl.arith.Pred<Elem, Tm, UNat>, UnaryNat<Elem, Tm, UNat, Ty> {}
