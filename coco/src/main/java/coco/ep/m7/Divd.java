package coco.ep.m7;

import coco.ep.Exp;

public interface Divd<FT> extends coco.ep.m6.Divd<FT>, coco.ep.m7.Exp<FT> {

    public default Exp<FT> powby(Exp<FT> other) {
        return this.divd(this.convert(this.getLeft()).powby(this.convert(other)), this.convert(this.getRight()).powby(this.convert(other)));
    }
}
