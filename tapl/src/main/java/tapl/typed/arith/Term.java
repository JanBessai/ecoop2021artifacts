package tapl.typed.arith;

public interface Term<Elem, Tm, UNat, Ty> extends tapl.typed.bool.Term<Elem, Tm, Ty>, tapl.typed.nat.Term<Elem, Tm, UNat, Ty>, tapl.arith.Term<Elem, Tm, UNat>, Factory<Elem, Tm, UNat, Ty> {}
