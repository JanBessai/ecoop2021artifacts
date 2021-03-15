package coco.ep.m2;

import coco.ep.m2.Exp;

public interface Sub<FT> extends coco.ep.m1.Sub<FT>, Exp<FT> {

    public default String prettyp() {
        return "(" + this.convert(this.getLeft()).prettyp() + "-" + this.convert(this.getRight()).prettyp() + ")";
    }
}
