package coco.ep.m6;

public interface Mult<FT> extends coco.ep.m5.Mult<FT>, Exp<FT> {

    default Boolean equals(coco.ep.Exp<FT> other) {
        return convert(this).astree().equals(convert(other).astree());
    }
}
