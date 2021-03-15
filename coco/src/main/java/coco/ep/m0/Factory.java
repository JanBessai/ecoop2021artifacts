package coco.ep.m0;

import coco.ep.Exp;

public interface Factory<FT> extends coco.ep.Factory<FT> {

    public abstract Exp<FT> lit(Double value);

    public abstract Exp<FT> add(Exp<FT> left, Exp<FT> right);

    public abstract coco.ep.m0.Exp<FT> convert(Exp<FT> other);
}
