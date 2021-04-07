package coco.ep.m7.finalized;

import coco.ep.Exp;
import coco.ep.m7.finalized.Add;
import coco.ep.m7.finalized.Divd;
import coco.ep.m7.finalized.Lit;
import coco.ep.m7.finalized.Mult;
import coco.ep.m7.finalized.Neg;
import coco.ep.m7.finalized.Sub;

public interface Factory extends coco.ep.m7.Factory<coco.ep.m7.finalized.Exp> {

    default coco.ep.m7.finalized.Exp sub(Exp<coco.ep.m7.finalized.Exp> left, Exp<coco.ep.m7.finalized.Exp> right) {
        return new Sub(convert(left), convert(right));
    }

    default coco.ep.m7.finalized.Exp neg(Exp<coco.ep.m7.finalized.Exp> inner) {
        return new Neg(convert(inner));
    }

    default coco.ep.m7.finalized.Exp mult(Exp<coco.ep.m7.finalized.Exp> left, Exp<coco.ep.m7.finalized.Exp> right) {
        return new Mult(convert(left), convert(right));
    }

    default coco.ep.m7.finalized.Exp divd(Exp<coco.ep.m7.finalized.Exp> left, Exp<coco.ep.m7.finalized.Exp> right) {
        return new Divd(convert(left), convert(right));
    }

    default coco.ep.m7.finalized.Exp lit(Double value) {
        return new Lit(value);
    }

    default coco.ep.m7.finalized.Exp add(Exp<coco.ep.m7.finalized.Exp> left, Exp<coco.ep.m7.finalized.Exp> right) {
        return new Add(convert(left), convert(right));
    }

    default coco.ep.m7.finalized.Exp convert(Exp<coco.ep.m7.finalized.Exp> other) {
        return other.getSelf();
    }
}
