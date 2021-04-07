package coco.ep.m3.finalized;

import coco.ep.Exp;

public interface Factory extends coco.ep.m3.Factory<coco.ep.m2.finalized.Exp>, coco.ep.m2.finalized.Factory {

    default coco.ep.m2.finalized.Exp neg(Exp<coco.ep.m2.finalized.Exp> inner) {
        return new Neg(convert(inner));
    }

    default coco.ep.m2.finalized.Exp mult(Exp<coco.ep.m2.finalized.Exp> left, Exp<coco.ep.m2.finalized.Exp> right) {
        return new Mult(convert(left), convert(right));
    }

    default coco.ep.m2.finalized.Exp divd(Exp<coco.ep.m2.finalized.Exp> left, Exp<coco.ep.m2.finalized.Exp> right) {
        return new Divd(convert(left), convert(right));
    }
}
