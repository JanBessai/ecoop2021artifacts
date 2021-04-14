package tapl.typed.lambdacalculus.f;

public class Arrow implements tapl.typed.lambdacalculus.Arrow<Element, Term, Type>, Type {
    private final tapl.typed.Type<Element, Term, Type> source;
    private final tapl.typed.Type<Element, Term, Type> target;

    public Arrow(tapl.typed.Type<Element, Term, Type> source, tapl.typed.Type<Element, Term, Type> target) {
        this.source = source;
        this.target = target;
    }

    @Override
    public tapl.typed.Type<Element, Term, Type> getSource() {
        return source;
    }

    @Override
    public tapl.typed.Type<Element, Term, Type> getTarget() {
        return target;
    }
}
