package coco.ep.m3;

import coco.ep.m2.Exp;

public interface Neg<FT> extends Exp<FT>, Factory<FT> {

    Exp<FT> getInner();

    default String prettyp() {
        return "(-" + convert(getInner()).prettyp() + ")";
    }

    default Double eval() {
        return -1.0 * convert(getInner()).eval();
    }
}
