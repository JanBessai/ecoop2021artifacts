package trivially.ep.m1.finalized;

import trivially.ep.m1.Exp;

public interface Factory extends Exp<trivially.ep.m1.finalized.Visitor> {

    public default Exp<trivially.ep.m1.finalized.Visitor> sub(trivially.ep.Exp<trivially.ep.m1.finalized.Visitor> left, trivially.ep.Exp<trivially.ep.m1.finalized.Visitor> right) {
        return new Sub(this.convert(left), this.convert(right));
    }

    public default Exp<trivially.ep.m1.finalized.Visitor> lit(Double value) {
        return new Lit(value);
    }

    public default Exp<trivially.ep.m1.finalized.Visitor> add(trivially.ep.Exp<trivially.ep.m1.finalized.Visitor> left, trivially.ep.Exp<trivially.ep.m1.finalized.Visitor> right) {
        return new Add(this.convert(left), this.convert(right));
    }
}
