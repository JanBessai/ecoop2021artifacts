package coco.ep.i1;

import coco.ep.Exp;

public interface Sub<FT> extends coco.ep.m2.Sub<FT>, coco.ep.i1.Exp<FT> {

    public default Exp<FT> multby(Exp<FT> other) {
        return this.sub(this.convert(this.getLeft()).multby(this.convert(other)), this.convert(this.getRight()).multby(this.convert(other)));
    }
}
