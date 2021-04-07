package coco.ep.m1;

import coco.ep.m0.Exp;

public interface Sub<FT> extends Exp<FT>, Factory<FT> {

    Exp<FT> getLeft();

    Exp<FT> getRight();

    default Double eval() {
        return convert(getLeft()).eval() - convert(getRight()).eval();
    }
}
