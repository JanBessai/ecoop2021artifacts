package coco.ep.m7;

public interface Factory<FT> extends coco.ep.m6.Factory<FT> {

    Exp<FT> convert(coco.ep.Exp<FT> other);
}
