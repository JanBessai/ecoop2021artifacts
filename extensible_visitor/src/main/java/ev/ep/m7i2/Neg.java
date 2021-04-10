package ev.ep.m7i2;

import ev.ep.Exp;
import ev.ep.Visitor;

public class Neg extends ev.ep.m6.Neg implements EqlQuery {

    public Neg(Exp _inner) {
        super(_inner);
    }

    public <R> R accept(Visitor<R> v) {
        return ((VisitorMerged<R>) v).visit(this);
    }
}
