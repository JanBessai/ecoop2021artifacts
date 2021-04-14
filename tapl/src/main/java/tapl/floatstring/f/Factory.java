package tapl.floatstring.f;

public interface Factory extends tapl.floatstring.Factory<Element, Term> {
    @Override
    default ConstString constString(String text) { return new ConstString(text); }

    @Override
    default ConstFloat constFloat(float x) { return new ConstFloat(x); }

    @Override
    default FloatTimes floatTimes(tapl.Term<Element, Term> left, tapl.Term<Element, Term> right) {
        return new FloatTimes(left, right);
    }

    @Override default Term convert(tapl.Term<Element, Term> other) { return other.getSelfTerm(); }
    @Override default Element convert(tapl.Element<Element, Term> other) { return other.getSelf(); }
}
