package trivially.ep.m6.finalized;

import trivially.ep.Exp;

public interface Factory extends trivially.ep.m6.Exp<trivially.ep.m6.finalized.Visitor> {

    public default trivially.ep.m6.Exp<trivially.ep.m6.finalized.Visitor> sub(Exp<trivially.ep.m6.finalized.Visitor> left, Exp<trivially.ep.m6.finalized.Visitor> right) {
        return new Sub(this.convert(left), this.convert(right));
    }

    public default trivially.ep.m6.Exp<trivially.ep.m6.finalized.Visitor> neg(Exp<trivially.ep.m6.finalized.Visitor> inner) {
        return new Neg(this.convert(inner));
    }

    public default trivially.ep.m6.Exp<trivially.ep.m6.finalized.Visitor> mult(Exp<trivially.ep.m6.finalized.Visitor> left, Exp<trivially.ep.m6.finalized.Visitor> right) {
        return new Mult(this.convert(left), this.convert(right));
    }

    public default trivially.ep.m6.Exp<trivially.ep.m6.finalized.Visitor> divd(Exp<trivially.ep.m6.finalized.Visitor> left, Exp<trivially.ep.m6.finalized.Visitor> right) {
        return new Divd(this.convert(left), this.convert(right));
    }

    public default trivially.ep.m6.Exp<trivially.ep.m6.finalized.Visitor> lit(Double value) {
        return new Lit(value);
    }

    public default trivially.ep.m6.Exp<trivially.ep.m6.finalized.Visitor> add(Exp<trivially.ep.m6.finalized.Visitor> left, Exp<trivially.ep.m6.finalized.Visitor> right) {
        return new Add(this.convert(left), this.convert(right));
    }
}
