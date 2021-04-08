package trivially.ep.i1.finalized;

import trivially.ep.Exp;

public interface Factory extends trivially.ep.i1.Exp<trivially.ep.i1.finalized.Visitor> {

    default trivially.ep.i1.Exp<trivially.ep.i1.finalized.Visitor> lit(Double value) {
        return new Lit(value);
    }

    default trivially.ep.i1.Exp<trivially.ep.i1.finalized.Visitor> add(Exp<trivially.ep.i1.finalized.Visitor> left, Exp<trivially.ep.i1.finalized.Visitor> right) {
        return new Add(this.convert(left), this.convert(right));
    }

    default trivially.ep.i1.Exp<trivially.ep.i1.finalized.Visitor> sub(Exp<trivially.ep.i1.finalized.Visitor> left, Exp<trivially.ep.i1.finalized.Visitor> right) {
        return new Sub(this.convert(left), this.convert(right));
    }
}
