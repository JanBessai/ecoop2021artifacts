package coco.ep.m7;

import coco.ep.Exp;

public interface Add<FT> extends coco.ep.m6.Add<FT>, coco.ep.m7.Exp<FT> {

    default Exp<FT> powby(Exp<FT> other) {
        return convert(this.lit(convert(this).eval())).powby(convert(other));
    }
}
