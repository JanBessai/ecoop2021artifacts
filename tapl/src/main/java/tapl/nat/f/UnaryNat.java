package tapl.nat.f;

public interface UnaryNat extends tapl.nat.UnaryNat<Element, Term, UnaryNat>, Term, Factory {
    @Override default UnaryNat getSelfUnaryNat() { return this; }
}
