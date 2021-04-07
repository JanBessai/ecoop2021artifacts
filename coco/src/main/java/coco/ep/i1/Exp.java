package coco.ep.i1;

public interface Exp<FT> extends coco.ep.m2.Exp<FT>, Factory<FT> {

    coco.ep.Exp<FT> multby(coco.ep.Exp<FT> other);
}
