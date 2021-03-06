package ev.ep.m3;

import ev.ep.Exp;
import ev.ep.Visitor;

public class Neg extends Exp {

    protected Exp inner;

    public Neg(Exp _inner) {
        this.inner = _inner;
    }

    public Exp getInner() {
        return this.inner;
    }

    public void setInner(Exp _inner) { this.inner = _inner; }

    public <R> R accept(Visitor<R> v) {
        return ((VisitorDivdMultNeg<R>) v).visit(this);
    }
}
