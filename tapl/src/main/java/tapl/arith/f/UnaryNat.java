package tapl.arith.f;

public interface UnaryNat extends tapl.arith.UnaryNat<Element, Term, UnaryNat>, Term, Factory {
    @Override default UnaryNat getSelfUnaryNat() { return this; }
}
