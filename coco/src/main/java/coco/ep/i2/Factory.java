package coco.ep.i2;

import coco.ep.Exp;

public interface Factory<FT> extends coco.ep.i1.Factory<FT> {

    public abstract Exp<FT> power(Exp<FT> left, Exp<FT> right);
}
