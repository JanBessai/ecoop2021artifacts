package coco.ep.m0;

public interface Exp<FT> extends coco.ep.Exp<FT>, Factory<FT> {

    Double eval();
}
