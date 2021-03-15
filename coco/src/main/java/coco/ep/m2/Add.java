package coco.ep.m2;

import coco.ep.m2.Exp;

public interface Add<FT> extends coco.ep.m0.Add<FT>, Exp<FT> {

    public default String prettyp() {
        return "(" + this.convert(this.getLeft()).prettyp() + "+" + this.convert(this.getRight()).prettyp() + ")";
    }
}
