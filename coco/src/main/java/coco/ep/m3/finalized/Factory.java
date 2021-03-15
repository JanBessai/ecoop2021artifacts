package coco.ep.m3.finalized;

import coco.ep.Exp;
import coco.ep.m3.finalized.Divd;
import coco.ep.m3.finalized.Mult;
import coco.ep.m3.finalized.Neg;

public interface Factory extends coco.ep.m3.Factory<coco.ep.m2.finalized.Exp>, coco.ep.m2.finalized.Factory {

    public default coco.ep.m2.finalized.Exp neg(Exp<coco.ep.m2.finalized.Exp> inner) {
        return new Neg(this.convert(inner));
    }

    public default coco.ep.m2.finalized.Exp mult(Exp<coco.ep.m2.finalized.Exp> left, Exp<coco.ep.m2.finalized.Exp> right) {
        return new Mult(this.convert(left), this.convert(right));
    }

    public default coco.ep.m2.finalized.Exp divd(Exp<coco.ep.m2.finalized.Exp> left, Exp<coco.ep.m2.finalized.Exp> right) {
        return new Divd(this.convert(left), this.convert(right));
    }
}
