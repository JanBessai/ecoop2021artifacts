package trivially.ep.m2.finalized;

import trivially.ep.m2.Exp;

public interface Factory extends Exp<trivially.ep.m2.finalized.Visitor> {

    public default Exp<trivially.ep.m2.finalized.Visitor> sub(trivially.ep.Exp<trivially.ep.m2.finalized.Visitor> left, trivially.ep.Exp<trivially.ep.m2.finalized.Visitor> right) {
        return new Sub(this.convert(left), this.convert(right));
    }

    public default Exp<trivially.ep.m2.finalized.Visitor> lit(Double value) {
        return new Lit(value);
    }

    public default Exp<trivially.ep.m2.finalized.Visitor> add(trivially.ep.Exp<trivially.ep.m2.finalized.Visitor> left, trivially.ep.Exp<trivially.ep.m2.finalized.Visitor> right) {
        return new Add(this.convert(left), this.convert(right));
    }
}
