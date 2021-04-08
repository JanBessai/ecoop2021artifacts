package coco.ep.i1;

import coco.ep.Exp;

public interface Add<FT> extends coco.ep.m2.Add<FT>, coco.ep.i1.Exp<FT> {

    default Exp<FT> multby(Exp<FT> other) {
        return this.add(convert(this.getLeft()).multby(convert(other)), convert(this.getRight()).multby(convert(other)));
    }
}
