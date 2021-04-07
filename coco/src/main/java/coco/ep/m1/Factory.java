package coco.ep.m1;

import coco.ep.Exp;

public interface Factory<FT> extends coco.ep.m0.Factory<FT> {

    Exp<FT> sub(Exp<FT> left, Exp<FT> right);
}
