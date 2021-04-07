package coco.ep.m7;

import coco.ep.Exp;

public interface Divd<FT> extends coco.ep.m6.Divd<FT>, coco.ep.m7.Exp<FT> {

    default Exp<FT> powby(Exp<FT> other) {
        return this.divd(convert(getLeft()).powby(convert(other)), convert(getRight()).powby(convert(other)));
    }
}
