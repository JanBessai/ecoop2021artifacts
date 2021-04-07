package coco.ep.m0;

import coco.ep.Exp;

public interface Factory<FT> extends coco.ep.Factory<FT> {

    Exp<FT> lit(Double value);

    Exp<FT> add(Exp<FT> left, Exp<FT> right);

    coco.ep.m0.Exp<FT> convert(Exp<FT> other);
}
