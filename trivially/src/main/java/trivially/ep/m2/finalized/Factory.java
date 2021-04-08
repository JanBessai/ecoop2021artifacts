package trivially.ep.m2.finalized;

import trivially.ep.m2.Exp;

public interface Factory extends Exp<trivially.ep.m2.finalized.Visitor> {

    default Exp<trivially.ep.m2.finalized.Visitor> sub(trivially.ep.Exp<trivially.ep.m2.finalized.Visitor> left, trivially.ep.Exp<trivially.ep.m2.finalized.Visitor> right) {
        return new Sub(convert(left), convert(right));
    }

    default Exp<trivially.ep.m2.finalized.Visitor> lit(Double value) {
        return new Lit(value);
    }

    default Exp<trivially.ep.m2.finalized.Visitor> add(trivially.ep.Exp<trivially.ep.m2.finalized.Visitor> left, trivially.ep.Exp<trivially.ep.m2.finalized.Visitor> right) {
        return new Add(convert(left), convert(right));
    }
}
