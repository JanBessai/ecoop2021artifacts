package coco.ep.m5;

public interface Factory<FT> extends coco.ep.m4.Factory<FT> {

    public abstract Exp<FT> convert(coco.ep.Exp<FT> other);
}
