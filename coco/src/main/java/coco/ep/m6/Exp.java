package coco.ep.m6;

public interface Exp<FT> extends coco.ep.m5.Exp<FT>, Factory<FT> {

    public abstract Boolean equals(coco.ep.Exp<FT> other);
}
