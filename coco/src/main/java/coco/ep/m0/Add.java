package coco.ep.m0;

import coco.ep.Exp;

public interface Add<FT> extends coco.ep.m0.Exp<FT> {

    public abstract Exp<FT> getLeft();

    public abstract Exp<FT> getRight();

    public default Double eval() {
        return this.convert(this.getLeft()).eval() + this.convert(this.getRight()).eval();
    }
}
