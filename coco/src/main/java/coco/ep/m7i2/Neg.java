package coco.ep.m7i2;

public interface Neg<FT> extends coco.ep.m7.Neg<FT>, coco.ep.m3.Neg<FT>, coco.ep.m7i2.Exp<FT>, Factory<FT> {

    default coco.ep.Exp<FT> multby(coco.ep.Exp<FT> other) {
        return this.mult(this, convert(other));
    }
    default coco.ep.Exp<FT> powby(coco.ep.Exp<FT> other) {
        return this.power(this, convert(other));
    }

}
