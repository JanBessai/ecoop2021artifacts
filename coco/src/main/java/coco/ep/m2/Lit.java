package coco.ep.m2;

import coco.ep.m2.Exp;

public interface Lit<FT> extends coco.ep.m0.Lit<FT>, Exp<FT> {

    public default String prettyp() {
        return String.valueOf(this.getValue());
    }
}
