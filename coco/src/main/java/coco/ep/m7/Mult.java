package coco.ep.m7;

import coco.ep.Exp;

public interface Mult<FT> extends coco.ep.m6.Mult<FT>, coco.ep.m7.Exp<FT> {

    default Exp<FT> powby(Exp<FT> other) {
        return this.mult(convert(getLeft()).powby(convert(other)), convert(getRight()).powby(convert(other)));
    }
}
