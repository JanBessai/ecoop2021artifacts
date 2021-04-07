package coco.ep.m6;

public interface Neg<FT> extends coco.ep.m5.Neg<FT>, Exp<FT> {

    default Boolean equals(coco.ep.Exp<FT> other) {
        return convert(this).astree().equals(convert(other).astree());
    }

    default Boolean isNeg(coco.ep.Exp<FT> inner) {
        return convert(inner).eql(getInner());
    }

    default Boolean eql(coco.ep.Exp<FT> that) {
        return convert(that).isNeg(convert(getInner()));
    }
}
