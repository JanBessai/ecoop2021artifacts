package tapl.typed.arith.f;

public class IsZero implements tapl.typed.arith.IsZero<Element, Term, UnaryNat, Type>, Term {
    private final tapl.Term<Element, Term> toTest;

    public IsZero(tapl.Term<Element, Term> toTest) {
        this.toTest = toTest;
    }

    @Override
    public tapl.Term<Element, Term> getToTest() {
        return toTest;
    }
}
