package tapl.typed.arith.f;

public class ArithTests implements tapl.typed.arith.ArithTests<Element, Term, UnaryNat, Type> {
    @Override public Factory getFactory() { return new Factory() {}; }
}
