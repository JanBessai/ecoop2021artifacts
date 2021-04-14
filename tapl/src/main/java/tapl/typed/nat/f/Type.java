package tapl.typed.nat.f;

public interface Type extends tapl.typed.nat.Type<Element, Term, UnaryNat, Type>, Element {
    @Override default Type getSelfType() { return this; }
}
