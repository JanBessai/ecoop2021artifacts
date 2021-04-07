package coco.ep.m7i2;

import coco.ep.Exp;

public interface Add<FT> extends coco.ep.m7.Add<FT>, coco.ep.i1.Add<FT>, coco.ep.m7i2.Exp<FT>, Factory<FT> {

    default Exp<FT> powby(Exp<FT> other) {
        return convert(this.lit(convert(this).eval())).powby(convert(other));
    }
}
