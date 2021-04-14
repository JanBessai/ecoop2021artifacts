package tapl.typed.nat.f;

public interface UnaryNat extends tapl.typed.nat.UnaryNat<Element, Term, UnaryNat, Type>, Term, Factory {
    @Override default UnaryNat getSelfUnaryNat() { return this; }
}
