package tapl.let.f;

import tapl.varapp.f.Element;
import tapl.varapp.f.Term;

public interface Factory extends tapl.let.Factory<Element, Term>, tapl.varapp.f.Factory {
    @Override default Let let(String name, tapl.Term<Element, Term> value, tapl.Term<Element, Term> in) {
        return new Let(name, value, in);
    }
}

