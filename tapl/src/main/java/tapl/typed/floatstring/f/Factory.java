package tapl.typed.floatstring.f;

public interface Factory extends tapl.typed.floatstring.Factory<Element, Term, Type> {
    @Override default ConstString constString(String text) { return new ConstString(text); }
    @Override default ConstFloat constFloat(float x) { return new ConstFloat(x); }
    @Override default FloatTimes floatTimes(tapl.Term<Element, Term> left, tapl.Term<Element, Term> right) {
        return new FloatTimes(left, right);
    }
    @Override public default StringTy stringTy() { return new StringTy(); }
    @Override public default FloatTy floatTy() { return new FloatTy(); }

    @Override default Term convert(tapl.Term<Element, Term> other) { return other.getSelfTerm(); }
    @Override default Element convert(tapl.Element<Element, Term> other) { return other.getSelf(); }
    @Override default Type convert(tapl.typed.Type<Element, Term, Type> other) { return other.getSelfType(); }
}
