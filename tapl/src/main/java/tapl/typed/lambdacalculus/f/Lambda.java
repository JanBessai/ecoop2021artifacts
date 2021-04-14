package tapl.typed.lambdacalculus.f;


import java.util.Optional;

public class Lambda implements tapl.typed.lambdacalculus.Lambda<Element, Term, Type>, Term {
    private final String name;
    private final Optional<tapl.typed.Type<Element, Term, Type>> boundType;
    private final tapl.Term<Element, Term> body;

    public Lambda(String name, tapl.Term<Element, Term> body) {
        this.name = name;
        this.boundType = Optional.empty();
        this.body = body;
    }

    public Lambda(String name,  tapl.typed.Type<Element, Term, Type> boundType, tapl.Term<Element, Term> body) {
        this.name = name;
        this.boundType = Optional.of(boundType);
        this.body = body;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Optional<tapl.typed.Type<Element, Term, Type>> getBoundType() {
        return boundType;
    }

    @Override
    public tapl.Term<Element, Term> getBody() {
        return body;
    }
}
