package coco.ep.m6;

public interface Exp<FT> extends coco.ep.m5.Exp<FT>, Factory<FT> {

    Boolean equals(coco.ep.Exp<FT> other);
}
