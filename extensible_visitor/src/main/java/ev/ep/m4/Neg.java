package ev.ep.m4;

import ev.ep.Exp;
import ev.ep.Visitor;

public class Neg extends ev.ep.m3.Neg {

    public Neg(Exp _inner) {
        super(_inner);
    }

    public void setInner(Exp _inner) {
        this.inner = _inner;
    }

    public <R> R accept(Visitor<R> v) {
        return ((VisitorDivdMultNegTruncate<R>) v).visit(this);
    }
}

