package coco.ep.m6;

public interface Lit<FT> extends coco.ep.m5.Lit<FT>, Exp<FT> {

    default Boolean isLit(Double d) {
        return d.equals(getValue());
    }

    default Boolean equals(coco.ep.Exp<FT> other) {
        return convert(this).astree().equals(convert(other).astree());
    }

    default Boolean eql(coco.ep.Exp<FT> that) {
        return convert(that).isLit(getValue());
    }
}
