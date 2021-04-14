package tapl.floatstring.f;

public interface Term extends tapl.floatstring.Term<Element, Term>, Element, Factory {
    @Override default Term getSelfTerm() { return this; }
}
