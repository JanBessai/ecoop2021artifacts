package coco.ep.m7;

public interface Exp<FT> extends coco.ep.m6.Exp<FT>, Factory<FT> {

    coco.ep.Exp<FT> powby(coco.ep.Exp<FT> other);
}
