package vita.ep.m4.finalized;

import vita.ep.Exp;

public class Factory implements vita.ep.m4.Factory<Visitor> {

    public vita.ep.m4.Exp<Visitor> sub(Exp<Visitor> left, Exp<Visitor> right) {
        return new Sub(this.convert(left), this.convert(right));
    }

    public vita.ep.m4.Exp<Visitor> neg(Exp<Visitor> inner) {
        return new Neg(this.convert(inner));
    }

    public vita.ep.m4.Exp<Visitor> mult(Exp<Visitor> left, Exp<Visitor> right) {
        return new Mult(this.convert(left), this.convert(right));
    }

    public vita.ep.m4.Exp<Visitor> divd(Exp<Visitor> left, Exp<Visitor> right) {
        return new Divd(this.convert(left), this.convert(right));
    }

    public vita.ep.m4.Exp<Visitor> lit(Double value) {
        return new Lit(value);
    }

    public vita.ep.m4.Exp<Visitor> add(Exp<Visitor> left, Exp<Visitor> right) {
        return new Add(this.convert(left), this.convert(right));
    }

    public vita.ep.m4.Exp<Visitor> convert(Exp<Visitor> other) {
        Visitor visitor = new Visitor();
        other.accept(visitor);
        return visitor.getResult();
    }
}
