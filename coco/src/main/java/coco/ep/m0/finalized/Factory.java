package coco.ep.m0.finalized;

public interface Factory extends coco.ep.m0.Factory<Exp> {

    default Exp lit(Double value) {
        return new Lit(value);
    }

    default Exp add(coco.ep.Exp<Exp> left, coco.ep.Exp<Exp> right) {
        return new Add(convert(left), convert(right));
    }

    default Exp convert(coco.ep.Exp<Exp> other) {
        return other.getSelf();
    }
}
