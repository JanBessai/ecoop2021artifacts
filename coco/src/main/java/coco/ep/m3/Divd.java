package coco.ep.m3;

import coco.ep.m2.Exp;

public interface Divd<FT> extends Exp<FT>, Factory<FT> {

    public abstract Exp<FT> getLeft();

    public abstract Exp<FT> getRight();

    public default String prettyp() {
        return "(" + this.convert(this.getLeft()).prettyp() + "/" + this.convert(this.getRight()).prettyp() + ")";
    }

    public default Double eval() {
        return this.convert(this.getLeft()).eval() / this.convert(this.getRight()).eval();
    }
}
