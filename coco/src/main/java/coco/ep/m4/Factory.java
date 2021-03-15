package coco.ep.m4;

public interface Factory<FT> extends coco.ep.m3.Factory<FT> {

    public abstract Exp<FT> convert(coco.ep.Exp<FT> other);
}
