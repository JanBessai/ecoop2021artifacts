package tapl.arith;

public interface Term<Elem, Tm, UNat> extends tapl.bool.Term<Elem, Tm>, tapl.nat.Term<Elem, Tm, UNat>, Factory<Elem, Tm, UNat> {}
