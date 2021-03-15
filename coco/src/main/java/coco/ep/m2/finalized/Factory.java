package coco.ep.m2.finalized;

import coco.ep.Exp;
import coco.ep.m2.finalized.Add;
import coco.ep.m2.finalized.Lit;
import coco.ep.m2.finalized.Sub;

public interface Factory extends coco.ep.m2.Factory<coco.ep.m2.finalized.Exp> {

    public default coco.ep.m2.finalized.Exp sub(Exp<coco.ep.m2.finalized.Exp> left, Exp<coco.ep.m2.finalized.Exp> right) {
        return new Sub(this.convert(left), this.convert(right));
    }

    public default coco.ep.m2.finalized.Exp lit(Double value) {
        return new Lit(value);
    }

    public default coco.ep.m2.finalized.Exp add(Exp<coco.ep.m2.finalized.Exp> left, Exp<coco.ep.m2.finalized.Exp> right) {
        return new Add(this.convert(left), this.convert(right));
    }

    public default coco.ep.m2.finalized.Exp convert(Exp<coco.ep.m2.finalized.Exp> other) {
        return other.getSelf();
    }
}
