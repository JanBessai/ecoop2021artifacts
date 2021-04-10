package coco.ep.i1.finalized;

import coco.ep.Exp;

public interface Factory extends coco.ep.i1.Factory<coco.ep.i1.finalized.Exp> {

    default coco.ep.i1.finalized.Exp sub(Exp<coco.ep.i1.finalized.Exp> left, Exp<coco.ep.i1.finalized.Exp> right) {
        return new Sub(convert(left), convert(right));
    }

    default coco.ep.i1.finalized.Exp lit(Double value) {
        return new Lit(value);
    }

    default coco.ep.i1.finalized.Exp add(Exp<coco.ep.i1.finalized.Exp> left, Exp<coco.ep.i1.finalized.Exp> right) {
        return new Add(convert(left), convert(right));
    }

    default coco.ep.i1.finalized.Exp convert(Exp<coco.ep.i1.finalized.Exp> other) {
        return other.getSelf();
    }
}
