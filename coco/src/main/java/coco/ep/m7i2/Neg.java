package coco.ep.m7i2;

import coco.ep.Exp;

public interface Neg<FT> extends coco.ep.m7.Neg<FT>, coco.ep.m3.Neg<FT>, coco.ep.m7i2.Exp<FT>, Factory<FT> {

    public default Exp<FT> multby(Exp<FT> other) {
        return this.mult(this, this.convert(other));
    }

    public default Exp<FT> powby(Exp<FT> other) {
        return this.mult(this.convert(this.lit(1.0)).powby(this.getInner()), this.convert(this.getInner()).powby(this.convert(other)));
    }
}
