package coco.ep.m0.finalized;

import coco.ep.m0.finalized.Add;
import coco.ep.m0.finalized.Lit;

public interface Factory extends coco.ep.m0.Factory<Exp> {

    public default Exp lit(Double value) {
        return new Lit(value);
    }

    public default Exp add(coco.ep.Exp<Exp> left, coco.ep.Exp<Exp> right) {
        return new Add(this.convert(left), this.convert(right));
    }

    public default Exp convert(coco.ep.Exp<Exp> other) {
        return other.getSelf();
    }
}
