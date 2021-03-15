package coco.ep.m7;

import coco.ep.Exp;

public interface Add<FT> extends coco.ep.m6.Add<FT>, coco.ep.m7.Exp<FT> {

    public default Exp<FT> powby(Exp<FT> other) {
        return this.convert(this.lit(this.convert(this).eval())).powby(this.convert(other));
    }
}
