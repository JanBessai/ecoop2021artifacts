package coco.ep.i2.finalized;

import coco.ep.Exp;
import coco.ep.i2.finalized.Power;

public interface Factory extends coco.ep.i2.Factory<coco.ep.i1.finalized.Exp>, coco.ep.i1.finalized.Factory {

    public default coco.ep.i1.finalized.Exp power(Exp<coco.ep.i1.finalized.Exp> left, Exp<coco.ep.i1.finalized.Exp> right) {
        return new Power(this.convert(left), this.convert(right));
    }
}
