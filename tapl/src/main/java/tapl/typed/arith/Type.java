package tapl.typed.arith;

public interface Type<Elem, Tm, UNat, Ty> extends tapl.typed.nat.Type<Elem, Tm, UNat, Ty>, tapl.typed.bool.Type<Elem, Tm, Ty>, Factory<Elem, Tm, UNat, Ty> {}
