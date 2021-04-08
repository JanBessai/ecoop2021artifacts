package trivially.ep.i2.finalized;

import trivially.ep.Exp;

public interface Factory extends trivially.ep.i2.Exp<trivially.ep.i2.finalized.Visitor> {

    default trivially.ep.i2.Exp<trivially.ep.i2.finalized.Visitor> sub(Exp<trivially.ep.i2.finalized.Visitor> left, Exp<trivially.ep.i2.finalized.Visitor> right) {
        return new Sub(convert(left), convert(right));
    }

    default trivially.ep.i2.Exp<trivially.ep.i2.finalized.Visitor> power(Exp<trivially.ep.i2.finalized.Visitor> left, Exp<trivially.ep.i2.finalized.Visitor> right) {
        return new Power(convert(left), convert(right));
    }

    default trivially.ep.i2.Exp<trivially.ep.i2.finalized.Visitor> lit(Double value) {
        return new Lit(value);
    }

    default trivially.ep.i2.Exp<trivially.ep.i2.finalized.Visitor> add(Exp<trivially.ep.i2.finalized.Visitor> left, Exp<trivially.ep.i2.finalized.Visitor> right) {
        return new Add(convert(left), convert(right));
    }
}
