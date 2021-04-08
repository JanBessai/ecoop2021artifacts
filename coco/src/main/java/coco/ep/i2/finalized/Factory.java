package coco.ep.i2.finalized;

import coco.ep.Exp;

public interface Factory extends coco.ep.i2.Factory<coco.ep.i1.finalized.Exp>, coco.ep.i1.finalized.Factory {

    default coco.ep.i1.finalized.Exp power(Exp<coco.ep.i1.finalized.Exp> left, Exp<coco.ep.i1.finalized.Exp> right) {
        return new Power(convert(left), convert(right));
    }
}
