package vita.ep.m7i2.finalized;

import vita.ep.Exp;

public class Factory implements vita.ep.m7i2.Factory<Visitor> {

    public vita.ep.m7i2.Exp<Visitor> sub(Exp<Visitor> left, Exp<Visitor> right) {
        return new Sub(this.convert(left), this.convert(right));
    }

    public vita.ep.m7i2.Exp<Visitor> power(Exp<Visitor> left, Exp<Visitor> right) {
        return new Power(this.convert(left), this.convert(right));
    }

    public vita.ep.m7i2.Exp<Visitor> lit(Double value) {
        return new Lit(value);
    }

    public vita.ep.m7i2.Exp<Visitor> add(Exp<Visitor> left, Exp<Visitor> right) {
        return new Add(this.convert(left), this.convert(right));
    }

    public vita.ep.m7i2.Exp<Visitor> neg(Exp<Visitor> inner) {
        return new Neg(this.convert(inner));
    }

    public vita.ep.m7i2.Exp<Visitor> mult(Exp<Visitor> left, Exp<Visitor> right) {
        return new Mult(this.convert(left), this.convert(right));
    }

    public vita.ep.m7i2.Exp<Visitor> divd(Exp<Visitor> left, Exp<Visitor> right) {
        return new Divd(this.convert(left), this.convert(right));
    }

    public vita.ep.m7i2.Exp<Visitor> convert(Exp<Visitor> other) {
        Visitor visitor = new Visitor();
        other.accept(visitor);
        return visitor.getResult();
    }
}
