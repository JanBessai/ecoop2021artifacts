package tapl.typed.let.f;

import tapl.typed.varapp.f.Element;
import tapl.typed.varapp.f.Term;
import tapl.typed.varapp.f.Type;

public interface Factory extends tapl.typed.let.Factory<Element, Term, Type>, tapl.typed.varapp.f.Factory {
    @Override default Let let(String name, tapl.Term<Element, Term> value, tapl.Term<Element, Term> in) {
        return new Let(name, value, in);
    }
}

