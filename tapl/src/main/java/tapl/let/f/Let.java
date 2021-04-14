package tapl.let.f;

import tapl.varapp.f.Element;
import tapl.varapp.f.Term;

public class Let implements tapl.let.Let<Element, Term>, Term, Factory {
    private final String name;
    private final tapl.Term<Element, Term> value;
    private final tapl.Term<Element, Term> in;

    public Let(String name, tapl.Term<Element, Term> value, tapl.Term<Element, Term> in) {
        this.name = name;
        this.value = value;
        this.in = in;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public tapl.Term<Element, Term> getValue() {
        return value;
    }

    @Override
    public tapl.Term<Element, Term> getIn() {
        return in;
    }
}
