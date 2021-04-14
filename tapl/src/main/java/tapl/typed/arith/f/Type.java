package tapl.typed.arith.f;

public interface Type extends tapl.typed.arith.Type<Element, Term, UnaryNat, Type>, Element {
    @Override default Type getSelfType() { return this; }
}
