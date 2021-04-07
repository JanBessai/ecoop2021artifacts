package coco.ep.m3;

import coco.ep.Exp;

public interface Factory<FT> extends coco.ep.m2.Factory<FT> {

    Exp<FT> neg(Exp<FT> inner);

    Exp<FT> mult(Exp<FT> left, Exp<FT> right);

    Exp<FT> divd(Exp<FT> left, Exp<FT> right);
}
