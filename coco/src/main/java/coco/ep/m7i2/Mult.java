package coco.ep.m7i2;

public interface Mult<FT> extends coco.ep.m7.Mult<FT>, coco.ep.m3.Mult<FT>, coco.ep.m7i2.Exp<FT> {

    default coco.ep.Exp<FT> multby(coco.ep.Exp<FT> other) {
        return this.mult(this, convert(other));
    }
    default coco.ep.Exp<FT> powby(coco.ep.Exp<FT> other) {
        return this.power(this, convert(other));
    }

}
