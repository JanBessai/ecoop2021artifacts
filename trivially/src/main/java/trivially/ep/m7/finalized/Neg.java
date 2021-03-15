package trivially.ep.m7.finalized;

import trivially.ep.m7.Exp;

public class Neg implements trivially.ep.m7.Neg<Visitor>, Factory {

    protected Exp<Visitor> inner;

    public Neg(Exp<Visitor> _inner) {
        this.inner = _inner;
    }

    public Exp<Visitor> getInner() {
        return this.inner;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Exp<Visitor> convert(trivially.ep.Exp<Visitor> other) {
        Visitor visitor = new Visitor();
        other.accept(visitor);
        return visitor.getResult();
    }
}
