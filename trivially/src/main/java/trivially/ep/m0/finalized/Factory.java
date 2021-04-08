package trivially.ep.m0.finalized;

import trivially.ep.m0.Exp;

public interface Factory extends Exp<trivially.ep.m0.finalized.Visitor> {

    default Exp<trivially.ep.m0.finalized.Visitor> lit(Double value) {
        return new Lit(value);
    }

    default Exp<trivially.ep.m0.finalized.Visitor> add(trivially.ep.Exp<trivially.ep.m0.finalized.Visitor> left, trivially.ep.Exp<trivially.ep.m0.finalized.Visitor> right) {
        return new Add(this.convert(left), this.convert(right));
    }
}
