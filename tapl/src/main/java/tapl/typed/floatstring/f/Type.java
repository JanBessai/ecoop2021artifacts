package tapl.typed.floatstring.f;

public interface Type extends tapl.typed.floatstring.Type<Element, Term, Type>, Element {
    @Override default Type getSelfType() { return this; }
}
