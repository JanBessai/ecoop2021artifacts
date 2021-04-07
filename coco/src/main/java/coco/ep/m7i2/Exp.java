package coco.ep.m7i2;

public interface Exp<FT> extends coco.ep.m7.Exp<FT>, coco.ep.i1.Exp<FT>, Factory<FT> {

    default Boolean isPower(coco.ep.Exp<FT> left, coco.ep.Exp<FT> right) { return false; }

}
