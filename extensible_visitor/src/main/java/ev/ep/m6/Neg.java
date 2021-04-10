package ev.ep.m6;

import ev.ep.Exp;
import ev.ep.Visitor;
import ev.ep.m4.VisitorDivdMultNegTruncate;

public class Neg extends ev.ep.m4.Neg implements EqlQuery {

    public Neg(Exp _inner) {
        super(_inner);
    }

    public Boolean isNeg(EqlQuery inner) {
        return ((Exp)inner).accept(new Eql(getInner()));
    }

    public <R> R accept(Visitor<R> v) {
        return ((VisitorDivdMultNegTruncate<R>) v).visit(this);
    }
}
