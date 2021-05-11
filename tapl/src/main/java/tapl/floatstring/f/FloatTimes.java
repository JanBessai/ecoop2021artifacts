package tapl.floatstring.f;

public class FloatTimes implements tapl.floatstring.FloatTimes<Element, Term>, Term {
    private final tapl.Term<Element, Term> left;
    private final tapl.Term<Element, Term> right;

    public FloatTimes(tapl.Term<Element, Term> left, tapl.Term<Element, Term> right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public tapl.Term<Element, Term> getLeft() {
        return left;
    }

    @Override
    public tapl.Term<Element, Term> getRight() {
        return right;
    }
}
