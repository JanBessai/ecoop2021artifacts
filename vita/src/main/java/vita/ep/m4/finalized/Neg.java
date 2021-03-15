package vita.ep.m4.finalized;

import vita.ep.m4.Exp;

public class Neg extends Factory implements vita.ep.m4.Neg<Visitor> {

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

    public Exp<Visitor> convert(vita.ep.Exp<Visitor> other) {
        Visitor visitor = new Visitor();
        other.accept(visitor);
        return visitor.getResult();
    }
}
