package coco.ep.m6;

public interface Factory<FT> extends coco.ep.m5.Factory<FT> {

    Exp<FT> convert(coco.ep.Exp<FT> other);
}
