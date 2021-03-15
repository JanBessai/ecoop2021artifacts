package coco.ep.m3;

import coco.ep.Exp;

public interface Factory<FT> extends coco.ep.m2.Factory<FT> {

    public abstract Exp<FT> neg(Exp<FT> inner);

    public abstract Exp<FT> mult(Exp<FT> left, Exp<FT> right);

    public abstract Exp<FT> divd(Exp<FT> left, Exp<FT> right);
}
