package coco.ep.m1;

import coco.ep.m0.Exp;

public interface Sub<FT> extends Exp<FT>, Factory<FT> {

    public abstract Exp<FT> getLeft();

    public abstract Exp<FT> getRight();

    public default Double eval() {
        return this.convert(this.getLeft()).eval() - this.convert(this.getRight()).eval();
    }
}
