package coco.ep.m6.finalized;

import coco.ep.Exp;
import coco.ep.m6.finalized.Add;
import coco.ep.m6.finalized.Divd;
import coco.ep.m6.finalized.Lit;
import coco.ep.m6.finalized.Mult;
import coco.ep.m6.finalized.Neg;
import coco.ep.m6.finalized.Sub;

public interface Factory extends coco.ep.m6.Factory<coco.ep.m6.finalized.Exp> {

    public default coco.ep.m6.finalized.Exp sub(Exp<coco.ep.m6.finalized.Exp> left, Exp<coco.ep.m6.finalized.Exp> right) {
        return new Sub(this.convert(left), this.convert(right));
    }

    public default coco.ep.m6.finalized.Exp neg(Exp<coco.ep.m6.finalized.Exp> inner) {
        return new Neg(this.convert(inner));
    }

    public default coco.ep.m6.finalized.Exp mult(Exp<coco.ep.m6.finalized.Exp> left, Exp<coco.ep.m6.finalized.Exp> right) {
        return new Mult(this.convert(left), this.convert(right));
    }

    public default coco.ep.m6.finalized.Exp divd(Exp<coco.ep.m6.finalized.Exp> left, Exp<coco.ep.m6.finalized.Exp> right) {
        return new Divd(this.convert(left), this.convert(right));
    }

    public default coco.ep.m6.finalized.Exp lit(Double value) {
        return new Lit(value);
    }

    public default coco.ep.m6.finalized.Exp add(Exp<coco.ep.m6.finalized.Exp> left, Exp<coco.ep.m6.finalized.Exp> right) {
        return new Add(this.convert(left), this.convert(right));
    }

    public default coco.ep.m6.finalized.Exp convert(Exp<coco.ep.m6.finalized.Exp> other) {
        return other.getSelf();
    }
}
