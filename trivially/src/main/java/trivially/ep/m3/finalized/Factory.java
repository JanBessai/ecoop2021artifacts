package trivially.ep.m3.finalized;

import trivially.ep.Exp;

public interface Factory extends trivially.ep.m3.Exp<trivially.ep.m3.finalized.Visitor> {

    default trivially.ep.m3.Exp<trivially.ep.m3.finalized.Visitor> sub(Exp<trivially.ep.m3.finalized.Visitor> left, Exp<trivially.ep.m3.finalized.Visitor> right) {
        return new Sub(convert(left), convert(right));
    }

    default trivially.ep.m3.Exp<trivially.ep.m3.finalized.Visitor> neg(Exp<trivially.ep.m3.finalized.Visitor> inner) {
        return new Neg(convert(inner));
    }

    default trivially.ep.m3.Exp<trivially.ep.m3.finalized.Visitor> mult(Exp<trivially.ep.m3.finalized.Visitor> left, Exp<trivially.ep.m3.finalized.Visitor> right) {
        return new Mult(convert(left), convert(right));
    }

    default trivially.ep.m3.Exp<trivially.ep.m3.finalized.Visitor> divd(Exp<trivially.ep.m3.finalized.Visitor> left, Exp<trivially.ep.m3.finalized.Visitor> right) {
        return new Divd(convert(left), convert(right));
    }

    default trivially.ep.m3.Exp<trivially.ep.m3.finalized.Visitor> lit(Double value) {
        return new Lit(value);
    }

    default trivially.ep.m3.Exp<trivially.ep.m3.finalized.Visitor> add(Exp<trivially.ep.m3.finalized.Visitor> left, Exp<trivially.ep.m3.finalized.Visitor> right) {
        return new Add(convert(left), convert(right));
    }
}
