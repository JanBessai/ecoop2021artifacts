package ev.ep.m6;

import ev.ep.Exp;
import ev.ep.Visitor;
import ev.ep.m4.VisitorDivdMultNegTruncate;

public class Add extends ev.ep.m4.Add implements EqlQuery {

    public Add(Exp _left, Exp _right) {
        super(_left, _right);
    }

    public Boolean isAdd(EqlQuery left, EqlQuery right) {
        return ((Exp)left).accept(new Eql(getLeft())) && ((Exp)right).accept(new Eql(getRight()));
    }

    public <R> R accept(Visitor<R> v) {
        return ((VisitorDivdMultNegTruncate<R>) v).visit(this);
    }
}