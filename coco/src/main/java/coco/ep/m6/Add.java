package coco.ep.m6;

import coco.ep.m6.Exp;

public interface Add<FT> extends coco.ep.m5.Add<FT>, Exp<FT> {

    public default Boolean equals(coco.ep.Exp<FT> other) {
        return this.convert(this).astree().equals(this.convert(this.convert(other)).astree());
    }
}
