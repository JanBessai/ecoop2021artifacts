package ev.ep.m7i2;

import ev.ep.Exp;
import ev.ep.Visitor;

public class Mult extends ev.ep.m6.Mult implements EqlQuery {

    public Mult(Exp _left, Exp _right) {
        super(_left, _right);
    }

    public <R> R accept(Visitor<R> v) {
        return ((VisitorMerged<R>) v).visit(this);
    }
}
