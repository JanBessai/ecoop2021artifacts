package coco.ep.m5;

public interface Factory<FT> extends coco.ep.m4.Factory<FT> {

    Exp<FT> convert(coco.ep.Exp<FT> other);
}
