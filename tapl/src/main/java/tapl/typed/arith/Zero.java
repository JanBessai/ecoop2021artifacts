package tapl.typed.arith;

public interface Zero<Elem, Tm, UNat, Ty> extends tapl.typed.nat.Zero<Elem, Tm, UNat, Ty>, tapl.arith.Zero<Elem, Tm, UNat>, UnaryNat<Elem, Tm, UNat, Ty> {}
