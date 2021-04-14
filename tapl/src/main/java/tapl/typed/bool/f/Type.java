package tapl.typed.bool.f;

public interface Type extends tapl.typed.bool.Type<Element, Term, Type>, Element {
    @Override default Type getSelfType() { return this; }
}
