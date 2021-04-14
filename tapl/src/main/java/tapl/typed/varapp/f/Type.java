package tapl.typed.varapp.f;

public interface Type extends tapl.typed.Type<Element, Term, Type>, Element {
    @Override default Type getSelfType() { return this; }
}
