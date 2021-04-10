package ev.ep.m7i2;

import ev.ep.Exp;
import ev.ep.Visitor;

public class Add extends ev.ep.m6.Add implements EqlQuery {

    public Add(Exp _left, Exp _right) {
        super(_left, _right);
    }

    public <R> R accept(Visitor<R> v) {
        return ((VisitorMerged<R>) v).visit(this);
    }
}
