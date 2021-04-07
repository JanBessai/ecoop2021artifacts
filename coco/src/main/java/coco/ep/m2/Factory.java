package coco.ep.m2;

public interface Factory<FT> extends coco.ep.m1.Factory<FT> {

    Exp<FT> convert(coco.ep.Exp<FT> other);
}
