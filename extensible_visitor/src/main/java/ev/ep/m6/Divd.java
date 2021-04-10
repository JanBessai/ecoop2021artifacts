package ev.ep.m6;

import ev.ep.Exp;
import ev.ep.Visitor;
import ev.ep.m4.VisitorDivdMultNegTruncate;

public class Divd extends ev.ep.m4.Divd implements EqlQuery {

    public Divd(Exp _left, Exp _right) {
        super(_left, _right);
    }

    public Boolean isDivd(EqlQuery left, EqlQuery right) {
        return ((Exp)left).accept(new Eql(getLeft())) && ((Exp)right).accept(new Eql(getRight()));
    }

    public <R> R accept(Visitor<R> v) {
        return ((VisitorDivdMultNegTruncate<R>) v).visit(this);
    }
}
