package tapl.lambdacalculus.f;

public class Lambda implements tapl.lambdacalculus.Lambda<Element, Term>, Term {
    private final String name;
    private final Term body;

    public Lambda(String name, tapl.Term<Element, Term> body) {
        this.name = name;
        this.body = convert(body);
    }

    @Override
    public String getName() { return name; }

    @Override
    public Term getBody() { return body; }
}
