package coco.ep.i1.finalized;

import coco.ep.Exp;
import coco.ep.i1.finalized.Add;
import coco.ep.i1.finalized.Lit;
import coco.ep.i1.finalized.Sub;

public interface Factory extends coco.ep.i1.Factory<coco.ep.i1.finalized.Exp> {

    public default coco.ep.i1.finalized.Exp sub(Exp<coco.ep.i1.finalized.Exp> left, Exp<coco.ep.i1.finalized.Exp> right) {
        return new Sub(this.convert(left), this.convert(right));
    }

    public default coco.ep.i1.finalized.Exp lit(Double value) {
        return new Lit(value);
    }

    public default coco.ep.i1.finalized.Exp add(Exp<coco.ep.i1.finalized.Exp> left, Exp<coco.ep.i1.finalized.Exp> right) {
        return new Add(this.convert(left), this.convert(right));
    }

    public default coco.ep.i1.finalized.Exp convert(Exp<coco.ep.i1.finalized.Exp> other) {
        return other.getSelf();
    }
}
