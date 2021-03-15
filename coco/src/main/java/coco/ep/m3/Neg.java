package coco.ep.m3;

import coco.ep.m2.Exp;

public interface Neg<FT> extends Exp<FT>, Factory<FT> {

    public abstract Exp<FT> getInner();

    public default String prettyp() {
        return "-" + this.convert(this.getInner()).prettyp();
    }

    public default Double eval() {
        return -1.0 * this.convert(this.getInner()).eval();
    }
}
