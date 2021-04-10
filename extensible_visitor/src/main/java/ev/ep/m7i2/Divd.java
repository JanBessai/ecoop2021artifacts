package ev.ep.m7i2;

import ev.ep.Exp;
import ev.ep.Visitor;

public class Divd extends ev.ep.m6.Divd implements EqlQuery {

    public Divd(Exp _left, Exp _right) {
        super(_left, _right);
    }

    public <R> R accept(Visitor<R> v) {
        return ((VisitorMerged<R>) v).visit(this);
    }
}
