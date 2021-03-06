package coco.ep.m1.finalized;

import coco.ep.Exp;

public interface Factory extends coco.ep.m1.Factory<coco.ep.m0.finalized.Exp>, coco.ep.m0.finalized.Factory {

    default coco.ep.m0.finalized.Exp sub(Exp<coco.ep.m0.finalized.Exp> left, Exp<coco.ep.m0.finalized.Exp> right) {
        return new Sub(convert(left), convert(right));
    }
}
