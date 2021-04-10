package coco.ep.i1;

public interface Factory<FT> extends coco.ep.m2.Factory<FT> {

    Exp<FT> convert(coco.ep.Exp<FT> other);
}
