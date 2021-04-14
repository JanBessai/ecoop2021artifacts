package tapl.typed.arith;

public interface Succ<Elem, Tm, UNat, Ty> extends tapl.typed.nat.Succ<Elem, Tm, UNat, Ty>, tapl.arith.Succ<Elem, Tm, UNat>, UnaryNat<Elem, Tm, UNat, Ty> {}
