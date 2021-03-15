package coco.ep.m7i2;

import coco.ep.Exp;

public interface Divd<FT> extends coco.ep.m7.Divd<FT>, coco.ep.m3.Divd<FT>, coco.ep.m7i2.Exp<FT>, Factory<FT> {

    public default Exp<FT> multby(Exp<FT> other) {
        return this.mult(this, this.convert(other));
    }

    public default Exp<FT> powby(Exp<FT> other) {
        return this.divd(this.convert(this.getLeft()).powby(this.convert(other)), this.convert(this.getRight()).powby(this.convert(other)));
    }
}
