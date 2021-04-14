package tapl.typed.floatstring.f;

public interface Term extends tapl.typed.floatstring.Term<Element, Term, Type>, Element, Factory {
    @Override default Term getSelfTerm() { return this; }
}
