package coco.ep.m6;

public interface Add<FT> extends coco.ep.m5.Add<FT>, Exp<FT> {

    default Boolean equals(coco.ep.Exp<FT> other) {
        return convert(this).astree().equals(convert(other).astree());
    }
}
