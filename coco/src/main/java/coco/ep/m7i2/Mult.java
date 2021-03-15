package coco.ep.m7i2;

import coco.ep.Exp;

public interface Mult<FT> extends coco.ep.m7.Mult<FT>, coco.ep.m3.Mult<FT>, coco.ep.m7i2.Exp<FT>, Factory<FT> {

    public default Exp<FT> multby(Exp<FT> other) {
        return this.mult(this, this.convert(other));
    }

    public default Exp<FT> powby(Exp<FT> other) {
        return this.mult(this.convert(this.getLeft()).powby(this.convert(other)), this.convert(this.getRight()).powby(this.convert(other)));
    }
}
