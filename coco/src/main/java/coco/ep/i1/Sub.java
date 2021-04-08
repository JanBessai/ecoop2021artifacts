package coco.ep.i1;

import coco.ep.Exp;

public interface Sub<FT> extends coco.ep.m2.Sub<FT>, coco.ep.i1.Exp<FT> {

    default Exp<FT> multby(Exp<FT> other) {
        return this.sub(convert(this.getLeft()).multby(convert(other)), convert(this.getRight()).multby(convert(other)));
    }
}
