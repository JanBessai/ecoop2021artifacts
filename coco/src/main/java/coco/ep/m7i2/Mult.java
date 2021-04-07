package coco.ep.m7i2;

import coco.ep.Exp;

public interface Mult<FT> extends coco.ep.m7.Mult<FT>, coco.ep.m3.Mult<FT>, coco.ep.m7i2.Exp<FT>, Factory<FT> {

    default Exp<FT> multby(Exp<FT> other) {
        return this.mult(this, convert(other));
    }

    default Exp<FT> powby(Exp<FT> other) {
        return this.mult(convert(getLeft()).powby(convert(other)), convert(getRight()).powby(convert(other)));
    }
}
