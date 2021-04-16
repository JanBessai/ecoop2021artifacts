package tapl.arith.f;

public class IsZero implements tapl.arith.IsZero<Element, Term, UnaryNat>, Term {
    private final tapl.Term<Element, Term> toTest;

    public IsZero(tapl.Term<Element, Term> toTest) {
        this.toTest = toTest;
    }

    @Override public tapl.Term<Element, Term> getToTest() {
        return toTest;
    }
}
