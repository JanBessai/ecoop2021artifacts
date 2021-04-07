package coco.ep.m3;

import coco.ep.m2.Exp;

public interface Divd<FT> extends Exp<FT>, Factory<FT> {

    Exp<FT> getLeft();
    Exp<FT> getRight();

    default String prettyp() {
        return "(" + convert(getLeft()).prettyp() + "/" + convert(getRight()).prettyp() + ")";
    }

    default Double eval() {
        return convert(getLeft()).eval() / convert(getRight()).eval();
    }
}
