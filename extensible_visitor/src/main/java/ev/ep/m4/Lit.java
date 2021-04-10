package ev.ep.m4;

import ev.ep.Visitor;

public class Lit extends ev.ep.m0.Lit {

    public Lit(double _value) {
        super(_value); }

    public <R> R accept(Visitor<R> v) {
        return ((VisitorDivdMultNegTruncate<R>) v).visit(this);
    }
}
