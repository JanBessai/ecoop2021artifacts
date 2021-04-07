package coco.ep.m0;

import coco.ep.Exp;

public interface Add<FT> extends coco.ep.m0.Exp<FT> {

    Exp<FT> getLeft();

    Exp<FT> getRight();

    default Double eval() {
        return convert(getLeft()).eval() + convert(getRight()).eval();
    }
}
