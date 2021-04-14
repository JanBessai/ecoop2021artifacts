package tapl.typed.arith;

public interface ConstFalse<Elem, Tm, UNat, Ty> extends tapl.typed.bool.ConstFalse<Elem, Tm, Ty>, tapl.arith.ConstFalse<Elem, Tm, UNat>, Term<Elem, Tm, UNat, Ty> {}
