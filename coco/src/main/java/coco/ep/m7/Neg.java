package coco.ep.m7;

import coco.ep.Exp;

public interface Neg<FT> extends coco.ep.m6.Neg<FT>, coco.ep.m7.Exp<FT> {

    public default Exp<FT> powby(Exp<FT> other) {
        return this.mult(this.convert(this.lit(1.0)).powby(this.getInner()), this.convert(this.getInner()).powby(this.convert(other)));
    }
}
