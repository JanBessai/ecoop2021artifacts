package coco.ep.m4.finalized;

import coco.ep.Exp;
import coco.ep.m4.finalized.Add;
import coco.ep.m4.finalized.Divd;
import coco.ep.m4.finalized.Lit;
import coco.ep.m4.finalized.Mult;
import coco.ep.m4.finalized.Neg;
import coco.ep.m4.finalized.Sub;

public interface Factory extends coco.ep.m4.Factory<coco.ep.m4.finalized.Exp> {

    public default coco.ep.m4.finalized.Exp sub(Exp<coco.ep.m4.finalized.Exp> left, Exp<coco.ep.m4.finalized.Exp> right) {
        return new Sub(this.convert(left), this.convert(right));
    }

    public default coco.ep.m4.finalized.Exp neg(Exp<coco.ep.m4.finalized.Exp> inner) {
        return new Neg(this.convert(inner));
    }

    public default coco.ep.m4.finalized.Exp mult(Exp<coco.ep.m4.finalized.Exp> left, Exp<coco.ep.m4.finalized.Exp> right) {
        return new Mult(this.convert(left), this.convert(right));
    }

    public default coco.ep.m4.finalized.Exp divd(Exp<coco.ep.m4.finalized.Exp> left, Exp<coco.ep.m4.finalized.Exp> right) {
        return new Divd(this.convert(left), this.convert(right));
    }

    public default coco.ep.m4.finalized.Exp lit(Double value) {
        return new Lit(value);
    }

    public default coco.ep.m4.finalized.Exp add(Exp<coco.ep.m4.finalized.Exp> left, Exp<coco.ep.m4.finalized.Exp> right) {
        return new Add(this.convert(left), this.convert(right));
    }

    public default coco.ep.m4.finalized.Exp convert(Exp<coco.ep.m4.finalized.Exp> other) {
        return other.getSelf();
    }
}
