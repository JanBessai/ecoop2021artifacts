package trivially.ep.i2.finalized;

import trivially.ep.i2.Exp;

public class Neg implements trivially.ep.i2.Neg<Visitor>, Factory {

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
