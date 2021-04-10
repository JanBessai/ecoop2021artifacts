package ev.ep.m7i2;

import ev.ep.Exp;
import ev.ep.Visitor;

public class Sub extends ev.ep.m6.Sub implements EqlQuery {

    public Sub(Exp _left, Exp _right) {
        super(_left, _right);
    }

    public <R> R accept(Visitor<R> v) {
        return ((VisitorMerged<R>) v).visit(this);
    }
}
