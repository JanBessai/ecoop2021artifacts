package trivially.ep.m1.finalized;

import trivially.ep.m1.Exp;

public interface Factory extends Exp<trivially.ep.m1.finalized.Visitor> {

    default Exp<trivially.ep.m1.finalized.Visitor> sub(trivially.ep.Exp<trivially.ep.m1.finalized.Visitor> left, trivially.ep.Exp<trivially.ep.m1.finalized.Visitor> right) {
        return new Sub(convert(left), convert(right));
    }

    default Exp<trivially.ep.m1.finalized.Visitor> lit(Double value) {
        return new Lit(value);
    }

    default Exp<trivially.ep.m1.finalized.Visitor> add(trivially.ep.Exp<trivially.ep.m1.finalized.Visitor> left, trivially.ep.Exp<trivially.ep.m1.finalized.Visitor> right) {
        return new Add(convert(left), convert(right));
    }
}
