package coco.ep.m7i2;

public interface Factory<FT> extends coco.ep.m7.Factory<FT>, coco.ep.i2.Factory<FT> {

    public abstract Exp<FT> convert(coco.ep.Exp<FT> other);
}
