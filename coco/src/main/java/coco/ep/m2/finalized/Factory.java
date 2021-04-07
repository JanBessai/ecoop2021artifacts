package coco.ep.m2.finalized;

import coco.ep.Exp;

public interface Factory extends coco.ep.m2.Factory<coco.ep.m2.finalized.Exp> {

    default coco.ep.m2.finalized.Exp sub(Exp<coco.ep.m2.finalized.Exp> left, Exp<coco.ep.m2.finalized.Exp> right) {
        return new Sub(convert(left), convert(right));
    }

    default coco.ep.m2.finalized.Exp lit(Double value) {
        return new Lit(value);
    }

    default coco.ep.m2.finalized.Exp add(Exp<coco.ep.m2.finalized.Exp> left, Exp<coco.ep.m2.finalized.Exp> right) {
        return new Add(convert(left), convert(right));
    }

    default coco.ep.m2.finalized.Exp convert(Exp<coco.ep.m2.finalized.Exp> other) {
        return other.getSelf();
    }
}
