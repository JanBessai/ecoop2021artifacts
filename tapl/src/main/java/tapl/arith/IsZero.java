package tapl.arith;

public interface IsZero<Elem, Tm, UNat> extends Term<Elem, Tm, UNat> {
    tapl.Term<Elem, Tm> getToTest();
    
    default IsZero<Elem, Tm, UNat> replaceToTest(tapl.Term<Elem, Tm> by) { return isZero(by); }

    @Override default tapl.Term<Elem, Tm> eval() {
        Term<Elem, Tm, UNat> evaluatedToTest = convert(getToTest().eval());
        if (evaluatedToTest != getToTest()) {
            return replaceToTest(evaluatedToTest);
        }
        if (evaluatedToTest.isNumericValue()) {
            return (evaluatedToTest.isZero() ? constTrue() : constFalse());
        }
        return this;
    }

    @Override default boolean isValue() { return false; }
    @Override default String print() {
        return String.format("(iszero %s)", getToTest().print());
    }
}
