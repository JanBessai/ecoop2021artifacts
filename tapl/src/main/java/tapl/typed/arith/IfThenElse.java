package tapl.typed.arith;

public interface IfThenElse<Elem, Tm, UNat, Ty> extends tapl.typed.bool.IfThenElse<Elem, Tm, Ty>, tapl.arith.IfThenElse<Elem, Tm, UNat>, Term<Elem, Tm, UNat, Ty> {}
