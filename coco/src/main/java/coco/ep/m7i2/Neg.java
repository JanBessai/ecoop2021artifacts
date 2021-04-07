package coco.ep.m7i2;

import coco.ep.Exp;

public interface Neg<FT> extends coco.ep.m7.Neg<FT>, coco.ep.m3.Neg<FT>, coco.ep.m7i2.Exp<FT>, Factory<FT> {

    default Exp<FT> multby(Exp<FT> other) {
        return this.mult(this, convert(other));
    }

    default Exp<FT> powby(Exp<FT> other) {
        return this.mult(convert(this.lit(1.0)).powby(getInner()), convert(getInner()).powby(convert(other)));
    }
}
