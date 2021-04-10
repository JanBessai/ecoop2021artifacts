package ev.ep.m6;

import ev.ep.Exp;
import ev.ep.Visitor;
import ev.ep.m4.VisitorDivdMultNegTruncate;

public class Mult extends ev.ep.m4.Mult implements EqlQuery {

    public Mult(Exp _left, Exp _right) {
        super(_left, _right);
    }

    public Boolean isMult(EqlQuery left, EqlQuery right) {
        return ((Exp)left).accept(new Eql(getLeft())) && ((Exp)right).accept(new Eql(getRight()));
    }

    public <R> R accept(Visitor<R> v) {
        return ((VisitorDivdMultNegTruncate<R>) v).visit(this);
    }
}
