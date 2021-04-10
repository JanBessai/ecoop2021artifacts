package ev.ep.m7i2;

import ev.ep.Visitor;

public class Lit extends ev.ep.m6.Lit implements EqlQuery {

    public Lit(double _value) {
        super(_value); }

    public <R> R accept(Visitor<R> v) {
        return ((VisitorMerged<R>) v).visit(this);
    }
}
