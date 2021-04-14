package tapl.lambdacalculus.f;

public class Lambda implements tapl.lambdacalculus.Lambda<Element, Term>, Term {
    private final String name;
    private final tapl.Term<Element, Term> body;

    public Lambda(String name, tapl.Term<Element, Term> body) {
        this.name = name;
        this.body = body;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public tapl.Term<Element, Term> getBody() {
        return body;
    }
}
