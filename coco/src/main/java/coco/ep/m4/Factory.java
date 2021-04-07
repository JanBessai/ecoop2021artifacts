package coco.ep.m4;

public interface Factory<FT> extends coco.ep.m3.Factory<FT> {

    Exp<FT> convert(coco.ep.Exp<FT> other);
}
