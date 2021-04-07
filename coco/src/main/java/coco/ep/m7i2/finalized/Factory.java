package coco.ep.m7i2.finalized;

import coco.ep.Exp;

public interface Factory extends coco.ep.m7i2.Factory<coco.ep.m7i2.finalized.Exp> {

    default coco.ep.m7i2.finalized.Exp sub(Exp<coco.ep.m7i2.finalized.Exp> left, Exp<coco.ep.m7i2.finalized.Exp> right) {
        return new Sub(convert(left), convert(right));
    }

    default coco.ep.m7i2.finalized.Exp power(Exp<coco.ep.m7i2.finalized.Exp> left, Exp<coco.ep.m7i2.finalized.Exp> right) {
        return new Power(convert(left), convert(right));
    }

    default coco.ep.m7i2.finalized.Exp lit(Double value) {
        return new Lit(value);
    }

    default coco.ep.m7i2.finalized.Exp add(Exp<coco.ep.m7i2.finalized.Exp> left, Exp<coco.ep.m7i2.finalized.Exp> right) {
        return new Add(convert(left), convert(right));
    }

    default coco.ep.m7i2.finalized.Exp neg(Exp<coco.ep.m7i2.finalized.Exp> inner) {
        return new Neg(convert(inner));
    }

    default coco.ep.m7i2.finalized.Exp mult(Exp<coco.ep.m7i2.finalized.Exp> left, Exp<coco.ep.m7i2.finalized.Exp> right) {
        return new Mult(convert(left), convert(right));
    }

    default coco.ep.m7i2.finalized.Exp divd(Exp<coco.ep.m7i2.finalized.Exp> left, Exp<coco.ep.m7i2.finalized.Exp> right) {
        return new Divd(convert(left), convert(right));
    }

    default coco.ep.m7i2.finalized.Exp convert(Exp<coco.ep.m7i2.finalized.Exp> other) {
        return other.getSelf();
    }
}
