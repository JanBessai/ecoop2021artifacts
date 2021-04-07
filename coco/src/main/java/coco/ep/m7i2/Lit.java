package coco.ep.m7i2;

public interface Lit<FT> extends coco.ep.m7.Lit<FT>, coco.ep.i1.Lit<FT>, Exp<FT>, Factory<FT> {
    // Merged branches offer optimizations
    default coco.ep.Exp<FT> multby(coco.ep.Exp<FT> other) {
        return this.mult(this, convert(other));
    }
    default coco.ep.Exp<FT> powby(coco.ep.Exp<FT> other) {
        return this.power(this, convert(other));
    }
}
