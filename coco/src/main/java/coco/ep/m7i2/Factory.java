package coco.ep.m7i2;

public interface Factory<FT> extends coco.ep.m7.Factory<FT>, coco.ep.i2.Factory<FT> {

    Exp<FT> convert(coco.ep.Exp<FT> other);
}
