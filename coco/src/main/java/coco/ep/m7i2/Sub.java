package coco.ep.m7i2;

import coco.ep.Exp;

public interface Sub<FT> extends coco.ep.m7.Sub<FT>, coco.ep.i1.Sub<FT>, coco.ep.m7i2.Exp<FT>, Factory<FT> {

    public default Exp<FT> powby(Exp<FT> other) {
        return this.convert(this.lit(this.convert(this).eval())).powby(this.convert(other));
    }
}
