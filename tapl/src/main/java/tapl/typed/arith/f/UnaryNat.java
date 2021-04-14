package tapl.typed.arith.f;

public interface UnaryNat extends tapl.typed.arith.UnaryNat<Element, Term, UnaryNat, Type>, Term {
    @Override default UnaryNat getSelfUnaryNat() { return this; }
}
