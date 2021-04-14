package tapl.typed.let.f;

import tapl.typed.varapp.f.Element;
import tapl.typed.varapp.f.Term;
import tapl.typed.varapp.f.Type;

public class Let implements tapl.typed.let.Let<Element, Term, Type>, Term, Factory {
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
