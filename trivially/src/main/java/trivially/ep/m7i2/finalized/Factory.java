package trivially.ep.m7i2.finalized;

import trivially.ep.Exp;

public interface Factory extends trivially.ep.m7i2.Exp<trivially.ep.m7i2.finalized.Visitor> {

    default trivially.ep.m7i2.Exp<trivially.ep.m7i2.finalized.Visitor> sub(Exp<trivially.ep.m7i2.finalized.Visitor> left, Exp<trivially.ep.m7i2.finalized.Visitor> right) {
        return new Sub(this.convert(left), this.convert(right));
    }

    default trivially.ep.m7i2.Exp<trivially.ep.m7i2.finalized.Visitor> neg(Exp<trivially.ep.m7i2.finalized.Visitor> inner) {
        return new Neg(this.convert(inner));
    }

    default trivially.ep.m7i2.Exp<trivially.ep.m7i2.finalized.Visitor> mult(Exp<trivially.ep.m7i2.finalized.Visitor> left, Exp<trivially.ep.m7i2.finalized.Visitor> right) {
        return new Mult(this.convert(left), this.convert(right));
    }

    default trivially.ep.m7i2.Exp<trivially.ep.m7i2.finalized.Visitor> divd(Exp<trivially.ep.m7i2.finalized.Visitor> left, Exp<trivially.ep.m7i2.finalized.Visitor> right) {
        return new Divd(this.convert(left), this.convert(right));
    }

    default trivially.ep.m7i2.Exp<trivially.ep.m7i2.finalized.Visitor> power(Exp<trivially.ep.m7i2.finalized.Visitor> left, Exp<trivially.ep.m7i2.finalized.Visitor> right) {
        return new Power(this.convert(left), this.convert(right));
    }

    default trivially.ep.m7i2.Exp<trivially.ep.m7i2.finalized.Visitor> lit(Double value) {
        return new Lit(value);
    }

    default trivially.ep.m7i2.Exp<trivially.ep.m7i2.finalized.Visitor> add(Exp<trivially.ep.m7i2.finalized.Visitor> left, Exp<trivially.ep.m7i2.finalized.Visitor> right) {
        return new Add(this.convert(left), this.convert(right));
    }
}
