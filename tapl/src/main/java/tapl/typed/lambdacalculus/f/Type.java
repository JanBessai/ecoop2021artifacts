package tapl.typed.lambdacalculus.f;

public interface Type extends tapl.typed.lambdacalculus.Type<Element, Term, Type>, Element {
    @Override default Type getSelfType() { return this; }
}
