package tapl.typed.arith;

public interface ConstTrue<Elem, Tm, UNat, Ty> extends tapl.typed.bool.ConstTrue<Elem, Tm, Ty>, tapl.arith.ConstTrue<Elem, Tm, UNat>, Term<Elem, Tm, UNat, Ty> {}
